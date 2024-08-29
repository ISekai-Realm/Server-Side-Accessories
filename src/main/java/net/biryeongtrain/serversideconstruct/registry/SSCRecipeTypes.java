package net.biryeongtrain.serversideconstruct.registry;

import net.biryeongtrain.serversideconstruct.ServerSideConstruct;
import net.biryeongtrain.serversideconstruct.recipe.JewelerRecipe;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class SSCRecipeTypes {
    public static final RecipeType<JewelerRecipe> JEWELER = register("jeweler");

    public static <T extends Recipe<?>> RecipeType<T> register(String path) {
        return Registry.register(Registries.RECIPE_TYPE, PathHelper.getModId(path), new RecipeType<T>() {
            @Override
            public String toString() {
                return ServerSideConstruct.MOD_ID + ":" + path;
            }
        });
    }

    public static void register() {

    }
}
