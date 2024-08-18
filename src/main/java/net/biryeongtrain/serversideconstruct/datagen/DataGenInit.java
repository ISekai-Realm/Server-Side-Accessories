package net.biryeongtrain.serversideconstruct.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

import static net.biryeongtrain.serversideconstruct.ServerSideConstruct.LOGGER;

public class DataGenInit implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        LOGGER.info("Initializing data generator");
        var pack = fabricDataGenerator.createPack();

        pack.addProvider(BlockTagsProvider::new);
        pack.addProvider(WorldGenProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, (WorldGenProvider::bootstrapConfigured));
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, (WorldGenProvider::bootstrapPlaced));
    }
}
