package net.biryeongtrain.serversideconstruct.registry;

import net.biryeongtrain.serversideconstruct.block.PolymerSimpleEXPDropBlock;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class SSCBlockRegistry {
    public static Block ONYX_ORE = Registry.register(Registries.BLOCK, PathHelper.getModId("onyx_ore"), new PolymerSimpleEXPDropBlock(UniformIntProvider.create(5, 10), SSCBlockModelRegistry.ONYX_BLOCK_STATE, AbstractBlock.Settings.create()
            .hardness(3.0F)
            .resistance(3.0F)
            .requiresTool()));

    public static Block DEEPSLATE_ONYX_ORE = Registry.register(Registries.BLOCK, PathHelper.getModId("deepslate_onyx_ore"), new PolymerSimpleEXPDropBlock(UniformIntProvider.create(5, 10), SSCBlockModelRegistry.DEEPSLATE_ONYX_BLOCK_STATE, AbstractBlock.Settings.create()
            .hardness(4.5F)
            .resistance(4.5F)
            .requiresTool()));

    public static void register() {
        // this do nothing, but it's required to be called in the main mod class
    }
}
