package net.biryeongtrain.serversideconstruct.registry;

import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class SSCWorldGenKeys {
    public static final RegistryKey<PlacedFeature> ONYX_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, PathHelper.getModId("onyx_ore"));

    public static void register() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ONYX_ORE_PLACED_KEY);
    }
}
