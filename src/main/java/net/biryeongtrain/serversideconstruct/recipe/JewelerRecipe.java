package net.biryeongtrain.serversideconstruct.recipe;

import eu.pb4.polymer.core.api.item.PolymerRecipe;
import net.biryeongtrain.serversideconstruct.block.JewelerBlockEntity;
import net.biryeongtrain.serversideconstruct.recipe.input.JewelerInput;
import net.biryeongtrain.serversideconstruct.registry.SSCRecipeTypes;
import net.biryeongtrain.serversideconstruct.registry.item.SSCJewelryRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.world.World;

public interface JewelerRecipe extends Recipe<JewelerInput>, PolymerRecipe {

    @Override
    default RecipeType<?> getType() {
        return SSCRecipeTypes.JEWELER;
    }

    @Override
    default ItemStack createIcon() {
        return SSCJewelryRegistry.ONYX_RING.getDefaultStack();
    }
}
