package net.metallurgy.metallurgymod.block.entity;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.metallurgy.metallurgymod.item.inventory.ImplementedInventory;
import net.metallurgy.metallurgymod.recipe.IronSmelterRecipe;
import net.metallurgy.metallurgymod.screen.IronSmelterScreenHandler;
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

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class TopSmelterEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(4,ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private static int maxProgress = 72;
    private int fuelTime = 0;
    private int maxFuelTime = 0;
    private static Identifier matchedId;
    public TopSmelterEntity(BlockPos pos, BlockState state) {
        super(ModBlocksEntity.IRON_SMELTER, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0:
                        return TopSmelterEntity.this.progress;
                    case 1:
                        return TopSmelterEntity.this.maxProgress;
                    case 2:
                        return TopSmelterEntity.this.fuelTime;
                    case 3:
                        return TopSmelterEntity.this.maxFuelTime;
                    default:
                        return 0;
                }
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        TopSmelterEntity.this.progress = value;
                        break;
                    case 1:
                        TopSmelterEntity.this.maxProgress = value;
                        break;
                    case 2:
                        TopSmelterEntity.this.fuelTime = value;
                        break;
                    case 3:
                        TopSmelterEntity.this.maxFuelTime = value;
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
        return Text.of("Steel smelter");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new IronSmelterScreenHandler(syncId,inv,this,this.propertyDelegate);
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

    public static void tick(World world, BlockPos pos, BlockState state, TopSmelterEntity entity) {
        if(isConsumingFuel(entity)) {
            entity.fuelTime-=2;
        }

        if(hasRecipe(entity)) {
            if(hasFuelInFuelSlot(entity) && !isConsumingFuel(entity)) {
                entity.consumeFuel();
            }
            if(isConsumingFuel(entity)) {
                entity.progress+=2;
                if(entity.progress > entity.maxProgress) {
                    craftItem(entity);
                }
            }
        } else {
            entity.resetProgress();
        }
    }

    private static boolean hasFuelInFuelSlot(TopSmelterEntity entity) {
        return !entity.getStack(0).isEmpty();
    }

    private static boolean isConsumingFuel(TopSmelterEntity entity) {
        return entity.fuelTime > 0;
    }

    private static boolean hasRecipe(TopSmelterEntity entity) {
        World world = entity.world;

        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 1; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<IronSmelterRecipe> match = world.getRecipeManager()
                .getFirstMatch(IronSmelterRecipe.Type.INSTANCE, inventory, world);

        if(match.isPresent()){
            if(matchedId != match.get().getId()){
                setMaxProgress(match);
                matchedId = match.get().getId();
            }
        }

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    private static void setMaxProgress(Optional<IronSmelterRecipe> match){
        try {
            String file = readFileFromResources(makeFileName(String.valueOf(match.get().getId())));
            JsonParser parser = new JsonParser();
            JsonObject obj = (JsonObject) parser.parse(file);
            JsonObject jsonObject = (JsonObject) obj.get("output");
            maxProgress = Integer.parseInt(String.valueOf(jsonObject.get("amount")));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String makeFileName(String id){
        StringBuilder builder = new StringBuilder("data/metallurgymod/recipes/");
        builder.append(id.split(":")[1]);
        builder.append(".json");
        return builder.toString();
    }

    private static String readFileFromResources(String filename) throws URISyntaxException, IOException {
        URL resource = TopSmelterEntity.class.getClassLoader().getResource(filename);
        byte[] bytes = Files.readAllBytes(Paths.get(resource.toURI()));
        return new String(bytes);
    }

    private static void craftItem(TopSmelterEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<IronSmelterRecipe> match = world.getRecipeManager()
                .getFirstMatch(IronSmelterRecipe.Type.INSTANCE, inventory, world);

        if(match.isPresent()) {
            entity.removeStack(1,1);
            entity.removeStack(2,1);
            entity.setStack(3, new ItemStack(match.get().getOutput().getItem(),
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
