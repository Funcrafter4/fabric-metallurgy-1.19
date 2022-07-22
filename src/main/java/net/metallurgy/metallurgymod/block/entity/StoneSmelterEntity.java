package net.metallurgy.metallurgymod.block.entity;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.metallurgy.metallurgymod.item.inventory.ImplementedInventory;
import net.metallurgy.metallurgymod.recipe.IronSmelterRecipe;
import net.metallurgy.metallurgymod.recipe.StoneSmelterRecipe;
import net.metallurgy.metallurgymod.screen.StoneSmelterScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Overwrite;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class StoneSmelterEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(4,ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private static int maxProgress = 72;
    private int fuelTime = 0;
    private int maxFuelTime = 0;
    private static Identifier matchedId;
    private static double countProg = 0;
    public StoneSmelterEntity(BlockPos pos, BlockState state) {
        super(ModBlocksEntity.STONE_SMELTER, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0:
                        return StoneSmelterEntity.this.progress;
                    case 1:
                        return StoneSmelterEntity.this.maxProgress;
                    case 2:
                        return StoneSmelterEntity.this.fuelTime;
                    case 3:
                        return StoneSmelterEntity.this.maxFuelTime;
                    default:
                        return 0;
                }
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        StoneSmelterEntity.this.progress = value;
                        break;
                    case 1:
                        StoneSmelterEntity.this.maxProgress = value;
                        break;
                    case 2:
                        StoneSmelterEntity.this.fuelTime = value;
                        break;
                    case 3:
                        StoneSmelterEntity.this.maxFuelTime = value;
                        break;
                }
            }

            @Override
            public int size() {
                return 4;
            }

        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.of("Stone smelter");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new StoneSmelterScreenHandler(syncId,inv,this,this.propertyDelegate);
    }
    @Override
    protected void writeNbt(NbtCompound nbt){
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("block.progress", progress);
        nbt.putInt("block.fuelTime", fuelTime);
        nbt.putInt("block.maxFuelTime", maxFuelTime);
    }
    @Override
    public void readNbt(NbtCompound nbt){
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("block.progress");
        fuelTime = nbt.getInt("block.fuelTime");
        maxFuelTime = nbt.getInt("block.maxFuelTime");
    }

    private void consumeFuel() {
        if(!getStack(0).isEmpty()) {
            this.fuelTime = FuelRegistry.INSTANCE.get(this.removeStack(0, 1).getItem());
            this.maxFuelTime = this.fuelTime;
        }
    }

    public static void tick(World world, BlockPos pos, BlockState state, StoneSmelterEntity entity) {
        if(isConsumingFuel(entity)) {
            entity.fuelTime--;
        }

        if(hasRecipe(entity)) {
            if(hasFuelInFuelSlot(entity) && !isConsumingFuel(entity)) {
                entity.consumeFuel();
            }
            if(isConsumingFuel(entity)) {
                countProg+=0.5;
                if(countProg % 1 == 0.5){
                    entity.progress++;
                }
                if(entity.progress > entity.maxProgress) {
                    craftItem(entity);
                }
            }
        } else {
            entity.resetProgress();
        }
    }

    private static boolean hasFuelInFuelSlot(StoneSmelterEntity entity) {
        return !entity.getStack(0).isEmpty();
    }

    private static boolean isConsumingFuel(StoneSmelterEntity entity) {
        return entity.fuelTime > 0;
    }

    private static boolean hasRecipe(StoneSmelterEntity entity) {
        World world = entity.world;

        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 1; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<StoneSmelterRecipe> match = world.getRecipeManager()
                .getFirstMatch(StoneSmelterRecipe.Type.INSTANCE, inventory, world);

        Optional<IronSmelterRecipe> secondMatch = world.getRecipeManager()
                .getFirstMatch(IronSmelterRecipe.Type.INSTANCE,inventory,world);

        if(match.isPresent()){
            if(matchedId != match.get().getId()){
                try {
                    setMaxProgress(readFileFromResources(makeFileName(String.valueOf(match.get().getId()))));
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                matchedId = match.get().getId();
            }
        }

        if(secondMatch.isPresent()){
            if(matchedId != secondMatch.get().getId()){
                try {
                    setMaxProgress(readFileFromResources(makeFileName(String.valueOf(secondMatch.get().getId()))));
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                matchedId = secondMatch.get().getId();
            }
        }
        if (secondMatch.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, secondMatch.get().getOutput())){
            return true;
        }
        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    private static void setMaxProgress(String file){
        JsonParser parser = new JsonParser();
        JsonObject obj = (JsonObject) parser.parse(file);
        JsonObject jsonObject = (JsonObject) obj.get("output");
        maxProgress = Integer.parseInt(String.valueOf(jsonObject.get("amount")));
    }

    private static String makeFileName(String id){
        StringBuilder builder = new StringBuilder("data/metallurgymod/recipes/");
        builder.append(id.split(":")[1]);
        builder.append(".json");
        return builder.toString();
    }

    private static String readFileFromResources(String filename) throws URISyntaxException, IOException {
        URL resource = StoneSmelterEntity.class.getClassLoader().getResource(filename);
        byte[] bytes = Files.readAllBytes(Paths.get(resource.toURI()));
        return new String(bytes);
    }

    private static void craftItem(StoneSmelterEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<StoneSmelterRecipe> match = world.getRecipeManager()
                .getFirstMatch(StoneSmelterRecipe.Type.INSTANCE, inventory, world);

        Optional<IronSmelterRecipe> secondMatch = world.getRecipeManager()
                .getFirstMatch(IronSmelterRecipe.Type.INSTANCE,inventory,world);


        if(match.isPresent()) {
            entity.removeStack(1,1);
            entity.removeStack(2,1);
            entity.setStack(3, new ItemStack(match.get().getOutput().getItem(),
                    entity.getStack(3).getCount() + 1));

            entity.resetProgress();
        }
        if(secondMatch.isPresent()) {
            entity.removeStack(1,1);
            entity.removeStack(2,1);
            entity.setStack(3, new ItemStack(secondMatch.get().getOutput().getItem(),
                    entity.getStack(3).getCount() + 1));

            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, ItemStack output) {
        return inventory.getStack(3).getItem() == output.getItem() || inventory.getStack(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(3).getMaxCount() > inventory.getStack(3).getCount();
    }
}
