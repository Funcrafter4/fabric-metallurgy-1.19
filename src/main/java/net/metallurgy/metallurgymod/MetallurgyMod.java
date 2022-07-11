package net.metallurgy.metallurgymod;

import net.fabricmc.api.ModInitializer;
import net.metallurgy.metallurgymod.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetallurgyMod implements ModInitializer {

	public static final String MOD_ID = "metallurgymod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModBlocks.registerModBlocks();
	}
}
