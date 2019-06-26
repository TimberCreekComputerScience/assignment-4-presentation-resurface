package com.rpg.dystopian.resurface.map.room;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Room {

    void updateRoom();
        //keyPress();
        //moveRoom();

    void keyPress(int keyInput);


    void moveRoom(int x, int y);


    void draw(SpriteBatch batch, float startingX,float startingY);



}
