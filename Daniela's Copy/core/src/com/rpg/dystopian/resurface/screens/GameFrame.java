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
    ArrayList<Beater> twobeat;
    Texture beet;
    Sprite beatBG;
    float counter;
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
        twobeat= new ArrayList<Beater>();
        beats.add(new Beater(0, 1, false, 700, 0,250));
        twobeat.add(new Beater(700, 0, true, 700, 0,250));
        music = Gdx.audio.newMusic(Gdx.files.internal("Music/Mon Amour.wav"));
        beet = new Texture("beatBG.png");
        beatBG = new Sprite(beet);
        beatBG.setPosition(0, 0);
        beatBG.setSize(800, 100);
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
        counter += delta;
        if(counter >= .6){
            counter -= .6;
            beats.add(new Beater(0, 1, false, 700, 0,250));
            twobeat.add(new Beater(750, 0, true, 700, 0,250));

        }
        for(Beater b: beats){
            b.movement();
            b.update(Gdx.graphics.getDeltaTime());
            b.draw(batch);

        }
        for(Beater B: twobeat){
            B.movement();
            B.update(Gdx.graphics.getDeltaTime());
            B.draw(batch);

        }
        if ((beats.get(0).getVertex().x > 440) && twobeat.get(0).getVertex().x < 360) {
            beats.remove(0);
            twobeat.remove(0);
        }
        //player moving
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (beats.get(0).getHitbox().overlaps(twobeat.get(0).getHitbox())) {
                System.out.println("Yes");
                beats.remove(0);
                twobeat.remove(0);
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (beats.get(0).getHitbox().overlaps(twobeat.get(0).getHitbox())) {
                System.out.println("Yes");
                beats.remove(0);
                twobeat.remove(0);
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (beats.get(0).getHitbox().overlaps(twobeat.get(0).getHitbox())) {
                System.out.println("Yes");
                beats.remove(0);
                twobeat.remove(0);
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (beats.get(0).getHitbox().overlaps(twobeat.get(0).getHitbox())) {
                System.out.println("Yes");
                beats.remove(0);
                twobeat.remove(0);
            }
        }
        batch.end();

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
