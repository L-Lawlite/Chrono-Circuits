package net.lawliet.chrono_circuits.datagen.Tags.BlockTags;

import net.lawliet.chrono_circuits.ChronoCircuits;
import net.lawliet.chrono_circuits.datagen.Tags.ChronoCircuitsTags;
import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.lawliet.chrono_circuits.registration.ChronoBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ChronoCircuitsBlockTagProvider extends BlockTagsProvider {
    public ChronoCircuitsBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, ChronoCircuits.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ChronoCircuitsTags.Blocks.PRESSURE_PLATES)
                .add(ChronoBlocks.COPPER_PRESSURE_PLATE.get())
                .add(ChronoBlocks.EXPOSED_COPPER_PRESSURE_PLATE.get())
                .add(ChronoBlocks.WEATHERED_COPPER_PRESSURE_PLATE.get())
                .add(ChronoBlocks.OXIDIZED_COPPER_PRESSURE_PLATE.get())
                .add(ChronoBlocks.WAXED_COPPER_PRESSURE_PLATE.get())
                .add(ChronoBlocks.WAXED_EXPOSED_COPPER_PRESSURE_PLATE.get())
                .add(ChronoBlocks.WAXED_WEATHERED_COPPER_PRESSURE_PLATE.get());

        this.tag(ChronoCircuitsTags.Blocks.HOPPERS)
                .add(ChronoBlockEntityTypes.COPPER_HOPPER_BLOCK.get())
                .add(ChronoBlockEntityTypes.EXPOSED_COPPER_HOPPER_BLOCK.get())
                .add(ChronoBlockEntityTypes.WEATHERED_COPPER_HOPPER_BLOCK.get())
                .add(ChronoBlockEntityTypes.OXIDIZED_COPPER_HOPPER_BLOCK.get())
                .add(ChronoBlockEntityTypes.GOLD_HOPPER_BLOCK.get());

        this.tag(ChronoCircuitsTags.Blocks.PIPES)
                .add(ChronoBlockEntityTypes.PIPE_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(ChronoCircuitsTags.Blocks.PRESSURE_PLATES)
                .addTag(ChronoCircuitsTags.Blocks.HOPPERS)
                .addTag(ChronoCircuitsTags.Blocks.PIPES);

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ChronoBlockEntityTypes.LIGHT_DETECTOR_BLOCK.get());

        this.tag(BlockTags.WALL_POST_OVERRIDE)
                .addTag(ChronoCircuitsTags.Blocks.PRESSURE_PLATES);


        this.tag(BlockTags.PRESSURE_PLATES)
                .addTag(ChronoCircuitsTags.Blocks.PRESSURE_PLATES);

    }
}
