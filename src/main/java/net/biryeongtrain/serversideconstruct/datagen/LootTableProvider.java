package net.biryeongtrain.serversideconstruct.datagen;

import net.biryeongtrain.serversideconstruct.registry.block.SSCBlockRegistry;
import net.biryeongtrain.serversideconstruct.registry.item.SSCResourceItemRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class LootTableProvider extends FabricBlockLootTableProvider {
    protected LootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
            addDrop(SSCBlockRegistry.JEWELER_BLOCK);
            addOreDrop(SSCBlockRegistry.ONYX_ORE, SSCResourceItemRegistry.ONYX_GEM);
    }
    private void addOreDrop(Block block, Item item) {
        addDrop(block, oreDrops(block, item));
    }
}
