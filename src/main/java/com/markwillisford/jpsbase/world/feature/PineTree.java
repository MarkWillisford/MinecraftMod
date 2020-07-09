package com.markwillisford.jpsbase.world.feature;

import java.util.Random;

import com.markwillisford.jpsbase.init.BlockInitNew;
import com.markwillisford.jpsbase.objects.placers.FirFoliagePlacer;
import com.markwillisford.jpsbase.objects.placers.PineFoliagePlacer;
import com.markwillisford.jpsbase.objects.placers.WalnutFoliagePlacer;

import net.minecraft.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class PineTree extends Tree {
	public static final TreeFeatureConfig PINE_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(
					BlockInitNew.PINE_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(
					BlockInitNew.PINE_LEAVES.get().getDefaultState()),
			new PineFoliagePlacer(2, 0)))
					.baseHeight(7)
					.heightRandA(2)
					.foliageHeight(0)
					// .decorators(ImmutableList.of(
					// new LeaveVineTreeDecorator()))
					// .trunkHeight(1)//.trunkHeightRandom(0).trunkTopOffsetRandom(0)
					.ignoreVines()
					.setSapling((IPlantable) BlockInitNew.PINE_SAPLING.get())
					.build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(
			Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(PINE_TREE_CONFIG);
	}
}