package net.biryeongtrain.serversideconstruct.component;

import com.mojang.serialization.Codec;
import net.biryeongtrain.serversideconstruct.utils.RandomHelper;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;
import net.minecraft.util.StringIdentifiable;
import org.apache.commons.lang3.ArrayUtils;

import java.util.List;

import static net.biryeongtrain.serversideconstruct.ServerSideConstruct.LOGGER;
import static net.biryeongtrain.serversideconstruct.registry.SSCJewelryRegistry.*;

public enum RuneType implements StringIdentifiable {
    EXPLORE("explore", ONYX_RING, "#757575"),
    MINING("mining", OPAL_RING, "#91dded"),
    COMBAT("combat", RUBY_RING, "#d80606 "),
    WATER_EXPLORE("water_explore", SAPPHIRE_RING, "#1298ff"),
    EXPERIENCE("experience", TOPAZ_RING, "#edbd39"),
    EVERYTHING("everything", Items.AIR, 10, "#ffffff"),
    NOTHING("nothing", Items.AIR, 0, "#757575")
    ;

    RuneType(String name, Item onColorItem, String hexColor) {
        this(name, onColorItem, 100, hexColor);
    }


    RuneType(String name, Item onColorItem, int defaultWeight, String hexColor) {
        this.name = name;
        this.onColorItem = onColorItem;
        this.defaultWeight = defaultWeight;
        var parseResult = TextColor.parse(hexColor);
        if (parseResult.isError()) {
            this.rgbColor = TextColor.fromFormatting(Formatting.WHITE);
            LOGGER.error("Failed to parse hex color for rune type: {}", name);
        }
        else {
            this.rgbColor = parseResult.result().orElseGet(() -> {
                LOGGER.error("Failed to get hex color {}, is empty?", hexColor);
                return TextColor.fromFormatting(Formatting.WHITE);
            });
        }
    }

    private final String name;
    public final Item onColorItem;
    public final int defaultWeight;
    public final TextColor rgbColor;

    public static final Codec<RuneType> CODEC;
    public static final int DOUBLE_ON_COLOR_ADD_WEIGHT = 3;
    private static final List<RuneType> VALIDATE_TYPE = List.of(EXPLORE, MINING, COMBAT, WATER_EXPLORE, EXPERIENCE, EVERYTHING);
    private static final int TOTAL_WEIGHT = VALIDATE_TYPE.stream().mapToInt(value -> value.defaultWeight).sum();
    static {
        CODEC = StringIdentifiable.createCodec(RuneType::values);
    }

    public static RuneType getOnColorType(Item item) {
        for (RuneType value : values()) {
            if(value.onColorItem == item) {
                return value;
            }
        }
        return NOTHING;
    }

    public static RuneType roll(Item item) {
        RuneType onColorType = getOnColorType(item);
        int weight = onColorType == NOTHING ? TOTAL_WEIGHT : TOTAL_WEIGHT *2;
        int roll = RandomHelper.getRandom(0, weight);
        if (roll > TOTAL_WEIGHT) {
            return onColorType;
        }
        return checkWeight(roll);
    }

    private static RuneType checkWeight(int weight) {
        int currentWeight = 0;
        for (RuneType runeType : VALIDATE_TYPE) {
            currentWeight += runeType.defaultWeight;
            if (weight <= currentWeight) {
                return runeType;
            }
        }
        return NOTHING; // Should never reach here
    }
    @Override
    public String asString() {
        return this.name;
    }

    public String getTranslatableKey() {
        return "rune.ss_construct." + this.name + ".name";
    }
}
