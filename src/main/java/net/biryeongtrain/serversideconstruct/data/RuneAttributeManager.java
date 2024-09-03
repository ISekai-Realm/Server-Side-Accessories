package net.biryeongtrain.serversideconstruct.data;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.biryeongtrain.serversideconstruct.ServerSideConstruct;
import net.biryeongtrain.serversideconstruct.component.AttributeInstance;
import net.biryeongtrain.serversideconstruct.component.RuneType;
import net.biryeongtrain.serversideconstruct.item.rune.RuneAttributes;
import net.minecraft.world.World;

import java.util.EnumMap;
import java.util.List;

public class RuneAttributeManager {

    private static final EnumMap<RuneType, RuneAttributeInstance> DATA = new EnumMap<>(RuneType.class);
    public static final RuneAttributeInstance.RuneAttributeData EMPTY = new RuneAttributeInstance.RuneAttributeData(RuneType.NOTHING, 0);

    static void reCalculate(EnumMap<RuneType, List<RuneAttributes>> map) {
        DATA.clear();
        map.forEach((type, attributes) -> DATA.put(type, new RuneAttributeInstance(type, attributes)));
    }


    //TODO : NULL-SAFETY
    public static List<AttributeInstance> getRandomRuneData(RuneType type, int attempt, int tier, boolean duplicate, boolean currentTierOnly, World world) {
        if (!DATA.containsKey(type)) {
            return List.of();
        }
        List<AttributeInstance> dataInstances = new ObjectArrayList<>();
        var manager = DATA.get(type);
        if (manager == null) {
            ServerSideConstruct.LOGGER.error("Failed to get rune attribute manager for type: {}, tier : {}", type.name(), tier);
            return List.of();
        }
        var instance = manager.getRandomRune(attempt, tier, currentTierOnly, duplicate, world);
        if (instance == null) return List.of();

        dataInstances.addAll(instance);

        return dataInstances;
    }
}
