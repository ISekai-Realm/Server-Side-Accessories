package net.biryeongtrain.serversideconstruct.item;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import eu.pb4.polymer.core.api.item.PolymerItem;
import net.biryeongtrain.serversideconstruct.component.JewelryComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class TestTrinket extends TrinketItem implements PolymerItem {
    public TestTrinket(Settings settings) {
        super(settings);
    }

    private boolean checkValid(SlotReference slot, LivingEntity entity) {
        return entity instanceof ServerPlayerEntity || slot.getId().equals("hand/ring");
    }

    @Override
    public boolean canEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        return checkValid(slot, entity);
    }

    @Override
    public boolean canUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        return checkValid(slot, entity);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return Items.PAPER;
    }

    @Override
    public void onCraft(ItemStack stack, World world) {
        stack.set(JewelryComponent.HEALTH_ROLL, 1);
    }

    

    @Override
    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, Identifier slotIdentifier) {
        var modifier = super.getModifiers(stack, slot, entity, slotIdentifier);
        modifier.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(slotIdentifier, 0.1, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        modifier.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(slotIdentifier, stack.getOrDefault(JewelryComponent.HEALTH_ROLL, 20), EntityAttributeModifier.Operation.ADD_VALUE));

//        SlotAttributes.addSlotModifier(modifier, "hand/ring", slotIdentifier, 1, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        return modifier;
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity.getWorld().isClient) {
            return;
        }
        if (entity.age % 20 == 0) {

            stack.damage(1, (ServerWorld) entity.getEntityWorld(), entity instanceof ServerPlayerEntity ? (ServerPlayerEntity) entity : null, item ->{});
        }
    }

}
