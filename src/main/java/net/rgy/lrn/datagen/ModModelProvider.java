package net.rgy.lrn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.rgy.lrn.block.ModBlocks;
import net.rgy.lrn.block.custom.PinkGarnetLampBlock;
import net.rgy.lrn.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator bsg) {
        BlockStateModelGenerator.BlockTexturePool pinkGarnetPool = bsg.registerCubeAllModelTexturePool(ModBlocks.PINK_GARNET_BLOCK);
        bsg.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);
        bsg.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);
        bsg.registerSimpleCubeAll(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
        bsg.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);

        pinkGarnetPool.stairs(ModBlocks.PINK_GARNET_STAIRS);
        pinkGarnetPool.fence(ModBlocks.PINK_GARNET_FENCE);
        pinkGarnetPool.fenceGate(ModBlocks.PINK_GARNET_FENCE_GATE);
        pinkGarnetPool.button(ModBlocks.PINK_GARNET_BUTTON);
        pinkGarnetPool.slab(ModBlocks.PINK_GARNET_SLAB);
        pinkGarnetPool.pressurePlate(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
        pinkGarnetPool.wall(ModBlocks.PINK_GARNET_WALL);

        bsg.registerDoor(ModBlocks.PINK_GARNET_DOOR);
        bsg.registerTrapdoor(ModBlocks.PINK_GARNET_TRAPDOOR);

        Identifier lampIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.PINK_GARNET_LAMP, bsg.modelCollector);
        Identifier lampOnIdentifier = bsg.createSubModel(ModBlocks.PINK_GARNET_LAMP,"_on",Models.CUBE_ALL, TextureMap::all);
        bsg.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.PINK_GARNET_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(PinkGarnetLampBlock.CLICKED,lampOnIdentifier,lampIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator img) {
       img.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);
       img.register(ModItems.PINK_GARNET_INGOT, Models.GENERATED);
       img.register(ModItems.CHISEL, Models.GENERATED);
       img.register(ModItems.CAULIFLOWER, Models.GENERATED);
       img.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);
       img.register(ModItems.PINK_GARNET, Models.GENERATED);

       img.registerArmor(((ArmorItem) ModItems.PINK_GARNET_HELMET));
       img.registerArmor(((ArmorItem) ModItems.PINK_GARNET_CHESTPLATE));
       img.registerArmor(((ArmorItem) ModItems.PINK_GARNET_LEGGINGS));
       img.registerArmor(((ArmorItem) ModItems.PINK_GARNET_BOOTS));

       img.register(ModItems.PINK_GARNET_SWORD,Models.HANDHELD);
       img.register(ModItems.PINK_GARNET_PICKAXE,Models.HANDHELD);
       img.register(ModItems.PINK_GARNET_AXE,Models.HANDHELD);
       img.register(ModItems.PINK_GARNET_SHOVEL,Models.HANDHELD);
       img.register(ModItems.PINK_GARNET_HOE,Models.HANDHELD);
       img.register(ModItems.PINK_GARNET_HAMMER,Models.HANDHELD);
    }
}
