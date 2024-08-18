package net.biryeongtrain.serversideconstruct.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import eu.pb4.polymer.core.api.item.PolymerItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class Ring extends TrinketItem implements PolymerItem {

    public Ring(Settings settings) {
        super(settings);
    }

    public int getDamageDelayTicks() {
        return 20;
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity.getWorld().isClient) {
            return;
        }

        if (getDamageDelayTicks() > 0 && entity.age % getDamageDelayTicks() == 0) {
            stack.damage(1, (ServerWorld) entity.getWorld(), entity instanceof ServerPlayerEntity ? (ServerPlayerEntity) entity : null, item -> {});
        }
    }

    @Override
    public void modifyClientTooltip(List<Text> tooltip, ItemStack stack, @Nullable ServerPlayerEntity player) {
        tooltip.add(Text.translatable("item.ring.durability.tooltip", this.getDamageDelayTicks()));
    }
}
