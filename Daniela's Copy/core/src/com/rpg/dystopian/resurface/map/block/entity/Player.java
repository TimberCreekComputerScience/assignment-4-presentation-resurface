package com.rpg.dystopian.resurface.map.block.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rpg.dystopian.resurface.map.block.entity.Entity;

public class Player implements Entity {

    int hp;
    int x;
    int y;
    int state;
    boolean isDefend;

    public Player(){

    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setX(float x) {
        this.x = (int)x;
    }

    @Override
    public void setY(float y) {
        this.y = (int)y;
    }

    @Override
    public int getState() {
        return state;
    }

    @Override
    public int setState() {
        //state = amount;
        return 0;
    }

    @Override
    public void translate(float x, float y, Sprite sprite, float deltaTime, int[] bfs) {
        this.x = (int)x;
        this.y = (int)y;
        //more stuff
    }

    @Override
    public void draw(SpriteBatch batch) {

    }

    @Override
    public String getDirection() {
        return null;
    }

    @Override
    public String setDirection() {
        return null;
    }

    @Override
    public boolean getIsDefend() {
        return isDefend;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public int setHp(int amount) {
        hp = amount;
        return hp;
    }

    @Override
    public int minusHp(int amount) {
        hp -= amount;
        return hp;
    }

    @Override
    public int addHp(int amount) {
        hp += amount;
        return hp;
    }
}
