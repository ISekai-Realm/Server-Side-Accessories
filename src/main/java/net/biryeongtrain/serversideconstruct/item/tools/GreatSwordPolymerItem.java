package net.biryeongtrain.serversideconstruct.item.tools;

import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;

import static net.biryeongtrain.serversideconstruct.item.tools.SpearPolymerItem.BASE_LEACH_MODIFIER_ID;

public class GreatSwordPolymerItem extends ToolPolymerItem {
    public static final Identifier BASE_MOVEMENT_SPEED_MODIFIER_ID = Identifier.ofVanilla("base_movement_speed");
    public GreatSwordPolymerItem(ToolMaterial material, Settings settings, PolymerModelData data) {
        super(material, settings, data);
    }

    public static AttributeModifiersComponent createAttributeModifiers(ToolMaterial material, int baseAttackDamage, float attackSpeed) {
        return AttributeModifiersComponent
                .builder()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, (float)baseAttackDamage + material.getAttackDamage(), EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND)
                .add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(BASE_LEACH_MODIFIER_ID, 1.0, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(BASE_MOVEMENT_SPEED_MODIFIER_ID, -0.1, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL), AttributeModifierSlot.MAINHAND)
                .build();
    }
}
