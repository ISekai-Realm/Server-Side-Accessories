package net.biryeongtrain.serversideconstruct.registry;

import net.biryeongtrain.serversideconstruct.item.OnyxRing;
import net.biryeongtrain.serversideconstruct.item.TestTrinket;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;

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

    public static Item OPAL_RING;
    public static Item RUBY_RING;
    public static Item SAPPHIRE_RING;
    public static Item TOPAZ_RING;

    public static void register() {
        // this do nothing, but it's required to be called in the main mod class
    }
}
