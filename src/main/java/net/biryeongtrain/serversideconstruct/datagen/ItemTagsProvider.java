package net.biryeongtrain.serversideconstruct.datagen;

import net.biryeongtrain.serversideconstruct.registry.item.SSCItemTags;
import net.biryeongtrain.serversideconstruct.registry.item.SSCJewelryRegistry;
import net.biryeongtrain.serversideconstruct.registry.item.SSCResourceItemRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ItemTagsProvider extends FabricTagProvider.ItemTagProvider {
    public ItemTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture, @Nullable FabricTagProvider.BlockTagProvider blockTagProvider) {
        super(output, completableFuture, blockTagProvider);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        this.getOrCreateTagBuilder(SSCItemTags.GEM_ITEMS)
                .add(SSCResourceItemRegistry.ONYX_GEM)
        ;

        this.getOrCreateTagBuilder(SSCItemTags.RING_ITEMS)
                .add(SSCJewelryRegistry.ONYX_RING)
                .add(SSCJewelryRegistry.OPAL_RING)
                .add(SSCJewelryRegistry.RUBY_RING)
                .add(SSCJewelryRegistry.SAPPHIRE_RING)
                .add(SSCJewelryRegistry.TOPAZ_RING)
                .add(SSCJewelryRegistry.TEST_RING)
                .add(SSCResourceItemRegistry.IRON_RING_ITEM)
        ;

        this.getOrCreateTagBuilder(SSCItemTags.EXPLORATION_RUNE_FAMILY)
                .add(SSCJewelryRegistry.ONYX_RING)
        ;

        this.getOrCreateTagBuilder(SSCItemTags.COMBAT_RUNE_FAMILY)
                .add(SSCJewelryRegistry.RUBY_RING)
        ;

        this.getOrCreateTagBuilder(SSCItemTags.WATER_EXPLORATION_RUNE_FAMILY)
                .add(SSCJewelryRegistry.SAPPHIRE_RING)
                ;

        this.getOrCreateTagBuilder(SSCItemTags.EXPERIENCE_RUNE_FAMILY)
                .add(SSCJewelryRegistry.TOPAZ_RING)
                ;

        this.getOrCreateTagBuilder(SSCItemTags.MINING_RUNE_FAMILY)
                .add(SSCJewelryRegistry.OPAL_RING)
        ;

        this.getOrCreateTagBuilder(SSCItemTags.JEWELRY_ITEMS)
                .addOptionalTag(SSCItemTags.RING_ITEMS)
        ;
    }
}