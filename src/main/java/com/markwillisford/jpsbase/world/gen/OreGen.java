package com.markwillisford.jpsbase.world.gen;

import com.markwillisford.jpsbase.init.BlockInitNew;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {
	public static void generateOre() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			// Diamond: 8 - 1, 0, 0, 16
			// Gold: 9 - 2, 0, 0, 32
			// Iron: 9 - 20, 0, 0, 64
			// Coal: 17 - 20, 0, 0, 128
			// Andisite: 33 - 10, 0, 0, 80
			ConfiguredPlacement<CountRangeConfig> gemConfig = Placement.COUNT_RANGE
				.configure(new CountRangeConfig(1, 0, 0, 16));	// rarity, lowest y, ?, highest y
			ConfiguredPlacement<CountRangeConfig> alternateStoneConfig = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(5, 32, 0, 80));	
			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
				BlockInitNew.RUBY_ORE.get().getDefaultState(), 2)) // this int is the max vain size
				.withPlacement(gemConfig));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
					BlockInitNew.SAPPHIRE_ORE.get().getDefaultState(), 2))
					.withPlacement(gemConfig));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
					BlockInitNew.MARBLE.get().getDefaultState(), 33))
					.withPlacement(alternateStoneConfig));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
					BlockInitNew.SLATE.get().getDefaultState(), 33))
					.withPlacement(alternateStoneConfig));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
					BlockInitNew.SLATE_BLUE.get().getDefaultState(), 33))
					.withPlacement(alternateStoneConfig));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
					BlockInitNew.SLATE_GREEN.get().getDefaultState(), 33))
					.withPlacement(alternateStoneConfig));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
					BlockInitNew.SLATE_PURPLE.get().getDefaultState(), 33))
					.withPlacement(alternateStoneConfig));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
					BlockInitNew.SLATE_RED.get().getDefaultState(), 33))
					.withPlacement(alternateStoneConfig));
			/*if (biome == Biomes.PLAINS) {
				ConfiguredPlacement<CountRangeConfig> customConfig = Placement.COUNT_RANGE
						.configure(new CountRangeConfig(20, 5, 0, 128));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
						BlockInit.example_block.getDefaultState(), 10))
						.withPlacement(customConfig));
			}*/
		}
	}
}
