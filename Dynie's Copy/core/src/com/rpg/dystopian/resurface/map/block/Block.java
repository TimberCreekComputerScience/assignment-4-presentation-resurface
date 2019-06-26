package com.rpg.dystopian.resurface.map.block;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Block {
    float getX();

    float getY();

    void setX(float x);

    void setY(float y);

    int getState();

    int setState();

    void translate(float x, float y, Sprite sprite, float deltaTime, int[] bfs);

    void draw(SpriteBatch batch);

    String getDirection();

    String setDirection();
}
