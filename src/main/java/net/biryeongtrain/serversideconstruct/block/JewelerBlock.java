package net.biryeongtrain.serversideconstruct.block;

import eu.pb4.factorytools.api.block.BarrierBasedWaterloggable;
import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.factorytools.api.block.MultiBlock;
import eu.pb4.factorytools.api.util.VirtualDestroyStage;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.BlockWithElementHolder;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import eu.pb4.polymer.virtualentity.api.attachment.BlockBoundAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import eu.pb4.sgui.api.gui.SimpleGui;
import net.biryeongtrain.serversideconstruct.block.slot.PredicateWhitelistedSlot;
import net.biryeongtrain.serversideconstruct.block.slot.TagWhitelistedSlot;
import net.biryeongtrain.serversideconstruct.recipe.JewelerRecipe;
import net.biryeongtrain.serversideconstruct.recipe.input.JewelerInput;
import net.biryeongtrain.serversideconstruct.registry.SSCRecipeTypes;
import net.biryeongtrain.serversideconstruct.registry.block.SSCBlockModelRegistry;
import net.biryeongtrain.serversideconstruct.registry.item.SSCItemTags;
import net.biryeongtrain.serversideconstruct.ui.GuiTextures;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.FurnaceOutputSlot;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

public class JewelerBlock extends MultiBlock implements FactoryBlock, BlockWithElementHolder, VirtualDestroyStage.Marker, BarrierBasedWaterloggable {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public JewelerBlock(Settings settings) {
        super(2, 1, 2, settings);
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH).with(WATERLOGGED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING).add(WATERLOGGED);
        super.appendProperties(builder);

    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (isCenter(state) && !newState.isOf(state.getBlock())) {
            var be = world.getBlockEntity(pos);
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return Blocks.BARRIER.getDefaultState();
    }

    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, ServerPlayerEntity player) {
        return Blocks.DEEPSLATE_BRICKS.getDefaultState();
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        tickWater(state, world, pos);
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected int getMaxX(BlockState state) {
        return state.get(FACING).getAxis() == Direction.Axis.X ? 0 : 1;
    }

    @Override
    protected int getMaxZ(BlockState state) {
        return state.get(FACING).getAxis() == Direction.Axis.Z ? 0 : 1;
    }


    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return isCenter(initialBlockState) ? new Model(initialBlockState) : null;
    }
    

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (getY(state) != 2 && !player.isSneaking()) {
            var gui = new Gui((ServerPlayerEntity) player);
            return ActionResult.SUCCESS;
        }

        return super.onUse(state, world, pos, player, hit);
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
            this.setTitle(GuiTextures.JEWELER.apply(Text.empty()));
            this.setSlotRedirect(9 + 1, BASE_SLOT);
            this.setSlotRedirect(9 + 4, GEM_SLOT);
            this.setSlotRedirect(9 + 7, RESULT_SLOT);
            this.open();

        }

        public void onChanged() {
            var input = getInput();
            var recipes = player.getWorld().getRecipeManager().getAllMatches(SSCRecipeTypes.JEWELER, input, player.getWorld());
            if (recipes.isEmpty()) {
                RESULT_SLOT.setStack(ItemStack.EMPTY);
            } else {
                RecipeEntry<JewelerRecipe> recipe = recipes.getFirst();
                ItemStack result = recipe.value().craft(input, player.getWorld().getRegistryManager());

                this.currentRecipe = recipe;
                this.resultInventory.setLastRecipe(recipe);
                this.resultInventory.setStack(0, result);
            }

        }

        private JewelerInput getInput() {
            return new JewelerInput(this.inventory.getStack(0), this.inventory.getStack(1), player.getWorld());
        }

        public boolean canTakeOutput(PlayerEntity player, boolean present) {
            return this.currentRecipe != null && this.currentRecipe.value().matches(this.getInput(), player.getWorld());
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


    public final class Model extends BlockModel {

        private final ItemDisplayElement display;

        public Model(BlockState state) {
            this.display = ItemDisplayElementUtil.createSimple(SSCBlockModelRegistry.JEWELER_MODEL.asStack());

            var facing = state.get(FACING);

            this.display.setScale(new Vector3f(1.05f));
            this.display.setDisplayWidth(3);

            this.updateStatePos(state);
            this.addElement(display);
        }

        private void updateStatePos(BlockState state) {
            var direction = state.get(FACING);
            var rot = direction.asRotation();
            if (direction == Direction.NORTH) {
                this.display.setOffset(new Vec3d(1, 0, 0));
            }
            if (direction == Direction.EAST) {
                this.display.setOffset(new Vec3d(0, 0, 1));
            }
            this.display.setYaw(rot);

        }

        @Override
        public void notifyUpdate(HolderAttachment.UpdateType updateType) {
            if (updateType == BlockBoundAttachment.BLOCK_STATE_UPDATE) {
                updateStatePos(this.blockState());
            }
        }
    }
}
