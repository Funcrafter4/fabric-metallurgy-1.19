package net.metallurgy.metallurgymod.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.metallurgy.metallurgymod.MetallurgyMod;
import net.metallurgy.metallurgymod.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocksEntity {

    public static BlockEntityType<StoneSmelterEntity> STONE_SMELTER;
    public static BlockEntityType<IronSmelterEntity> IRON_SMELTER;

    public static BlockEntityType<CrusherBlockEntity> CRUSHER_BLOCK;

    public static BlockEntityType<CompressorBlockEntity> COMPRESSOR_BLOCK;

    public static void registerAllBlockEntities(){
        STONE_SMELTER = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(MetallurgyMod.MOD_ID,"stone_smelter"),
                FabricBlockEntityTypeBuilder.create(StoneSmelterEntity::new,
                        ModBlocks.STONE_SMELTER).build(null));

        IRON_SMELTER = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(MetallurgyMod.MOD_ID,"iron_smelter"),
                FabricBlockEntityTypeBuilder.create(IronSmelterEntity::new,
                        ModBlocks.IRON_SMELTER).build(null));

        CRUSHER_BLOCK = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(MetallurgyMod.MOD_ID,"crusher_block"),
                FabricBlockEntityTypeBuilder.create(CrusherBlockEntity::new,
                        ModBlocks.CRUSHER_BLOCK).build(null));

        COMPRESSOR_BLOCK = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(MetallurgyMod.MOD_ID,"compressor_block"),
                FabricBlockEntityTypeBuilder.create(CompressorBlockEntity::new,
                        ModBlocks.COMPRESSOR_BLOCK).build(null));
    }
}
