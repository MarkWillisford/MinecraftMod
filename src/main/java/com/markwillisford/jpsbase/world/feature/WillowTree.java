package com.markwillisford.jpsbase.world.feature;

import java.util.Random;

import com.google.common.collect.ImmutableList;
import com.markwillisford.jpsbase.init.BlockInitNew;
import com.markwillisford.jpsbase.objects.placers.WillowFoliagePlacer;

import net.minecraft.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraftforge.common.IPlantable;

public class WillowTree extends Tree {
	public static final TreeFeatureConfig WILLOW_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(
					BlockInitNew.WILLOW_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(
					BlockInitNew.WILLOW_LEAVES.get().getDefaultState()),
			new WillowFoliagePlacer(2, 0)))
					// new BlobFoliagePlacer(0, 0)))
					.baseHeight(5).heightRandA(2)
					// .heightRandB(2)
					// .foliageHeight(4)
					.decorators(ImmutableList.of(new LeaveVineTreeDecorator()))
					.trunkHeight(0)// .trunkHeightRandom(0).trunkTopOffsetRandom(0)
					// .ignoreVines()
					.setSapling((IPlantable) BlockInitNew.WILLOW_SAPLING.get())
					.build();

	public static final TreeFeatureConfig WILLOW_TREE_CONFIG2 = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInitNew.WILLOW_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInitNew.WILLOW_LEAVES.get().getDefaultState()),
			new BlobFoliagePlacer(3, 0))).baseHeight(4).heightRandA(2)
					.foliageHeight(3).ignoreVines()
					.decorators(ImmutableList.of(new LeaveVineTreeDecorator()))
					.setSapling((IPlantable) BlockInitNew.WILLOW_SAPLING.get())
					.build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(
			Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(WILLOW_TREE_CONFIG2);
	}
}
