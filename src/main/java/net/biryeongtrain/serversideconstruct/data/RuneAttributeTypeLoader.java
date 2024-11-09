package net.biryeongtrain.serversideconstruct.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import net.biryeongtrain.serversideconstruct.ServerSideConstruct;
import net.biryeongtrain.serversideconstruct.component.RuneType;
import net.biryeongtrain.serversideconstruct.item.rune.RuneAttributes;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.EnumUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RuneAttributeTypeLoader implements SimpleSynchronousResourceReloadListener {
    public static final EnumMap<RuneType, List<RuneAttributes>> ATTRIBUTES = new EnumMap<>(RuneType.class);

    @Override
    public Identifier getFabricId() {
        return null;
    }

    @Override
    public void reload(ResourceManager manager) {
        ATTRIBUTES.clear();
        Map<Identifier, Resource> resources = manager.findResources("rune_attributes", (path) -> path.getPath().endsWith(".json"));
        var test2 = manager.findResources("ss_construct", (path) -> path.getPath().endsWith(".json"));
        for (Map.Entry<Identifier, Resource> identifierResourceEntry : resources.entrySet()) {
            Identifier id = identifierResourceEntry.getKey();
            Resource resource = identifierResourceEntry.getValue();
            var typeString = id.getPath()
                    .replace("rune_attributes/", "")
                    .replace(".json", "");
            var type = EnumUtils.getEnum(RuneType.class, typeString.toUpperCase());

            if (type == null) {
                continue;
            }
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

                try {
                    JsonElement json = JsonParser.parseReader(reader);
                    DataResult<List<RuneAttributes>> result = RuneAttributes.CODEC.listOf().parse(JsonOps.INSTANCE, json);

                    result.result().ifPresent((data) -> ATTRIBUTES.put(type, data));
                    result.error().ifPresent((error) -> ServerSideConstruct.LOGGER.error("Failed to parse rune attribute at {}: {}", id, error));

                    RuneAttributeManager.reCalculate(ATTRIBUTES);
                } catch (Throwable ex) {
                    try {
                        reader.close();
                    } catch (Throwable ex2) {
                        ex2.addSuppressed(ex);
                    }

                    throw ex;
                }

                reader.close();

            } catch (Exception e) {
                ServerSideConstruct.LOGGER.error("Failed to read page at {}", id, e);
            }
        }
    }
}
