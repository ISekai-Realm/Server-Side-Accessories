package net.biryeongtrain.serversideconstruct.item;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.biryeongtrain.serversideconstruct.attributes.Attributes;
import net.biryeongtrain.serversideconstruct.component.JewelryComponent;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.biryeongtrain.serversideconstruct.utils.RandomHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class OnyxRing extends Ring {
    public static PolymerModelData MODEL_DATA = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("onyx_ring"));

    public OnyxRing(Settings settings) {
        super(settings);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return MODEL_DATA.item();
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return MODEL_DATA.value();
    }

    @Override
    public void onCraft(ItemStack stack, World world) {
        super.onCraft(stack, world);
        stack.set(JewelryComponent.HEALTH_ROLL, 1);
        //test
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
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (world.isClient) {
            return;
        }
        if (stack.contains(JewelryComponent.HEALTH_ROLL)) {
            return;
        }

        if (entity instanceof ServerPlayerEntity) {
            stack.set(JewelryComponent.HEALTH_ROLL, RandomHelper.getRandom(1, 5));
        }
    }

    @Override
    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, Identifier slotIdentifier) {
        var modifiers = super.getModifiers(stack, slot, entity, slotIdentifier);
        modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(slotIdentifier, stack.getOrDefault(JewelryComponent.HEALTH_ROLL, 0), EntityAttributeModifier.Operation.ADD_VALUE));
        modifiers.put(EntityAttributes.PLAYER_MINING_EFFICIENCY, new EntityAttributeModifier(slotIdentifier, 10, EntityAttributeModifier.Operation.ADD_VALUE));
//        modifiers.put(EntityAttributes.PLAYER_BLOCK_BREAK_SPEED, new EntityAttributeModifier(slotIdentifier, 0.1, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        modifiers.put(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE, new EntityAttributeModifier(slotIdentifier, 1, EntityAttributeModifier.Operation.ADD_VALUE));
        return modifiers;
    }

    @Override
    public int getDamageDelayTicks() {
        return 1;
    }
}
