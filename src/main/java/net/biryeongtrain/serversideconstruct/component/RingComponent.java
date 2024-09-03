package net.biryeongtrain.serversideconstruct.component;

import com.google.common.collect.Multimap;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.List;

public record RingComponent(RuneType type, List<AttributeInstance> components) {
    public static Codec<RingComponent> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            RuneType.CODEC.fieldOf("type").forGetter(RingComponent::type),
            AttributeInstance.CODEC.listOf().fieldOf("components").forGetter(RingComponent::components)
    ).apply(instance, RingComponent::new));

    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> collectModifiers(Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> modifiers, String slot) {
        components.forEach(component -> component.createModifier(modifiers, slot + "_rune"));

        return modifiers;
    }

    public boolean isEmpty() {
        return components.isEmpty();
    }
}
