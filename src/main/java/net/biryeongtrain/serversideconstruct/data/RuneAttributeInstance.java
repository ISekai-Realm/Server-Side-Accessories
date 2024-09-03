package net.biryeongtrain.serversideconstruct.data;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.biryeongtrain.serversideconstruct.ServerSideConstruct;
import net.biryeongtrain.serversideconstruct.component.AttributeInstance;
import net.biryeongtrain.serversideconstruct.component.RuneType;
import net.biryeongtrain.serversideconstruct.item.rune.RuneAttributes;
import net.biryeongtrain.serversideconstruct.utils.RandomHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RuneAttributeInstance {

    private final Int2ObjectArrayMap<RuneAttributeData> data = new Int2ObjectArrayMap<>();
    public final RuneType type;

    RuneAttributeInstance(RuneType type, List<RuneAttributes> attributes) {
        this.type = type;
        attributes.forEach(attribute -> {
            int tier = attribute.genTier();
            if (!data.containsKey(tier)) {
                var dataInstance = new RuneAttributeData(type, tier);
                dataInstance.add(attribute);
                data.put(tier, dataInstance);
            } else {
                data.get(tier).add(attribute);
            }
        });
    }

    @Nullable
    public List<AttributeInstance> getRandomRune(int attempt, int tier, boolean currentTierOnly, boolean duplicate, World world) {
        List<RuneAttributeData> filter = new ObjectArrayList<>();
        List<RuneAttributes> result = new ObjectArrayList<>();

        if (!currentTierOnly) {
            this.data.forEach((key, value) -> {
                if (key <= tier) {
                    filter.add(value);
                }
            });
        } else {
            var instance = this.data.getOrDefault(tier, RuneAttributeManager.EMPTY);
            filter.add(instance);
        }
        int totalWeight = filter.stream().mapToInt(RuneAttributeData::getWeights).sum();

        for (int i = 0; i < attempt; i++) {
            int tierRandom = RandomHelper.getRandom(0, totalWeight);
            for (int j = filter.size() - 1; j >= 0; j--) {
                tierRandom -= filter.get(j).getWeights();
                if (tierRandom <= 0) {
                    var instance = filter.get(j);
                    var attribute = instance.getRandomAttribute(duplicate ? null : result);
                    if (attribute != null) {
                        result.add(attribute);
                    }
                }
            }
        }

        return result.stream().map(attribute -> attribute.getAttributeInstance(world)).toList();
    }


    public static class RuneAttributeData {
        private int cachedWeight = -1;
        private final ObjectArrayList<RuneAttributes> attributes = new ObjectArrayList<>();
        private final int tier;

        RuneAttributeData(RuneType type, int tier) {
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

        public List<RuneAttributes> getAttributes() {
            return this.attributes.clone();
        }


        public int getTier() {
            return this.tier;
        }

        @Nullable
        RuneAttributes getRandomAttribute(@Nullable List<RuneAttributes> blacklist) {
            if (this.attributes.isEmpty()) {
                return null;
            }
            List<RuneAttributes> list = blacklist != null ? this.getAttributes().stream().filter(data -> !blacklist.contains(data)).toList() : this.getAttributes();
            int random = RandomHelper.getRandom(0, cachedWeight);

            for (RuneAttributes attribute : list) {
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


