package com.andriylazaryev;

import com.andriylazaryev.screen.GameScreen;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class ObstacleAvoidGame extends Game {

	@Override
	public void create() {

		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		setScreen(new GameScreen());

	}
}
