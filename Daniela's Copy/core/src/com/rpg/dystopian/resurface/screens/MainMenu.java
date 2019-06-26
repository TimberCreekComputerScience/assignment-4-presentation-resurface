package com.rpg.dystopian.resurface.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.rpg.dystopian.resurface.GameController;
import com.rpg.dystopian.resurface.hub.Hub;

public class MainMenu implements Screen {
    GameController myGame;
    SpriteBatch batch;
    Texture background;
    Sprite img;
    String gameTitle;
    BitmapFont titleBitmap;
    String gameStart;
    BitmapFont startBitmap;
    Music music;
    OrthographicCamera camera;

    public MainMenu(GameController g){
        myGame = g;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        background = new Texture("mainmenu.jpg");
        img = new Sprite(background);
        img.setPosition(0, 0);
        img.setSize(960, 600);
        music = Gdx.audio.newMusic(Gdx.files.internal("mainmenuMusic.mp3"));
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 960, 600);
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(camera.combined);
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);

        //draw
        batch.begin();
        img.draw(batch);
        batch.end();


        displayText();
        music.play();
        if(Gdx.input.justTouched()) {
            Vector3 touched = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touched);
            if (touched.x > 320 && touched.x < 640 && touched.y > 135 && touched.y < 200) {
                myGame.setScreen(new GameFrame(myGame));
                music.stop();
            }
        }
    }

    public void displayText(){

        gameTitle = "resurface";
        gameStart = "start";

        titleBitmap = new BitmapFont(Gdx.files.internal("font.fnt"));
        titleBitmap.getData().setScale(2);
        startBitmap = new BitmapFont(Gdx.files.internal("font.fnt"));
        startBitmap.getData().setScale(2);

        //draw
        batch.begin();
        titleBitmap.setColor(0.5f, 0f, 0f, 1.0f);
        titleBitmap.draw(batch, gameTitle, 185, 500);
        startBitmap.setColor(0.5f, 0f, 0f, 1.0f);
        startBitmap.draw(batch, gameStart, 325, 200);
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
        batch.dispose();
    }
}
