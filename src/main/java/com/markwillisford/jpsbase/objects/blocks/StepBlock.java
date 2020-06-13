package com.markwillisford.jpsbase.objects.blocks;

import com.markwillisford.jpsbase.JPsBase;
import com.markwillisford.jpsbase.objects.enums.StepOrientation;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class StepBlock extends Block{	
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final EnumProperty<StepOrientation> ORIENTATION = EnumProperty.create("orientation", StepOrientation.class);

	private static final VoxelShape SHAPE_BN = Block.makeCuboidShape(0, 0, 0, 16, 8, 8);	
	private static final VoxelShape SHAPE_BE = Block.makeCuboidShape(8, 0, 0, 16, 8, 16);
	private static final VoxelShape SHAPE_BS = Block.makeCuboidShape(0, 0, 8, 16, 8, 16);
	private static final VoxelShape SHAPE_BW = Block.makeCuboidShape(0, 0, 0, 8, 8, 16);
	private static final VoxelShape SHAPE_TN = Block.makeCuboidShape(0, 8, 0, 16, 16, 8);	
	private static final VoxelShape SHAPE_TE = Block.makeCuboidShape(8, 8, 0, 16, 16, 16);
	private static final VoxelShape SHAPE_TS = Block.makeCuboidShape(0, 8, 8, 16, 16, 16);
	private static final VoxelShape SHAPE_TW = Block.makeCuboidShape(0, 8, 0, 8, 16, 16);
	private static final VoxelShape SHAPE_NE = Block.makeCuboidShape(8, 0, 0, 16, 16, 8);	
	private static final VoxelShape SHAPE_NW = Block.makeCuboidShape(0, 0, 0, 8, 16, 8);
	private static final VoxelShape SHAPE_SE = Block.makeCuboidShape(8, 0, 8, 16, 16, 16);
	private static final VoxelShape SHAPE_SW = Block.makeCuboidShape(0, 0, 8, 8, 16, 16);
	
	public StepBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(ORIENTATION)) {
		case BN:
			return SHAPE_BN;
		case BE:
			return SHAPE_BE;
		case BS:
			return SHAPE_BS;
		case BW:
			return SHAPE_BW;
		case TN:
			return SHAPE_TN;
		case TE:
			return SHAPE_TE;
		case TS:
			return SHAPE_TS;
		case TW:
			return SHAPE_TW;
		case NE:
			return SHAPE_NE;
		case NW:
			return SHAPE_NW;
		case SE:
			return SHAPE_SE;
		case SW:
			return SHAPE_SW;
		default:
			return SHAPE_BN;
		}
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
	    Direction direction = context.getFace();
	    BlockPos blockpos = context.getPos();
	    BlockState blockstate = this.getDefaultState();
	    // IFluidState ifluidstate = context.getWorld().getFluidState(blockpos);
	    // BlockState blockstate = this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing());
	    // return blockstate.with(SHAPE, blockpos);

	    double x = context.getHitVec().x - (double)blockpos.getX();
	    double y = context.getHitVec().y - (double)blockpos.getY();
	    double z = context.getHitVec().z - (double)blockpos.getZ();
	    int cell = 0;
    	JPsBase.LOGGER.info("******************************************************************");
	    if(direction == Direction.WEST || direction == Direction.EAST) {
	    	cell = whichCell(y, z);
	    } else if (direction == Direction.NORTH || direction == Direction.SOUTH) {
	    	cell = whichCell(y, x);
	    } else if (direction == Direction.UP || direction == Direction.DOWN) {
	    	cell = whichCell(x, z);
	    }
	    
	    switch(cell) {
	    case 1:
		    if(direction == Direction.WEST || direction == Direction.EAST) {
		    	JPsBase.LOGGER.info("Top, North");
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.TN);
		    	// up north
		    } else if (direction == Direction.NORTH || direction == Direction.SOUTH) {
		    	JPsBase.LOGGER.info("Top, West");
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.TW);
		    	
		    } else if (direction == Direction.UP || direction == Direction.DOWN) {
		    	JPsBase.LOGGER.info("North East");
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.NE);
		    }
		    break;
	    case 2:
		    if(direction == Direction.WEST) {
		    	JPsBase.LOGGER.info("2-west");
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.TE);
		    	// up
		    } else if (direction == Direction.EAST) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.TW);
		    	JPsBase.LOGGER.info("2-east");
		    	
		    } else if (direction == Direction.NORTH) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.TS);
		    	JPsBase.LOGGER.info("2-north");
		    	
		    } else if (direction == Direction.SOUTH) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.TN);
		    	JPsBase.LOGGER.info("2-south");
		    	
		    } else if (direction == Direction.UP) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.BE);
		    	JPsBase.LOGGER.info("2-UP");
		    } else if (direction == Direction.DOWN) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.TE);
		    	JPsBase.LOGGER.info("2-Down");
		    }
		    break;
	    case 3:
		    if(direction == Direction.WEST || direction == Direction.EAST) {
		    	JPsBase.LOGGER.info("Top South");
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.TS);
		    	// up south
		    } else if (direction == Direction.NORTH || direction == Direction.SOUTH) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.TE);
		    	JPsBase.LOGGER.info("Top East");
		    	
		    } else if (direction == Direction.UP || direction == Direction.DOWN) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.SE);
		    	JPsBase.LOGGER.info("South East");
		    }
		    break;
	    case 4:
	    	if(direction == Direction.WEST) {
		    	JPsBase.LOGGER.info("4-west");
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.NE);
		    	
		    } else if (direction == Direction.EAST) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.NW);
		    	JPsBase.LOGGER.info("4-east");
		    	
		    } else if (direction == Direction.NORTH) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.SW);
		    	JPsBase.LOGGER.info("4-north");
		    	
		    } else if (direction == Direction.SOUTH) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.NW);
		    	JPsBase.LOGGER.info("4-south");
		    	
		    } else if (direction == Direction.UP) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.BN);
		    	JPsBase.LOGGER.info("4-UP");
		    } else if (direction == Direction.DOWN) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.TN);
		    	JPsBase.LOGGER.info("4-Down");
		    }
		    break;    	
	    case 5:
	    	JPsBase.LOGGER.info("MIDDLE !!!!!");
	    case 6:
	    	if(direction == Direction.WEST) {
		    	JPsBase.LOGGER.info("6-west");
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.SE);
		    	// up
		    } else if (direction == Direction.EAST) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.SW);
		    	JPsBase.LOGGER.info("6-east");
		    	
		    } else if (direction == Direction.NORTH) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.SE);
		    	JPsBase.LOGGER.info("6-north");
		    	
		    } else if (direction == Direction.SOUTH) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.NE);
		    	JPsBase.LOGGER.info("6-south");
		    	
		    } else if (direction == Direction.UP) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.BS);
		    	JPsBase.LOGGER.info("6-UP");
		    } else if (direction == Direction.DOWN) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.TS);
		    	JPsBase.LOGGER.info("6-Down");
		    }
		    break;
	    case 7:
		    if(direction == Direction.WEST || direction == Direction.EAST) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.BN);
		    	JPsBase.LOGGER.info("North Bottom");
		    	// north down
		    } else if (direction == Direction.NORTH || direction == Direction.SOUTH) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.BW);
		    	JPsBase.LOGGER.info("West Bottom");
		    	
		    } else if (direction == Direction.UP || direction == Direction.DOWN) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.NW);
		    	JPsBase.LOGGER.info("North West");
		    }
		    break;
	    case 8:
	    	if(direction == Direction.WEST) {
		    	JPsBase.LOGGER.info("8-west");
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.BE);
		    	// up
		    } else if (direction == Direction.EAST) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.BW);
		    	JPsBase.LOGGER.info("8-east");
		    	
		    } else if (direction == Direction.NORTH) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.BS);
		    	JPsBase.LOGGER.info("8-north");
		    	
		    } else if (direction == Direction.SOUTH) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.BN);
		    	JPsBase.LOGGER.info("8-south");
		    	
		    } else if (direction == Direction.UP) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.BW);
		    	JPsBase.LOGGER.info("8-UP");
		    } else if (direction == Direction.DOWN) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.TW);
		    	JPsBase.LOGGER.info("8-Down");
		    }
		    break;
	    case 9:
		    if(direction == Direction.WEST || direction == Direction.EAST) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.BS);
		    	JPsBase.LOGGER.info("Bottom South");
		    	// down south
		    } else if (direction == Direction.NORTH || direction == Direction.SOUTH) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.BE);
		    	JPsBase.LOGGER.info("Bottom East");
		    	
		    } else if (direction == Direction.UP || direction == Direction.DOWN) {
		    	blockstate = this.getDefaultState().with(ORIENTATION, StepOrientation.SW);
		    	JPsBase.LOGGER.info("South West");
		    }
		    break;
    	default:
    		;
	    }
    	JPsBase.LOGGER.info("******************************************************************");
    	
    	return blockstate;
	    // return this.stateContainer.getBaseState().with(FACING, Direction.NORTH);
		// return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
	
	private int whichCell(double a, double b) {
		// top three cells
		if(a >= .66 && b <= .33) {
			return 1;
		} else if(a >= .66 && b <= .66) {
			return 2;
		} else if(a >= .66) {
			return 3;
		} else if(a >= .33 && b <= .33) {
			return 4;
		} else if(a >= .33 && b <= .66) {
			return 5;
		} else if(a >= .33) {
			return 6;
		} else if(b <= .33) {
			return 7;
		} else if(b <= .66) {
			return 8;
		} else {
			return 9;
		} 
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}
	
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(FACING);
		builder.add(ORIENTATION);
	}
	/*

	
	// public static final EnumProperty<Half> HALF = BlockStateProperties.HALF;
	// public static final EnumProperty<StairsShape> SHAPE = BlockStateProperties.STAIRS_SHAPE;
	// private final Block modelBlock;
	// private final BlockState modelState;
	// private final java.util.function.Supplier<BlockState> stateSupplier;
	   
	public StepBlock(java.util.function.Supplier<BlockState> state, Block.Properties properties) {
		//super(properties);
	    //this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	    //this.modelBlock = Blocks.AIR; // These are unused, fields are redirected
	    //this.modelState = Blocks.AIR.getDefaultState();
	    
		super(properties);
	    //this.stateSupplier = state;
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));		
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(FACING)) {
		case NORTH:
			return SHAPE_BN;
		case EAST:
			return SHAPE_BE;
		case SOUTH:
			return SHAPE_BS;
		case WEST:
			return SHAPE_BW;
		default:
			return SHAPE_BN;
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
	
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
	*/
	
}
