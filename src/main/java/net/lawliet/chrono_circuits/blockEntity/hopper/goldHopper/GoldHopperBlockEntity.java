package net.lawliet.chrono_circuits.blockEntity.hopper.goldHopper;

import net.lawliet.chrono_circuits.blockEntity.hopper.HopperBlockEntityHandler;
import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.WorldlyContainerHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.HopperBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.Hopper;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.ContainerOrHandler;
import net.neoforged.neoforge.items.IItemHandler;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.BooleanSupplier;

public class GoldHopperBlockEntity extends RandomizableContainerBlockEntity implements Hopper {
    public static final int MOVE_ITEM_SPEED = 2;
    public static final int HOPPER_CONTAINER_SIZE = 2;
    private static final int[][] CACHED_SLOTS = new int[54][];
    private NonNullList<ItemStack> items;
    private int cooldownTime = -1;
    private long tickedGameTime;
    private Direction facing;

    public GoldHopperBlockEntity(BlockPos pos, BlockState blockState) {
        super(ChronoBlockEntityTypes.GOLD_HOPPER_BLOCK_ENTITY.get(), pos, blockState);
        this.items = NonNullList.withSize(HOPPER_CONTAINER_SIZE, ItemStack.EMPTY);
        this.facing = blockState.getValue(HopperBlock.FACING);
    }

    @Override
    protected void loadAdditional(ValueInput compoundTag) {
        super.loadAdditional(compoundTag);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(compoundTag)) {
            ContainerHelper.loadAllItems(compoundTag, this.items);
        }

        this.cooldownTime = compoundTag.getIntOr("TransferCooldown", -1);
    }

    @Override
    protected void saveAdditional(ValueOutput compoundTag) {
        super.saveAdditional(compoundTag);
        if (!this.trySaveLootTable(compoundTag)) {
            ContainerHelper.saveAllItems(compoundTag, this.items);
        }

        compoundTag.putInt("TransferCooldown", this.cooldownTime);
    }

    @Override
    public int getContainerSize() {
        return this.items.size();
    }

    @Override
    public ItemStack removeItem(int index, int count) {
        this.unpackLootTable((Player)null);
        return ContainerHelper.removeItem(this.getItems(), index, count);
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        this.unpackLootTable((Player)null);
        this.getItems().set(index, stack);
        stack.limitSize(this.getMaxStackSize(stack));
    }

    @Override
    public void setBlockState(BlockState state) {
        super.setBlockState(state);
        this.facing = state.getValue(HopperBlock.FACING);
    }

    @Override
    protected Component getDefaultName() {
        ResourceLocation blockId = BuiltInRegistries.BLOCK.getKey(this.getBlockState().getBlock());
        return  Component.translatable(blockId.toLanguageKey("container"));
    }

    public static void pushItemsTick(Level level, BlockPos pos, BlockState state, GoldHopperBlockEntity be) {
        --be.cooldownTime;
        be.tickedGameTime = level.getGameTime();
        if (!be.isOnCooldown()) {
            be.setCooldown(0);
            tryMoveItems(level, pos, state, be, () -> suckInItems(level, be));
        }

    }

    private static boolean tryMoveItems(Level level, BlockPos pos, BlockState state, GoldHopperBlockEntity be, BooleanSupplier validator) {
        if (level.isClientSide) {
            return false;
        }
        if (!be.isOnCooldown() && state.getValue(HopperBlock.ENABLED)) {
            boolean flag = false;
            if (!be.isEmpty()) {
                flag = ejectItems(level, pos, be);
            }

            if (!be.inventoryFull()) {
                flag |= validator.getAsBoolean();
            }

            if (flag) {
                be.setCooldown(MOVE_ITEM_SPEED);
                setChanged(level, pos, state);
                return true;
            }
        }

        return false;
    }

    private boolean inventoryFull() {
        for(ItemStack itemstack : this.items) {
            if (itemstack.isEmpty() || itemstack.getCount() != itemstack.getMaxStackSize()) {
                return false;
            }
        }

        return true;
    }

    private static boolean ejectItems(Level level, BlockPos pos, GoldHopperBlockEntity blockEntity) {
        ContainerOrHandler containerOrHandler = getContainerOrHandlerAt(level, pos.relative(blockEntity.facing), blockEntity.facing.getOpposite());
        if (containerOrHandler.isEmpty()) {
            return false;
        }
        Container container = containerOrHandler.container();
        if(container == null) {
            return HopperBlockEntityHandler.insertHook(blockEntity, containerOrHandler.itemHandler());
        }
        Direction direction = blockEntity.facing.getOpposite();
        if (isFullContainer(container, direction)) {
            return false;
        }
        for(int i = 0; i < blockEntity.getContainerSize(); ++i) {
            ItemStack itemstack = blockEntity.getItem(i);
            if (!itemstack.isEmpty()) {
                int j = itemstack.getCount();
                ItemStack itemstack1 = addItem(blockEntity, container, blockEntity.removeItem(i, 1), direction);
                if (itemstack1.isEmpty()) {
                    container.setChanged();
                    return true;
                }

                itemstack.setCount(j);
                if (j == 1) {
                    blockEntity.setItem(i, itemstack);
                }
            }
        }
        return false;

    }


    private static int[] getSlots(Container container, Direction direction) {
        if (container instanceof WorldlyContainer worldlycontainer) {
            return worldlycontainer.getSlotsForFace(direction);
        } else {
            int i = container.getContainerSize();
            if (i < CACHED_SLOTS.length) {
                int[] aint = CACHED_SLOTS[i];
                if (aint != null) {
                    return aint;
                } else {
                    int[] aint1 = createFlatSlots(i);
                    CACHED_SLOTS[i] = aint1;
                    return aint1;
                }
            } else {
                return createFlatSlots(i);
            }
        }
    }

    private static int[] createFlatSlots(int size) {
        int[] aint = new int[size];

        for(int i = 0; i < aint.length; i++) {
            aint[i] = i;
        }

        return aint;
    }

    private static boolean isFullContainer(Container container, Direction direction) {
        int[] aint = getSlots(container, direction);

        for(int i : aint) {
            ItemStack itemstack = container.getItem(i);
            if (itemstack.getCount() < itemstack.getMaxStackSize()) {
                return false;
            }
        }

        return true;
    }

    public static boolean suckInItems(Level level, GoldHopperBlockEntity hopper) {
        BlockPos blockpos = BlockPos.containing(hopper.getLevelX(), hopper.getLevelY() + (double)1.0F, hopper.getLevelZ());
        BlockState blockstate = level.getBlockState(blockpos);
        ContainerOrHandler containerOrHandler = getSourceContainerOrHandler(level, hopper, blockpos, blockstate);
        if (containerOrHandler.container() != null) {
            Container container = containerOrHandler.container();
            Direction direction = Direction.DOWN;

            for(int i : getSlots(container, direction)) {
                if (tryTakeInItemFromSlot(hopper, container, i, direction)) {
                    return true;
                }
            }

            return false;
        } else if (containerOrHandler.itemHandler() != null) {
            return HopperBlockEntityHandler.extractHook(hopper, containerOrHandler.itemHandler());
        } else {
            boolean flag = hopper.isGridAligned() && blockstate.isCollisionShapeFullBlock(level, blockpos) && !blockstate.is(BlockTags.DOES_NOT_BLOCK_HOPPERS);
            if (!flag) {
                for(ItemEntity itementity : getItemsAtAndAbove(level, hopper)) {
                    if (addItem(hopper, itementity)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    private static boolean tryTakeInItemFromSlot(Hopper hopper, Container container, int slot, Direction direction) {
        ItemStack itemstack = container.getItem(slot);
        if (!itemstack.isEmpty() && canTakeItemFromContainer(hopper, container, itemstack, slot, direction)) {
            int i = itemstack.getCount();
            ItemStack itemstack1 = addItem(container, hopper, container.removeItem(slot, 1), (Direction)null);
            if (itemstack1.isEmpty()) {
                container.setChanged();
                return true;
            }

            itemstack.setCount(i);
            if (i == 1) {
                container.setItem(slot, itemstack);
            }
        }

        return false;
    }

    public static boolean addItem(Container container, ItemEntity item) {
        boolean flag = false;
        ItemStack itemstack = item.getItem().copy();
        ItemStack itemstack1 = addItem((Container)null, container, itemstack, (Direction)null);
        if (itemstack1.isEmpty()) {
            flag = true;
            item.setItem(ItemStack.EMPTY);
            item.discard();
        } else {
            item.setItem(itemstack1);
        }

        return flag;
    }

    public static ItemStack addItem(@Nullable Container source, Container destination, ItemStack stack, @Nullable Direction direction) {
        if (destination instanceof WorldlyContainer worldlycontainer) {
            if (direction != null) {
                int[] aint = worldlycontainer.getSlotsForFace(direction);

                for(int k = 0; k < aint.length && !stack.isEmpty(); ++k) {
                    stack = tryMoveInItem(source, destination, stack, aint[k], direction);
                }

                return stack;
            }
        }

        int i = destination.getContainerSize();

        for(int j = 0; j < i && !stack.isEmpty(); ++j) {
            stack = tryMoveInItem(source, destination, stack, j, direction);
        }

        return stack;
    }

    private static boolean canPlaceItemInContainer(Container container, ItemStack stack, int slot, @Nullable Direction direction) {
        if (!container.canPlaceItem(slot, stack)) {
            return false;
        } else {
            if (container instanceof WorldlyContainer worldlycontainer) {
                return worldlycontainer.canPlaceItemThroughFace(slot, stack, direction);
            }

            return true;
        }
    }

    private static boolean canTakeItemFromContainer(Container source, Container destination, ItemStack stack, int slot, Direction direction) {
        if (!destination.canTakeItem(source, slot, stack)) {
            return false;
        } else {
            if (destination instanceof WorldlyContainer worldlycontainer) {
                return worldlycontainer.canTakeItemThroughFace(slot, stack, direction);
            }

            return true;
        }
    }

    private static ItemStack tryMoveInItem(@Nullable Container source, Container destination, ItemStack stack, int slot, @Nullable Direction direction) {
        ItemStack itemstack = destination.getItem(slot);
        if (canPlaceItemInContainer(destination, stack, slot, direction)) {
            boolean flag = false;
            boolean flag1 = destination.isEmpty();
            if (itemstack.isEmpty()) {
                destination.setItem(slot, stack);
                stack = ItemStack.EMPTY;
                flag = true;
            } else if (canMergeItems(itemstack, stack)) {
                int i = stack.getMaxStackSize() - itemstack.getCount();
                int j = Math.min(stack.getCount(), i);
                stack.shrink(j);
                itemstack.grow(j);
                flag = j > 0;
            }

            if (flag) {
                if (flag1 && destination instanceof GoldHopperBlockEntity hopperblockentity1) {
                    if (!hopperblockentity1.isOnCustomCooldown()) {
                        int k = 0;
                        if (source instanceof GoldHopperBlockEntity hopperblockentity) {
                            if (hopperblockentity1.tickedGameTime >= hopperblockentity.tickedGameTime) {
                                k = 1;
                            }
                        }

                        hopperblockentity1.setCooldown(MOVE_ITEM_SPEED - k);
                    }
                }

                destination.setChanged();
            }
        }

        return stack;
    }

    @Nullable
    private static Container getAttachedContainer(Level level, BlockPos pos, GoldHopperBlockEntity blockEntity) {
        return getContainerAt(level, pos.relative(blockEntity.facing));
    }

    @Nullable
    private static Container getSourceContainer(Level level, Hopper hopper, BlockPos pos, BlockState state) {
        return getContainerAt(level, pos, state, hopper.getLevelX(), hopper.getLevelY() + (double)1.0F, hopper.getLevelZ());
    }

    public static List<ItemEntity> getItemsAtAndAbove(Level level, Hopper hopper) {
        AABB aabb = hopper.getSuckAabb().move(hopper.getLevelX() - (double)0.5F, hopper.getLevelY() - (double)0.5F, hopper.getLevelZ() - (double)0.5F);
        return level.getEntitiesOfClass(ItemEntity.class, aabb, EntitySelector.ENTITY_STILL_ALIVE);
    }

    /** @deprecated */
    @Deprecated
    @Nullable
    public static Container getContainerAt(Level level, BlockPos pos) {
        return getContainerAt(level, pos, level.getBlockState(pos), (double)pos.getX() + (double)0.5F, (double)pos.getY() + (double)0.5F, (double)pos.getZ() + (double)0.5F);
    }

    @Nullable
    private static Container getContainerAt(Level level, BlockPos pos, BlockState state, double x, double y, double z) {
        Container container = getBlockContainer(level, pos, state);
        if (container == null) {
            container = getEntityContainer(level, x, y, z);
        }

        return container;
    }

    @Nullable
    private static Container getBlockContainer(Level level, BlockPos pos, BlockState state) {
        Block block = state.getBlock();
        if (block instanceof WorldlyContainerHolder) {
            return ((WorldlyContainerHolder)block).getContainer(state, level, pos);
        } else {
            if (state.hasBlockEntity()) {
                BlockEntity var5 = level.getBlockEntity(pos);
                if (var5 instanceof Container container) {
                    if (container instanceof ChestBlockEntity && block instanceof ChestBlock) {
                        return ChestBlock.getContainer((ChestBlock)block, state, level, pos, true);
                    }

                    return container;
                }
            }

            return null;
        }
    }

    @Nullable
    private static Container getEntityContainer(Level level, double x, double y, double z) {
        List<Entity> list = level.getEntities((Entity)null, new AABB(x - (double)0.5F, y - (double)0.5F, z - (double)0.5F, x + (double)0.5F, y + (double)0.5F, z + (double)0.5F), EntitySelector.CONTAINER_ENTITY_SELECTOR);
        return !list.isEmpty() ? (Container)list.get(level.random.nextInt(list.size())) : null;
    }

    private static ContainerOrHandler getSourceContainerOrHandler(Level level, GoldHopperBlockEntity hopper, BlockPos pos, BlockState state) {
        return getContainerOrHandlerAt(level, pos, state, hopper.getLevelX(), hopper.getLevelY() + (double)1.0F, hopper.getLevelZ(), Direction.DOWN);
    }

    public static ContainerOrHandler getContainerOrHandlerAt(Level level, BlockPos pos, @Nullable Direction side) {
        return getContainerOrHandlerAt(level, pos, level.getBlockState(pos), (double)pos.getX() + (double)0.5F, (double)pos.getY() + (double)0.5F, (double)pos.getZ() + (double)0.5F, side);
    }

    private static ContainerOrHandler getContainerOrHandlerAt(Level level, BlockPos pos, BlockState state, double x, double y, double z, @Nullable Direction side) {
        Container container = getBlockContainer(level, pos, state);
        if (container != null) {
            return new ContainerOrHandler(container, (IItemHandler)null);
        } else {
            IItemHandler blockItemHandler = (IItemHandler)level.getCapability(Capabilities.ItemHandler.BLOCK, pos, state, (BlockEntity)null, side);
            return blockItemHandler != null ? new ContainerOrHandler((Container)null, blockItemHandler) : HopperBlockEntityHandler.getEntityContainerOrHandler(level, x, y, z, side);
        }
    }

    private static boolean canMergeItems(ItemStack stack1, ItemStack stack2) {
        return stack1.getCount() <= stack1.getMaxStackSize() && ItemStack.isSameItemSameComponents(stack1, stack2);
    }

    @Override
    public double getLevelX() {
        return (double)this.worldPosition.getX() + (double)0.5F;
    }

    @Override
    public double getLevelY() {
        return (double)this.worldPosition.getY() + (double)0.5F;
    }

    @Override
    public double getLevelZ() {
        return (double)this.worldPosition.getZ() + (double)0.5F;
    }

    @Override
    public boolean isGridAligned() {
        return true;
    }

    public void setCooldown(int cooldownTime) {
        this.cooldownTime = cooldownTime;
    }

    private boolean isOnCooldown() {
        return this.cooldownTime > 0;
    }

    public boolean isOnCustomCooldown() {
        return this.cooldownTime > MOVE_ITEM_SPEED;
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        this.items = items;
    }

    public static void entityInside(Level level, BlockPos pos, BlockState state, Entity entity, GoldHopperBlockEntity blockEntity) {
        if (entity instanceof ItemEntity itementity) {
            if (!itementity.getItem().isEmpty() && entity.getBoundingBox().move(-pos.getX(), -pos.getY(), -pos.getZ()).intersects(blockEntity.getSuckAabb())) {
                tryMoveItems(level, pos, state, blockEntity, () -> addItem(blockEntity, itementity));
            }
        }

    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player) {
        return new GoldHopperMenu(id, player, this);
    }

    public long getLastUpdateTime() {
        return this.tickedGameTime;
    }

}
