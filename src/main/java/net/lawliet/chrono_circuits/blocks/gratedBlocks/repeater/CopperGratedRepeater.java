package net.lawliet.chrono_circuits.blocks.gratedBlocks.repeater;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RepeaterBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CopperGratedRepeater extends RepeaterBlock implements SimpleWaterloggedBlock {
    @SuppressWarnings("unused")
    public static final MapCodec<CopperGratedRepeater> CODEC = simpleCodec(CopperGratedRepeater::new);
    public static final BooleanProperty WATERLOGGED;
    private static final VoxelShape SHAPE;

    public CopperGratedRepeater(Properties properties) {
        super(properties);
        this.registerDefaultState(
                (this.stateDefinition.any())
                        .setValue(FACING, Direction.NORTH)
                        .setValue(DELAY, 1)
                        .setValue(LOCKED, false)
                        .setValue(POWERED, false)
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


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return super.getStateForPlacement(context)
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, DELAY, LOCKED, POWERED, WATERLOGGED);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        SHAPE = Block.box(0.0F, 0.0F, 0.0F, 16.0F, 3.0F, 16.0F);
    }
}
