package net.biryeongtrain.serversideconstruct.item.rune;

import eu.pb4.placeholders.api.PlaceholderContext;
import eu.pb4.placeholders.api.parsers.TagParser;
import eu.pb4.placeholders.api.parsers.TextParserV1;
import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import net.biryeongtrain.serversideconstruct.component.AttributeInstance;
import net.biryeongtrain.serversideconstruct.component.JewelryComponent;
import net.biryeongtrain.serversideconstruct.component.RuneType;
import net.biryeongtrain.serversideconstruct.data.RuneAttributeInstance;
import net.biryeongtrain.serversideconstruct.data.RuneAttributeManager;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.biryeongtrain.serversideconstruct.utils.RandomHelper;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Rune extends Item implements PolymerItem {
    private final RuneTier tier;
    private final PolymerModelData modelData;
    private final RuneType type;
    private static final String RUNE_UNIDENTIFIED = "<#ff4063><lang item.ss_construct.rune.unidentified.lore> <key key.use><reset>";

    public Rune(Settings settings, RuneTier tier, RuneType type, PolymerModelData data) {
        super(settings);
        this.tier = tier;
        this.type = type;
        this.modelData = data;
    }

    public RuneType getType() {
        return type;
    }
    public RuneTier getTier() {
        return this.tier;
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return modelData.value();
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return modelData.item();
    }

    public boolean currentTierOnly() {
        return false;
    }

    public boolean canAttributeDuplicated() {
        return false;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (hand != Hand.MAIN_HAND) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }
        var originalStack = user.getStackInHand(hand);

        if (!originalStack.contains(JewelryComponent.RING_ATTRIBUTE_COMPONENT)) {
            var stack = new ItemStack(this);
            var attempt = RandomHelper.getRandom(getTier().minAttributes, getTier().maxAttributes);
            var list = generateType(attempt,getTier().tier,  currentTierOnly(), canAttributeDuplicated(), world);
            if (list.isEmpty()) {
                return TypedActionResult.fail(originalStack);
            }
            stack.set(JewelryComponent.RUNE_ATTRIBUTE_COMPONENT, list);
            var modifier = stack.getOrDefault(DataComponentTypes.ATTRIBUTE_MODIFIERS, AttributeModifiersComponent.DEFAULT);

            int i = 0;
            for (AttributeInstance attributeInstance : list) {
                modifier = modifier.with(
                        attributeInstance.attribute(),
                        new EntityAttributeModifier(PathHelper.getModId("rune_attribute_" + i), attributeInstance.value(), attributeInstance.operation()),
                        AttributeModifierSlot.MAINHAND);
            }
            stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, modifier);

            user.getInventory().offerOrDrop(stack);
            originalStack.decrementUnlessCreative(1, user);
            return TypedActionResult.success(originalStack);
        }

        return TypedActionResult.pass(originalStack);
    }

    @Override
    public void modifyClientTooltip(List<Text> tooltip, ItemStack stack, @Nullable ServerPlayerEntity player) {
        tooltip.add(Text.empty());
        tooltip.add(TagParser.DEFAULT.parseNode(RUNE_UNIDENTIFIED).toText());
    }

    public List<AttributeInstance> generateType(int attempt, int tier, boolean currentTierOnly, boolean duplicate, World world) {
        return RuneAttributeManager.getRandomRuneData(getType(), attempt, tier, currentTierOnly, duplicate, world);
    }
}
