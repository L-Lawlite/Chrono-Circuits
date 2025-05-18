package net.lawliet.chrono_circuit.datagen.model;

import net.lawliet.chrono_circuit.ChronoCircuits;
import net.lawliet.chrono_circuit.registration.ChronoBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class ModelGenerator extends ModelProvider {
    public ModelGenerator(PackOutput output) {
        super(output, ChronoCircuits.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        playerOnlyPressurePlateModelGen(blockModels);
    }

    private void playerOnlyPressurePlateModelGen(BlockModelGenerators blockModels) {
        Block pressurePlateBlock = ChronoBlocks.COPPER_PRESSURE_PLATE.get();
        TextureMapping texturemapping = TextureMapping.defaultTexture(Blocks.COPPER_BLOCK);
        ResourceLocation pressurePlateUp = ModelTemplates.PRESSURE_PLATE_UP.create(pressurePlateBlock, texturemapping, blockModels.modelOutput);
        ResourceLocation pressurePlateDown = ModelTemplates.PRESSURE_PLATE_DOWN.create(pressurePlateBlock, texturemapping, blockModels.modelOutput);
        blockModels.blockStateOutput.accept(
            BlockModelGenerators.createPressurePlate(pressurePlateBlock,pressurePlateUp, pressurePlateDown)
        );
    }
}
