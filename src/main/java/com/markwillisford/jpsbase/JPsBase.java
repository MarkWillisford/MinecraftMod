package com.markwillisford.jpsbase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.markwillisford.jpsbase.init.BlockInit;
import com.markwillisford.jpsbase.init.BlockInitNew;
import com.markwillisford.jpsbase.init.FeatureInit;
import com.markwillisford.jpsbase.init.ItemInitNew;
import com.markwillisford.jpsbase.world.gen.OreGen;
import com.markwillisford.jpsbase.world.gen.TreeGen;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("jpsbase")
@Mod.EventBusSubscriber(modid = JPsBase.MOD_ID, bus = Bus.MOD)
public class JPsBase
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "jpsbase";
    public static JPsBase instance;
    public static final ResourceLocation EXAMPLE_DIM_TYPE = new ResourceLocation(MOD_ID, "jpsbase");
    
    // https://www.planetminecraft.com/texture-pack/mizunos-16-craft/%3Ca%20href= ?
    
    public JPsBase() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	
        // Register the setup method for modloading
    	modEventBus.addListener(this::setup);
        // Register the doClientStuff method for modloading
    	modEventBus.addListener(this::doClientStuff);

    	ItemInitNew.ITEMS.register(modEventBus);
    	BlockInitNew.BLOCKS.register(modEventBus);
    	// ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
    	// BiomeInit.BIOMES.register(modEventBus);    	
    	// DimensionInit.MOD_DIMENSIONS.register(modEventBus);
        FeatureInit.FEATURES.register(modEventBus);
        instance = this;
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);      

    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
    	final IForgeRegistry<Item> registry = event.getRegistry();
    	
    	BlockInitNew.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
    		final Item.Properties properties = new Item.Properties().group(TutorialItemGroup.instance);
    		final BlockItem blockItem = new BlockItem(block, properties);
    		blockItem.setRegistryName(block.getRegistryName());
    		registry.register(blockItem);
    	});
    	
    	//Block block = BlockInitNew.DEF_ITEM.get();
    	Item item = ItemInitNew.DEF_ITEM.get();
    	
    	// LOGGER.debug("Registered BlockItems");
    }

    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
    	// BiomeInit.registerBiomes();
    }
    
    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        OreGen.generateOre();
        TreeGen.generateTrees();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        // LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
    
    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
    	OreGen.generateOre();
        TreeGen.generateTrees();
    }
    
    public static class TutorialItemGroup extends ItemGroup{
    	public static final TutorialItemGroup instance = new TutorialItemGroup(ItemGroup.GROUPS.length, "tutorialtab");
    	
    	private TutorialItemGroup(int index, String label) {
    		super(index, label);
    	}
    	
    	@Override
    	public ItemStack createIcon() {
    		return new ItemStack(BlockInit.example_block);
    	}
    }
}
