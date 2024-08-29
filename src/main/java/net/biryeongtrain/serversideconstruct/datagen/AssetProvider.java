package net.biryeongtrain.serversideconstruct.datagen;

import com.google.common.hash.HashCode;
import net.biryeongtrain.serversideconstruct.ui.UiResourceCreator;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.util.Util;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class AssetProvider implements DataProvider {
    private final DataOutput output;

    public AssetProvider(DataOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        BiConsumer<String, byte[]> assetWriter = (path, data) -> {
            try {
                writer.write(this.output.getPath().resolve(path), data, HashCode.fromBytes(data));
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        return CompletableFuture.runAsync(() -> {
            runWriters(assetWriter);
        }, Util.getMainWorkerExecutor());
    }

    public static void runWriters(BiConsumer<String,byte[]> assetWriter) {
        UiResourceCreator.generateAssets(assetWriter);
    }

    @Override
    public String getName() {
        return "ss_constructs:assets";
    }
}
