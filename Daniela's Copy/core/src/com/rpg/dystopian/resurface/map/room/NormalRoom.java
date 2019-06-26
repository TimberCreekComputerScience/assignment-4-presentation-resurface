package com.rpg.dystopian.resurface.map.room;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rpg.dystopian.resurface.map.block.Block;
import com.rpg.dystopian.resurface.map.block.Door;
import com.rpg.dystopian.resurface.map.block.Wall;
import com.rpg.dystopian.resurface.map.block.entity.Elevator;
import com.rpg.dystopian.resurface.map.block.entity.Zombie;

import java.util.ArrayList;

public class NormalRoom implements Room {
        Block[][] grid;

    public NormalRoom(int difficulties, int yrow, int xcol) {
        grid = new Block[10][16];

        // Set the walls
        // top
        for (int i = 0; i < 16; i++) {
            if (i == 7) {
                if (yrow == 4) {
                    grid[9][7] = new Wall(7, 9);
                    grid[9][8] = new Wall(8, 9);
                    i += 2;
                } else {
                    grid[9][7] = new Door(7, 9);
                    grid[9][8] = new Door(8, 9);
                    i += 2;
                }
            }
            grid[9][i] = new Wall(i, 9);
        }
        // bottom
        for (int i = 0; i < 16; i++) {
            if (i == 7) {
                if (yrow == 0) {
                    grid[0][7] = new Wall(7, 0);
                    grid[0][8] = new Wall(8, 0);
                    i += 2;
                } else {
                    grid[0][7] = new Door(7, 0);
                    grid[0][8] = new Door(8, 0);
                    i += 2;
                }
            }
            grid[0][i] = new Wall(i, 0);
        }
        // left
        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                if (xcol == 0) {
                    grid[4][0] = new Wall(0, 4);
                    grid[5][0] = new Wall(0, 5);
                    i += 2;
                } else {
                    grid[4][0] = new Door(0, 4);
                    grid[5][0] = new Door(0, 5);
                    i += 2;
                }
            }
            grid[i][0] = new Wall(0, i);
        }
        // right
        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                if (xcol == 4) {
                    grid[4][9] = new Wall(9, 4);
                    grid[5][9] = new Wall(9, 5);
                    i += 2;
                } else {
                    grid[4][9] = new Door(9, 4);
                    grid[5][9] = new Door(9, 5);
                    i += 2;
                }
            }
            grid[i][0] = new Wall(0, i);
        }
        grid[4][7] = new Elevator(7, 4, 1);
        grid[4][8] = new Elevator(7, 4, 2);
        grid[5][7] = new Elevator(7, 4, 3);
        grid[5][8] = new Elevator(7, 4, 4);
        for (int y = 1; y < 9; y++) {
            for (int x = 1; x < 15; x++) {
                if (grid[y][x] == null) {
                    if (Math.random() < 0.1) {
                        grid[y][x] = new Zombie(x, y, difficulties);
                    } else {

                    }
                }
            }
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
