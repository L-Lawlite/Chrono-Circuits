package net.lawliet.chrono_circuits.events;

import net.lawliet.chrono_circuits.ChronoCircuits;
import net.lawliet.chrono_circuits.blockEntity.hopper.copperHopper.CopperHopperScreen;
import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = ChronoCircuits.MODID, bus = EventBusSubscriber.Bus.MOD)
public class RegisterScreen {
    @SubscribeEvent
    public static void registerScreen(RegisterMenuScreensEvent event) {
        event.register(ChronoBlockEntityTypes.COPPER_HOPPER_MENU.get(), CopperHopperScreen::new);
    }
}
