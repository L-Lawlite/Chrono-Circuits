package net.lawliet.chrono_circuits.blockEntity.hopper.goldHopper;

import net.lawliet.chrono_circuits.blockEntity.hopper.AbstractHopperMenu;
import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;

public class GoldHopperMenu extends AbstractHopperMenu {
    private static final int CONTAINER_SIZE = 2;

    public GoldHopperMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, new SimpleContainer(CONTAINER_SIZE));
    }

    public GoldHopperMenu(int containerId, Inventory playerInventory, Container container) {
        super(ChronoBlockEntityTypes.GOLD_HOPPER_MENU.get(),containerId, playerInventory, container);
    }


    @Override
    protected void addHopperSlots(Container container) {
        for (int i = 0; i < CONTAINER_SIZE; i++) {
            this.addSlot(new Slot(container, i, 44 + i * 18, 20));
        }

    }
}
