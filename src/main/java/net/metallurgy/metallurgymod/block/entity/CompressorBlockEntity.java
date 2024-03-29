package net.metallurgy.metallurgymod.block.entity;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.metallurgy.metallurgymod.item.inventory.ImplementedInventory;
import net.metallurgy.metallurgymod.recipe.CompressorBlockRecipe;
import net.metallurgy.metallurgymod.screen.CompressorBlockScreenHandler;
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
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CompressorBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(3,ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private static int maxProgress = 72;
    private int fuelTime = 0;
    private int maxFuelTime = 0;
    public CompressorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocksEntity.COMPRESSOR_BLOCK, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0:
                        return CompressorBlockEntity.this.progress;
                    case 1:
                        return CompressorBlockEntity.this.maxProgress;
                    case 2:
                        return CompressorBlockEntity.this.fuelTime;
                    case 3:
                        return CompressorBlockEntity.this.maxFuelTime;
                    default:
                        return 0;
                }
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        CompressorBlockEntity.this.progress = value;
                        break;
                    case 1:
                        CompressorBlockEntity.this.maxProgress = value;
                        break;
                    case 2:
                        CompressorBlockEntity.this.fuelTime = value;
                        break;
                    case 3:
                        CompressorBlockEntity.this.maxFuelTime = value;
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
        return Text.of("Compressor block");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new CompressorBlockScreenHandler(syncId,inv,this,this.propertyDelegate);
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

    public static void tick(World world, BlockPos pos, BlockState state, CompressorBlockEntity entity) {
        if(isConsumingFuel(entity)) {
            entity.fuelTime--;
        }

        if(hasRecipe(entity)) {
            if(hasFuelInFuelSlot(entity) && !isConsumingFuel(entity)) {
                entity.consumeFuel();
            }
            if(isConsumingFuel(entity)) {
                entity.progress++;
                if(entity.progress > entity.maxProgress) {
                    craftItem(entity);
                }
            }
        } else {
            entity.resetProgress();
        }
    }

    private static boolean hasFuelInFuelSlot(CompressorBlockEntity entity) {
        return !entity.getStack(0).isEmpty();
    }

    private static boolean isConsumingFuel(CompressorBlockEntity entity) {
        return entity.fuelTime > 0;
    }

    private static boolean hasRecipe(CompressorBlockEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<CompressorBlockRecipe> match = world.getRecipeManager()
                .getFirstMatch(CompressorBlockRecipe.Type.INSTANCE, inventory, world);



        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    private static void craftItem(CompressorBlockEntity entity) {


        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<CompressorBlockRecipe> match = world.getRecipeManager()
                .getFirstMatch(CompressorBlockRecipe.Type.INSTANCE, inventory, world);

        if(match.isPresent()) {
            entity.removeStack(1,1);

            entity.setStack(2, new ItemStack(match.get().getOutput().getItem(),
                    entity.getStack(2).getCount() + match.get().getOutput().getCount()));

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
        return inventory.getStack(2).getMaxCount() > inventory.getStack(2).getCount();
    }
}
