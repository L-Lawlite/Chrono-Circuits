package net.lawliet.chrono_circuit.datagen;

import com.mojang.logging.LogUtils;
import net.lawliet.chrono_circuit.ChronoCircuits;
import net.lawliet.chrono_circuit.datagen.datamap.DataMapGenerator;
import net.lawliet.chrono_circuit.datagen.lang.LanguageGenerator;
import net.lawliet.chrono_circuit.datagen.model.ModelGenerator;
import net.lawliet.chrono_circuit.datagen.recipes.CraftingRecipeGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.slf4j.Logger;

@EventBusSubscriber(modid = ChronoCircuits.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ClientDatagen {
    private static final Logger LOGGER = LogUtils.getLogger();

    @SubscribeEvent
    public static void generate(GatherDataEvent.Client event) {
        LOGGER.info("Generating Client Files...");
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();

        generator.addProvider(true,new LanguageGenerator(packOutput,"en_us"));
        event.createProvider(ModelGenerator::new);
        event.createProvider(CraftingRecipeGenerator.Runner::new);
        event.createProvider(DataMapGenerator::new);


    }
}
