package net.lawliet.chrono_circuits.blockEntity.hopper.goldHopper;

import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HopperBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class GoldHopperBlock extends HopperBlock {
    public GoldHopperBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new GoldHopperBlockEntity(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> be) {
        return level.isClientSide ? null : createTickerHelper(be, ChronoBlockEntityTypes.GOLD_HOPPER_BLOCK_ENTITY.get(), GoldHopperBlockEntity::pushItemsTick);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult blockHitResult) {
        if (!level.isClientSide) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof GoldHopperBlockEntity copperHopperBlockEntity) {
                player.openMenu(copperHopperBlockEntity);
                player.awardStat(Stats.INSPECT_HOPPER);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        BlockEntity blockentity = level.getBlockEntity(pos);
        if (blockentity instanceof GoldHopperBlockEntity be) {
            GoldHopperBlockEntity.entityInside(level, pos, state, entity, be);
        }
    }
}
