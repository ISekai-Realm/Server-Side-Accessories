package net.biryeongtrain.serversideconstruct.component;

import com.mojang.serialization.Codec;
import eu.pb4.polymer.core.api.utils.PolymerUtils;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.component.ComponentType;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ToolComponents {
    //Copper Type
    public static final ComponentType<Long> COPPER_AGE = register("copper_age", ComponentType.<Long>builder()
            .codec(Codec.LONG)
            .packetCodec(PacketCodecs.VAR_LONG)
            .build()
    );

    public static <T> ComponentType<T> register(String path, ComponentType<T> item) {
        Registry.register(Registries.DATA_COMPONENT_TYPE, PathHelper.getModId(path), item);
        PolymerUtils.markAsPolymer(item);
        return item;
    }
}
