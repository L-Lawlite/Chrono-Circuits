package net.lawliet.chrono_circuits.blockEntity.hopper.copperHopper;

import net.lawliet.chrono_circuits.blockEntity.hopper.AbstractHopperMenu;
import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;

public class CopperHopperMenu extends AbstractHopperMenu {
    private static final int CONTAINER_ROW = 2;
    private static final int CONTAINER_COLUMN = 5;
    private static final int CONTAINER_SIZE = CONTAINER_ROW * CONTAINER_COLUMN;


    public CopperHopperMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, new SimpleContainer(CONTAINER_SIZE));
    }

    public CopperHopperMenu(int containerId, Inventory playerInventory, Container container) {
        super(ChronoBlockEntityTypes.COPPER_HOPPER_MENU.get(),containerId, playerInventory, container);
        this.addStandardInventorySlots(playerInventory, 8, 69);
    }


    @Override
    protected void addHopperSlots(Container container) {
        for (int i = 0; i < CONTAINER_ROW; i++) {
            for(int j = 0; j < CONTAINER_COLUMN; j++) {
                this.addSlot(new Slot(container, i * CONTAINER_COLUMN + j, 44 + j * 18, 20 + i * 18));

            }
        }
    }
}
