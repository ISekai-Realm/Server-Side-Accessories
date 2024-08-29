package net.biryeongtrain.serversideconstruct.registry.block;

import eu.pb4.polymer.core.api.block.PolymerBlockUtils;
import net.biryeongtrain.serversideconstruct.block.JewelerBlockEntity;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class SSCBlockEntityRegistry {
    public static final BlockEntityType<JewelerBlockEntity> JEWELRY_BLOCK_ENTITY = register("jeweler_block_entity",
            BlockEntityType.Builder.create(JewelerBlockEntity::new, SSCBlockRegistry.JEWELER_BLOCK));

    public static void register() {

    }
    private static <T extends BlockEntity> BlockEntityType<T> register(BlockEntityType<T> blockEntityType) {
        PolymerBlockUtils.registerBlockEntity(blockEntityType);
        return blockEntityType;
    }

    public static <T extends BlockEntity> BlockEntityType<T> register(String path, BlockEntityType.Builder<T> item) {
        var x = Registry.register(Registries.BLOCK_ENTITY_TYPE, PathHelper.getModId(path), item.build(null));
        PolymerBlockUtils.registerBlockEntity(x);
        return x;
    }
}
