package com.markwillisford.jpsbase.world.feature;

import java.util.Random;

import com.markwillisford.jpsbase.init.BlockInitNew;

import net.minecraft.block.trees.SpruceTree;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;
/*
public class WalnutTree extends Tree{
	
	public static final TreeFeatureConfig WALNUT_TREE_CONFIG2 = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInitNew.WALNUT_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(BlockInitNew.WALNUT_LEAVES.get().getDefaultState()), 
			new WalnutFoliagePlacer(2, 0)))
			.baseHeight(5)
			.heightRandA(2)
			.foliageHeight(0)
			//.decorators(ImmutableList.of( 
					// new LeaveVineTreeDecorator()))
			//.trunkHeight(1)//.trunkHeightRandom(0).trunkTopOffsetRandom(0)
			.ignoreVines()
			.setSapling((IPlantable)BlockInitNew.WALNUT_SAPLING.get()).build();
	   
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(WALNUT_TREE_CONFIG2);
	//@Override
	// protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		// return Feature.FANCY_TREE.withConfiguration(WALNUT_TREE_CONFIG);					// NORMAL_TREE
		// return Feature.NORMAL_TREE.withConfiguration(SPRUCE_TREE_CONFIG); 
		// return Feature.ACACIA_TREE.withConfiguration(SPRUCE_TREE_CONFIG);
		// return randomIn.nextInt(10) == 0 	// between 0 inclusive and 10 exclusive
		//		? Feature.NORMAL_TREE.withConfiguration(
		//				b ? WALNUT_TREE_CONFIG : WALNUT_TREE_CONFIG
		//		) : Feature.NORMAL_TREE.withConfiguration(
		//				b ? WALNUT_TREE_CONFIG2 : WALNUT_TREE_CONFIG2);
	 }
}*/

public class WalnutTree extends Tree{	// WALNUT_TREE_SMALL_CONFIG
	public static final HugeTreeFeatureConfig WALNUT_TREE_CONFIG = (new HugeTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInitNew.WALNUT_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInitNew.WALNUT_LEAVES.get().getDefaultState())))
					.baseHeight(7)
					.heightInterval(2)
					.crownHeight(4)
					.setSapling((IPlantable)BlockInitNew.WALNUT_SAPLING.get())
					.build();
	
	public static final TreeFeatureConfig WALNUT_TREE_SMALL_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInitNew.WALNUT_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(BlockInitNew.WALNUT_LEAVES.get().getDefaultState()), 
			new BlobFoliagePlacer(1, 0)))				// leaf radius, 
			.baseHeight(25)			// func_225569_d_	// baseHeight
			.heightRandA(2)			// func_227354_b_	// heightRandA
			.foliageHeight(10)		// func_227360_i_	// foliageHeight
			.ignoreVines()			// func_227352_a_	// ignoreVines
			.setSapling((IPlantable)BlockInitNew.WALNUT_SAPLING.get()).build();		// func_225568_b_	// build
	
	protected ConfiguredFeature<HugeTreeFeatureConfig, ?> getHugeTreeFeature(
			Random p_225547_1_) {
		return Feature.MEGA_SPRUCE_TREE
				.withConfiguration(WALNUT_TREE_CONFIG);
	}

	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(
			Random randomIn, boolean p_225546_2_) {
		return null;
	}
}