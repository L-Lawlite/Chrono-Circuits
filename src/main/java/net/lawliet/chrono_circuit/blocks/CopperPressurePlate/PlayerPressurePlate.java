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
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import javax.annotation.Nullable;

public class PlayerPressurePlate extends BasePressurePlateBlock implements WeatheringCopper {
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
    public static final BooleanProperty POWERED;


    public PlayerPressurePlate(WeatheringCopper.WeatherState weatherState, BlockSetType type, Properties properties, int tickDelay) {
        super(properties,type);
        this.tickDelay = tickDelay;
        this.weatherState = weatherState;
        this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, false));

    }

    public PlayerPressurePlate(WeatheringCopper.WeatherState weatherState,BlockSetType type, Properties properties) {
        this(weatherState,type,properties,20);
    }

    @Override
    protected int getSignalStrength(Level level, BlockPos pos) {
        return getEntityCount(level, TOUCH_AABB.move(pos), Player.class) > 0 ? 15 : 0;
    }

    @Override
    protected int getSignalForState(BlockState state) {
        return state.getValue(POWERED) ? 15 : 0;
    }

    @Override
    protected BlockState setSignalForState(BlockState state, int strength) {
        return state.setValue(POWERED, strength > 0);
    }

    @Override
    protected MapCodec<PlayerPressurePlate> codec() {
        return CODEC;
    }

    @Override
    protected void tick(BlockState state, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        int i = this.getSignalForState(state);
        if (i > 0) {
            this.checkPressed((Entity)null, serverLevel, pos, state, i);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
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
            level.scheduleTick(new BlockPos(pos), this, Math.max(this.getPressedTime(),this.tickDelay));
        }
        else {
            level.scheduleTick(new BlockPos(pos),this,this.tickDelay);
        }

    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        this.changeOverTime(state,level,pos,random);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return WeatheringCopper.getNext(state.getBlock()).isPresent();
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }

    static {
        POWERED = BlockStateProperties.POWERED;
    }

}
