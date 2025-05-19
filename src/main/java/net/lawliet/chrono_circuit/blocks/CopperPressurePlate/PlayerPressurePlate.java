package net.lawliet.chrono_circuit.blocks.CopperPressurePlate;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.DataMapHooks;

import javax.annotation.Nullable;
import java.util.Optional;

public class PlayerPressurePlate extends PressurePlateBlock implements ChangeOverTimeBlock<WeatheringCopper.WeatherState> {
    public static final MapCodec<PlayerPressurePlate> CODEC = RecordCodecBuilder
            .mapCodec((inst) -> inst.group(
                    WeatheringCopper.WeatherState.CODEC.fieldOf("weathering_state")
                            .forGetter(ChangeOverTimeBlock::getAge),
                    BlockSetType.CODEC.fieldOf("block_set_type")
                            .forGetter(pressurePlate -> pressurePlate.type),
                    propertiesCodec(),
                    Codec.INT.optionalFieldOf("tick_delay",0)
                            .forGetter(pressurePlate -> pressurePlate.tickDelay))
                    .apply(inst, PlayerPressurePlate::new));
    protected int tickDelay;
    private final WeatheringCopper.WeatherState weatherState;

    public PlayerPressurePlate(WeatheringCopper.WeatherState weatherState, BlockSetType type, Properties properties, int tickDelay) {
        super(type, properties);
        this.tickDelay = tickDelay;
        this.weatherState = weatherState;
    }

    public PlayerPressurePlate(WeatheringCopper.WeatherState weatherState,BlockSetType type, Properties properties) {
        this(weatherState,type,properties,0);
    }

    @Override
    protected int getSignalStrength(Level level, BlockPos pos) {
        return getEntityCount(level, TOUCH_AABB.move(pos), Player.class) > 0 ? 15 : 0;
    }

    @Override
    protected void tick(BlockState state, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        int i = this.getSignalForState(state);
        if (i > 0) {
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

    @Override
    public Optional<BlockState> getNext(BlockState blockState) {
        return  getNext(blockState.getBlock()).map((state) -> state.withPropertiesOf(blockState));
    }

    private static Optional<Block> getNext(Block block) {
        return Optional.ofNullable(DataMapHooks.getNextOxidizedStage(block));
    }

    @Override
    public float getChanceModifier() {
        return this.getAge() == WeatheringCopper.WeatherState.UNAFFECTED ? 0.75F : 1.0F;
    }

    @Override
    public WeatheringCopper.WeatherState getAge() {
        return this.weatherState;
    }
}
