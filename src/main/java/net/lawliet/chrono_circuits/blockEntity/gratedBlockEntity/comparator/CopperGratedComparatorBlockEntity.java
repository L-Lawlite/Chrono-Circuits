package net.lawliet.chrono_circuits.blockEntity.gratedBlockEntity.comparator;

import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CopperGratedComparatorBlockEntity extends BlockEntity {
    private int output = 0;


    public CopperGratedComparatorBlockEntity(BlockPos pos, BlockState blockState) {
        super(ChronoBlockEntityTypes.COPPER_GRATED_COMPARATOR_BLOCK_ENTITY.get(), pos, blockState);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.saveAdditional(tag, provider);
        tag.putInt("OutputSignal", this.output);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.loadAdditional(tag, provider);
        this.output = tag.getIntOr("OutputSignal", 0);
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
