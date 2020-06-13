package com.markwillisford.jpsbase.util.helpers;

import com.markwillisford.jpsbase.JPsBase;
import com.markwillisford.jpsbase.init.DimensionInit;

import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = JPsBase.MOD_ID, bus = Bus.FORGE)
public class ForgeEventBusSubsciber {
	
	/*
	@SubscribeEvent
	public static void registerDimensions(final RegisterDimensionsEvent event) {
		if(DimensionType.byName(JPsBase.EXAMPLE_DIM_TYPE) == null) {
			DimensionManager.registerDimension(JPsBase.EXAMPLE_DIM_TYPE, DimensionInit.EXAMPLE_DIM.get(), null, true);
		}
		JPsBase.LOGGER.info("Dimensions Registered");
	}
	*/
}
