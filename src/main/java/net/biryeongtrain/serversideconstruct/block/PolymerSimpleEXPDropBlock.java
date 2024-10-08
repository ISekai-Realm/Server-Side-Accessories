package net.biryeongtrain.serversideconstruct.block;

import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import eu.pb4.polymer.core.api.block.PolymerBlock;
import net.biryeongtrain.serversideconstruct.ServerSideConstruct;
import net.minecraft.block.BlockState;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.util.math.intprovider.IntProvider;

public class PolymerSimpleEXPDropBlock extends ExperienceDroppingBlock implements PolymerTexturedBlock {
    private final BlockState polymerBlockState;

    public PolymerSimpleEXPDropBlock(IntProvider experienceDropped, BlockState polymerBlockState, Settings settings) {
        super(experienceDropped, settings);
        this.polymerBlockState = polymerBlockState;
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return this.polymerBlockState;
    }
}
