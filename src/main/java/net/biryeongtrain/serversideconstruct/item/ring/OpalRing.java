package net.biryeongtrain.serversideconstruct.item.ring;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import net.biryeongtrain.serversideconstruct.registry.item.SSCItemModelRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class OpalRing extends Ring {
    public OpalRing(Settings settings) {
        super(settings);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return SSCItemModelRegistry.OPAL_RING_MODEL.item();
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return SSCItemModelRegistry.OPAL_RING_MODEL.value();
    }

    // TODO : Implement the getModifiers method
    @Override
    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, Identifier slotIdentifier) {
        return super.getModifiers(stack, slot, entity, slotIdentifier);
    }
}
