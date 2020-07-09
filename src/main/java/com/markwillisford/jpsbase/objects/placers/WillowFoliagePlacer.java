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

public class WillowFoliagePlacer extends FoliagePlacer {
	public static final Logger LOGGER = LogManager.getLogger();
	
	public WillowFoliagePlacer(int radius, int radiusPlusRand) {
    	super(radius, radiusPlusRand, FoliagePlacerType.BLOB);
	}

	@Override
	public void func_225571_a_(IWorldGenerationReader p_225571_1_, Random p_225571_2_, TreeFeatureConfig p_225571_3_,
		int heigthOfLogs, int p_225571_5_, int p_225571_6_, BlockPos saplingLoc, Set<BlockPos> p_225571_8_) {

        LOGGER.info( "********************************************************************************" );
        LOGGER.info( "********************************************************************************" );
        LOGGER.info( "********************************************************************************" );
        
    	// 5 x 5 without corners
        for(int i = -2; i<=2; i++) {
        	if(i == -2 || i == 2) {
        		threeLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs, i);
        	}
        	if(i >= -1 && i <= 1) {
        		fiveLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs, i);
        	}
        }
        // 7 x 7 without extended corners
        for(int i = -3; i<=3;i++) {
        	if(i == -3 || i == 3) {
        		threeLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs-1, i);        		
        	} else if(i == -2 || i == 2) {
        		fiveLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs-1, i);
        	} else {
        		sevenLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs-1, i);
        	}        	
        }
        // the droop
        for(int i=-4; i<=4;i++) {
        	if(i==-4 || i==4) {
        		threeLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs-2, i);
        	} else if (i == -3 || i == 3) {
        		fiveLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs-2, i);
        	} else if(i == -2 || i == 2) {
        		sevenLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs-2, i);
        	} else {
        		// 3 x 3 off centered by +3 and -3
                for(int x = -1; x<=1; x++) {
                	for(int z = -1; z<=1; z++) {
                		p_225571_1_.setBlockState(saplingLoc.add(x, heigthOfLogs-2, z-3), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);  
                		p_225571_1_.setBlockState(saplingLoc.add(x, heigthOfLogs-2, z+3), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);  
                    }
                }
        	}
        }
        // now the hanging branches // heigthOfLogs-3
        // out 4 left 1
        int[][] arr = { {-4, 1},{-4, -1},{4, 1},{4, -1},
        				{-1, 4},{-1, -4},{1, 4},{1, -4} };
        int[][] arrRand = { {-3, 2},{-3, -2},{3, 2},{3, -2},
							{-2, 3},{-2, -3},{2, 3},{2, -3} };
        for(int i=0;i<arr.length;i++) {
            p_225571_1_.setBlockState(saplingLoc.add(arr[i][0], heigthOfLogs-3, arr[i][1]), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);  
        }
        for(int i=0;i<arrRand.length;i++) {
            if(Math.random() > 0.5) {
            	p_225571_1_.setBlockState(saplingLoc.add(arr[i][0], heigthOfLogs-3, arr[i][1]), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);  
            }
        }
        
	}
	
	private void threeLong(IWorldGenerationReader p_225571_1_, Random p_225571_2_, TreeFeatureConfig p_225571_3_, 
			BlockPos saplingLoc, int heigthOfLogs, int x) {
		for(int z = -1; z<=1; z++) {
    		p_225571_1_.setBlockState(saplingLoc.add(x, heigthOfLogs, z), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);           	
    	}
	}
	
	private void fiveLong(IWorldGenerationReader p_225571_1_, Random p_225571_2_, TreeFeatureConfig p_225571_3_, 
			BlockPos saplingLoc, int heigthOfLogs, int x) {
		for(int z = -2; z<=2; z++) {
    		p_225571_1_.setBlockState(saplingLoc.add(x, heigthOfLogs, z), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);           	
    	}
	}
	
	private void sevenLong(IWorldGenerationReader p_225571_1_, Random p_225571_2_, TreeFeatureConfig p_225571_3_, 
			BlockPos saplingLoc, int heigthOfLogs, int x) {
		for(int z = -3; z<=3; z++) {
    		p_225571_1_.setBlockState(saplingLoc.add(x, heigthOfLogs, z), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);           	
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
