package com.rpg.dystopian.resurface;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rpg.dystopian.resurface.screens.GameOver;
import com.rpg.dystopian.resurface.screens.MainMenu;

public class GameController extends Game {

	@Override
	public void create () {
		setScreen(new GameOver(this));
	}


}
