package net.lawliet.chrono_circuit.blockEntity.lightDetector;

import com.mojang.serialization.MapCodec;
import net.lawliet.chrono_circuit.registration.ChronoBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class LightDetectorBlock extends BaseEntityBlock {
    public static final MapCodec<LightDetectorBlock> CODEC = simpleCodec(LightDetectorBlock::new);
    public static final IntegerProperty POWER;
    public static final EnumProperty<LightState> LIGHT_STATE;
    protected static final VoxelShape SHAPE;


    public LightDetectorBlock(BlockBehaviour.Properties p_49224_) {
        super(p_49224_);
        this.registerDefaultState(this.stateDefinition.any().setValue(POWER,0).setValue(LIGHT_STATE,LightState.SKY_AND_BLOCK));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    @Override
    protected int getSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return state.getValue(POWER);
    }

    private static void updateSignalStrength(BlockState state, Level level, BlockPos pos) {
        int signal = getLightLevel(state,level,pos);
        if (state.getValue(POWER) != signal) {
            level.setBlock(pos,state.setValue(POWER,signal),3);
        }
    }

    private static int getLightLevel(BlockState state, Level level, BlockPos pos) {
        int sky_light = level.getBrightness(LightLayer.SKY, pos);
        int block_light = level.getBrightness(LightLayer.BLOCK,pos);
        LightState operationState = state.getValue(LIGHT_STATE);
        return switch (operationState) {
            case LightState.SKY -> sky_light;
            case LightState.BLOCK -> block_light;
            default -> Math.max(sky_light,block_light);
        };
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!player.mayBuild()) {
            return super.useWithoutItem(state,level,pos,player,hitResult);
        }
        if(!level.isClientSide) {
            BlockState nextBlockState = state.cycle(LIGHT_STATE);
            level.setBlock(pos,nextBlockState,2);
            level.gameEvent(GameEvent.BLOCK_CHANGE,pos, GameEvent.Context.of(player,nextBlockState));
            updateSignalStrength(nextBlockState,level,pos);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected boolean isSignalSource(BlockState state) {
        return true;
    }

    private static void tickEntity(Level level, BlockPos pos, BlockState state, LightDetectorBlockEntity be) {
        updateSignalStrength(state,level,pos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWER,LIGHT_STATE);
    }

    @Override
    protected MapCodec<LightDetectorBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new LightDetectorBlockEntity(blockPos,blockState);
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> beType) {
        return !level.isClientSide ? createTickerHelper(beType, ChronoBlockEntityTypes.LIGHT_DETECTOR_BLOCK_ENTITY.get(),LightDetectorBlock::tickEntity) : null;
    }

    static {
        POWER = BlockStateProperties.POWER;
        LIGHT_STATE = net.lawliet.chrono_circuit.blockState.BlockStateProperties.LIGHT_STATE;
        SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D);
    }
}
