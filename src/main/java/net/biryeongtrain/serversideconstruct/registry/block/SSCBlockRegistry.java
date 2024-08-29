package net.biryeongtrain.serversideconstruct.registry.block;

import net.biryeongtrain.serversideconstruct.block.JewelerBlock;
import net.biryeongtrain.serversideconstruct.block.PolymerDeepslateOreBlock;
import net.biryeongtrain.serversideconstruct.block.PolymerOreBlock;
import net.biryeongtrain.serversideconstruct.block.PolymerSimpleEXPDropBlock;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class SSCBlockRegistry {
    public static final Block ONYX_ORE = Registry.register(Registries.BLOCK, PathHelper.getModId("onyx_ore"), new PolymerOreBlock(UniformIntProvider.create(5, 10), SSCBlockModelRegistry.ONYX_ORE, AbstractBlock.Settings.create()
            .hardness(3.0F)
            .resistance(3.0F)
            .requiresTool()));

    public static final Block DEEPSLATE_ONYX_ORE = Registry.register(Registries.BLOCK, PathHelper.getModId("deepslate_onyx_ore"), new PolymerDeepslateOreBlock(UniformIntProvider.create(5, 10), "deepslate_onyx_ore", AbstractBlock.Settings.create()
            .hardness(4.5F)
            .resistance(4.5F)
            .requiresTool()));

    public static final JewelerBlock JEWELER_BLOCK = Registry.register(Registries.BLOCK, PathHelper.getModId("jeweler_block"), new JewelerBlock(AbstractBlock.Settings.create()
            .hardness(3.0F)
            .resistance(3.0F)
            .requiresTool()
            .nonOpaque()
    ));

    public static void register() {
        // this do nothing, but it's required to be called in the main mod class
    }
}
