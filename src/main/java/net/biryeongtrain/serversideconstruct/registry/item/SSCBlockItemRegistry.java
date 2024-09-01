package net.biryeongtrain.serversideconstruct.registry.item;

import net.biryeongtrain.serversideconstruct.item.TexturedPolyBlockItem;
import net.biryeongtrain.serversideconstruct.registry.block.SSCBlockRegistry;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;

public class SSCBlockItemRegistry {
    public static final Item ONYX_ORE_ITEM = Registry.register(Registries.ITEM, PathHelper.getModId("onyx_ore"), new TexturedPolyBlockItem(SSCBlockRegistry.ONYX_ORE, new Item.Settings().maxCount(64).rarity(Rarity.COMMON), "onyx_ore"));
    public static final Item DEEPSLATE_ONYX_ORE_ITEM = Registry.register(Registries.ITEM, PathHelper.getModId("deepslate_onyx_ore"), new TexturedPolyBlockItem(SSCBlockRegistry.DEEPSLATE_ONYX_ORE, new Item.Settings().maxCount(64).rarity(Rarity.COMMON), "deepslate_onyx_ore"));
    public static final Item OPAL_ORE_ITEM = Registry.register(Registries.ITEM, PathHelper.getModId("opal_ore"), new TexturedPolyBlockItem(SSCBlockRegistry.OPAL_ORE, new Item.Settings().maxCount(64).rarity(Rarity.COMMON), "opal_ore"));
    public static final Item DEEPSLATE_OPAL_ORE_ITEM = Registry.register(Registries.ITEM, PathHelper.getModId("deepslate_opal_ore"), new TexturedPolyBlockItem(SSCBlockRegistry.DEEPSLATE_OPAL_ORE, new Item.Settings().maxCount(64).rarity(Rarity.COMMON), "deepslate_opal_ore"));
    public static final Item RUBY_ORE_ITEM = Registry.register(Registries.ITEM, PathHelper.getModId("ruby_ore"), new TexturedPolyBlockItem(SSCBlockRegistry.RUBY_ORE, new Item.Settings().maxCount(64).rarity(Rarity.COMMON), "ruby_ore"));
    public static final Item DEEPSLATE_RUBY_ORE_ITEM = Registry.register(Registries.ITEM, PathHelper.getModId("deepslate_ruby_ore"), new TexturedPolyBlockItem(SSCBlockRegistry.DEEPSLATE_RUBY_ORE, new Item.Settings().maxCount(64).rarity(Rarity.COMMON), "deepslate_ruby_ore"));
    public static final Item SAPPHIRE_ORE_ITEM = Registry.register(Registries.ITEM, PathHelper.getModId("sapphire_ore"), new TexturedPolyBlockItem(SSCBlockRegistry.SAPPHIRE_ORE, new Item.Settings().maxCount(64).rarity(Rarity.COMMON), "sapphire_ore"));
    public static final Item DEEPSLATE_SAPPHIRE_ORE_ITEM = Registry.register(Registries.ITEM, PathHelper.getModId("deepslate_sapphire_ore"), new TexturedPolyBlockItem(SSCBlockRegistry.DEEPSLATE_SAPPHIRE_ORE, new Item.Settings().maxCount(64).rarity(Rarity.COMMON), "deepslate_sapphire_ore"));
    public static final Item TOPAZ_ORE_ITEM = Registry.register(Registries.ITEM, PathHelper.getModId("topaz_ore"), new TexturedPolyBlockItem(SSCBlockRegistry.TOPAZ_ORE, new Item.Settings().maxCount(64).rarity(Rarity.COMMON), "topaz_ore"));
    public static final Item DEEPSLATE_TOPAZ_ORE_ITEM = Registry.register(Registries.ITEM, PathHelper.getModId("deepslate_topaz_ore"), new TexturedPolyBlockItem(SSCBlockRegistry.DEEPSLATE_TOPAZ_ORE, new Item.Settings().maxCount(64).rarity(Rarity.COMMON), "deepslate_topaz_ore"));

    public static void register() {}
}
