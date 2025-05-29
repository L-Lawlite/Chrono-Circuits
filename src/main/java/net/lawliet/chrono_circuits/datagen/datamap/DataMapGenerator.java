package net.lawliet.chrono_circuits.datagen.datamap;

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
        ;
    }
}
