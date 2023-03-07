package com.Valenwar.testmod.item.custom;



import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class RuneBook extends Item {
    public RuneBook(Item.Properties properties) {
        super(properties);
    }


    //This Makes a normal chest inventory, but it doesnt save the items in it yet. This makes an inventory
    //inside of an item, not a block. Work in progress.
    private static final Component CONTAINER_TITLE = Component.translatable("Book Of Runes");
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
            player.openMenu(new SimpleMenuProvider((i, inventory, player1 ) -> {
                return ChestMenu.threeRows(i, inventory);
            }, CONTAINER_TITLE));

        }
        ;

        return super.use(level, player, hand);

    }
}

