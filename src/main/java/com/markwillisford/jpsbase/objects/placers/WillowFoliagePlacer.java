package com.markwillisford.jpsbase.objects.placers;

import java.util.Random;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;

public class WillowFoliagePlacer extends FoliagePlacer {
	public static final Logger LOGGER = LogManager.getLogger();

	public WillowFoliagePlacer(int radius, int radiusPlusRand) {
		super(radius, radiusPlusRand, FoliagePlacerType.BLOB);
	}

	@Override
	public void func_225571_a_(IWorldGenerationReader p_225571_1_,
			Random p_225571_2_, TreeFeatureConfig p_225571_3_, int heigthOfLogs,
			int p_225571_5_, int p_225571_6_, BlockPos saplingLoc,
			Set<BlockPos> p_225571_8_) {

		LOGGER.info(
				"********************************************************************************");
		LOGGER.info(
				"********************************************************************************");
		LOGGER.info(
				"********************************************************************************");

		// 5 x 5 without corners
		for (int i = -2; i <= 2; i++) {
			if (i == -2 || i == 2) {
				threeLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc,
						heigthOfLogs, i);
			}
			if (i >= -1 && i <= 1) {
				fiveLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc,
						heigthOfLogs, i);
			}
		}
		// 7 x 7 without extended corners
		for (int i = -3; i <= 3; i++) {
			if (i == -3 || i == 3) {
				threeLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc,
						heigthOfLogs - 1, i);
			} else if (i == -2 || i == 2) {
				fiveLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc,
						heigthOfLogs - 1, i);
			} else {
				sevenLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc,
						heigthOfLogs - 1, i);
			}
		}

		// the droop
		// 9 x 9 without extended corners
		for (int i = -4; i <= 4; i++) {
			if (i == -4 || i == 4) {
				threeLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc,
						heigthOfLogs - 2, i);
			} else if (i == -3 || i == 3) {
				fiveLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc,
						heigthOfLogs - 2, i);
			} else if (i == -2 || i == 2) {
				sevenLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc,
						heigthOfLogs - 2, i);
			} else {
				nineLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc,
						heigthOfLogs - 2, i);
			}
		}

		/*
		 * for(int i=-4; i<=4;i++) { if(i==-4 || i==4) { threeLong(p_225571_1_,
		 * p_225571_2_, p_225571_3_, saplingLoc, heigthOfLogs-2, i); } else if
		 * (i == -3 || i == 3) { fiveLong(p_225571_1_, p_225571_2_, p_225571_3_,
		 * saplingLoc, heigthOfLogs-2, i); } else if(i == -2 || i == 2) {
		 * sevenLong(p_225571_1_, p_225571_2_, p_225571_3_, saplingLoc,
		 * heigthOfLogs-2, i); } else { // 3 x 3 off centered by +3 and -3
		 * for(int x = -1; x<=1; x++) { for(int z = -1; z<=1; z++) {
		 * p_225571_1_.setBlockState(saplingLoc.add(x, heigthOfLogs-2, z-3),
		 * p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc),
		 * 2); p_225571_1_.setBlockState(saplingLoc.add(x, heigthOfLogs-2, z+3),
		 * p_225571_3_.leavesProvider.getBlockState(p_225571_2_, saplingLoc),
		 * 2); } } } }
		 */

		// now the hanging branches // heigthOfLogs-3
		// out 4 left 1
		int[][] arr = {{-4, 1}, {-4, -1}, {4, 1}, {4, -1}, {-1, 4}, {-1, -4},
				{1, 4}, {1, -4}};
		int[][] arrRand = {{-3, 2}, {-3, -2}, {3, 2}, {3, -2}, {-2, 3},
				{-2, -3}, {2, 3}, {2, -3}};
		for (int i = 0; i < arr.length; i++) {
			p_225571_1_.setBlockState(
					saplingLoc.add(arr[i][0], heigthOfLogs - 3, arr[i][1]),
					p_225571_3_.leavesProvider.getBlockState(p_225571_2_,
							saplingLoc),
					2);
		}
		for (int i = 0; i < arrRand.length; i++) {
			if (Math.random() > 0.5) {
				p_225571_1_.setBlockState(
						saplingLoc.add(arr[i][0], heigthOfLogs - 3, arr[i][1]),
						p_225571_3_.leavesProvider.getBlockState(p_225571_2_,
								saplingLoc),
						2);
			}
		}

	}

	private void threeLong(IWorldGenerationReader p_225571_1_,
			Random p_225571_2_, TreeFeatureConfig p_225571_3_,
			BlockPos saplingLoc, int heigthOfLogs, int x) {
		for (int z = -1; z <= 1; z++) {
			p_225571_1_.setBlockState(saplingLoc.add(x, heigthOfLogs, z),
					p_225571_3_.leavesProvider.getBlockState(p_225571_2_,
							saplingLoc),
					2);
		}
	}

	private void fiveLong(IWorldGenerationReader p_225571_1_,
			Random p_225571_2_, TreeFeatureConfig p_225571_3_,
			BlockPos saplingLoc, int heigthOfLogs, int x) {
		for (int z = -2; z <= 2; z++) {
			p_225571_1_.setBlockState(saplingLoc.add(x, heigthOfLogs, z),
					p_225571_3_.leavesProvider.getBlockState(p_225571_2_,
							saplingLoc),
					2);
		}
	}

	private void sevenLong(IWorldGenerationReader p_225571_1_,
			Random p_225571_2_, TreeFeatureConfig p_225571_3_,
			BlockPos saplingLoc, int heigthOfLogs, int x) {
		for (int z = -3; z <= 3; z++) {
			p_225571_1_.setBlockState(saplingLoc.add(x, heigthOfLogs, z),
					p_225571_3_.leavesProvider.getBlockState(p_225571_2_,
							saplingLoc),
					2);
		}
	}

	private void nineLong(IWorldGenerationReader p_225571_1_,
			Random p_225571_2_, TreeFeatureConfig p_225571_3_,
			BlockPos saplingLoc, int heigthOfLogs, int x) {
		for (int z = -4; z <= 4; z++) {
			p_225571_1_.setBlockState(saplingLoc.add(x, heigthOfLogs, z),
					p_225571_3_.leavesProvider.getBlockState(p_225571_2_,
							saplingLoc),
					2);
		}
	}

	@Override
	public int func_225573_a_(Random p_225573_1_, int p_225573_2_,
			int p_225573_3_, TreeFeatureConfig p_225573_4_) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected boolean func_225572_a_(Random p_225572_1_, int p_225572_2_, int p_225572_3_, int p_225572_4_, int p_225572_5_, int p_225572_6_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int func_225570_a_(int p_225570_1_, int p_225570_2_, int p_225570_3_, int p_225570_4_) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void func_227384_a_(IWorldGenerationReader p_227384_1_,
			Random p_227384_2_, TreeFeatureConfig p_227384_3_, int p_227384_4_,
			BlockPos p_227384_5_, int p_227384_6_, int p_227384_7_,
			Set<BlockPos> p_227384_8_) {
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

		for (int i = -p_227384_7_; i <= p_227384_7_; ++i) {
			for (int j = -p_227384_7_; j <= p_227384_7_; ++j) {
				if (!this.func_225572_a_(p_227384_2_, p_227384_4_, i,
						p_227384_6_, j, p_227384_7_)) {
					blockpos$mutable.setPos(i + p_227384_5_.getX(),
							p_227384_6_ + p_227384_5_.getY(),
							j + p_227384_5_.getZ());
					this.func_227385_a_(p_227384_1_, p_227384_2_,
							blockpos$mutable, p_227384_3_, p_227384_8_);
				}
			}
		}
	}

	@Override
	protected void func_227385_a_(IWorldGenerationReader p_227385_1_,
			Random p_227385_2_, BlockPos p_227385_3_,
			TreeFeatureConfig p_227385_4_, Set<BlockPos> p_227385_5_) {
		if (AbstractTreeFeature.isAirOrLeaves(p_227385_1_, p_227385_3_)
				|| AbstractTreeFeature.isTallPlants(p_227385_1_, p_227385_3_)
				|| AbstractTreeFeature.isWater(p_227385_1_, p_227385_3_)) {
			p_227385_1_.setBlockState(p_227385_3_, p_227385_4_.leavesProvider
					.getBlockState(p_227385_2_, p_227385_3_), 19);
			p_227385_5_.add(p_227385_3_.toImmutable());
		}

	}

	@Override
	public <T> T serialize(DynamicOps<T> p_218175_1_) {
		Builder<T, T> builder = ImmutableMap.builder();
		builder.put(p_218175_1_.createString("type"),
				p_218175_1_.createString(Registry.FOLIAGE_PLACER_TYPE
						.getKey(this.field_227383_c_).toString()))
				.put(p_218175_1_.createString("radius"),
						p_218175_1_.createInt(this.field_227381_a_))
				.put(p_218175_1_.createString("radius_random"),
						p_218175_1_.createInt(this.field_227382_b_));
		return (new Dynamic<>(p_218175_1_,
				p_218175_1_.createMap(builder.build()))).getValue();
	}
}
