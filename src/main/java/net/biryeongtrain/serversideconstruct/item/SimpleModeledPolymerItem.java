package net.biryeongtrain.serversideconstruct.item;

import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import org.jetbrains.annotations.Nullable;

public class SimpleModeledPolymerItem extends Item implements PolymerItem {
    private final PolymerModelData modelData;

    public SimpleModeledPolymerItem(Settings settings, PolymerModelData modelData) {
        super(settings);
        this.modelData = modelData;
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return modelData.item();
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return modelData.value();
    }
}
