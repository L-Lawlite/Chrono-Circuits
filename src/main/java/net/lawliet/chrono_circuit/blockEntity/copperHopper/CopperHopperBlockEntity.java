//package net.lawliet.chrono_circuit.blockEntity.copperHopper;
//
//import net.lawliet.chrono_circuit.registration.ChronoBlockEntityTypes;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.core.NonNullList;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.Container;
//import net.minecraft.world.WorldlyContainer;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.HopperBlock;
//import net.minecraft.world.level.block.entity.HopperBlockEntity;
//import net.minecraft.world.level.block.state.BlockState;
//import net.neoforged.neoforge.items.ContainerOrHandler;
//import net.neoforged.neoforge.items.VanillaInventoryCodeHooks;
//
//import javax.annotation.Nullable;
//import java.util.function.BooleanSupplier;
//
//public class CopperHopperBlockEntity extends HopperBlockEntity {
//    public static final int MOVE_ITEM_SPEED = 2;
//    public static final int HOPPER_CONTAINER_SIZE = 2;
//    private static final int[][] CACHED_SLOTS = new int[54][];
//    private NonNullList<ItemStack> items;
//    private int cooldownTime;
//    private long tickedGameTime;
//    private Direction facing;
//
//    public CopperHopperBlockEntity(BlockPos pos, BlockState blockState) {
//        super(pos, blockState);
//        this.items = NonNullList.withSize(HOPPER_CONTAINER_SIZE, ItemStack.EMPTY);
//        this.cooldownTime = -1;
//        this.facing = blockState.getValue(CopperHopperBlock.FACING);
//    }
//
//    @Override
//    protected Component getDefaultName() {
//        return Component.translatable("container.copper_hopper");
//    }
//
//
//    private static boolean tryMoveItems(Level level, BlockPos pos, BlockState state, CopperHopperBlockEntity blockEntity, BooleanSupplier validator) {
//        if (level.isClientSide) {
//            return false;
//        } else {
//            if (!blockEntity.isOnCooldown() && state.getValue(HopperBlock.ENABLED)) {
//                boolean flag = false;
//                if (!blockEntity.isEmpty()) {
//                    flag = ejectItems(level, pos, blockEntity);
//                }
//
//                if (!blockEntity.inventoryFull()) {
//                    flag |= validator.getAsBoolean();
//                }
//
//                if (flag) {
//                    blockEntity.setCooldown(MOVE_ITEM_SPEED);
//                    setChanged(level, pos, state);
//                    return true;
//                }
//            }
//
//            return false;
//        }
//    }
//
//    private boolean inventoryFull() {
//        for(ItemStack itemstack : this.items) {
//            if (itemstack.isEmpty() || itemstack.getCount() != itemstack.getMaxStackSize()) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    private boolean isOnCooldown() {
//        return this.cooldownTime > 0;
//    }
//
//    private static boolean ejectItems(Level level, BlockPos pos, CopperHopperBlockEntity blockEntity) {
//        ContainerOrHandler containerOrHandler = getContainerOrHandlerAt(level, pos.relative(blockEntity.facing), blockEntity.facing.getOpposite());
//        if (containerOrHandler.isEmpty()) {
//            return false;
//        } else if (containerOrHandler.container() != null) {
//            Container container = containerOrHandler.container();
//            Direction direction = blockEntity.facing.getOpposite();
//            if (isFullContainer(container, direction)) {
//                return false;
//            } else {
//                for(int i = 0; i < blockEntity.getContainerSize(); ++i) {
//                    ItemStack itemstack = blockEntity.getItem(i);
//                    if (!itemstack.isEmpty()) {
//                        int j = itemstack.getCount();
//                        ItemStack itemstack1 = addItem(blockEntity, container, blockEntity.removeItem(i, 1), direction);
//                        if (itemstack1.isEmpty()) {
//                            container.setChanged();
//                            return true;
//                        }
//
//                        itemstack.setCount(j);
//                        if (j == 1) {
//                            blockEntity.setItem(i, itemstack);
//                        }
//                    }
//                }
//
//                return false;
//            }
//        } else {
//            return VanillaInventoryCodeHooks.insertHook(blockEntity, containerOrHandler.itemHandler());
//        }
//    }
//
//    private static boolean isFullContainer(Container container, Direction direction) {
//        int[] aint = getSlots(container, direction);
//
//        for(int i : aint) {
//            ItemStack itemstack = container.getItem(i);
//            if (itemstack.getCount() < itemstack.getMaxStackSize()) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    private static int[] getSlots(Container container, Direction direction) {
//        if (container instanceof WorldlyContainer worldlycontainer) {
//            return worldlycontainer.getSlotsForFace(direction);
//        } else {
//            int i = container.getContainerSize();
//            if (i < CACHED_SLOTS.length) {
//                int[] aint = CACHED_SLOTS[i];
//                if (aint != null) {
//                    return aint;
//                } else {
//                    int[] aint1 = createFlatSlots(i);
//                    CACHED_SLOTS[i] = aint1;
//                    return aint1;
//                }
//            } else {
//                return createFlatSlots(i);
//            }
//        }
//    }
//
//    private static int[] createFlatSlots(int size) {
//        int[] aint = new int[size];
//
//        for(int i = 0; i < aint.length; aint[i] = i++);
//
//        return aint;
//    }
//
//    private static boolean canPlaceItemInContainer(Container container, ItemStack stack, int slot, @Nullable Direction direction) {
//        if (!container.canPlaceItem(slot, stack)) {
//            return false;
//        }
//
//        if (container instanceof WorldlyContainer worldlycontainer) {
//            return worldlycontainer.canPlaceItemThroughFace(slot, stack, direction);
//        }
//
//        return true;
//    }
//
//    private static boolean canTakeItemFromContainer(Container source, Container destination, ItemStack stack, int slot, Direction direction) {
//        if (!destination.canTakeItem(source, slot, stack)) {
//            return false;
//        }
//        if (destination instanceof WorldlyContainer worldlycontainer) {
//            return worldlycontainer.canTakeItemThroughFace(slot, stack, direction);
//        }
//
//        return true;
//    }
//
//    private static ItemStack tryMoveInItem(@Nullable Container source, Container destination, ItemStack stack, int slot, @Nullable Direction direction) {
//        ItemStack itemstack = destination.getItem(slot);
//        if (canPlaceItemInContainer(destination, stack, slot, direction)) {
//            boolean flag = false;
//            boolean flag1 = destination.isEmpty();
//            if (itemstack.isEmpty()) {
//                destination.setItem(slot, stack);
//                stack = ItemStack.EMPTY;
//                flag = true;
//            } else if (canMergeItems(itemstack, stack)) {
//                int i = stack.getMaxStackSize() - itemstack.getCount();
//                int j = Math.min(stack.getCount(), i);
//                stack.shrink(j);
//                itemstack.grow(j);
//                flag = j > 0;
//            }
//
//            if (flag) {
//                if (flag1 && destination instanceof CopperHopperBlockEntity copperHopperBlockEntity1 ) {
//                    if (!copperHopperBlockEntity1.isOnCustomCooldown()) {
//                        int k = 0;
//                        if (source instanceof CopperHopperBlockEntity copperHopperBlockEntity) {
//                            if (copperHopperBlockEntity1.tickedGameTime >= copperHopperBlockEntity.tickedGameTime) {
//                                k = 1;
//                            }
//                        }
//
//                        copperHopperBlockEntity1.setCooldown(MOVE_ITEM_SPEED - k);
//                    }
//                }
//
//                destination.setChanged();
//            }
//        }
//
//        return stack;
//    }
//
//    private static boolean canMergeItems(ItemStack stack1, ItemStack stack2) {
//        return stack1.getCount() <= stack1.getMaxStackSize() && ItemStack.isSameItemSameComponents(stack1, stack2);
//    }
//
//}
