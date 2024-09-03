package net.biryeongtrain.serversideconstruct.component;

import com.google.common.collect.Multimap;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.registry.entry.RegistryEntry;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public record AttributeInstance(RegistryEntry<EntityAttribute> attribute, double value, EntityAttributeModifier.Operation operation) {
    public static Codec<AttributeInstance> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            EntityAttribute.CODEC.fieldOf("attribute").forGetter(AttributeInstance::attribute),
            Codec.DOUBLE.fieldOf("value").forGetter(AttributeInstance::value),
            EntityAttributeModifier.Operation.CODEC.fieldOf("operation").forGetter(AttributeInstance::operation)
    ).apply(instance, AttributeInstance::new));

    @Contract("_, _ -> param1")
    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> createModifier(@NotNull Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> modifiers, @NotNull String id) {
        modifiers.put(attribute, new EntityAttributeModifier(PathHelper.getModId(id), value, operation));
        return modifiers;
    }
}
