package net.biryeongtrain.serversideconstruct.component;

import com.mojang.serialization.Codec;
import eu.pb4.polymer.core.api.utils.PolymerUtils;
import net.minecraft.component.ComponentType;
import net.minecraft.network.codec.PacketCodecs;

public class JewelryComponent {
    public static final ComponentType<Integer> HEALTH_ROLL = ComponentType.<Integer>builder()
            .codec(Codec.INT)
            .packetCodec(PacketCodecs.INTEGER)
            .build();

    public static final ComponentType<Integer> DAMAGE_ROLL = ComponentType.<Integer>builder()
            .codec(Codec.INT)
            .packetCodec(PacketCodecs.INTEGER)
            .build();

    public static final ComponentType<Integer> ARMOR_ROLL = ComponentType.<Integer>builder()
            .codec(Codec.INT)
            .packetCodec(PacketCodecs.INTEGER)
            .build();

    static {
        PolymerUtils.markAsPolymer(HEALTH_ROLL);
        PolymerUtils.markAsPolymer(DAMAGE_ROLL);
        PolymerUtils.markAsPolymer(ARMOR_ROLL);
    }
}
