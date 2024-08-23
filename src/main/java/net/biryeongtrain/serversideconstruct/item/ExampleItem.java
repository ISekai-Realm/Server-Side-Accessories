package net.biryeongtrain.serversideconstruct.item;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.biryeongtrain.serversideconstruct.component.JewelryComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ExplosionS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ExampleItem extends Item implements PolymerItem {
    public ExampleItem(Settings settings) {
        super(settings);
    }


    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return Items.DIAMOND;
    }

    @Override
    public ItemStack getDefaultStack() {
        var stack = super.getDefaultStack();
        if (stack.contains(JewelryComponent.ARMOR_ROLL)) {
            return stack;
        }
        // ... Do Something
        stack.set(JewelryComponent.ARMOR_ROLL, 1);
        return stack;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user instanceof ServerPlayerEntity serverPlayer) {
            serverPlayer.addVelocity(0, 0.4, 0);
            serverPlayer.velocityModified = true;

        }

        return TypedActionResult.success(user.getStackInHand(hand), false);
    }
}
