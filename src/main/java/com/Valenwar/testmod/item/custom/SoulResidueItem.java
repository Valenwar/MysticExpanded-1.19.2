package com.Valenwar.testmod.item.custom;


import com.Valenwar.testmod.soulresidue.PlayerSRProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SoulResidueItem extends Item {

    public SoulResidueItem(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return stack.getItem().isEdible() ? UseAnim.EAT : UseAnim.NONE;
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide && hand == InteractionHand.MAIN_HAND) {

            //set Soul Residue Cost
            player.getCapability(PlayerSRProvider.PLAYER_SOULRESIDUE).ifPresent(soulresidue ->{
              soulresidue.addSoulResidue(15);

                //Send soul residue level message
                player.sendSystemMessage(Component.literal("Current Soul Residue " + soulresidue.getSoulresidue()).withStyle(ChatFormatting.YELLOW));
                player.getCooldowns().addCooldown(this, 20);
            });

        }


        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        if(Screen.hasShiftDown()){
            list.add(Component.literal("Drink to recover some Soul Residue").withStyle(ChatFormatting.YELLOW));

        }else{
            list.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.YELLOW));
        }



        super.appendHoverText(stack, level, list, flag);
    }

}
