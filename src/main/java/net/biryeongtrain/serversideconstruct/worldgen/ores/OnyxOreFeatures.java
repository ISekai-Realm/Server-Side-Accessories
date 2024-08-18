package net.biryeongtrain.serversideconstruct.worldgen.ores;

import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Set;
import java.util.function.Predicate;

public class OnyxOreFeatures extends OreFeature {
    public static final Identifier ID = PathHelper.getModId("onyx_ore_feature");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ONYX_ORE_CONFIGURE = RegistryKey
            .of(RegistryKeys.CONFIGURED_FEATURE, ID);
    public static final RegistryKey<PlacedFeature> ONYX_ORE_PLACE = RegistryKey
            .of(RegistryKeys.PLACED_FEATURE, ID);
    public static final Predicate<BiomeSelectionContext> GENERATE_BIOMES = BiomeSelectors.all();

    private final Set<RegistryKey<World>> generate_dimensions = Set.of(World.OVERWORLD);


    public OnyxOreFeatures() {
        super(OreFeatureConfig.CODEC);

    }

    @Override
    public boolean generate(FeatureContext<OreFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        if (!generate_dimensions.contains(world.toServerWorld().getRegistryKey())) {
            return false;
        }

        return super.generate(context);
    }
}
