package com.rpg.dystopian.resurface.map.block;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Wall implements Block {

    public Wall(int x, int y){

    }
    @Override
    public float getX() {
        return 0;
    }

    @Override
    public float getY() {
        return 0;
    }

    @Override
    public void setX(float x) {

    }

    @Override
    public void setY(float y) {

    }

    @Override
    public int getState() {
        return 0;
    }

    @Override
    public int setState() {
        return 0;
    }

    @Override
    public void translate(float x, float y, Sprite sprite, float deltaTime, int[] bfs) {

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
}
