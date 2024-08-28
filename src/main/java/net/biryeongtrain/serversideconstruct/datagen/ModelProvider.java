package net.biryeongtrain.serversideconstruct.datagen;

import net.biryeongtrain.serversideconstruct.registry.SSCResourceItemRegistry;
import net.biryeongtrain.serversideconstruct.registry.SSCToolRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(SSCResourceItemRegistry.ONYX_GEM, Models.GENERATED);
        itemModelGenerator.register(SSCToolRegistry.COPPER_PICKAXE,"0", Models.HANDHELD);
        itemModelGenerator.register(SSCToolRegistry.COPPER_PICKAXE,"1", Models.HANDHELD);
        itemModelGenerator.register(SSCToolRegistry.COPPER_PICKAXE,"2", Models.HANDHELD);
        itemModelGenerator.register(SSCToolRegistry.COPPER_PICKAXE,"3", Models.HANDHELD);

        // Spear
        itemModelGenerator.register(SSCToolRegistry.NETHERITE_SPEAR, Models.HANDHELD);
        itemModelGenerator.register(SSCToolRegistry.DIAMOND_SPEAR, Models.HANDHELD);

        // Greatsword
        itemModelGenerator.register(SSCToolRegistry.NETHERITE_GREATSWORD, Models.HANDHELD);
    }
}
