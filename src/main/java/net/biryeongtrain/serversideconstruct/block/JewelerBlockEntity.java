package net.biryeongtrain.serversideconstruct.block;

import eu.pb4.sgui.api.gui.SimpleGui;
import net.biryeongtrain.serversideconstruct.block.slot.PredicateWhitelistedSlot;
import net.biryeongtrain.serversideconstruct.block.slot.TagWhitelistedSlot;
import net.biryeongtrain.serversideconstruct.recipe.JewelerRecipe;
import net.biryeongtrain.serversideconstruct.recipe.input.JewelerInput;
import net.biryeongtrain.serversideconstruct.registry.SSCRecipeTypes;
import net.biryeongtrain.serversideconstruct.registry.block.SSCBlockEntityRegistry;
import net.biryeongtrain.serversideconstruct.registry.item.SSCItemTags;
import net.biryeongtrain.serversideconstruct.ui.GuiTextures;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.FurnaceOutputSlot;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class JewelerBlockEntity extends BlockEntity {
    private static final int[] SLOTS = new int[]{0, 1, 2};
    protected boolean isChanged = false;

    public JewelerBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    public JewelerBlockEntity(BlockPos pos, BlockState state) {
        super(SSCBlockEntityRegistry.JEWELRY_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup lookup) {
        super.readNbt(nbt, lookup);
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup lookup) {
        super.writeNbt(nbt, lookup);
    }



    public void createGui(ServerPlayerEntity player) {
        new Gui(player);
    }

    @Override
    public void markDirty() {
        super.markDirty();

    }


    private class Gui extends SimpleGui {
        private final Inventory inventory = new SimpleInventory(2) {
            @Override
            public void markDirty() {
                super.markDirty();
                Gui.this.onChanged();
            }
        };
        private final Slot BASE_SLOT = new TagWhitelistedSlot(this.inventory, 0, 0, 0, SSCItemTags.JEWELRY_ITEMS);
        private final Slot GEM_SLOT = new PredicateWhitelistedSlot(this.inventory, 1, 0, 0, stack -> stack.isIn(SSCItemTags.GEM_ITEMS) || stack.isIn(SSCItemTags.RUNE_ITEMS));
        private final CraftingResultInventory resultInventory = new CraftingResultInventory();
        private final Slot RESULT_SLOT = new FurnaceOutputSlot(player, resultInventory, 0, 0, 0) {
            @Override
            public boolean canTakeItems(PlayerEntity playerEntity) {
                return Gui.this.canTakeOutput(playerEntity, true);
            }

            @Override
            public ItemStack takeStack(int amount) {
                Gui.this.onTakeResultItem();
                return super.takeStack(amount);
            }

            @Override
            public void onQuickTransfer(ItemStack newItem, ItemStack original) {
                onTakeResultItem();
                super.onQuickTransfer(newItem, original);
            }
        };
        @Nullable
        private RecipeEntry<JewelerRecipe> currentRecipe;

        public Gui(ServerPlayerEntity player) {
            super(ScreenHandlerType.GENERIC_9X3, player, false);
            this.setTitle(GuiTextures.JEWELER.apply(JewelerBlockEntity.this.getCachedState().getBlock().getName()));
            this.setSlotRedirect(9 + 1, BASE_SLOT);
            this.setSlotRedirect(9 + 4, GEM_SLOT);
            this.setSlotRedirect(9 + 7, RESULT_SLOT);
            this.open();

        }

        public void onChanged() {
            var input = getInput();
            var recipes = player.getWorld().getRecipeManager().getAllMatches(SSCRecipeTypes.JEWELER, input, world);
            if (recipes.isEmpty()) {
                RESULT_SLOT.setStack(ItemStack.EMPTY);
            } else {
                RecipeEntry<JewelerRecipe> recipe = recipes.getFirst();
                ItemStack result = recipe.value().craft(input, world.getRegistryManager());

                this.currentRecipe = recipe;
                this.resultInventory.setLastRecipe(recipe);
                this.resultInventory.setStack(0, result);
            }

        }

        private JewelerInput getInput() {
            return new JewelerInput(this.inventory.getStack(0), this.inventory.getStack(1), player.getWorld());
        }

        public boolean canTakeOutput(PlayerEntity player, boolean present) {
            return this.currentRecipe != null && this.currentRecipe.value().matches(this.getInput(), world);
        }

        public void onTakeResultItem() {
            this.currentRecipe = null;
            this.inventory.getStack(0).decrement(1);
            this.inventory.getStack(1).decrement(1);
//            this.inventory.markDirty();
        }

        @Override
        public void onClose() {
            super.onClose();
            dropInventory();
        }

        protected void dropInventory() {
            if (!player.isAlive() || player instanceof ServerPlayerEntity && player.isDisconnected()) {
                for (int i = 0; i < inventory.size(); ++i) {
                    player.dropItem(inventory.removeStack(i), false);
                }
                return;
            }
            for (int i = 0; i < inventory.size(); ++i) {
                PlayerInventory playerInventory = player.getInventory();
                if (!(playerInventory.player instanceof ServerPlayerEntity)) continue;
                playerInventory.offerOrDrop(inventory.removeStack(i));
            }
        }

        @Override
        public ItemStack quickMove(int index) {
            if (this.getSlotRedirect(index) == this.RESULT_SLOT) {
                onTakeResultItem();
            }
            return super.quickMove(index);
        }
    }
}
