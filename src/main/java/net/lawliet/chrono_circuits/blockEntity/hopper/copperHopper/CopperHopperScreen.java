package net.lawliet.chrono_circuits.blockEntity.hopper.copperHopper;

import net.lawliet.chrono_circuits.ChronoCircuits;
import net.lawliet.chrono_circuits.blockEntity.hopper.AbstractHopperMenu;
import net.lawliet.chrono_circuits.blockEntity.hopper.AbstractHopperScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopperHopperScreen extends AbstractHopperScreen {
    private static final Logger log = LoggerFactory.getLogger(CopperHopperScreen.class);

    public CopperHopperScreen(AbstractHopperMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.GUI_TEXTURE = ResourceLocation.fromNamespaceAndPath(ChronoCircuits.MODID,"textures/gui/container/copper_hopper.png");
        this.imageHeight = 150;
        this.inventoryLabelY = this.imageHeight - 92;
    }
}
