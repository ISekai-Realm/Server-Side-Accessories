package net.biryeongtrain.serversideconstruct.item.tools;

import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import net.biryeongtrain.serversideconstruct.component.ToolComponents;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.biryeongtrain.serversideconstruct.registry.SSCItemModelRegistry.*;

public class CopperMiningTool extends MiningToolItem implements PolymerItem {
    public static long DAMAGE_START_TICK = 24000L;
    public static long OXIDATION_PARTS = 4;
    public static long OXIDATION_TEXTURE_TICK = DAMAGE_START_TICK / OXIDATION_PARTS;
    public static long DAMAGE_INTERVAL = 100L;
    public static Map<TagKey<Block>, List<PolymerModelData>> MODELS = new HashMap<>();
    private final TagKey<Block> tag;

    public CopperMiningTool(ToolMaterial material, TagKey<Block> effectiveBlocks, Settings settings) {
        super(material, effectiveBlocks, settings);
        this.tag = effectiveBlocks;
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        var age = itemStack.getOrDefault(ToolComponents.COPPER_AGE, 0L);
        var partLvl = getAge(age);
        return switch(partLvl) {
            case 0 -> MODELS.get(this.tag).get(0).item();
            case 1 -> MODELS.get(this.tag).get(1).item();
            case 2 -> MODELS.get(this.tag).get(2).item();
            default -> MODELS.get(this.tag).get(3).item();
        };
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        var age = itemStack.getOrDefault(ToolComponents.COPPER_AGE, 0L);
        var partLvl = getAge(age);
        return switch(partLvl) {
            case 0 -> MODELS.get(this.tag).get(0).value();
            case 1 -> MODELS.get(this.tag).get(1).value();
            case 2 -> MODELS.get(this.tag).get(2).value();
            default -> MODELS.get(this.tag).get(3).value();
        };
    }

    private int getAge(long age) {
        return (int) (age / OXIDATION_TEXTURE_TICK);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (world.isClient) {
            return;
        }
        var age = stack.getOrDefault(ToolComponents.COPPER_AGE, -1L);
        if (age == -1) {
            return;
        }
        if (entity.age % 1200L == 0) {
            stack.set(ToolComponents.COPPER_AGE, age + 1200L);
        }

        if (age < DAMAGE_START_TICK || age % DAMAGE_INTERVAL != 0) {
            return;
        }
        stack.damage(1, (ServerWorld) entity.getWorld(), entity instanceof ServerPlayerEntity ? (ServerPlayerEntity) entity : null, item -> {});
    }

    static {
        MODELS.put(BlockTags.PICKAXE_MINEABLE, List.of(COPPER_PICKAXE_MODEL_AGE_0, COPPER_PICKAXE_MODEL_AGE_1, COPPER_PICKAXE_MODEL_AGE_2, COPPER_PICKAXE_MODEL_AGE_3));
    }
}
