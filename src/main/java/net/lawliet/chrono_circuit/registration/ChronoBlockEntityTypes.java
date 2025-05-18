package net.lawliet.chrono_circuit.registration;

import net.lawliet.chrono_circuit.blockEntity.lightDetector.LightDetectorBlock;
import net.lawliet.chrono_circuit.blockEntity.lightDetector.LightDetectorBlockEntity;
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
    }

    static {
        LIGHT_DETECTOR_BLOCK_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(LIGHT_DETECTOR_BLOCK);
    }

    static {
        LIGHT_DETECTOR_BLOCK_ENTITY = ChronoRegistries.BLOCK_ENTITY_TYPES.register(
                "light_detector_block_entity",
                () -> new BlockEntityType<>(
                        LightDetectorBlockEntity::new,
                        LIGHT_DETECTOR_BLOCK.get()

                )
        );
    }
}
