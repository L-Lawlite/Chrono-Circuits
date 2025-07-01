package net.lawliet.chrono_circuits.registration;

import net.lawliet.chrono_circuits.blockEntity.hopper.copperHopper.CopperHopperBlock;
import net.lawliet.chrono_circuits.blockEntity.hopper.copperHopper.CopperHopperBlockEntity;
import net.lawliet.chrono_circuits.blockEntity.hopper.copperHopper.CopperHopperMenu;
import net.lawliet.chrono_circuits.blockEntity.hopper.goldHopper.GoldHopperBlock;
import net.lawliet.chrono_circuits.blockEntity.hopper.goldHopper.GoldHopperBlockEntity;
import net.lawliet.chrono_circuits.blockEntity.hopper.goldHopper.GoldHopperMenu;
import net.lawliet.chrono_circuits.blockEntity.hopper.pipe.PipeBlock;
import net.lawliet.chrono_circuits.blockEntity.hopper.pipe.PipeBlockEntity;
import net.lawliet.chrono_circuits.blockEntity.hopper.pipe.PipeMenu;
import net.lawliet.chrono_circuits.blockEntity.lightDetector.LightDetectorBlock;
import net.lawliet.chrono_circuits.blockEntity.lightDetector.LightDetectorBlockEntity;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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

    public static final DeferredBlock<Block> EXPOSED_COPPER_HOPPER_BLOCK;
    public static final DeferredItem<BlockItem> EXPOSED_COPPER_HOPPER_BLOCK_ITEM;

    public static final DeferredBlock<Block> WEATHERED_COPPER_HOPPER_BLOCK;
    public static final DeferredItem<BlockItem> WEATHERED_COPPER_HOPPER_BLOCK_ITEM;

    public static final DeferredBlock<Block> OXIDIZED_COPPER_HOPPER_BLOCK;
    public static final DeferredItem<BlockItem> OXIDIZED_COPPER_HOPPER_BLOCK_ITEM;

    public static final DeferredBlock<Block> GOLD_HOPPER_BLOCK;
    public static final DeferredItem<BlockItem> GOLD_HOPPER_BLOCK_ITEM;

    public static final DeferredBlock<Block> PIPE_BLOCK;
    public static final DeferredItem<BlockItem> PIPE_BLOCK_ITEM;

    public static final Supplier<BlockEntityType<CopperHopperBlockEntity>> COPPER_HOPPER_BLOCK_ENTITY;
    public static final Supplier<MenuType<CopperHopperMenu>> COPPER_HOPPER_MENU;

    public static final Supplier<BlockEntityType<GoldHopperBlockEntity>> GOLD_HOPPER_BLOCK_ENTITY;
    public static final Supplier<MenuType<GoldHopperMenu>> GOLD_HOPPER_MENU;

    public static final Supplier<BlockEntityType<PipeBlockEntity>> PIPE_BLOCK_ENTITY;
    public static final Supplier<MenuType<PipeMenu>> PIPE_MENU;


    static {
        LIGHT_DETECTOR_BLOCK = ChronoRegistries.BLOCKS.registerBlock(
                "light_detector",
                LightDetectorBlock::new,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.QUARTZ)
                        .strength(0.2F)
                        .instrument(NoteBlockInstrument.BASS)
                        .sound(SoundType.WOOD)
                        .ignitedByLava()
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
        EXPOSED_COPPER_HOPPER_BLOCK = ChronoRegistries.BLOCKS.registerBlock(
                "exposed_copper_hopper",
                CopperHopperBlock::new,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                        .requiresCorrectToolForDrops()
                        .strength(3.0F,4.8F)
                        .noOcclusion()
                        .sound(SoundType.COPPER)
        );
        WEATHERED_COPPER_HOPPER_BLOCK = ChronoRegistries.BLOCKS.registerBlock(
                "weathered_copper_hopper",
                CopperHopperBlock::new,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.WARPED_STEM)
                        .requiresCorrectToolForDrops()
                        .strength(3.0F,4.8F)
                        .noOcclusion()
                        .sound(SoundType.COPPER)
        );
        OXIDIZED_COPPER_HOPPER_BLOCK = ChronoRegistries.BLOCKS.registerBlock(
                "oxidized_copper_hopper",
                CopperHopperBlock::new,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.WARPED_NYLIUM)
                        .requiresCorrectToolForDrops()
                        .strength(3.0F,4.8F)
                        .noOcclusion()
                        .sound(SoundType.COPPER)
        );
        GOLD_HOPPER_BLOCK = ChronoRegistries.BLOCKS.registerBlock(
                "gold_hopper",
                GoldHopperBlock::new,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.GOLD)
                        .requiresCorrectToolForDrops()
                        .strength(3.0F,4.8F)
                        .noOcclusion()
        );
        PIPE_BLOCK = ChronoRegistries.BLOCKS.registerBlock(
                "pipe",
                PipeBlock::new,
                BlockBehaviour.Properties.ofFullCopy(Blocks.HOPPER)
        );
    }

    static {
        LIGHT_DETECTOR_BLOCK_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(LIGHT_DETECTOR_BLOCK);
        COPPER_HOPPER_BLOCK_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(COPPER_HOPPER_BLOCK);
        EXPOSED_COPPER_HOPPER_BLOCK_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(EXPOSED_COPPER_HOPPER_BLOCK);
        WEATHERED_COPPER_HOPPER_BLOCK_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(WEATHERED_COPPER_HOPPER_BLOCK);
        OXIDIZED_COPPER_HOPPER_BLOCK_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(OXIDIZED_COPPER_HOPPER_BLOCK);
        GOLD_HOPPER_BLOCK_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(GOLD_HOPPER_BLOCK);
        PIPE_BLOCK_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(PIPE_BLOCK);

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
                        COPPER_HOPPER_BLOCK.get(),
                        EXPOSED_COPPER_HOPPER_BLOCK.get(),
                        WEATHERED_COPPER_HOPPER_BLOCK.get(),
                        OXIDIZED_COPPER_HOPPER_BLOCK.get()
                )
        );
        GOLD_HOPPER_BLOCK_ENTITY = ChronoRegistries.BLOCK_ENTITY_TYPES.register(
                "gold_hopper_block_entity",
                () -> new BlockEntityType<>(
                        GoldHopperBlockEntity::new,
                        GOLD_HOPPER_BLOCK.get()
                        )
        );
        PIPE_BLOCK_ENTITY = ChronoRegistries.BLOCK_ENTITY_TYPES.register(
                "pipe",
                () -> new BlockEntityType<>(
                        PipeBlockEntity::new,
                        PIPE_BLOCK.get()
                )
        );
    }

    //MENU
    static {
        COPPER_HOPPER_MENU = ChronoRegistries.MENU_TYPES.register("copper_hopper_menu", () -> new MenuType<>(CopperHopperMenu::new, FeatureFlags.DEFAULT_FLAGS));
        GOLD_HOPPER_MENU = ChronoRegistries.MENU_TYPES.register("gold_hopper_menu", () -> new MenuType<>(GoldHopperMenu::new, FeatureFlags.DEFAULT_FLAGS));
        PIPE_MENU = ChronoRegistries.MENU_TYPES.register("pipe_menu", () -> new MenuType<>(PipeMenu::new, FeatureFlags.DEFAULT_FLAGS));
    }

    public static void addCreative(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        output.accept(LIGHT_DETECTOR_BLOCK_ITEM);
        output.accept(COPPER_HOPPER_BLOCK_ITEM);
        output.accept(EXPOSED_COPPER_HOPPER_BLOCK_ITEM);
        output.accept(WEATHERED_COPPER_HOPPER_BLOCK_ITEM);
        output.accept(OXIDIZED_COPPER_HOPPER_BLOCK_ITEM);
        output.accept(GOLD_HOPPER_BLOCK_ITEM);
        output.accept(PIPE_BLOCK_ITEM);
    }
}
