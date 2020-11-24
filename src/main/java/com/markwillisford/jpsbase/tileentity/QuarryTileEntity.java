package com.markwillisford.jpsbase.tileentity;

import javax.annotation.Nullable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.markwillisford.jpsbase.init.ModTileEntityTypes;
import com.markwillisford.jpsbase.util.helpers.NBTHelper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

public class QuarryTileEntity extends TileEntity implements ITickableTileEntity{
    public static final Logger LOGGER = LogManager.getLogger();

	public int x, y, z, tick;
	boolean initialized = false;
	
	public QuarryTileEntity(final TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}
	
	public QuarryTileEntity() {
		this(ModTileEntityTypes.QUARRY.get());
	}
	
	@Override
	public void tick() {
		if(!initialized) init();
		tick++;
        LOGGER.info("TICKING");
        LOGGER.info("tick: " + tick);
		if(tick == 40) {
			tick = 0;
			if(y >2) execute();
		}		
	}

	private void init() {
		initialized = true;
		x = this.pos.getX() - 1;
		y = this.pos.getY() - 1;
		z = this.pos.getZ() - 1;
		tick = 0;
	}

	private void execute() {
        LOGGER.info("HELLO FROM EXECUTE");
		int index = 0;
		Block[] blocksRemoved = new Block[9];	// 3 x 3 quarry
		for(int x = 0; x<3; x++) {
			for(int z = 0; z<3; z++) {
				BlockPos posToBreak = new BlockPos(this.x + x, this.y, this.z + z);
				blocksRemoved[index] = this.world.getBlockState(posToBreak).getBlock();
				destroyBlock(posToBreak, true, null);
				index++;
			}
		}
		this.y--;
	}

	private boolean destroyBlock(BlockPos pos, boolean dropBlock, @Nullable Entity entity) {
		BlockState blockstate = world.getBlockState(pos);
		if(blockstate.isAir(world, pos)) return false;
		else {
			IFluidState ifluidstate = world.getFluidState(pos);
			world.playEvent(2001, pos, Block.getStateId(blockstate));	// 2001 is play sound of block being borken
			if(dropBlock) {
				TileEntity tileentity = blockstate.hasTileEntity() ? world.getTileEntity(pos) : null;
				Block.spawnDrops(blockstate, world, this.pos.add(0,1.5,0), tileentity, entity, ItemStack.EMPTY);
			}
			return world.setBlockState(pos, ifluidstate.getBlockState(), 3);	// 3 is update fluids maybe?
		}
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
		compound.put("initvalues", NBTHelper.toNBT(this));
		return super.write(compound);
	}
	
	@Override
	public void read(CompoundNBT compound) {		
		super.read(compound);
		CompoundNBT initValues = compound.getCompound("initvalues");
		if(initValues != null) {
			this.x = initValues.getInt("x");
			this.y = initValues.getInt("y");
			this.z = initValues.getInt("z");
			this.tick = 0;
			initialized = true;
			return;
		}
		init();
	}
}
