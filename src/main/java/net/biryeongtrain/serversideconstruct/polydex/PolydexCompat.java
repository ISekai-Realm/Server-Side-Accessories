package net.biryeongtrain.serversideconstruct.polydex;

import net.biryeongtrain.serversideconstruct.ServerSideConstruct;
import net.fabricmc.loader.api.FabricLoader;

public class PolydexCompat {
    private static boolean IS_PRESENT = FabricLoader.getInstance().isModLoaded("polydex2");
    
    public static void register() {
        if (IS_PRESENT) {
            
        } else {
            ServerSideConstruct.LOGGER.warn("Polydex is not found, For the best experience, it's highly suggest to install it.");
        }
    }
}
