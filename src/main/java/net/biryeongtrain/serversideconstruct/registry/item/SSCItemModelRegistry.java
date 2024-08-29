package net.biryeongtrain.serversideconstruct.registry.item;

import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.item.Items;

public class SSCItemModelRegistry {
    public static PolymerModelData ONYX_GEM_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("onyx_gem"));
    public static PolymerModelData COPPER_PICKAXE_MODEL_AGE_0 = PolymerResourcePackUtils.requestModel(Items.IRON_PICKAXE, PathHelper.getItemModelId("copper_pickaxe0"));
    public static PolymerModelData COPPER_PICKAXE_MODEL_AGE_1 = PolymerResourcePackUtils.requestModel(Items.IRON_PICKAXE, PathHelper.getItemModelId("copper_pickaxe1"));
    public static PolymerModelData COPPER_PICKAXE_MODEL_AGE_2 = PolymerResourcePackUtils.requestModel(Items.IRON_PICKAXE, PathHelper.getItemModelId("copper_pickaxe2"));
    public static PolymerModelData COPPER_PICKAXE_MODEL_AGE_3 = PolymerResourcePackUtils.requestModel(Items.IRON_PICKAXE, PathHelper.getItemModelId("copper_pickaxe3"));
    public static PolymerModelData COPPER_SHOVEL_MODEL = PolymerResourcePackUtils.requestModel(Items.IRON_SHOVEL, PathHelper.getItemModelId("copper_shovel"));
    public static PolymerModelData COPPER_AXE_MODEL = PolymerResourcePackUtils.requestModel(Items.IRON_AXE, PathHelper.getItemModelId("copper_axe"));
    public static PolymerModelData COPPER_SWORD_MODEL = PolymerResourcePackUtils.requestModel(Items.IRON_SWORD, PathHelper.getItemModelId("copper_sword"));
    public static PolymerModelData NETHERITE_SPEAR_MODEL = PolymerResourcePackUtils.requestModel(Items.NETHERITE_SWORD, PathHelper.getItemModelId("netherite_spear"));
    public static PolymerModelData DIAMOND_SPEAR_MODEL = PolymerResourcePackUtils.requestModel(Items.DIAMOND_SWORD, PathHelper.getItemModelId("diamond_spear"));
    public static PolymerModelData NETHERITE_GREATSWORD_MODEL = PolymerResourcePackUtils.requestModel(Items.NETHERITE_SWORD, PathHelper.getItemModelId("netherite_greatsword"));

    // not implemented
    public static final PolymerModelData IRON_RING_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("iron_ring"));
    public static final PolymerModelData OPAL_RING_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("opal_ring"));
    public static final PolymerModelData RUBY_RING_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("ruby_ring"));
    public static final PolymerModelData SAPPHIRE_RING_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("sapphire_ring"));
    public static final PolymerModelData TOPAZ_RING_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("topaz_ring"));
}
