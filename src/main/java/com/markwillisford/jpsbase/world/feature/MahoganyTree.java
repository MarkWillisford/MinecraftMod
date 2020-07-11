package com.markwillisford.jpsbase.world.feature;

import java.util.Random;

import com.markwillisford.jpsbase.init.BlockInitNew;
import com.markwillisford.jpsbase.init.FeatureInit;
import com.markwillisford.jpsbase.objects.placers.MahoganyFoliagePlacer;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraftforge.common.IPlantable;

public class MahoganyTree extends Tree {
	public static final TreeFeatureConfig MAHOGANY_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(
					BlockInitNew.MAHOGANY_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(
					BlockInitNew.MAHOGANY_LEAVES.get().getDefaultState()),
			new MahoganyFoliagePlacer(0, 0))).baseHeight(7).heightRandA(2)
					// .foliageHeight(3)
					// .decorators(ImmutableList.of(
					// new LeaveVineTreeDecorator()))
					.trunkHeight(0)// .trunkHeightRandom(0).trunkTopOffsetRandom(0)
					.ignoreVines()
					.setSapling(
							(IPlantable) BlockInitNew.MAHOGANY_SAPLING.get())
					.build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(
			Random randomIn, boolean b) {
		//return FeatureInit.MAHOGANY_TREE_FEATURE.get()			// TODO! Needs work on the branches
		//		.withConfiguration(MAHOGANY_TREE_CONFIG);
		return Feature.FANCY_TREE.withConfiguration(MAHOGANY_TREE_CONFIG);
	}	
}