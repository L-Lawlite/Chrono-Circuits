package net.lawliet.chrono_circuits.datagen.datamap;

import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.lawliet.chrono_circuits.registration.ChronoBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.neoforged.neoforge.registries.datamaps.builtin.Oxidizable;
import net.neoforged.neoforge.registries.datamaps.builtin.Waxable;

import java.util.concurrent.CompletableFuture;

public class DataMapGenerator extends DataMapProvider {
    public DataMapGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        //Oxidizables
        this.builder(NeoForgeDataMaps.OXIDIZABLES)
                .add(
                        ChronoBlocks.COPPER_PRESSURE_PLATE.getDelegate(),
                        new Oxidizable(ChronoBlocks.EXPOSED_COPPER_PRESSURE_PLATE.get()),
                        false
                )
                .add(
                        ChronoBlocks.EXPOSED_COPPER_PRESSURE_PLATE.getDelegate(),
                        new Oxidizable(ChronoBlocks.WEATHERED_COPPER_PRESSURE_PLATE.get()),
                        false
                )
                .add(
                        ChronoBlocks.WEATHERED_COPPER_PRESSURE_PLATE.getDelegate(),
                        new Oxidizable(ChronoBlocks.OXIDIZED_COPPER_PRESSURE_PLATE.get()),
                        false
                )
                .add(
                        ChronoBlocks.COPPER_GRATED_REDSTONE_TORCH.getDelegate(),
                        new Oxidizable(ChronoBlocks.EXPOSED_COPPER_GRATED_REDSTONE_TORCH.get()),
                        false
                )
                .add(
                        ChronoBlocks.COPPER_GRATED_REDSTONE_WALL_TORCH.getDelegate(),
                        new Oxidizable(ChronoBlocks.EXPOSED_COPPER_GRATED_REDSTONE_WALL_TORCH.get()),
                        false
                )
                .add(
                        ChronoBlocks.EXPOSED_COPPER_GRATED_REDSTONE_TORCH.getDelegate(),
                        new Oxidizable(ChronoBlocks.WEATHERED_COPPER_GRATED_REDSTONE_TORCH.get()),
                        false
                )
                .add(
                        ChronoBlocks.EXPOSED_COPPER_GRATED_REDSTONE_WALL_TORCH.getDelegate(),
                        new Oxidizable(ChronoBlocks.WEATHERED_COPPER_GRATED_REDSTONE_WALL_TORCH.get()),
                        false
                )
                .add(
                        ChronoBlocks.WEATHERED_COPPER_GRATED_REDSTONE_TORCH.getDelegate(),
                        new Oxidizable(ChronoBlocks.OXIDIZED_COPPER_GRATED_REDSTONE_TORCH.get()),
                        false
                )
                .add(
                        ChronoBlocks.WEATHERED_COPPER_GRATED_REDSTONE_WALL_TORCH.getDelegate(),
                        new Oxidizable(ChronoBlocks.OXIDIZED_COPPER_GRATED_REDSTONE_WALL_TORCH.get()),
                        false
                )
                .add(ChronoBlockEntityTypes.COPPER_HOPPER_BLOCK.getDelegate(), new Oxidizable(ChronoBlockEntityTypes.EXPOSED_COPPER_HOPPER_BLOCK.get()), false)
                .add(ChronoBlockEntityTypes.EXPOSED_COPPER_HOPPER_BLOCK.getDelegate(), new Oxidizable(ChronoBlockEntityTypes.WEATHERED_COPPER_HOPPER_BLOCK.get()), false)
                .add(ChronoBlockEntityTypes.WEATHERED_COPPER_HOPPER_BLOCK.getDelegate(), new Oxidizable(ChronoBlockEntityTypes.OXIDIZED_COPPER_HOPPER_BLOCK.get()), false)
                .add(ChronoBlocks.COPPER_GRATED_REPEATER.getDelegate(), new Oxidizable(ChronoBlocks.EXPOSED_COPPER_GRATED_REPEATER.get()), false)
                .add(ChronoBlocks.EXPOSED_COPPER_GRATED_REPEATER.getDelegate(), new Oxidizable(ChronoBlocks.WEATHERED_COPPER_GRATED_REPEATER.get()), false)
                .add(ChronoBlocks.WEATHERED_COPPER_GRATED_REPEATER.getDelegate(), new Oxidizable(ChronoBlocks.OXIDIZED_COPPER_GRATED_REPEATER.get()), false)
                .add(ChronoBlockEntityTypes.COPPER_GRATED_COMPARATOR.getDelegate(), new Oxidizable(ChronoBlockEntityTypes.EXPOSED_COPPER_GRATED_COMPARATOR.get()), false)
                .add(ChronoBlockEntityTypes.EXPOSED_COPPER_GRATED_COMPARATOR.getDelegate(), new Oxidizable(ChronoBlockEntityTypes.WEATHERED_COPPER_GRATED_COMPARATOR.get()), false)
                .add(ChronoBlockEntityTypes.WEATHERED_COPPER_GRATED_COMPARATOR.getDelegate(), new Oxidizable(ChronoBlockEntityTypes.OXIDIZED_COPPER_GRATED_COMPARATOR.get()), false)
        ;


        //Waxables
        this.builder(NeoForgeDataMaps.WAXABLES)
                .add(
                        ChronoBlocks.COPPER_PRESSURE_PLATE.getDelegate(),
                        new Waxable(ChronoBlocks.WAXED_COPPER_PRESSURE_PLATE.get()),
                        false
                )
                .add(
                        ChronoBlocks.EXPOSED_COPPER_PRESSURE_PLATE.getDelegate(),
                        new Waxable(ChronoBlocks.WAXED_EXPOSED_COPPER_PRESSURE_PLATE.get()),
                        false
                )
                .add(
                        ChronoBlocks.WEATHERED_COPPER_PRESSURE_PLATE.getDelegate(),
                        new Waxable(ChronoBlocks.WAXED_WEATHERED_COPPER_PRESSURE_PLATE.get()),
                        false
                )
                .add(
                        ChronoBlocks.OXIDIZED_COPPER_PRESSURE_PLATE.getDelegate(),
                        new Waxable(ChronoBlocks.WAXED_OXIDIZED_COPPER_PRESSURE_PLATE.get()),
                        false
                )
                .add(
                        ChronoBlocks.COPPER_GRATED_REDSTONE_TORCH.getDelegate(),
                        new Waxable(ChronoBlocks.WAXED_COPPER_GRATED_REDSTONE_TORCH.get()),
                        false
                )
                .add(
                        ChronoBlocks.EXPOSED_COPPER_GRATED_REDSTONE_TORCH.getDelegate(),
                        new Waxable(ChronoBlocks.WAXED_EXPOSED_COPPER_GRATED_REDSTONE_TORCH.get()),
                        false
                )
                .add(
                        ChronoBlocks.WEATHERED_COPPER_GRATED_REDSTONE_TORCH.getDelegate(),
                        new Waxable(ChronoBlocks.WAXED_WEATHERED_COPPER_GRATED_REDSTONE_TORCH.get()),
                        false
                )
                .add(
                        ChronoBlocks.OXIDIZED_COPPER_GRATED_REDSTONE_TORCH.getDelegate(),
                        new Waxable(ChronoBlocks.WAXED_OXIDIZED_COPPER_GRATED_REDSTONE_TORCH.get()),
                        false
                )
                .add(
                        ChronoBlocks.COPPER_GRATED_REDSTONE_WALL_TORCH.getDelegate(),
                        new Waxable(ChronoBlocks.WAXED_COPPER_GRATED_REDSTONE_WALL_TORCH.get()),
                        false
                )
                .add(
                        ChronoBlocks.EXPOSED_COPPER_GRATED_REDSTONE_WALL_TORCH.getDelegate(),
                        new Waxable(ChronoBlocks.WAXED_EXPOSED_COPPER_GRATED_REDSTONE_WALL_TORCH.get()),
                        false
                )
                .add(
                        ChronoBlocks.WEATHERED_COPPER_GRATED_REDSTONE_WALL_TORCH.getDelegate(),
                        new Waxable(ChronoBlocks.WAXED_WEATHERED_COPPER_GRATED_REDSTONE_WALL_TORCH.get()),
                        false
                )
                .add(
                        ChronoBlocks.OXIDIZED_COPPER_GRATED_REDSTONE_WALL_TORCH.getDelegate(),
                        new Waxable(ChronoBlocks.WAXED_OXIDIZED_COPPER_GRATED_REDSTONE_WALL_TORCH.get()),
                        false
                )
                .add(ChronoBlockEntityTypes.COPPER_HOPPER_BLOCK.getDelegate(), new Waxable(ChronoBlockEntityTypes.WAXED_COPPER_HOPPER_BLOCK.get()), false)
                .add(ChronoBlockEntityTypes.EXPOSED_COPPER_HOPPER_BLOCK.getDelegate(), new Waxable(ChronoBlockEntityTypes.WAXED_EXPOSED_COPPER_HOPPER_BLOCK.get()), false)
                .add(ChronoBlockEntityTypes.WEATHERED_COPPER_HOPPER_BLOCK.getDelegate(), new Waxable(ChronoBlockEntityTypes.WAXED_WEATHERED_COPPER_HOPPER_BLOCK.get()), false)
                .add(ChronoBlockEntityTypes.OXIDIZED_COPPER_HOPPER_BLOCK.getDelegate(), new Waxable(ChronoBlockEntityTypes.WAXED_OXIDIZED_COPPER_HOPPER_BLOCK.get()), false)
                .add(ChronoBlocks.COPPER_GRATED_REPEATER.getDelegate(), new Waxable(ChronoBlocks.WAXED_COPPER_GRATED_REPEATER.get()), false)
                .add(ChronoBlocks.EXPOSED_COPPER_GRATED_REPEATER.getDelegate(), new Waxable(ChronoBlocks.WAXED_EXPOSED_COPPER_GRATED_REPEATER.get()), false)
                .add(ChronoBlocks.WEATHERED_COPPER_GRATED_REPEATER.getDelegate(), new Waxable(ChronoBlocks.WAXED_WEATHERED_COPPER_GRATED_REPEATER.get()), false)
                .add(ChronoBlocks.OXIDIZED_COPPER_GRATED_REPEATER.getDelegate(), new Waxable(ChronoBlocks.WAXED_OXIDIZED_COPPER_GRATED_REPEATER.get()), false)
                .add(ChronoBlockEntityTypes.COPPER_GRATED_COMPARATOR.getDelegate(), new Waxable(ChronoBlockEntityTypes.WAXED_COPPER_GRATED_COMPARATOR.get()), false)
                .add(ChronoBlockEntityTypes.EXPOSED_COPPER_GRATED_COMPARATOR.getDelegate(), new Waxable(ChronoBlockEntityTypes.WAXED_EXPOSED_COPPER_GRATED_COMPARATOR.get()), false)
                .add(ChronoBlockEntityTypes.WEATHERED_COPPER_GRATED_COMPARATOR.getDelegate(), new Waxable(ChronoBlockEntityTypes.WAXED_WEATHERED_COPPER_GRATED_COMPARATOR.get()), false)
                .add(ChronoBlockEntityTypes.OXIDIZED_COPPER_GRATED_COMPARATOR.getDelegate(), new Waxable(ChronoBlockEntityTypes.WAXED_OXIDIZED_COPPER_GRATED_COMPARATOR.get()), false)
        ;
    }
}
