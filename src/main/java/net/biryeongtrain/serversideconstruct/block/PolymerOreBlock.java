package net.biryeongtrain.serversideconstruct.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.intprovider.IntProvider;

public class PolymerOreBlock extends PolymerSimpleEXPDropBlock {
    public PolymerOreBlock(IntProvider experienceDropped, BlockState state, Settings settings) {
        super(experienceDropped,
                state, settings);
    }

    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, ServerPlayerEntity player) {
        return Blocks.STONE.getDefaultState();
    }


}
