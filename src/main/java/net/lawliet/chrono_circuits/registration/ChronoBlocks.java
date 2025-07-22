package net.lawliet.chrono_circuits.registration;

import net.lawliet.chrono_circuits.blocks.CopperPressurePlate.PlayerPressurePlate;
import net.lawliet.chrono_circuits.blocks.CopperPressurePlate.WeatheringPlayerPressurePlate;
import net.lawliet.chrono_circuits.blocks.gratedBlocks.torch.CopperGratedTorch;
import net.lawliet.chrono_circuits.blocks.gratedBlocks.repeater.CopperGratedRepeater;
import net.lawliet.chrono_circuits.blocks.gratedBlocks.torch.CopperGratedWallTorch;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
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

    public static final DeferredBlock<Block> WAXED_COPPER_PRESSURE_PLATE;
    public static final DeferredItem<BlockItem> WAXED_COPPER_PRESSURE_PLATE_ITEM;

    public static final DeferredBlock<Block> WAXED_EXPOSED_COPPER_PRESSURE_PLATE;
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_COPPER_PRESSURE_PLATE_ITEM;

    public static final DeferredBlock<Block> WAXED_WEATHERED_COPPER_PRESSURE_PLATE;
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_COPPER_PRESSURE_PLATE_ITEM;

    public static final DeferredBlock<Block> COPPER_GRATED_REPEATER;
    public static final DeferredItem<BlockItem> COPPER_GRATED_REPEATER_ITEM;


    public static final DeferredBlock<Block> COPPER_GRATED_TORCH;
    public static final DeferredBlock<Block> COPPER_GRATED_WALL_TORCH;
    public static final DeferredItem<BlockItem> COPPER_GRATED_TORCH_ITEM;

    //blocks
    static {
        COPPER_PRESSURE_PLATE = ChronoRegistries.BLOCKS.registerBlock("copper_pressure_plate",
                properties -> new WeatheringPlayerPressurePlate(WeatheringCopper.WeatherState.UNAFFECTED,BlockSetType.COPPER,properties),
                copperPressurePlateDefaultProperties()
                        .mapColor(MapColor.COLOR_ORANGE)
        );

        EXPOSED_COPPER_PRESSURE_PLATE = ChronoRegistries.BLOCKS.registerBlock("exposed_copper_pressure_plate",
                properties -> new WeatheringPlayerPressurePlate(WeatheringCopper.WeatherState.EXPOSED,BlockSetType.COPPER,properties,40),
                copperPressurePlateDefaultProperties()
                        .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
        );

        WEATHERED_COPPER_PRESSURE_PLATE = ChronoRegistries.BLOCKS.registerBlock("weathered_copper_pressure_plate",
                properties -> new WeatheringPlayerPressurePlate(WeatheringCopper.WeatherState.WEATHERED,BlockSetType.COPPER,properties,80),
                copperPressurePlateDefaultProperties()
                        .mapColor(MapColor.WARPED_STEM)
        );

        OXIDIZED_COPPER_PRESSURE_PLATE = ChronoRegistries.BLOCKS.registerBlock("oxidized_copper_pressure_plate",
                properties -> new WeatheringPlayerPressurePlate(WeatheringCopper.WeatherState.OXIDIZED,BlockSetType.COPPER,properties,160),
                copperPressurePlateDefaultProperties()
                        .mapColor(MapColor.WARPED_NYLIUM)
        );

        WAXED_COPPER_PRESSURE_PLATE = ChronoRegistries.BLOCKS.registerBlock("waxed_copper_pressure_plate",
                properties -> new PlayerPressurePlate(BlockSetType.COPPER,properties),
                copperPressurePlateDefaultProperties()
                        .mapColor(MapColor.COLOR_ORANGE)
                );
        WAXED_EXPOSED_COPPER_PRESSURE_PLATE = ChronoRegistries.BLOCKS.registerBlock("waxed_exposed_copper_pressure_plate",
                properties -> new PlayerPressurePlate(BlockSetType.COPPER,properties,40),
                copperPressurePlateDefaultProperties()
                        .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                );
        WAXED_WEATHERED_COPPER_PRESSURE_PLATE = ChronoRegistries.BLOCKS.registerBlock("waxed_weathered_copper_pressure_plate",
                properties -> new PlayerPressurePlate(BlockSetType.COPPER,properties,80),
                copperPressurePlateDefaultProperties()
                        .mapColor(MapColor.WARPED_STEM)
                );
        COPPER_GRATED_REPEATER = ChronoRegistries.BLOCKS.registerBlock("copper_grated_repeater",
                CopperGratedRepeater::new,
                BlockBehaviour.Properties.of().instabreak().sound(SoundType.COPPER).pushReaction(PushReaction.DESTROY)
                );
        COPPER_GRATED_TORCH = ChronoRegistries.BLOCKS.registerBlock("copper_grated_torch",
                properties -> new CopperGratedTorch(ParticleTypes.FLAME, properties),
                BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel(p_220871_ -> 14).sound(SoundType.COPPER).pushReaction(PushReaction.DESTROY)
                );
        COPPER_GRATED_WALL_TORCH = ChronoRegistries.BLOCKS.registerBlock("copper_grated_wall_torch",
                properties -> new CopperGratedWallTorch(ParticleTypes.FLAME, wallVariant(COPPER_GRATED_TORCH.get(), properties, true)),
                BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel(p_220871_ -> 14).sound(SoundType.COPPER).pushReaction(PushReaction.DESTROY)
        );
    }



    //block items
    static {
        COPPER_PRESSURE_PLATE_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(COPPER_PRESSURE_PLATE);
        EXPOSED_COPPER_PRESSURE_PLATE_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(EXPOSED_COPPER_PRESSURE_PLATE);
        WEATHERED_COPPER_PRESSURE_PLATE_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(WEATHERED_COPPER_PRESSURE_PLATE);
        OXIDIZED_COPPER_PRESSURE_PLATE_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(OXIDIZED_COPPER_PRESSURE_PLATE);
        WAXED_COPPER_PRESSURE_PLATE_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(WAXED_COPPER_PRESSURE_PLATE);
        WAXED_EXPOSED_COPPER_PRESSURE_PLATE_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(WAXED_EXPOSED_COPPER_PRESSURE_PLATE);
        WAXED_WEATHERED_COPPER_PRESSURE_PLATE_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(WAXED_WEATHERED_COPPER_PRESSURE_PLATE);
        COPPER_GRATED_REPEATER_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(COPPER_GRATED_REPEATER);
        COPPER_GRATED_TORCH_ITEM = ChronoRegistries.ITEMS.registerItem("copper_grated_torch",properties -> new StandingAndWallBlockItem(COPPER_GRATED_TORCH.get(), COPPER_GRATED_WALL_TORCH.get(), Direction.DOWN, properties));
    }

    private static BlockBehaviour.Properties copperPressurePlateDefaultProperties() {
        return BlockBehaviour.Properties.of()
                .strength(0.5F)
                .forceSolidOn()
                .noCollission()
                .pushReaction(PushReaction.DESTROY)
                .instrument(NoteBlockInstrument.BASEDRUM)
                .sound(SoundType.COPPER);
    }

    private static BlockBehaviour.Properties wallVariant(Block baseBlock, BlockBehaviour.Properties properties, boolean overrideDescription){
        BlockBehaviour.Properties properties1 = properties.overrideLootTable(baseBlock.getLootTable());
        if (overrideDescription) {
            properties1 = properties1.overrideDescription(baseBlock.getDescriptionId());
        }

        return properties1;
    }

    public static void init() {}

    @SuppressWarnings("unused")
    public static void addCreative(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        output.accept(COPPER_PRESSURE_PLATE_ITEM);
        output.accept(EXPOSED_COPPER_PRESSURE_PLATE_ITEM);
        output.accept(WEATHERED_COPPER_PRESSURE_PLATE_ITEM);
        output.accept(OXIDIZED_COPPER_PRESSURE_PLATE_ITEM);
        output.accept(WAXED_COPPER_PRESSURE_PLATE_ITEM);
        output.accept(WAXED_EXPOSED_COPPER_PRESSURE_PLATE_ITEM);
        output.accept(WAXED_WEATHERED_COPPER_PRESSURE_PLATE_ITEM);
        output.accept(COPPER_GRATED_REPEATER_ITEM);
        output.accept(COPPER_GRATED_TORCH_ITEM);
    }
}
