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



    static {
        HOPPER = ModelTemplates.create(ChronoCircuits.MODID + "template_hopper", TextureSlot.TOP,TextureSlot.SIDE,TextureSlot.INSIDE);
        HOPPER_SIDE = ModelTemplates.create(ChronoCircuits.MODID + "template_hopper_side", TextureSlot.TOP,TextureSlot.SIDE,TextureSlot.INSIDE);
        LIGHT_DETECTOR = ModelTemplates.create(ChronoCircuits.MODID + "template_light_detector",TextureSlot.TOP,TextureSlot.SIDE,TextureSlot.BOTTOM);
        COPPER_GRATED_REDSTONE_TORCH = ModelTemplates.create(ChronoCircuits.MODID + "template_copper_grated_redstone_torch",ChronoCircuitsTextureSlot.COPPER_GRATE);
        COPPER_GRATED_REDSTONE_TORCH_UNLIT = ModelTemplates.create(ChronoCircuits.MODID + "template_copper_grated_redstone_torch_unlit",ChronoCircuitsTextureSlot.COPPER_GRATE);
        COPPER_GRATED_REDSTONE_WALL_TORCH = ModelTemplates.create(ChronoCircuits.MODID + "template_copper_grated_redstone_wall_torch",ChronoCircuitsTextureSlot.COPPER_GRATE);
        COPPER_GRATED_REDSTONE_WALL_TORCH_UNLIT = ModelTemplates.create(ChronoCircuits.MODID + "template_copper_grated_redstone_wall_torch_unlit",ChronoCircuitsTextureSlot.COPPER_GRATE);
    }


}
