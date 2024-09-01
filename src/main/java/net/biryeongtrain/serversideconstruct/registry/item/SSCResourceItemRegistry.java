package net.biryeongtrain.serversideconstruct.registry.item;

import eu.pb4.factorytools.api.item.MultiBlockItem;
import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import net.biryeongtrain.serversideconstruct.component.JewelryComponent;
import net.biryeongtrain.serversideconstruct.item.ExampleItem;
import net.biryeongtrain.serversideconstruct.item.ExampleItem2;
import net.biryeongtrain.serversideconstruct.item.SimpleModeledPolymerItem;
import net.biryeongtrain.serversideconstruct.registry.block.SSCBlockRegistry;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;

import static net.biryeongtrain.serversideconstruct.ServerSideConstruct.MOD_ID;

public class SSCResourceItemRegistry {
    public static final Item ONYX_GEM = Registry.register(Registries.ITEM, PathHelper.getModId("onyx_gem"), new SimpleModeledPolymerItem(new Item.Settings().maxCount(99).rarity(Rarity.UNCOMMON), SSCItemModelRegistry.ONYX_GEM_MODEL));
    public static final Item RUBY_GEM = Registry.register(Registries.ITEM, PathHelper.getModId("ruby_gem"), new SimpleModeledPolymerItem(new Item.Settings().maxCount(99).rarity(Rarity.UNCOMMON), SSCItemModelRegistry.RUBY_GEM_MODEL));
    public static final Item SAPPHIRE_GEM = Registry.register(Registries.ITEM, PathHelper.getModId("sapphire_gem"), new SimpleModeledPolymerItem(new Item.Settings().maxCount(99).rarity(Rarity.UNCOMMON), SSCItemModelRegistry.SAPPHIRE_GEM_MODEL));
    public static final Item OPAL_GEM = Registry.register(Registries.ITEM, PathHelper.getModId("opal_gem"), new SimpleModeledPolymerItem(new Item.Settings().maxCount(99).rarity(Rarity.UNCOMMON), SSCItemModelRegistry.OPAL_GEM_MODEL));
    public static final Item TOPAZ_GEM = Registry.register(Registries.ITEM, PathHelper.getModId("topaz_gem"), new SimpleModeledPolymerItem(new Item.Settings().maxCount(99).rarity(Rarity.UNCOMMON), SSCItemModelRegistry.TOPAZ_GEM_MODEL));

    // dummy
    public static final Item EXAMPLE_ITEM = Registry.register(Registries.ITEM, PathHelper.getModId("example_item"), new ExampleItem(new Item.Settings().maxCount(99).component(JewelryComponent.HEALTH_ROLL, 1).fireproof()));
    public static final Item EXAMPLE_ITEM_2 = Registry.register(Registries.ITEM, PathHelper.getModId("example_item_2"), new ExampleItem2(new Item.Settings().maxCount(99).component(JewelryComponent.HEALTH_ROLL, 1).fireproof()));

    public static final Item JEWELER_BLOCK_ITEM = Registry.register(Registries.ITEM, PathHelper.getModId("jeweler"), new MultiBlockItem(SSCBlockRegistry.JEWELER_BLOCK,new Item.Settings().maxCount(99).rarity(Rarity.COMMON)));

    public static final Item IRON_RING_ITEM = Registry.register(Registries.ITEM, PathHelper.getModId("iron_ring"), new SimpleModeledPolymerItem(new Item.Settings().maxCount(1).rarity(Rarity.COMMON), SSCItemModelRegistry.IRON_RING_MODEL));
    public static void register() {
        PolymerItemGroupUtils.registerPolymerItemGroup(PathHelper.getModId("resource_group"), ItemGroup.create(ItemGroup.Row.BOTTOM, -1)
                .icon(RUBY_GEM::getDefaultStack)
                        .displayName(Text.translatable( PathHelper.getItemGroupTranslationKey("resources")))
                .entries((context, entries) -> {
                    entries.add(ONYX_GEM);
                    entries.add(RUBY_GEM);
                    entries.add(SAPPHIRE_GEM);
                    entries.add(OPAL_GEM);
                    entries.add(TOPAZ_GEM);

                    entries.add(IRON_RING_ITEM);
                    entries.add(JEWELER_BLOCK_ITEM);
                }).build()
        );
    }
}
