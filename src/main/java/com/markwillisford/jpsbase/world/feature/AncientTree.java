package com.markwillisford.jpsbase.world.feature;

import java.util.Random;

import com.markwillisford.jpsbase.init.BlockInitNew;
import com.markwillisford.jpsbase.objects.placers.WalnutFoliagePlacer;

import net.minecraft.block.trees.BigTree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class AncientTree extends BigTree{
	   
	public static final TreeFeatureConfig WALNUT_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInitNew.WALNUT_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(BlockInitNew.WALNUT_LEAVES.get().getDefaultState()), 
			new BlobFoliagePlacer(1, 0)))				// leaf radius, 
			.baseHeight(25)			// func_225569_d_	// baseHeight
			.heightRandA(2)			// func_227354_b_	// heightRandA
			.foliageHeight(10)		// func_227360_i_	// foliageHeight
			.ignoreVines()			// func_227352_a_	// ignoreVines
			.setSapling((IPlantable)BlockInitNew.WALNUT_SAPLING.get()).build();		// func_225568_b_	// build
	
	public static final TreeFeatureConfig WALNUT_TREE_CONFIG2 = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInitNew.ANCIENT_TREE_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(BlockInitNew.ANCIENT_TREE_LEAVES.get().getDefaultState()), 
			new WalnutFoliagePlacer(2, 0)))
			.baseHeight(5)
			.heightRandA(2)
			.foliageHeight(0)
			//.decorators(ImmutableList.of( 
					// new LeaveVineTreeDecorator()))
			//.trunkHeight(1)//.trunkHeightRandom(0).trunkTopOffsetRandom(0)
			.ignoreVines()
			.setSapling((IPlantable)BlockInitNew.ANCIENT_TREE_SAPLING.get()).build();
	
	public static final HugeTreeFeatureConfig MEGA_ANCIENT_TREE_CONFIG = (new HugeTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInitNew.ANCIENT_TREE_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(BlockInitNew.ANCIENT_TREE_LEAVES.get().getDefaultState())))
			.baseHeight(20)
			.heightInterval(10)	// 
			.crownHeight(0)		//
			//.decorators(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(PODZOL))))
			.setSapling((IPlantable)BlockInitNew.ANCIENT_TREE_SAPLING.get()).build();
	
	
	
	// public static final HugeTreeFeatureConfig MEGA_PINE_TREE_CONFIG = (new HugeTreeFeatureConfig.Builder(new SimpleBlockStateProvider(SPRUCE_LOG), new SimpleBlockStateProvider(SPRUCE_LEAVES))).baseHeight(13).heightInterval(15).crownHeight(3).decorators(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(PODZOL)))).setSapling((net.minecraftforge.common.IPlantable)Blocks.SPRUCE_SAPLING).build();

	//@Override
	protected ConfiguredFeature<HugeTreeFeatureConfig, ?> getHugeTreeFeature(Random randomIn) {
		return Feature.MEGA_SPRUCE_TREE.withConfiguration(MEGA_ANCIENT_TREE_CONFIG); 
		
	//@Override
	// protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		// return Feature.FANCY_TREE.withConfiguration(WALNUT_TREE_CONFIG);					// NORMAL_TREE
		// return Feature.NORMAL_TREE.withConfiguration(SPRUCE_TREE_CONFIG); 
		// return Feature.ACACIA_TREE.withConfiguration(SPRUCE_TREE_CONFIG);
		/*return randomIn.nextInt(10) == 0 	// between 0 inclusive and 10 exclusive
				? Feature.NORMAL_TREE.withConfiguration(
						b ? WALNUT_TREE_CONFIG : WALNUT_TREE_CONFIG
				) : Feature.NORMAL_TREE.withConfiguration(
						b ? WALNUT_TREE_CONFIG2 : WALNUT_TREE_CONFIG2);*/
	
	
	 }



	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(
			Random randomIn, boolean p_225546_2_) {
		return null;
	}
}