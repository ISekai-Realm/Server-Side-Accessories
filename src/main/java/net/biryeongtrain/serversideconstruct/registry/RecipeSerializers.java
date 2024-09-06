package net.biryeongtrain.serversideconstruct.registry;

import com.mojang.serialization.MapCodec;
import eu.pb4.factorytools.api.recipe.LazyRecipeSerializer;
import net.biryeongtrain.serversideconstruct.recipe.GemInsertRecipe;
import net.biryeongtrain.serversideconstruct.recipe.RuneInfuseRecipe;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class RecipeSerializers {
    public static final LazyRecipeSerializer<GemInsertRecipe> GEM_INSERT_RECIPE = register("jeweler/gem_insert", GemInsertRecipe.CODEC);
    public static final LazyRecipeSerializer<RuneInfuseRecipe> RUNE_INFUSE_RECIPE = register("jeweler/rune_infuse", RuneInfuseRecipe.CODEC);
    public static void register() {

    }
    public static <T extends RecipeSerializer<?>> T register(String path, T recipeSerializer) {
        return Registry.register(Registries.RECIPE_SERIALIZER, PathHelper.getModId(path), recipeSerializer);
    }

    public static <T extends Recipe<?>> LazyRecipeSerializer<T> register(String path, MapCodec<T> codec) {
        return Registry.register(Registries.RECIPE_SERIALIZER, PathHelper.getModId(path), new LazyRecipeSerializer<>(codec));
    }
}
