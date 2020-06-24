package com.markwillisford.jpsbase.world.feature;

import java.util.Random;

import com.google.common.collect.ImmutableList;
import com.markwillisford.jpsbase.init.BlockInitNew;

import net.minecraft.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraftforge.common.IPlantable;



public class AncientTree extends Tree{
	public static final TreeFeatureConfig ANCIENT_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInitNew.ANCIENT_TREE_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(BlockInitNew.ANCIENT_TREE_LEAVES.get().getDefaultState()), 
			new BlobFoliagePlacer(0, 0)))
			.setSapling((net.minecraftforge.common.IPlantable)BlockInitNew.ANCIENT_TREE_SAPLING.get()).build();
	
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.FANCY_TREE.withConfiguration(ANCIENT_TREE_CONFIG);	
	}
}
