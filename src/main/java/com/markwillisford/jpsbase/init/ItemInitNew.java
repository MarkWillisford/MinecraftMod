package com.markwillisford.jpsbase.init;

import com.markwillisford.jpsbase.JPsBase;
import com.markwillisford.jpsbase.JPsBase.TutorialItemGroup;
import com.markwillisford.jpsbase.objects.items.SpecialItem;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInitNew {
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, JPsBase.MOD_ID);
	// public static final DeferredRegister<Item> VANILLA_ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, "minecraft");
	
	public static final RegistryObject<Item> DEF_ITEM = ITEMS.register("def_item", () -> new SpecialItem(new Item.Properties().group(TutorialItemGroup.instance)));

	/*public static final RegistryObject<Item> COBBLESTONE = VANILLA_ITEMS
			.register("cobblestone", () -> new SpecialItem(new Item.Properties().group(TutorialItemGroup.instance)));*/
}
