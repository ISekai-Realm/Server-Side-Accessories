package net.biryeongtrain.serversideconstruct.polydex;

import eu.pb4.polydex.api.v1.recipe.PolydexEntry;
import net.biryeongtrain.serversideconstruct.recipe.GemInsertRecipe;
import net.biryeongtrain.serversideconstruct.registry.item.SSCJewelryRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import org.jetbrains.annotations.Nullable;

public class GemInsertPage extends AbstractJewelerStationRecipeView<GemInsertRecipe> {
    private static final Ingredient DEFAULT = Ingredient.ofItems(SSCJewelryRegistry.OPAL_RING);
    public GemInsertPage(RecipeEntry<GemInsertRecipe> recipe) {
        super(recipe);
    }

    @Override
    protected Ingredient getAddition() {
        return recipe.addition();
    }

    @Override
    protected Ingredient getBase() {
        return recipe.base();
    }

    @Override
    public String getGroup() {
        return "gem_insert";
    }

    @Override
    protected Ingredient getBaseItem(@Nullable PolydexEntry entry) {
        return entry != null && getBase().test((ItemStack) entry.stack().getBacking()) ? Ingredient.ofStacks((ItemStack) entry.stack().getBacking()) : DEFAULT;
    }

    @Override
    public boolean syncWithClient(ServerPlayerEntity player) {
        return true;
    }

    @Override
    public int priority() {
        return 100;
    }
    
    @Override
    protected ItemStack[] getOutput(@Nullable PolydexEntry entry, ServerPlayerEntity player) {
        
//        ItemStack baseStack = entry != null && getBase().test((ItemStack) entry.stack().getBacking()) ? (ItemStack) entry.stack().getBacking() : DEFAULT;
//        for (var material : PolydexImplUtils.readIngredient(getAddition())) {
//            Optional<RegistryEntry.Reference<ArmorTrimMaterial>> optional = ArmorTrimMaterials.get(player.server.getRegistryManager(), material);
//            if (optional.isPresent() && optional2.isPresent()) {
//                //Optional<ArmorTrim> optional3 = ArmorTrim.getTrim(player.server.getRegistryManager(), addition, true);
//                //if (optional3.isPresent() && optional3.get().equals(optional2.get(), optional.get())) {
//                //    continue;
//                //}
//
//                ItemStack itemStack2 = baseStack.copy();
//                itemStack2.setCount(1);
//                itemStack2.set(this.recipe.craft(new JewelerInput(baseStack, addition, player.getWorld())), );
//                list.add(itemStack2);
//            }
//        }
//
//        return list.toArray(new ItemStack[0]);
    return null;
    }
    
}
