package net.lawliet.chrono_circuit.blockEntity.hopper.copperHopper;

import net.lawliet.chrono_circuit.blockEntity.hopper.AbstractHopperMenu;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;

public class CopperHopperMenu extends AbstractHopperMenu {
    protected static int CONTAINER_SIZE = 3;

    public CopperHopperMenu(int containerId, Inventory playerInventory) {
        super(containerId, playerInventory);
    }

    public CopperHopperMenu(int containerId, Inventory playerInventory, Container container) {
        super(containerId, playerInventory, container);
    }


    @Override
    protected void addHopperSlots(Container container, int containerSize) {
        for (int i = 0; i < CONTAINER_SIZE; i++) {
            this.addSlot(new Slot(container, i, 44 + i * 18, 20));
        }
    }
}
