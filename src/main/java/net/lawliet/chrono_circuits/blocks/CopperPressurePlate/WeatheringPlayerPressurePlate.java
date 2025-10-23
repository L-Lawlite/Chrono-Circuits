package net.lawliet.chrono_circuits.blocks.CopperPressurePlate;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class WeatheringPlayerPressurePlate extends PlayerPressurePlate implements WeatheringCopper {
    public static final MapCodec<WeatheringPlayerPressurePlate> CODEC = RecordCodecBuilder
            .mapCodec((inst) -> inst.group(
                    WeatheringCopper.WeatherState.CODEC.fieldOf("weathering_state")
                            .forGetter(ChangeOverTimeBlock::getAge),
                    BlockSetType.CODEC.fieldOf("block_set_type")
                            .forGetter(pressurePlate -> pressurePlate.type),
                    propertiesCodec(),
                    Codec.INT.optionalFieldOf("tick_delay",0)
                            .forGetter(pressurePlate -> pressurePlate.tickDelay))
                    .apply(inst, WeatheringPlayerPressurePlate::new));
    private final WeatheringCopper.WeatherState weatherState;


    public WeatheringPlayerPressurePlate(WeatheringCopper.WeatherState weatherState, BlockSetType type, Properties properties, int tickDelay) {
        super(type,properties,tickDelay);
        this.weatherState = weatherState;
    }

    public WeatheringPlayerPressurePlate(WeatheringCopper.WeatherState weatherState, BlockSetType type, Properties properties) {
        this(weatherState,type,properties,20);
    }

    @Override
    protected MapCodec<WeatheringPlayerPressurePlate> codec() {
        return CODEC;
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

}
