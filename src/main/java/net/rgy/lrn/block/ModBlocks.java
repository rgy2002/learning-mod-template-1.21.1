package net.rgy.lrn.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.rgy.lrn.Learning;
import net.rgy.lrn.block.custom.MagicBlock;
import net.rgy.lrn.block.custom.PinkGarnetLampBlock;

public class ModBlocks {

    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4.5f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .hardness(6.2f)));

    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(5.5f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .hardness(7.2f)));

    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .hardness(6.2f)));

    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerBlock("deepslate_pink_garnet_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),AbstractBlock.Settings.create()
                    .strength(5f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)
                    .hardness(7.2f)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create()
                    .strength(1f)
                    .sounds(BlockSoundGroup.DEEPSLATE)
                    .requiresTool()
                    .hardness(7.2f)));

    public static final Block PINK_GARNET_STAIRS = registerBlock("pink_garnet_stairs",
            new StairsBlock(ModBlocks.PINK_GARNET_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create()
                            .strength(2)
                            .requiresTool()
                            .hardness(3)));

    public static final Block PINK_GARNET_SLAB = registerBlock("pink_garnet_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                            .strength(2)
                            .requiresTool()
                            .hardness(3)));

    public static final Block PINK_GARNET_BUTTON = registerBlock("pink_garnet_button",
            new ButtonBlock(BlockSetType.IRON, 20,
                    AbstractBlock.Settings.create()
                            .strength(2)
                            .requiresTool()
                            .noCollision()
                            .hardness(3)));

    public static final Block PINK_GARNET_PRESSURE_PLATE = registerBlock("pink_garnet_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.create()
                            .strength(2)
                            .requiresTool()
                            .hardness(3)));

    public static final Block PINK_GARNET_FENCE = registerBlock("pink_garnet_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                            .strength(2)
                            .requiresTool()
                            .hardness(3)));

    public static final Block PINK_GARNET_FENCE_GATE = registerBlock("pink_garnet_fence_gate",
            new FenceGateBlock(WoodType.ACACIA,
                    AbstractBlock.Settings.create()
                            .strength(2)
                            .requiresTool()
                            .hardness(3)));

    public static final Block PINK_GARNET_WALL = registerBlock("pink_garnet_wall",
            new WallBlock(AbstractBlock.Settings.create()
                            .strength(2)
                            .requiresTool()
                            .hardness(3)));

    public static final Block PINK_GARNET_DOOR = registerBlock("pink_garnet_door",
            new DoorBlock(BlockSetType.IRON,AbstractBlock.Settings.create()
                    .strength(2)
                    .requiresTool()
                    .nonOpaque()
                    .hardness(3)));

    public static final Block PINK_GARNET_TRAPDOOR = registerBlock("pink_garnet_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON,AbstractBlock.Settings.create()
                    .strength(2)
                    .requiresTool()
                    .nonOpaque()
                    .hardness(3)));

    public static final Block PINK_GARNET_LAMP = registerBlock("pink_garnet_lamp",
            new PinkGarnetLampBlock(AbstractBlock.Settings.create()
                    .strength(2)
                    .requiresTool()
                    .luminance(state -> state.get(PinkGarnetLampBlock.CLICKED) ? 15 : 0)
                    .hardness(3)));




    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Learning.MOD_ID,name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(Learning.MOD_ID,name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        Learning.LOGGER.info("Registering Mod Blocks for: " + Learning.MOD_ID);


    }
}
