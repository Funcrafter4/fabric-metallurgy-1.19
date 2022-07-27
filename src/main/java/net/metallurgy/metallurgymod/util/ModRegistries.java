package net.metallurgy.metallurgymod.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.metallurgy.metallurgymod.MetallurgyMod;
import net.metallurgy.metallurgymod.item.ModItems;

public class ModRegistries {

    public static void registerModStuffs(){
        registerFuels();
    }

    private static void registerFuels(){
        MetallurgyMod.LOGGER.info("register fuels");
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.COMPRESSED_COAL, 3200);
    }
}
