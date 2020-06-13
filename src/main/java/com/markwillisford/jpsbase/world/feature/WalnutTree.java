package com.markwillisford.jpsbase.world.feature;

import java.util.Random;

import com.markwillisford.jpsbase.init.BlockInitNew;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class WalnutTree extends Tree{
	public static final TreeFeatureConfig WALNUT_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInitNew.WALNUT_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(BlockInitNew.WALNUT_LEAVES.get().getDefaultState()), 
			new BlobFoliagePlacer(2, 0)))				// leaf radius, 
			.baseHeight(7)			// func_225569_d_	// baseHeight
			.heightRandA(2)			// func_227354_b_	// heightRandA
			.foliageHeight(3)		// func_227360_i_	// foliageHeight
			.ignoreVines()			// func_227352_a_	// ignoreVines
			.setSapling((IPlantable)BlockInitNew.WALNUT_SAPLING.get()).build();		// func_225568_b_	// build

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(WALNUT_TREE_CONFIG);
	}
}