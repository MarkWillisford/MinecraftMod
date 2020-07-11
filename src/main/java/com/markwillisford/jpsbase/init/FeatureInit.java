package com.markwillisford.jpsbase.init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.markwillisford.jpsbase.JPsBase;
import com.markwillisford.jpsbase.world.feature.FancyTreeTestingFeature;
import com.markwillisford.jpsbase.world.feature.Mahogany_Tree_Feature;
import com.mojang.datafixers.Dynamic;

import net.minecraft.world.gen.feature.AbstractSmallTreeFeature;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class FeatureInit<FC extends IFeatureConfig> extends net.minecraftforge.registries.ForgeRegistryEntry<Feature<?>> {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<>(
			ForgeRegistries.FEATURES, JPsBase.MOD_ID);

	public static final RegistryObject<AbstractSmallTreeFeature<TreeFeatureConfig>> MAHOGANY_TREE_FEATURE = FEATURES
			.register("mahogany_tree_feature", () -> new Mahogany_Tree_Feature(
					TreeFeatureConfig::deserializeFoliage));
	public static final RegistryObject<AbstractTreeFeature<TreeFeatureConfig>> FANCY_TREE_TESTING_FEATURE = FEATURES
			.register("fancy_tree_testing_feature", () -> new FancyTreeTestingFeature(
					TreeFeatureConfig::deserializeFoliage));
}
