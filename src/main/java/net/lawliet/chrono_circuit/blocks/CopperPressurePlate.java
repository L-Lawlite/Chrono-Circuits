package net.lawliet.chrono_circuit.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class CopperPressurePlate extends PressurePlateBlock {

    public CopperPressurePlate(BlockSetType type, Properties properties) {
        super(type, properties);
    }

    @Override
    protected int getSignalStrength(Level level, BlockPos pos) {
        return getEntityCount(level, TOUCH_AABB.move(pos), Player.class) > 0 ? 15 : 0;
    }
}
