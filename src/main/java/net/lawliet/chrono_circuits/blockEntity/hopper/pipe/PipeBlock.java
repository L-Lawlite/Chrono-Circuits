package net.lawliet.chrono_circuits.blockEntity.hopper.pipe;

import com.mojang.serialization.MapCodec;
import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HopperBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class PipeBlock extends HopperBlock {
    private static final VoxelShape TOP;
    private static final VoxelShape CHUTE;
    private static final VoxelShape FUNNEL;
    private static final VoxelShape CONVEX_BASE;
    private static final VoxelShape INSIDE;
    private static final VoxelShape BASE;

    public static final MapCodec<PipeBlock> CODEC = simpleCodec(PipeBlock::new);
    public PipeBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PipeBlockEntity(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> be) {
        return level.isClientSide ? null : createTickerHelper(be, ChronoBlockEntityTypes.PIPE_BLOCK_ENTITY.get(), PipeBlockEntity::pushItemsTick);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult blockHitResult) {
        if (!level.isClientSide) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof PipeBlockEntity copperHopperBlockEntity) {
                player.openMenu(copperHopperBlockEntity);
                player.awardStat(Stats.INSPECT_HOPPER);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier insideBlockEffectApplier) {
        BlockEntity blockentity = level.getBlockEntity(pos);
        if (blockentity instanceof PipeBlockEntity be) {
            PipeBlockEntity.entityInside(level, pos, state, entity, be);
        }
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return BASE;
    }

    @Override
    protected VoxelShape getInteractionShape(BlockState state, BlockGetter level, BlockPos pos) {
        return INSIDE;
    }

    static {
        TOP = Block.box(2.0D, 14.0D, 2.0D, 14.0D, 16.0D, 14.0D);
        CHUTE = Block.box(3.0D, 12.0D, 3.0D, 13.0D, 14.0D, 13.0D);
        FUNNEL = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D);
        INSIDE = Block.box(3.0D, 15.0D, 3.0D, 13.0D, 16.0D, 13.0D);
        CONVEX_BASE = Shapes.or(FUNNEL, TOP, CHUTE);
        BASE = Shapes.join(CONVEX_BASE, INSIDE, BooleanOp.OR);
    }
}
