package net.lawliet.chrono_circuits.datagen;

import com.mojang.logging.LogUtils;
import net.lawliet.chrono_circuits.ChronoCircuits;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.slf4j.Logger;

@EventBusSubscriber(modid = ChronoCircuits.MODID)
public class ServerDatagen {
    private static final Logger LOGGER = LogUtils.getLogger();

    @SubscribeEvent
    public static void generate(GatherDataEvent.Server event) {
        LOGGER.info("Generating Server Files...");


    }
}
