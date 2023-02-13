package com.Valenwar.testmod.item.custom;


import com.Valenwar.testmod.soulresidue.PlayerSRProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EightBallItem extends Item {

    public EightBallItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
            // Output a random number
            // Set a item cool down
            outputRandomNumber(player);
            player.getCooldowns().addCooldown(this, 20);

            //set Soul Residue Cost
            player.getCapability(PlayerSRProvider.PLAYER_SOULRESIDUE).ifPresent(soulresidue ->{
              soulresidue.subSoulResidue(8);

                //Send soul residue level message
                player.sendSystemMessage(Component.literal("Current Soul Residue " + soulresidue.getSoulresidue()).withStyle(ChatFormatting.YELLOW));

            });

        }


        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        if(Screen.hasShiftDown()){
            list.add(Component.literal("Right Click to get a random number").withStyle(ChatFormatting.YELLOW));

        }else{
            list.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.YELLOW));
        }



        super.appendHoverText(stack, level, list, flag);
    }

    private void outputRandomNumber(Player player) {
        player.sendSystemMessage(Component.literal("Your number is " + getRandomNumber()));
    }
    private int getRandomNumber(){
        return RandomSource.createNewThreadLocalInstance().nextInt(10);
    }
}
