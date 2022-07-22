package net.metallurgy.metallurgymod.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.metallurgy.metallurgymod.MetallurgyMod;
import net.metallurgy.metallurgymod.block.ModBlocks;
import net.metallurgy.metallurgymod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final PointOfInterestType SMETLER_POI = registerPOI("smelter_poi", ModBlocks.IRON_SMELTER);
    public static final VillagerProfession METALLURGIST = registerProfession("metallurgist", RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(MetallurgyMod.MOD_ID, "smelter_poi")));


    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type){
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(MetallurgyMod.MOD_ID, name), VillagerProfessionBuilder.create().id(new Identifier(MetallurgyMod.MOD_ID, name)).workstation(type).workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).build());
    }

    public static PointOfInterestType registerPOI(String name, Block block){
        return PointOfInterestHelper.register(new Identifier(MetallurgyMod.MOD_ID, name), 1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }

    public static void registerVillagers(){
        MetallurgyMod.LOGGER.debug("Register Villagers");
    }

    public static void registerTrades(){
        TradeOfferHelper.registerVillagerOffers(METALLURGIST, 1, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(ModItems.BRASS_INGOT, 6),
                    4, 2, 0.02f
            )));
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.TIN_INGOT, 8),
                    new ItemStack(Items.EMERALD, 1),
                    8, 2, 0.02f
            )));
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.ZINC_INGOT, 3),
                    4, 2, 0.02f
            )));
        });
        TradeOfferHelper.registerVillagerOffers(METALLURGIST, 2, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(ModItems.ANGMALLEN_INGOT, 2),
                    4, 2, 0.02f
            )));
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.BRONZE_DUST, 1),
                    4, 2, 0.02f
            )));
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(ModItems.BRASS_AXE, 1),
                    4, 2, 0.02f
            )));
        });
        TradeOfferHelper.registerVillagerOffers(METALLURGIST, 3, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.ELECTRUM_DUST, 1),
                    4, 2, 0.02f
            )));
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ModItems.SILVER_DUST, 2),
                    4, 2, 0.02f
            )));
        });
        TradeOfferHelper.registerVillagerOffers(METALLURGIST, 4, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(ModItems.ELECTRUM_INGOT, 2),
                    4, 2, 0.02f
            )));
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(ModItems.PLATINUM_DUST, 1),
                    4, 2, 0.02f
            )));
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(ModItems.STEEL_INGOT, 2),
                    4, 2, 0.02f
            )));
        });
        TradeOfferHelper.registerVillagerOffers(METALLURGIST, 5, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModItems.DAMASCUS_STEEL_DUST, 2),
                    4, 2, 0.02f
            )));
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 19),
                    new ItemStack(ModItems.DAMASCUS_STEEL_PICKAXE, 1),
                    4, 2, 0.02f
            )));

        });
    }
}
