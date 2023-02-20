package com.Valenwar.testmod.block.custom;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.EndRodBlock;
import net.minecraft.world.level.block.state.BlockState;

public class OnyxGemCluster extends EndRodBlock {


    public OnyxGemCluster(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP));
    }

    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        Direction direction = placeContext.getClickedFace();
        BlockState blockstate = placeContext.getLevel().getBlockState(placeContext.getClickedPos().relative(direction.getOpposite()));
        return blockstate.is(this) && blockstate.getValue(FACING) == direction ? this.defaultBlockState().setValue(FACING, direction.getOpposite()) : this.defaultBlockState().setValue(FACING, direction);
    }

}
