package com.rpg.dystopian.resurface.item.weapon;

import com.rpg.dystopian.resurface.item.Item;
import com.rpg.dystopian.resurface.map.block.entity.Player;

public interface Weapon extends Item {

    void inRange(Player p, int xCol, int yRow);

    void attack();

    void knockBack();
    //damage doubles if hits wall
}
