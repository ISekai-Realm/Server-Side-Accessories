package net.biryeongtrain.serversideconstruct;

import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.biryeongtrain.serversideconstruct.attributes.Attributes;
import net.biryeongtrain.serversideconstruct.registry.*;
import net.biryeongtrain.serversideconstruct.registry.block.SSCBlockEntityRegistry;
import net.biryeongtrain.serversideconstruct.registry.block.SSCBlockRegistry;
import net.biryeongtrain.serversideconstruct.registry.item.SSCItemTags;
import net.biryeongtrain.serversideconstruct.registry.item.SSCJewelryRegistry;
import net.biryeongtrain.serversideconstruct.registry.item.SSCResourceItemRegistry;
import net.biryeongtrain.serversideconstruct.registry.item.SSCToolRegistry;
import net.biryeongtrain.serversideconstruct.ui.GuiTextures;
import net.biryeongtrain.serversideconstruct.ui.UiResourceCreator;
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
        SSCBlockEntityRegistry.register();
        SSCBlockRegistry.register();
        SSCToolRegistry.register();

        //Dynamic.
        SSCRecipeTypes.register();
        SSCWorldGenKeys.register();
        Attributes.register();
        SSCItemTags.register();
        RecipeSerializers.register();

        UiResourceCreator.setup();
        GuiTextures.register();
    }
}
