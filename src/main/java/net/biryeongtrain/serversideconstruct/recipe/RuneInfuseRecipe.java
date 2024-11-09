package net.biryeongtrain.serversideconstruct.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.biryeongtrain.serversideconstruct.component.JewelryComponent;
import net.biryeongtrain.serversideconstruct.component.RingComponent;
import net.biryeongtrain.serversideconstruct.component.RuneType;
import net.biryeongtrain.serversideconstruct.item.rune.Rune;
import net.biryeongtrain.serversideconstruct.recipe.input.JewelerInput;
import net.biryeongtrain.serversideconstruct.registry.RecipeSerializers;
import net.biryeongtrain.serversideconstruct.registry.item.SSCJewelryRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public record RuneInfuseRecipe(Ingredient base, Ingredient rune) implements JewelerRecipe {
    public static final MapCodec<RuneInfuseRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("base").forGetter(RuneInfuseRecipe::base),
            Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("rune").forGetter(RuneInfuseRecipe::rune)
    ).apply(instance, RuneInfuseRecipe::new));

    @Override
    public boolean matches(JewelerInput input, World world) {
        if (!(base.test(input.base()) && rune.test(input.addition()))) {
            return false;
        }
        if (!(input.addition().getItem() instanceof Rune rune)) {
            return false;
        }
        
        if (!input.addition().contains(JewelryComponent.RUNE_ATTRIBUTE_COMPONENT)) {
            return false;
        }
        
        List<RingComponent> list = input.base().getOrDefault(JewelryComponent.RING_ATTRIBUTE_COMPONENT, List.of());

        return list.stream().anyMatch((attribute) -> (attribute.type() == rune.getType() || attribute.type() == RuneType.EVERYTHING) && attribute.isEmpty());
    }

    @Override
    public ItemStack craft(JewelerInput input, RegistryWrapper.WrapperLookup lookup) {
        var stack = input.base().copyComponentsToNewStack(input.base().getItem(), 1);
        List<RingComponent> list = new ArrayList<>(stack.getOrDefault(JewelryComponent.RING_ATTRIBUTE_COMPONENT, List.of()));
        
        var attribute = list.stream()
                .filter((attr) -> attr.type() == ((Rune)input.addition().getItem()).getType() && attr.isEmpty())
                .findFirst()
                .orElse(null);
        
        if (attribute == null) {
            attribute = list.stream().filter((attr) -> attr.type() == RuneType.EVERYTHING).findFirst().orElse(null);
        }

        if (attribute == null) {
            return ItemStack.EMPTY;
        }
        
        list.remove(attribute);
        list.add(new RingComponent(attribute.type(), input.addition().getOrDefault(JewelryComponent.RUNE_ATTRIBUTE_COMPONENT, List.of())));
        
        stack.set(JewelryComponent.RING_ATTRIBUTE_COMPONENT, list);
        return stack;
    }

    @Override
    public boolean fits(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return SSCJewelryRegistry.OPAL_RING.getDefaultStack();
    }

    @Override
    public RecipeSerializer<RuneInfuseRecipe> getSerializer() {
        return RecipeSerializers.RUNE_INFUSE_RECIPE;
    }
}
