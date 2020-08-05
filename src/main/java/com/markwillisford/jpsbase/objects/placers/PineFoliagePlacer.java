package com.markwillisford.jpsbase.objects.placers;

import java.util.Random;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;

public class PineFoliagePlacer extends FoliagePlacer {
	// public static final Logger LOGGER = LogManager.getLogger();
	
	public PineFoliagePlacer(int radius, int radiusPlusRand) {
    	super(radius, radiusPlusRand, FoliagePlacerType.BLOB);
	}

	@Override
	public void func_225571_a_(IWorldGenerationReader p_225571_1_, Random p_225571_2_, TreeFeatureConfig p_225571_3_,
		int heigthOfLogs, int p_225571_5_, int p_225571_6_, BlockPos saplingLoc, Set<BlockPos> p_225571_8_) {
		
		// this stores the location of our top log
		BlockPos topLog = saplingLoc.add(0, heigthOfLogs-1, 0);
		
        for(int i = 1;i<3;i++) {
			p_225571_1_.setBlockState(topLog.add(0, i, 0), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);
		}
        // 3 x 3 cross
        for(int i = -1; i<=1;i++) {
    		p_225571_1_.setBlockState(topLog.add(i, 0, 0), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);
        }
		p_225571_1_.setBlockState(topLog.add(0, 0, 1), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);
		p_225571_1_.setBlockState(topLog.add(0, 0, -1), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);

        Random rand = new Random();
        int branchCount = 0;
		//for(int i = heigthOfLogs-1; i >= 3; i--) {
		for(int i = 3; i <= heigthOfLogs-1; i++) {
			if((heigthOfLogs-i)%2 == 0) {
				for(int x = -1; x<=1; x++) {        	
		        	for(int z = -1; z<=1; z++) {
		        		p_225571_1_.setBlockState(saplingLoc.add(x, i, z), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);  
		        	}
		        }
			} else {
	        	// cycle NE, SE, NW, SW
				int[][] directions = { // { x, z }
				    { 1, 1 },
				    { 1, -1 },
				    { -1, 1 },
				    { -1, -1 }
				};
				for(int j=0;j<directions.length;j++) {
			        if(rand.nextInt(4) == 0) { // avg once every branch levels			        	
			        	// build a small branch 
			        	int[] direction = directions[0];
			        	p_225571_1_.setBlockState(saplingLoc.add(direction[0], i, direction[1]), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);  
			        }					
				}
			}
		}            
    }
	
	@Override
	public int func_225573_a_(Random p_225573_1_, int p_225573_2_, int p_225573_3_, TreeFeatureConfig p_225573_4_) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected boolean func_225572_a_(Random p_225572_1_, int p_225572_2_, int p_225572_3_, int p_225572_4_,
			int p_225572_5_, int p_225572_6_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int func_225570_a_(int p_225570_1_, int p_225570_2_, int p_225570_3_, int p_225570_4_) {
		// TODO Auto-generated method stub
		return 0;
	}
}
