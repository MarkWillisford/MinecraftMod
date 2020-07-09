package com.markwillisford.jpsbase.world.feature;

import java.util.Random;

import com.markwillisford.jpsbase.init.BlockInitNew;
import com.markwillisford.jpsbase.objects.placers.FirFoliagePlacer;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraftforge.common.IPlantable;

public class FirTree extends Tree{
	public static final TreeFeatureConfig FIR_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInitNew.FIR_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(BlockInitNew.FIR_LEAVES.get().getDefaultState()), 
			new FirFoliagePlacer(2, 0)))
			.baseHeight(5)
			.heightRandA(2)
			//.trunkTopOffset(1)
			.foliageHeight(0)
			//.foliageHeightRandom(1)
			.ignoreVines()
			.setSapling((IPlantable)BlockInitNew.FIR_SAPLING.get()).build();
	
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(FIR_TREE_CONFIG); 	
	 }
}