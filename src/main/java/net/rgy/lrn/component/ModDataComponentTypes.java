package net.rgy.lrn.component;

import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.rgy.lrn.Learning;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {

    public static final ComponentType<BlockPos> COORDINATES = register("coordinates", builder -> builder.codec(BlockPos.CODEC));

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator){
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(Learning.MOD_ID,name),
                builderOperator.apply(ComponentType.builder()).build());
    }



    public static void registerModDataComponentTypes(){
        Learning.LOGGER.info("Registering Mod Data Component Types For: " + Learning.MOD_ID);
    }

}
