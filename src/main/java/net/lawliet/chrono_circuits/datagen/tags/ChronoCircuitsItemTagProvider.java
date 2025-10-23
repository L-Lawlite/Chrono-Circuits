package net.lawliet.chrono_circuits.datagen.tags;

import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
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

        this.copy(ChronoCircuitsTags.Blocks.HOPPERS, ChronoCircuitsTags.Items.HOPPERS);
        this.copy(ChronoCircuitsTags.Blocks.COPPER_HOPPERS, ChronoCircuitsTags.Items.COPPER_HOPPERS);
        this.copy(ChronoCircuitsTags.Blocks.REPEATERS, ChronoCircuitsTags.Items.REPEATERS);
        this.copy(ChronoCircuitsTags.Blocks.COMPARATORS, ChronoCircuitsTags.Items.COMPARATORS);

        this.tag(ChronoCircuitsTags.Items.GRATED_ITEMS)
                .add(ChronoBlocks.COPPER_GRATED_REDSTONE_TORCH_ITEM.get())
                .add(ChronoBlocks.EXPOSED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get())
                .add(ChronoBlocks.WEATHERED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get())
                .add(ChronoBlocks.OXIDIZED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get())
                .add(ChronoBlocks.WAXED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get())
                .add(ChronoBlocks.WAXED_EXPOSED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get())
                .add(ChronoBlocks.WAXED_WEATHERED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get())
                .add(ChronoBlocks.WAXED_OXIDIZED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get())
                .add(ChronoBlocks.COPPER_GRATED_REPEATER_ITEM.get())
                .add(ChronoBlocks.EXPOSED_COPPER_GRATED_REPEATER_ITEM.get())
                .add(ChronoBlocks.WEATHERED_COPPER_GRATED_REPEATER_ITEM.get())
                .add(ChronoBlocks.OXIDIZED_COPPER_GRATED_REPEATER_ITEM.get())
                .add(ChronoBlocks.WAXED_COPPER_GRATED_REPEATER_ITEM.get())
                .add(ChronoBlocks.WAXED_EXPOSED_COPPER_GRATED_REPEATER_ITEM.get())
                .add(ChronoBlocks.WAXED_WEATHERED_COPPER_GRATED_REPEATER_ITEM.get())
                .add(ChronoBlocks.WAXED_OXIDIZED_COPPER_GRATED_REPEATER_ITEM.get())
                .add(ChronoBlockEntityTypes.COPPER_GRATED_COMPARATOR_ITEM.get())
                .add(ChronoBlockEntityTypes.EXPOSED_COPPER_GRATED_COMPARATOR_ITEM.get())
                .add(ChronoBlockEntityTypes.WEATHERED_COPPER_GRATED_COMPARATOR_ITEM.get())
                .add(ChronoBlockEntityTypes.OXIDIZED_COPPER_GRATED_COMPARATOR_ITEM.get())
                .add(ChronoBlockEntityTypes.WAXED_COPPER_GRATED_COMPARATOR_ITEM.get())
                .add(ChronoBlockEntityTypes.WAXED_EXPOSED_COPPER_GRATED_COMPARATOR_ITEM.get())
                .add(ChronoBlockEntityTypes.WAXED_WEATHERED_COPPER_GRATED_COMPARATOR_ITEM.get())
                .add(ChronoBlockEntityTypes.WAXED_OXIDIZED_COPPER_GRATED_COMPARATOR_ITEM.get());

    }
}
