package net.lawliet.chrono_circuits.blockEntity.hopper.goldHopper;

import net.lawliet.chrono_circuits.ChronoCircuits;
import net.lawliet.chrono_circuits.blockEntity.hopper.AbstractHopperMenu;
import net.lawliet.chrono_circuits.blockEntity.hopper.AbstractHopperScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class GoldHopperScreen extends AbstractHopperScreen {
    public GoldHopperScreen(AbstractHopperMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.GUI_TEXTURE = ResourceLocation.fromNamespaceAndPath(ChronoCircuits.MODID,"textures/gui/container/gold_hopper.png");
    }
}
