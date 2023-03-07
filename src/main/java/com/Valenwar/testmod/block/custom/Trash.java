package com.Valenwar.testmod.block.custom;

import com.Valenwar.testmod.item.ModCreativeModeTab;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.RegistryObject;

public class Trash extends Block {

    public Trash(Properties properties) {super(properties);}

    private static final Component CONTAINER_TITLE = Component.translatable("Trash");
    public InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            MenuProvider menuprovider = this.getMenuProvider(blockState, level, pos);
            if (menuprovider != null) {
                player.openMenu(menuprovider);
            }

            return InteractionResult.CONSUME;
        }
    }
}
