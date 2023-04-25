package com.andriylazaryev.entity;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;

public class Obstacle extends GameObjectBase {

	private static final float BOUNDS_RADIUS = 0.2f; // world units
	private static final float SIZE = 2 * BOUNDS_RADIUS;

	public Obstacle(){
		super(BOUNDS_RADIUS);
	}

	public void update(){
		float ySpeed = 0.09f;
		setY(getY()- ySpeed);
	}

	public float getWidth() {
		return SIZE;
	}

	public boolean isPlayerColliding(Player player) {
		Circle playerBounds = player.getBounds();
		// check if player bounds overlaps obstacle bounds
		return Intersector.overlaps(playerBounds,getBounds());
	}
}
