package net.metallurgy.metallurgymod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.metallurgy.metallurgymod.MetallurgyMod;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandler {
    public static ScreenHandlerType<StoneSmelterScreenHandler> STONE_SMELTER_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(MetallurgyMod.MOD_ID,"stone_smelter"),
                    StoneSmelterScreenHandler::new);

    public static ScreenHandlerType<IronSmelterScreenHandler> IRON_SMELTER_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(MetallurgyMod.MOD_ID,"iron_smelter"),
                    IronSmelterScreenHandler::new);

    public static ScreenHandlerType<CrusherBlockScreenHandler> CRUSHER_BLOCK_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(MetallurgyMod.MOD_ID,"crusher_block"),
                    CrusherBlockScreenHandler::new);
}
