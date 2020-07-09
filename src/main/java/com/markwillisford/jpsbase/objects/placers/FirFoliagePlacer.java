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

public class FirFoliagePlacer extends FoliagePlacer {
	public static final Logger LOGGER = LogManager.getLogger();
	
	public FirFoliagePlacer(int radius, int radiusPlusRand) {
    	super(radius, radiusPlusRand, FoliagePlacerType.BLOB);
	}

	@Override
	public void func_225571_a_(IWorldGenerationReader p_225571_1_, Random p_225571_2_, TreeFeatureConfig p_225571_3_,
		int heigthOfLogs, int p_225571_5_, int p_225571_6_, BlockPos saplingLoc, Set<BlockPos> p_225571_8_) {

        LOGGER.info( "********************************************************************************" );
        LOGGER.info( "********************************************************************************" );
        LOGGER.info( "********************************************************************************" );
		for(int i = 0;i<3;i++) {
    		p_225571_1_.setBlockState(saplingLoc.add(0, heigthOfLogs+i, 0), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);
		}
        // 3 x 3 cross
        for(int i = -1; i<=1;i++) {
    		p_225571_1_.setBlockState(saplingLoc.add(i, heigthOfLogs, 0), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);
        }
		p_225571_1_.setBlockState(saplingLoc.add(0, heigthOfLogs, 1), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);
		p_225571_1_.setBlockState(saplingLoc.add(0, heigthOfLogs, -1), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);
        
        // 3 x 3 square		
        for(int i = -1; i<=1; i++) {        	
        	for(int j = -1; j<=1; j++) {
        		p_225571_1_.setBlockState(saplingLoc.add(i, heigthOfLogs-1, j), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);  
        	}
        }
        
        Random rand = new Random();
        boolean shape = rand.nextInt(3) == 0;
        for(int x = 0; x < 3; x++) {
        	// 5 x 5 diamond
	        for(int i = -2; i<=2; i++) {
	        	if(i == -2 || i == 2) {
	        		if(!shape) {
	        			for(int j = -1; j<=1; j++) {
		            		p_225571_1_.setBlockState(saplingLoc.add(i, heigthOfLogs-2-x, j), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);           	
		            	}
	        		} else {
	        			p_225571_1_.setBlockState(saplingLoc.add(i, heigthOfLogs-2-x, 0), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);           			
	    	        }	        		
	        	}
	        	if(i == -1 || i == 1) {
	        		if(!shape) {
		            	for(int j = -2; j<=2; j++) {	
		            		p_225571_1_.setBlockState(saplingLoc.add(i, heigthOfLogs-2-x, j), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);  
		            	}
	        		} else {
		            	for(int j = -1; j<=1; j++) {	
		            		p_225571_1_.setBlockState(saplingLoc.add(i, heigthOfLogs-2-x, j), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);  
		            	}
	        		}	        		        		
	        	}
	        	if(i==0) {
	            	for(int j = -2; j<=2; j++) {	
	            		p_225571_1_.setBlockState(saplingLoc.add(i, heigthOfLogs-2-x, j), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);  
	            	}  
	        	}
	        }
        }
	    
        if(heigthOfLogs >= 7) {
        	// 3 x 3 square
            for(int i = -1; i<=1; i++) {        	
            	for(int j = -1; j<=1; j++) {	
            		BlockPos pos = new BlockPos(saplingLoc.add(i, heigthOfLogs-5, j));   
            		BlockState blockstate = ((net.minecraft.world.IWorld)p_225571_1_).getWorld().getBlockState(pos);
            		//if(BlockTags.LOGS.contains(blockstate.getBlock())) {
            			LOGGER.info("Blockstate: " + blockstate);
            			LOGGER.info("Block: " + blockstate.getBlock());
            			LOGGER.info("pos: " + pos);
            		//}
            		p_225571_1_.setBlockState(saplingLoc.add(i, heigthOfLogs-5, j), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);  
            	}
            }
        }
        LOGGER.info( "********************************************************************************" );
        LOGGER.info( "********************************************************************************" );
        LOGGER.info( "********************************************************************************" );
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
