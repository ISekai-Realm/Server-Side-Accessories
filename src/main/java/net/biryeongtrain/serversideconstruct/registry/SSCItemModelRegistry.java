package net.biryeongtrain.serversideconstruct.registry;

import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.item.Items;

public class SSCItemModelRegistry {
    public static PolymerModelData ONYX_GEM_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("onyx_gem"));
}
