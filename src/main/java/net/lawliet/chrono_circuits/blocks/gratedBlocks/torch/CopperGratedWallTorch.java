package net.lawliet.chrono_circuits.blocks.gratedBlocks.torch;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

public class CopperGratedWallTorch extends WallTorchBlock implements SimpleWaterloggedBlock {
    public static final MapCodec<CopperGratedWallTorch> CODEC;
    public static final BooleanProperty WATERLOGGED;


    public CopperGratedWallTorch(SimpleParticleType flameParticle, Properties properties) {
        super(flameParticle, properties);
        this.registerDefaultState((this.stateDefinition.any())
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false)
        );
    }

    @Override
    protected BlockState updateShape(BlockState state1, LevelReader level, ScheduledTickAccess tickAccess, BlockPos pos1, Direction direction, BlockPos pos2, BlockState state2, RandomSource source) {
        if (state1.getValue(WATERLOGGED)) {
            tickAccess.scheduleTick(pos1, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return super.updateShape(state1, level, tickAccess, pos1, direction, pos2, state2, source);
    }


    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        BlockState blockState = super.getStateForPlacement(context);
        return blockState == null ? null : blockState
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING,WATERLOGGED);
    }

    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        CODEC = RecordCodecBuilder.mapCodec((builder -> builder.group(PARTICLE_OPTIONS_FIELD.forGetter(block -> block.flameParticle), propertiesCodec()).apply(builder, CopperGratedWallTorch::new)));
    }
}
