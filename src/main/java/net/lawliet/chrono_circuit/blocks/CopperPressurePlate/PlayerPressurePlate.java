package net.lawliet.chrono_circuit.blocks.CopperPressurePlate;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;

public class PlayerPressurePlate extends PressurePlateBlock {
    protected int tickDelay;

    public PlayerPressurePlate(BlockSetType type, Properties properties,int tickDelay) {
        super(type, properties);
        this.tickDelay = tickDelay;
    }

    public PlayerPressurePlate(BlockSetType type, Properties properties) {
        super(type, properties);
        this.tickDelay = 0;
    }

    @Override
    protected int getSignalStrength(Level level, BlockPos pos) {
        return getEntityCount(level, TOUCH_AABB.move(pos), Player.class) > 0 ? 15 : 0;
    }

    @Override
    protected void tick(BlockState state, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        int i = this.getSignalForState(state);
        if (i > 0) {
            System.out.println(this.tickDelay);
            serverLevel.scheduleTick(pos,this,this.tickDelay);
            this.checkPressed((Entity)null, serverLevel, pos, state, i);
        }
    }

    private void checkPressed(@Nullable Entity entity, Level level, BlockPos pos, BlockState state, int currentSignal) {
        int i = this.getSignalStrength(level, pos);
        boolean flag = currentSignal > 0;
        boolean flag1 = i > 0;
        if (currentSignal != i) {
            BlockState blockstate = this.setSignalForState(state, i);
            level.setBlock(pos, blockstate, 2);
            this.updateNeighbours(level, pos);
            level.setBlocksDirty(pos, state, blockstate);
        }

        if (!flag1 && flag) {
            level.playSound((Player)null, pos, this.type.pressurePlateClickOff(), SoundSource.BLOCKS);
            level.gameEvent(entity, GameEvent.BLOCK_DEACTIVATE, pos);
        } else if (flag1 && !flag) {
            level.playSound((Player)null, pos, this.type.pressurePlateClickOn(), SoundSource.BLOCKS);
            level.gameEvent(entity, GameEvent.BLOCK_ACTIVATE, pos);
        }

        if (flag1) {
            level.scheduleTick(new BlockPos(pos), this, this.getPressedTime());
        }

    }
}
