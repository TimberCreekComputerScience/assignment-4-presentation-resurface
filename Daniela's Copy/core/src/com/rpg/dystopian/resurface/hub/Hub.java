package com.rpg.dystopian.resurface.hub;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hub {

    Texture img;
    Sprite hub;

    public Hub(){
        img = new Texture("hub.png");
        hub = new Sprite(img);
        hub.setPosition(800, 0);
        hub.setSize(160, 600);

    }

    public void draw(SpriteBatch batch){
        hub.draw(batch);
    }



}
