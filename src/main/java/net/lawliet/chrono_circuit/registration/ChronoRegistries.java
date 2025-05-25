package net.lawliet.chrono_circuit.registration;

import net.lawliet.chrono_circuit.ChronoCircuits;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ChronoRegistries {

    // Create a Deferred Register to hold Blocks which will all be registered under the "chrono_circuits" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ChronoCircuits.MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "chrono_circuits" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ChronoCircuits.MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "chrono_circuits" namespace
    public static final DeferredRegister<CreativeModeTab> CHRONO_CIRCUITS_MOD_TAB = DeferredRegister.create(net.minecraft.core.registries.Registries.CREATIVE_MODE_TAB, ChronoCircuits.MODID);

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE,ChronoCircuits.MODID);

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU,ChronoCircuits.MODID);


    public static void init(IEventBus modEventBus) {
        ChronoBlocks.init();
        ChronoBlockEntityTypes.init();

        modEventBus.addListener(ChronoBlocks::addCreative);

        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CHRONO_CIRCUITS_MOD_TAB.register(modEventBus);

        BLOCK_ENTITY_TYPES.register(modEventBus);

        MENU_TYPES.register(modEventBus);
    }

}
