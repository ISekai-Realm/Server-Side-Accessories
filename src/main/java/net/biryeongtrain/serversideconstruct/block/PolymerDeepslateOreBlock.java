package net.biryeongtrain.serversideconstruct.block;

import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.intprovider.IntProvider;

public class PolymerDeepslateOreBlock extends PolymerSimpleEXPDropBlock {
    public PolymerDeepslateOreBlock(IntProvider experienceDropped, String path, Settings settings) {
        super(experienceDropped,
                PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(PathHelper.getBlockModelId(path)))
                , settings);
    }

    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, ServerPlayerEntity player) {
        return Blocks.DEEPSLATE.getDefaultState();
    }
}
