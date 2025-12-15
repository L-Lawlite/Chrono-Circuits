package net.lawliet.chrono_circuits.datagen.recipes;

import net.lawliet.chrono_circuits.ChronoCircuits;
import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.lawliet.chrono_circuits.registration.ChronoBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import org.openjdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

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
                .define('C', Tags.Items.CHESTS_WOODEN)
                .define('I', Tags.Items.INGOTS_COPPER)
                .pattern("I I")
                .pattern("ICI")
                .pattern(" I ")
                .unlockedBy("has_copper_ingot", this.has(Tags.Items.INGOTS_COPPER))
                .save(this.output);
        ShapedRecipeBuilder
                .shaped(this.registries.lookupOrThrow(Registries.ITEM),RecipeCategory.REDSTONE, ChronoBlockEntityTypes.GOLD_HOPPER_BLOCK_ITEM.asItem())
                .define('C', Tags.Items.CHESTS_WOODEN)
                .define('I', Tags.Items.INGOTS_GOLD)
                .pattern("I I")
                .pattern("ICI")
                .pattern(" I ")
                .unlockedBy("has_gold", this.has(Tags.Items.INGOTS_GOLD))
                .save(this.output);
        ShapedRecipeBuilder
                .shaped(this.registries.lookupOrThrow(Registries.ITEM),RecipeCategory.REDSTONE,ChronoBlockEntityTypes.PIPE_BLOCK_ITEM.asItem())
                .define('I', Tags.Items.INGOTS_IRON)
                .define('C', Tags.Items.CHESTS_WOODEN)
                .pattern("I I")
                .pattern("ICI")
                .pattern("I I")
                .unlockedBy("has_iron",this.has(Tags.Items.INGOTS_IRON))
                .save(this.output);

        ShapedRecipeBuilder
                .shaped(this.registries.lookupOrThrow(Registries.ITEM),RecipeCategory.REDSTONE,ChronoBlockEntityTypes.LIGHT_DETECTOR_BLOCK.asItem())
                .define('A', Tags.Items.GEMS_AMETHYST)
                .define('D', Items.DAYLIGHT_DETECTOR)
                .pattern(" A ")
                .pattern("ADA")
                .unlockedBy("has_day_light_detector",this.has(Items.DAYLIGHT_DETECTOR))
                .save(this.output);

        makeGratedBlockRecipe(Items.REPEATER, ChronoBlocks.COPPER_GRATED_REPEATER_ITEM.get(), Items.COPPER_GRATE);
        makeGratedBlockRecipe(Items.REPEATER, ChronoBlocks.EXPOSED_COPPER_GRATED_REPEATER_ITEM.get(), Items.EXPOSED_COPPER_GRATE);
        makeGratedBlockRecipe(Items.REPEATER, ChronoBlocks.WEATHERED_COPPER_GRATED_REPEATER_ITEM.get(), Items.WEATHERED_COPPER_GRATE);
        makeGratedBlockRecipe(Items.REPEATER, ChronoBlocks.OXIDIZED_COPPER_GRATED_REPEATER_ITEM.get(), Items.OXIDIZED_COPPER_GRATE);
        makeGratedBlockRecipe(Items.REPEATER, ChronoBlocks.WAXED_COPPER_GRATED_REPEATER_ITEM.get(), Items.WAXED_COPPER_GRATE);
        makeGratedBlockRecipe(Items.REPEATER, ChronoBlocks.WAXED_EXPOSED_COPPER_GRATED_REPEATER_ITEM.get(), Items.WAXED_EXPOSED_COPPER_GRATE);
        makeGratedBlockRecipe(Items.REPEATER, ChronoBlocks.WAXED_WEATHERED_COPPER_GRATED_REPEATER_ITEM.get(), Items.WAXED_WEATHERED_COPPER_GRATE);
        makeGratedBlockRecipe(Items.REPEATER, ChronoBlocks.WAXED_OXIDIZED_COPPER_GRATED_REPEATER_ITEM.get(), Items.WAXED_OXIDIZED_COPPER_GRATE);

        makeGratedBlockRecipe(Items.COMPARATOR, ChronoBlockEntityTypes.COPPER_GRATED_COMPARATOR_ITEM.get(), Items.COPPER_GRATE);
        makeGratedBlockRecipe(Items.COMPARATOR, ChronoBlockEntityTypes.EXPOSED_COPPER_GRATED_COMPARATOR_ITEM.get(), Items.EXPOSED_COPPER_GRATE);
        makeGratedBlockRecipe(Items.COMPARATOR, ChronoBlockEntityTypes.WEATHERED_COPPER_GRATED_COMPARATOR_ITEM.get(), Items.WEATHERED_COPPER_GRATE);
        makeGratedBlockRecipe(Items.COMPARATOR, ChronoBlockEntityTypes.OXIDIZED_COPPER_GRATED_COMPARATOR_ITEM.get(), Items.OXIDIZED_COPPER_GRATE);
        makeGratedBlockRecipe(Items.COMPARATOR, ChronoBlockEntityTypes.WAXED_COPPER_GRATED_COMPARATOR_ITEM.get(), Items.WAXED_COPPER_GRATE);
        makeGratedBlockRecipe(Items.COMPARATOR, ChronoBlockEntityTypes.WAXED_EXPOSED_COPPER_GRATED_COMPARATOR_ITEM.get(), Items.WAXED_EXPOSED_COPPER_GRATE);
        makeGratedBlockRecipe(Items.COMPARATOR, ChronoBlockEntityTypes.WAXED_OXIDIZED_COPPER_GRATED_COMPARATOR_ITEM.get(), Items.WAXED_WEATHERED_COPPER_GRATE);
        makeGratedBlockRecipe(Items.COMPARATOR, ChronoBlockEntityTypes.WAXED_WEATHERED_COPPER_GRATED_COMPARATOR_ITEM.get(), Items.WAXED_OXIDIZED_COPPER_GRATE);

        makeGratedBlockRecipe(Items.REDSTONE_TORCH, ChronoBlocks.COPPER_GRATED_REDSTONE_TORCH_ITEM.get(), Items.COPPER_GRATE, 4);
        makeGratedBlockRecipe(Items.REDSTONE_TORCH, ChronoBlocks.EXPOSED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get(), Items.EXPOSED_COPPER_GRATE, 4);
        makeGratedBlockRecipe(Items.REDSTONE_TORCH, ChronoBlocks.WEATHERED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get(), Items.WEATHERED_COPPER_GRATE, 4);
        makeGratedBlockRecipe(Items.REDSTONE_TORCH, ChronoBlocks.OXIDIZED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get(), Items.OXIDIZED_COPPER_GRATE, 4);
        makeGratedBlockRecipe(Items.REDSTONE_TORCH, ChronoBlocks.WAXED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get(), Items.WAXED_COPPER_GRATE, 4);
        makeGratedBlockRecipe(Items.REDSTONE_TORCH, ChronoBlocks.WAXED_EXPOSED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get(), Items.WAXED_EXPOSED_COPPER_GRATE, 4);
        makeGratedBlockRecipe(Items.REDSTONE_TORCH, ChronoBlocks.WAXED_WEATHERED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get(), Items.WAXED_WEATHERED_COPPER_GRATE, 4);
        makeGratedBlockRecipe(Items.REDSTONE_TORCH, ChronoBlocks.WAXED_OXIDIZED_COPPER_GRATED_REDSTONE_TORCH_ITEM.get(), Items.WAXED_OXIDIZED_COPPER_GRATE, 4);

    }

    private void makeGratedBlockRecipe(Item inputItem, Item outputItem, Item grateType) {
        makeGratedBlockRecipe(inputItem ,outputItem, grateType, 1);
    }

    private void makeGratedBlockRecipe(Item inputItem, Item outputItem, Item grateType, int recipeType) {
        String itemId = BuiltInRegistries.ITEM.getKey(inputItem).getPath();
        ShapedRecipeBuilder builder = ShapedRecipeBuilder
                .shaped(this.registries.lookupOrThrow(Registries.ITEM),RecipeCategory.REDSTONE,outputItem, recipeType)
                .define('G', grateType)
                .define('C', inputItem)
                .unlockedBy("has_" + itemId,this.has(inputItem))
                .unlockedBy("has_copper_grate", this.has(grateType));
        switch (recipeType) {
            case 1:
                builder.pattern("G").pattern("C");
                break;
            case 4:
                builder.pattern(" C ").pattern("CGC").pattern(" C ");
                break;
            case 8:
                builder.pattern("CCC").pattern("CGC").pattern("CCC");
                break;
            default:
                throw new ValueException("Invalid recipeType for grated Block Recipe");

        }
        builder.save(this.output);
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
