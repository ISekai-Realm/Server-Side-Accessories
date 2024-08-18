package net.biryeongtrain.serversideconstruct.item;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.biryeongtrain.serversideconstruct.component.JewelryComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import org.jetbrains.annotations.Nullable;

public class ExampleItem extends Item implements PolymerItem {
    public ExampleItem(Settings settings) {
        super(settings);
    }


    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return Items.DIAMOND;
    }

    @Override
    public ItemStack getDefaultStack() {
        var stack = super.getDefaultStack();
        if (stack.contains(JewelryComponent.ARMOR_ROLL)) {
            return stack;
        }
        // ... Do Something
        stack.set(JewelryComponent.ARMOR_ROLL, 1);
        return stack;
    }
}
