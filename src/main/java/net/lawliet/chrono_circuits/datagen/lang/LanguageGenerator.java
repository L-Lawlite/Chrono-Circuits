package net.lawliet.chrono_circuits.datagen.lang;

import net.lawliet.chrono_circuits.ChronoCircuits;
import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.lawliet.chrono_circuits.registration.ChronoBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.function.Supplier;

public class LanguageGenerator extends LanguageProvider {


    public LanguageGenerator(PackOutput packOutput, String lang) {
        super(packOutput, ChronoCircuits.MODID,lang);
    }

    @Override
    protected void addTranslations() {
        this.addBlock(ChronoBlocks.COPPER_PRESSURE_PLATE,"Copper Pressure Plate");
        this.addBlock(ChronoBlocks.EXPOSED_COPPER_PRESSURE_PLATE,"Exposed Copper Pressure Plate");
        this.addBlock(ChronoBlocks.WEATHERED_COPPER_PRESSURE_PLATE,"Weathered Copper Pressure Plate");
        this.addBlock(ChronoBlocks.OXIDIZED_COPPER_PRESSURE_PLATE,"Oxidized Copper Pressure Plate");
        this.addBlock(ChronoBlocks.WAXED_COPPER_PRESSURE_PLATE,"Waxed Copper Pressure Plate");
        this.addBlock(ChronoBlocks.WAXED_EXPOSED_COPPER_PRESSURE_PLATE,"Waxed Exposed Copper Pressure Plate");
        this.addBlock(ChronoBlocks.WAXED_WEATHERED_COPPER_PRESSURE_PLATE,"Waxed Weathered Copper Pressure Plate");


        this.addBlock(ChronoBlockEntityTypes.LIGHT_DETECTOR_BLOCK,"Light Detector");


       HopperHelper(ChronoBlockEntityTypes.COPPER_HOPPER_BLOCK,"Copper Hopper");
       HopperHelper(ChronoBlockEntityTypes.EXPOSED_COPPER_HOPPER_BLOCK,"Exposed Copper Hopper");
       HopperHelper(ChronoBlockEntityTypes.WEATHERED_COPPER_HOPPER_BLOCK,"Weathered Copper Hopper");
       HopperHelper(ChronoBlockEntityTypes.OXIDIZED_COPPER_HOPPER_BLOCK,"Oxidized Copper Hopper");
       HopperHelper(ChronoBlockEntityTypes.GOLD_HOPPER_BLOCK,"Gold Hopper");

    }

    private void HopperHelper(Supplier<? extends Block> key, String name) {
        this.addBlock(key,name);
        this.add(BuiltInRegistries.BLOCK.getKey(key.get()).toLanguageKey("container"),name);
    }
}
