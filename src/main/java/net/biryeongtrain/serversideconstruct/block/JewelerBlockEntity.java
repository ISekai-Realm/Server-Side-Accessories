package net.biryeongtrain.serversideconstruct.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;

public class JewelerBlockEntity extends BlockEntity {
    private static final int[] SLOTS = new int[]{0, 1, 2};
    protected boolean isChanged = false;

    public JewelerBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

//    public JewelerBlockEntity(BlockPos pos, BlockState state) {
//        super(SSCBlockEntityRegistry.JEWELRY_BLOCK_ENTITY, pos, state);
//    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup lookup) {
        super.readNbt(nbt, lookup);
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup lookup) {
        super.writeNbt(nbt, lookup);
    }

    @Override
    public void markDirty() {
        super.markDirty();

    }
}
