package net.biryeongtrain.serversideconstruct.item.rune;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.biryeongtrain.serversideconstruct.component.AttributeInstance;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.floatprovider.UniformFloatProvider;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

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

    public AttributeInstance getAttributeInstance(World world) {
        return new AttributeInstance(attribute, range.get(world.getRandom()), operation);
    }
    
    public static class Builder {
        private RegistryEntry<EntityAttribute> attribute;
        private EntityAttributeModifier.Operation operation;
        private UniformFloatProvider range;
        private int weight;
        private int genTier = -1;
        
        private Builder() {
        }
        
        public static Builder create() {
            return new Builder();
        }
        
        public Builder attribute(RegistryEntry<EntityAttribute> attribute) {
            this.attribute = attribute;
            return this;
        }
        
        public Builder operation(EntityAttributeModifier.Operation operation) {
            this.operation = operation;
            return this;
        }
        
        public Builder range(float min, float max) {
            this.range = UniformFloatProvider.create(min, max);
            return this;
        }
        
        public Builder weight(int weight) {
            this.weight = weight;
            return this;
        }
        
        public Builder genTier(int genTier) {
            this.genTier = genTier;
            return this;
        }
        
        public RuneAttributes build() {
            if (attribute == null || operation == null || range == null || genTier <= 0) {
                throw new IllegalStateException("Attribute, operation, and range must be set");
            }
            return new RuneAttributes(attribute, operation, range, weight, genTier);
        }
    }
}
