package net.lawliet.chrono_circuits.blockEntity.hopper.copperHopper;

import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HopperBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class CopperHopperBlock extends HopperBlock {
    public CopperHopperBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CopperHopperBlockEntity(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> be) {
        return level.isClientSide ? null : createTickerHelper(be, ChronoBlockEntityTypes.COPPER_HOPPER_BLOCK_ENTITY.get(), CopperHopperBlockEntity::pushItemsTick);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult blockHitResult) {
        if (!level.isClientSide) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof CopperHopperBlockEntity copperHopperBlockEntity) {
                player.openMenu(copperHopperBlockEntity);
                player.awardStat(Stats.INSPECT_HOPPER);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier insideBlockEffectApplier) {
        BlockEntity blockentity = level.getBlockEntity(pos);
        if (blockentity instanceof CopperHopperBlockEntity be) {
            CopperHopperBlockEntity.entityInside(level, pos, state, entity, be);
        }
    }
}
