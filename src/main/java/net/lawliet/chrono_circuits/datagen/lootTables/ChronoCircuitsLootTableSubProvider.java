package net.lawliet.chrono_circuits.datagen.lootTables;

import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.lawliet.chrono_circuits.registration.ChronoBlocks;
import net.lawliet.chrono_circuits.registration.ChronoRegistries;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ChronoCircuitsLootTableSubProvider extends BlockLootSubProvider {
    public ChronoCircuitsLootTableSubProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS,provider);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ChronoRegistries.BLOCKS.getEntries().stream().map(e -> (Block)e.value()).toList();
    }

    @Override
    protected void generate() {
        this.dropSelf(ChronoBlocks.COPPER_PRESSURE_PLATE.get());
        this.dropSelf(ChronoBlocks.EXPOSED_COPPER_PRESSURE_PLATE.get());
        this.dropSelf(ChronoBlocks.WEATHERED_COPPER_PRESSURE_PLATE.get());
        this.dropSelf(ChronoBlocks.OXIDIZED_COPPER_PRESSURE_PLATE.get());
        this.dropSelf(ChronoBlocks.WAXED_COPPER_PRESSURE_PLATE.get());
        this.dropSelf(ChronoBlocks.WAXED_EXPOSED_COPPER_PRESSURE_PLATE.get());
        this.dropSelf(ChronoBlocks.WAXED_WEATHERED_COPPER_PRESSURE_PLATE.get());
        this.dropSelf(ChronoBlockEntityTypes.LIGHT_DETECTOR_BLOCK.get());
        this.dropSelf(ChronoBlockEntityTypes.COPPER_HOPPER_BLOCK.get());
        this.dropSelf(ChronoBlockEntityTypes.EXPOSED_COPPER_HOPPER_BLOCK.get());
        this.dropSelf(ChronoBlockEntityTypes.WEATHERED_COPPER_HOPPER_BLOCK.get());
        this.dropSelf(ChronoBlockEntityTypes.OXIDIZED_COPPER_HOPPER_BLOCK.get());
        this.dropSelf(ChronoBlockEntityTypes.GOLD_HOPPER_BLOCK.get());
        this.dropSelf(ChronoBlockEntityTypes.PIPE_BLOCK.get());


    }
}
