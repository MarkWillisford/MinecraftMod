package com.markwillisford.jpsbase.world.gen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;
import com.markwillisford.jpsbase.init.BlockInitNew;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {
	public static final Logger LOGGER = LogManager.getLogger();
	public static void generateOre() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			// Diamond: 8 - 1, 0, 0, 16
			// Gold: 9 - 2, 0, 0, 32
			// Iron: 9 - 20, 0, 0, 64
			// Coal: 17 - 20, 0, 0, 128
			// Andisite: 33 - 10, 0, 0, 80
			ConfiguredPlacement<CountRangeConfig> gemConfig = Placement.COUNT_RANGE
				.configure(new CountRangeConfig(1, 0, 0, 16));	// rarity, lowest y, ?, highest y
			ConfiguredPlacement<CountRangeConfig> oreConfig = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(1, 0, 0, 16));	
			ConfiguredPlacement<CountRangeConfig> alternateStoneConfig = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(5, 32, 0, 80));	 //TODO! turn this down a bit
			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
				BlockInitNew.RUBY_ORE.get().getDefaultState(), 4)) // this int is the max vain size
				.withPlacement(gemConfig));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
					BlockInitNew.SAPPHIRE_ORE.get().getDefaultState(), 4))
					.withPlacement(gemConfig));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
					BlockInitNew.SMALL_MITHRAL_ORE.get().getDefaultState(), 4))
					.withPlacement(oreConfig));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
					BlockInitNew.SMALL_ADAMANTINE_ORE.get().getDefaultState(), 4))
					.withPlacement(oreConfig));
			
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
			
			if (biome == Biomes.MOUNTAINS) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
						BlockInitNew.MITHRAL_ORE.get().getDefaultState(), 4))
						.withPlacement(oreConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
						BlockInitNew.ADAMANTINE_ORE.get().getDefaultState(), 4))
						.withPlacement(oreConfig));
			}
			
			if (biome == Biomes.RIVER) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
						Feature.DISK.withConfiguration(new SphereReplaceConfig(
								BlockInitNew.MUD_WET.get().getDefaultState(), 4, 1, 
								Lists.newArrayList(Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())))
						.withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(3))));
			}
		}
	}
}
