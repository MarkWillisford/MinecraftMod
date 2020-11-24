package com.markwillisford.jpsbase.init;

import com.markwillisford.jpsbase.JPsBase;
import com.markwillisford.jpsbase.JPsBase.TutorialItemGroup;
import com.markwillisford.jpsbase.objects.blocks.BlockQuarry;
import com.markwillisford.jpsbase.objects.blocks.SpecalBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(JPsBase.MOD_ID)
@Mod.EventBusSubscriber(modid = JPsBase.MOD_ID, bus = Bus.MOD)
public class BlockInit {
	public static final Block example_block = null;
	public static final Block specal_block = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).harvestLevel(2).sound(SoundType.WOOD)).setRegistryName("example_block"));
		event.getRegistry().register(new SpecalBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F)
				.harvestTool(ToolType.AXE).harvestLevel(2).sound(SoundType.GLASS).lightValue(4)
				.slipperiness(1.2f).noDrops()).setRegistryName("specal_block"));
		}
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new BlockItem(example_block, new Item.Properties().maxStackSize(16).group(TutorialItemGroup.instance)).setRegistryName("example_block"));
		event.getRegistry().register(new BlockItem(specal_block, new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("specal_block"));
	}
}
