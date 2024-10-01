package net.rgy.lrn.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.rgy.lrn.Learning;

public class ModTags {
    public static class Blocks{
        private static TagKey<Block> createTag(String nm){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Learning.MOD_ID,nm));
        }
    }
    public static class Items{
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String nm){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Learning.MOD_ID,nm));
        }
    }
}
