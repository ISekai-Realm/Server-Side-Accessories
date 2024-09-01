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

    public static final Block DEEPSLATE_ONYX_ORE = Registry.register(Registries.BLOCK, PathHelper.getModId("deepslate_onyx_ore"), new PolymerDeepslateOreBlock(UniformIntProvider.create(5, 10), SSCBlockModelRegistry.DEEPSLATE_ONYX_ORE, AbstractBlock.Settings.create()
            .hardness(4.5F)
            .resistance(4.5F)
            .requiresTool()));

    public static final Block OPAL_ORE = Registry.register(Registries.BLOCK, PathHelper.getModId("opal_ore"), new PolymerOreBlock(UniformIntProvider.create(5, 10), SSCBlockModelRegistry.OPAL_ORE, AbstractBlock.Settings.create()
            .hardness(3.0F)
            .resistance(3.0F)
            .requiresTool()));

    public static final Block DEEPSLATE_OPAL_ORE = Registry.register(Registries.BLOCK, PathHelper.getModId("deepslate_opal_ore"), new PolymerDeepslateOreBlock(UniformIntProvider.create(5, 10), SSCBlockModelRegistry.DEEPSLATE_OPAL_ORE, AbstractBlock.Settings.create()
            .hardness(4.5F)
            .resistance(4.5F)
            .requiresTool()));

    public static final Block RUBY_ORE = Registry.register(Registries.BLOCK, PathHelper.getModId("ruby_ore"), new PolymerOreBlock(UniformIntProvider.create(5, 10), SSCBlockModelRegistry.RUBY_ORE, AbstractBlock.Settings.create()
            .hardness(3.0F)
            .resistance(3.0F)
            .requiresTool()));

    public static final Block DEEPSLATE_RUBY_ORE = Registry.register(Registries.BLOCK, PathHelper.getModId("deepslate_ruby_ore"), new PolymerDeepslateOreBlock(UniformIntProvider.create(5, 10), SSCBlockModelRegistry.DEEPSLATE_RUBY_ORE, AbstractBlock.Settings.create()
            .hardness(4.5F)
            .resistance(4.5F)
            .requiresTool()));

    public static final Block SAPPHIRE_ORE = Registry.register(Registries.BLOCK, PathHelper.getModId("sapphire_ore"), new PolymerOreBlock(UniformIntProvider.create(5, 10), SSCBlockModelRegistry.SAPPHIRE_ORE, AbstractBlock.Settings.create()
            .hardness(3.0F)
            .resistance(3.0F)
            .requiresTool()));

    public static final Block DEEPSLATE_SAPPHIRE_ORE = Registry.register(Registries.BLOCK, PathHelper.getModId("deepslate_sapphire_ore"), new PolymerDeepslateOreBlock(UniformIntProvider.create(5, 10), SSCBlockModelRegistry.DEEPSLATE_SAPPHIRE_ORE, AbstractBlock.Settings.create()
            .hardness(4.5F)
            .resistance(4.5F)
            .requiresTool()));

    public static final Block TOPAZ_ORE = Registry.register(Registries.BLOCK, PathHelper.getModId("topaz_ore"), new PolymerOreBlock(UniformIntProvider.create(5, 10), SSCBlockModelRegistry.TOPAZ_ORE, AbstractBlock.Settings.create()
            .hardness(3.0F)
            .resistance(3.0F)
            .requiresTool()));

    public static final Block DEEPSLATE_TOPAZ_ORE = Registry.register(Registries.BLOCK, PathHelper.getModId("deepslate_topaz_ore"), new PolymerDeepslateOreBlock(UniformIntProvider.create(5, 10), SSCBlockModelRegistry.DEEPSLATE_TOPAZ_ORE, AbstractBlock.Settings.create()
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
