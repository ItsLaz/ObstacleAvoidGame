package com.andriylazaryev.entity;

import com.andriylazaryev.config.GameConfig;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player extends GameObjectBase {

	private static final float BOUNDS_RADIUS = 0.4f; // world units
	private static final float SIZE = 2 * BOUNDS_RADIUS;

	public Player() {
		super(BOUNDS_RADIUS);
	}

	public void update() {
		float xSpeed = 0;
		if (Gdx.input.isKeyPressed(Input.Keys.D)) xSpeed = GameConfig.MAX_PLAYER_X_SPEED;
		if (Gdx.input.isKeyPressed(Input.Keys.A)) xSpeed = -GameConfig.MAX_PLAYER_X_SPEED;
		setX(getX() + xSpeed);
//		updateBounds();
	}

	public float getWidth() {
		return SIZE;
	}
}
