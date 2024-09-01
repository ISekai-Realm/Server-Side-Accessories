package net.biryeongtrain.serversideconstruct.registry.item;

import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import net.biryeongtrain.serversideconstruct.item.ring.*;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;

import static net.biryeongtrain.serversideconstruct.ServerSideConstruct.MOD_ID;

public class SSCJewelryRegistry {
    public static Item TEST_RING = Registry.register(Registries.ITEM, PathHelper.getModId("test"), new TestTrinket(new Item.Settings()
                    .maxCount(1)
                    .maxDamage(5)
                    .rarity(Rarity.RARE)
            )
    );

    public static Item ONYX_RING = Registry.register(Registries.ITEM, PathHelper.getModId("onyx_ring"), new OnyxRing(new Item.Settings()
                    .maxCount(1)
                    .maxDamage(155788848)
                    .rarity(Rarity.RARE)
            )
    );

    public static Item OPAL_RING = register("opal_ring", new OpalRing(new Item.Settings()
            .maxCount(1)
            .maxDamage(155788848)
            .rarity(Rarity.RARE)
    ));
    public static Item RUBY_RING = register("ruby_ring", new RubyRing(new Item.Settings()
            .maxCount(1)
            .maxDamage(155788848)
            .rarity(Rarity.RARE)
    ));
    public static Item SAPPHIRE_RING = register("sapphire_ring", new SapphireRing(new Item.Settings()
            .maxCount(1)
            .maxDamage(155788848)
            .rarity(Rarity.RARE)
    ));
    public static Item TOPAZ_RING = register("topaz_ring", new TopazRing(new Item.Settings()
            .maxCount(1)
            .maxDamage(155788848)
            .rarity(Rarity.RARE)
    ));

    public static void register() {
        PolymerItemGroupUtils.registerPolymerItemGroup(PathHelper.getModId("jewelry_group"), ItemGroup.create(ItemGroup.Row.BOTTOM, -1)
                .icon(OPAL_RING::getDefaultStack)
                        .displayName(Text.translatable(PathHelper.getItemGroupTranslationKey("jewelries")))
                .entries((context, entries) -> {
                    entries.add(ONYX_RING);
                    entries.add(OPAL_RING);
                    entries.add(RUBY_RING);
                    entries.add(SAPPHIRE_RING);
                    entries.add(TOPAZ_RING);
                    entries.add(TEST_RING);
                }).build()
        );
    }

    public static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, PathHelper.getModId(id), item);
    }
}
