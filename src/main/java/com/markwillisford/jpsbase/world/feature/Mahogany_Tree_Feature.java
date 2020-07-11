package com.markwillisford.jpsbase.world.feature;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.markwillisford.jpsbase.world.feature.Mahogany_Tree_Feature.Tree.Node;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.LogBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractSmallTreeFeature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class Mahogany_Tree_Feature extends AbstractSmallTreeFeature<TreeFeatureConfig> {
	public Mahogany_Tree_Feature(Function<Dynamic<?>, ? extends TreeFeatureConfig> p_i225820_1_) {
		super(p_i225820_1_);
	}
	public static final Logger LOGGER = LogManager.getLogger();

	public boolean place(IWorldGenerationReader generationReader, Random rand,
			BlockPos positionIn, Set<BlockPos> p_225557_4_,
			Set<BlockPos> p_225557_5_, MutableBoundingBox boundingBoxIn,
			TreeFeatureConfig configIn) {
		int i = configIn.baseHeight + rand.nextInt(configIn.heightRandA + 1)
				+ rand.nextInt(configIn.heightRandB + 1);
		int j = configIn.trunkHeight >= 0
				? configIn.trunkHeight
						+ rand.nextInt(configIn.trunkHeightRandom + 1)
				: i - (configIn.foliageHeight
						+ rand.nextInt(configIn.foliageHeightRandom + 1));
		int k = configIn.foliagePlacer.func_225573_a_(rand, j, i, configIn);
		Optional<BlockPos> optional = this.func_227212_a_(generationReader, i,
				j, k, positionIn, configIn);
		if (!optional.isPresent()) {
			return false;
		} else {
			BlockPos blockpos = optional.get();
			this.setDirtAt(generationReader, blockpos.down(), blockpos);
			configIn.foliagePlacer.func_225571_a_(generationReader, rand, configIn, i, j, k, blockpos, p_225557_5_);
			this.buildTrunk(generationReader, rand, i, blockpos, configIn.trunkTopOffset + 
					rand.nextInt(configIn.trunkTopOffsetRandom + 1), p_225557_4_, boundingBoxIn, configIn);
			return true;
		}
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	protected void buildTrunk(IWorldGenerationReader generationReader, Random rand, int maxHeight, BlockPos p_227213_4_, int trunkTopOffsetAndRand,
			Set<BlockPos> p_227213_6_, MutableBoundingBox p_227213_7_, TreeFeatureConfig treeConfig) {
		int mainTrunk = (int) ((maxHeight - trunkTopOffsetAndRand)*.6);
		int secondTrunks = maxHeight - trunkTopOffsetAndRand - mainTrunk;
		BlockPos mainSplit = p_227213_4_.up(mainTrunk);
		
		// Main trunk
		for (int i = 0; i <= mainTrunk; i++) {
			this.setLog(generationReader, rand, p_227213_4_.up(i), p_227213_6_, p_227213_7_, treeConfig);	
		}
		
		// Secondary Trunks, I would love to move this to a loop for ease of readability
		this.setBlockState(generationReader, mainSplit.add(1,0,0), treeConfig.trunkProvider.getBlockState(rand, mainSplit.add(1,0,0)).with(LogBlock.AXIS, this.func_227238_a_(mainSplit, mainSplit.add(1,0,0))), p_227213_7_);
		/*for(int i = 0; i <= secondTrunks; i++) {
			if(i <= secondTrunks/2) {
				this.setLog(generationReader, rand, mainSplit.add(2,i+1,0), p_227213_6_, p_227213_7_, treeConfig);			
			} else {
				this.setLog(generationReader, rand, mainSplit.add(3,i+1,0), p_227213_6_, p_227213_7_, treeConfig);
			}
		}		
		this.setBlockState(generationReader, mainSplit.add(3,secondTrunks+1,1), treeConfig.trunkProvider.getBlockState(rand, mainSplit.add(2,3,1)).with(LogBlock.AXIS, this.func_227238_a_(mainSplit.add(2,3,0), mainSplit.add(2,3,1))), p_227213_7_);
		this.setBlockState(generationReader, mainSplit.add(3,secondTrunks+1,-1), treeConfig.trunkProvider.getBlockState(rand, mainSplit.add(2,3,-1)).with(LogBlock.AXIS, this.func_227238_a_(mainSplit.add(2,3,0), mainSplit.add(2,3,-1))), p_227213_7_);
		*/
		this.setBlockState(generationReader, mainSplit.add(-1,0,0), treeConfig.trunkProvider.getBlockState(rand, mainSplit.add(-1,0,0)).with(LogBlock.AXIS, this.func_227238_a_(mainSplit, mainSplit.add(-1,0,0))), p_227213_7_);
		/*for(int i = 0; i <= secondTrunks; i++) {
			if(i <= secondTrunks/2) {
				this.setLog(generationReader, rand, mainSplit.add(-2,i+1,0), p_227213_6_, p_227213_7_, treeConfig);			
			} else {
				this.setLog(generationReader, rand, mainSplit.add(-3,i+1,0), p_227213_6_, p_227213_7_, treeConfig);
			}
		}
		this.setBlockState(generationReader, mainSplit.add(-3,secondTrunks+1,1), treeConfig.trunkProvider.getBlockState(rand, mainSplit.add(2,3,1)).with(LogBlock.AXIS, this.func_227238_a_(mainSplit.add(2,3,0), mainSplit.add(2,3,1))), p_227213_7_);
		this.setBlockState(generationReader, mainSplit.add(-3,secondTrunks+1,-1), treeConfig.trunkProvider.getBlockState(rand, mainSplit.add(2,3,-1)).with(LogBlock.AXIS, this.func_227238_a_(mainSplit.add(2,3,0), mainSplit.add(2,3,-1))), p_227213_7_);
		*/
		this.setBlockState(generationReader, mainSplit.add(0,0,1), treeConfig.trunkProvider.getBlockState(rand, mainSplit.add(0,0,1)).with(LogBlock.AXIS, this.func_227238_a_(mainSplit, mainSplit.add(0,0,-1))), p_227213_7_);
		/*for(int i = 0; i <= secondTrunks; i++) {
			if(i <= secondTrunks/2) {
				this.setLog(generationReader, rand, mainSplit.add(0,i+1,2), p_227213_6_, p_227213_7_, treeConfig);			
			} else {
				this.setLog(generationReader, rand, mainSplit.add(0,i+1,3), p_227213_6_, p_227213_7_, treeConfig);
			}
		}
		this.setBlockState(generationReader, mainSplit.add(1,secondTrunks+1,3), treeConfig.trunkProvider.getBlockState(rand, mainSplit.add(2,3,1)).with(LogBlock.AXIS, this.func_227238_a_(mainSplit.add(2,3,0), mainSplit.add(2,3,1))), p_227213_7_);
		this.setBlockState(generationReader, mainSplit.add(-1,secondTrunks+1,3), treeConfig.trunkProvider.getBlockState(rand, mainSplit.add(2,3,-1)).with(LogBlock.AXIS, this.func_227238_a_(mainSplit.add(2,3,0), mainSplit.add(2,3,-1))), p_227213_7_);
		*/
		this.setBlockState(generationReader, mainSplit.add(0,0,-1), treeConfig.trunkProvider.getBlockState(rand, mainSplit.add(0,0,-1)).with(LogBlock.AXIS, this.func_227238_a_(mainSplit, mainSplit.add(0,0,-1))), p_227213_7_);
		/*for(int i = 0; i <= secondTrunks; i++) {
			if(i <= secondTrunks/2) {
				this.setLog(generationReader, rand, mainSplit.add(0,i+1,-2), p_227213_6_, p_227213_7_, treeConfig);			
			} else {
				this.setLog(generationReader, rand, mainSplit.add(0,i+1,-3), p_227213_6_, p_227213_7_, treeConfig);
			}
		}
		this.setBlockState(generationReader, mainSplit.add(1,secondTrunks+1,-3), treeConfig.trunkProvider.getBlockState(rand, mainSplit.add(2,3,1)).with(LogBlock.AXIS, this.func_227238_a_(mainSplit.add(2,3,0), mainSplit.add(2,3,1))), p_227213_7_);
		this.setBlockState(generationReader, mainSplit.add(-1,secondTrunks+1,-3), treeConfig.trunkProvider.getBlockState(rand, mainSplit.add(2,3,-1)).with(LogBlock.AXIS, this.func_227238_a_(mainSplit.add(2,3,0), mainSplit.add(2,3,-1))), p_227213_7_);  
		*/
		// building branch shape
		Tree<String> tree = new Tree<>();
		tree.addRoot("base");
		Node node1 = tree.getRoot();
		// branch log 1
		Node node21 = tree.addNode("L", node1);
		Node node22 = tree.addNode("C", node1);
		Node node23 = tree.addNode("R", node1);

		// branch log 2
		Node node31 = tree.addNode("OOLL", node21);
		Node node32 = tree.addNode("OOLLU", node21);
		Node node33 = tree.addNode("OOL", node22, node21);
		Node node34 = tree.addNode("OOLU", node22, node21);
		Node node35 = tree.addNode("OO", node22);
		Node node36 = tree.addNode("OOU", node22);
		Node node37 = tree.addNode("OOR", node22, node23);
		Node node38 = tree.addNode("OORU", node22, node23);
		Node node39 = tree.addNode("OORR", node23);
		Node node310 = tree.addNode("OORRU", node23);		

		// branch log 3
		Node node41 = tree.addNode("OOLLLUU", node32);
		Node node42 = tree.addNode("OOOLLLUU", node32);
		Node node43 = tree.addNode("OOOLLUU", node32);
		Node node44 = tree.addNode("OOLLLD", node31);
		Node node45 = tree.addNode("OOOLLLD", node31);
		Node node46 = tree.addNode("OOOLLD", node31);
		
		Node node47 = tree.addNode("OORRRUU", node310);
		Node node48 = tree.addNode("OOORRRUU", node310);
		Node node49 = tree.addNode("OOORRUU", node310);
		Node node410 = tree.addNode("OORRRD", node39);
		Node node411 = tree.addNode("OOORRRD", node39);
		Node node412 = tree.addNode("OOORRD", node39);
		
		Node node413 = tree.addNode("OOLLL", node31,node32);
		Node node414 = tree.addNode("OOOLLL", node31,node32);
		Node node415 = tree.addNode("OOOLL", node31,node32,node33,node34 );
		Node node416 = tree.addNode("OOLLLU", node31,node32);
		Node node417 = tree.addNode("OOOLLLU", node31,node32);
		Node node418 = tree.addNode("OOOLLU", node31,node32,node33,node34 );
		Node node419 = tree.addNode("OOOL", node33,node34,node35,node36);
		Node node420 = tree.addNode("OOOLU", node33,node34,node35,node36);
		Node node421 = tree.addNode("OOOLD", node33,node35);
		Node node422 = tree.addNode("OOOLUU", node34,node36);

		Node node423 = tree.addNode("OORRR", node39,node310);
		Node node424 = tree.addNode("OOORRR", node39,node310);
		Node node425 = tree.addNode("OOORR", node39,node310,node37,node38 );
		Node node426 = tree.addNode("OORRRU", node39,node310);
		Node node427 = tree.addNode("OOORRRU", node39,node310);
		Node node428 = tree.addNode("OOORRU", node39,node310,node37,node38 );
		Node node429 = tree.addNode("OOOR", node37,node38,node35,node36);
		Node node430 = tree.addNode("OOORU", node37,node38,node35,node36);
		Node node431 = tree.addNode("OOORD", node37,node35);
		Node node432 = tree.addNode("OOORUU", node38,node36);

		Node node433 = tree.addNode("OOO", node33,node34,node35,node36,node37,node38);
		Node node434 = tree.addNode("OOOD", node33,node35,node37);
		Node node435 = tree.addNode("OOOU", node33,node34,node35,node36,node37,node38);
		Node node436 = tree.addNode("OOOUU", node34,node36,node38);
		
        LOGGER.info( "********************************************************************************" );
        LOGGER.info( "********************************************************************************" );
        LOGGER.info( "********************************************************************************" );
		LOGGER.info(node1.children);
		LOGGER.info(node1.children.size());		
		
		for(int dir=0;dir<4;dir++) {
			if(dir == 0) {			// N
				// mainSplit.add(0,0,-1)
				BlockPos base = mainSplit.add(0,0,-1);
				for(int i = 0;i<3;i++) {
					int randDir = ThreadLocalRandom.current().nextInt(0, 3);
					if(randDir == 0) {
						this.setBlockState(generationReader, base.add(1,0,-1), treeConfig.trunkProvider.getBlockState(rand, base.add(1,0,-1)).with(LogBlock.AXIS, this.func_227238_a_(base, base.add(1,0,-1))), p_227213_7_);
						base = base.add(1,0,-1);
					} else if(randDir == 1) {
						this.setBlockState(generationReader, base.add(0,0,-1), treeConfig.trunkProvider.getBlockState(rand, base.add(0,0,-1)).with(LogBlock.AXIS, this.func_227238_a_(base, base.add(0,0,-1))), p_227213_7_);
						base = base.add(0,0,-1);
					} else if(randDir == 2) {
						this.setBlockState(generationReader, base.add(-1,0,-1), treeConfig.trunkProvider.getBlockState(rand, base.add(-1,0,-1)).with(LogBlock.AXIS, this.func_227238_a_(base, base.add(-1,0,-1))), p_227213_7_);
						base = base.add(-1,0,-1);
					}
				}
				
			} else if(dir == 1) {	// E
				// mainSplit.add(1,0,0)
				BlockPos base = mainSplit.add(1,0,0);
				for(int i = 0;i<3;i++) {
					int randDir = ThreadLocalRandom.current().nextInt(0, 3);
					if(randDir == 0) {
						this.setBlockState(generationReader, base.add(1,0,0), treeConfig.trunkProvider.getBlockState(rand, base.add(1,0,0)).with(LogBlock.AXIS, this.func_227238_a_(base, base.add(1,0,0))), p_227213_7_);
						base = base.add(1,0,0);
					} else if(randDir == 1) {
						this.setBlockState(generationReader, base.add(1,0,1), treeConfig.trunkProvider.getBlockState(rand, base.add(1,0,1)).with(LogBlock.AXIS, this.func_227238_a_(base, base.add(1,0,1))), p_227213_7_);
						base = base.add(1,0,1);
					} else if(randDir == 2) {
						this.setBlockState(generationReader, base.add(1,0,-1), treeConfig.trunkProvider.getBlockState(rand, base.add(1,0,-1)).with(LogBlock.AXIS, this.func_227238_a_(base, base.add(1,0,-1))), p_227213_7_);
						base = base.add(1,0,-1);
					}
				}
				
			} else if(dir == 2) {	// S 
				// mainSplit.add(0,0,1)
				BlockPos base = mainSplit.add(0,0,1);
				for(int i = 0;i<3;i++) {
					int randDir = ThreadLocalRandom.current().nextInt(0, 3);
					if(randDir == 0) {
						this.setBlockState(generationReader, base.add(1,0,1), treeConfig.trunkProvider.getBlockState(rand, base.add(1,0,1)).with(LogBlock.AXIS, this.func_227238_a_(base, base.add(1,0,1))), p_227213_7_);
						base = base.add(1,0,1);
					} else if(randDir == 1) {
						this.setBlockState(generationReader, base.add(-1,0,1), treeConfig.trunkProvider.getBlockState(rand, base.add(-1,0,1)).with(LogBlock.AXIS, this.func_227238_a_(base, base.add(-1,0,1))), p_227213_7_);
						base = base.add(-1,0,1);
					} else if(randDir == 2) {
						this.setBlockState(generationReader, base.add(0,0,1), treeConfig.trunkProvider.getBlockState(rand, base.add(0,0,1)).with(LogBlock.AXIS, this.func_227238_a_(base, base.add(0,0,1))), p_227213_7_);
						base = base.add(0,0,1);
					}
				}				
			} else if(dir == 3) {	// W
				// mainSplit.add(-1,0,0)
				BlockPos base = mainSplit.add(-1,0,0);
				for(int i = 0;i<3;i++) {
					int randDir = ThreadLocalRandom.current().nextInt(0, 3);
					if(randDir == 0) {
						this.setBlockState(generationReader, base.add(-1,0,0), treeConfig.trunkProvider.getBlockState(rand, base.add(-1,0,0)).with(LogBlock.AXIS, this.func_227238_a_(base, base.add(-1,0,0))), p_227213_7_);
						base = base.add(-1,0,0);
					} else if(randDir == 1) {
						this.setBlockState(generationReader, base.add(-1,0,-1), treeConfig.trunkProvider.getBlockState(rand, base.add(-1,0,-1)).with(LogBlock.AXIS, this.func_227238_a_(base, base.add(-1,0,-1))), p_227213_7_);
						base = base.add(-1,0,-1);
					} else if(randDir == 2) {
						this.setBlockState(generationReader, base.add(-1,0,1), treeConfig.trunkProvider.getBlockState(rand, base.add(-1,0,1)).with(LogBlock.AXIS, this.func_227238_a_(base, base.add(-1,0,1))), p_227213_7_);
						base = base.add(-1,0,1);
					}
				}				
			}
		}
		
		String[] directions = new String[4];

		Node current = tree.getRoot();
		for(int i=0;i<directions.length;i++) {
			directions[i] = (String) current.getValue();
			if(current.children.size() > 0) {
				current = (Node) current.children.get(ThreadLocalRandom.current().nextInt(0, current.children.size()));
			}			
		}
		for(int i=0;i<directions.length;i++) {
			LOGGER.info(directions[i]);
		}
		
	}
	
	protected boolean setLog(IWorldGenerationReader p_227216_1_, Random p_227216_2_, BlockPos p_227216_3_, Set<BlockPos> p_227216_4_, MutableBoundingBox p_227216_5_, BaseTreeFeatureConfig p_227216_6_) {
	    if (!isAirOrLeaves(p_227216_1_, p_227216_3_) && !isTallPlants(p_227216_1_, p_227216_3_) && !isWater(p_227216_1_, p_227216_3_)) {
	       return false;
	    } else {
	       this.setBlockState(p_227216_1_, p_227216_3_, p_227216_6_.trunkProvider.getBlockState(p_227216_2_, p_227216_3_), p_227216_5_);
	       p_227216_4_.add(p_227216_3_.toImmutable());
	       return true;
	    }
	 }
	
   private Direction.Axis func_227238_a_(BlockPos p_227238_1_, BlockPos p_227238_2_) {
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
   
	public class Tree<E> {
		private Node root;
		public class Node {
			private E value;
			private LinkedList<Node> children;
			private Tree<E> hostTree;
			private LinkedList<Node> parents;

			public E getValue() {
				return value;
			}
			public LinkedList<Node> getChildren() {
				return children;
			}
			private Node(LinkedList<Node> children, Tree<E> hostTree,
					E value, LinkedList<Node> parents) {
				this.children = children;
				this.hostTree = hostTree;
				this.value = value;
				this.parents = parents;
			}
		}

		public void addRoot(E value) {
			if (root == null) {
				root = new Node(new LinkedList<>(), this, value, null);
			} else {
				throw new IllegalStateException(
						"trying to add new node to non empty tree");
			}
		}
		public Node getRoot() {
			return root;
		}
		
		public Node addNode(E value, Node... parents) {
			if (parents == null) {
				throw new NullPointerException(
						"Cannot add child to null parent");
			} else if (parents[0].hostTree != this) {
				
				throw new IllegalArgumentException(
						"Primary parent node not a part of this tree");
			} else {
				LinkedList parentsLL = new LinkedList<>();
				for(Node parent : parents) {
					parentsLL.addLast(parent);
				}
				Node newNode = new Node(new LinkedList<>(), this, value, parentsLL );
				for(Node parent : parents) {
					parent.getChildren().addLast(newNode);
				}				
				return newNode;
			}
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
}


