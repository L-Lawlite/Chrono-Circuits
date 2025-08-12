package net.lawliet.chrono_circuits.datagen.Tags;

import net.lawliet.chrono_circuits.ChronoCircuits;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ChronoCircuitsTags {

    public static class Blocks {
        public static final TagKey<Block> COPPER_PRESSURE_PLATES = chronoCircuitsTag("copper_pressure_plates");
        public static final TagKey<Block> PRESSURE_PLATES = chronoCircuitsTag("pressure_plates");
        public static final TagKey<Block> COPPER_HOPPERS = chronoCircuitsTag("copper_hoppers");
        public static final TagKey<Block> HOPPERS = chronoCircuitsTag("hoppers");
        public static final TagKey<Block> PIPES = chronoCircuitsTag("pipes");
        public static final TagKey<Block> REDSTONE_TORCHES = chronoCircuitsTag("redstone_torches");
        public static final TagKey<Block> REPEATERS = chronoCircuitsTag("repeaters");
        public static final TagKey<Block> COMPARATORS = chronoCircuitsTag("comparators");
        public static final TagKey<Block> GRATED_BLOCKS = chronoCircuitsTag("grated_blocks");

        private static TagKey<Block> chronoCircuitsTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ChronoCircuits.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> REDSTONE_TORCHES = chronoCircuitsTag("redstone_torches");
        public static final TagKey<Item> REPEATERS = chronoCircuitsTag("repeaters");
        public static final TagKey<Item> COMPARATORS = chronoCircuitsTag("comparators");
        public static final TagKey<Item> COPPER_HOPPERS = chronoCircuitsTag("copper_hoppers");
        public static final TagKey<Item> HOPPERS = chronoCircuitsTag("hoppers");
        public static final TagKey<Item> GRATED_ITEMS = chronoCircuitsTag("grated_items");


        private static TagKey<Item> chronoCircuitsTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ChronoCircuits.MODID, name));
        }
    }


}
