package net.lawliet.chrono_circuit.registration;

import net.lawliet.chrono_circuit.blockEntity.hopper.copperHopper.CopperHopperBlock;
import net.lawliet.chrono_circuit.blockEntity.hopper.copperHopper.CopperHopperBlockEntity;
import net.lawliet.chrono_circuit.blockEntity.hopper.copperHopper.CopperHopperMenu;
import net.lawliet.chrono_circuit.blockEntity.lightDetector.LightDetectorBlock;
import net.lawliet.chrono_circuit.blockEntity.lightDetector.LightDetectorBlockEntity;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.function.Supplier;

public class ChronoBlockEntityTypes {
    public static void init() {
    }


    public static final DeferredBlock<Block> LIGHT_DETECTOR_BLOCK;
    public static final DeferredItem<BlockItem> LIGHT_DETECTOR_BLOCK_ITEM;
    public static final Supplier<BlockEntityType<LightDetectorBlockEntity>> LIGHT_DETECTOR_BLOCK_ENTITY;

    public static final DeferredBlock<Block> COPPER_HOPPER_BLOCK;
    public static final DeferredItem<BlockItem> COPPER_HOPPER_BLOCK_ITEM;
    public static final Supplier<BlockEntityType<CopperHopperBlockEntity>> COPPER_HOPPER_BLOCK_ENTITY;
    public static final Supplier<MenuType<CopperHopperMenu>> COPPER_HOPPER_MENU;

    static {
        LIGHT_DETECTOR_BLOCK = ChronoRegistries.BLOCKS.registerBlock(
                "light_detector",
                LightDetectorBlock::new,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.QUARTZ)
                        .strength(0.2F)
                        .instrument(NoteBlockInstrument.BASS)
                        .sound(SoundType.CREAKING_HEART)
        );
        COPPER_HOPPER_BLOCK = ChronoRegistries.BLOCKS.registerBlock(
                "copper_hopper",
                CopperHopperBlock::new,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.COLOR_ORANGE)
                        .requiresCorrectToolForDrops()
                        .strength(3.0F,4.8F)
                        .noOcclusion()
                        .sound(SoundType.COPPER)
        );
    }

    static {
        LIGHT_DETECTOR_BLOCK_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(LIGHT_DETECTOR_BLOCK);
        COPPER_HOPPER_BLOCK_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(COPPER_HOPPER_BLOCK);
    }

    static {
        LIGHT_DETECTOR_BLOCK_ENTITY = ChronoRegistries.BLOCK_ENTITY_TYPES.register(
                "light_detector_block_entity",
                () -> new BlockEntityType<>(
                        LightDetectorBlockEntity::new,
                        LIGHT_DETECTOR_BLOCK.get()

                )
        );
        COPPER_HOPPER_BLOCK_ENTITY = ChronoRegistries.BLOCK_ENTITY_TYPES.register(
                "copper_hopper_block_entity",
                () -> new BlockEntityType<>(
                        CopperHopperBlockEntity::new,
                        COPPER_HOPPER_BLOCK.get()
                )
        );
    }

    //MENU
    static {
        COPPER_HOPPER_MENU = ChronoRegistries.MENU_TYPES.register("copper_hopper_menu", () -> new MenuType<>(CopperHopperMenu::new, FeatureFlags.DEFAULT_FLAGS));

    }
}
