package net.metallurgy.metallurgymod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.metallurgy.metallurgymod.MetallurgyMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup METALLURGY_GROUP = FabricItemGroupBuilder.create(new Identifier(MetallurgyMod.MOD_ID, "metallurgy_group"))
            .icon(() -> new ItemStack(ModItems.TIN_INGOT)).build();
}
