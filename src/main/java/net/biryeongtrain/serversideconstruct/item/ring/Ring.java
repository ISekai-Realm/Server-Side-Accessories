package net.biryeongtrain.serversideconstruct.item.ring;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import eu.pb4.polymer.core.api.item.PolymerItem;
import net.biryeongtrain.serversideconstruct.component.JewelryComponent;
import net.biryeongtrain.serversideconstruct.component.RuneComponent;
import net.biryeongtrain.serversideconstruct.component.RuneType;
import net.biryeongtrain.serversideconstruct.utils.RandomHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public abstract class Ring extends TrinketItem implements PolymerItem {
    public static final int MAX_RUNE_SLOTS = 4;

    public Ring(Settings settings) {
        super(settings);
    }

    public int getDamageDelayTicks() {
        return 20;
    }

    public List<RuneComponent> createRuneSlots() {
        int random = RandomHelper.getRandom(0, MAX_RUNE_SLOTS);
        List<RuneComponent> runeComponents = new ArrayList<>();
        for (int i = 0; i < random; i++) {
            RuneType type = RuneType.roll(this);
            runeComponents.add(new RuneComponent(type, List.of()));
        }
        return runeComponents;
    }

    @Override
    public abstract int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player);

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (!stack.contains(JewelryComponent.RUNE_COMPONENT)) {
            stack.set(JewelryComponent.RUNE_COMPONENT, this.createRuneSlots());
        }
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity.getWorld().isClient) {
            return;
        }

        if (getDamageDelayTicks() > 0 && entity.age % getDamageDelayTicks() == 0) {
            stack.damage(1, (ServerWorld) entity.getWorld(), entity instanceof ServerPlayerEntity ? (ServerPlayerEntity) entity : null, item -> {
            });
        }
    }

    @Override
    public void modifyClientTooltip(List<Text> tooltip, ItemStack stack, @Nullable ServerPlayerEntity player) {
        tooltip.add(Text.empty());
        if (stack.contains(JewelryComponent.RUNE_COMPONENT)) {
            List<RuneComponent> runeComponents = stack.get(JewelryComponent.RUNE_COMPONENT);
            runeComponents.forEach(runeComponent -> {
                var type = runeComponent.type();
                if (runeComponent.isEmpty()) {
                    tooltip.add(Text.translatable("item.ring.rune.tooltip.empty", "\uD83D\uDC8E", Text.translatable(type.getTranslatableKey())).withColor(type.rgbColor.getRgb()));
                } else {
                    tooltip.add(Text.translatable("item.ring.rune.tooltip.filled", "\uD83D\uDC8E", Text.translatable(type.getTranslatableKey())).withColor(type.rgbColor.getRgb()));
                }
            });
        }
    }

    @Override
    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, Identifier slotIdentifier) {
        var modifiers = super.getModifiers(stack, slot, entity, slotIdentifier);
        if (stack.contains(JewelryComponent.RUNE_COMPONENT)) {
            List<RuneComponent> runeComponents = stack.get(JewelryComponent.RUNE_COMPONENT);
            runeComponents.forEach(runeComponent -> {
                if (!runeComponent.isEmpty()) {
                    runeComponent.collectModifiers(modifiers, "ring");
                }
            });
        }

        return modifiers;
    }
}
