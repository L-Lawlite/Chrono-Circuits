package net.lawliet.chrono_circuits.datagen.model;

import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureSlot;

public class ChronoModelTemplates {
    public static final ModelTemplate HOPPER;
    public static final ModelTemplate HOPPER_SIDE;

    static {
        HOPPER = ModelTemplates.create("chrono_circuits:template_hopper", TextureSlot.TOP,TextureSlot.SIDE,TextureSlot.INSIDE);
        HOPPER_SIDE = ModelTemplates.create("chrono_circuits:template_hopper_side", TextureSlot.TOP,TextureSlot.SIDE,TextureSlot.INSIDE);
    }


}
