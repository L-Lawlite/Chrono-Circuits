package net.lawliet.chrono_circuits.events;

import net.lawliet.chrono_circuits.ChronoCircuits;
import net.lawliet.chrono_circuits.blockEntity.hopper.copperHopper.CopperHopperScreen;
import net.lawliet.chrono_circuits.blockEntity.hopper.goldHopper.GoldHopperScreen;
import net.lawliet.chrono_circuits.blockEntity.hopper.pipe.PipeScreen;
import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = ChronoCircuits.MODID)
public class RegisterScreen {
    @SubscribeEvent
    public static void registerScreen(RegisterMenuScreensEvent event) {
        event.register(ChronoBlockEntityTypes.COPPER_HOPPER_MENU.get(), CopperHopperScreen::new);
        event.register(ChronoBlockEntityTypes.GOLD_HOPPER_MENU.get(), GoldHopperScreen::new);
        event.register(ChronoBlockEntityTypes.PIPE_MENU.get(), PipeScreen::new);

    }
}
