package net.biryeongtrain.serversideconstruct.item.ring;

import net.biryeongtrain.serversideconstruct.registry.item.SSCItemModelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import org.jetbrains.annotations.Nullable;

public class SapphireRing extends Ring{
    public SapphireRing(Settings settings) {
        super(settings);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return SSCItemModelRegistry.SAPPHIRE_RING_MODEL.item();
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return SSCItemModelRegistry.SAPPHIRE_RING_MODEL.value();
    }
}
