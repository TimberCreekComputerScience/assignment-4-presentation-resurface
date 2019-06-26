package com.rpg.dystopian.resurface.beatSystem;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


import java.util.ArrayList;

public class Beater {
    Music[] music;
    public int x;
    public int y;

    Rectangle hitbox;

    Sprite beat;
    Vector2 position;
    Vector2 velocity;
    int max;
    int min;


    Texture[] textures = {new Texture("beaters.png"), new Texture("beaters.png")};
    public Beater(int x, int y, int max, int min, int text){

        velocity = new Vector2(800, 0);
        position = new Vector2(x , y);
        beat = new Sprite(textures[text]);
        beat.setSize(50, 100);
        beat.setPosition(x,y);

        hitbox = new Rectangle();

        hitbox.x = beat.getX();
        hitbox.y = beat.getY();
        this.max = max;
        this.min = min;


    }

    public void update(float deltaTime){
        position.x += velocity.x * deltaTime;
        position.y += velocity.y * deltaTime;
        hitbox.x = beat.getX();
        hitbox.y = beat.getY();
        // hitbox.x = position.x;
        //hitbox.y = position.y;
        beat.setPosition(position.x, position.y);

    }
    public float getX(){
        return position.x;
    }
    public float getY(){
        return position.y;
    }
    void click(){
        //if(overlap){ action performed }
    }

    public  void draw(SpriteBatch batch){
        beat.draw(batch);
    }
    public void movement(){
        if(position.x >= max){
            velocity.x = - velocity.x;
            position.x = max-1;
        }
        if(position.x <= min)
        {
            velocity.x = - velocity.x;
            position.x = min+1;
        }
    }

    void musicFinished(){

    }

    public Rectangle getHitbox(){
        return hitbox;
    }

}
