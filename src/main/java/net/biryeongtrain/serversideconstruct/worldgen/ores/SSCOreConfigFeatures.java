package net.biryeongtrain.serversideconstruct.worldgen.ores;

import net.biryeongtrain.serversideconstruct.registry.SSCBlockRegistry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SSCOreConfigFeatures {
    private static final Map<String, RegistryKey<PlacedFeature>> keyMap = new HashMap<>();
    public static final Map<RegistryKey<PlacedFeature>, List<PlacementModifier>> datagenModifierLists = new HashMap<>();
    public static final OreFeatureConfig ONYX_ORE_CONFIGURE;
    public static final ConfiguredFeature<?, ?> ONYX_CONFIGURE = new ConfiguredFeature<OreFeatureConfig, OreFeature>(new OnyxOreFeatures(), SSCOreConfigFeatures.ONYX_ORE_CONFIGURE);
    //    public static final RegistryEntry<PlacedFeature> ONYX_ORE_CONFIGURED = register(OnyxOreFeatures.ONYX_ORE_PLACE, ONYX_CONFIGURE, PlacedFeatures.)
    static {
        TagMatchRuleTest ruleTest2 = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        TagMatchRuleTest ruleTest3 = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        var onyx_predicate = List.of(OreFeatureConfig.createTarget(ruleTest2, SSCBlockRegistry.ONYX_ORE.getDefaultState()), OreFeatureConfig.createTarget(ruleTest3, SSCBlockRegistry.DEEPSLATE_ONYX_ORE.getDefaultState()));
        ONYX_ORE_CONFIGURE = new OreFeatureConfig(onyx_predicate, 3);


    }

    public static RegistryEntry<PlacedFeature> register(RegistryKey<PlacedFeature> key, ConfiguredFeature<?, ?> feature, PlacementModifier... modifiers) {
        return register(key, feature, List.of(modifiers));
    }

    public static RegistryEntry<PlacedFeature> register(RegistryKey<PlacedFeature> key, ConfiguredFeature<?, ?> holder, List<PlacementModifier> modifiers) {
        keyMap.put(key.getRegistry().getPath(), key);
        RegistryEntry<PlacedFeature> direct = RegistryEntry.of(new PlacedFeature(RegistryEntry.of(holder), modifiers));
        datagenModifierLists.put(key, modifiers);
        return direct;
    }
}
