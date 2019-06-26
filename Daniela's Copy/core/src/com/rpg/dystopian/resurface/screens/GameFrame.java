package com.rpg.dystopian.resurface.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.rpg.dystopian.resurface.GameController;
import com.rpg.dystopian.resurface.beatSystem.Beater;
import com.rpg.dystopian.resurface.hub.Hub;
import com.rpg.dystopian.resurface.map.Level;
import com.rpg.dystopian.resurface.map.block.entity.Player;

import java.util.ArrayList;

public class GameFrame implements Screen {
    GameController myGame;

    SpriteBatch batch;
    //hub
    Hub hub;
    //beater
    Beater beat;
    Music music ;
    ArrayList<Beater> beats;
    ArrayList<Rectangle> hitboxes;
    Texture beet;
    Sprite beatBG;
    boolean overlapBeat;
    //level
    Level level;

    //player
    Player player;

    OrthographicCamera camera;

    public GameFrame(GameController g){
        myGame = g;
    }


    @Override
    public void show() {
        batch = new SpriteBatch();
        //hub
        hub = new Hub();
        //beater
        beats= new ArrayList<Beater>();
        beats.add(new Beater(1, 0, 755,  1, 1));
        beats.add(new Beater(755, 0, 755, 1, 0));
        hitboxes = new ArrayList<Rectangle>();
        hitboxes.add(new Rectangle());
        hitboxes.add(new Rectangle());
        music = Gdx.audio.newMusic(Gdx.files.internal("Music/Mon Amour.wav"));
        beet = new Texture("beatBG.png");
        beatBG = new Sprite(beet);
        beatBG.setPosition(0, 0);
        beatBG.setSize(800, 100);
        overlapBeat = false;

        //level = new Level((int)(Math.random() * 4), (int)(Math.random() * 4), difficulty);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 960, 600);
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(camera.combined);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);

        music.play();

        //draw
        batch.begin();
        hub.draw(batch);
        beatBG.draw(batch);
        for(Beater b: beats){
            b.update(Gdx.graphics.getDeltaTime());
            b.movement();
            b.draw(batch);
        }
        batch.end();

        //player moving
        if(overlapBeat) {
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                System.out.println("up");
                // player.translate(player.getX(), player.getY() + 50, player, Gdx.graphics.getDeltaTime(), );
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                System.out.println("down");
            }
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                System.out.println("right");
            }
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                System.out.println("left");
            }
        }
        //beats overlapping
        if(beats.get(0).getHitbox().overlaps(beats.get(1).getHitbox())){
            overlapBeat = true;
            System.out.println("overlaps");
            //if(!(beats.get(0).getHitbox().overlaps(beats.get(1).getHitbox()))){
                //overlapBeat = false;
            //}
        }
        if(hitboxes.get(0).overlaps(hitboxes.get(1))) {
            overlapBeat = true;
            System.out.println("overlaps");
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
