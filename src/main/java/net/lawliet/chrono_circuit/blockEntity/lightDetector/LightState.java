package net.lawliet.chrono_circuit.blockEntity.lightDetector;

import net.minecraft.util.StringRepresentable;

public enum LightState implements StringRepresentable {
    SKY("sky"),
    BLOCK("block"),
    SKY_AND_BLOCK("sky_and_block");

    private final String name;

    LightState(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
