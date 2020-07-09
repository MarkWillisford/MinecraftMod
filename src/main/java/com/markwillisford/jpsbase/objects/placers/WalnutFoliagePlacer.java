package com.markwillisford.jpsbase.objects.placers;

import java.util.Random;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;

public class WalnutFoliagePlacer extends FoliagePlacer {
	public static final Logger LOGGER = LogManager.getLogger();

	public WalnutFoliagePlacer(int radius, int radiusPlusRand) {
    	super(radius, radiusPlusRand, FoliagePlacerType.BLOB);
	}

	@Override
	public void func_225571_a_(IWorldGenerationReader p_225571_1_, Random p_225571_2_, TreeFeatureConfig p_225571_3_,
			int heigthOfLogs, int p_225571_5_, int p_225571_6_, BlockPos saplingLoc, Set<BlockPos> p_225571_8_) {

        LOGGER.info( "********************************************************************************" );
        LOGGER.info( "********************************************************************************" );
        LOGGER.info( "********************************************************************************" );
        LOGGER.info( "********************************************************************************" );
        LOGGER.info( "********************************************************************************" );
        LOGGER.info( "********************************************************************************" );
		LOGGER.info("TreeFeatureConfig p_225571_3_: " + p_225571_3_);
		LOGGER.info("int p_225571_4_: " + heigthOfLogs);				// heigth of logs
		LOGGER.info("int p_225571_5_: " + p_225571_5_);				// heigth of logs - foliageHeight + trunkHeight +1
		LOGGER.info("int p_225571_6_: " + p_225571_6_);				// 
		LOGGER.info("BlockPos p_225571_7_: " + saplingLoc);		// pos of sapling
		LOGGER.info("Set<BlockPos> p_225571_8_: " + p_225571_8_);	// array?
		LOGGER.info("Test Data " + p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc));	
        LOGGER.info( "********************************************************************************" );
        LOGGER.info( "********************************************************************************" );
        LOGGER.info( "********************************************************************************" );
        LOGGER.info( "********************************************************************************" );
        LOGGER.info( "********************************************************************************" );
        LOGGER.info( "********************************************************************************" );
			
        	
        	//p_225571_1_.setBlockState(saplingLoc.add(0, heigthOfLogs+1, 0), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);
        	//p_225571_1_.setBlockState(saplingLoc.add(0, heigthOfLogs+2, 0), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);

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
        
        for(int x = 0; x < 3; x++) {
        	// 5 x 5 cut corners
	        for(int i = -2; i<=2; i++) {
	        	if(i == -2 || i == 2) {
	            	for(int j = -1; j<=1; j++) {
	            		p_225571_1_.setBlockState(saplingLoc.add(i, heigthOfLogs-2-x, j), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);           	
	            	}        		
	        	}
	        	if(i == -1 || i == 1) {
	            	for(int j = -2; j<=2; j++) {	
	            		p_225571_1_.setBlockState(saplingLoc.add(i, heigthOfLogs-2-x, j), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);  
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
            		p_225571_1_.setBlockState(saplingLoc.add(i, heigthOfLogs-5, j), p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc), 2);  
            	}
            }
        }
        
        
		//for(int i = heigthOfLogs; i >= p_225571_5_; --i) {
			// 
			/*
			int j = Math.max(p_225571_6_ - 1 - (i - heigthOfLogs) / 2, 0);
			this.func_227384_a_(p_225571_1_, p_225571_2_, p_225571_3_, heigthOfLogs, saplingLoc, i, j, p_225571_8_);
			*/
		//}		
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
	
	/*@Override
	public void func_225571_a_(IWorldGenerationReader p_225571_1_, Random p_225571_2_, TreeFeatureConfig p_225571_3_, int p_225571_4_, int p_225571_5_, int p_225571_6_, BlockPos p_225571_7_, Set<BlockPos> p_225571_8_) {
		for(int i = p_225571_4_; i >= p_225571_5_; --i) {
			int j = Math.max(p_225571_6_ - 1 - (i - p_225571_4_) / 2, 0);
			this.func_227384_a_(p_225571_1_, p_225571_2_, p_225571_3_, p_225571_4_, p_225571_7_, i, j, p_225571_8_);
		}
	}

	@Override
	public int func_225573_a_(Random p_225573_1_, int p_225573_2_, int p_225573_3_, TreeFeatureConfig p_225573_4_) {
		return this.field_227381_a_ + p_225573_1_.nextInt(this.field_227382_b_ + 1);
	}

	@Override
	protected boolean func_225572_a_(Random p_225572_1_, int p_225572_2_, int p_225572_3_, int p_225572_4_, int p_225572_5_, int p_225572_6_) {
    	return Math.abs(p_225572_3_) == p_225572_6_ && Math.abs(p_225572_5_) == p_225572_6_ && (p_225572_1_.nextInt(2) == 0 || p_225572_4_ == p_225572_2_);
	}

	@Override
	public int func_225570_a_(int p_225570_1_, int p_225570_2_, int p_225570_3_, int p_225570_4_) {
		return p_225570_4_ == 0 ? 0 : 1;
	}*/

}
