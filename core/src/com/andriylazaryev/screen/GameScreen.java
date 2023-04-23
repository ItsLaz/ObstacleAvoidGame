package com.andriylazaryev.screen;

import com.andriylazaryev.config.GameConfig;
import com.andriylazaryev.util.GdxUtils;
import com.andriylazaryev.util.ViewportUtils;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {

	private OrthographicCamera camera;
	private Viewport viewport;
	private ShapeRenderer renderer;

	@Override
	public void show () {
		camera = new OrthographicCamera();
		viewport = new FitViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, camera);
		renderer = new ShapeRenderer();
	}
	@Override
	public void render (float delta) {
		GdxUtils.clearScreen();

		drawDebug();
	}

	private void drawDebug(){
		ViewportUtils.drawGrid(viewport, renderer);
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width,height);
		ViewportUtils.debugPixelPerUnit(viewport);
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
	public void dispose () {
		renderer.dispose();
	}


}
