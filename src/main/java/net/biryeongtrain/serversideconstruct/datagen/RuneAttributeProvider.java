package net.biryeongtrain.serversideconstruct.datagen;

import net.biryeongtrain.serversideconstruct.component.RuneType;
import net.biryeongtrain.serversideconstruct.item.rune.RuneAttributes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricCodecDataProvider;
import net.minecraft.data.DataOutput;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.floatprovider.UniformFloatProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class RuneAttributeProvider extends FabricCodecDataProvider<List<RuneAttributes>> {
    protected RuneAttributeProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(dataOutput, registriesFuture, DataOutput.OutputType.DATA_PACK, "rune_attributes", RuneAttributes.CODEC.listOf());
    }


    @Override
    public String getName() {
        return "ss_construct";
    }

    @Override
    protected void configure(BiConsumer<Identifier, List<RuneAttributes>> provider, RegistryWrapper.WrapperLookup lookup) {
        provider.accept(RuneType.COMBAT.getId(), List.of(
                        // Tier 1
                        new RuneAttributes(EntityAttributes.GENERIC_ATTACK_DAMAGE, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, UniformFloatProvider.create(0.05f, 0.1f), 100, 1),
                        new RuneAttributes(EntityAttributes.GENERIC_ATTACK_DAMAGE, EntityAttributeModifier.Operation.ADD_VALUE, UniformFloatProvider.create(1f, 3f), 100, 1),
                        new RuneAttributes(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, EntityAttributeModifier.Operation.ADD_VALUE, UniformFloatProvider.create(0.05f, 0.1f), 100, 1),
                        new RuneAttributes(EntityAttributes.GENERIC_ARMOR, EntityAttributeModifier.Operation.ADD_VALUE, UniformFloatProvider.create(2f, 6f), 150, 1),
                        new RuneAttributes(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, UniformFloatProvider.create(0.1f, 0.2f), 150, 1),
                        new RuneAttributes(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, EntityAttributeModifier.Operation.ADD_VALUE, UniformFloatProvider.create(0.1f, 0.3f), 50, 1),

                        // Tier 2
                        RuneAttributes.Builder.create()
                                .attribute(EntityAttributes.GENERIC_ATTACK_DAMAGE)
                                .operation(EntityAttributeModifier.Operation.ADD_VALUE)
                                .range(3f, 5f)
                                .weight(100)
                                .genTier(2)
                                .build()
                        ,

                        RuneAttributes.Builder.create()
                                .attribute(EntityAttributes.GENERIC_ATTACK_DAMAGE)
                                .operation(EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                                .range(0.1f, 0.2f)
                                .weight(100)
                                .genTier(2)
                                .build()
                        ,

                        RuneAttributes.Builder.create()
                                .attribute(EntityAttributes.GENERIC_ATTACK_KNOCKBACK)
                                .operation(EntityAttributeModifier.Operation.ADD_VALUE)
                                .range(0.1f, 0.15f)
                                .weight(100)
                                .genTier(2)
                                .build()
                        ,

                        RuneAttributes.Builder.create()
                                .attribute(EntityAttributes.GENERIC_ARMOR)
                                .operation(EntityAttributeModifier.Operation.ADD_VALUE)
                                .range(6f, 10f)
                                .weight(150)
                                .genTier(2)
                                .build()
                )
        );
    }
}
