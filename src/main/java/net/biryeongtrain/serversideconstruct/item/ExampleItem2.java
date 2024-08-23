package net.biryeongtrain.serversideconstruct.item;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.biryeongtrain.serversideconstruct.component.JewelryComponent;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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

public class ExampleItem2 extends Item implements PolymerItem {
    public ExampleItem2(Settings settings) {
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
            serverPlayer.networkHandler.sendPacket(new ExplosionS2CPacket(
                    serverPlayer.getX(),
                    serverPlayer.getY() - 9999,
                    serverPlayer.getZ(),
                    0,
                    List.of(),
                    new Vec3d(0, 0.4, 0),
                    Explosion.DestructionType.KEEP,
                    ParticleTypes.BUBBLE,
                    ParticleTypes.BUBBLE,
                    Registries.SOUND_EVENT.getEntry(SoundEvents.INTENTIONALLY_EMPTY)
            ));
        }

        return TypedActionResult.success(user.getStackInHand(hand), false);
    }
}
