package net.lawliet.chrono_circuits.datagen.model;

import net.lawliet.chrono_circuits.ChronoCircuits;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureSlot;

public class ChronoCircuitsModelTemplates {
    public static final ModelTemplate HOPPER;
    public static final ModelTemplate HOPPER_SIDE;

    public static final ModelTemplate LIGHT_DETECTOR;

    public static final ModelTemplate COPPER_GRATED_REDSTONE_TORCH;
    public static final ModelTemplate COPPER_GRATED_REDSTONE_TORCH_UNLIT;
    public static final ModelTemplate COPPER_GRATED_REDSTONE_WALL_TORCH;
    public static final ModelTemplate COPPER_GRATED_REDSTONE_WALL_TORCH_UNLIT;

    public static final ModelTemplate COPPER_GRATED_COMPARATOR;
    public static final ModelTemplate COPPER_GRATED_COMPARATOR_ON;
    public static final ModelTemplate COPPER_GRATED_COMPARATOR_ON_SUBTRACT;
    public static final ModelTemplate COPPER_GRATED_COMPARATOR_SUBTRACT;

    public static final ModelTemplate COPPER_GRATED_REPEATER_1TICK;
    public static final ModelTemplate COPPER_GRATED_REPEATER_1TICK_LOCKED;
    public static final ModelTemplate COPPER_GRATED_REPEATER_1TICK_ON;
    public static final ModelTemplate COPPER_GRATED_REPEATER_1TICK_ON_LOCKED;
    public static final ModelTemplate COPPER_GRATED_REPEATER_2TICK_LOCKED;
    public static final ModelTemplate COPPER_GRATED_REPEATER_2TICK;
    public static final ModelTemplate COPPER_GRATED_REPEATER_2TICK_ON;
    public static final ModelTemplate COPPER_GRATED_REPEATER_2TICK_ON_LOCKED;
    public static final ModelTemplate COPPER_GRATED_REPEATER_3TICK;
    public static final ModelTemplate COPPER_GRATED_REPEATER_3TICK_LOCKED;
    public static final ModelTemplate COPPER_GRATED_REPEATER_3TICK_ON;
    public static final ModelTemplate COPPER_GRATED_REPEATER_3TICK_ON_LOCKED;
    public static final ModelTemplate COPPER_GRATED_REPEATER_4TICK_LOCKED;
    public static final ModelTemplate COPPER_GRATED_REPEATER_4TICK;
    public static final ModelTemplate COPPER_GRATED_REPEATER_4TICK_ON;
    public static final ModelTemplate COPPER_GRATED_REPEATER_4TICK_ON_LOCKED;



    static {
        HOPPER = ModelTemplates.create(ChronoCircuits.MODID + ":template_hopper", TextureSlot.TOP,TextureSlot.SIDE,TextureSlot.INSIDE);
        HOPPER_SIDE = ModelTemplates.create(ChronoCircuits.MODID + ":template_hopper_side", TextureSlot.TOP,TextureSlot.SIDE,TextureSlot.INSIDE);
        LIGHT_DETECTOR = ModelTemplates.create(ChronoCircuits.MODID + ":template_light_detector",TextureSlot.TOP,TextureSlot.SIDE,TextureSlot.BOTTOM);
        COPPER_GRATED_REDSTONE_TORCH = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_redstone_torch",ChronoCircuitsTextureSlot.COPPER_GRATE);
        COPPER_GRATED_REDSTONE_TORCH_UNLIT = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_redstone_torch_unlit",ChronoCircuitsTextureSlot.COPPER_GRATE);
        COPPER_GRATED_REDSTONE_WALL_TORCH = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_redstone_wall_torch",ChronoCircuitsTextureSlot.COPPER_GRATE);
        COPPER_GRATED_REDSTONE_WALL_TORCH_UNLIT = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_redstone_wall_torch_unlit",ChronoCircuitsTextureSlot.COPPER_GRATE);
        COPPER_GRATED_COMPARATOR = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_comparator", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
        COPPER_GRATED_COMPARATOR_ON = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_comparator_on", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
        COPPER_GRATED_COMPARATOR_ON_SUBTRACT = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_comparator_on_subtract", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
        COPPER_GRATED_COMPARATOR_SUBTRACT = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_comparator_subtract", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
        COPPER_GRATED_REPEATER_1TICK = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_repeater_1tick", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
        COPPER_GRATED_REPEATER_1TICK_LOCKED = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_repeater_1tick_locked", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
        COPPER_GRATED_REPEATER_1TICK_ON = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_repeater_1tick_on", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
        COPPER_GRATED_REPEATER_1TICK_ON_LOCKED = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_repeater_1tick_on_locked", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
        COPPER_GRATED_REPEATER_2TICK_LOCKED = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_repeater_2tick_locked", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
        COPPER_GRATED_REPEATER_2TICK = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_repeater_2tick", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
        COPPER_GRATED_REPEATER_2TICK_ON = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_repeater_2tick_on", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
        COPPER_GRATED_REPEATER_2TICK_ON_LOCKED = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_repeater_2tick_on_locked", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
        COPPER_GRATED_REPEATER_3TICK = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_repeater_3tick", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
        COPPER_GRATED_REPEATER_3TICK_LOCKED = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_repeater_3tick_locked", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
        COPPER_GRATED_REPEATER_3TICK_ON = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_repeater_3tick_on", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
        COPPER_GRATED_REPEATER_3TICK_ON_LOCKED = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_repeater_3tick_on_locked", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
        COPPER_GRATED_REPEATER_4TICK_LOCKED = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_repeater_4tick_locked", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
        COPPER_GRATED_REPEATER_4TICK = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_repeater_4tick", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
        COPPER_GRATED_REPEATER_4TICK_ON = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_repeater_4tick_on", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
        COPPER_GRATED_REPEATER_4TICK_ON_LOCKED = ModelTemplates.create(ChronoCircuits.MODID + ":template_copper_grated_repeater_4tick_on_locked", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
    }


}
