package net.lawliet.chrono_circuits.blocks.gratedBlocks.repeater;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;

public class WeatheringCopperGratedRepeater extends CopperGratedRepeater implements WeatheringCopper {
    @SuppressWarnings("unused")
    public static final MapCodec<WeatheringCopperGratedRepeater> CODEC;
    private final WeatheringCopper.WeatherState weatherState;

    public WeatheringCopperGratedRepeater(WeatherState weatherState , Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        changeOverTime(state, level, pos, random);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return WeatheringCopper.getNext(state.getBlock()).isPresent();
    }

    static {
        CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(WeatherState.CODEC.fieldOf("weather_state").forGetter(WeatheringCopperGratedRepeater::getAge),propertiesCodec()).apply(instance, WeatheringCopperGratedRepeater::new));
    }


}
