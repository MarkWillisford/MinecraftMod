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

public class MapleTree extends Tree{	
	public static final TreeFeatureConfig MAPLE_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInitNew.MAPLE_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(BlockInitNew.MAPLE_LEAVES.get().getDefaultState()), 
			// new AcaciaFoliagePlacer(2, 0)))
			new BlobFoliagePlacer(0, 0)))
			.baseHeight(5)
			.heightRandA(2)
			//.foliageHeight(3)
			//.decorators(ImmutableList.of( 
					// new LeaveVineTreeDecorator()))
			.trunkHeight(0)//.trunkHeightRandom(0).trunkTopOffsetRandom(0)
			.ignoreVines()
			.setSapling((IPlantable)BlockInitNew.MAPLE_SAPLING.get()).build();
	
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(MAPLE_TREE_CONFIG); 

	 }
}