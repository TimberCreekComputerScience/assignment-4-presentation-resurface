package com.rpg.dystopian.resurface.hub;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class Hub {

    Texture img;
    Sprite hub;
    Texture inventory;
    Texture selected;
    Sprite one;
    Sprite two;
    Sprite three;
    Sprite four;
    Sprite five;

    public Hub(){
        img = new Texture("hub.png");
        hub = new Sprite(img);
        hub.setPosition(800, 0);
        hub.setSize(160, 600);
        inventory = new Texture("inventory.png");
        selected = new Texture("inventorySelect.png");
        one = new Sprite(inventory);
        one.setPosition(815, 200);
        one.setSize(130, 80);
        two = new Sprite(inventory);
        two.setPosition(815, 107);
        two.setSize(130, 80);
        three = new Sprite(inventory);
        three.setPosition(815, 15);
        three.setSize(130, 80);

        select();

    }

    public void select(){
        if(Gdx.input.justTouched()){
            Vector3 touched = new Vector3(Gdx.input.getX(), Gdx.input.getY(),0);

            if(touched.x > 815 && touched.x < 945 && touched.y > 200 && touched.y < 280) {
                one.setTexture(selected);
            }
            if(touched.x > 815 && touched.x < 945 && touched.y > 107 && touched.y < 187) {
                two.setTexture(selected);
            }
            if(touched.x > 815 && touched.x < 945 && touched.y > 15 && touched.y < 95) {
                three.setTexture(selected);
            }
        }
    }

    public void draw(SpriteBatch batch){
        hub.draw(batch);
        one.draw(batch);
        two.draw(batch);
        three.draw(batch);
    }



}
