package net.biryeongtrain.serversideconstruct;

import com.mojang.serialization.JsonOps;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.biryeongtrain.serversideconstruct.attributes.Attributes;
import net.biryeongtrain.serversideconstruct.data.RuneAttributeTypeLoader;
import net.biryeongtrain.serversideconstruct.item.rune.RuneAttributes;
import net.biryeongtrain.serversideconstruct.registry.*;
import net.biryeongtrain.serversideconstruct.registry.block.SSCBlockEntityRegistry;
import net.biryeongtrain.serversideconstruct.registry.block.SSCBlockRegistry;
import net.biryeongtrain.serversideconstruct.registry.item.*;
import net.biryeongtrain.serversideconstruct.ui.GuiTextures;
import net.biryeongtrain.serversideconstruct.ui.UiResourceCreator;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.resource.ResourceType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.floatprovider.UniformFloatProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ServerSideConstruct implements ModInitializer {
    public static final String MOD_ID = "ss_construct";
    public static final Logger LOGGER = LoggerFactory.getLogger("ServerSideConstruct");
    private static MinecraftServer SERVER;
    @Override
    public void onInitialize() {
        PolymerResourcePackUtils.addModAssets(MOD_ID);
        PolymerResourcePackUtils.markAsRequired();

        SSCResourceItemRegistry.register();
        SSCJewelryRegistry.register();
        SSCBlockEntityRegistry.register();
        SSCBlockRegistry.register();
        SSCToolRegistry.register();
        SSCBlockItemRegistry.register();

        //Dynamic.
        SSCRecipeTypes.register();
        SSCWorldGenKeys.register();
        Attributes.register();
        SSCItemTags.register();
        RecipeSerializers.register();

        UiResourceCreator.setup();
        GuiTextures.register();

        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new RuneAttributeTypeLoader());
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            SERVER = server;
        });


        var test = new RuneAttributes(EntityAttributes.GENERIC_ATTACK_DAMAGE, EntityAttributeModifier.Operation.ADD_VALUE, UniformFloatProvider.create(1.0f, 2.0f), 100,  3);
        var test2 = new RuneAttributes(EntityAttributes.GENERIC_ATTACK_DAMAGE, EntityAttributeModifier.Operation.ADD_VALUE, UniformFloatProvider.create(1.0f, 5.0f), 100, 2);
        var list = List.of(test, test2);
        RuneAttributes.CODEC.encodeStart(JsonOps.INSTANCE, test).result().ifPresent((element) -> {
            LOGGER.info(element.toString());
        });

        RuneAttributes.CODEC.listOf().encodeStart(JsonOps.INSTANCE, list).result().ifPresent((element) -> {
            LOGGER.info(element.toString());
        });
    }
}
