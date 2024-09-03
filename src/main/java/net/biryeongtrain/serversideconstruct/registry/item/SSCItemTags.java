package net.biryeongtrain.serversideconstruct.registry.item;

import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class SSCItemTags {
    public static final TagKey<Item> GEM_ITEMS = TagKey.of(RegistryKeys.ITEM, PathHelper.getModId("gem_items"));
    public static final TagKey<Item> JEWELRY_ITEMS = TagKey.of(RegistryKeys.ITEM, PathHelper.getModId("jewelry"));
    public static final TagKey<Item> RING_ITEMS = TagKey.of(RegistryKeys.ITEM, PathHelper.getModId("rings"));
    
    public static final TagKey<Item> EXPLORATION_RUNE_FAMILY = TagKey.of(RegistryKeys.ITEM, PathHelper.getModId("exploration_family"));
    public static final TagKey<Item> COMBAT_RUNE_FAMILY = TagKey.of(RegistryKeys.ITEM, PathHelper.getModId("combat_family"));
    public static final TagKey<Item> WATER_EXPLORATION_RUNE_FAMILY = TagKey.of(RegistryKeys.ITEM, PathHelper.getModId("water_exploration_family"));
    public static final TagKey<Item> EXPERIENCE_RUNE_FAMILY = TagKey.of(RegistryKeys.ITEM, PathHelper.getModId("experience_family"));
    public static final TagKey<Item> MINING_RUNE_FAMILY = TagKey.of(RegistryKeys.ITEM, PathHelper.getModId("mining_family"));
    public static final TagKey<Item> EVERYTHING_RUNE_FAMILY = TagKey.of(RegistryKeys.ITEM, PathHelper.getModId("everything_family"));
    public static final TagKey<Item> NOTHING_RUNE_FAMILY = TagKey.of(RegistryKeys.ITEM, PathHelper.getModId("nothing_family"));

    public static final TagKey<Item> RUNE_ITEMS = TagKey.of(RegistryKeys.ITEM, PathHelper.getModId("runes"));

    public static void register() {

    }
}
