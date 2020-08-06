package com.markwillisford.jpsbase.world.gen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.ImmutableList;
import com.markwillisford.jpsbase.world.feature.CherryPinkTree;
import com.markwillisford.jpsbase.world.feature.CherryWhiteTree;
import com.markwillisford.jpsbase.world.feature.FirTree;
import com.markwillisford.jpsbase.world.feature.MahoganyTree;
import com.markwillisford.jpsbase.world.feature.MapleTree;
import com.markwillisford.jpsbase.world.feature.PineTree;
import com.markwillisford.jpsbase.world.feature.WalnutTree;
import com.markwillisford.jpsbase.world.feature.WengeTree;
import com.markwillisford.jpsbase.world.feature.WillowTree;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class TreeGen {
    public static final Logger LOGGER = LogManager.getLogger();
    
	public static void generateTrees() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			// Cherry Trees
			if (biome == Biomes.FLOWER_FOREST) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(
					new MultipleRandomFeatureConfig(ImmutableList.of(
						Feature.NORMAL_TREE.withConfiguration(CherryPinkTree.CHERRY_PINK_TREE_CONFIG).withChance(0.5F),
						Feature.FANCY_TREE.withConfiguration(CherryPinkTree.FANCY_CHERRY_PINK_TREE_CONFIG).withChance(0.1F),
						Feature.FANCY_TREE.withConfiguration(CherryWhiteTree.FANCY_CHERRY_WHITE_TREE_CONFIG).withChance(0.1F)), 
						Feature.NORMAL_TREE.withConfiguration(CherryWhiteTree.CHERRY_WHITE_TREE_CONFIG))
					).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.5F, 1))));			
			}
			// Fir Trees in 
			if (biome == Biomes.TAIGA ||
				biome == Biomes.TAIGA_HILLS ||
				biome == Biomes.TAIGA_MOUNTAINS ||
				biome == Biomes.SNOWY_TAIGA ||
				biome == Biomes.SNOWY_TAIGA_HILLS ||
				biome == Biomes.SNOWY_TAIGA_MOUNTAINS) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(
					//PineTree.PINE_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.5F, 1))));
					FirTree.FIR_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.5F, 1))));
			}
				//if (biome == Biomes.SNOWY_TAIGA || 
				//	biome == Biomes.SNOWY_TAIGA_HILLS ||
				//	biome == Biomes.SNOWY_TAIGA_MOUNTAINS) {
				//	biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(
				//			FirTree.FIR_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
				
					//biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(
					//		new MultipleRandomFeatureConfig(ImmutableList.of(
					//			Feature.NORMAL_TREE.withConfiguration(FirTree.FIR_TREE_CONFIG).withChance(0.33F)), 
					//			Feature.NORMAL_TREE.withConfiguration(PineTree.PINE_TREE_CONFIG))
					//		).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
				//}
			// Maple Trees in 
			if (biome == Biomes.FOREST) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(
					new MultipleRandomFeatureConfig(ImmutableList.of(
						Feature.NORMAL_TREE.withConfiguration(CherryPinkTree.CHERRY_PINK_TREE_CONFIG).withChance(0.23F),
						Feature.FANCY_TREE.withConfiguration(CherryPinkTree.FANCY_CHERRY_PINK_TREE_CONFIG).withChance(0.02F),
						Feature.FANCY_TREE.withConfiguration(CherryWhiteTree.FANCY_CHERRY_WHITE_TREE_CONFIG).withChance(0.02F),
						Feature.NORMAL_TREE.withConfiguration(MapleTree.MAPLE_TREE_CONFIG).withChance(0.35F),
						Feature.FANCY_TREE.withConfiguration(MapleTree.FANCY_MAPLE_TREE_CONFIG).withChance(0.15F)), 
						Feature.NORMAL_TREE.withConfiguration(CherryWhiteTree.CHERRY_WHITE_TREE_CONFIG))
					).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 1.0F, 1))));	
			}
			
			// Pine Trees in 
		
			// Walnut Tree's in 
			if (biome == Biomes.PLAINS) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.MEGA_SPRUCE_TREE.withConfiguration(
						WalnutTree.WALNUT_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.3F, 1))));
			}
			
			// Wenge and Mahogany Trees in 
			if (biome == Biomes.SAVANNA || 
				biome == Biomes.SAVANNA_PLATEAU ||
				biome == Biomes.SHATTERED_SAVANNA ||
				biome == Biomes.SHATTERED_SAVANNA_PLATEAU) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(
					new MultipleRandomFeatureConfig(ImmutableList.of(
						Feature.ACACIA_TREE.withConfiguration(MahoganyTree.MAHOGANY_TREE_CONFIG_A).withChance(0.6F)), 
						Feature.ACACIA_TREE.withConfiguration(WengeTree.WENGE_TREE_CONFIG))
					).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.5F, 1))));
			}
			// Willow Tree in swamps
			if (biome == Biomes.SWAMP ||
				biome == Biomes.SWAMP_HILLS) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(
					WillowTree.WILLOW_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
			}
		}
		// Willow Tree along rivers
	}
}
