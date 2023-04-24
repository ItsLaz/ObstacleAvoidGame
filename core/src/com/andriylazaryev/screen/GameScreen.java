package com.andriylazaryev.screen;

import com.andriylazaryev.config.GameConfig;
import com.andriylazaryev.entity.Player;
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

	private Player player;

	@Override
	public void show () {
		camera = new OrthographicCamera();
		viewport = new FitViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, camera);
		renderer = new ShapeRenderer();

		//create player
		player = new Player();

		//calculate position
		float startPlayerX = GameConfig.WORLD_CENTER_X;
		float startPlayerY = 1;

		//position player
		player.setPosition(startPlayerX,startPlayerY);

	}
	@Override
	public void render (float delta) {
		GdxUtils.clearScreen();

		renderDebug();
	}

	private void renderDebug(){

		renderer.setProjectionMatrix(camera.combined);
		renderer.begin(ShapeRenderer.ShapeType.Line);

		drawDebug();

		renderer.end();

		ViewportUtils.drawGrid(viewport, renderer);

	}

	private void drawDebug(){

		player.drawDebug(renderer);

	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width,height, true);
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
