package net.lawliet.chrono_circuits.datagen.recipes;

import net.lawliet.chrono_circuits.ChronoCircuits;
import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.lawliet.chrono_circuits.registration.ChronoBlocks;
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

        ShapedRecipeBuilder
                .shaped(this.registries.lookupOrThrow(Registries.ITEM),RecipeCategory.REDSTONE, ChronoBlockEntityTypes.COPPER_HOPPER_BLOCK_ITEM.asItem())
                .define('C', Tags.Items.CHESTS)
                .define('I', Items.COPPER_BLOCK)
                .define('H', Items.HONEYCOMB)
                .pattern("IHI")
                .pattern("ICI")
                .pattern(" I ")
                .unlockedBy("has_copper_block", this.has(Tags.Items.STORAGE_BLOCKS_COPPER))
                .save(this.output);
        ShapedRecipeBuilder
                .shaped(this.registries.lookupOrThrow(Registries.ITEM),RecipeCategory.REDSTONE, ChronoBlockEntityTypes.EXPOSED_COPPER_HOPPER_BLOCK_ITEM.asItem())
                .define('C', Tags.Items.CHESTS)
                .define('I', Items.EXPOSED_COPPER)
                .define('H', Items.HONEYCOMB)
                .pattern("IHI")
                .pattern("ICI")
                .pattern(" I ")
                .unlockedBy("has_copper_block", this.has(Tags.Items.STORAGE_BLOCKS_COPPER))
                .save(this.output);
        ShapedRecipeBuilder
                .shaped(this.registries.lookupOrThrow(Registries.ITEM),RecipeCategory.REDSTONE, ChronoBlockEntityTypes.WEATHERED_COPPER_HOPPER_BLOCK_ITEM.asItem())
                .define('C', Tags.Items.CHESTS)
                .define('I', Items.WEATHERED_COPPER)
                .define('H', Items.HONEYCOMB)
                .pattern("IHI")
                .pattern("ICI")
                .pattern(" I ")
                .unlockedBy("has_copper_block", this.has(Tags.Items.STORAGE_BLOCKS_COPPER))
                .save(this.output);
        ShapedRecipeBuilder
                .shaped(this.registries.lookupOrThrow(Registries.ITEM),RecipeCategory.REDSTONE, ChronoBlockEntityTypes.OXIDIZED_COPPER_HOPPER_BLOCK_ITEM.asItem())
                .define('C', Tags.Items.CHESTS)
                .define('I', Items.OXIDIZED_COPPER)
                .pattern("I I")
                .pattern("ICI")
                .pattern(" I ")
                .unlockedBy("has_copper_block", this.has(Tags.Items.STORAGE_BLOCKS_COPPER))
                .save(this.output);
        ShapedRecipeBuilder
                .shaped(this.registries.lookupOrThrow(Registries.ITEM),RecipeCategory.REDSTONE, ChronoBlockEntityTypes.GOLD_HOPPER_BLOCK_ITEM.asItem())
                .define('C', Tags.Items.CHESTS)
                .define('I', Tags.Items.INGOTS_GOLD)
                .pattern("I I")
                .pattern("ICI")
                .pattern(" I ")
                .unlockedBy("has_gold", this.has(Tags.Items.INGOTS_GOLD))
                .save(this.output);
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
