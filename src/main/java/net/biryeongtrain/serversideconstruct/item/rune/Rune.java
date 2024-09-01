package net.biryeongtrain.serversideconstruct.item.rune;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.biryeongtrain.serversideconstruct.component.RuneType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import org.jetbrains.annotations.Nullable;

public abstract class Rune extends Item implements PolymerItem {
    public Rune(Settings settings) {
        super(settings);
    }

    public abstract RuneType getType();

    
}
