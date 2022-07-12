package net.metallurgy.metallurgymod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.metallurgy.metallurgymod.MetallurgyMod;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandler {
    public static ScreenHandlerType<IronSmelterScreenHandler> MYTHRIL_BLOCK_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(MetallurgyMod.MOD_ID,"iron_smelter"),
                    IronSmelterScreenHandler::new);
}
