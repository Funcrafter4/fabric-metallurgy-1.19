package net.metallurgy.metallurgymod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.metallurgy.metallurgymod.block.entity.ModBlocksEntity;
import net.metallurgy.metallurgymod.item.ModItems;
import net.metallurgy.metallurgymod.block.ModBlocks;
import net.metallurgy.metallurgymod.recipe.ModRecipes;
import net.metallurgy.metallurgymod.screen.IronSmelterScreen;
import net.metallurgy.metallurgymod.screen.ModScreenHandler;
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
		ScreenRegistry.register(ModScreenHandler.MYTHRIL_BLOCK_SCREEN_HANDLER, IronSmelterScreen::new);
		ModRecipes.registerRecipes();
	}
}
