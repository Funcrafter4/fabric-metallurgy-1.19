package net.metallurgy.metallurgymod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.metallurgy.metallurgymod.block.entity.ModBlocksEntity;
import net.metallurgy.metallurgymod.item.ModItems;
import net.metallurgy.metallurgymod.block.ModBlocks;
import net.metallurgy.metallurgymod.recipe.ModRecipes;
import net.metallurgy.metallurgymod.screen.*;
import net.metallurgy.metallurgymod.util.ModRegistries;
import net.metallurgy.metallurgymod.villager.ModVillagers;
import net.metallurgy.metallurgymod.world.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MetallurgyMod implements ModInitializer {

	public static final String MOD_ID = "metallurgymod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModBlocks.registerModBlocks();
        ModItems.registerModItems();
		ModWorldGen.generateModWorldGen();
		ModBlocksEntity.registerAllBlockEntities();
		ScreenRegistry.register(ModScreenHandler.STONE_SMELTER_SCREEN_HANDLER, StoneSmelterScreen::new);
		ScreenRegistry.register(ModScreenHandler.IRON_SMELTER_SCREEN_HANDLER, IronSmelterScreen::new);
		ScreenRegistry.register(ModScreenHandler.CRUSHER_BLOCK_SCREEN_HANDLER, CrusherBlockScreen::new);
		ScreenRegistry.register(ModScreenHandler.COMPRESSOR_BLOCK_SCREEN_HANDLER, CompressorBlockScreen::new);
		ModRecipes.registerRecipes();
		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();
		ModRegistries.registerModStuffs();
	}
}
