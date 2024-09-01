package net.biryeongtrain.serversideconstruct.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.biryeongtrain.serversideconstruct.recipe.input.JewelerInput;
import net.biryeongtrain.serversideconstruct.registry.RecipeSerializers;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;

public record GemInsertRecipe(Ingredient base, Ingredient addition, ItemStack result) implements JewelerRecipe {
    public static final MapCodec<GemInsertRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("base").forGetter(GemInsertRecipe::base),
                    Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("addition").forGetter(GemInsertRecipe::addition),
                    ItemStack.CODEC.fieldOf("result").forGetter(GemInsertRecipe::result)
            ).apply(instance, GemInsertRecipe::new)
    );
    @Override
    public boolean matches(JewelerInput input, World world) {
        return this.base().test(input.base()) && this.addition().test(input.addition());
    }

    @Override
    public ItemStack craft(JewelerInput input, RegistryWrapper.WrapperLookup lookup) {
        var stack =  this.result().copy();
        stack.getItem().onCraft(stack, input.world());

        return stack;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return this.result;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializers.GEM_INSERT_RECIPE;
    }
}
