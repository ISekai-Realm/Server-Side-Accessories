package net.biryeongtrain.serversideconstruct.block;

import eu.pb4.factorytools.api.block.BarrierBasedWaterloggable;
import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.factorytools.api.block.MultiBlock;
import eu.pb4.factorytools.api.util.VirtualDestroyStage;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import eu.pb4.polymer.virtualentity.api.BlockWithElementHolder;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import eu.pb4.polymer.virtualentity.api.attachment.BlockBoundAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.biryeongtrain.serversideconstruct.registry.block.SSCBlockModelRegistry;
import net.biryeongtrain.serversideconstruct.utils.PathHelper;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import static net.minecraft.util.math.Direction.AxisDirection.POSITIVE;

public class JewelerBlock extends MultiBlock implements FactoryBlock, BlockEntityProvider, BlockWithElementHolder, VirtualDestroyStage.Marker, BarrierBasedWaterloggable {
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


    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return isCenter(state) ? new JewelerBlockEntity(pos, state) : null;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (getY(state) != 2 && !player.isSneaking() && world.getBlockEntity(getCenter(state, pos)) instanceof JewelerBlockEntity be) {
            be.createGui((ServerPlayerEntity) player);
            return ActionResult.SUCCESS;
        }

        return super.onUse(state, world, pos, player, hit);
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
