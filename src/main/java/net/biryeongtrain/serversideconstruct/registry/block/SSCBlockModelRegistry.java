package net.biryeongtrain.serversideconstruct.registry.block;

import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.block.BlockState;

import static net.biryeongtrain.serversideconstruct.ServerSideConstruct.LOGGER;

public class SSCBlockModelRegistry {
    public static final BlockState ONYX_ORE = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(PathHelper.getBlockModelId("onyx_ore")));
    public static final BlockState DEEPSLATE_ONYX_BLOCK_STATE = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(PathHelper.getBlockModelId("deepslate_onyx_ore")));
    static {
        LOGGER.info(ONYX_ORE.toString());
    }
}
