package com.Valenwar.testmod.soulresidue;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerSRProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerSoulResidue> PLAYER_SOULRESIDUE = CapabilityManager.get(new CapabilityToken<PlayerSoulResidue>() {});

    private PlayerSoulResidue soulresidue = null;
    private final LazyOptional<PlayerSoulResidue> optional = LazyOptional.of(this::createPlayerSoulResidue);

    private PlayerSoulResidue createPlayerSoulResidue(){
        if(this.soulresidue == null){
            this.soulresidue = new PlayerSoulResidue();
        }

        return this.soulresidue;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == PLAYER_SOULRESIDUE){
            return optional.cast();
        }


        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerSoulResidue().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerSoulResidue().loadNBTData(nbt);

    }
}
