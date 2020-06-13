package com.markwillisford.jpsbase.objects.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class SpecalBlock extends Block{

	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	
	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(7, 0, 0, 9, 2, 15),
			Block.makeCuboidShape(5, 0, 1, 7, 3, 3),
			Block.makeCuboidShape(3, 0, 3, 5, 3, 5),
			Block.makeCuboidShape(1, 0, 5, 3, 3, 7),
			Block.makeCuboidShape(9, 0, 1, 11, 3, 3),
			Block.makeCuboidShape(11, 0, 3, 13, 3, 5),
			Block.makeCuboidShape(13, 0, 5, 15, 3, 7)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(0, 0, 7, 15, 2, 9),
			Block.makeCuboidShape(1, 0, 9, 3, 3, 11),
			Block.makeCuboidShape(3, 0, 11, 5, 3, 13),
			Block.makeCuboidShape(5, 0, 13, 7, 3, 15),
			Block.makeCuboidShape(1, 0, 5, 3, 3, 7),
			Block.makeCuboidShape(3, 0, 3, 5, 3, 5),
			Block.makeCuboidShape(5, 0, 1, 7, 3, 3)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(1, 0, 7, 16, 2, 9),
			Block.makeCuboidShape(13, 0, 5, 15, 3, 7),
			Block.makeCuboidShape(11, 0, 3, 13, 3, 5),
			Block.makeCuboidShape(9, 0, 1, 11, 3, 3),
			Block.makeCuboidShape(13, 0, 9, 15, 3, 11),
			Block.makeCuboidShape(11, 0, 11, 13, 3, 13),
			Block.makeCuboidShape(9, 0, 13, 11, 3, 15)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(7, 0, 1, 9, 2, 16),
			Block.makeCuboidShape(9, 0, 13, 11, 3, 15),
			Block.makeCuboidShape(11, 0, 11, 13, 3, 13),
			Block.makeCuboidShape(13, 0, 9, 15, 3, 11),
			Block.makeCuboidShape(5, 0, 13, 7, 3, 15),
			Block.makeCuboidShape(3, 0, 11, 5, 3, 13),
			Block.makeCuboidShape(1, 0, 9, 3, 3, 11)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	
	public SpecalBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch(state.get(FACING)) {
		case NORTH:
			return SHAPE_N;
		case EAST:
			return SHAPE_E;
		case SOUTH:
			return SHAPE_S;
		case WEST:
			return SHAPE_W;
		default:
			return SHAPE_N;			
		}
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return super.rotate(state, mirrorIn.toRotation(state.get(FACING)));
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
	
	public ActionResultType func_225533_a_(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult p_225533_6_) {
		// checking for client
		if(!worldIn.isRemote()) {	
			ServerWorld serverWorld = (ServerWorld)worldIn;
			LightningBoltEntity entity = new LightningBoltEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), false);
			serverWorld.addLightningBolt(entity);
		}
		return ActionResultType.SUCCESS;
	}
}
