package net.rgy.lrn.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.rgy.lrn.Learning;
import net.rgy.lrn.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup LEARNING_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Learning.MOD_ID,"learning"),
            FabricItemGroup.builder().icon(()-> new ItemStack(ModItems.PINK_GARNET))
                    .displayName(Text.translatable("itemgroup.lrn.learning"))
                    .entries((displayContext, entries) -> {
                        //! ITEMS
                        entries.add(ModItems.RAW_PINK_GARNET);
                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModItems.CHISEL);
                        entries.add(ModItems.CAULIFLOWER);
                        entries.add(ModItems.STARLIGHT_ASHES);

                        //! BLOCKS
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.MAGIC_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_BUTTON);
                        entries.add(ModBlocks.PINK_GARNET_DOOR);
                        entries.add(ModBlocks.PINK_GARNET_FENCE);
                        entries.add(ModBlocks.PINK_GARNET_FENCE_GATE);
                        entries.add(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
                        entries.add(ModBlocks.PINK_GARNET_SLAB);
                        entries.add(ModBlocks.PINK_GARNET_WALL);
                        entries.add(ModBlocks.PINK_GARNET_TRAPDOOR);
                        entries.add(ModBlocks.PINK_GARNET_STAIRS);
                        entries.add(ModBlocks.PINK_GARNET_LAMP);



                    }).build());


    public static void registerItemGroups(){
        Learning.LOGGER.info("Registering Mod Item Groups For: " + Learning.MOD_ID);
    }
}
