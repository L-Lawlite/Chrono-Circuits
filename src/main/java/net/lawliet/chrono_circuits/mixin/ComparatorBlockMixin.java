package net.lawliet.chrono_circuits.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.lawliet.chrono_circuits.blockEntity.gratedBlockEntity.comparator.CopperGratedComparatorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ComparatorBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ComparatorBlockEntity.class)
public class ComparatorBlockMixin {

    @Definition(id = "COMPARATOR", field = "Lnet/minecraft/world/level/block/entity/BlockEntityType;COMPARATOR:Lnet/minecraft/world/level/block/entity/BlockEntityType;")
    @Expression("COMPARATOR")
    @ModifyExpressionValue(method = "<init>", at = @At("MIXINEXTRAS:EXPRESSION"))
    private static BlockEntityType<?> modifyEntityType(BlockEntityType<?> original) {
        var surrogate = CopperGratedComparatorBlockEntity.SURROGATE_TYPE.get();
        if(surrogate == null) {
            return original;
        }
        return surrogate;
    }
}
