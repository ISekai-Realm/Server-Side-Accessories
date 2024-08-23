package net.biryeongtrain.serversideconstruct.registry;

import eu.pb4.polymer.core.api.block.PolymerBlock;
import eu.pb4.polymer.core.api.item.PolymerBlockItem;
import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import net.biryeongtrain.serversideconstruct.component.JewelryComponent;
import net.biryeongtrain.serversideconstruct.item.ExampleItem;
import net.biryeongtrain.serversideconstruct.item.ExampleItem2;
import net.biryeongtrain.serversideconstruct.item.SimpleModeledPolymerItem;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;

public class SSCResourceItemRegistry {
    public static final Item ONYX_GEM = Registry.register(Registries.ITEM, PathHelper.getModId("onyx_gem"), new SimpleModeledPolymerItem(new Item.Settings().maxCount(99).rarity(Rarity.UNCOMMON), SSCItemModelRegistry.ONYX_GEM_MODEL));
    public static final Item EXAMPLE_ITEM = Registry.register(Registries.ITEM, PathHelper.getModId("example_item"), new ExampleItem(new Item.Settings().maxCount(99).component(JewelryComponent.HEALTH_ROLL, 1).fireproof()));
    public static final Item EXAMPLE_ITEM_2 = Registry.register(Registries.ITEM, PathHelper.getModId("example_item_2"), new ExampleItem2(new Item.Settings().maxCount(99).component(JewelryComponent.HEALTH_ROLL, 1).fireproof()));
    public static final Item ONYX_BLOCK_ITEM = Registry.register(Registries.ITEM, PathHelper.getModId("onyx_block"), new PolymerBlockItem(SSCBlockRegistry.ONYX_ORE, new Item.Settings().maxCount(64).rarity(Rarity.UNCOMMON), Items.PAPER));


    public static void register() {
        // this do nothing, but it's required to be called in the main mod class
    }
}
