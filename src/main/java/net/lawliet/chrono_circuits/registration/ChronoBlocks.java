package net.lawliet.chrono_circuits.registration;

import net.lawliet.chrono_circuits.blocks.CopperPressurePlate.PlayerPressurePlate;
import net.lawliet.chrono_circuits.blocks.CopperPressurePlate.WeatheringPlayerPressurePlate;
import net.lawliet.chrono_circuits.blocks.gratedBlocks.repeater.WeatheringCopperGratedRepeater;
import net.lawliet.chrono_circuits.blocks.gratedBlocks.torch.CopperGratedRedstoneTorch;
import net.lawliet.chrono_circuits.blocks.gratedBlocks.torch.CopperGratedRedstoneWallTorch;
import net.lawliet.chrono_circuits.blocks.gratedBlocks.torch.WeatheringCopperGratedRedstoneTorch;
import net.lawliet.chrono_circuits.blocks.gratedBlocks.repeater.CopperGratedRepeater;
import net.lawliet.chrono_circuits.blocks.gratedBlocks.torch.WeatheringCopperGratedRedstoneWallTorch;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.function.ToIntFunction;

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
    public static final DeferredBlock<Block> WAXED_OXIDIZED_COPPER_PRESSURE_PLATE;
    public static final DeferredItem<BlockItem> WAXED_OXIDIZED_COPPER_PRESSURE_PLATE_ITEM;

    public static final DeferredBlock<Block> COPPER_GRATED_REPEATER;
    public static final DeferredItem<BlockItem> COPPER_GRATED_REPEATER_ITEM;
    public static final DeferredBlock<Block> EXPOSED_COPPER_GRATED_REPEATER;
    public static final DeferredItem<BlockItem> EXPOSED_COPPER_GRATED_REPEATER_ITEM;
    public static final DeferredBlock<Block> WEATHERED_COPPER_GRATED_REPEATER;
    public static final DeferredItem<BlockItem> WEATHERED_COPPER_GRATED_REPEATER_ITEM;
    public static final DeferredBlock<Block> OXIDIZED_COPPER_GRATED_REPEATER;
    public static final DeferredItem<BlockItem> OXIDIZED_COPPER_GRATED_REPEATER_ITEM;
    public static final DeferredBlock<Block> WAXED_COPPER_GRATED_REPEATER;
    public static final DeferredItem<BlockItem> WAXED_COPPER_GRATED_REPEATER_ITEM;
    public static final DeferredBlock<Block> WAXED_EXPOSED_COPPER_GRATED_REPEATER;
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_COPPER_GRATED_REPEATER_ITEM;
    public static final DeferredBlock<Block> WAXED_WEATHERED_COPPER_GRATED_REPEATER;
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_COPPER_GRATED_REPEATER_ITEM;
    public static final DeferredBlock<Block> WAXED_OXIDIZED_COPPER_GRATED_REPEATER;
    public static final DeferredItem<BlockItem> WAXED_OXIDIZED_COPPER_GRATED_REPEATER_ITEM;


    public static final DeferredBlock<Block> COPPER_GRATED_REDSTONE_TORCH;
    public static final DeferredBlock<Block> COPPER_GRATED_REDSTONE_WALL_TORCH;
    public static final DeferredItem<BlockItem> COPPER_GRATED_REDSTONE_TORCH_ITEM;
    public static final DeferredBlock<Block> EXPOSED_COPPER_GRATED_REDSTONE_TORCH;
    public static final DeferredBlock<Block> EXPOSED_COPPER_GRATED_REDSTONE_WALL_TORCH;
    public static final DeferredItem<BlockItem> EXPOSED_COPPER_GRATED_REDSTONE_TORCH_ITEM;
    public static final DeferredBlock<Block> WEATHERED_COPPER_GRATED_REDSTONE_TORCH;
    public static final DeferredBlock<Block> WEATHERED_COPPER_GRATED_REDSTONE_WALL_TORCH;
    public static final DeferredItem<BlockItem> WEATHERED_COPPER_GRATED_REDSTONE_TORCH_ITEM;
    public static final DeferredBlock<Block> OXIDIZED_COPPER_GRATED_REDSTONE_TORCH;
    public static final DeferredBlock<Block> OXIDIZED_COPPER_GRATED_REDSTONE_WALL_TORCH;
    public static final DeferredItem<BlockItem> OXIDIZED_COPPER_GRATED_REDSTONE_TORCH_ITEM;
    public static final DeferredBlock<Block> WAXED_COPPER_GRATED_REDSTONE_TORCH;
    public static final DeferredBlock<Block> WAXED_COPPER_GRATED_REDSTONE_WALL_TORCH;
    public static final DeferredItem<BlockItem> WAXED_COPPER_GRATED_REDSTONE_TORCH_ITEM;
    public static final DeferredBlock<Block> WAXED_EXPOSED_COPPER_GRATED_REDSTONE_TORCH;
    public static final DeferredBlock<Block> WAXED_EXPOSED_COPPER_GRATED_REDSTONE_WALL_TORCH;
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_COPPER_GRATED_REDSTONE_TORCH_ITEM;
    public static final DeferredBlock<Block> WAXED_WEATHERED_COPPER_GRATED_REDSTONE_TORCH;
    public static final DeferredBlock<Block> WAXED_WEATHERED_COPPER_GRATED_REDSTONE_WALL_TORCH;
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_COPPER_GRATED_REDSTONE_TORCH_ITEM;
    public static final DeferredBlock<Block> WAXED_OXIDIZED_COPPER_GRATED_REDSTONE_TORCH;
    public static final DeferredBlock<Block> WAXED_OXIDIZED_COPPER_GRATED_REDSTONE_WALL_TORCH;
    public static final DeferredItem<BlockItem> WAXED_OXIDIZED_COPPER_GRATED_REDSTONE_TORCH_ITEM;

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
        WAXED_OXIDIZED_COPPER_PRESSURE_PLATE = ChronoRegistries.BLOCKS.registerBlock("waxed_oxidized_copper_pressure_plate",
                properties -> new PlayerPressurePlate(BlockSetType.COPPER,properties,160),
                copperPressurePlateDefaultProperties()
                        .mapColor(MapColor.WARPED_NYLIUM)
        );
        COPPER_GRATED_REPEATER = ChronoRegistries.BLOCKS.registerBlock("copper_grated_repeater",
                properties -> new WeatheringCopperGratedRepeater(WeatheringCopper.WeatherState.UNAFFECTED, properties),
                gratedRedstoneRepeaterProperties()
        );
        EXPOSED_COPPER_GRATED_REPEATER = ChronoRegistries.BLOCKS.registerBlock("exposed_copper_grated_repeater",
                properties -> new WeatheringCopperGratedRepeater(WeatheringCopper.WeatherState.EXPOSED, properties),
                gratedRedstoneRepeaterProperties()
        );
        WEATHERED_COPPER_GRATED_REPEATER = ChronoRegistries.BLOCKS.registerBlock("weathered_copper_grated_repeater",
                properties -> new WeatheringCopperGratedRepeater(WeatheringCopper.WeatherState.WEATHERED, properties),
                gratedRedstoneRepeaterProperties()
        );
        OXIDIZED_COPPER_GRATED_REPEATER = ChronoRegistries.BLOCKS.registerBlock("oxidized_copper_grated_repeater",
                properties -> new WeatheringCopperGratedRepeater(WeatheringCopper.WeatherState.OXIDIZED, properties),
                gratedRedstoneRepeaterProperties()
        );
        WAXED_COPPER_GRATED_REPEATER = ChronoRegistries.BLOCKS.registerBlock("waxed_copper_grated_repeater",
                CopperGratedRepeater::new,
                gratedRedstoneRepeaterProperties()
        );
        WAXED_EXPOSED_COPPER_GRATED_REPEATER = ChronoRegistries.BLOCKS.registerBlock("waxed_exposed_copper_grated_repeater",
                CopperGratedRepeater::new,
                gratedRedstoneRepeaterProperties()
        );
        WAXED_WEATHERED_COPPER_GRATED_REPEATER = ChronoRegistries.BLOCKS.registerBlock("waxed_weathered_copper_grated_repeater",
                CopperGratedRepeater::new,
                gratedRedstoneRepeaterProperties()
        );
        WAXED_OXIDIZED_COPPER_GRATED_REPEATER = ChronoRegistries.BLOCKS.registerBlock("waxed_oxidized_copper_grated_repeater",
                CopperGratedRepeater::new,
                gratedRedstoneRepeaterProperties()
        );


        COPPER_GRATED_REDSTONE_TORCH = ChronoRegistries.BLOCKS.registerBlock("copper_grated_redstone_torch",
                properties -> new WeatheringCopperGratedRedstoneTorch(WeatheringCopper.WeatherState.UNAFFECTED, properties),
                gratedRedstoneTorchProperties(7)
                );
        COPPER_GRATED_REDSTONE_WALL_TORCH = ChronoRegistries.BLOCKS.registerBlock("copper_grated_redstone_wall_torch",
                properties -> new WeatheringCopperGratedRedstoneWallTorch(WeatheringCopper.WeatherState.UNAFFECTED, wallVariant(COPPER_GRATED_REDSTONE_TORCH.get(), properties, true)),
                gratedRedstoneTorchProperties(7)
        );
        EXPOSED_COPPER_GRATED_REDSTONE_TORCH = ChronoRegistries.BLOCKS.registerBlock("exposed_copper_grated_redstone_torch",
                properties -> new WeatheringCopperGratedRedstoneTorch(WeatheringCopper.WeatherState.EXPOSED, properties),
                gratedRedstoneTorchProperties(7)
        );
        EXPOSED_COPPER_GRATED_REDSTONE_WALL_TORCH = ChronoRegistries.BLOCKS.registerBlock("exposed_copper_grated_redstone_wall_torch",
                properties -> new WeatheringCopperGratedRedstoneWallTorch(WeatheringCopper.WeatherState.EXPOSED, wallVariant(COPPER_GRATED_REDSTONE_TORCH.get(), properties, true)),
                gratedRedstoneTorchProperties(7)
        );
        WEATHERED_COPPER_GRATED_REDSTONE_TORCH = ChronoRegistries.BLOCKS.registerBlock("weathered_copper_grated_redstone_torch",
                properties -> new WeatheringCopperGratedRedstoneTorch(WeatheringCopper.WeatherState.WEATHERED, properties),
                gratedRedstoneTorchProperties(7)
        );
        WEATHERED_COPPER_GRATED_REDSTONE_WALL_TORCH = ChronoRegistries.BLOCKS.registerBlock("weathered_copper_grated_redstone_wall_torch",
                properties -> new WeatheringCopperGratedRedstoneWallTorch(WeatheringCopper.WeatherState.WEATHERED, wallVariant(COPPER_GRATED_REDSTONE_TORCH.get(), properties, true)),
                gratedRedstoneTorchProperties(7)
        );
        OXIDIZED_COPPER_GRATED_REDSTONE_TORCH = ChronoRegistries.BLOCKS.registerBlock("oxidized_copper_grated_redstone_torch",
                properties -> new WeatheringCopperGratedRedstoneTorch(WeatheringCopper.WeatherState.OXIDIZED, properties),
                gratedRedstoneTorchProperties(7)
        );
        OXIDIZED_COPPER_GRATED_REDSTONE_WALL_TORCH = ChronoRegistries.BLOCKS.registerBlock("oxidized_copper_grated_redstone_wall_torch",
                properties -> new WeatheringCopperGratedRedstoneWallTorch(WeatheringCopper.WeatherState.OXIDIZED, wallVariant(COPPER_GRATED_REDSTONE_TORCH.get(), properties, true)),
                gratedRedstoneTorchProperties(7)
        );

        WAXED_COPPER_GRATED_REDSTONE_TORCH = ChronoRegistries.BLOCKS.registerBlock("waxed_copper_grated_redstone_torch",
                CopperGratedRedstoneTorch::new,
                gratedRedstoneTorchProperties(7)
        );
        WAXED_COPPER_GRATED_REDSTONE_WALL_TORCH = ChronoRegistries.BLOCKS.registerBlock("waxed_copper_grated_redstone_wall_torch",
                properties -> new CopperGratedRedstoneWallTorch(wallVariant(COPPER_GRATED_REDSTONE_TORCH.get(), properties, true)),
                gratedRedstoneTorchProperties(7)
        );
        WAXED_EXPOSED_COPPER_GRATED_REDSTONE_TORCH = ChronoRegistries.BLOCKS.registerBlock("waxed_exposed_copper_grated_redstone_torch",
                CopperGratedRedstoneTorch::new,
                gratedRedstoneTorchProperties(7)
        );
        WAXED_EXPOSED_COPPER_GRATED_REDSTONE_WALL_TORCH = ChronoRegistries.BLOCKS.registerBlock("waxed_exposed_copper_grated_redstone_wall_torch",
                properties -> new CopperGratedRedstoneWallTorch(wallVariant(COPPER_GRATED_REDSTONE_TORCH.get(), properties, true)),
                gratedRedstoneTorchProperties(7)
        );
        WAXED_WEATHERED_COPPER_GRATED_REDSTONE_TORCH = ChronoRegistries.BLOCKS.registerBlock("waxed_weathered_copper_grated_redstone_torch",
                CopperGratedRedstoneTorch::new,
                gratedRedstoneTorchProperties(7)
        );
        WAXED_WEATHERED_COPPER_GRATED_REDSTONE_WALL_TORCH = ChronoRegistries.BLOCKS.registerBlock("waxed_weathered_copper_grated_redstone_wall_torch",
                properties -> new CopperGratedRedstoneWallTorch(wallVariant(COPPER_GRATED_REDSTONE_TORCH.get(), properties, true)),
                gratedRedstoneTorchProperties(7)
        );
        WAXED_OXIDIZED_COPPER_GRATED_REDSTONE_TORCH = ChronoRegistries.BLOCKS.registerBlock("waxed_oxidized_copper_grated_redstone_torch",
                CopperGratedRedstoneTorch::new,
                gratedRedstoneTorchProperties(7)
        );
        WAXED_OXIDIZED_COPPER_GRATED_REDSTONE_WALL_TORCH = ChronoRegistries.BLOCKS.registerBlock("waxed_oxidized_copper_grated_redstone_wall_torch",
                properties -> new CopperGratedRedstoneWallTorch(wallVariant(COPPER_GRATED_REDSTONE_TORCH.get(), properties, true)),
                gratedRedstoneTorchProperties(7)
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
        WAXED_OXIDIZED_COPPER_PRESSURE_PLATE_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(WAXED_OXIDIZED_COPPER_PRESSURE_PLATE);
        WAXED_WEATHERED_COPPER_PRESSURE_PLATE_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(WAXED_WEATHERED_COPPER_PRESSURE_PLATE);
        COPPER_GRATED_REPEATER_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(COPPER_GRATED_REPEATER);
        EXPOSED_COPPER_GRATED_REPEATER_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(EXPOSED_COPPER_GRATED_REPEATER);
        WEATHERED_COPPER_GRATED_REPEATER_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(WEATHERED_COPPER_GRATED_REPEATER);
        OXIDIZED_COPPER_GRATED_REPEATER_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(OXIDIZED_COPPER_GRATED_REPEATER);
        WAXED_COPPER_GRATED_REPEATER_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(WAXED_COPPER_GRATED_REPEATER);
        WAXED_EXPOSED_COPPER_GRATED_REPEATER_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(WAXED_EXPOSED_COPPER_GRATED_REPEATER);
        WAXED_WEATHERED_COPPER_GRATED_REPEATER_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(WAXED_WEATHERED_COPPER_GRATED_REPEATER);
        WAXED_OXIDIZED_COPPER_GRATED_REPEATER_ITEM = ChronoRegistries.ITEMS.registerSimpleBlockItem(WAXED_OXIDIZED_COPPER_GRATED_REPEATER);
        COPPER_GRATED_REDSTONE_TORCH_ITEM = ChronoRegistries.ITEMS.registerItem("copper_grated_redstone_torch", properties -> new StandingAndWallBlockItem(COPPER_GRATED_REDSTONE_TORCH.get(), COPPER_GRATED_REDSTONE_WALL_TORCH.get(), Direction.DOWN, properties));
        EXPOSED_COPPER_GRATED_REDSTONE_TORCH_ITEM = ChronoRegistries.ITEMS.registerItem("exposed_copper_grated_redstone_torch", properties -> new StandingAndWallBlockItem(EXPOSED_COPPER_GRATED_REDSTONE_TORCH.get(), EXPOSED_COPPER_GRATED_REDSTONE_WALL_TORCH.get(), Direction.DOWN, properties));
        WEATHERED_COPPER_GRATED_REDSTONE_TORCH_ITEM = ChronoRegistries.ITEMS.registerItem("weathered_copper_grated_redstone_torch", properties -> new StandingAndWallBlockItem(WEATHERED_COPPER_GRATED_REDSTONE_TORCH.get(), WEATHERED_COPPER_GRATED_REDSTONE_WALL_TORCH.get(), Direction.DOWN, properties));
        OXIDIZED_COPPER_GRATED_REDSTONE_TORCH_ITEM = ChronoRegistries.ITEMS.registerItem("oxidized_copper_grated_redstone_torch", properties -> new StandingAndWallBlockItem(OXIDIZED_COPPER_GRATED_REDSTONE_TORCH.get(), OXIDIZED_COPPER_GRATED_REDSTONE_WALL_TORCH.get(), Direction.DOWN, properties));
        WAXED_COPPER_GRATED_REDSTONE_TORCH_ITEM = ChronoRegistries.ITEMS.registerItem("waxed_copper_grated_redstone_torch", properties -> new StandingAndWallBlockItem(WAXED_COPPER_GRATED_REDSTONE_TORCH.get(), WAXED_COPPER_GRATED_REDSTONE_WALL_TORCH.get(), Direction.DOWN, properties));
        WAXED_EXPOSED_COPPER_GRATED_REDSTONE_TORCH_ITEM = ChronoRegistries.ITEMS.registerItem("waxed_exposed_copper_grated_redstone_torch", properties -> new StandingAndWallBlockItem(WAXED_EXPOSED_COPPER_GRATED_REDSTONE_TORCH.get(), WAXED_EXPOSED_COPPER_GRATED_REDSTONE_WALL_TORCH.get(), Direction.DOWN, properties));
        WAXED_WEATHERED_COPPER_GRATED_REDSTONE_TORCH_ITEM = ChronoRegistries.ITEMS.registerItem("waxed_weathered_copper_grated_redstone_torch", properties -> new StandingAndWallBlockItem(WAXED_WEATHERED_COPPER_GRATED_REDSTONE_TORCH.get(), WAXED_WEATHERED_COPPER_GRATED_REDSTONE_WALL_TORCH.get(), Direction.DOWN, properties));
        WAXED_OXIDIZED_COPPER_GRATED_REDSTONE_TORCH_ITEM = ChronoRegistries.ITEMS.registerItem("waxed_oxidized_copper_grated_redstone_torch", properties -> new StandingAndWallBlockItem(WAXED_OXIDIZED_COPPER_GRATED_REDSTONE_TORCH.get(), WAXED_OXIDIZED_COPPER_GRATED_REDSTONE_WALL_TORCH.get(), Direction.DOWN, properties));
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

    private static BlockBehaviour.Properties gratedRedstoneTorchProperties(int lightValue) {
        return BlockBehaviour.Properties.of()
                .noCollission().instabreak().lightLevel(litBlockEmission(lightValue)).sound(SoundType.COPPER).pushReaction(PushReaction.DESTROY);
    }
    private static  BlockBehaviour.Properties gratedRedstoneRepeaterProperties() {
        return BlockBehaviour.Properties.of().instabreak().sound(SoundType.COPPER).pushReaction(PushReaction.DESTROY);
    }

    private static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
        return state -> (Boolean)state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }


    public static void init() {}

    @SuppressWarnings("unused")
    public static void addCreative(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        ChronoRegistries.ITEMS.getEntries().forEach(item -> output.accept(item.get()));
    }

    public static void modifyRenderLayer() {
        ChronoRegistries.BLOCKS.getEntries().stream().filter(blockHolder -> blockHolder.getId().getPath().contains("grated")).forEach(block -> ItemBlockRenderTypes.setRenderLayer(block.get(), RenderType.CUTOUT_MIPPED));
    }
}
