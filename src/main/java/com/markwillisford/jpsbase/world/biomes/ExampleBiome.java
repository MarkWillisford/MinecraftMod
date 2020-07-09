package com.markwillisford.jpsbase.world.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.TwoFeatureChoiceConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.HeightWithChanceConfig;
import net.minecraft.world.gen.placement.Placement;

public class ExampleBiome extends Biome{

	public ExampleBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 20, 2, 10));
		// DefaultBiomeFeatures
		// this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285715F)));
		this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.HELL_CAVE, new ProbabilityConfig(0.14285715F)));
		
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(128))));
		
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addExtraEmeraldOre(this);
		DefaultBiomeFeatures.addExtraGoldOre(this);
	}
}


/*you can then go into your custom biome and add it like this:
 

public class MY_CUSTOM_BIOME extends Biome
{
	public MY_CUSTOM_BIOME
    {
    	super(Your biome.builder config stuff);
      	// THIS IS WHAT YOU USE
      	this.addFeature(
          	Decoration.VEGETAL_DECORATION, 
          	Biome.createDecoratedFeature(
        		MyFeatures.CUSTOM_TREE, 
          		IFeatureConfig.NO_FEATURE_CONFIG, 
          		Placement.COUNT_EXTRA_HEIGHTMAP, 
          		new AtSurfaceWithExtraConfig(0.4F, 10, 1));
    }
}
or, if you want to add it to a biome that already exists (a vanilla biome)
 

for (Biome biome : ForgeRegistries.BIOMES) 
{
        biome.addFeature(
                Decoration.VEGETAL_DECORATION,
                Biome.createDecoratedFeature(
                        MyFeatures.CUSTOM_TREE,
                        IFeatureConfig.NO_FEATURE_CONFIG,
                        Placement.COUNT_EXTRA_HEIGHTMAP,
                        new AtSurfaceWithExtraConfig(0.4F, 10, 1))
        );
}
This code would go in your main mod file, under the FMLCommonSetupEvent (you probably called it init or something similar)*/