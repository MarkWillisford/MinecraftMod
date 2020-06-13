package com.markwillisford.jpsbase.objects.blocks;

import java.util.Random;

import com.markwillisford.jpsbase.init.BlockInitNew;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

public class ModOreBlock extends OreBlock{

	public ModOreBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	protected int getExperience(Random random) {
		if(this == BlockInitNew.RUBY_ORE.get()) {
	    	return MathHelper.nextInt(random, 2, 6);
		} else {
			return MathHelper.nextInt(random, 2, 6);
		}
	}
}
