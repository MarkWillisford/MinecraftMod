package com.markwillisford.jpsbase.init;

import com.markwillisford.jpsbase.JPsBase;
import com.markwillisford.jpsbase.objects.blocks.FallingSlabBlock;
import com.markwillisford.jpsbase.objects.blocks.FallingStairBlock;
import com.markwillisford.jpsbase.objects.blocks.ModCarpetBlock;
import com.markwillisford.jpsbase.objects.blocks.ModOreBlock;
import com.markwillisford.jpsbase.objects.blocks.ModPressurePlateBlock;
import com.markwillisford.jpsbase.objects.blocks.ModSaplingBlock;
import com.markwillisford.jpsbase.objects.blocks.ModWoodButtonBlock;
import com.markwillisford.jpsbase.objects.blocks.StepBlock;
import com.markwillisford.jpsbase.objects.blocks.VerticalSlabBlock;
import com.markwillisford.jpsbase.world.feature.WalnutTree;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInitNew {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, JPsBase.MOD_ID);
	
	public static final RegistryObject<Block> DEF_ITEM = BLOCKS.register("def_block", () -> new Block(Block.Properties.create(Material.IRON)));
	
	// Stones and Slates
	public static final RegistryObject<Block> MARBLE = BLOCKS.register("marble", () -> new Block(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> MARBLE_SLAB = BLOCKS.register("marble_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> MARBLE_STAIRS = BLOCKS.register("marble_stairs", () -> new StairsBlock(() -> Blocks.STONE.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> MARBLE_BUTTON = BLOCKS.register("marble_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> MARBLE_PRESSURE_PLATE = BLOCKS.register("marble_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> MARBLE_VERTICAL_SLAB = BLOCKS.register("marble_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> MARBLE_STEP = BLOCKS.register("marble_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> MARBLE_WALL = BLOCKS.register("marble_wall", () -> new WallBlock(Block.Properties.from(Blocks.STONE)));
	
	public static final RegistryObject<Block> MARBLE_POLISHED = BLOCKS.register("marble_polished", () -> new Block(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> MARBLE_POLISHED_SLAB = BLOCKS.register("marble_polished_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> MARBLE_POLISHED_STAIRS = BLOCKS.register("marble_polished_stairs", () -> new StairsBlock(() -> Blocks.STONE.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> MARBLE_POLISHED_BUTTON = BLOCKS.register("marble_polished_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> MARBLE_POLISHED_PRESSURE_PLATE = BLOCKS.register("marble_polished_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> MARBLE_POLISHED_VERTICAL_SLAB = BLOCKS.register("marble_polished_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> MARBLE_POLISHED_STEP = BLOCKS.register("marble_polished_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> MARBLE_POLISHED_WALL = BLOCKS.register("marble_polished_wall", () -> new WallBlock(Block.Properties.from(Blocks.STONE)));

	// blue + Hue 20, Saturation -5
	public static final RegistryObject<Block> SLATE = BLOCKS.register("slate", () -> new Block(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_SLAB = BLOCKS.register("slate_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_STAIRS = BLOCKS.register("slate_stairs", () -> new StairsBlock(() -> Blocks.STONE.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_BUTTON = BLOCKS.register("slate_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_PRESSURE_PLATE = BLOCKS.register("slate_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_VERTICAL_SLAB = BLOCKS.register("slate_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_STEP = BLOCKS.register("slate_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_WALL = BLOCKS.register("slate_wall", () -> new WallBlock(Block.Properties.from(Blocks.STONE)));
	
	public static final RegistryObject<Block> SLATE_BLUE = BLOCKS.register("slate_blue", () -> new Block(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_BLUE_SLAB = BLOCKS.register("slate_blue_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_BLUE_STAIRS = BLOCKS.register("slate_blue_stairs", () -> new StairsBlock(() -> Blocks.STONE.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_BLUE_BUTTON = BLOCKS.register("slate_blue_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_BLUE_PRESSURE_PLATE = BLOCKS.register("slate_blue_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_BLUE_VERTICAL_SLAB = BLOCKS.register("slate_blue_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_BLUE_STEP = BLOCKS.register("slate_blue_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_BLUE_WALL = BLOCKS.register("slate_blue_wall", () -> new WallBlock(Block.Properties.from(Blocks.STONE)));
	
	public static final RegistryObject<Block> SLATE_GREEN = BLOCKS.register("slate_green", () -> new Block(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_GREEN_SLAB = BLOCKS.register("slate_green_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_GREEN_STAIRS = BLOCKS.register("slate_green_stairs", () -> new StairsBlock(() -> Blocks.STONE.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_GREEN_BUTTON = BLOCKS.register("slate_green_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_GREEN_PRESSURE_PLATE = BLOCKS.register("slate_green_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_GREEN_VERTICAL_SLAB = BLOCKS.register("slate_green_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_GREEN_STEP = BLOCKS.register("slate_green_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_GREEN_WALL = BLOCKS.register("slate_green_wall", () -> new WallBlock(Block.Properties.from(Blocks.STONE)));

	public static final RegistryObject<Block> SLATE_PURPLE = BLOCKS.register("slate_purple", () -> new Block(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_PURPLE_SLAB = BLOCKS.register("slate_purple_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_PURPLE_STAIRS = BLOCKS.register("slate_purple_stairs", () -> new StairsBlock(() -> Blocks.STONE.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_PURPLE_BUTTON = BLOCKS.register("slate_purple_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_PURPLE_PRESSURE_PLATE = BLOCKS.register("slate_purple_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_PURPLE_VERTICAL_SLAB = BLOCKS.register("slate_purple_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_PURPLE_STEP = BLOCKS.register("slate_purple_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_PURPLE_WALL = BLOCKS.register("slate_purple_wall", () -> new WallBlock(Block.Properties.from(Blocks.STONE)));
	
	// blue + Hue 122, Saturation 127
	public static final RegistryObject<Block> SLATE_RED = BLOCKS.register("slate_red", () -> new Block(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_RED_SLAB = BLOCKS.register("slate_red_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_RED_STAIRS = BLOCKS.register("slate_red_stairs", () -> new StairsBlock(() -> Blocks.STONE.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_RED_BUTTON = BLOCKS.register("slate_red_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_RED_PRESSURE_PLATE = BLOCKS.register("slate_red_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_RED_VERTICAL_SLAB = BLOCKS.register("slate_red_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_RED_STEP = BLOCKS.register("slate_red_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_RED_WALL = BLOCKS.register("slate_red_wall", () -> new WallBlock(Block.Properties.from(Blocks.STONE)));
	
	public static final RegistryObject<Block> SLATE_POLISHED = BLOCKS.register("slate_polished", () -> new Block(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_POLISHED_SLAB = BLOCKS.register("slate_polished_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_POLISHED_STAIRS = BLOCKS.register("slate_polished_stairs", () -> new StairsBlock(() -> Blocks.STONE.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_POLISHED_BUTTON = BLOCKS.register("slate_polished_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_POLISHED_PRESSURE_PLATE = BLOCKS.register("slate_polished_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_POLISHED_VERTICAL_SLAB = BLOCKS.register("slate_polished_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_POLISHED_STEP = BLOCKS.register("slate_polished_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_POLISHED_WALL = BLOCKS.register("slate_polished_wall", () -> new WallBlock(Block.Properties.from(Blocks.STONE)));
	
	public static final RegistryObject<Block> SLATE_BLUE_POLISHED = BLOCKS.register("slate_blue_polished", () -> new Block(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_BLUE_POLISHED_SLAB = BLOCKS.register("slate_blue_polished_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_BLUE_POLISHED_STAIRS = BLOCKS.register("slate_blue_polished_stairs", () -> new StairsBlock(() -> Blocks.STONE.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_BLUE_POLISHED_BUTTON = BLOCKS.register("slate_blue_polished_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_BLUE_POLISHED_PRESSURE_PLATE = BLOCKS.register("slate_blue_polished_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_BLUE_POLISHED_VERTICAL_SLAB = BLOCKS.register("slate_blue_polished_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_BLUE_POLISHED_STEP = BLOCKS.register("slate_blue_polished_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_BLUE_POLISHED_WALL = BLOCKS.register("slate_blue_polished_wall", () -> new WallBlock(Block.Properties.from(Blocks.STONE)));
	
	public static final RegistryObject<Block> SLATE_GREEN_POLISHED = BLOCKS.register("slate_green_polished", () -> new Block(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_GREEN_POLISHED_SLAB = BLOCKS.register("slate_green_polished_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_GREEN_POLISHED_STAIRS = BLOCKS.register("slate_green_polished_stairs", () -> new StairsBlock(() -> Blocks.STONE.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_GREEN_POLISHED_BUTTON = BLOCKS.register("slate_green_polished_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_GREEN_POLISHED_PRESSURE_PLATE = BLOCKS.register("slate_green_polished_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_GREEN_POLISHED_VERTICAL_SLAB = BLOCKS.register("slate_green_polished_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_GREEN_POLISHED_STEP = BLOCKS.register("slate_green_polished_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_GREEN_POLISHED_WALL = BLOCKS.register("slate_green_polished_wall", () -> new WallBlock(Block.Properties.from(Blocks.STONE)));

	public static final RegistryObject<Block> SLATE_PURPLE_POLISHED = BLOCKS.register("slate_purple_polished", () -> new Block(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_PURPLE_POLISHED_SLAB = BLOCKS.register("slate_purple_polished_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_PURPLE_POLISHED_STAIRS = BLOCKS.register("slate_purple_polished_stairs", () -> new StairsBlock(() -> Blocks.STONE.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_PURPLE_POLISHED_BUTTON = BLOCKS.register("slate_purple_polished_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_PURPLE_POLISHED_PRESSURE_PLATE = BLOCKS.register("slate_purple_polished_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_PURPLE_POLISHED_POLISHED_VERTICAL_SLAB = BLOCKS.register("slate_purple_polished_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_PURPLE_POLISHED_STEP = BLOCKS.register("slate_purple_polished_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_PURPLE_POLISHED_WALL = BLOCKS.register("slate_purple_polished_wall", () -> new WallBlock(Block.Properties.from(Blocks.STONE)));
	
	// blue + Hue 122, Saturation 127
	public static final RegistryObject<Block> SLATE_RED_POLISHED = BLOCKS.register("slate_red_polished", () -> new Block(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_RED_POLISHED_SLAB = BLOCKS.register("slate_red_polished_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_RED_POLISHED_STAIRS = BLOCKS.register("slate_red_polished_stairs", () -> new StairsBlock(() -> Blocks.STONE.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_RED_POLISHED_BUTTON = BLOCKS.register("slate_red_polished_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_RED_POLISHED_PRESSURE_PLATE = BLOCKS.register("slate_red_polished_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_RED_POLISHED_VERTICAL_SLAB = BLOCKS.register("slate_red_polished_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> SLATE_RED_POLISHED_STEP = BLOCKS.register("slate_red_polished_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	public static final RegistryObject<Block> SLATE_RED_POLISHED_WALL = BLOCKS.register("slate_red_polished_wall", () -> new WallBlock(Block.Properties.from(Blocks.STONE)));
	
	// basic building blocks
	public static final RegistryObject<Block> DIRT_SLAB = BLOCKS.register("dirt_slab", () -> new SlabBlock(Block.Properties.create(Material.EARTH)));
	public static final RegistryObject<Block> COARSE_DIRT_SLAB = BLOCKS.register("coarse_dirt_slab", () -> new SlabBlock(Block.Properties.create(Material.EARTH)));
	public static final RegistryObject<Block> DIRT_STAIRS = BLOCKS.register("dirt_stairs", () -> new StairsBlock(() -> Blocks.DIRT.getDefaultState(), Block.Properties.create(Material.EARTH, MaterialColor.DIRT)));
	public static final RegistryObject<Block> COARSE_DIRT_STAIRS = BLOCKS.register("coarse_dirt_stairs", () -> new StairsBlock(() -> Blocks.COARSE_DIRT.getDefaultState(), Block.Properties.create(Material.EARTH, MaterialColor.DIRT)));
	public static final RegistryObject<Block> COARSE_DIRT_STEP = BLOCKS.register("coarse_dirt_step", () -> new StepBlock(Block.Properties.create(Material.EARTH, MaterialColor.DIRT)));
	public static final RegistryObject<Block> DIRT_STEP = BLOCKS.register("dirt_step", () -> new StepBlock(Block.Properties.create(Material.EARTH, MaterialColor.DIRT)));
	public static final RegistryObject<Block> MUD = BLOCKS.register("mud", () -> new Block(Block.Properties.from(Blocks.DIRT)));
	public static final RegistryObject<Block> MUD_WET = BLOCKS.register("mud_wet", () -> new Block(Block.Properties.from(Blocks.DIRT)));
	
	public static final RegistryObject<Block> GRAVEL_SLAB = BLOCKS.register("gravel_slab", () -> new FallingSlabBlock(Block.Properties.create(Material.SAND)));
	public static final RegistryObject<Block> GRAVEL_STAIRS = BLOCKS.register("gravel_stairs", () -> new FallingStairBlock(() -> Blocks.GRAVEL.getDefaultState(), Block.Properties.create(Material.EARTH, MaterialColor.DIRT)));
	public static final RegistryObject<Block> SAND_SLAB = BLOCKS.register("sand_slab", () -> new FallingSlabBlock(Block.Properties.create(Material.SAND)));
	public static final RegistryObject<Block> SAND_STAIRS = BLOCKS.register("sand_stairs", () -> new FallingStairBlock(() -> Blocks.GRAVEL.getDefaultState(), Block.Properties.create(Material.EARTH, MaterialColor.DIRT)));
	
	// World Gen Trees
	// Lets put these in a loop?
	public static final RegistryObject<Block> WALNUT_PLANKS = BLOCKS.register("walnut_planks", () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> WALNUT_LOG = BLOCKS.register("walnut_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> WALNUT_LEAVES = BLOCKS.register("walnut_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> WALNUT_SAPLING = BLOCKS.register("walnut_sapling", () -> new ModSaplingBlock(() -> new WalnutTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> WALNUT_LEAVES_CARPET = BLOCKS.register("walnut_leaves_carpet", () -> new ModCarpetBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> WALNUT_PLANKS_SLAB = BLOCKS.register("walnut_planks_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> WALNUT_PLANKS_VERTICAL_SLAB = BLOCKS.register("walnut_planks_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> WALNUT_PLANKS_PLANKS_STAIRS = BLOCKS.register("walnut_planks_stairs", () -> new StairsBlock(() -> WALNUT_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> WALNUT_PLANKS_FENCE = BLOCKS.register("walnut_planks_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> WALNUT_PLANKS_BUTTON = BLOCKS.register("walnut_planks_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> WALNUT_PLANKS_PRESSURE_PLATE = BLOCKS.register("walnut_planks_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> WALNUT_PLANKS_STEP = BLOCKS.register("walnut_planks_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	
	public static final RegistryObject<Block> MAHOGANY_PLANKS = BLOCKS.register("mahogany_planks", () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> MAHOGANY_LOG = BLOCKS.register("mahogany_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> MAHOGANY_LEAVES = BLOCKS.register("mahogany_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> MAHOGANY_SAPLING = BLOCKS.register("mahogany_sapling", () -> new ModSaplingBlock(() -> new WalnutTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> MAHOGANY_LEAVES_CARPET = BLOCKS.register("mahogany_leaves_carpet", () -> new ModCarpetBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> MAHOGANY_PLANKS_SLAB = BLOCKS.register("mahogany_planks_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> MAHOGANY_PLANKS_VERTICAL_SLAB = BLOCKS.register("mahogany_planks_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> MAHOGANY_PLANKS_PLANKS_STAIRS = BLOCKS.register("mahogany_planks_stairs", () -> new StairsBlock(() -> WALNUT_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> MAHOGANY_PLANKS_FENCE = BLOCKS.register("mahogany_planks_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> MAHOGANY_PLANKS_BUTTON = BLOCKS.register("mahogany_planks_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> MAHOGANY_PLANKS_PRESSURE_PLATE = BLOCKS.register("mahogany_planks_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> MAHOGANY_PLANKS_STEP = BLOCKS.register("mahogany_planks_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	
	public static final RegistryObject<Block> FIR_PLANKS = BLOCKS.register("fir_planks", () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> FIR_LOG = BLOCKS.register("fir_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> FIR_LEAVES = BLOCKS.register("fir_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> FIR_SAPLING = BLOCKS.register("fir_sapling", () -> new ModSaplingBlock(() -> new WalnutTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> FIR_LEAVES_CARPET = BLOCKS.register("fir_leaves_carpet", () -> new ModCarpetBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> FIR_PLANKS_SLAB = BLOCKS.register("fir_planks_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> FIR_PLANKS_VERTICAL_SLAB = BLOCKS.register("fir_planks_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> FIR_PLANKS_PLANKS_STAIRS = BLOCKS.register("fir_planks_stairs", () -> new StairsBlock(() -> WALNUT_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> FIR_PLANKS_FENCE = BLOCKS.register("fir_planks_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> FIR_PLANKS_BUTTON = BLOCKS.register("fir_planks_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> FIR_PLANKS_PRESSURE_PLATE = BLOCKS.register("fir_planks_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> FIR_PLANKS_STEP = BLOCKS.register("fir_planks_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	
	public static final RegistryObject<Block> ANCIENT_TREE_PLANKS = BLOCKS.register("ancient_tree_planks", () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> ANCIENT_TREE_LOG = BLOCKS.register("ancient_tree_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> ANCIENT_TREE_LEAVES = BLOCKS.register("ancient_tree_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> ANCIENT_TREE_SAPLING = BLOCKS.register("ancient_tree_sapling", () -> new ModSaplingBlock(() -> new WalnutTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> ANCIENT_TREE_LEAVES_CARPET = BLOCKS.register("ancient_tree_leaves_carpet", () -> new ModCarpetBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> ANCIENT_TREE_PLANKS_SLAB = BLOCKS.register("ancient_tree_planks_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> ANCIENT_TREE_PLANKS_VERTICAL_SLAB = BLOCKS.register("ancient_tree_planks_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> ANCIENT_TREE_PLANKS_PLANKS_STAIRS = BLOCKS.register("ancient_tree_planks_stairs", () -> new StairsBlock(() -> WALNUT_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> ANCIENT_TREE_PLANKS_FENCE = BLOCKS.register("ancient_tree_planks_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> ANCIENT_TREE_PLANKS_BUTTON = BLOCKS.register("ancient_tree_planks_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> ANCIENT_TREE_PLANKS_PRESSURE_PLATE = BLOCKS.register("ancient_tree_planks_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> ANCIENT_TREE_PLANKS_STEP = BLOCKS.register("ancient_tree_planks_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	
	public static final RegistryObject<Block> PINE_PLANKS = BLOCKS.register("pine_planks", () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> PINE_LOG = BLOCKS.register("pine_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> PINE_LEAVES = BLOCKS.register("pine_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> PINE_SAPLING = BLOCKS.register("pine_sapling", () -> new ModSaplingBlock(() -> new WalnutTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> PINE_LEAVES_CARPET = BLOCKS.register("pine_leaves_carpet", () -> new ModCarpetBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> PINE_PLANKS_SLAB = BLOCKS.register("pine_planks_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> PINE_PLANKS_VERTICAL_SLAB = BLOCKS.register("pine_planks_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> PINE_PLANKS_PLANKS_STAIRS = BLOCKS.register("pine_planks_stairs", () -> new StairsBlock(() -> WALNUT_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> PINE_PLANKS_FENCE = BLOCKS.register("pine_planks_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> PINE_PLANKS_BUTTON = BLOCKS.register("pine_planks_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> PINE_PLANKS_PRESSURE_PLATE = BLOCKS.register("pine_planks_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> PINE_PLANKS_STEP = BLOCKS.register("pine_planks_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	
	public static final RegistryObject<Block> WENGE_PLANKS = BLOCKS.register("wenge_planks", () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> WENGE_LOG = BLOCKS.register("wenge_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> WENGE_LEAVES = BLOCKS.register("wenge_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> WENGE_SAPLING = BLOCKS.register("wenge_sapling", () -> new ModSaplingBlock(() -> new WalnutTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> WENGE_LEAVES_CARPET = BLOCKS.register("wenge_leaves_carpet", () -> new ModCarpetBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> WENGE_PLANKS_SLAB = BLOCKS.register("wenge_planks_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> WENGE_PLANKS_VERTICAL_SLAB = BLOCKS.register("wenge_planks_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> WENGE_PLANKS_PLANKS_STAIRS = BLOCKS.register("wenge_planks_stairs", () -> new StairsBlock(() -> WALNUT_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> WENGE_PLANKS_FENCE = BLOCKS.register("wenge_planks_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> WENGE_PLANKS_BUTTON = BLOCKS.register("wenge_planks_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> WENGE_PLANKS_PRESSURE_PLATE = BLOCKS.register("wenge_planks_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> WENGE_PLANKS_STEP = BLOCKS.register("wenge_planks_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	
	public static final RegistryObject<Block> WILLOW_PLANKS = BLOCKS.register("willow_planks", () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> WILLOW_LOG = BLOCKS.register("willow_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> WILLOW_LEAVES = BLOCKS.register("willow_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> WILLOW_SAPLING = BLOCKS.register("willow_sapling", () -> new ModSaplingBlock(() -> new WalnutTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> WILLOW_LEAVES_CARPET = BLOCKS.register("willow_leaves_carpet", () -> new ModCarpetBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> WILLOW_PLANKS_SLAB = BLOCKS.register("willow_planks_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> WILLOW_PLANKS_VERTICAL_SLAB = BLOCKS.register("willow_planks_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> WILLOW_PLANKS_PLANKS_STAIRS = BLOCKS.register("willow_planks_stairs", () -> new StairsBlock(() -> WALNUT_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> WILLOW_PLANKS_FENCE = BLOCKS.register("willow_planks_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> WILLOW_PLANKS_BUTTON = BLOCKS.register("willow_planks_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> WILLOW_PLANKS_PRESSURE_PLATE = BLOCKS.register("willow_planks_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> WILLOW_PLANKS_STEP = BLOCKS.register("willow_planks_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	
	public static final RegistryObject<Block> MAPLE_PLANKS = BLOCKS.register("maple_planks", () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> MAPLE_LOG = BLOCKS.register("maple_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> MAPLE_LEAVES = BLOCKS.register("maple_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> MAPLE_SAPLING = BLOCKS.register("maple_sapling", () -> new ModSaplingBlock(() -> new WalnutTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> MAPLE_LEAVES_CARPET = BLOCKS.register("maple_leaves_carpet", () -> new ModCarpetBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> MAPLE_PLANKS_SLAB = BLOCKS.register("maple_planks_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> MAPLE_PLANKS_VERTICAL_SLAB = BLOCKS.register("maple_planks_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> MAPLE_PLANKS_PLANKS_STAIRS = BLOCKS.register("maple_planks_stairs", () -> new StairsBlock(() -> WALNUT_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> MAPLE_PLANKS_FENCE = BLOCKS.register("maple_planks_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> MAPLE_PLANKS_BUTTON = BLOCKS.register("maple_planks_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> MAPLE_PLANKS_PRESSURE_PLATE = BLOCKS.register("maple_planks_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> MAPLE_PLANKS_STEP = BLOCKS.register("maple_planks_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	
	// Cherry Trees
	public static final RegistryObject<Block> CHERRY_PLANKS = BLOCKS.register("cherry_planks", () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> CHERRY_LOG = BLOCKS.register("cherry_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
	
	public static final RegistryObject<Block> CHERRY_WHITE_LEAVES = BLOCKS.register("cherry_white_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> CHERRY_WHITE_SAPLING = BLOCKS.register("cherry_white_sapling", () -> new ModSaplingBlock(() -> new WalnutTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> CHERRY_WHITE_LEAVES_CARPET = BLOCKS.register("cherry_white_leaves_carpet", () -> new ModCarpetBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> CHERRY_PINK_LEAVES = BLOCKS.register("cherry_pink_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> CHERRY_PINK_SAPLING = BLOCKS.register("cherry_pink_sapling", () -> new ModSaplingBlock(() -> new WalnutTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> CHERRY_PINK_LEAVES_CARPET = BLOCKS.register("cherry_pink_leaves_carpet", () -> new ModCarpetBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> CHERRY_PLANKS_SLAB = BLOCKS.register("cherry_planks_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> CHERRY_PLANKS_VERTICAL_SLAB = BLOCKS.register("cherry_planks_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> CHERRY_PLANKS_PLANKS_STAIRS = BLOCKS.register("cherry_planks_stairs", () -> new StairsBlock(() -> WALNUT_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> CHERRY_PLANKS_FENCE = BLOCKS.register("cherry_planks_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> CHERRY_PLANKS_BUTTON = BLOCKS.register("cherry_planks_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> CHERRY_PLANKS_PRESSURE_PLATE = BLOCKS.register("cherry_planks_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	public static final RegistryObject<Block> CHERRY_PLANKS_STEP = BLOCKS.register("cherry_planks_step", () -> new StepBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE)));
	
	// World Gen Ores
	public static final RegistryObject<Block> SMALL_MITHRAL_ORE = BLOCKS.register("small_mithral_ore", () -> new OreBlock(Block.Properties.from(Blocks.IRON_ORE)));
	public static final RegistryObject<Block> MITHRAL_ORE = BLOCKS.register("mithral_ore", () -> new OreBlock(Block.Properties.from(Blocks.IRON_ORE)));
	public static final RegistryObject<Block> SMALL_ADAMANTINE_ORE = BLOCKS.register("small_adamantine_ore", () -> new OreBlock(Block.Properties.from(Blocks.IRON_ORE)));
	public static final RegistryObject<Block> ADAMANTINE_ORE = BLOCKS.register("adamantine_ore", () -> new OreBlock(Block.Properties.from(Blocks.IRON_ORE)));
	public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", () -> new ModOreBlock(Block.Properties.from(Blocks.IRON_ORE)));
	public static final RegistryObject<Block> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore", () -> new ModOreBlock(Block.Properties.from(Blocks.IRON_ORE)));
	
	
}