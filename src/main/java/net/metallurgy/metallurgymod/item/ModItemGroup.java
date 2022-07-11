package net.metallurgy.metallurgymod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.metallurgy.metallurgymod.MetallurgyMod;
import net.metallurgy.metallurgymod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup METALLURGY_BLOCK = FabricItemGroupBuilder.create(new Identifier(MetallurgyMod.MOD_ID, "Metallurgy Blocks"))
            .icon(() -> new ItemStack(ModBlocks.TIN_ORE)).build();
}
