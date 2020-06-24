package com.markwillisford.jpsbase.world.feature;

import java.util.Random;

import com.google.common.collect.ImmutableList;
import com.markwillisford.jpsbase.init.BlockInitNew;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.PineFoliagePlacer;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraftforge.common.IPlantable;

public class WalnutTree extends Tree{
	   
	public static final TreeFeatureConfig WALNUT_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInitNew.WALNUT_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(BlockInitNew.WALNUT_LEAVES.get().getDefaultState()), 
			new BlobFoliagePlacer(1, 0)))				// leaf radius, 
			.baseHeight(5)			// func_225569_d_	// baseHeight
			.heightRandA(2)			// func_227354_b_	// heightRandA
			.foliageHeight(10)		// func_227360_i_	// foliageHeight
			.ignoreVines()			// func_227352_a_	// ignoreVines
			.setSapling((IPlantable)BlockInitNew.WALNUT_SAPLING.get()).build();		// func_225568_b_	// build
	
	public static final TreeFeatureConfig WALNUT_TREE_CONFIG2 = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInitNew.WALNUT_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(BlockInitNew.WALNUT_LEAVES.get().getDefaultState()), 
			// new AcaciaFoliagePlacer(2, 0)))
			new BlobFoliagePlacer(0, 0)))
			.baseHeight(5)
			.heightRandA(2)
			//.foliageHeight(3)
			//.decorators(ImmutableList.of( 
					// new LeaveVineTreeDecorator()))
			.trunkHeight(0)//.trunkHeightRandom(0).trunkTopOffsetRandom(0)
			.ignoreVines()
			.setSapling((IPlantable)BlockInitNew.WALNUT_SAPLING.get()).build();
	
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.ACACIA_TREE.withConfiguration(WALNUT_TREE_CONFIG); 
		
	//@Override
	//protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		// return Feature.FANCY_TREE.withConfiguration(WALNUT_TREE_CONFIG);					// NORMAL_TREE
		// return Feature.NORMAL_TREE.withConfiguration(SPRUCE_TREE_CONFIG); 
		// return Feature.ACACIA_TREE.withConfiguration(SPRUCE_TREE_CONFIG);
		/*return randomIn.nextInt(10) == 0 
				? Feature.NORMAL_TREE.withConfiguration(
						b ? PINE_TREE_CONFIG : PINE_TREE_CONFIG
				) : Feature.NORMAL_TREE.withConfiguration(
						b ? WALNUT_TREE_CONFIG : WALNUT_TREE_CONFIG);*/
	
	
	 }
}