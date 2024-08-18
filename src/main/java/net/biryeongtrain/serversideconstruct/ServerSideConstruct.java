package net.biryeongtrain.serversideconstruct;

import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.biryeongtrain.serversideconstruct.item.OnyxRing;
import net.biryeongtrain.serversideconstruct.item.TestTrinket;
import net.biryeongtrain.serversideconstruct.registry.SSCBlockRegistry;
import net.biryeongtrain.serversideconstruct.registry.SSCItemModelRegistry;
import net.biryeongtrain.serversideconstruct.registry.SSCJewelryRegistry;
import net.biryeongtrain.serversideconstruct.registry.SSCResourceItemRegistry;
import net.biryeongtrain.serversideconstruct.worldgen.WorldGenInit;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerSideConstruct implements ModInitializer {
    public static final String MOD_ID = "ss_construct";
    public static final Logger LOGGER = LoggerFactory.getLogger("ServerSideConstruct");
    @Override
    public void onInitialize() {
        PolymerResourcePackUtils.addModAssets(MOD_ID);
        PolymerResourcePackUtils.markAsRequired();

        SSCResourceItemRegistry.register();
        SSCJewelryRegistry.register();
        SSCBlockRegistry.register();
//        WorldGenInit.init();
    }
}
