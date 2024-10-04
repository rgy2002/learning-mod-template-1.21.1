package net.rgy.lrn.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.rgy.lrn.Learning;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {


    public static final RegistryEntry<ArmorMaterial> PINK_GARNET_ARMOR_MATERIAL = registerArmorMaterial("pink_garnet",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map ->{
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 11);
            }), 30, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,() -> Ingredient.ofItems(ModItems.PINK_GARNET_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Learning.MOD_ID, "pink_garnet"))), 4.0F,0.2F));


    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material){
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(Learning.MOD_ID, name), material.get());
    }
}
