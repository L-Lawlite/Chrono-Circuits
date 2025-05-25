package net.lawliet.chrono_circuit.blockEntity.hopper;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public abstract class AbstractHopperMenu extends AbstractContainerMenu {
    protected static int CONTAINER_SIZE = 0;
    protected final Container hopper;

    public AbstractHopperMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, new SimpleContainer(CONTAINER_SIZE));
    }

    public AbstractHopperMenu(int containerId, Inventory playerInventory, Container container) {
        super(MenuType.HOPPER, containerId);
        this.hopper = container;
        checkContainerSize(container, CONTAINER_SIZE);
        container.startOpen(playerInventory.player);

        this.addHopperSlots(container,CONTAINER_SIZE);
        this.addStandardInventorySlots(playerInventory, 8, 51);
    }

    protected abstract void addHopperSlots(Container container, int containerSize);

    /**
     * Determines whether supplied player can use this container
     */
    @Override
    public boolean stillValid(Player player) {
        return this.hopper.stillValid(player);
    }

    /**
     * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player inventory and the other inventory(s).
     */
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < this.hopper.getContainerSize()) {
                if (!this.moveItemStackTo(itemstack1, this.hopper.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, this.hopper.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    /**
     * Called when the container is closed.
     */
    @Override
    public void removed(Player player) {
        super.removed(player);
        this.hopper.stopOpen(player);
    }
}
