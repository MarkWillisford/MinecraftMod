package com.markwillisford.jpsbase.util.helpers;

import com.markwillisford.jpsbase.JPsBase;
import com.markwillisford.jpsbase.init.BlockInitNew;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = JPsBase.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(BlockInitNew.WALNUT_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.MAHOGANY_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.WALNUT_LEAVES_CARPET.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.MAHOGANY_LEAVES_CARPET.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.FIR_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.FIR_LEAVES_CARPET.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.ANCIENT_TREE_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.ANCIENT_TREE_LEAVES_CARPET.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.PINE_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.PINE_LEAVES_CARPET.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.WENGE_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.WENGE_LEAVES_CARPET.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.WILLOW_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.WILLOW_LEAVES_CARPET.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.MAPLE_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.MAPLE_LEAVES_CARPET.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.CHERRY_PINK_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.CHERRY_PINK_LEAVES_CARPET.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.CHERRY_WHITE_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.CHERRY_WHITE_LEAVES_CARPET.get(), RenderType.getCutout());
	}
}

