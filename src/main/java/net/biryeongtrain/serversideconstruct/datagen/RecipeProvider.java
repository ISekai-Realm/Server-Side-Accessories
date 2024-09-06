package net.biryeongtrain.serversideconstruct.datagen;

import net.biryeongtrain.serversideconstruct.recipe.GemInsertRecipe;
import net.biryeongtrain.serversideconstruct.recipe.RuneInfuseRecipe;
import net.biryeongtrain.serversideconstruct.registry.item.SSCItemTags;
import net.biryeongtrain.serversideconstruct.registry.item.SSCResourceItemRegistry;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.biryeongtrain.serversideconstruct.registry.item.SSCResourceItemRegistry.*;

public class RecipeProvider extends FabricRecipeProvider {
    public RecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        var gems = List.of(ONYX_GEM, OPAL_GEM, TOPAZ_GEM, SAPPHIRE_GEM, RUBY_GEM);
        for (var item : gems) {
            String path = item.getRegistryEntry().getKey().get().getValue().getPath();
            var result = Registries.ITEM.get(PathHelper.getModId(path.replace("gem", "ring")));
            of(exporter, new RecipeEntry<>(PathHelper.getModId("jeweler/insert_" + path), new GemInsertRecipe(Ingredient.ofItems(SSCResourceItemRegistry.IRON_RING_ITEM), Ingredient.ofItems(item), result.getDefaultStack())));
            of(exporter, new RecipeEntry<>(PathHelper.getModId("jeweler/infuse_" + path), new RuneInfuseRecipe(Ingredient.fromTag(SSCItemTags.JEWELRY_ITEMS), Ingredient.fromTag(SSCItemTags.RUNE_ITEMS))));
        }
    }

    public void of(RecipeExporter exporter, RecipeEntry<?>... recipes) {
        for (var recipe : recipes) {
            exporter.accept(recipe.id(), recipe.value(), null);
        }
    }
}
