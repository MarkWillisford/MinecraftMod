package com.markwillisford.jpsbase.world.gen;

import com.markwillisford.jpsbase.init.BlockInitNew;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {
	public static void generateOre() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			ConfiguredPlacement<CountRangeConfig> customConfig = Placement.COUNT_RANGE
				.configure(new CountRangeConfig(20, 5, 0, 128));	// rarity, lowest y, ?, highest y
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
				BlockInitNew.RUBY_ORE.get().getDefaultState(), 10)) // this int is the max vain size
				.withPlacement(customConfig));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
					BlockInitNew.SAPPHIRE_ORE.get().getDefaultState(), 10))
					.withPlacement(customConfig));
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
