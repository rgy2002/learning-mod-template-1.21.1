package net.rgy.lrn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.MinecartItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.rgy.lrn.Learning;
import net.rgy.lrn.block.ModBlocks;
import net.rgy.lrn.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static void offerPinkGarnetUpgradeRecipe(RecipeExporter exporter, Item input, RecipeCategory category, Item result) {
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(input), Ingredient.ofItems(ModItems.PINK_GARNET_INGOT), category, result
                )
                .criterion("has_pink_garnet", conditionsFromItem(ModItems.PINK_GARNET_INGOT))
                .offerTo(exporter, getItemPath(result) + "_smithing");
    }

    @Override
    public void generate(RecipeExporter exporter) {

        offerPinkGarnetUpgradeRecipe(exporter,Items.NETHERITE_HELMET,RecipeCategory.COMBAT,ModItems.PINK_GARNET_HELMET);
        offerPinkGarnetUpgradeRecipe(exporter,Items.NETHERITE_CHESTPLATE,RecipeCategory.COMBAT,ModItems.PINK_GARNET_CHESTPLATE);
        offerPinkGarnetUpgradeRecipe(exporter,Items.NETHERITE_LEGGINGS,RecipeCategory.COMBAT,ModItems.PINK_GARNET_LEGGINGS);
        offerPinkGarnetUpgradeRecipe(exporter,Items.NETHERITE_BOOTS,RecipeCategory.COMBAT,ModItems.PINK_GARNET_BOOTS);

        offerPinkGarnetUpgradeRecipe(exporter,Items.NETHERITE_INGOT,RecipeCategory.MISC,ModItems.PINK_GARNET_INGOT);

        offerPinkGarnetUpgradeRecipe(exporter,Items.NETHERITE_SWORD,RecipeCategory.COMBAT,ModItems.PINK_GARNET_SWORD);
        offerPinkGarnetUpgradeRecipe(exporter,Items.NETHERITE_PICKAXE,RecipeCategory.COMBAT,ModItems.PINK_GARNET_PICKAXE);
        offerPinkGarnetUpgradeRecipe(exporter,Items.NETHERITE_AXE,RecipeCategory.COMBAT,ModItems.PINK_GARNET_AXE);
        offerPinkGarnetUpgradeRecipe(exporter,Items.NETHERITE_SHOVEL,RecipeCategory.COMBAT,ModItems.PINK_GARNET_SHOVEL);
        offerPinkGarnetUpgradeRecipe(exporter,Items.NETHERITE_HOE,RecipeCategory.COMBAT,ModItems.PINK_GARNET_HOE);


        List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE, ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

        offerSmelting(exporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC,ModItems.PINK_GARNET, 0.8f,200,"pink_garnet");
        offerBlasting(exporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC,ModItems.PINK_GARNET, 1.6f,100,"pink_garnet");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET_INGOT,RecipeCategory.DECORATIONS,ModBlocks.PINK_GARNET_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RAW_PINK_GARNET)
                .criterion(hasItem(ModItems.RAW_PINK_GARNET), conditionsFromItem(ModItems.RAW_PINK_GARNET))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 9)
                .input(ModBlocks.RAW_PINK_GARNET_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PINK_GARNET_STAIRS,4)
                .pattern("R  ")
                .pattern("RR ")
                .pattern("RRR")
                .input('R', ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(exporter);

        offerSlabRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.PINK_GARNET_SLAB,ModItems.PINK_GARNET);
        offerWallRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.PINK_GARNET_WALL,ModItems.PINK_GARNET);
        offerPressurePlateRecipe(exporter,ModBlocks.PINK_GARNET_PRESSURE_PLATE,ModItems.PINK_GARNET);



        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PINK_GARNET_TRAPDOOR,2)
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PINK_GARNET_DOOR,3)
                .pattern("RR ")
                .pattern("RR ")
                .pattern("RR ")
                .input('R', ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PINK_GARNET_BUTTON, 1)
                .input(ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PINK_GARNET_FENCE,3)
                .pattern("RZR")
                .pattern("RZR")
                .input('R', ModItems.PINK_GARNET)
                .input('Z', Items.IRON_INGOT)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);





    }
}
