package com.rpg.dystopian.resurface.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.rpg.dystopian.resurface.GameController;

public class GameOver implements Screen {
    GameController myGame;
    SpriteBatch batch;
    Sprite sprite;
    BitmapFont titleBitmap;
    BitmapFont restartBitmap;
    String gameOver;
    String restart;
    OrthographicCamera camera;
    public GameOver( GameController g){
        myGame = g;
    }
    @Override
    public void show() {
        batch = new SpriteBatch();
        sprite = new Sprite(new Texture("mainmenu2.png"));
        sprite.setSize(960, 600);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 960, 600);
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        sprite.draw(batch);
        batch.end();
        displayText();
        if(Gdx.input.justTouched()) {
            Vector3 touched = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touched);
            if (touched.x > 250 && touched.x < 690 && touched.y > 150 && touched.y < 250) {
                myGame.setScreen(new MainMenu(myGame));

            }
        }

    }
    public void displayText(){

       gameOver = "GAME OVER";
       restart = "restart";

        titleBitmap = new BitmapFont(Gdx.files.internal("font.fnt"));
        titleBitmap.getData().setScale(2);
        restartBitmap = new BitmapFont(Gdx.files.internal("font.fnt"));
        restartBitmap.getData().setScale(2);

        //draw
        batch.begin();
        titleBitmap.setColor(0.5f, 0f, 0f, 1.0f);
        titleBitmap.draw(batch, gameOver, 185, 430);
        restartBitmap.setColor(0.5f, 0f, 0f, 1.0f);
        restartBitmap.draw(batch, restart, 274, 250);
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
