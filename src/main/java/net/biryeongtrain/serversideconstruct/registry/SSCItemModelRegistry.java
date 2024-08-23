package net.biryeongtrain.serversideconstruct.registry;

import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.item.Items;

public class SSCItemModelRegistry {
    public static PolymerModelData ONYX_GEM_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("onyx_gem"));
    public static PolymerModelData COPPER_PICKAXE_MODEL = PolymerResourcePackUtils.requestModel(Items.IRON_PICKAXE, PathHelper.getItemModelId("copper_pickaxe"));
    public static PolymerModelData COPPER_SHOVEL_MODEL = PolymerResourcePackUtils.requestModel(Items.IRON_SHOVEL, PathHelper.getItemModelId("copper_shovel"));
    public static PolymerModelData COPPER_AXE_MODEL = PolymerResourcePackUtils.requestModel(Items.IRON_AXE, PathHelper.getItemModelId("copper_axe"));
    public static PolymerModelData COPPER_SWORD_MODEL = PolymerResourcePackUtils.requestModel(Items.IRON_SWORD, PathHelper.getItemModelId("copper_sword"));
}
