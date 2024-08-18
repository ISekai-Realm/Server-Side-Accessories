package net.biryeongtrain.serversideconstruct.datagen;

import net.biryeongtrain.serversideconstruct.worldgen.ores.OnyxOreFeatures;
import net.biryeongtrain.serversideconstruct.worldgen.ores.SSCOreConfigFeatures;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.*;
import net.minecraft.world.gen.feature.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.biryeongtrain.serversideconstruct.ServerSideConstruct.MOD_ID;

public class WorldGenProvider extends FabricDynamicRegistryProvider {


    public WorldGenProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        var registryConfigured = registries
                .getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE);
        var registryPlaced = registries
                .getWrapperOrThrow(RegistryKeys.PLACED_FEATURE);

        entries.add(
                OnyxOreFeatures.ONYX_ORE_CONFIGURE,
                registryConfigured.getOrThrow(OnyxOreFeatures.ONYX_ORE_CONFIGURE).value()
        );

        entries.add(OnyxOreFeatures.ONYX_ORE_PLACE, registryPlaced.getOrThrow(OnyxOreFeatures.ONYX_ORE_PLACE).value());
    }

    public static void bootstrapConfigured(Registerable<ConfiguredFeature<?, ?>> context) {
        context.register(OnyxOreFeatures.ONYX_ORE_CONFIGURE, new ConfiguredFeature<OreFeatureConfig, OreFeature>(new OnyxOreFeatures(), SSCOreConfigFeatures.ONYX_ORE_CONFIGURE));
    }

    public static void bootstrapPlaced(Registerable<PlacedFeature> context) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> provider = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        context.register(
                OnyxOreFeatures.ONYX_ORE_PLACE,
                new PlacedFeature(provider.getOrThrow(OnyxOreFeatures.ONYX_ORE_CONFIGURE), List.of())
        );
    }


    @Override
    public String getName() {
        return MOD_ID + " worldgen provider";
    }
}
