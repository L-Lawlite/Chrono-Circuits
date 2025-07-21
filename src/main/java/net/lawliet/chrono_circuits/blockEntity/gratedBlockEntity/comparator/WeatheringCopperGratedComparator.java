package net.lawliet.chrono_circuits.blockEntity.gratedBlockEntity.comparator;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;

public class WeatheringCopperGratedComparator extends CopperGratedComparator implements WeatheringCopper {
    @SuppressWarnings("unused")
    public static final MapCodec<WeatheringCopperGratedComparator> CODEC;
    private final WeatherState weatherState;

    public WeatheringCopperGratedComparator(WeatherState weatherState ,Properties properties) {
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
        CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(WeatherState.CODEC.fieldOf("weather_state").forGetter(WeatheringCopperGratedComparator::getAge), propertiesCodec()).apply(instance, WeatheringCopperGratedComparator::new));
    }
}
