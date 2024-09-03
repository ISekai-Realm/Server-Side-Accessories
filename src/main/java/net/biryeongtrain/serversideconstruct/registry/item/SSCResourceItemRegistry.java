package net.biryeongtrain.serversideconstruct.registry.item;

import eu.pb4.factorytools.api.item.MultiBlockItem;
import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import net.biryeongtrain.serversideconstruct.component.JewelryComponent;
import net.biryeongtrain.serversideconstruct.component.RuneType;
import net.biryeongtrain.serversideconstruct.item.ExampleItem;
import net.biryeongtrain.serversideconstruct.item.ExampleItem2;
import net.biryeongtrain.serversideconstruct.item.SimpleModeledPolymerItem;
import net.biryeongtrain.serversideconstruct.item.rune.Rune;
import net.biryeongtrain.serversideconstruct.item.rune.RuneTier;
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

    public static final Item TIER_1_RUBY_RUNE = Registry.register(Registries.ITEM, PathHelper.getModId("tier_1_ruby_rune"), new Rune(new Item.Settings().maxCount(99).rarity(Rarity.UNCOMMON), RuneTier.TIER_1, RuneType.COMBAT, SSCItemModelRegistry.TIER_1_RUBY_RUNE_MODEL));
    public static final Item TIER_2_RUBY_RUNE = Registry.register(Registries.ITEM, PathHelper.getModId("tier_2_ruby_rune"), new Rune(new Item.Settings().maxCount(99).rarity(Rarity.RARE),RuneTier.TIER_2, RuneType.COMBAT, SSCItemModelRegistry.TIER_2_RUBY_RUNE_MODEL));
    public static final Item TIER_3_RUBY_RUNE = Registry.register(Registries.ITEM, PathHelper.getModId("tier_3_ruby_rune"), new Rune(new Item.Settings().maxCount(99).rarity(Rarity.EPIC),RuneTier.TIER_3, RuneType.COMBAT, SSCItemModelRegistry.TIER_3_RUBY_RUNE_MODEL));
    public static final Item TIER_1_OPAL_RUNE = Registry.register(Registries.ITEM, PathHelper.getModId("tier_1_opal_rune"), new Rune(new Item.Settings().maxCount(99).rarity(Rarity.UNCOMMON),RuneTier.TIER_1, RuneType.MINING, SSCItemModelRegistry.TIER_1_OPAL_RUNE_MODEL));
    public static final Item TIER_2_OPAL_RUNE = Registry.register(Registries.ITEM, PathHelper.getModId("tier_2_opal_rune"), new Rune(new Item.Settings().maxCount(99).rarity(Rarity.RARE), RuneTier.TIER_2, RuneType.MINING, SSCItemModelRegistry.TIER_2_OPAL_RUNE_MODEL));
    public static final Item TIER_3_OPAL_RUNE = Registry.register(Registries.ITEM, PathHelper.getModId("tier_3_opal_rune"), new Rune(new Item.Settings().maxCount(99).rarity(Rarity.EPIC), RuneTier.TIER_3, RuneType.MINING, SSCItemModelRegistry.TIER_3_OPAL_RUNE_MODEL));
    public static final Item TIER_1_SAPPHIRE_RUNE = Registry.register(Registries.ITEM, PathHelper.getModId("tier_1_sapphire_rune"), new Rune(new Item.Settings().maxCount(99).rarity(Rarity.UNCOMMON),RuneTier.TIER_1, RuneType.WATER_EXPLORE, SSCItemModelRegistry.TIER_1_SAPPHIRE_RUNE_MODEL));
    public static final Item TIER_2_SAPPHIRE_RUNE = Registry.register(Registries.ITEM, PathHelper.getModId("tier_2_sapphire_rune"), new Rune(new Item.Settings().maxCount(99).rarity(Rarity.RARE), RuneTier.TIER_2, RuneType.WATER_EXPLORE, SSCItemModelRegistry.TIER_2_SAPPHIRE_RUNE_MODEL));
    public static final Item TIER_3_SAPPHIRE_RUNE = Registry.register(Registries.ITEM, PathHelper.getModId("tier_3_sapphire_rune"), new Rune(new Item.Settings().maxCount(99).rarity(Rarity.EPIC), RuneTier.TIER_3, RuneType.WATER_EXPLORE, SSCItemModelRegistry.TIER_3_SAPPHIRE_RUNE_MODEL));
    public static final Item TIER_1_TOPAZ_RUNE = Registry.register(Registries.ITEM, PathHelper.getModId("tier_1_topaz_rune"), new Rune(new Item.Settings().maxCount(99).rarity(Rarity.UNCOMMON), RuneTier.TIER_1, RuneType.EXPERIENCE, SSCItemModelRegistry.TIER_1_TOPAZ_RUNE_MODEL));
    public static final Item TIER_2_TOPAZ_RUNE = Registry.register(Registries.ITEM, PathHelper.getModId("tier_2_topaz_rune"), new Rune(new Item.Settings().maxCount(99).rarity(Rarity.RARE), RuneTier.TIER_2, RuneType.EXPERIENCE, SSCItemModelRegistry.TIER_2_TOPAZ_RUNE_MODEL));
    public static final Item TIER_3_TOPAZ_RUNE = Registry.register(Registries.ITEM, PathHelper.getModId("tier_3_topaz_rune"), new Rune(new Item.Settings().maxCount(99).rarity(Rarity.EPIC), RuneTier.TIER_3, RuneType.EXPERIENCE, SSCItemModelRegistry.TIER_3_TOPAZ_RUNE_MODEL));
    public static final Item TIER_1_ONYX_RUNE = Registry.register(Registries.ITEM, PathHelper.getModId("tier_1_onyx_rune"), new Rune(new Item.Settings().maxCount(99).rarity(Rarity.UNCOMMON), RuneTier.TIER_1, RuneType.EXPLORE, SSCItemModelRegistry.TIER_1_ONYX_RUNE_MODEL));
    public static final Item TIER_2_ONYX_RUNE = Registry.register(Registries.ITEM, PathHelper.getModId("tier_2_onyx_rune"), new Rune(new Item.Settings().maxCount(99).rarity(Rarity.RARE), RuneTier.TIER_2, RuneType.EXPLORE, SSCItemModelRegistry.TIER_2_ONYX_RUNE_MODEL));
    public static final Item TIER_3_ONYX_RUNE = Registry.register(Registries.ITEM, PathHelper.getModId("tier_3_onyx_rune"), new Rune(new Item.Settings().maxCount(99).rarity(Rarity.EPIC), RuneTier.TIER_3, RuneType.EXPLORE, SSCItemModelRegistry.TIER_3_ONYX_RUNE_MODEL));

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

                    entries.add(TIER_1_ONYX_RUNE);
                    entries.add(TIER_2_ONYX_RUNE);
                    entries.add(TIER_3_ONYX_RUNE);
                    entries.add(TIER_1_RUBY_RUNE);
                    entries.add(TIER_2_RUBY_RUNE);
                    entries.add(TIER_3_RUBY_RUNE);
                    entries.add(TIER_1_OPAL_RUNE);
                    entries.add(TIER_2_OPAL_RUNE);
                    entries.add(TIER_3_OPAL_RUNE);
                    entries.add(TIER_1_SAPPHIRE_RUNE);
                    entries.add(TIER_2_SAPPHIRE_RUNE);
                    entries.add(TIER_3_SAPPHIRE_RUNE);
                    entries.add(TIER_1_TOPAZ_RUNE);
                    entries.add(TIER_2_TOPAZ_RUNE);
                    entries.add(TIER_3_TOPAZ_RUNE);

                }).build()
        );
    }
}
