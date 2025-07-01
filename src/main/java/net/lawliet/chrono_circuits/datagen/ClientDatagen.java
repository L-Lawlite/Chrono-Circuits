package net.lawliet.chrono_circuits.datagen;

import com.mojang.logging.LogUtils;
import net.lawliet.chrono_circuits.ChronoCircuits;
import net.lawliet.chrono_circuits.datagen.Tags.BlockTags.ChronoCircuitsBlockTagProvider;
import net.lawliet.chrono_circuits.datagen.datamap.DataMapGenerator;
import net.lawliet.chrono_circuits.datagen.lang.LanguageGenerator;
import net.lawliet.chrono_circuits.datagen.lootTables.ChronoCircuitsLootTableSubProvider;
import net.lawliet.chrono_circuits.datagen.model.ModelGenerator;
import net.lawliet.chrono_circuits.datagen.recipes.CraftingRecipeGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.slf4j.Logger;

import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = ChronoCircuits.MODID)
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


        event.createProvider((output,lookupProvider) -> new LootTableProvider(
                output,
                Set.of(),
                List.of(
                    new LootTableProvider.SubProviderEntry(
                            ChronoCircuitsLootTableSubProvider::new,
                            LootContextParamSets.BLOCK
                    )
                ),
                lookupProvider
        ));

        event.createProvider(ChronoCircuitsBlockTagProvider::new);


    }
}
