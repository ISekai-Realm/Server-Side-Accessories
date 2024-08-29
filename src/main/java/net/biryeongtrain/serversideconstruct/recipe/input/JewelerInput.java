package net.biryeongtrain.serversideconstruct.recipe.input;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.world.World;

import java.util.List;

public record JewelerInput(ItemStack base, ItemStack addition, World world) implements RecipeInput {
    @Override
    public ItemStack getStackInSlot(int slot) {
        if (slot == 0) {
            return this.base;
        } else if (slot == 1) {
            return this.addition;
        } else {
            throw new IllegalArgumentException("Invalid slot " + slot);
        }
    }

    @Override
    public int getSize() {
        return 2;
    }
}
