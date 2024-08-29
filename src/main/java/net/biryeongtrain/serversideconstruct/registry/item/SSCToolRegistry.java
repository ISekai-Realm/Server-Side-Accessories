package net.biryeongtrain.serversideconstruct.registry.item;

import net.biryeongtrain.serversideconstruct.component.ToolComponents;
import net.biryeongtrain.serversideconstruct.item.tools.*;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;

public class SSCToolRegistry {
    public static final Item COPPER_PICKAXE = Registry.register(
            Registries.ITEM,
            PathHelper.getModId("copper_pickaxe"),
            (Item) new CopperMiningTool(SSCMaterialTier.COPPER_MATERIAL,
                    BlockTags.PICKAXE_MINEABLE,
                    new Item.Settings()
                            .component(ToolComponents.COPPER_AGE, 0L)
                            .attributeModifiers(PickaxeItem.createAttributeModifiers(SSCMaterialTier.COPPER_MATERIAL, 1.5f, -2.8f))
                    ));

    public static final Item COPPER_SHOVEL = Registry.register(
            Registries.ITEM,
            PathHelper.getModId("copper_shovel"),
            (Item) new PolymerMiningToolItem(SSCMaterialTier.COPPER_MATERIAL,
                    BlockTags.SHOVEL_MINEABLE,
                    new Item.Settings()
                            .attributeModifiers(ShovelItem.createAttributeModifiers(SSCMaterialTier.COPPER_MATERIAL, 2f, -3.0f)),
                    SSCItemModelRegistry.COPPER_SHOVEL_MODEL)
    );
    public static final Item COPPER_AXE = Registry.register(
            Registries.ITEM,
            PathHelper.getModId("copper_axe"),
            (Item) new PolymerMiningToolItem(SSCMaterialTier.COPPER_MATERIAL,
                    BlockTags.AXE_MINEABLE,
                    new Item.Settings()
                            .attributeModifiers(AxeItem.createAttributeModifiers(SSCMaterialTier.COPPER_MATERIAL, 7.5f, -3.2f)),
                    SSCItemModelRegistry.COPPER_AXE_MODEL)
    );
    public static final Item COPPER_SWORD = Registry.register(
            Registries.ITEM,
            PathHelper.getModId("copper_sword"),
            (Item) new ToolPolymerItem(SSCMaterialTier.COPPER_MATERIAL,
                    new Item.Settings()
                            .attributeModifiers(SwordItem.createAttributeModifiers(SSCMaterialTier.COPPER_MATERIAL, 3, -2.4f)),
                    SSCItemModelRegistry.COPPER_SWORD_MODEL)
    );

    public static final Item NETHERITE_SPEAR = Registry.register(
            Registries.ITEM,
            PathHelper.getModId("netherite_spear"),
            (Item) new SpearPolymerItem(ToolMaterials.NETHERITE,
                    new Item.Settings()
                            .attributeModifiers(SpearPolymerItem.createAttributeModifiers(ToolMaterials.NETHERITE, 2, -3f)),
                    SSCItemModelRegistry.NETHERITE_SPEAR_MODEL)
    );

    public static final Item DIAMOND_SPEAR = Registry.register(
            Registries.ITEM,
            PathHelper.getModId("diamond_spear"),
            (Item) new SpearPolymerItem(ToolMaterials.DIAMOND,
                    new Item.Settings()
                            .attributeModifiers(SpearPolymerItem.createAttributeModifiers(ToolMaterials.DIAMOND, 2, -3f))
                            .fireproof(),
                    SSCItemModelRegistry.DIAMOND_SPEAR_MODEL)
    );

    public static final Item NETHERITE_GREATSWORD = Registry.register(Registries.ITEM, PathHelper.getModId("netherite_greatsword"), (Item) new GreatSwordPolymerItem(ToolMaterials.NETHERITE,
            new Item.Settings()
                    .attributeModifiers(GreatSwordPolymerItem.createAttributeModifiers(ToolMaterials.NETHERITE, 6, -3.2f))
                    .fireproof(),
            SSCItemModelRegistry.NETHERITE_GREATSWORD_MODEL
    ));

    public static void register() {

    }
}
