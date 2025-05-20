package net.lawliet.chrono_circuit.datagen.lang;

import net.lawliet.chrono_circuit.ChronoCircuits;
import net.lawliet.chrono_circuit.registration.ChronoBlockEntityTypes;
import net.lawliet.chrono_circuit.registration.ChronoBlocks;
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
    }
}
