package net.biryeongtrain.serversideconstruct.worldgen;

import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.biryeongtrain.serversideconstruct.worldgen.ores.OnyxOreFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.Feature;

import java.util.function.Predicate;

public class WorldGenInit {
    public static void init() {
        registerFeature("onyx_ore", new OnyxOreFeatures(), OnyxOreFeatures.GENERATE_BIOMES, GenerationStep.Feature.UNDERGROUND_ORES);
    }

    public static void registerFeature(String registerName, Feature feature, Predicate<BiomeSelectionContext> biome, GenerationStep.Feature step) {
        Registry.register(Registries.FEATURE, PathHelper.getModId(registerName), feature);
        BiomeModifications.addFeature(biome, step, RegistryKey.of(RegistryKeys.PLACED_FEATURE, PathHelper.getModId(registerName)));
    }
}
