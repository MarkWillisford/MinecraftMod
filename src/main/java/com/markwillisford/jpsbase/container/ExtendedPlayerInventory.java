package com.markwillisford.jpsbase.container;

import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.NonNullList;

public class ExtendedPlayerInventory extends PlayerInventory {
	public final NonNullList<ItemStack> backpackArray;
	public final NonNullList<ItemStack> backpackInventory;
	private final List<NonNullList<ItemStack>> allInventories;

	public ExtendedPlayerInventory(PlayerEntity player) {
		super(player);
		this.backpackArray = NonNullList.withSize(1, ItemStack.EMPTY);
		this.backpackInventory = NonNullList.withSize(1, ItemStack.EMPTY);
		this.allInventories = ImmutableList.of(this.mainInventory, this.armorInventory, this.offHandInventory, this.backpackInventory);
	}

	public NonNullList<ItemStack> getBackpackItems() {
		return this.backpackInventory;
	}

	public void copyBackpack(ExtendedPlayerInventory inventory) {
		this.backpackInventory.set(0, inventory.backpackInventory.get(0));
	}

	public ItemStack func_70298_a(int index, int count) {
		NonNullList<ItemStack> targetInventory = null;

		NonNullList inventory;
		for(Iterator var4 = this.allInventories.iterator(); var4.hasNext(); index -= inventory.size()) {
			inventory = (NonNullList)var4.next();
			if (index < inventory.size()) {
				targetInventory = inventory;
				break;
			}
		}

		return targetInventory != null && !((ItemStack)targetInventory.get(index)).isEmpty() ? ItemStackHelper.getAndSplit(targetInventory, index, count) : ItemStack.EMPTY;
	}

	public void func_184437_d(ItemStack stack) {
		Iterator var2 = this.allInventories.iterator();

		while(true) {
			while(var2.hasNext()) {
				NonNullList<ItemStack> inventory = (NonNullList)var2.next();

				for(int i = 0; i < inventory.size(); ++i) {
					if (inventory.get(i) == stack) {
						inventory.set(i, ItemStack.EMPTY);
						break;
					}
				}
			}

			return;
		}
	}

	public ItemStack func_70304_b(int index) {
		NonNullList<ItemStack> targetInventory = null;

		NonNullList inventory;
		for(Iterator var3 = this.allInventories.iterator(); var3.hasNext(); index -= inventory.size()) {
			inventory = (NonNullList)var3.next();
			if (index < inventory.size()) {
				targetInventory = inventory;
				break;
			}
		}

		if (targetInventory != null && !((ItemStack)targetInventory.get(index)).isEmpty()) {
			ItemStack stack = (ItemStack)targetInventory.get(index);
			targetInventory.set(index, ItemStack.EMPTY);
			return stack;
		} else {
			return ItemStack.EMPTY;
		}
	}

	public void func_70299_a(int index, ItemStack stack) {
		NonNullList<ItemStack> targetInventory = null;

		NonNullList inventory;
		for(Iterator var4 = this.allInventories.iterator(); var4.hasNext(); index -= inventory.size()) {
			inventory = (NonNullList)var4.next();
			if (index < inventory.size()) {
				targetInventory = inventory;
				break;
			}
		}

		if (targetInventory != null) {
			targetInventory.set(index, stack);
		}

	}

	public ItemStack func_70301_a(int index) {
		List<ItemStack> list = null;

		NonNullList inventory;
		for(Iterator var3 = this.allInventories.iterator(); var3.hasNext(); index -= inventory.size()) {
			inventory = (NonNullList)var3.next();
			if (index < inventory.size()) {
				list = inventory;
				break;
			}
		}

		return list == null ? ItemStack.EMPTY : (ItemStack)list.get(index);
	}

	public ListNBT func_70442_a(ListNBT list) {
		list = super.write(list);

		for(int i = 0; i < this.backpackInventory.size(); ++i) {
			if (!((ItemStack)this.backpackInventory.get(i)).isEmpty()) {
				CompoundNBT compound = new CompoundNBT();
				compound.putByte("Slot", (byte)(i + 200));
				((ItemStack)this.backpackInventory.get(i)).write(compound);
				list.add(compound);
			}
		}

		return list;
	}

	public void func_70443_b(ListNBT list) {
		super.read(list);

		for(int i = 0; i < list.size(); ++i) {
			CompoundNBT compound = list.getCompound(i);
			int slot = compound.getByte("Slot") & 255;
			ItemStack stack = ItemStack.read(compound);
			if (!stack.isEmpty() && slot >= 200 && slot < this.backpackInventory.size() + 200) {
				this.backpackInventory.set(slot - 200, stack);
			}
		}

	}

	public int func_70302_i_() {
		return super.getSizeInventory() + this.backpackInventory.size();
	}

	public boolean func_191420_l() {
		Iterator var1 = this.backpackInventory.iterator();

		ItemStack stack;
		do {
			if (!var1.hasNext()) {
				return super.isEmpty();
			}

			stack = (ItemStack)var1.next();
		} while(stack.isEmpty());

		return false;
	}

	public boolean func_70431_c(ItemStack targetStack) {
		Iterator var2 = this.allInventories.iterator();
		if (var2.hasNext()) {
			NonNullList<ItemStack> inventory = (NonNullList)var2.next();
			Iterator iterator = inventory.iterator();

			ItemStack stack;
			do {
				if (!iterator.hasNext()) {
					return false;
				}

				stack = (ItemStack)iterator.next();
			} while(stack.isEmpty() || !stack.isItemEqual(targetStack));

			return true;
		} else {
			return false;
		}
	}

	public void func_174888_l() {
		Iterator var1 = this.allInventories.iterator();

		while(var1.hasNext()) {
			List<ItemStack> list = (List)var1.next();
			list.clear();
		}

	}

	public void func_70436_m() {
		//if ((Boolean)Config.COMMON.keepBackpackOnDeath.get()) {
		//	super.dropAllItems();
		//} else {
			Iterator var1 = this.allInventories.iterator();

			while(var1.hasNext()) {
				List<ItemStack> list = (List)var1.next();

				for(int i = 0; i < list.size(); ++i) {
					ItemStack itemstack = (ItemStack)list.get(i);
					if (!itemstack.isEmpty()) {
						this.player.dropItem(itemstack, true, false);
						list.set(i, ItemStack.EMPTY);
					}
				}
			}
		//}
	}
}