package net.lawliet.chrono_circuits.datagen.lang;

import net.lawliet.chrono_circuits.ChronoCircuits;
import net.lawliet.chrono_circuits.registration.ChronoBlockEntityTypes;
import net.lawliet.chrono_circuits.registration.ChronoBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.function.Supplier;

public class LanguageGenerator extends LanguageProvider {


    public LanguageGenerator(PackOutput packOutput, String lang) {
        super(packOutput, ChronoCircuits.MODID,lang);
    }

    @Override
    protected void addTranslations() {
        this.addBlock(ChronoBlocks.COPPER_PRESSURE_PLATE,"Copper Pressure Plate");
        this.addBlock(ChronoBlocks.EXPOSED_COPPER_PRESSURE_PLATE,"Exposed Copper Pressure Plate");
        this.addBlock(ChronoBlocks.WEATHERED_COPPER_PRESSURE_PLATE,"Weathered Copper Pressure Plate");
        this.addBlock(ChronoBlocks.OXIDIZED_COPPER_PRESSURE_PLATE,"Oxidized Copper Pressure Plate");
        this.addBlock(ChronoBlocks.WAXED_COPPER_PRESSURE_PLATE,"Waxed Copper Pressure Plate");
        this.addBlock(ChronoBlocks.WAXED_EXPOSED_COPPER_PRESSURE_PLATE,"Waxed Exposed Copper Pressure Plate");
        this.addBlock(ChronoBlocks.WAXED_WEATHERED_COPPER_PRESSURE_PLATE,"Waxed Weathered Copper Pressure Plate");
        this.addBlock(ChronoBlocks.WAXED_OXIDIZED_COPPER_PRESSURE_PLATE,"Waxed Oxidized Copper Pressure Plate");

        this.addBlock(ChronoBlockEntityTypes.LIGHT_DETECTOR_BLOCK,"Light Detector");

        this.addBlock(ChronoBlocks.COPPER_GRATED_REPEATER, "Copper Grated Repeater");
        this.addBlock(ChronoBlocks.EXPOSED_COPPER_GRATED_REPEATER, "Exposed Copper Grated Repeater");
        this.addBlock(ChronoBlocks.WEATHERED_COPPER_GRATED_REPEATER, "Weathered Copper Grated Repeater");
        this.addBlock(ChronoBlocks.OXIDIZED_COPPER_GRATED_REPEATER, "Oxidized Copper Grated Repeater");
        this.addBlock(ChronoBlocks.WAXED_COPPER_GRATED_REPEATER, "Waxed Copper Grated Repeater");
        this.addBlock(ChronoBlocks.WAXED_EXPOSED_COPPER_GRATED_REPEATER, "Waxed Exposed Copper Grated Repeater");
        this.addBlock(ChronoBlocks.WAXED_WEATHERED_COPPER_GRATED_REPEATER, "Waxed Weathered Copper Grated Repeater");
        this.addBlock(ChronoBlocks.WAXED_OXIDIZED_COPPER_GRATED_REPEATER, "Waxed Oxidized Copper Grated Repeater");

        this.addBlock(ChronoBlockEntityTypes.COPPER_GRATED_COMPARATOR, "Copper Grated Comparator");
        this.addBlock(ChronoBlockEntityTypes.EXPOSED_COPPER_GRATED_COMPARATOR, "Exposed Copper Grated Comparator");
        this.addBlock(ChronoBlockEntityTypes.WEATHERED_COPPER_GRATED_COMPARATOR, "Weathered Copper Grated Comparator");
        this.addBlock(ChronoBlockEntityTypes.OXIDIZED_COPPER_GRATED_COMPARATOR, "Oxidized Copper Grated Comparator");
        this.addBlock(ChronoBlockEntityTypes.WAXED_COPPER_GRATED_COMPARATOR, "Waxed Copper Grated Comparator");
        this.addBlock(ChronoBlockEntityTypes.WAXED_EXPOSED_COPPER_GRATED_COMPARATOR, "Waxed Exposed Copper Grated Comparator");
        this.addBlock(ChronoBlockEntityTypes.WAXED_OXIDIZED_COPPER_GRATED_COMPARATOR, "Waxed Oxidized Copper Grated Comparator");
        this.addBlock(ChronoBlockEntityTypes.WAXED_WEATHERED_COPPER_GRATED_COMPARATOR, "Waxed Weathered Copper Grated Comparator");


        this.addBlock(ChronoBlocks.COPPER_GRATED_REDSTONE_TORCH, "Copper Grated Torch");
        this.addBlock(ChronoBlocks.EXPOSED_COPPER_GRATED_REDSTONE_TORCH, "Exposed Copper Grated Redstone Torch");
        this.addBlock(ChronoBlocks.WEATHERED_COPPER_GRATED_REDSTONE_TORCH, "Weathered Copper Grated Redstone Torch");
        this.addBlock(ChronoBlocks.OXIDIZED_COPPER_GRATED_REDSTONE_TORCH, "Oxidized Copper Grated Redstone Torch");
        this.addBlock(ChronoBlocks.WAXED_COPPER_GRATED_REDSTONE_TORCH, "Waxed Copper Grated Redstone Torch");
        this.addBlock(ChronoBlocks.WAXED_EXPOSED_COPPER_GRATED_REDSTONE_TORCH, "Waxed Exposed Copper Grated Redstone Torch");
        this.addBlock(ChronoBlocks.WAXED_WEATHERED_COPPER_GRATED_REDSTONE_TORCH, "Waxed Weathered Copper Grated Redstone Torch");
        this.addBlock(ChronoBlocks.WAXED_OXIDIZED_COPPER_GRATED_REDSTONE_TORCH, "Waxed Oxidized Copper Grated Redstone Torch");

        this.addItem(ChronoBlocks.COPPER_GRATED_REDSTONE_TORCH_ITEM, "Copper Grated Torch");
        this.addItem(ChronoBlocks.EXPOSED_COPPER_GRATED_REDSTONE_TORCH_ITEM, "Exposed Copper Grated Redstone Torch");
        this.addItem(ChronoBlocks.WEATHERED_COPPER_GRATED_REDSTONE_TORCH_ITEM, "Weathered Copper Grated Redstone Torch");
        this.addItem(ChronoBlocks.OXIDIZED_COPPER_GRATED_REDSTONE_TORCH_ITEM, "Oxidized Copper Grated Redstone Torch");
        this.addItem(ChronoBlocks.WAXED_COPPER_GRATED_REDSTONE_TORCH_ITEM, "Waxed Copper Grated Redstone Torch");
        this.addItem(ChronoBlocks.WAXED_EXPOSED_COPPER_GRATED_REDSTONE_TORCH_ITEM, "Waxed Exposed Copper Grated Redstone Torch");
        this.addItem(ChronoBlocks.WAXED_WEATHERED_COPPER_GRATED_REDSTONE_TORCH_ITEM, "Waxed Weathered Copper Grated Redstone Torch");
        this.addItem(ChronoBlocks.WAXED_OXIDIZED_COPPER_GRATED_REDSTONE_TORCH_ITEM, "Waxed Oxidized Copper Grated Redstone Torch");

        HopperHelper(ChronoBlockEntityTypes.COPPER_HOPPER_BLOCK,"Copper Hopper");
        HopperHelper(ChronoBlockEntityTypes.EXPOSED_COPPER_HOPPER_BLOCK,"Exposed Copper Hopper");
        HopperHelper(ChronoBlockEntityTypes.WEATHERED_COPPER_HOPPER_BLOCK,"Weathered Copper Hopper");
        HopperHelper(ChronoBlockEntityTypes.OXIDIZED_COPPER_HOPPER_BLOCK,"Oxidized Copper Hopper");
        HopperHelper(ChronoBlockEntityTypes.WAXED_COPPER_HOPPER_BLOCK,"Waxed Copper Hopper");
        HopperHelper(ChronoBlockEntityTypes.WAXED_EXPOSED_COPPER_HOPPER_BLOCK,"Waxed Exposed Copper Hopper");
        HopperHelper(ChronoBlockEntityTypes.WAXED_WEATHERED_COPPER_HOPPER_BLOCK,"Waxed Weathered Copper Hopper");
        HopperHelper(ChronoBlockEntityTypes.WAXED_OXIDIZED_COPPER_HOPPER_BLOCK,"Waxed Oxidized Copper Hopper");
        HopperHelper(ChronoBlockEntityTypes.GOLD_HOPPER_BLOCK,"Gold Hopper");

        HopperHelper(ChronoBlockEntityTypes.PIPE_BLOCK,"Item Pipe");

        this.add("itemGroup.chrono_circuits", "Chrono Circuits");

    }

    private void HopperHelper(Supplier<? extends Block> key, String name) {
        this.addBlock(key,name);
        this.add(BuiltInRegistries.BLOCK.getKey(key.get()).toLanguageKey("container"),name);
    }
}
