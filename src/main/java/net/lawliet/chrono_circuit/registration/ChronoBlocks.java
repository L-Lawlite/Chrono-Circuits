package net.lawliet.chrono_circuit.registration;

import net.lawliet.chrono_circuit.blocks.CopperPressurePlate;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
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

    //blocks
    static {
        COPPER_PRESSURE_PLATE = ChronoRegistries.BLOCKS.registerBlock("player_only_pressure_plate",
                properties -> new CopperPressurePlate(BlockSetType.COPPER,properties),
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.COLOR_ORANGE)
                        .strength(0.5F)
                        .forceSolidOn()
                        .noCollission()
                        .pushReaction(PushReaction.DESTROY)
                        .instrument(NoteBlockInstrument.BASEDRUM)
        );
    }

    //block items
    static {
        COPPER_PRESSURE_PLATE_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem("player_only_pressure_plate",COPPER_PRESSURE_PLATE);
    }

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.accept(COPPER_PRESSURE_PLATE_ITEM);
        }
    }

    public static void init() {}
}
