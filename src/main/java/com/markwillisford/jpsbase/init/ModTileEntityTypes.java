package com.markwillisford.jpsbase.init;

import com.markwillisford.jpsbase.JPsBase;
import com.markwillisford.jpsbase.tileentity.ExampleChestTileEntity;
import com.markwillisford.jpsbase.tileentity.QuarryTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(
			ForgeRegistries.TILE_ENTITIES, JPsBase.MOD_ID);

	public static final RegistryObject<TileEntityType<QuarryTileEntity>> QUARRY = TILE_ENTITY_TYPES
			.register("quarry", () -> TileEntityType.Builder
					.create(QuarryTileEntity::new, BlockInitNew.QUARRY.get())
					.build(null));

	public static final RegistryObject<TileEntityType<ExampleChestTileEntity>> EXAMPLE_CHEST = TILE_ENTITY_TYPES
			.register("example_chest", () -> TileEntityType.Builder
					.create(ExampleChestTileEntity::new, BlockInitNew.EXAMPLE_CHEST.get())
					.build(null));
}
