package com.markwillisford.jpsbase.init;

import com.markwillisford.jpsbase.JPsBase;
import com.markwillisford.jpsbase.world.biomes.ExampleBiome;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, JPsBase.MOD_ID);
	
	/*
	public static final RegistryObject<Biome> EXAMPLE_BIOME = BIOMES.register("example_biome", 
			() -> new ExampleBiome(new Biome.Builder().precipitation(RainType.SNOW).scale(1.2f).temperature(.5f)
					.waterColor(16724639).waterFogColor(16762304) // 0xFFFFFF for hexedecimal
					.surfaceBuilder(SurfaceBuilder.DEFAULT, 
							new SurfaceBuilderConfig(BlockInit.example_block.getDefaultState(), 
									BlockInitNew.EXAMPLE_STARES.get().getDefaultState(), 
									Blocks.ACACIA_LOG.getDefaultState()))
					.category(Category.PLAINS)
					.downfall(.5F)
					.depth(0.5F).scale(0.05F)
					//.depth(1.0f)				// default depth is 0.125
					.parent(null)));			// nullable
	*/
	
	public static void registerBiomes() {
		//registerBiome(EXAMPLE_BIOME.get(), Type.PLAINS, Type.OVERWORLD);
	}
	
	private static void registerBiome(Biome biome, Type... types) {
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 100));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}
	
}
