package com.markwillisford.jpsbase.world.feature;

import java.util.Random;

import com.markwillisford.jpsbase.init.BlockInitNew;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class WengeTree extends Tree{	
	public static final TreeFeatureConfig WENGE_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInitNew.WENGE_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(BlockInitNew.WENGE_LEAVES.get().getDefaultState()), 
			new AcaciaFoliagePlacer(2, 0)))
			//new BlobFoliagePlacer(0, 0)))
			.baseHeight(5)
			.heightRandA(2)
			//.foliageHeight(3)
			//.decorators(ImmutableList.of( 
					// new LeaveVineTreeDecorator()))
			.trunkHeight(0)//.trunkHeightRandom(0).trunkTopOffsetRandom(0)
			.ignoreVines()
			.setSapling((IPlantable)BlockInitNew.WENGE_SAPLING.get()).build();
	
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.ACACIA_TREE.withConfiguration(WENGE_TREE_CONFIG); 

	 }
}