package net.metallurgy.metallurgymod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.metallurgy.metallurgymod.MetallurgyMod;
import net.metallurgy.metallurgymod.item.custom.*;
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

    public static final Item BRASS_SWORD = registerItem("brass_sword", new ModSwordItem(ModToolMaterials.BRASS, 2, -2.4f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item BRASS_AXE = registerItem("brass_axe", new ModAxeItem(ModToolMaterials.BRASS, 7, -3.1f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item BRASS_PICKAXE = registerItem("brass_pickaxe", new ModPickaxeItem(ModToolMaterials.BRASS, -2, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item BRASS_SHOVEL = registerItem("brass_shovel", new ModShovelItem(ModToolMaterials.BRASS, -1, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item BRASS_HOE = registerItem("brass_hoe", new ModHoeItem(ModToolMaterials.BRASS, -3, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item HEPATIZON_SWORD = registerItem("hepatizon_sword", new ModSwordItem(ModToolMaterials.HEPATIZON, 2, -2.4f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item HEPATIZON_AXE = registerItem("hepatizon_axe", new ModAxeItem(ModToolMaterials.HEPATIZON, 7, -3.1f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item HEPATIZON_PICKAXE = registerItem("hepatizon_pickaxe", new ModPickaxeItem(ModToolMaterials.HEPATIZON, -2, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item HEPATIZON_SHOVEL = registerItem("hepatizon_shovel", new ModShovelItem(ModToolMaterials.HEPATIZON, -1, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item HEPATIZON_HOE = registerItem("hepatizon_hoe", new ModHoeItem(ModToolMaterials.HEPATIZON, -3, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item SILVER_SWORD = registerItem("silver_sword", new ModSwordItem(ModToolMaterials.SILVER, 2, -2.4f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item SILVER_AXE = registerItem("silver_axe", new ModAxeItem(ModToolMaterials.SILVER, 7, -3.1f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item SILVER_PICKAXE = registerItem("silver_pickaxe", new ModPickaxeItem(ModToolMaterials.SILVER, -2, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item SILVER_SHOVEL = registerItem("silver_shovel", new ModShovelItem(ModToolMaterials.SILVER, -1, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item SILVER_HOE = registerItem("silver_hoe", new ModHoeItem(ModToolMaterials.SILVER, -3, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item PLATINUM_SWORD = registerItem("platinum_sword", new ModSwordItem(ModToolMaterials.PLATINUM, 2, -2.4f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item PLATINUM_AXE = registerItem("platinum_axe", new ModAxeItem(ModToolMaterials.PLATINUM, 7, -3.1f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item PLATINUM_PICKAXE = registerItem("platinum_pickaxe", new ModPickaxeItem(ModToolMaterials.PLATINUM, -2, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item PLATINUM_SHOVEL = registerItem("platinum_shovel", new ModShovelItem(ModToolMaterials.PLATINUM, -1, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item PLATINUM_HOE = registerItem("platinum_hoe", new ModHoeItem(ModToolMaterials.PLATINUM, -3, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item ELECTRUM_SWORD = registerItem("electrum_sword", new ModSwordItem(ModToolMaterials.ELECTRUM, 2, -2.4f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item ELECTRUM_AXE = registerItem("electrum_axe", new ModAxeItem(ModToolMaterials.ELECTRUM, 7, -3.1f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item ELECTRUM_PICKAXE = registerItem("electrum_pickaxe", new ModPickaxeItem(ModToolMaterials.ELECTRUM, -2, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item ELECTRUM_SHOVEL = registerItem("electrum_shovel", new ModShovelItem(ModToolMaterials.ELECTRUM, -1, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item ELECTRUM_HOE = registerItem("electrum_hoe", new ModHoeItem(ModToolMaterials.ELECTRUM, -3, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item BRONZE_SWORD = registerItem("bronze_sword", new ModSwordItem(ModToolMaterials.BRONZE, 2, -2.4f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item BRONZE_AXE = registerItem("bronze_axe", new ModAxeItem(ModToolMaterials.BRONZE, 7, -3.1f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item BRONZE_PICKAXE = registerItem("bronze_pickaxe", new ModPickaxeItem(ModToolMaterials.BRONZE, -2, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item BRONZE_SHOVEL = registerItem("bronze_shovel", new ModShovelItem(ModToolMaterials.BRONZE, -1, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item BRONZE_HOE = registerItem("bronze_hoe", new ModHoeItem(ModToolMaterials.BRONZE, -3, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item ANGMALLEN_SWORD = registerItem("angmallen_sword", new ModSwordItem(ModToolMaterials.ANGMALLEN, 3, -2.4f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item ANGMALLEN_AXE = registerItem("angmallen_axe", new ModAxeItem(ModToolMaterials.ANGMALLEN, 8, -3.1f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item ANGMALLEN_PICKAXE = registerItem("angmallen_pickaxe", new ModPickaxeItem(ModToolMaterials.ANGMALLEN, -1, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item ANGMALLEN_SHOVEL = registerItem("angmallen_shovel", new ModShovelItem(ModToolMaterials.ANGMALLEN, 0, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item ANGMALLEN_HOE = registerItem("angmallen_hoe", new ModHoeItem(ModToolMaterials.ANGMALLEN, -2, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item DAMASCUS_STEEL_SWORD = registerItem("damascus_steel_sword", new ModSwordItem(ModToolMaterials.DAMASCUS_STEEL, 3, -2.4f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item DAMASCUS_STEEL_AXE = registerItem("damascus_steel_axe", new ModAxeItem(ModToolMaterials.DAMASCUS_STEEL, 8, -3.1f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item DAMASCUS_STEEL_PICKAXE = registerItem("damascus_steel_pickaxe", new ModPickaxeItem(ModToolMaterials.DAMASCUS_STEEL, -1, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item DAMASCUS_STEEL_SHOVEL = registerItem("damascus_steel_shovel", new ModShovelItem(ModToolMaterials.DAMASCUS_STEEL, 0, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item DAMASCUS_STEEL_HOE = registerItem("damascus_steel_hoe", new ModHoeItem(ModToolMaterials.DAMASCUS_STEEL, -2, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item STEEL_SWORD = registerItem("steel_sword", new ModSwordItem(ModToolMaterials.STEEL, 4, -2.4f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item STEEL_AXE = registerItem("steel_axe", new ModAxeItem(ModToolMaterials.STEEL, 9, -3.1f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item STEEL_PICKAXE = registerItem("steel_pickaxe", new ModPickaxeItem(ModToolMaterials.STEEL, 0, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item STEEL_SHOVEL = registerItem("steel_shovel", new ModShovelItem(ModToolMaterials.STEEL, 1, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item STEEL_HOE = registerItem("steel_hoe", new ModHoeItem(ModToolMaterials.STEEL, -1, -3f, new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  IRON_DUST = registerItem("iron_dust", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  GOLD_DUST = registerItem("gold_dust", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  COPPER_DUST = registerItem("copper_dust", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  TIN_DUST = registerItem("tin_dust", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  ZINC_DUST = registerItem("zinc_dust", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  SILVER_DUST = registerItem("silver_dust", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  PLATINUM_DUST = registerItem("platinum_dust", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  BRASS_DUST = registerItem("brass_dust", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  BRONZE_DUST = registerItem("bronze_dust", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  HEPATIZON_DUST = registerItem("hepatizon_dust", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  ANGMALLEN_DUST = registerItem("angmallen_dust", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  ELECTRUM_DUST = registerItem("electrum_dust", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  STEEL_DUST = registerItem("steel_dust", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  DAMASCUS_STEEL_DUST = registerItem("damascus_steel_dust", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  DIAMOND_DUST = registerItem("diamond_dust", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  COAL_DUST = registerItem("coal_dust", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  EMERALD_DUST = registerItem("emerald_dust", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    public static final Item  ANGMALLEN_PLATE = registerItem("angmallen_plate", new Item(new FabricItemSettings().group(ModItemGroup.METALLURGY_GROUP)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(MetallurgyMod.MOD_ID, name), item);
    }

    public static void registerModItems(){

        MetallurgyMod.LOGGER.debug("Register Mod Items");
    }
}
