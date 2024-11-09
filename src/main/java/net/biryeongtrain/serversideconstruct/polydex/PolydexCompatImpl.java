package net.biryeongtrain.serversideconstruct.polydex;

import eu.pb4.polydex.api.v1.recipe.PolydexCategory;
import eu.pb4.polydex.api.v1.recipe.PolydexEntry;
import eu.pb4.polydex.api.v1.recipe.PolydexPage;
import net.biryeongtrain.serversideconstruct.registry.item.SSCJewelryRegistry;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

import java.util.function.Consumer;

public class PolydexCompatImpl {
    public static final PolydexCategory CATEGORY = PolydexCategory.of(PathHelper.getModId("jeweler")); 
    public static void register() {
        PolydexEntry.registerEntryCreator(SSCJewelryRegistry.OPAL_RING, PolydexCompatImpl::createEntries);
    }
    
    private static PolydexEntry createEntries(ItemStack stack) {
        return null;
    }
    
    private static void createPages(MinecraftServer server, Consumer<PolydexPage> pageConsumer) {
    }
}
