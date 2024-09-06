package net.biryeongtrain.serversideconstruct.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;

import static net.biryeongtrain.serversideconstruct.ServerSideConstruct.LOGGER;

public class DataGenInit implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        LOGGER.info("Initializing data generator");
        var pack = fabricDataGenerator.createPack();

        var blockTags = pack.addProvider(BlockTagsProvider::new);
        pack.addProvider(ModelProvider::new);
        pack.addProvider((a, b) -> new ItemTagsProvider(a, b, blockTags));
        pack.addProvider(RecipeProvider::new);
        pack.addProvider(LootTableProvider::new);
        pack.addProvider((a, b) -> new AssetProvider(a));
        pack.addProvider(EnglishLanguageProvider::new);
        pack.addProvider(RuneAttributeProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        DataGeneratorEntrypoint.super.buildRegistry(registryBuilder);
    }
}
