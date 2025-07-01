package net.lawliet.chrono_circuits.registration;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ChronoCreativeModeTabs {
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CHRONO_CIRCUITS_TAB ;

    static {
        CHRONO_CIRCUITS_TAB = ChronoRegistries.CHRONO_CIRCUITS_MOD_TAB.register("chrono_circuits_tab", () -> CreativeModeTab.builder()
                        .title(Component.translatable("itemGroup.chrono_circuits"))
                        .icon(() -> ChronoBlockEntityTypes.COPPER_HOPPER_BLOCK_ITEM.get().getDefaultInstance())
                        .displayItems(ChronoCreativeModeTabs::addCreative)
                        .build()
                );
    }

    public static void init() {}

    public static void addCreative(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        ChronoBlocks.addCreative(parameters,output);
        ChronoBlockEntityTypes.addCreative(parameters,output);
    }
}
