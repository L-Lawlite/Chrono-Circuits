package net.lawliet.chrono_circuit.datagen.recipes;

import net.lawliet.chrono_circuit.ChronoCircuits;
import net.lawliet.chrono_circuit.registration.ChronoBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class CraftingRecipeGenerator extends RecipeProvider {
    public CraftingRecipeGenerator(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        ShapedRecipeBuilder
                .shaped(this.registries.lookupOrThrow(Registries.ITEM),RecipeCategory.REDSTONE,ChronoBlocks.COPPER_PRESSURE_PLATE_ITEM.asItem())
                .pattern("##")
                .define('#', Tags.Items.INGOTS_COPPER)
                .unlockedBy("has_copper",this.has(Tags.Items.INGOTS_COPPER))
                .save(this.output, String.valueOf(ResourceLocation.fromNamespaceAndPath(ChronoCircuits.MODID,"crafting/" + ChronoBlocks.COPPER_PRESSURE_PLATE_ITEM.getId().getPath())));
    }

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new CraftingRecipeGenerator(provider,recipeOutput);
        }

        @Override
        public String getName() {
            return "Chrono Circuits Recipe";
        }
    }
}
