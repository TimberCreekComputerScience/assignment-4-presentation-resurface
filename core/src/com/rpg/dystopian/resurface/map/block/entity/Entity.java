package com.rpg.dystopian.resurface.map.block.entity;

import com.rpg.dystopian.resurface.map.block.Block;

public interface Entity extends Block {
    boolean getIsDefend(); //shield
    //damage reduced 25%
    int getHp();
    int setHp(int amount);
    int minusHp(int amount);
    int addHp(int amount);

}
