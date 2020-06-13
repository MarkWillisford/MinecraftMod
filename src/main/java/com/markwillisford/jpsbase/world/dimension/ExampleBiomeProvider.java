package com.markwillisford.jpsbase.world.dimension;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.markwillisford.jpsbase.init.BiomeInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

public class ExampleBiomeProvider extends BiomeProvider{

	private Random rand;

	public ExampleBiomeProvider() {
		super(biomeList);
		rand = new Random();
	}

	private static final Set<Biome> biomeList = ImmutableSet.of();		// (BiomeInit.EXAMPLE_BIOME.get());

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return null;
		// return BiomeInit.EXAMPLE_BIOME.get();
	}
}
