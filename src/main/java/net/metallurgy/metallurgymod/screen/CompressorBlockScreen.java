package net.metallurgy.metallurgymod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.metallurgy.metallurgymod.MetallurgyMod;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CompressorBlockScreen extends HandledScreen<CompressorBlockScreenHandler> {
    private static final Identifier TEXTURE =
            new Identifier(MetallurgyMod.MOD_ID,"textures/gui/compressor_block_gui.png");

    public CompressorBlockScreen(CompressorBlockScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F,1.0F,1.0F,1.0F);
        RenderSystem.setShaderTexture(0,TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y,0,0, backgroundWidth, backgroundHeight);
        if(handler.isCrafting()) {
            drawTexture(matrices, x + 91, y + 36, 176, 14, handler.getScaledProgress(), 14);
        }

        if(handler.hasFuel()) {
            drawTexture(matrices, x + 48, y + 35 + 14 - handler.getScaledFuelProgress(), 176,
                    14 - handler.getScaledFuelProgress(), 14, handler.getScaledFuelProgress());
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices,mouseX,mouseY);
    }
}
