package net.biryeongtrain.serversideconstruct.component;

import com.mojang.serialization.Codec;
import eu.pb4.polymer.core.api.utils.PolymerUtils;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.component.ComponentType;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.List;

public class JewelryComponent {
    public static final ComponentType<Integer> HEALTH_ROLL = register("jewelry_health_roll", ComponentType.<Integer>builder()
            .codec(Codec.INT)
            .packetCodec(PacketCodecs.INTEGER)
            .build()
    );

    public static final ComponentType<Integer> DAMAGE_ROLL = register("jewelry_damage_roll",ComponentType.<Integer>builder()
            .codec(Codec.INT)
            .packetCodec(PacketCodecs.INTEGER)
            .build()
    );

    public static final ComponentType<Integer> ARMOR_ROLL = register("jewelry_armor_roll", ComponentType.<Integer>builder()
            .codec(Codec.INT)
            .packetCodec(PacketCodecs.INTEGER)
            .build()
    );

    public static final ComponentType<List<RingComponent>> RING_ATTRIBUTE_COMPONENT = register("jewelry_rune_component", ComponentType.<List<RingComponent>>builder()
            .codec(RingComponent.CODEC.listOf())
            .build()
    );

    public static final ComponentType<List<AttributeInstance>> RUNE_ATTRIBUTE_COMPONENT = register("rune_attribute_component", ComponentType.<List<AttributeInstance>>builder()
            .codec(AttributeInstance.CODEC.listOf())
            .build()
    );

    public static <T> ComponentType<T> register(String path, ComponentType<T> item) {
        Registry.register(Registries.DATA_COMPONENT_TYPE, PathHelper.getModId(path), item);
        PolymerUtils.markAsPolymer(item);
        return item;
    }
}
