package com.Valenwar.testmod.block.custom;

import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;


public class RunebookInventory extends SimpleContainer {

    private final ItemStack stack;

    public RunebookInventory(ItemStack stack, int count) {
        super(count);
        this.stack = stack;
        readItemStack();
    }

    public ItemStack getStack() {
        return stack;
    }

    public void readItemStack() {
        if (stack.getTag() != null) {
            readNBT(stack.getTag());
        }
    }

    public void writeItemStack() {
        if (isEmpty()) {
            stack.removeTagKey("Items");
        } else {
            writeNBT(stack.getOrCreateTag());
        }
    }

    private void readNBT(CompoundTag compound) {
        final NonNullList<ItemStack> list = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(compound, list);
        for (int index = 0; index < list.size(); index++) {
            setItem(index, list.get(index));
        }
    }

    private void writeNBT(CompoundTag compound) {
        final NonNullList<ItemStack> list = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
        for (int index = 0; index < list.size(); index++) {
            list.set(index, getItem(index));
        }
        ContainerHelper.saveAllItems(compound, list, false);
    }
}
