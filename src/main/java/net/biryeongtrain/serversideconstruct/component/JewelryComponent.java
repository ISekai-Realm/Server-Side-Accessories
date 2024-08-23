package net.biryeongtrain.serversideconstruct.component;

import com.mojang.serialization.Codec;
import eu.pb4.polymer.core.api.utils.PolymerUtils;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.component.ComponentType;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class JewelryComponent {
    public static final ComponentType<Integer> HEALTH_ROLL = register("jewelry_health_roll", ComponentType.<Integer>builder()
            .codec(Codec.INT)
            .packetCodec(PacketCodecs.INTEGER)
            .build()
    );

    public static final ComponentType<Integer> DAMAGE_ROLL =  register("jewelry_damage_roll",ComponentType.<Integer>builder()
            .codec(Codec.INT)
            .packetCodec(PacketCodecs.INTEGER)
            .build()
    );

    public static final ComponentType<Integer> ARMOR_ROLL = register("jewerly_armor_roll", ComponentType.<Integer>builder()
            .codec(Codec.INT)
            .packetCodec(PacketCodecs.INTEGER)
            .build()
    );

    public static <T> ComponentType<T> register(String path, ComponentType<T> item) {
        Registry.register(Registries.DATA_COMPONENT_TYPE, PathHelper.getModId(path), item);
        PolymerUtils.markAsPolymer(item);
        return item;
    }
}
