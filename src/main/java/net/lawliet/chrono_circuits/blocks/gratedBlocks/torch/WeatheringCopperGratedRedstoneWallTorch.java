package net.lawliet.chrono_circuits.blocks.gratedBlocks.torch;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

public class WeatheringCopperGratedRedstoneWallTorch extends CopperGratedRedstoneWallTorch implements SimpleWaterloggedBlock, WeatheringCopper {
    public static final MapCodec<WeatheringCopperGratedRedstoneWallTorch> CODEC;
    private final WeatheringCopper.WeatherState weatherState;

    public WeatheringCopperGratedRedstoneWallTorch(WeatherState weatherState, Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        this.changeOverTime(state, level, pos, random);
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
        CODEC = RecordCodecBuilder.mapCodec((builder -> builder.group(WeatherState.CODEC.fieldOf("weather_state").forGetter(WeatheringCopperGratedRedstoneWallTorch::getAge), propertiesCodec()).apply(builder, WeatheringCopperGratedRedstoneWallTorch::new)));
    }

}
