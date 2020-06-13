package com.markwillisford.jpsbase.events;

import com.markwillisford.jpsbase.JPsBase;

import net.minecraft.entity.EntityClassification;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent.CheckSpawn;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = JPsBase.MOD_ID, bus = Bus.FORGE)
public class TestJumpEvent {
	@SubscribeEvent
	public static void testEvent(LivingSpawnEvent.CheckSpawn event) {
	//public static void testEvent(CheckSpawn event) {
		double x = event.getEntity().getPosX();
		double y = event.getEntity().getPosY();
		double z = event.getEntity().getPosZ();
		String entityString = event.getEntity().getEntityString();
		EntityClassification entityClassification = event.getEntity().getClassification(false);
		
		if(entityClassification == EntityClassification.MONSTER) {
			// okay, now I know when a monster tries to spawn
			JPsBase.LOGGER.info("********************************************************");
			JPsBase.LOGGER.info("testEvent fired");
			JPsBase.LOGGER.info(entityString + " spawn at:");
			JPsBase.LOGGER.info("x: " + x);
			JPsBase.LOGGER.info("y: " + y);
			JPsBase.LOGGER.info("z: " + z);
			JPsBase.LOGGER.info(entityString + " is a:" + entityClassification + "!!  DENYING!");
			// and this stops the spawn
			event.setResult(Result.DENY);
		}
		/*
		LivingEntity livingEntity = event.getEntityLiving();
		World world = livingEntity.getEntityWorld();
		world.setBlockState(livingEntity.getPosition().add(0, 5, 0), BlockInit.example_block.getDefaultState());
		livingEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 600, 255));
		livingEntity.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5000, 255));
		*/
	}
}
