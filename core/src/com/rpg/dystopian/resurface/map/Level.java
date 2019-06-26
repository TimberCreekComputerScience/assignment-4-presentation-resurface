package com.rpg.dystopian.resurface.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rpg.dystopian.resurface.map.room.BossRoom;
import com.rpg.dystopian.resurface.map.room.NormalRoom;
import com.rpg.dystopian.resurface.map.room.Room;
import com.rpg.dystopian.resurface.map.room.StartRoom;

public class Level {
    private Room[][] level;

    public Level(int xColStart, int yRowStart, int difficulty) {
        level = new Room[4][4];
        level[yRowStart][xColStart] = new StartRoom(difficulty, yRowStart, xColStart);
        double probability = 0.625;
        boolean hasBoss = false;
        // construct the remaining rooms
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (level[y][x] == null) {
                    if (!hasBoss) {
                        if (Math.random() < probability) {
                            level[y][x] = new BossRoom(difficulty, y, x);
                            hasBoss = true;
                        } else {
                            level[y][x] = new NormalRoom(difficulty, y, x);
                        }
                        probability += 0.625;
                    } else {
                        level[y][x] = new NormalRoom(difficulty, y, x);
                    }
                }
            }
        }
    }

    public void draw(SpriteBatch batch){
        float x = 0;
        // y = 100 so the beatelevel[y][x]doesn't have to be in a negative coordinate
        float y = 100;
        for(Room[] columns:level) {
            for(Room r: columns) {
                r.draw(batch, x,y);
                x+=800;
                y+=500;
            }
        }
    }
}
