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

public class MahoganyFoliagePlacer extends FoliagePlacer {
	public static final Logger LOGGER = LogManager.getLogger();
	
	public MahoganyFoliagePlacer(int radius, int radiusPlusRand) {
    	super(radius, radiusPlusRand, FoliagePlacerType.BLOB);
	}

	@Override
	public void func_225571_a_(IWorldGenerationReader p_225571_1_, Random p_225571_2_, TreeFeatureConfig p_225571_3_,
		int heigthOfLogs, int p_225571_5_, int p_225571_6_, BlockPos saplingLoc, Set<BlockPos> p_225571_8_) {

		// 7 by 7 diamond
        for(int i = -4; i<=4;i++) {
        	if(i == -4 || i == 4) {
        		p_225571_1_.setBlockState(saplingLoc.add(i, heigthOfLogs+2, 0), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2); 
        	}
        	else if(i == -3 || i == 3) {
        		threeLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs+2, i);        		
        	} else if(i == -2 || i == 2) {
        		fiveLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs+2, i);
        	} else if(i == -1 || i == 1) {
        		sevenLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs+2, i);
        	} else {     
        		nineLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs+2, i);
        	}
        }

    	// 5 x 5 diamond
        for(int i = -2; i<=2; i++) {
        	if(i == -2 || i == 2) {
        		p_225571_1_.setBlockState(saplingLoc.add(i, heigthOfLogs+3, 0), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);           			
        	}
        	if(i == -1 || i == 1) {
            	for(int j = -1; j<=1; j++) {	
            		p_225571_1_.setBlockState(saplingLoc.add(i, heigthOfLogs+3, j), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);  
            	}       		        		
        	}
        	if(i==0) {
            	for(int j = -2; j<=2; j++) {	
            		p_225571_1_.setBlockState(saplingLoc.add(i, heigthOfLogs+3, j), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);  
            	}  
        	}
        }
        
        // heigthOfLogs+1
        // 11 x 11 diamond (3 long end, outer boundry)
        for(int i=-5;i<=5;i++) {
        	if(i == -5 || i == 5) {
        		threeLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs+1, i);  
        	}
        	if(i == -4 || i == 4) {
        		fiveLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs+1, i);  
        	}
        	if(i == -3 || i == 3) {
        		// first two and last two
        		placementOnEnds(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs+1, i, 2, 7);
        	}
        	if(i == -2 || i == 2) {
        		placementOnEnds(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs+1, i, 2, 9);
        	}
        	if(i >= -1 && i <= 1) {
        		placementOnEnds(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs+1, i, 2, 11);
        	}
        }
        // heigthOfLogs
        // 11 x 11 diamond (3 long end, outer boundry)
        for(int i=-5;i<=5;i++) {
        	if(i == -5 || i == 5) {
        		threeLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs, i);  
        	}
        	if(i == -4 || i == 4) {
        		fiveLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs, i);  
        	}
        	if(i == -3 || i == 3) {
        		sevenLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs, i);  
        	}
        	if(i == -2 || i == 2) {
        		placementOnEnds(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs, i, 2, 9);
        	}
        	if(i >= -1 && i <= 1) {
        		placementOnEnds(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs, i, 3, 11);
        	}
        }
        // heigthOfLogs -1
        // 3 long ends droop down further
        for(int i=-5;i<=5;i++) {
        	if(i == -5 || i == 5) {
        		threeLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs-1, i);  
        	}
        	if(i >= -1 && i <= 1) {
        		placementOnEnds(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs-1, i, 1, 11);
        	}
        }
	}
	
	private void placementOnEnds(IWorldGenerationReader p_225571_1_, Random p_225571_2_, TreeFeatureConfig p_225571_3_, 
			BlockPos saplingLoc, int heigthOfLogs, int x, int endThinkness, int length) {
	    int half = (int) length/2;
	    int[] z = new int[length];
	      
	    for(int i = 0;i<half;i++){
	        z[i] = -(half - i);
	        z[z.length - 1 - i] = half - i;
	    }
        
		for(int i=0;i<z.length;i++) {
			if(i<endThinkness || i >= (length - endThinkness) ) {
				p_225571_1_.setBlockState(saplingLoc.add(x, heigthOfLogs, z[i]), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);           	
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

	private void nineLong(IWorldGenerationReader p_225571_1_, Random p_225571_2_, TreeFeatureConfig p_225571_3_, 
			BlockPos saplingLoc, int heigthOfLogs, int x) {
		for(int z = -4; z<=4; z++) {
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
