package net.rgy.lrn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.rgy.lrn.block.ModBlocks;
import net.rgy.lrn.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator bsg) {
        bsg.registerSimpleCubeAll(ModBlocks.PINK_GARNET_BLOCK);
        bsg.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);
        bsg.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);
        bsg.registerSimpleCubeAll(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
        bsg.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator img) {
       img.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);
       img.register(ModItems.CHISEL, Models.GENERATED);
       img.register(ModItems.CAULIFLOWER, Models.GENERATED);
       img.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);
       img.register(ModItems.PINK_GARNET, Models.GENERATED);
    }
}
