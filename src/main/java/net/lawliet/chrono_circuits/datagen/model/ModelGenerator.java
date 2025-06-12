package net.lawliet.chrono_circuits.datagen.model;

import net.lawliet.chrono_circuits.ChronoCircuits;
import net.lawliet.chrono_circuits.blockEntity.lightDetector.LightState;
import net.lawliet.chrono_circuits.blockState.BlockStateProperties;
import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.lawliet.chrono_circuits.registration.ChronoBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class ModelGenerator extends ModelProvider {
    public ModelGenerator(PackOutput output) {
        super(output, ChronoCircuits.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        CopperPressurePlateModelGenerator(blockModels,ChronoBlocks.COPPER_PRESSURE_PLATE.get(),Blocks.COPPER_BLOCK);
        CopperPressurePlateModelGenerator(blockModels,ChronoBlocks.EXPOSED_COPPER_PRESSURE_PLATE.get(),Blocks.EXPOSED_COPPER);
        CopperPressurePlateModelGenerator(blockModels,ChronoBlocks.WEATHERED_COPPER_PRESSURE_PLATE.get(),Blocks.WEATHERED_COPPER);
        CopperPressurePlateModelGenerator(blockModels,ChronoBlocks.OXIDIZED_COPPER_PRESSURE_PLATE.get(),Blocks.OXIDIZED_COPPER);
        CopperPressurePlateModelGenerator(blockModels,ChronoBlocks.WAXED_COPPER_PRESSURE_PLATE.get(),Blocks.COPPER_BLOCK);
        CopperPressurePlateModelGenerator(blockModels,ChronoBlocks.WAXED_EXPOSED_COPPER_PRESSURE_PLATE.get(),Blocks.EXPOSED_COPPER);
        CopperPressurePlateModelGenerator(blockModels,ChronoBlocks.WAXED_WEATHERED_COPPER_PRESSURE_PLATE.get(),Blocks.WEATHERED_COPPER);

        createLightDetector(blockModels);
        createHopper(blockModels,ChronoBlockEntityTypes.COPPER_HOPPER_BLOCK.get(),ChronoBlockEntityTypes.COPPER_HOPPER_BLOCK_ITEM.get());
        createHopper(blockModels,ChronoBlockEntityTypes.EXPOSED_COPPER_HOPPER_BLOCK.get(),ChronoBlockEntityTypes.EXPOSED_COPPER_HOPPER_BLOCK_ITEM.get());
        createHopper(blockModels,ChronoBlockEntityTypes.WEATHERED_COPPER_HOPPER_BLOCK.get(),ChronoBlockEntityTypes.WEATHERED_COPPER_HOPPER_BLOCK_ITEM.get());
        createHopper(blockModels,ChronoBlockEntityTypes.OXIDIZED_COPPER_HOPPER_BLOCK.get(),ChronoBlockEntityTypes.OXIDIZED_COPPER_HOPPER_BLOCK_ITEM.get());
        createHopper(blockModels,ChronoBlockEntityTypes.GOLD_HOPPER_BLOCK.get(),ChronoBlockEntityTypes.GOLD_HOPPER_BLOCK_ITEM.get());
        createPipe(blockModels,ChronoBlockEntityTypes.PIPE_BLOCK.get(),ChronoBlockEntityTypes.PIPE_BLOCK_ITEM.get());
    }

    public void CopperPressurePlateModelGenerator(BlockModelGenerators blockModels, Block pressurePlateBlock, Block textureMappingBlock) {
        TextureMapping texturemapping = TextureMapping.defaultTexture(textureMappingBlock);
        ResourceLocation pressurePlateUp = ModelTemplates.PRESSURE_PLATE_UP.create(pressurePlateBlock, texturemapping, blockModels.modelOutput);
        ResourceLocation pressurePlateDown = ModelTemplates.PRESSURE_PLATE_DOWN.create(pressurePlateBlock, texturemapping, blockModels.modelOutput);
        blockModels.blockStateOutput.accept(
            BlockModelGenerators.createPressurePlate(pressurePlateBlock,pressurePlateUp, pressurePlateDown)
        );
    }

    public void createHopper(BlockModelGenerators blockModels, Block hopperBlock, Item hopperItem) {
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

    private void createLightDetector(BlockModelGenerators blockModels) {
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

        blockModels.blockStateOutput.accept(MultiVariantGenerator.multiVariant(lightDetector).with(PropertyDispatch.property(BlockStateProperties.LIGHT_STATE)
                .select(LightState.SKY, Variant.variant().with(VariantProperties.MODEL, ChronoCircuitsModelTemplates.LIGHT_DETECTOR.create(ModelLocationUtils.getModelLocation(lightDetector,"_sky"), skyMapping, blockModels.modelOutput)))
                .select(LightState.BLOCK, Variant.variant().with(VariantProperties.MODEL, ChronoCircuitsModelTemplates.LIGHT_DETECTOR.create(ModelLocationUtils.getModelLocation(lightDetector, "_block"), blockMapping, blockModels.modelOutput)))
                .select(LightState.SKY_AND_BLOCK, Variant.variant().with(VariantProperties.MODEL, ChronoCircuitsModelTemplates.LIGHT_DETECTOR.create(lightDetector, bothMapping, blockModels.modelOutput)))
        ));
    }

    public void createPipe(BlockModelGenerators blockModels, Block pipeBlock, Item pipeItem) {
        blockModels.registerSimpleFlatItemModel(pipeItem);
        blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(pipeBlock,ResourceLocation.parse("chrono_circuits:block/pipe")));
    }
}
