package net.biryeongtrain.serversideconstruct.polydex;

import eu.pb4.polydex.api.v1.recipe.*;
import net.biryeongtrain.serversideconstruct.recipe.JewelerRecipe;
import net.biryeongtrain.serversideconstruct.registry.item.SSCJewelryRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class AbstractJewelerStationRecipeView<T extends JewelerRecipe> extends AbstractRecipePolydexPage<T> {
//    private final List<PolydexIngredient<?>> ingredients;

    public AbstractJewelerStationRecipeView(RecipeEntry<T> recipe) {
        super(recipe);
//        this.ingredients = List.of(PolydexIngredient.of(getBase()), PolydexIngredient.of(getAddition()), PolydexIngredient.of(getResult()));
    }

    @Override
    public ItemStack typeIcon(ServerPlayerEntity serverPlayerEntity) {
        return SSCJewelryRegistry.OPAL_RING.getDefaultStack();
    }

    @Override
    public void createPage(@Nullable PolydexEntry polydexEntry, ServerPlayerEntity serverPlayerEntity, PageBuilder pageBuilder) {
        pageBuilder.setIngredient(2, 2, this.getBaseItem(polydexEntry));
        pageBuilder.setIngredient(3, 2, this.getAddition());
        pageBuilder.setOutput(6, 2, this.getOutput(polydexEntry, serverPlayerEntity));
    }
    protected ItemStack[] getOutput(@Nullable PolydexEntry entry, ServerPlayerEntity player) {
        return new ItemStack[] { recipe.getResult(player.server.getRegistryManager()) };
    }


    protected Ingredient getBaseItem(@Nullable PolydexEntry entry) {
        return getBase();
    }

    @Override
    public List<PolydexCategory> categories() {
        return List.of(PolydexCompatImpl.CATEGORY);
    }

    protected abstract Ingredient getAddition();
    protected abstract Ingredient getBase();
}
