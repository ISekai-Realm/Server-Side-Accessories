package net.biryeongtrain.serversideconstruct.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
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
        Map<Identifier, Resource> resources = manager.findResources("rune_attributes", (path) -> {
            return path.getPath().endsWith(".json");
        });

        for (Map.Entry<Identifier, Resource> identifierResourceEntry : resources.entrySet()) {
            Identifier id = (Identifier) ((Map.Entry) identifierResourceEntry).getKey();
            Resource resource = (Resource) ((Map.Entry) identifierResourceEntry).getValue();
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
                    result.result().ifPresent((data) -> {
                        ATTRIBUTES.put(type, data);
                    });
                } catch (JsonIOException e) {
                    throw new RuntimeException(e);
                } catch (JsonSyntaxException e) {
                    throw new RuntimeException(e);
                }
                // Do something with the resource
                reader.close();
            } catch (Exception e) {
                // Handle the exception
            }
        }
    }
}
