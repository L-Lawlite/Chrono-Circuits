package net.lawliet.chrono_circuits.datagen.Tags;

import net.lawliet.chrono_circuits.ChronoCircuits;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ChronoCircuitsTags {

    public static class Blocks {
        public static final TagKey<Block> PRESSURE_PLATES = chronoCircuitsTag("pressure_plates");
        public static final TagKey<Block> HOPPERS = chronoCircuitsTag("hopper");
        public static final TagKey<Block> PIPES = chronoCircuitsTag("pipes");

    }

    private static TagKey<Block> chronoCircuitsTag(String name) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ChronoCircuits.MODID, name));
    }
}
