package com.Valenwar.testmod.soulresidue;

import net.minecraft.nbt.CompoundTag;

public class PlayerSoulResidue {
    private int soulresidue;
    private final int MIN_SOULRESIDUE = 0;
    private final int MAX_SOULRESIDUE = 100;

    public int getSoulresidue(){

        return soulresidue;
    }

    public void addSoulResidue(int add){

        this.soulresidue = Math.min(soulresidue + add, MAX_SOULRESIDUE );
    }

    public void subSoulResidue(int sub){

        this.soulresidue = Math.max(soulresidue - sub, MIN_SOULRESIDUE );
    }

    public void copyFrom(PlayerSoulResidue source ){

        this.soulresidue = source.soulresidue;
    }

    public void saveNBTData(CompoundTag nbt){

        nbt.putInt("soulresidue", soulresidue);
    }

    public void loadNBTData(CompoundTag nbt){
        soulresidue = nbt.getInt("soulresidue");
    }


}
