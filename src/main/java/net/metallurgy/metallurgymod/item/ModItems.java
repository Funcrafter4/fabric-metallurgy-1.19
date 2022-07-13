package net.metallurgy.metallurgymod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.metallurgy.metallurgymod.MetallurgyMod;
import net.metallurgy.metallurgymod.item.custom.ModPickaxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item RAW_TIN_ORE = registerItem("raw_tin_ore", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  MANGANESE_DUST = registerItem("manganese_dust", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  MANGANESE_INGOT = registerItem("manganese_ingot", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item RAW_SILVER_ORE = registerItem("raw_silver_ore", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  SILVER_INGOT = registerItem("silver_ingot", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item RAW_ZINC_ORE = registerItem("raw_zinc_ore", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  ZINC_INGOT = registerItem("zinc_ingot", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item RAW_PLATINUM_ORE = registerItem("raw_platinum_ore", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  PLATINUM_INGOT = registerItem("platinum_ingot", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  ANGMALLEN_INGOT = registerItem("angmallen_ingot", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  BRONZE_INGOT = registerItem("bronze_ingot", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  DAMASCUS_STEEL_INGOT = registerItem("damascus_steel_ingot", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  STEEL_INGOT = registerItem("steel_ingot", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  HEPATIZON_INGOT = registerItem("hepatizon_ingot", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  ELECTRUM_INGOT = registerItem("electrum_ingot", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  BRASS_INGOT = registerItem("brass_ingot", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(MetallurgyMod.MOD_ID, name), item);
    }

    public static void registerModItems(){

        MetallurgyMod.LOGGER.debug("Register Mod Items");
    }
}
