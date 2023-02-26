package com.Valenwar.testmod.item.custom;


import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.PlayerEnderChestContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class RuneBook extends Item {

    public RuneBook(Properties properties) { super(properties); }

    private static final Component CONTAINER_TITLE = Component.translatable("container.test");
@Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
    PlayerEnderChestContainer playerenderchestcontainer = player.getEnderChestInventory();

        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
            player.openMenu(new SimpleMenuProvider((i, inventory, player1) -> {
                return ChestMenu.threeRows(i, inventory, playerenderchestcontainer);
            }, CONTAINER_TITLE));

        };

        return super.use(level, player, hand);

    }

}


