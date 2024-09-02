package net.biryeongtrain.serversideconstruct.data;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.biryeongtrain.serversideconstruct.ServerSideConstruct;
import net.biryeongtrain.serversideconstruct.component.RuneAttributeInstance;
import net.biryeongtrain.serversideconstruct.component.RuneType;
import net.biryeongtrain.serversideconstruct.item.rune.RuneAttributes;
import net.biryeongtrain.serversideconstruct.utils.RandomHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;
import java.util.List;
import java.util.Random;

public class RuneAttributeManager {
    private static final EnumMap<RuneType, RuneAttributeManager> DATA = new EnumMap<>(RuneType.class);
    private static final RuneDataInstance EMPTY = new RuneDataInstance(RuneType.NOTHING, 0);

    private final Int2ObjectArrayMap<RuneDataInstance> data = new Int2ObjectArrayMap<>();
    public final RuneType type;

    RuneAttributeManager(RuneType type, List<RuneAttributes> attributes) {
        this.type = type;
        attributes.forEach(attribute -> {
            int tier = attribute.genTier();
            if (!data.containsKey(tier)) {
                var dataInstance = new RuneDataInstance(type, tier);
                dataInstance.add(attribute);
                data.put(tier, dataInstance);
            }
            data.get(tier).add(attribute);
        });
    }

    private RuneAttributeInstance getRandomRune(int tier, boolean currentTierOnly, World world) {
        List<RuneDataInstance> filter = new ObjectArrayList<>();
        if (!currentTierOnly) {
            this.data.forEach((key, value) -> {
                if (key <= tier) {
                    filter.add(value);
                }
            });
        } else {
            var instance = this.data.getOrDefault(tier, EMPTY);
            filter.add(instance);
        }
        int totalWeight = filter.stream().mapToInt(RuneDataInstance::getWeights).sum();
        int tierRandom = RandomHelper.getRandom(0, totalWeight);

        for (int i = filter.size() - 1; i >= 0; i--) {
            tierRandom -= filter.get(i).getWeights();
            if (tierRandom <= 0) {
                var instance = filter.get(i);
                var attribute = instance.getRandomAttribute();
                if (attribute != null) {
                    return attribute.getAttributeInstance(world);
                }
            }
        }

        return null;
    }


    static void reCalculate(EnumMap<RuneType, List<RuneAttributes>> map) {
        DATA.clear();

    }


    public static List<RuneDataInstance> getRandomRune(RuneType type, int tier, boolean duplicate, boolean currentTierOnly) {
        return null;
    }


    public static class RuneDataInstance {
        private int cachedWeight = -1;
        private final ObjectArrayList<RuneAttributes> attributes = new ObjectArrayList<>();
        private final int tier;

        RuneDataInstance(RuneType type, int tier) {
            this.tier = tier;
        }

        void add(RuneAttributes attributes) {
            if (attributes.genTier() == this.tier) {
                this.attributes.add(attributes);
                if (cachedWeight == -1) {
                    this.cachedWeight = attributes.weight();
                }
            } else {
                ServerSideConstruct.LOGGER.warn("Attempted to add a rune with a different tier to the rune data instance. This should not happen.");
            }
        }

        void clear() {
            this.attributes.clear();
            this.cachedWeight = -1;
        }

        public List<RuneAttributes> getAttributes() {
            return this.attributes.clone();
        }


        public int getTier() {
            return this.tier;
        }

        @Nullable
        RuneAttributes getRandomAttribute() {
            if (this.attributes.isEmpty()) {
                return null;
            }
            int random = RandomHelper.getRandom(0, cachedWeight);

            for (RuneAttributes attribute : this.attributes) {
                random -= attribute.weight();
                if (random <= 0) {
                    return attribute;
                }
            }

            return null;
        }

        int getWeights() {
            return this.cachedWeight;
        }
    }
}


