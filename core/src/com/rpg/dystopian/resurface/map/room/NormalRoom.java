package com.rpg.dystopian.resurface.map.room;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class NormalRoom implements Room {

    public NormalRoom(int difficulties, int yrow, int xcol){
        //randomly generated block[10][16]
    }

    @Override
    public void updateRoom() {

    }

    @Override
    public void keyPress(int keyInput) {

    }

    @Override
    public void moveRoom(int x, int y) {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            // x -= 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            // x += 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            // y -= 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            // y += 1;
        }
    }

    @Override
    public void draw(SpriteBatch batch, float startingX, float startingY) {

    }

}
