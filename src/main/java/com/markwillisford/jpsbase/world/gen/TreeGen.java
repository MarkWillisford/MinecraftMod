package com.markwillisford.jpsbase.world.gen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.markwillisford.jpsbase.world.feature.WillowTree;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class TreeGen {
    public static final Logger LOGGER = LogManager.getLogger();
    
	public static void generateTrees() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			// Cherry Trees
		
			// Fir Trees in 
		
			// Mahogany Trees in 
		
			// Maple Trees in 
		
			// Pine Trees in 
		
			// Walnut Tree's in 
		
			// Wenge Tree's in 
		
			// Willow Tree in swamps
			if (biome == Biomes.SWAMP ||
				biome == Biomes.SWAMP_HILLS) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(
						WillowTree.WILLOW_TREE_CONFIG2).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
				      
			}			
		}
		// Willow Tree along rivers
	}
}
