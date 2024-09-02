package net.biryeongtrain.serversideconstruct.item.rune;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.biryeongtrain.serversideconstruct.component.RuneAttributeInstance;
import net.biryeongtrain.serversideconstruct.utils.RandomHelper;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.floatprovider.UniformFloatProvider;
import net.minecraft.world.World;

public record RuneAttributes(RegistryEntry<EntityAttribute> attribute, EntityAttributeModifier.Operation operation,
                             UniformFloatProvider range, int weight, int genTier) {
    public static final Codec<RuneAttributes> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    EntityAttribute.CODEC.fieldOf("attribute").forGetter(RuneAttributes::attribute),
                    EntityAttributeModifier.Operation.CODEC.fieldOf("operation").forGetter(RuneAttributes::operation),
                    UniformFloatProvider.CODEC.fieldOf("range").forGetter(RuneAttributes::range),
                    Codec.INT.fieldOf("weight").forGetter(RuneAttributes::weight),
                    Codec.INT.fieldOf("gen_tier").forGetter(RuneAttributes::genTier)
            ).apply(instance, RuneAttributes::new)
    );

    public RuneAttributeInstance getAttributeInstance(World world) {
        return new RuneAttributeInstance(attribute, range.get(world.getRandom()), operation);
    }
}
