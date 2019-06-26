package com.rpg.dystopian.resurface.map.room;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rpg.dystopian.resurface.map.block.Block;
import com.rpg.dystopian.resurface.map.block.Floor;
import com.rpg.dystopian.resurface.map.block.Wall;
import com.rpg.dystopian.resurface.map.room.Room;

public class StartRoom implements Room {
    Block[][] grid;

    public StartRoom(int difficulties, int yrow, int xcol){
        grid = new Block[10][16];
        // Set the walls
        // top
        for(int i = 0; i < 16;i++){
            if(i == 7) {
                if (yrow == 4) {
                    grid[9][7] = new Wall(7, 9);
                    grid[9][8] = new Wall(8, 9);
                    i += 2;
                } else {
                    grid[9][7] = new Floor(7, 9);
                    grid[9][8] = new Floor(8, 9);
                    i += 2;
                }
            }
            grid[9][i] = new Wall(i,9);
        }
        // bottom
        for(int i = 0; i < 16;i++){
            if(i == 7) {
                if (yrow == 0) {
                    grid[0][7] = new Wall(7, 0);
                    grid[0][8] = new Wall(8, 0);
                    i += 2;
                } else {
                    grid[0][7] = new Floor(7, 0);
                    grid[0][8] = new Floor(8, 0);
                    i += 2;
                }
            }
            grid[0][i] = new Wall(i,0);
        }
        // left
        for(int i = 0; i < 10;i++){
            if(i == 4) {
                if (xcol == 0) {
                    grid[4][0] = new Wall(0, 4);
                    grid[5][0] = new Wall(0, 5);
                    i += 2;
                } else {
                    grid[4][0] = new Floor(0, 4);
                    grid[5][0] = new Floor(0, 5);
                    i += 2;
                }
            }
            grid[i][0] = new Wall(0,i);
        }
        // right
        for(int i = 0; i < 10;i++){
            if(i == 4) {
                if (xcol == 4) {
                    grid[4][9] = new Wall(9, 4);
                    grid[5][9] = new Wall(9, 5);
                    i += 2;
                } else {
                    grid[4][9] = new Floor(9, 4);
                    grid[5][9] = new Floor(9, 5);
                    i += 2;
                }
            }
            grid[i][0] = new Wall(0,i);
        }

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
