package net.lawliet.chrono_circuit.registration;

import net.lawliet.chrono_circuit.blocks.CopperPressurePlate.PlayerPressurePlate;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ChronoBlocks {
    //Player Pressure Plate
    public static final DeferredBlock<Block> COPPER_PRESSURE_PLATE;
    public static final DeferredItem<BlockItem> COPPER_PRESSURE_PLATE_ITEM;

    public static final DeferredBlock<Block> EXPOSED_COPPER_PRESSURE_PLATE;
    public static final DeferredItem<BlockItem> EXPOSED_COPPER_PRESSURE_PLATE_ITEM;

    public static final DeferredBlock<Block> WEATHERED_COPPER_PRESSURE_PLATE;
    public static final DeferredItem<BlockItem> WEATHERED_COPPER_PRESSURE_PLATE_ITEM;

    public static final DeferredBlock<Block> OXIDIZED_COPPER_PRESSURE_PLATE;
    public static final DeferredItem<BlockItem> OXIDIZED_COPPER_PRESSURE_PLATE_ITEM;

    //blocks
    static {
        COPPER_PRESSURE_PLATE = ChronoRegistries.BLOCKS.registerBlock("copper_pressure_plate",
                properties -> new PlayerPressurePlate(WeatheringCopper.WeatherState.UNAFFECTED,BlockSetType.COPPER,properties),
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.COLOR_ORANGE)
                        .strength(0.5F)
                        .forceSolidOn()
                        .noCollission()
                        .pushReaction(PushReaction.DESTROY)
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .sound(SoundType.COPPER)
        );

        EXPOSED_COPPER_PRESSURE_PLATE = ChronoRegistries.BLOCKS.registerBlock("exposed_copper_pressure_plate",
                properties -> new PlayerPressurePlate(WeatheringCopper.WeatherState.EXPOSED,BlockSetType.COPPER,properties,20),
                BlockBehaviour.Properties.of()
                        .strength(0.5F)
                        .forceSolidOn()
                        .noCollission()
                        .pushReaction(PushReaction.DESTROY)
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .sound(SoundType.COPPER)
                        .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
        );

        WEATHERED_COPPER_PRESSURE_PLATE = ChronoRegistries.BLOCKS.registerBlock("weathered_copper_pressure_plate",
                properties -> new PlayerPressurePlate(WeatheringCopper.WeatherState.WEATHERED,BlockSetType.COPPER,properties,40),
                BlockBehaviour.Properties.of()
                        .strength(0.5F)
                        .forceSolidOn()
                        .noCollission()
                        .pushReaction(PushReaction.DESTROY)
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .sound(SoundType.COPPER)
                        .mapColor(MapColor.WARPED_STEM)
        );

        OXIDIZED_COPPER_PRESSURE_PLATE = ChronoRegistries.BLOCKS.registerBlock("oxidized_copper_pressure_plate",
                properties -> new PlayerPressurePlate(WeatheringCopper.WeatherState.OXIDIZED,BlockSetType.COPPER,properties,80),
                BlockBehaviour.Properties.of()
                        .strength(0.5F)
                        .forceSolidOn()
                        .noCollission()
                        .pushReaction(PushReaction.DESTROY)
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .sound(SoundType.COPPER)
                        .mapColor(MapColor.WARPED_NYLIUM)
        );

    }

    //block items
    static {
        COPPER_PRESSURE_PLATE_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem("copper_pressure_plate",COPPER_PRESSURE_PLATE);
        EXPOSED_COPPER_PRESSURE_PLATE_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem("exposed_copper_pressure_plate",EXPOSED_COPPER_PRESSURE_PLATE);
        WEATHERED_COPPER_PRESSURE_PLATE_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem("weathered_copper_pressure_plate",WEATHERED_COPPER_PRESSURE_PLATE);
        OXIDIZED_COPPER_PRESSURE_PLATE_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem("oxidized_copper_pressure_plate",OXIDIZED_COPPER_PRESSURE_PLATE);
    }

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.accept(COPPER_PRESSURE_PLATE_ITEM);
            event.accept(EXPOSED_COPPER_PRESSURE_PLATE_ITEM);
            event.accept(WEATHERED_COPPER_PRESSURE_PLATE_ITEM);
            event.accept(OXIDIZED_COPPER_PRESSURE_PLATE_ITEM);
        }
    }

    public static void init() {}
}
