package com.markwillisford.jpsbase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.markwillisford.jpsbase.init.BlockInit;
import com.markwillisford.jpsbase.init.BlockInitNew;
import com.markwillisford.jpsbase.init.FeatureInit;
import com.markwillisford.jpsbase.init.ItemInitNew;
import com.markwillisford.jpsbase.init.ModContainerTypes;
import com.markwillisford.jpsbase.init.ModTileEntityTypes;
import com.markwillisford.jpsbase.world.gen.OreGen;
import com.markwillisford.jpsbase.world.gen.TreeGen;

import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import top.theillusivec4.curios.api.imc.CurioIMCMessage;

@Mod("jpsbase")
@Mod.EventBusSubscriber(modid = JPsBase.MOD_ID, bus = Bus.MOD)
public class JPsBase
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "jpsbase";
    public static JPsBase instance;
    public static final ResourceLocation EXAMPLE_DIM_TYPE = new ResourceLocation(MOD_ID, "jpsbase");
    //public static final ResourceLocation EMPTY_BACKPACK_SLOT = new ResourceLocation("jpsbase", "item/empty_backpack_slot");
    //private static Field inventoryField;
    //private static Field containerField;
	private static boolean curiosLoaded = false;
    
    // https://www.planetminecraft.com/texture-pack/mizunos-16-craft/%3Ca%20href= ?
    
    public JPsBase() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	
        // Register the setup method for modloading
    	modEventBus.addListener(this::setup);
        // Register the doClientStuff method for modloading
    	modEventBus.addListener(this::doClientStuff);

    	ItemInitNew.ITEMS.register(modEventBus);
    	BlockInitNew.BLOCKS.register(modEventBus);
    	ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
    	ModContainerTypes.CONTAINER_TYPES.register(modEventBus);
    	// BiomeInit.BIOMES.register(modEventBus);    	
    	// DimensionInit.MOD_DIMENSIONS.register(modEventBus);
        FeatureInit.FEATURES.register(modEventBus);
        instance = this;
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);     
		curiosLoaded = ModList.get().isLoaded("curios"); 

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
    	// Item item = ItemInitNew.DEF_ITEM.get();
    	
    	LOGGER.debug("Registered BlockItems");
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
    
    // Player Inventory
    /*
     * Add an inventory slot
		Create model that renders on player
		create backback item
		texture backback
		crafting recipe
		hotkey B to open inventory
     */  
    
	private void onEnqueueIMC(InterModEnqueueEvent event) {
		if (curiosLoaded) {
			InterModComms.sendTo("curios", "register_type", () -> {
				return (new CurioIMCMessage("backpacked")).setSize(1);
			});
			InterModComms.sendTo("curios", "register_icon", () -> {
				return new Tuple("backpacked", new ResourceLocation("backpacked", "item/empty_backpack_slot"));
			});
		}
	}
    
    /*@SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void onPlayerRenderScreen(DrawBackground event) {
    	ContainerScreen screen = event.getGuiContainer();         
    	int left;         
    	int top;
    	
        if (screen instanceof InventoryScreen) {

           InventoryScreen inventoryScreen = (InventoryScreen)screen;
           left = inventoryScreen.getGuiLeft();
           top = inventoryScreen.getGuiTop();
           
           inventoryScreen.getMinecraft().getTextureManager().bindTexture(ContainerScreen.INVENTORY_BACKGROUND);		
           // func_110434_K().func_110577_a(ContainerScreen.field_147001_a);
           Screen.blit(left + 76, top + 43, 18, 18, 76.0F, 61.0F, 18, 18, 256, 256);

        } else if (screen instanceof CreativeScreen) {

           CreativeScreen creativeScreen = (CreativeScreen)screen;
           											// field_78036_m.func_78021_a()
           if (creativeScreen.getSelectedTabIndex() == ItemGroup.INVENTORY.getIndex()) {

              left = creativeScreen.getGuiLeft();
              top = creativeScreen.getGuiTop();
              creativeScreen.getMinecraft().getTextureManager().bindTexture(ContainerScreen.INVENTORY_BACKGROUND);
              Screen.blit(left + 126, top + 19, 18, 18, 76.0F, 61.0F, 18, 18, 256, 256);
           }}
    }*/
    
    /*@SuppressWarnings("deprecation")
	@SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void onTextureStitch(Pre event) {
    	if (event.getMap().getTextureLocation().equals(AtlasTexture.LOCATION_BLOCKS_TEXTURE)) {    
    		event.addSprite(EMPTY_BACKPACK_SLOT);
    	}
    }*/

    /*@SubscribeEvent
    public void onPlayerClone(Clone event) {
	    PlayerEntity oldPlayer = event.getOriginal();

	    //if (oldPlayer.inventory instanceof ExtendedPlayerInventory && event.getPlayer().inventory instanceof ExtendedPlayerInventory) {
	    //	((ExtendedPlayerInventory)event.getPlayer().inventory).copyBackpack((ExtendedPlayerInventory)oldPlayer.inventory);
	    //}
    }*/

    /*
    @SubscribeEvent
    public void onStartTracking(StartTracking event) {
    	PlayerEntity player = event.getPlayer();
    	if (player.inventory instanceof ExtendedPlayerInventory && !((ItemStack)((ExtendedPlayerInventory)player.inventory).getBackpackItems().get(0)).isEmpty()()) {
    		PacketHandler.instance.send(PacketDistributor.TRACKING_ENTITY.with(() -> {
    			return player;
	     	), new MessageUpdateBackpack(player.func_145782_y(), true));
    	}
	}
	*/
    
    /*
    @SubscribeEvent
    public void onPlayerTick(PlayerTickEvent event) {
      if (event.phase == Phase.START) {
         PlayerEntity player = event.player;
         if (!player.world.isRemote && player.inventory instanceof ExtendedPlayerInventory) {
            ExtendedPlayerInventory inventory = (ExtendedPlayerInventory)player.inventory;
            if (!((ItemStack)inventory.backpackArray.get(0)).equals(inventory.backpackInventory.get(0))) {
               PacketHandler.instance.send(PacketDistributor.TRACKING_ENTITY.with(() -> {
                  return player;
               }), new MessageUpdateBackpack(player.getEntityId(), !((ItemStack)inventory.backpackInventory.get(0)).isEmpty()));
               inventory.backpackArray.set(0, inventory.backpackInventory.get(0));
            }
         }

      }
    }
    */
    
    /*public static void onPlayerInit(PlayerEntity player) {
    	patchInventory(player);
	}*/

	/*private static void patchInventory(PlayerEntity player) {
		if (inventoryField == null) {
	    	inventoryField = getFieldAndSetAccessible(PlayerEntity.class, "inventory");
	    }
	
		if (containerField == null) {
			containerField = getFieldAndSetAccessible(PlayerEntity.class, "container");
	    }
	
	    try {
	    	ExtendedPlayerInventory inventory = new ExtendedPlayerInventory(player);
	    	inventoryField.set(player, inventory);
	    	ExtendedPlayerContainer container = new ExtendedPlayerContainer(inventory, !player.world.isRemote, player);
	    	containerField.set(player, container);
	    	player.openContainer = container;
	    } catch (IllegalAccessException var3) {
	    	var3.printStackTrace();
	    }
	}*/
	
	/*private static Field getFieldAndSetAccessible(Class clazz, String obfName) {
		Field field = ObfuscationReflectionHelper.findField(clazz, obfName);
		field.setAccessible(true);

	    try {
	    	Field modifiersField = Field.class.getDeclaredField("modifiers");
	    	modifiersField.setAccessible(true);
	    	modifiersField.setInt(field, field.getModifiers() & -17);
	    } catch (NoSuchFieldException | IllegalAccessException var4) {
	    	var4.printStackTrace();
	    }

	    return field;
	}*/
}
