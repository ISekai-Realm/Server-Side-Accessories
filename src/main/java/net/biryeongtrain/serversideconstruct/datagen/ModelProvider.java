package net.biryeongtrain.serversideconstruct.datagen;

import net.biryeongtrain.serversideconstruct.registry.block.SSCBlockRegistry;
import net.biryeongtrain.serversideconstruct.registry.item.SSCJewelryRegistry;
import net.biryeongtrain.serversideconstruct.registry.item.SSCResourceItemRegistry;
import net.biryeongtrain.serversideconstruct.registry.item.SSCToolRegistry;
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
        blockStateModelGenerator.registerSimpleCubeAll(SSCBlockRegistry.ONYX_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(SSCBlockRegistry.DEEPSLATE_ONYX_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(SSCBlockRegistry.OPAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(SSCBlockRegistry.DEEPSLATE_OPAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(SSCBlockRegistry.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(SSCBlockRegistry.DEEPSLATE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(SSCBlockRegistry.SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(SSCBlockRegistry.DEEPSLATE_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(SSCBlockRegistry.TOPAZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(SSCBlockRegistry.DEEPSLATE_TOPAZ_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(SSCResourceItemRegistry.ONYX_GEM, Models.GENERATED);
        itemModelGenerator.register(SSCResourceItemRegistry.RUBY_GEM, Models.GENERATED);
        itemModelGenerator.register(SSCResourceItemRegistry.SAPPHIRE_GEM, Models.GENERATED);
        itemModelGenerator.register(SSCResourceItemRegistry.OPAL_GEM, Models.GENERATED);
        itemModelGenerator.register(SSCResourceItemRegistry.TOPAZ_GEM, Models.GENERATED);


        // Tools
        itemModelGenerator.register(SSCToolRegistry.COPPER_PICKAXE,"0", Models.HANDHELD);
        itemModelGenerator.register(SSCToolRegistry.COPPER_PICKAXE,"1", Models.HANDHELD);
        itemModelGenerator.register(SSCToolRegistry.COPPER_PICKAXE,"2", Models.HANDHELD);
        itemModelGenerator.register(SSCToolRegistry.COPPER_PICKAXE,"3", Models.HANDHELD);

        // Spear
        itemModelGenerator.register(SSCToolRegistry.NETHERITE_SPEAR, Models.HANDHELD);
        itemModelGenerator.register(SSCToolRegistry.DIAMOND_SPEAR, Models.HANDHELD);

        // Greatsword
        itemModelGenerator.register(SSCToolRegistry.NETHERITE_GREATSWORD, Models.HANDHELD);

        // rings
        itemModelGenerator.register(SSCJewelryRegistry.ONYX_RING, Models.GENERATED);
        itemModelGenerator.register(SSCJewelryRegistry.OPAL_RING, Models.GENERATED);
        itemModelGenerator.register(SSCJewelryRegistry.RUBY_RING, Models.GENERATED);
        itemModelGenerator.register(SSCJewelryRegistry.SAPPHIRE_RING, Models.GENERATED);
        itemModelGenerator.register(SSCJewelryRegistry.TOPAZ_RING, Models.GENERATED);
        itemModelGenerator.register(SSCResourceItemRegistry.IRON_RING_ITEM, Models.GENERATED);
    }


}
