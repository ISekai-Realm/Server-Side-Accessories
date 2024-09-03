package net.biryeongtrain.serversideconstruct.item.rune;

public enum RuneTier {
    TIER_1(1, 1, 3),
    TIER_2(2, 1, 4),
    TIER_3(3, 2, 5),
    ;


    public final int tier;
    public final int minAttributes;
    public final int maxAttributes;

    RuneTier(int tier, int minAttributes, int maxAttributes) {
        this.tier = tier;
        this.minAttributes = minAttributes;
        this.maxAttributes = maxAttributes;
    }
}
