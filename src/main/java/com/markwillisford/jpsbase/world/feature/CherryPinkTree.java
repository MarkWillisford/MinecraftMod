package com.markwillisford.jpsbase.world.feature;

import java.util.Random;

import com.markwillisford.jpsbase.init.BlockInitNew;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;

public class CherryPinkTree extends Tree {
	public static final TreeFeatureConfig CHERRY_PINK_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInitNew.CHERRY_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInitNew.CHERRY_PINK_LEAVES.get().getDefaultState()),
			new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines()
					.setSapling((net.minecraftforge.common.IPlantable) BlockInitNew.CHERRY_PINK_SAPLING.get()).build();
	public static final TreeFeatureConfig FANCY_CHERRY_PINK_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInitNew.CHERRY_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInitNew.CHERRY_PINK_LEAVES.get().getDefaultState()),
			new BlobFoliagePlacer(0, 0)))
					.setSapling((net.minecraftforge.common.IPlantable) BlockInitNew.CHERRY_PINK_SAPLING.get()).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return randomIn.nextInt(4) == 0 // between 0 inclusive and 4 exclusive
				? Feature.FANCY_TREE
						.withConfiguration(b ? FANCY_CHERRY_PINK_TREE_CONFIG : FANCY_CHERRY_PINK_TREE_CONFIG)
				: Feature.NORMAL_TREE.withConfiguration(b ? CHERRY_PINK_TREE_CONFIG : CHERRY_PINK_TREE_CONFIG);

	}
}
