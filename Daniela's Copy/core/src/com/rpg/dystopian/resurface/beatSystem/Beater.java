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


    Rectangle hitbox;

    Sprite beat;
    Vector2 position;
    float velocity;
    boolean move;
    int max;
    int min;

    Texture[] textures = {new Texture("beaters.png"), new Texture("beaters.png")};

    public Beater(int x, int texture, boolean move, int max, int min, float velocity){
        this.velocity = velocity;
        position = new Vector2(x , 0);
        beat = new Sprite(textures[texture]);
        beat.setSize(50, 100);
        beat.setPosition(350,0);

        hitbox = new Rectangle();

        hitbox.x = beat.getX();
        hitbox.y = beat.getY();
        hitbox.width=beat.getWidth();
        hitbox.height=beat.getHeight();
        this.max = max;
        this.min = min;
        this.move = move;


    }

    public void update(float deltaTime){
        position.x += velocity * deltaTime;
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
         /*
        if (move){
            velocity.x = - velocity.x;
            position.x = max-1;
        }else{
            velocity.x = - velocity.x;
            position.x = min+1;
        }
        */
        /*if(position.x >= max){
            move = true;
        }
        else if(position.x <= min)
        {
            move = false;
        }*/
        if (move) {
            velocity = -Math.abs(velocity);


        } else {
            velocity = Math.abs(velocity);


        }
    }

    void musicFinished(){

    }

    public Rectangle getHitbox(){
        return hitbox;
    }
    public Vector2 getVertex(){
        return position;
    }

}
