package net.biryeongtrain.serversideconstruct.datagen;

import net.biryeongtrain.serversideconstruct.registry.block.SSCBlockRegistry;
import net.biryeongtrain.serversideconstruct.registry.item.SSCResourceItemRegistry;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class EnglishLanguageProvider extends FabricLanguageProvider {
    protected EnglishLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(PathHelper.getItemGroupTranslationKey("resources"), "Server-Side Construct Resources");
        translationBuilder.add(PathHelper.getItemGroupTranslationKey("jewelries"), "Server-Side Construct Jewelries");
        translationBuilder.add(SSCResourceItemRegistry.IRON_RING_ITEM, "Iron Ring");
        translationBuilder.add(SSCBlockRegistry.DEEPSLATE_ONYX_ORE, "Deepslate Onyx Ore");
        translationBuilder.add(SSCBlockRegistry.DEEPSLATE_OPAL_ORE, "Deepslate Opal Ore");
        translationBuilder.add(SSCBlockRegistry.DEEPSLATE_RUBY_ORE, "Deepslate Ruby Ore");
        translationBuilder.add(SSCBlockRegistry.DEEPSLATE_SAPPHIRE_ORE, "Deepslate Sapphire Ore");
        translationBuilder.add(SSCBlockRegistry.DEEPSLATE_TOPAZ_ORE, "Deepslate Topaz Ore");
        translationBuilder.add(SSCBlockRegistry.OPAL_ORE, "Opal Ore");
        translationBuilder.add(SSCBlockRegistry.RUBY_ORE, "Ruby Ore");
        translationBuilder.add(SSCBlockRegistry.SAPPHIRE_ORE, "Sapphire Ore");
        translationBuilder.add(SSCBlockRegistry.TOPAZ_ORE, "Topaz Ore");
        try {
            Path existingFilePath = dataOutput.getModContainer().findPath("assets/ss_construct/lang/en_us.existing.json").get();
            translationBuilder.add(existingFilePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add existing language file!", e);
        }
    }
}
