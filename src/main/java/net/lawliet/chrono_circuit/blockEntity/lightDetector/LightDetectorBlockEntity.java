package net.lawliet.chrono_circuit.blockEntity.lightDetector;

import net.lawliet.chrono_circuit.registration.ChronoBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class LightDetectorBlockEntity extends BlockEntity {
    public LightDetectorBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ChronoBlockEntityTypes.LIGHT_DETECTOR_BLOCK_ENTITY.get(), blockPos, blockState);
    }
}
