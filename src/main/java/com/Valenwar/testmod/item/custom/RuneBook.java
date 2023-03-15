package com.Valenwar.testmod.item.custom;




import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraft.world.item.Item;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class RuneBook extends Item implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(3){
        @Override
        protected void onContentsChanged(int slot){
            setChanged();
        }
    };

    // All of this code is for a block, but it sits here in an item
    //class because I believe it can be frankensteined into what I need, if I
    //can find a way.
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();


    public RuneBook(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player){
        return void;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side){
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad(){
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps(){
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    //IMPORTANT SHIT THIS SAVES INVENTORIES DO NOT DELETE
    @Override
    protected void saveAdditional(CompoundTag nbt){
        nbt.put("inventory", itemHandler.serializeNBT())
        super.saveAdditional(nbt);
    }
    // THE THING ABOVE IS IMPORTANT SHIT TOOK DAYS TO FIGURE OUT DO NOT DELETE
    // THE THING BELOW IS ALSO IMPORTANT SHIT THIS LOADS IT BACK DO NOT DELETE
    @Override
    public void load(CompoundTag nbt){
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Rune Book");
    }
    // THE THING ABOVE IS IMPORTANT SHIT THIS LOADS IT BACK DO NOT DELETE

}

