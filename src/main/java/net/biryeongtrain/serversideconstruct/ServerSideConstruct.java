package net.biryeongtrain.serversideconstruct;

import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.biryeongtrain.serversideconstruct.registry.*;
import net.fabricmc.api.ModInitializer;
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
        SSCWorldGenKeys.register();
        SSCToolRegistry.register();
    }
}
