package net.biryeongtrain.serversideconstruct.block;

import eu.pb4.factorytools.api.block.BarrierBasedWaterloggable;
import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.factorytools.api.block.MultiBlock;
import eu.pb4.factorytools.api.util.VirtualDestroyStage;
import eu.pb4.polymer.virtualentity.api.BlockWithElementHolder;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemPlacementContext;
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
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

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
        return isCenter(initialBlockState) ? new Model() : null;
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



    public final class Model extends ElementHolder {
        public Model() {
            super();
        }
    }
}
