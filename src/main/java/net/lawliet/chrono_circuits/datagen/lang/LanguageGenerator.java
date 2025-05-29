package net.lawliet.chrono_circuits.datagen.lang;

import net.lawliet.chrono_circuits.ChronoCircuits;
import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.lawliet.chrono_circuits.registration.ChronoBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

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


        this.addBlock(ChronoBlockEntityTypes.COPPER_HOPPER_BLOCK,"Copper Hopper");
        this.addBlock(ChronoBlockEntityTypes.EXPOSED_COPPER_HOPPER_BLOCK,"Exposed Copper Hopper");
        this.addBlock(ChronoBlockEntityTypes.WEATHERED_COPPER_HOPPER_BLOCK,"Weathered Copper Hopper");
        this.addBlock(ChronoBlockEntityTypes.OXIDIZED_COPPER_HOPPER_BLOCK,"Oxidized Copper Hopper");
        this.add(BuiltInRegistries.BLOCK.getKey(ChronoBlockEntityTypes.COPPER_HOPPER_BLOCK.get()).toLanguageKey("container"),"Copper Hopper");
        this.add(BuiltInRegistries.BLOCK.getKey(ChronoBlockEntityTypes.EXPOSED_COPPER_HOPPER_BLOCK.get()).toLanguageKey("container"),"Exposed Copper Hopper");
        this.add(BuiltInRegistries.BLOCK.getKey(ChronoBlockEntityTypes.WEATHERED_COPPER_HOPPER_BLOCK.get()).toLanguageKey("container"),"Weathered Copper Hopper");
        this.add(BuiltInRegistries.BLOCK.getKey(ChronoBlockEntityTypes.OXIDIZED_COPPER_HOPPER_BLOCK.get()).toLanguageKey("container"),"Oxidized Copper Hopper");

    }
}
