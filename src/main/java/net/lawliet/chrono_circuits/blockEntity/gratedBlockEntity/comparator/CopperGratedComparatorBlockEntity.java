package net.lawliet.chrono_circuits.blockEntity.gratedBlockEntity.comparator;

import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CopperGratedComparatorBlockEntity extends BlockEntity {
    private int output;


    public CopperGratedComparatorBlockEntity(BlockPos pos, BlockState blockState) {
        super(ChronoBlockEntityTypes.COPPER_GRATED_COMPARATOR_BLOCK_ENTITY.get(), pos, blockState);
    }

    @Override
    protected void saveAdditional(CompoundTag p_187493_, HolderLookup.Provider p_323979_) {
        super.saveAdditional(p_187493_, p_323979_);
        p_187493_.putInt("OutputSignal", this.output);
    }

    @Override
    protected void loadAdditional(CompoundTag p_338778_, HolderLookup.Provider p_338355_) {
        super.loadAdditional(p_338778_, p_338355_);
        this.output = p_338778_.getInt("OutputSignal");
    }

    @SuppressWarnings("unused")
    public int getOutputSignal() {
        return this.output;
    }

    @SuppressWarnings("unused")
    public void setOutputSignal(int output) {
        this.output = output;
    }
}
