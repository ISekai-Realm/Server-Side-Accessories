package net.biryeongtrain.serversideconstruct.registry.block;

import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.block.BlockState;
import net.minecraft.item.Items;

public class SSCBlockModelRegistry {
    public static final BlockState ONYX_ORE = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(PathHelper.getBlockModelId("onyx_ore")));
    public static final BlockState DEEPSLATE_ONYX_ORE = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(PathHelper.getBlockModelId("deepslate_onyx_ore")));
    public static final BlockState OPAL_ORE = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(PathHelper.getBlockModelId("opal_ore")));
    public static final BlockState DEEPSLATE_OPAL_ORE = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(PathHelper.getBlockModelId("deepslate_opal_ore")));
    public static final BlockState RUBY_ORE = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(PathHelper.getBlockModelId("ruby_ore")));
    public static final BlockState DEEPSLATE_RUBY_ORE = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(PathHelper.getBlockModelId("deepslate_ruby_ore")));
    public static final BlockState SAPPHIRE_ORE = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(PathHelper.getBlockModelId("sapphire_ore")));
    public static final BlockState DEEPSLATE_SAPPHIRE_ORE = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(PathHelper.getBlockModelId("deepslate_sapphire_ore")));
    public static final BlockState TOPAZ_ORE = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(PathHelper.getBlockModelId("topaz_ore")));
    public static final BlockState DEEPSLATE_TOPAZ_ORE = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(PathHelper.getBlockModelId("deepslate_topaz_ore")));
    public static final PolymerModelData JEWELER_MODEL = PolymerResourcePackUtils.requestModel(Items.PAPER, PathHelper.getItemModelId("jeweler"));

}
