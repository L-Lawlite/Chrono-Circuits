package net.lawliet.chrono_circuits.blockState;

import net.lawliet.chrono_circuits.blockEntity.lightDetector.LightState;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class BlockStateProperties {
    public static final EnumProperty<LightState> LIGHT_STATE;

    static {
        LIGHT_STATE = EnumProperty.create("light_state",LightState.class);
    }
}
