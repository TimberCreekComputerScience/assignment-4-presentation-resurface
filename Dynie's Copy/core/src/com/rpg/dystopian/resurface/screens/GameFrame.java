package com.rpg.dystopian.resurface.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.rpg.dystopian.resurface.GameController;
import com.rpg.dystopian.resurface.beatSystem.beater;

import java.util.ArrayList;

public class GameFrame implements Screen {
    SpriteBatch batch;
    GameController myGame;
    Sprite sprite;
    beater beat;
    Music music ;
    ArrayList<beater> beats;
    ArrayList<beater> twobeat;
    OrthographicCamera camera;
    String gameOver;
    String restart;
    boolean touched;
    float counter;

    public GameFrame( GameController g){
        myGame = g;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        sprite = new Sprite(new Texture("beatBG.PNG"));
       sprite.setPosition(0,0);
touched = false;

  beats= new ArrayList<beater>();
        twobeat= new ArrayList<beater>();
  //beats.add(new beater(500, 0, 1000,  200, 1, true));
        beats.add(new beater(0, 1, false, 700, 0,250));

        //beats.add(new beater(500, 0, 755, 1, 0, false));
        twobeat.add(new beater(700, 0, true, 700, 0,250));



        music = Gdx.audio.newMusic(Gdx.files.internal("Music/Steellife.wav"));
      camera = new OrthographicCamera();
      camera.setToOrtho(false, 960, 600);

    }

    @Override
    public void render(float delta) {

       // music.play();
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        counter += delta;
        if(counter >= .6){
            counter -= .6;
            beats.add(new beater(0, 1, false, 700, 0,250));
            twobeat.add(new beater(750, 0, true, 700, 0,250));

        }
        sprite.draw(batch);
        for(beater b: beats){
            b.movement();
            b.update(Gdx.graphics.getDeltaTime());
            b.draw(batch);

        }
        for(beater B: twobeat){
            B.movement();
            B.update(Gdx.graphics.getDeltaTime());
            B.draw(batch);

        }
        if ((beats.get(0).getVertex().x > 440) && twobeat.get(0).getVertex().x < 360) {
            beats.remove(0);
            twobeat.remove(0);
        }
        if(Gdx.input.justTouched()) {
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
