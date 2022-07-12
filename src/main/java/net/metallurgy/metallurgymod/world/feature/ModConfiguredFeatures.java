package net.metallurgy.metallurgymod.world.feature;

import net.metallurgy.metallurgymod.MetallurgyMod;
import net.metallurgy.metallurgymod.block.ModBlocks;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {

    public static final List<OreFeatureConfig.Target> OVERWORLD_TIN_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.TIN_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> TIN_ORE =
            ConfiguredFeatures.register("tin_ore", Feature.ORE,
                    new OreFeatureConfig(OVERWORLD_TIN_ORES, 6));

    public static final List<OreFeatureConfig.Target> OVERWORLD_MANGANESE_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.MANGANESE_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> MANGANESE_ORE =
            ConfiguredFeatures.register("manganese_ore", Feature.ORE,
                    new OreFeatureConfig(OVERWORLD_MANGANESE_ORES, 4));

    public static final List<OreFeatureConfig.Target> OVERWORLD_ZINC_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.ZINC_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ZINC_ORE =
            ConfiguredFeatures.register("zinc_ore", Feature.ORE,
                    new OreFeatureConfig(OVERWORLD_ZINC_ORES, 6));
    public static final List<OreFeatureConfig.Target> OVERWORLD_SILVER_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.SILVER_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SILVER_ORE =
            ConfiguredFeatures.register("silver_ore", Feature.ORE,
                    new OreFeatureConfig(OVERWORLD_SILVER_ORES, 5));

    public static final List<OreFeatureConfig.Target> OVERWORLD_PLATINUM_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.PLATINUM_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> PLATINUM_ORE =
            ConfiguredFeatures.register("platinum_ore", Feature.ORE,
                    new OreFeatureConfig(OVERWORLD_PLATINUM_ORES, 3));

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + MetallurgyMod.MOD_ID);
    }
}
