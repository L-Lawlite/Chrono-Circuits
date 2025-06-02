package net.lawliet.chrono_circuits.blockEntity.hopper.pipe;

import net.lawliet.chrono_circuits.blockEntity.hopper.AbstractHopperMenu;
import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;

public class PipeMenu extends AbstractHopperMenu {
    private static final int CONTAINER_SIZE = 1;

    public PipeMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, new SimpleContainer(CONTAINER_SIZE));
    }

    public PipeMenu(int containerId, Inventory playerInventory, Container container) {
        super(ChronoBlockEntityTypes.PIPE_MENU.get(),containerId, playerInventory, container);
    }


    @Override
    protected void addHopperSlots(Container container) {
        this.addSlot(new Slot(container, 0, 44, 20));
    }
}
