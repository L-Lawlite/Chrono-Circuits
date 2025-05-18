package net.lawliet.chrono_circuit.datagen.lang;

import net.lawliet.chrono_circuit.ChronoCircuits;
import net.lawliet.chrono_circuit.registration.ChronoBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class LanguageGenerator extends LanguageProvider {


    public LanguageGenerator(PackOutput packOutput, String lang) {
        super(packOutput, ChronoCircuits.MODID,lang);
    }

    @Override
    protected void addTranslations() {
        this.addBlock(ChronoBlocks.COPPER_PRESSURE_PLATE,"Player Only Pressure Plate");
//        this.addItem(ChronoBlocks.COPPER_PRESSURE_PLATE_ITEM,"Player Only Pressure Plate");
    }
}
