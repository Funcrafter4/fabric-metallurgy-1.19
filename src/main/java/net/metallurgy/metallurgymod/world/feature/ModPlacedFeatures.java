package net.metallurgy.metallurgymod.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

public class ModPlacedFeatures {


    public static final RegistryEntry<PlacedFeature> TIN_ORE_PLACED = PlacedFeatures.register("tin_ore_placed",
            ModConfiguredFeatures.TIN_ORE, ModOreFeatures.modifiersWithCount(10,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(0), YOffset.aboveBottom(128))));

    public static final RegistryEntry<PlacedFeature> MANGANESE_ORE_PLACED = PlacedFeatures.register("manganese_ore_placed",
            ModConfiguredFeatures.MANGANESE_ORE, ModOreFeatures.modifiersWithCount(4,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(0), YOffset.aboveBottom(128))));

    public static final RegistryEntry<PlacedFeature> ZINC_ORE_PLACED = PlacedFeatures.register("zinc_ore_placed",
            ModConfiguredFeatures.ZINC_ORE, ModOreFeatures.modifiersWithCount(4,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(0), YOffset.aboveBottom(128))));

    public static final RegistryEntry<PlacedFeature> SILVER_ORE_PLACED = PlacedFeatures.register("silver_ore_placed",
            ModConfiguredFeatures.SILVER_ORE, ModOreFeatures.modifiersWithCount(5,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(0), YOffset.aboveBottom(128))));

    public static final RegistryEntry<PlacedFeature> PLATINUM_ORE_PLACED = PlacedFeatures.register("platinum_ore_placed",
            ModConfiguredFeatures.PLATINUM_ORE, ModOreFeatures.modifiersWithCount(3,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(0), YOffset.aboveBottom(128))));
}
