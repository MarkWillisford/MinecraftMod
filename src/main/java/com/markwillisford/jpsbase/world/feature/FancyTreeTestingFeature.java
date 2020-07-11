package com.markwillisford.jpsbase.world.feature;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.LogBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class FancyTreeTestingFeature extends AbstractTreeFeature<TreeFeatureConfig> {
	public FancyTreeTestingFeature(Function<Dynamic<?>, ? extends TreeFeatureConfig> p_i225803_1_) {
		super(p_i225803_1_);
	}
	public static final Logger LOGGER = LogManager.getLogger();

	private void placeLeaves(IWorldGenerationReader p_227233_1_,
			Random p_227233_2_, BlockPos p_227233_3_, float p_227233_4_,
			Set<BlockPos> p_227233_5_, MutableBoundingBox p_227233_6_,
			TreeFeatureConfig p_227233_7_) {
		/*int i = (int) ((double) p_227233_4_ + 0.618D);

		for (int j = -i; j <= i; ++j) {
			for (int k = -i; k <= i; ++k) {
				if (Math.pow((double) Math.abs(j) + 0.5D, 2.0D)
						+ Math.pow((double) Math.abs(k) + 0.5D,
								2.0D) <= (double) (p_227233_4_ * p_227233_4_)) {
					this.setLeaf(p_227233_1_, p_227233_2_,
							p_227233_3_.add(j, 0, k), p_227233_5_, p_227233_6_,
							p_227233_7_);
				}
			}
		}*/

	}

	private float func_227231_a_(int i, int i1) {
		LOGGER.info("in math function: i: " + i + ", i1: " + i1 );
		if ((float) i1 < (float) i * 0.3F) {
			return -1.0F;
		} else {
			float f = (float) i / 2.0F;
			float f1 = f - (float) i1;
			float f2 = MathHelper.sqrt(f * f - f1 * f1);
			if (f1 == 0.0F) {
				f2 = f;
			} else if (Math.abs(f1) >= f) {
				return 0.0F;
			}

			return f2 * 0.5F;
		}
	}

	private float func_227230_a_(int p_227230_1_) {
		if (p_227230_1_ >= 0 && p_227230_1_ < 5) {
			return p_227230_1_ != 0 && p_227230_1_ != 4 ? 3.0F : 2.0F;
		} else {
			return -1.0F;
		}
	}

	private void func_227236_a_(IWorldGenerationReader p_227236_1_,
			Random p_227236_2_, BlockPos p_227236_3_, Set<BlockPos> p_227236_4_,
			MutableBoundingBox p_227236_5_, TreeFeatureConfig p_227236_6_) {
		for (int i = 0; i < 5; ++i) {
			this.placeLeaves(p_227236_1_, p_227236_2_, p_227236_3_.up(i),
					this.func_227230_a_(i), p_227236_4_, p_227236_5_,
					p_227236_6_);
		}

	}
	
	private int makeBranch(IWorldGenerationReader generationReader,
			Random rand, BlockPos saplingLoc, BlockPos saplingLocAddRandom4to15,
			boolean TorF, Set<BlockPos> setPos1,
			MutableBoundingBox boundingBoxIn, TreeFeatureConfig configIn) {
		if (!TorF && Objects.equals(saplingLoc, saplingLocAddRandom4to15)) {
			return -1;		// fails, probably on an error of some kind, edge case?
		} else {
			LOGGER.info("in makeBranch func ");
			LOGGER.info("TorF " + TorF);
			LOGGER.info("saplingLocAddRandom4to15 " + saplingLocAddRandom4to15);
			LOGGER.info("saplingLoc " + saplingLoc);			
			BlockPos blockpos = saplingLocAddRandom4to15.add(-saplingLoc.getX(),
					-saplingLoc.getY(), -saplingLoc.getZ());
			LOGGER.info("blockpos " + blockpos);	
			
			int i = this.getHighestAbsoluteValue(blockpos);		// highest int value difference between sapling and random location
			LOGGER.info("i " + i);				
			float f = (float) blockpos.getX() / (float) i;	
			LOGGER.info("blockpos.getX() " + blockpos.getX());				
			LOGGER.info("/i " + i + " =");				
			LOGGER.info("f(x float) " + f);				
			float f1 = (float) blockpos.getY() / (float) i;
			LOGGER.info("blockpos.getY() " + blockpos.getY());				
			LOGGER.info("/i " + i + " =");				
			LOGGER.info("f1(y float) " + f1);	
			float f2 = (float) blockpos.getZ() / (float) i;
			LOGGER.info("blockpos.getZ() " + blockpos.getZ());				
			LOGGER.info("/i " + i + " =");				
			LOGGER.info("f2(z float) " + f2);	

			// for each differant value between sap and randLoc
			// create a pos that adds .5 + the diff multiplied by the divions above.
			for (int j = 0; j <= i; ++j) {
				BlockPos blockpos1 = saplingLoc.add(
						(double) (0.5F + (float) j * f),
						(double) (0.5F + (float) j * f1),
						(double) (0.5F + (float) j * f2));
				LOGGER.info("new pos " + blockpos1);	
				if (TorF) {
					LOGGER.info("is true; setting blockstate and adding to setPos1");		
					this.setBlockState(generationReader, blockpos1,
							configIn.trunkProvider
									.getBlockState(rand, blockpos1)
									.with(LogBlock.AXIS, this.func_227238_a_(
											saplingLoc, blockpos1)),
									boundingBoxIn);
					setPos1.add(blockpos1);
				} else if (!canBeReplacedByLogs(generationReader, blockpos1)) {
					LOGGER.info("can't be replaced by logs, returning: " + j);						
					return j;
				}
			}

			LOGGER.info("reached end, returning: -1");	
			return -1;
		}
	}

	private int getHighestAbsoluteValue(BlockPos p_227237_1_) {
		int x = MathHelper.abs(p_227237_1_.getX());
		int y = MathHelper.abs(p_227237_1_.getY());
		int z = MathHelper.abs(p_227237_1_.getZ());
		if (z > x && z > y) {
			return z;
		} else {
			return y > x ? y : x;
		}
	}

	private Direction.Axis func_227238_a_(BlockPos p_227238_1_,
			BlockPos p_227238_2_) {
		Direction.Axis direction$axis = Direction.Axis.Y;
		int i = Math.abs(p_227238_2_.getX() - p_227238_1_.getX());
		int j = Math.abs(p_227238_2_.getZ() - p_227238_1_.getZ());
		int k = Math.max(i, j);
		if (k > 0) {
			if (i == k) {
				direction$axis = Direction.Axis.X;
			} else if (j == k) {
				direction$axis = Direction.Axis.Z;
			}
		}

		return direction$axis;
	}

	private void func_227232_a_(IWorldGenerationReader p_227232_1_,
			Random p_227232_2_, int p_227232_3_, BlockPos p_227232_4_,
			List<FancyTreeTestingFeature.ExtendedPos> p_227232_5_,
			Set<BlockPos> p_227232_6_, MutableBoundingBox p_227232_7_,
			TreeFeatureConfig p_227232_8_) {
		/*for (FancyTreeTestingFeature.ExtendedPos fancytreefeature$extendedpos : p_227232_5_) {
			if (this.func_227239_b_(p_227232_3_,
					fancytreefeature$extendedpos.getIntToAdd()
							- p_227232_4_.getY())) {
				this.func_227236_a_(p_227232_1_, p_227232_2_,
						fancytreefeature$extendedpos, p_227232_6_, p_227232_7_,
						p_227232_8_);
			}
		}*/

	}

	private boolean func_227239_b_(int p_227239_1_, int p_227239_2_) {
		return (double) p_227239_2_ >= (double) p_227239_1_ * 0.2D;
	}

	private void func_227234_a_(IWorldGenerationReader p_227234_1_,
			Random p_227234_2_, BlockPos p_227234_3_, int p_227234_4_,
			Set<BlockPos> p_227234_5_, MutableBoundingBox p_227234_6_,
			TreeFeatureConfig p_227234_7_) {
		this.makeBranch(p_227234_1_, p_227234_2_, p_227234_3_,
				p_227234_3_.up(p_227234_4_), true, p_227234_5_, p_227234_6_,
				p_227234_7_);
	}

	private void func_227240_b_(IWorldGenerationReader p_227240_1_,
			Random p_227240_2_, int p_227240_3_, BlockPos p_227240_4_,
			List<FancyTreeTestingFeature.ExtendedPos> p_227240_5_,
			Set<BlockPos> p_227240_6_, MutableBoundingBox p_227240_7_,
			TreeFeatureConfig p_227240_8_) {
		for (FancyTreeTestingFeature.ExtendedPos fancytreefeature$extendedpos : p_227240_5_) {
			int i = fancytreefeature$extendedpos.getIntToAdd();
			BlockPos blockpos = new BlockPos(p_227240_4_.getX(), i,
					p_227240_4_.getZ());
			if (!blockpos.equals(fancytreefeature$extendedpos) && this
					.func_227239_b_(p_227240_3_, i - p_227240_4_.getY())) {
				this.makeBranch(p_227240_1_, p_227240_2_, blockpos,
						fancytreefeature$extendedpos, true, p_227240_6_,
						p_227240_7_, p_227240_8_);
			}
		}

	}

	/**
	 * Called when placing the tree feature.
	 */
	public boolean place(IWorldGenerationReader generationReader, Random rand,
			BlockPos saplingLoc, Set<BlockPos> p_225557_4_,
			Set<BlockPos> p_225557_5_, MutableBoundingBox boundingBoxIn,
			TreeFeatureConfig configIn) {
        LOGGER.info( "********************************************************************************" );
        LOGGER.info( "********************************************************************************" );
        LOGGER.info( "********************************************************************************" );
		LOGGER.info("in place()");
		LOGGER.info("generationReader " + generationReader);		// 
		LOGGER.info("rand " + rand);		// 
		LOGGER.info("MutableBoundingBox " + boundingBoxIn);		// 
		LOGGER.info("saplingLoc " + saplingLoc);		// Sapling Pos
		LOGGER.info("p_225557_4_ " + p_225557_4_);
		LOGGER.info("p_225557_5_ " + p_225557_5_);
		
		Random random = new Random(rand.nextLong());
		int i = this.func_227241_b_(generationReader, rand, saplingLoc,
				5 + random.nextInt(12), p_225557_4_, boundingBoxIn, configIn);		// random num 5 to 16
		LOGGER.info("back in place(), i is: " + i);
		if (i == -1) {
			return false;
		} else {
			this.setDirt(generationReader, saplingLoc.down());
			int j = (int) ((double) i * 0.618D);
			LOGGER.info("set j: " + j);
			if (j >= i) {
				j = i - 1;
				LOGGER.info("j is larger than i, reducing to: " + j);
			}

			double d0 = 1.0D;
			int k = (int) (1.382D + Math.pow(1.0D * (double) i / 13.0D, 2.0D));
			LOGGER.info("setting k to i (" + i + ")" + " /13 to the 2nd power");
			LOGGER.info("1.0D * (double) i / 13.0D: " + 1.0D * (double) i / 13.0D);
			if (k < 1) {
				k = 1;
				LOGGER.info("k is too small, resetting to " + k);
			}

			int l = saplingLoc.getY() + j;
			LOGGER.info("l = saplings y level + j " + l);
			int i1 = i - 5;
			LOGGER.info("i1 = i - 5 " + i1);
			List<FancyTreeTestingFeature.ExtendedPos> list = Lists.newArrayList();
			list.add(new FancyTreeTestingFeature.ExtendedPos(saplingLoc.up(i1), l));

			// start at i1 (or i - 5) and count down to 0
			for (; i1 >= 0; --i1) {
				float f = this.func_227231_a_(i, i1);
				LOGGER.info("float f after math function: " + f);
				if (!(f < 0.0F)) {
					LOGGER.info("if is not less than 0 ");
					for (int j1 = 0; j1 < k; ++j1) {
						double d1 = 1.0D;
						double d2 = 1.0D * (double) f
								* ((double) random.nextFloat() + 0.328D);
						double d3 = (double) (random.nextFloat() * 2.0F)
								* Math.PI;
						double d4 = d2 * Math.sin(d3) + 0.5D;
						double d5 = d2 * Math.cos(d3) + 0.5D;
						BlockPos blockpos = saplingLoc.add(d4,
								(double) (i1 - 1), d5);
						BlockPos blockpos1 = blockpos.up(5);
						if (this.makeBranch(generationReader, rand, blockpos,
								blockpos1, false, p_225557_4_, boundingBoxIn,
								configIn) == -1) {
							int k1 = saplingLoc.getX() - blockpos.getX();
							int l1 = saplingLoc.getZ() - blockpos.getZ();
							double d6 = (double) blockpos.getY()
									- Math.sqrt((double) (k1 * k1 + l1 * l1))
											* 0.381D;
							int i2 = d6 > (double) l ? l : (int) d6;
							BlockPos blockpos2 = new BlockPos(saplingLoc.getX(),
									i2, saplingLoc.getZ());
							if (this.makeBranch(generationReader, rand,
									blockpos2, blockpos, false, p_225557_4_,
									boundingBoxIn, configIn) == -1) {
								list.add(new FancyTreeTestingFeature.ExtendedPos(
										blockpos, blockpos2.getY()));
							}
						}
					}
				}
			}

			for(int r=0;r<list.size();r++) {
				LOGGER.info("list[r] " + list.get(r));
			}
			Iterator<BlockPos> it = p_225557_4_.iterator();
		     while(it.hasNext()){
		    	 LOGGER.info("p_225557_4_[r] " + it.next());
		     }
			this.func_227232_a_(generationReader, rand, i, saplingLoc, list,
					p_225557_5_, boundingBoxIn, configIn);
			this.func_227234_a_(generationReader, rand, saplingLoc, j,
					p_225557_4_, boundingBoxIn, configIn);
			this.func_227240_b_(generationReader, rand, i, saplingLoc, list,
					p_225557_4_, boundingBoxIn, configIn);
			return true;
		}
	}

	private int func_227241_b_(IWorldGenerationReader generationReader,
			Random rand, BlockPos saplingLoc, int randomInt5to16,
			Set<BlockPos> p_227241_5_, MutableBoundingBox boundingBoxIn,
			TreeFeatureConfig configIn) {
		if (!isDirtOrGrassBlockOrFarmland(generationReader, saplingLoc.down())) {
			return -1;		// if the sapling is not on dirt or farmland, return -1 
		} else {
			LOGGER.info("in 1st func, calling makeBranch");
			int i = this.makeBranch(generationReader, rand, saplingLoc,
					saplingLoc.up(randomInt5to16 - 1), false, p_227241_5_,
					boundingBoxIn, configIn);

			LOGGER.info("back in 1st func, i is: " + i);
			if (i == -1) {
				LOGGER.info("returning: " + randomInt5to16);
				return randomInt5to16;
			} else {
				LOGGER.info("returning: -1 or " + i + " if above 6");
				return i < 6 ? -1 : i;
			}
		}
	}

	static class ExtendedPos extends BlockPos {
		private final int intToAdd;

		public ExtendedPos(BlockPos posIn, int intToAdd) {
			super(posIn.getX(), posIn.getY(),
					posIn.getZ());
			this.intToAdd = intToAdd;
		}

		public int getIntToAdd() {
			return this.intToAdd;
		}
	}
}