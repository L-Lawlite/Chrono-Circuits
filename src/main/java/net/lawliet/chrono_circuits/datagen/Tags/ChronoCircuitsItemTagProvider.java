package net.lawliet.chrono_circuits.datagen.Tags;

import net.lawliet.chrono_circuits.registration.ChronoBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ChronoCircuitsItemTagProvider extends ItemTagsProvider {
    public ChronoCircuitsItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ChronoCircuitsTags.Items.REDSTONE_TORCHES)
                .add(ChronoBlocks.COPPER_GRATED_REDSTONE_TORCH_ITEM.get())
                .add(ChronoBlocks.EXPOSED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get())
                .add(ChronoBlocks.WEATHERED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get())
                .add(ChronoBlocks.OXIDIZED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get())
                .add(ChronoBlocks.WAXED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get())
                .add(ChronoBlocks.WAXED_EXPOSED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get())
                .add(ChronoBlocks.WAXED_WEATHERED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get())
                .add(ChronoBlocks.WAXED_OXIDIZED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get());
    }
}
