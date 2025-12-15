package net.lawliet.chrono_circuits.blockEntity.gratedBlockEntity.comparator;

import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.ComparatorBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ComparatorBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class CopperGratedComparatorBlockEntity extends ComparatorBlockEntity {
    public static ThreadLocal<BlockEntityType<?>> SURROGATE_TYPE = new ThreadLocal<>();
    private CopperGratedComparatorBlockEntity(BlockPos pos, BlockState blockState) {
        super(pos, blockState);
    }

    public static CopperGratedComparatorBlockEntity make(BlockPos pos, BlockState blockState) {
        try {
            SURROGATE_TYPE.set(
                    ChronoBlockEntityTypes.COPPER_GRATED_COMPARATOR_BLOCK_ENTITY.get()
            );
            return new CopperGratedComparatorBlockEntity(pos, blockState);
        } finally {
            SURROGATE_TYPE.remove();
        }
    }

}
