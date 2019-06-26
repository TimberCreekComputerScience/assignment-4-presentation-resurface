package com.rpg.dystopian.resurface.item;

public interface Item {

    int getDurability();

    void use();

    void addDurability();

    void minusDurability();

    void setDurability(int d);
}
