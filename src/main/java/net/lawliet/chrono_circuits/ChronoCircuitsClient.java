package net.lawliet.chrono_circuits;

import net.lawliet.chrono_circuits.registration.ChronoRegistries;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(value = ChronoCircuits.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = ChronoCircuits.MODID, value = Dist.CLIENT)
public class ChronoCircuitsClient
{
    public ChronoCircuitsClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        // Some client setup code
        ChronoCircuits.LOGGER.info("HELLO FROM CLIENT SETUP");
        ChronoCircuits.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        ChronoRegistries.BLOCKS.getEntries().stream().filter(blockHolder -> blockHolder.getId().getPath().contains("grated")).forEach(block -> ItemBlockRenderTypes.setRenderLayer(block.get(), RenderType.CUTOUT_MIPPED));
    }
}
