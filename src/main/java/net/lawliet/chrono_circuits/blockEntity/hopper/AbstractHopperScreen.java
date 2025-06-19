package net.lawliet.chrono_circuits.blockEntity.hopper;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public abstract class AbstractHopperScreen extends AbstractContainerScreen<AbstractHopperMenu> {
    public ResourceLocation GUI_TEXTURE;
    public AbstractHopperScreen(AbstractHopperMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int x, int y, float v) {
        super.render(guiGraphics, x, y, v);
        this.renderTooltip(guiGraphics, x, y);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(RenderPipelines.GUI_TEXTURED,GUI_TEXTURE,x,y,0.0F,0.0F,imageWidth,imageHeight,256,256);

    }
}
