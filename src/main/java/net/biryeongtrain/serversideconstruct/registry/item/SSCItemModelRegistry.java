package net.biryeongtrain.serversideconstruct.registry.item;

import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.item.Items;

public class SSCItemModelRegistry {
    // GEMS
    public static PolymerModelData ONYX_GEM_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("onyx_gem"));
    public static PolymerModelData RUBY_GEM_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("ruby_gem"));
    public static PolymerModelData SAPPHIRE_GEM_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("sapphire_gem"));
    public static PolymerModelData OPAL_GEM_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("opal_gem"));
    public static PolymerModelData TOPAZ_GEM_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("topaz_gem"));
    // TOOLS
    public static PolymerModelData COPPER_PICKAXE_MODEL_AGE_0 = PolymerResourcePackUtils.requestModel(Items.IRON_PICKAXE, PathHelper.getItemModelId("copper_pickaxe0"));
    public static PolymerModelData COPPER_PICKAXE_MODEL_AGE_1 = PolymerResourcePackUtils.requestModel(Items.IRON_PICKAXE, PathHelper.getItemModelId("copper_pickaxe1"));
    public static PolymerModelData COPPER_PICKAXE_MODEL_AGE_2 = PolymerResourcePackUtils.requestModel(Items.IRON_PICKAXE, PathHelper.getItemModelId("copper_pickaxe2"));
    public static PolymerModelData COPPER_PICKAXE_MODEL_AGE_3 = PolymerResourcePackUtils.requestModel(Items.IRON_PICKAXE, PathHelper.getItemModelId("copper_pickaxe3"));
    public static PolymerModelData COPPER_SHOVEL_MODEL = PolymerResourcePackUtils.requestModel(Items.IRON_SHOVEL, PathHelper.getItemModelId("copper_shovel"));
    public static PolymerModelData COPPER_AXE_MODEL = PolymerResourcePackUtils.requestModel(Items.IRON_AXE, PathHelper.getItemModelId("copper_axe"));
    public static PolymerModelData COPPER_SWORD_MODEL = PolymerResourcePackUtils.requestModel(Items.IRON_SWORD, PathHelper.getItemModelId("copper_sword"));

    // OTHER WEAPONS
    public static PolymerModelData NETHERITE_SPEAR_MODEL = PolymerResourcePackUtils.requestModel(Items.NETHERITE_SWORD, PathHelper.getItemModelId("netherite_spear"));
    public static PolymerModelData DIAMOND_SPEAR_MODEL = PolymerResourcePackUtils.requestModel(Items.DIAMOND_SWORD, PathHelper.getItemModelId("diamond_spear"));
    public static PolymerModelData NETHERITE_GREATSWORD_MODEL = PolymerResourcePackUtils.requestModel(Items.NETHERITE_SWORD, PathHelper.getItemModelId("netherite_greatsword"));

    public static final PolymerModelData IRON_RING_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("iron_ring"));
    public static final PolymerModelData OPAL_RING_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("opal_ring"));
    public static final PolymerModelData RUBY_RING_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("ruby_ring"));
    public static final PolymerModelData SAPPHIRE_RING_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("sapphire_ring"));
    public static final PolymerModelData TOPAZ_RING_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("topaz_ring"));

    public static final PolymerModelData TIER_1_RUBY_RUNE_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("tier_1_ruby_rune"));
    public static final PolymerModelData TIER_2_RUBY_RUNE_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("tier_2_ruby_rune"));
    public static final PolymerModelData TIER_3_RUBY_RUNE_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("tier_3_ruby_rune"));
    public static final PolymerModelData TIER_1_OPAL_RUNE_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("tier_1_opal_rune"));
    public static final PolymerModelData TIER_2_OPAL_RUNE_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("tier_2_opal_rune"));
    public static final PolymerModelData TIER_3_OPAL_RUNE_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("tier_3_opal_rune"));
    public static final PolymerModelData TIER_1_SAPPHIRE_RUNE_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("tier_1_sapphire_rune"));
    public static final PolymerModelData TIER_2_SAPPHIRE_RUNE_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("tier_2_sapphire_rune"));
    public static final PolymerModelData TIER_3_SAPPHIRE_RUNE_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("tier_3_sapphire_rune"));
    public static final PolymerModelData TIER_1_TOPAZ_RUNE_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("tier_1_topaz_rune"));
    public static final PolymerModelData TIER_2_TOPAZ_RUNE_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("tier_2_topaz_rune"));
    public static final PolymerModelData TIER_3_TOPAZ_RUNE_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("tier_3_topaz_rune"));
    public static final PolymerModelData TIER_1_ONYX_RUNE_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("tier_1_onyx_rune"));
    public static final PolymerModelData TIER_2_ONYX_RUNE_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("tier_2_onyx_rune"));
    public static final PolymerModelData TIER_3_ONYX_RUNE_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("tier_3_onyx_rune"));
}
