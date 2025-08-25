package net.lawliet.chrono_circuits.datagen.model;

import net.lawliet.chrono_circuits.ChronoCircuits;
import net.lawliet.chrono_circuits.blockEntity.gratedBlockEntity.comparator.WeatheringCopperGratedComparator;
import net.lawliet.chrono_circuits.blockEntity.lightDetector.LightState;
import net.lawliet.chrono_circuits.blockState.ChronoCircuitsBlockStateProperties;
import net.lawliet.chrono_circuits.blocks.gratedBlocks.repeater.WeatheringCopperGratedRepeater;
import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.lawliet.chrono_circuits.registration.ChronoBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.*;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.ComparatorMode;

import static net.minecraft.client.data.models.BlockModelGenerators.createHorizontalFacingDispatchAlt;

public class ModelGenerator extends ModelProvider {
    public ModelGenerator(PackOutput output) {
        super(output, ChronoCircuits.MODID);
    }
    private BlockModelGenerators blockModels;
    private ItemModelGenerators itemModels;

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        this.blockModels = blockModels;
        this.itemModels = itemModels;
        CopperPressurePlateModelGenerator(blockModels,ChronoBlocks.COPPER_PRESSURE_PLATE.get(),Blocks.COPPER_BLOCK);
        CopperPressurePlateModelGenerator(blockModels,ChronoBlocks.EXPOSED_COPPER_PRESSURE_PLATE.get(),Blocks.EXPOSED_COPPER);
        CopperPressurePlateModelGenerator(blockModels,ChronoBlocks.WEATHERED_COPPER_PRESSURE_PLATE.get(),Blocks.WEATHERED_COPPER);
        CopperPressurePlateModelGenerator(blockModels,ChronoBlocks.OXIDIZED_COPPER_PRESSURE_PLATE.get(),Blocks.OXIDIZED_COPPER);
        CopperPressurePlateModelGenerator(blockModels,ChronoBlocks.WAXED_COPPER_PRESSURE_PLATE.get(),Blocks.COPPER_BLOCK);
        CopperPressurePlateModelGenerator(blockModels,ChronoBlocks.WAXED_EXPOSED_COPPER_PRESSURE_PLATE.get(),Blocks.EXPOSED_COPPER);
        CopperPressurePlateModelGenerator(blockModels,ChronoBlocks.WAXED_WEATHERED_COPPER_PRESSURE_PLATE.get(),Blocks.WEATHERED_COPPER);
        CopperPressurePlateModelGenerator(blockModels,ChronoBlocks.WAXED_OXIDIZED_COPPER_PRESSURE_PLATE.get(),Blocks.OXIDIZED_COPPER);

        createLightDetector(blockModels);
        createHopper(ChronoBlockEntityTypes.COPPER_HOPPER_BLOCK.get(), ChronoBlockEntityTypes.WAXED_COPPER_HOPPER_BLOCK.get());
        createHopper(ChronoBlockEntityTypes.EXPOSED_COPPER_HOPPER_BLOCK.get(), ChronoBlockEntityTypes.WAXED_EXPOSED_COPPER_HOPPER_BLOCK.get());
        createHopper(ChronoBlockEntityTypes.WEATHERED_COPPER_HOPPER_BLOCK.get(), ChronoBlockEntityTypes.WAXED_WEATHERED_COPPER_HOPPER_BLOCK.get());
        createHopper(ChronoBlockEntityTypes.OXIDIZED_COPPER_HOPPER_BLOCK.get(), ChronoBlockEntityTypes.WAXED_OXIDIZED_COPPER_HOPPER_BLOCK.get());
        createHopper(blockModels,ChronoBlockEntityTypes.GOLD_HOPPER_BLOCK.get(),ChronoBlockEntityTypes.GOLD_HOPPER_BLOCK_ITEM.get());
        createPipe(blockModels,ChronoBlockEntityTypes.PIPE_BLOCK.get(),ChronoBlockEntityTypes.PIPE_BLOCK_ITEM.get());

        createRepeater(ChronoBlocks.COPPER_GRATED_REPEATER.get(), ChronoBlocks.WAXED_COPPER_GRATED_REPEATER.get());
        createRepeater(ChronoBlocks.EXPOSED_COPPER_GRATED_REPEATER.get(), ChronoBlocks.WAXED_EXPOSED_COPPER_GRATED_REPEATER.get());
        createRepeater(ChronoBlocks.WEATHERED_COPPER_GRATED_REPEATER.get(), ChronoBlocks.WAXED_WEATHERED_COPPER_GRATED_REPEATER.get());
        createRepeater(ChronoBlocks.OXIDIZED_COPPER_GRATED_REPEATER.get(), ChronoBlocks.WAXED_OXIDIZED_COPPER_GRATED_REPEATER.get());

        createComparator(ChronoBlockEntityTypes.COPPER_GRATED_COMPARATOR.get(), ChronoBlockEntityTypes.WAXED_COPPER_GRATED_COMPARATOR.get());
        createComparator(ChronoBlockEntityTypes.EXPOSED_COPPER_GRATED_COMPARATOR.get(), ChronoBlockEntityTypes.WAXED_EXPOSED_COPPER_GRATED_COMPARATOR.get());
        createComparator(ChronoBlockEntityTypes.WEATHERED_COPPER_GRATED_COMPARATOR.get(), ChronoBlockEntityTypes.WAXED_WEATHERED_COPPER_GRATED_COMPARATOR.get());
        createComparator(ChronoBlockEntityTypes.OXIDIZED_COPPER_GRATED_COMPARATOR.get(), ChronoBlockEntityTypes.WAXED_OXIDIZED_COPPER_GRATED_COMPARATOR.get());


        createRedstoneTorch(ChronoBlocks.COPPER_GRATED_REDSTONE_TORCH.get(), ChronoBlocks.COPPER_GRATED_REDSTONE_WALL_TORCH.get(), ChronoBlocks.WAXED_COPPER_GRATED_REDSTONE_TORCH.get(), ChronoBlocks.WAXED_COPPER_GRATED_REDSTONE_WALL_TORCH.get());
        createRedstoneTorch(ChronoBlocks.EXPOSED_COPPER_GRATED_REDSTONE_TORCH.get(), ChronoBlocks.EXPOSED_COPPER_GRATED_REDSTONE_WALL_TORCH.get(), ChronoBlocks.WAXED_EXPOSED_COPPER_GRATED_REDSTONE_TORCH.get(), ChronoBlocks.WAXED_EXPOSED_COPPER_GRATED_REDSTONE_WALL_TORCH.get());
        createRedstoneTorch(ChronoBlocks.WEATHERED_COPPER_GRATED_REDSTONE_TORCH.get(), ChronoBlocks.WEATHERED_COPPER_GRATED_REDSTONE_WALL_TORCH.get(), ChronoBlocks.WAXED_WEATHERED_COPPER_GRATED_REDSTONE_TORCH.get(), ChronoBlocks.WAXED_WEATHERED_COPPER_GRATED_REDSTONE_WALL_TORCH.get());
        createRedstoneTorch(ChronoBlocks.OXIDIZED_COPPER_GRATED_REDSTONE_TORCH.get(), ChronoBlocks.OXIDIZED_COPPER_GRATED_REDSTONE_WALL_TORCH.get(), ChronoBlocks.WAXED_OXIDIZED_COPPER_GRATED_REDSTONE_TORCH.get(), ChronoBlocks.WAXED_OXIDIZED_COPPER_GRATED_REDSTONE_WALL_TORCH.get());
    }

    private void createRedstoneTorch(Block unwaxedtorch, Block unwaxedWallTorch, Block waxedtorch, Block waxedWallTorch) {
        TextureMapping copperGrateTexture = new TextureMapping().put(ChronoCircuitsTextureSlot.COPPER_GRATE, TextureMapping.getBlockTexture(unwaxedtorch));
        ResourceLocation torchLit = ChronoCircuitsModelTemplates.COPPER_GRATED_REDSTONE_TORCH.create(unwaxedtorch, copperGrateTexture, blockModels.modelOutput);
        ResourceLocation torchUnlit = ChronoCircuitsModelTemplates.COPPER_GRATED_REDSTONE_TORCH_UNLIT.createWithSuffix(unwaxedtorch, "_unlit", copperGrateTexture, blockModels.modelOutput);
        blockModels.blockStateOutput.accept(MultiVariantGenerator.multiVariant(unwaxedtorch).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.LIT, torchLit, torchUnlit)));
        blockModels.blockStateOutput.accept(MultiVariantGenerator.multiVariant(waxedtorch).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.LIT, torchLit, torchUnlit)));
        ResourceLocation wallTorchLit = ChronoCircuitsModelTemplates.COPPER_GRATED_REDSTONE_WALL_TORCH.create(unwaxedWallTorch, copperGrateTexture, blockModels.modelOutput);
        ResourceLocation wallTorchUnlit = ChronoCircuitsModelTemplates.COPPER_GRATED_REDSTONE_WALL_TORCH_UNLIT.createWithSuffix(unwaxedWallTorch, "_unlit", copperGrateTexture, blockModels.modelOutput);
        blockModels.blockStateOutput.accept(MultiVariantGenerator.multiVariant(unwaxedWallTorch).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.LIT, wallTorchLit, wallTorchUnlit)).with(BlockModelGenerators.createTorchHorizontalDispatch()));
        blockModels.blockStateOutput.accept(MultiVariantGenerator.multiVariant(waxedWallTorch).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.LIT, wallTorchLit, wallTorchUnlit)).with(BlockModelGenerators.createTorchHorizontalDispatch()));
        blockModels.registerSimpleFlatItemModel(unwaxedtorch.asItem());
        itemModels.itemModelOutput.copy(unwaxedtorch.asItem(), waxedtorch.asItem());
    }

    private void createRepeater(Block unwaxedRepeater, Block waxedRepeater) {
        blockModels.registerSimpleFlatItemModel(unwaxedRepeater.asItem());
        itemModels.itemModelOutput.copy(unwaxedRepeater.asItem(), waxedRepeater.asItem());
        // Need to be modified
        WeatheringCopperGratedRepeater weatheringUnwaxedBlock = (WeatheringCopperGratedRepeater) unwaxedRepeater;
        String bottomPrefix = weatheringUnwaxedBlock.getAge() == WeatheringCopper.WeatherState.UNAFFECTED ? "" : weatheringUnwaxedBlock.getAge().getSerializedName() + "_";
        ResourceLocation topTexture = TextureMapping.getBlockTexture(unwaxedRepeater, "_opening");
        ResourceLocation sideTexture = ResourceLocation.fromNamespaceAndPath(ChronoCircuits.MODID, "copper_grated_slab").withPrefix(bottomPrefix).withPrefix("block/");
        ResourceLocation bottomTexture = ResourceLocation.fromNamespaceAndPath(ChronoCircuits.MODID, "copper_grated_redstone_bottom").withPrefix(bottomPrefix).withPrefix("block/");
        TextureMapping textureMapping = new TextureMapping()
                .put(TextureSlot.TOP, topTexture)
                .put(TextureSlot.SIDE, sideTexture)
                .put(TextureSlot.BOTTOM, bottomTexture);

        ChronoCircuitsModelTemplates.COPPER_GRATED_REPEATER_1TICK.createWithSuffix(unwaxedRepeater, "_1tick", textureMapping, blockModels.modelOutput);
        ChronoCircuitsModelTemplates.COPPER_GRATED_REPEATER_1TICK_LOCKED.createWithSuffix(unwaxedRepeater, "_1tick_locked", textureMapping, blockModels.modelOutput);
        ChronoCircuitsModelTemplates.COPPER_GRATED_REPEATER_1TICK_ON.createWithSuffix(unwaxedRepeater, "_1tick_on", textureMapping, blockModels.modelOutput);
        ChronoCircuitsModelTemplates.COPPER_GRATED_REPEATER_1TICK_ON_LOCKED.createWithSuffix(unwaxedRepeater, "_1tick_on_locked", textureMapping, blockModels.modelOutput);
        ChronoCircuitsModelTemplates.COPPER_GRATED_REPEATER_2TICK_LOCKED.createWithSuffix(unwaxedRepeater, "_2tick_locked", textureMapping, blockModels.modelOutput);
        ChronoCircuitsModelTemplates.COPPER_GRATED_REPEATER_2TICK.createWithSuffix(unwaxedRepeater, "_2tick", textureMapping, blockModels.modelOutput);
        ChronoCircuitsModelTemplates.COPPER_GRATED_REPEATER_2TICK_ON.createWithSuffix(unwaxedRepeater, "_2tick_on", textureMapping, blockModels.modelOutput);
        ChronoCircuitsModelTemplates.COPPER_GRATED_REPEATER_2TICK_ON_LOCKED.createWithSuffix(unwaxedRepeater, "_2tick_on_locked", textureMapping, blockModels.modelOutput);
        ChronoCircuitsModelTemplates.COPPER_GRATED_REPEATER_3TICK.createWithSuffix(unwaxedRepeater, "_3tick", textureMapping, blockModels.modelOutput);
        ChronoCircuitsModelTemplates.COPPER_GRATED_REPEATER_3TICK_LOCKED.createWithSuffix(unwaxedRepeater, "_3tick_locked", textureMapping, blockModels.modelOutput);
        ChronoCircuitsModelTemplates.COPPER_GRATED_REPEATER_3TICK_ON.createWithSuffix(unwaxedRepeater, "_3tick_on", textureMapping, blockModels.modelOutput);
        ChronoCircuitsModelTemplates.COPPER_GRATED_REPEATER_3TICK_ON_LOCKED.createWithSuffix(unwaxedRepeater, "_3tick_on_locked", textureMapping, blockModels.modelOutput);
        ChronoCircuitsModelTemplates.COPPER_GRATED_REPEATER_4TICK_LOCKED.createWithSuffix(unwaxedRepeater, "_4tick_locked", textureMapping, blockModels.modelOutput);
        ChronoCircuitsModelTemplates.COPPER_GRATED_REPEATER_4TICK.createWithSuffix(unwaxedRepeater, "_4tick", textureMapping, blockModels.modelOutput);
        ChronoCircuitsModelTemplates.COPPER_GRATED_REPEATER_4TICK_ON.createWithSuffix(unwaxedRepeater, "_4tick_on", textureMapping, blockModels.modelOutput);
        ChronoCircuitsModelTemplates.COPPER_GRATED_REPEATER_4TICK_ON_LOCKED.createWithSuffix(unwaxedRepeater, "_4tick_on_locked", textureMapping, blockModels.modelOutput);

        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(unwaxedRepeater)
                        .with(PropertyDispatch.properties(BlockStateProperties.DELAY, BlockStateProperties.LOCKED,  BlockStateProperties.POWERED).generate((delay, locked, powered) -> {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append('_').append(delay).append("tick");
                            if (powered) {
                               stringBuilder.append("_on");
                            }
                            if (locked) {
                                stringBuilder.append("_locked");
                            }
                            return Variant.variant().with(VariantProperties.MODEL, TextureMapping.getBlockTexture(unwaxedRepeater, stringBuilder.toString()));
                        })).with(createHorizontalFacingDispatchAlt())
        );
        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(waxedRepeater)
                        .with(PropertyDispatch.properties(BlockStateProperties.DELAY, BlockStateProperties.LOCKED,  BlockStateProperties.POWERED).generate((delay, locked, powered) -> {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append('_').append(delay).append("tick");
                            if (powered) {
                                stringBuilder.append("_on");
                            }
                            if (locked) {
                                stringBuilder.append("_locked");
                            }
                            return Variant.variant().with(VariantProperties.MODEL, TextureMapping.getBlockTexture(unwaxedRepeater, stringBuilder.toString()));
                        })).with(createHorizontalFacingDispatchAlt())
        );
    }

    public static void createRepeater(BlockModelGenerators blockModels, Block block, BlockItem blockItem) {
        blockModels.registerSimpleFlatItemModel(blockItem);
        blockModels.blockStateOutput
                .accept(
                        MultiVariantGenerator.multiVariant(block)
                                .with(
                                        PropertyDispatch.properties(BlockStateProperties.DELAY, BlockStateProperties.LOCKED, BlockStateProperties.POWERED)
                                                .generate((delay, locked, powered) -> {
                                                    StringBuilder stringbuilder = new StringBuilder();
                                                    stringbuilder.append('_').append(delay).append("tick");
                                                    if (powered) {
                                                        stringbuilder.append("_on");
                                                    }

                                                    if (locked) {
                                                        stringbuilder.append("_locked");
                                                    }

                                                    return Variant.variant()
                                                            .with(VariantProperties.MODEL, TextureMapping.getBlockTexture(block, stringbuilder.toString()));
                                                })
                                )
                                .with(createHorizontalFacingDispatchAlt())
                );
    }

    public static void createComparator(BlockModelGenerators blockModels, Block block, BlockItem blockItem) {
        blockModels.registerSimpleFlatItemModel(blockItem);
        blockModels.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(createHorizontalFacingDispatchAlt()).with(PropertyDispatch.properties(net.minecraft.world.level.block.state.properties.BlockStateProperties.MODE_COMPARATOR, net.minecraft.world.level.block.state.properties.BlockStateProperties.POWERED).select(ComparatorMode.COMPARE, false, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block))).select(ComparatorMode.COMPARE, true, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block, "_on"))).select(ComparatorMode.SUBTRACT, false, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block, "_subtract"))).select(ComparatorMode.SUBTRACT, true, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block, "_on_subtract")))));
    }

    public void createComparator(Block unwaxedBlock, Block waxedBlock) {
        blockModels.registerSimpleFlatItemModel(unwaxedBlock.asItem());
        itemModels.itemModelOutput.copy(unwaxedBlock.asItem(), waxedBlock.asItem());
        WeatheringCopperGratedComparator weatheringUnwaxedBlock = (WeatheringCopperGratedComparator) unwaxedBlock;
        String bottomPrefix = weatheringUnwaxedBlock.getAge() == WeatheringCopper.WeatherState.UNAFFECTED ? "" : weatheringUnwaxedBlock.getAge().getSerializedName() + "_";
        ResourceLocation topTexture = TextureMapping.getBlockTexture(unwaxedBlock, "_opening");
        ResourceLocation sideTexture = ResourceLocation.fromNamespaceAndPath(ChronoCircuits.MODID, "copper_grated_slab").withPrefix(bottomPrefix).withPrefix("block/");
        ResourceLocation bottomTexture = ResourceLocation.fromNamespaceAndPath(ChronoCircuits.MODID, "copper_grated_redstone_bottom").withPrefix(bottomPrefix).withPrefix("block/");
        TextureMapping textureMapping = new TextureMapping()
                .put(TextureSlot.TOP, topTexture)
                .put(TextureSlot.SIDE, sideTexture)
                .put(TextureSlot.BOTTOM, bottomTexture);

        ResourceLocation comparator = ChronoCircuitsModelTemplates.COPPER_GRATED_COMPARATOR.create(unwaxedBlock, textureMapping, blockModels.modelOutput);
        ResourceLocation comparatorOn = ChronoCircuitsModelTemplates.COPPER_GRATED_COMPARATOR_ON.createWithSuffix(unwaxedBlock, "_on", textureMapping, blockModels.modelOutput);
        ResourceLocation comparatorOnSubtract = ChronoCircuitsModelTemplates.COPPER_GRATED_COMPARATOR_ON_SUBTRACT.createWithSuffix(unwaxedBlock, "_on_subtract", textureMapping, blockModels.modelOutput);
        ResourceLocation comparatorSubtract = ChronoCircuitsModelTemplates.COPPER_GRATED_COMPARATOR_SUBTRACT.createWithSuffix(unwaxedBlock, "_subtract", textureMapping, blockModels.modelOutput);

        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(unwaxedBlock)
                        .with(createHorizontalFacingDispatchAlt())
                        .with(PropertyDispatch.properties(BlockStateProperties.MODE_COMPARATOR, BlockStateProperties.POWERED)
                                .select(ComparatorMode.COMPARE, false, Variant.variant().with(VariantProperties.MODEL, comparator))
                                .select(ComparatorMode.COMPARE, true, Variant.variant().with(VariantProperties.MODEL, comparatorOn))
                                .select(ComparatorMode.SUBTRACT, false, Variant.variant().with(VariantProperties.MODEL, comparatorSubtract))
                                .select(ComparatorMode.SUBTRACT, true, Variant.variant().with(VariantProperties.MODEL, comparatorOnSubtract))
                        )
        );
        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(waxedBlock)
                        .with(createHorizontalFacingDispatchAlt())
                        .with(PropertyDispatch.properties(BlockStateProperties.MODE_COMPARATOR, BlockStateProperties.POWERED)
                                .select(ComparatorMode.COMPARE, false, Variant.variant().with(VariantProperties.MODEL, comparator))
                                .select(ComparatorMode.COMPARE, true, Variant.variant().with(VariantProperties.MODEL, comparatorOn))
                                .select(ComparatorMode.SUBTRACT, false, Variant.variant().with(VariantProperties.MODEL, comparatorSubtract))
                                .select(ComparatorMode.SUBTRACT, true, Variant.variant().with(VariantProperties.MODEL, comparatorOnSubtract))
                        )
        );

    }

    public static void CopperPressurePlateModelGenerator(BlockModelGenerators blockModels, Block pressurePlateBlock, Block textureMappingBlock) {
        TextureMapping texturemapping = TextureMapping.defaultTexture(textureMappingBlock);
        ResourceLocation pressurePlateUp = ModelTemplates.PRESSURE_PLATE_UP.create(pressurePlateBlock, texturemapping, blockModels.modelOutput);
        ResourceLocation pressurePlateDown = ModelTemplates.PRESSURE_PLATE_DOWN.create(pressurePlateBlock, texturemapping, blockModels.modelOutput);
        blockModels.blockStateOutput.accept(
            BlockModelGenerators.createPressurePlate(pressurePlateBlock,pressurePlateUp, pressurePlateDown)
        );
    }

    public void createHopper(Block unwaxedHopper, Block waxedHopper) {
        ResourceLocation topTexture = TextureMapping.getBlockTexture(unwaxedHopper,"_top");
        ResourceLocation outsideTexture = TextureMapping.getBlockTexture(unwaxedHopper,"_outside");
        ResourceLocation insideTexture = TextureMapping.getBlockTexture(unwaxedHopper,"_inside");
        TextureMapping textureMapping = new TextureMapping()
                .put(TextureSlot.TOP,topTexture)
                .put(TextureSlot.SIDE,outsideTexture)
                .put(TextureSlot.INSIDE,insideTexture);
        ResourceLocation resourcelocation = ChronoCircuitsModelTemplates.HOPPER.create(unwaxedHopper,textureMapping, blockModels.modelOutput);
        ResourceLocation resourcelocation1 = ChronoCircuitsModelTemplates.HOPPER_SIDE.createWithSuffix(unwaxedHopper,"_side",textureMapping, blockModels.modelOutput);
        blockModels.registerSimpleFlatItemModel(unwaxedHopper.asItem());
        itemModels.itemModelOutput.copy(unwaxedHopper.asItem(), waxedHopper.asItem());
        blockModels.blockStateOutput.accept(
                MultiVariantGenerator
                        .multiVariant(unwaxedHopper)
                        .with(PropertyDispatch.property(net.minecraft.world.level.block.state.properties.BlockStateProperties.FACING_HOPPER)
                                .select(Direction.DOWN, Variant.variant().with(VariantProperties.MODEL, resourcelocation)).
                                select(Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, resourcelocation1))
                                .select(Direction.EAST, Variant.variant().with(VariantProperties.MODEL, resourcelocation1).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                                .select(Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, resourcelocation1).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                                .select(Direction.WEST, Variant.variant().with(VariantProperties.MODEL, resourcelocation1).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))));
        blockModels.blockStateOutput.accept(
                MultiVariantGenerator
                        .multiVariant(waxedHopper)
                        .with(PropertyDispatch.property(BlockStateProperties.FACING_HOPPER)
                                .select(Direction.DOWN, Variant.variant().with(VariantProperties.MODEL, resourcelocation)).
                                select(Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, resourcelocation1))
                                .select(Direction.EAST, Variant.variant().with(VariantProperties.MODEL, resourcelocation1).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                                .select(Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, resourcelocation1).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                                .select(Direction.WEST, Variant.variant().with(VariantProperties.MODEL, resourcelocation1).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))));

    }


    public static void createHopper(BlockModelGenerators blockModels, Block hopperBlock, Item hopperItem) {
        ResourceLocation topTexture = TextureMapping.getBlockTexture(hopperBlock,"_top");
        ResourceLocation outsideTexture = TextureMapping.getBlockTexture(hopperBlock,"_outside");
        ResourceLocation insideTexture = TextureMapping.getBlockTexture(hopperBlock,"_inside");
        TextureMapping textureMapping = new TextureMapping()
                .put(TextureSlot.TOP,topTexture)
                .put(TextureSlot.SIDE,outsideTexture)
                .put(TextureSlot.INSIDE,insideTexture);
        ResourceLocation resourcelocation = ChronoCircuitsModelTemplates.HOPPER.create(hopperBlock,textureMapping, blockModels.modelOutput);
        ResourceLocation resourcelocation1 = ChronoCircuitsModelTemplates.HOPPER_SIDE.createWithSuffix(hopperBlock,"_side",textureMapping, blockModels.modelOutput);
        blockModels.registerSimpleFlatItemModel(hopperItem);
        blockModels.blockStateOutput.accept(
                MultiVariantGenerator
                        .multiVariant(hopperBlock)
                        .with(PropertyDispatch.property(net.minecraft.world.level.block.state.properties.BlockStateProperties.FACING_HOPPER)
                                .select(Direction.DOWN, Variant.variant().with(VariantProperties.MODEL, resourcelocation)).
                                select(Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, resourcelocation1))
                                .select(Direction.EAST, Variant.variant().with(VariantProperties.MODEL, resourcelocation1).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                                .select(Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, resourcelocation1).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                                .select(Direction.WEST, Variant.variant().with(VariantProperties.MODEL, resourcelocation1).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))));

    }

    private static void createLightDetector(BlockModelGenerators blockModels) {
        Block lightDetector = ChronoBlockEntityTypes.LIGHT_DETECTOR_BLOCK.get();
        ResourceLocation sideBoth = TextureMapping.getBlockTexture(lightDetector, "_side_both");
        ResourceLocation sideSky = TextureMapping.getBlockTexture(lightDetector, "_side_sky");
        ResourceLocation sideBlock = TextureMapping.getBlockTexture(lightDetector, "_side_block");

        ResourceLocation topBoth = TextureMapping.getBlockTexture(lightDetector, "_top_both");
        ResourceLocation topSky = TextureMapping.getBlockTexture(lightDetector, "_top_sky");
        ResourceLocation topBlock = TextureMapping.getBlockTexture(lightDetector, "_top_block");

        ResourceLocation bottom = TextureMapping.getBlockTexture(lightDetector, "_top_bottom");


        TextureMapping bothMapping = new TextureMapping()
                .put(TextureSlot.TOP, topBoth)
                .put(TextureSlot.SIDE, sideBoth)
                .put(TextureSlot.BOTTOM, bottom);
        TextureMapping skyMapping = new TextureMapping()
                .put(TextureSlot.TOP, topSky)
                .put(TextureSlot.SIDE, sideSky)
                .put(TextureSlot.BOTTOM, bottom);
        TextureMapping blockMapping = new TextureMapping()
                .put(TextureSlot.TOP, topBlock)
                .put(TextureSlot.SIDE, sideBlock)
                .put(TextureSlot.BOTTOM, bottom);

        blockModels.blockStateOutput.accept(MultiVariantGenerator.multiVariant(lightDetector).with(PropertyDispatch.property(ChronoCircuitsBlockStateProperties.LIGHT_STATE)
                .select(LightState.SKY, Variant.variant().with(VariantProperties.MODEL, ChronoCircuitsModelTemplates.LIGHT_DETECTOR.create(ModelLocationUtils.getModelLocation(lightDetector,"_sky"), skyMapping, blockModels.modelOutput)))
                .select(LightState.BLOCK, Variant.variant().with(VariantProperties.MODEL, ChronoCircuitsModelTemplates.LIGHT_DETECTOR.create(ModelLocationUtils.getModelLocation(lightDetector, "_block"), blockMapping, blockModels.modelOutput)))
                .select(LightState.SKY_AND_BLOCK, Variant.variant().with(VariantProperties.MODEL, ChronoCircuitsModelTemplates.LIGHT_DETECTOR.create(lightDetector, bothMapping, blockModels.modelOutput)))
        ));
    }

    public static void createPipe(BlockModelGenerators blockModels, Block pipeBlock, Item pipeItem) {
        blockModels.registerSimpleFlatItemModel(pipeItem);
        blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(pipeBlock,ResourceLocation.parse("chrono_circuits:block/pipe")));
    }

//    @Override
//    protected Stream<? extends Holder<Block>> getKnownBlocks() {
//        return ChronoRegistries.BLOCKS.getEntries().stream();
//    }
}
