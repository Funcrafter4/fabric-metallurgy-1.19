package net.metallurgy.metallurgymod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.metallurgy.metallurgymod.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class MetallurgyModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.IRON_SMELTER, RenderLayer.getCutout());

    }
}
