package net.biryeongtrain.serversideconstruct.block.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.slot.Slot;

public class TagWhitelistedSlot extends Slot {
    private final TagKey<Item> tagKey;
    public TagWhitelistedSlot(Inventory inventory, int index, int x, int y, TagKey<Item> tagKey) {
        super(inventory, index, x, y);
        this.tagKey = tagKey;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.isIn(this.tagKey);
    }
}
