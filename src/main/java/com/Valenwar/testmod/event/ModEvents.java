package com.Valenwar.testmod.event;

import com.Valenwar.testmod.soulresidue.PlayerSRProvider;
import com.Valenwar.testmod.soulresidue.PlayerSoulResidue;
import com.Valenwar.testmod.testmod;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = testmod.MOD_ID)

public class ModEvents {
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
        if(event.getObject() instanceof Player){
            if(!event.getObject().getCapability(PlayerSRProvider.PLAYER_SOULRESIDUE).isPresent()) {
                event.addCapability(new ResourceLocation(testmod.MOD_ID, "properties"), new PlayerSRProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event){
        if(event.isWasDeath()){
            event.getOriginal().getCapability(PlayerSRProvider.PLAYER_SOULRESIDUE).ifPresent(oldStore ->{
                event.getOriginal().getCapability(PlayerSRProvider.PLAYER_SOULRESIDUE).ifPresent(newStore ->{
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event){
        event.register(PlayerSoulResidue.class);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event){
        if (event.side == LogicalSide.SERVER){
         event.player.getCapability(PlayerSRProvider.PLAYER_SOULRESIDUE).ifPresent(soulresidue ->{
             if(soulresidue.getSoulresidue() >= 0 && event.player.getRandom().nextFloat() < 0.005f){//Once every 10 Seconds on Avg

                 soulresidue.addSoulResidue(1);

                event.player.sendSystemMessage(Component.literal("Added Soul Residue").withStyle(ChatFormatting.AQUA));
             }
         });
        }
    }

}
