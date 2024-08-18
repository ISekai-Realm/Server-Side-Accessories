package net.biryeongtrain.serversideconstruct.registry;

import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.block.BlockState;

public class SSCBlockModelRegistry {
    public static BlockState ONYX_BLOCK_STATE = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(PathHelper.getBlockModelId("onyx_ore")));
    public static BlockState DEEPSLATE_ONYX_BLOCK_STATE = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(PathHelper.getBlockModelId("deepslate_onyx_ore")));
}
