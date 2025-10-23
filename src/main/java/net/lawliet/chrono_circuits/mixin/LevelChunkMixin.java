package net.lawliet.chrono_circuits.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.lawliet.chrono_circuits.datagen.Tags.ChronoCircuitsTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Debug(export = true)
@Mixin(LevelChunk.class)
public class LevelChunkMixin {


    @WrapOperation(method = "setBlockState", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z", ordinal = 0))
    public boolean shouldRemoveBlockEntityOnOxidation(BlockState instance, Block block, Operation<Boolean> original) {
        return original.call(instance, block) || instance.is(ChronoCircuitsTags.Blocks.OXIDIZATION_SHOULD_KEEP_BLOCK_ENTITY);
    }
}
