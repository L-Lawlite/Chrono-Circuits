package net.lawliet.chrono_circuits.datagen.model;

import net.lawliet.chrono_circuits.ChronoCircuits;
import net.lawliet.chrono_circuits.blockEntity.lightDetector.LightState;
import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.lawliet.chrono_circuits.registration.ChronoBlocks;
import net.lawliet.chrono_circuits.registration.ChronoRegistries;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.*;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.ComparatorMode;

import java.util.stream.Stream;

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

        createRepeater(blockModels, ChronoBlocks.COPPER_GRATED_REPEATER.get(), ChronoBlocks.COPPER_GRATED_REPEATER_ITEM.get());
        createComparator(blockModels, ChronoBlockEntityTypes.COPPER_GRATED_COMPARATOR.get(), ChronoBlockEntityTypes.COPPER_GRATED_COMPARATOR_ITEM.get());
        createRedstoneTorch(ChronoBlocks.COPPER_GRATED_REDSTONE_TORCH.get(), ChronoBlocks.COPPER_GRATED_REDSTONE_WALL_TORCH.get(), ChronoBlocks.WAXED_COPPER_GRATED_REDSTONE_TORCH.get(), ChronoBlocks.WAXED_COPPER_GRATED_REDSTONE_WALL_TORCH.get());
        createRedstoneTorch(ChronoBlocks.EXPOSED_COPPER_GRATED_REDSTONE_TORCH.get(), ChronoBlocks.EXPOSED_COPPER_GRATED_REDSTONE_WALL_TORCH.get(), ChronoBlocks.WAXED_EXPOSED_COPPER_GRATED_REDSTONE_TORCH.get(), ChronoBlocks.WAXED_EXPOSED_COPPER_GRATED_REDSTONE_WALL_TORCH.get());
        createRedstoneTorch(ChronoBlocks.WEATHERED_COPPER_GRATED_REDSTONE_TORCH.get(), ChronoBlocks.WEATHERED_COPPER_GRATED_REDSTONE_WALL_TORCH.get(), ChronoBlocks.WAXED_WEATHERED_COPPER_GRATED_REDSTONE_TORCH.get(), ChronoBlocks.WAXED_WEATHERED_COPPER_GRATED_REDSTONE_WALL_TORCH.get());
        createRedstoneTorch(ChronoBlocks.OXIDIZED_COPPER_GRATED_REDSTONE_TORCH.get(), ChronoBlocks.OXIDIZED_COPPER_GRATED_REDSTONE_WALL_TORCH.get(), ChronoBlocks.WAXED_OXIDIZED_COPPER_GRATED_REDSTONE_TORCH.get(), ChronoBlocks.WAXED_OXIDIZED_COPPER_GRATED_REDSTONE_WALL_TORCH.get());
    }

    private void createRedstoneTorch(Block unwaxedtorch, Block unwaxedWallTorch, Block waxedtorch, Block waxedWallTorch) {
        TextureMapping copperGrateTexture = new TextureMapping().put(ChronoCircuitsTextureSlot.COPPER_GRATE, TextureMapping.getBlockTexture(unwaxedtorch));
        MultiVariant torchLit = BlockModelGenerators.plainVariant(ChronoCircuitsModelTemplates.COPPER_GRATED_REDSTONE_TORCH.create(unwaxedtorch, copperGrateTexture, blockModels.modelOutput));
        MultiVariant torchUnlit = BlockModelGenerators.plainVariant(ChronoCircuitsModelTemplates.COPPER_GRATED_REDSTONE_TORCH_UNLIT.createWithSuffix(unwaxedtorch, "_unlit", copperGrateTexture, blockModels.modelOutput));
        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(unwaxedtorch).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.LIT, torchLit, torchUnlit)));
        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(waxedtorch).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.LIT, torchLit, torchUnlit)));
        MultiVariant wallTorchLit = BlockModelGenerators.plainVariant(ChronoCircuitsModelTemplates.COPPER_GRATED_REDSTONE_WALL_TORCH.create(unwaxedWallTorch, copperGrateTexture, blockModels.modelOutput));
        MultiVariant wallTorchUnlit = BlockModelGenerators.plainVariant(ChronoCircuitsModelTemplates.COPPER_GRATED_REDSTONE_WALL_TORCH_UNLIT.createWithSuffix(unwaxedWallTorch, "_unlit", copperGrateTexture, blockModels.modelOutput));
        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(unwaxedWallTorch).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.LIT, wallTorchLit, wallTorchUnlit)));
        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(waxedWallTorch).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.LIT, wallTorchLit, wallTorchUnlit)));
        blockModels.registerSimpleFlatItemModel(unwaxedtorch.asItem());
        itemModels.itemModelOutput.copy(unwaxedtorch.asItem(), waxedtorch.asItem());
    }

    private void createRepeater(Block unwaxedRepeater, Block waxedRepeater) {
        blockModels.registerSimpleFlatItemModel(unwaxedRepeater.asItem());
        itemModels.itemModelOutput.copy(unwaxedRepeater.asItem(), waxedRepeater.asItem());
        // Need to be modified
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
                        }))
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
                        }))
        );
    }

    public static void createRepeater(BlockModelGenerators blockModels, Block block, BlockItem blockItem) {
        blockModels.registerSimpleFlatItemModel(blockItem);
        blockModels.blockStateOutput
                .accept(
                        MultiVariantGenerator.multiVariant(block)
                                .with(
                                        PropertyDispatch.properties(net.minecraft.world.level.block.state.properties.BlockStateProperties.DELAY, net.minecraft.world.level.block.state.properties.BlockStateProperties.LOCKED, net.minecraft.world.level.block.state.properties.BlockStateProperties.POWERED)
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

    public static void CopperPressurePlateModelGenerator(BlockModelGenerators blockModels, Block pressurePlateBlock, Block textureMappingBlock) {
        TextureMapping texturemapping = TextureMapping.defaultTexture(textureMappingBlock);
        MultiVariant pressurePlateUp = BlockModelGenerators.plainVariant(
                ModelTemplates.PRESSURE_PLATE_UP.create(pressurePlateBlock,texturemapping,blockModels.modelOutput)
        );
        MultiVariant pressurePlateDown = BlockModelGenerators.plainVariant(
                ModelTemplates.PRESSURE_PLATE_DOWN.create(pressurePlateBlock, texturemapping, blockModels.modelOutput)
        );
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
        MultiVariant hopperDown = BlockModelGenerators.plainVariant(ChronoCircuitsModelTemplates.HOPPER.create(hopperBlock,textureMapping,blockModels.modelOutput));
        MultiVariant hopperSide = BlockModelGenerators.plainVariant(ChronoCircuitsModelTemplates.HOPPER_SIDE.createWithSuffix(hopperBlock,"_side",textureMapping,blockModels.modelOutput));


        blockModels.registerSimpleFlatItemModel(hopperItem);
        blockModels.blockStateOutput.accept(
                MultiVariantGenerator
                        .dispatch(hopperBlock)
                        .with(PropertyDispatch.initial(net.minecraft.world.level.block.state.properties.BlockStateProperties.FACING_HOPPER)
                                .select(Direction.DOWN, hopperDown).
                                select(Direction.NORTH, hopperSide)
                                .select(Direction.EAST, hopperSide.with(BlockModelGenerators.Y_ROT_90))
                                .select(Direction.SOUTH, hopperSide.with(BlockModelGenerators.Y_ROT_180))
                                .select(Direction.WEST, hopperSide.with(BlockModelGenerators.Y_ROT_270))));

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

        MultiVariant bothVariant = BlockModelGenerators.plainVariant(ChronoCircuitsModelTemplates.LIGHT_DETECTOR.create(ModelLocationUtils.getModelLocation(lightDetector), bothMapping, blockModels.modelOutput));
        MultiVariant skyVariant = BlockModelGenerators.plainVariant(ChronoCircuitsModelTemplates.LIGHT_DETECTOR.create(ModelLocationUtils.getModelLocation(lightDetector,"_sky"), skyMapping, blockModels.modelOutput));
        MultiVariant blockVariant = BlockModelGenerators.plainVariant(ChronoCircuitsModelTemplates.LIGHT_DETECTOR.create(ModelLocationUtils.getModelLocation(lightDetector,"_block"), blockMapping, blockModels.modelOutput));


        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(lightDetector).with(PropertyDispatch.initial(BlockStateProperties.LIGHT_STATE)
                .select(LightState.SKY, skyVariant)
                .select(LightState.BLOCK, blockVariant)
                .select(LightState.SKY_AND_BLOCK, bothVariant)
        ));
    }

    public static void createPipe(BlockModelGenerators blockModels, Block pipeBlock, Item pipeItem) {
        blockModels.registerSimpleFlatItemModel(pipeItem);
        blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(pipeBlock,BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(ChronoBlockEntityTypes.PIPE_BLOCK.get()))));
    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return ChronoRegistries.BLOCKS.getEntries().stream().filter(block -> !(block.getId().getPath().contains("repeater") || block.getId().getPath().contains("comparator")));
    }
}
