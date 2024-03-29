package net.metallurgy.metallurgymod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.metallurgy.metallurgymod.MetallurgyMod;
import net.metallurgy.metallurgymod.block.custom.*;
import net.metallurgy.metallurgymod.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block TIN_ORE = registerBlock("tin_ore",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.METALLURGY_GROUP);

    public static final Block MANGANESE_ORE = registerBlock("manganese_ore",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.METALLURGY_GROUP);

    public static final Block ZINC_ORE = registerBlock("zinc_ore",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.METALLURGY_GROUP);

    public static final Block PLATINUM_ORE = registerBlock("platinum_ore",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.METALLURGY_GROUP);

    public static final Block SILVER_ORE = registerBlock("silver_ore",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.METALLURGY_GROUP);

    public static final Block STONE_SMELTER = registerBlock("stone_smelter",
            new StoneSmelterBlock(FabricBlockSettings.of(Material.METAL)), ModItemGroup.METALLURGY_GROUP);

    public static final Block IRON_SMELTER = registerBlock("iron_smelter",
            new IronSmelterBlock(FabricBlockSettings.of(Material.METAL)), ModItemGroup.METALLURGY_GROUP);

    public static final Block STEEL_SMELTER = registerBlock("steel_smelter",
            new TopSmelterBlock(FabricBlockSettings.of(Material.METAL)), ModItemGroup.METALLURGY_GROUP);
    public static final Block CRUSHER_BLOCK = registerBlock("crusher_block",
            new CrusherBlock(FabricBlockSettings.of(Material.METAL)), ModItemGroup.METALLURGY_GROUP);

    public static final Block COMPRESSOR_BLOCK = registerBlock("compressor_block",
            new CompressorBlock(FabricBlockSettings.of(Material.METAL)), ModItemGroup.METALLURGY_GROUP);

    public static final Block ZINC_BLOCK = registerBlock("zinc_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.METALLURGY_GROUP);

    public static final Block TIN_BLOCK = registerBlock("tin_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.METALLURGY_GROUP);

    public static final Block SILVER_BLOCK = registerBlock("silver_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.METALLURGY_GROUP);

    public static final Block PLATINUM_BLOCK = registerBlock("platinum_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.METALLURGY_GROUP);

    public static final Block MANGANESE_BLOCK = registerBlock("manganese_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.METALLURGY_GROUP);

    public static final Block ANGMALLEN_BLOCK = registerBlock("angmallen_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.METALLURGY_GROUP);

    public static final Block BRASS_BLOCK = registerBlock("brass_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.METALLURGY_GROUP);

    public static final Block BRONZE_BLOCK = registerBlock("bronze_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.METALLURGY_GROUP);

    public static final Block HEPATIZON_BLOCK = registerBlock("hepatizon_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.METALLURGY_GROUP);

    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.METALLURGY_GROUP);

    public static final Block DAMASCUS_STEEL_BLOCK = registerBlock("damascus_steel_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.METALLURGY_GROUP);

    public static final Block ELECTRUM_BLOCK = registerBlock("electrum_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.METALLURGY_GROUP);

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK,new Identifier(MetallurgyMod.MOD_ID, name),block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM,new Identifier(MetallurgyMod.MOD_ID,name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks(){
        MetallurgyMod.LOGGER.info("Registering ModBlocks for " + MetallurgyMod.MOD_ID );
    }
}
