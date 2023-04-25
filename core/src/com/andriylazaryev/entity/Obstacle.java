package com.andriylazaryev.entity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;

public class Obstacle {

	private static final float BOUNDS_RADIUS = 0.2f; // world units
	private static final float SIZE = 2 * BOUNDS_RADIUS;

	private float x;
	private float y;

	private final float ySpeed = 0.1f;

	private final Circle bounds;

	public Obstacle(){
		bounds = new Circle(x,y, BOUNDS_RADIUS);
	}

	public void drawDebug(ShapeRenderer renderer){
		renderer.circle(bounds.x, bounds.y, bounds.radius, 30);
	}

	public void setPosition(float x, float y){
		this.x = x;
		this.y = y;
		updateBounds();
	}

	private void updateBounds(){
		bounds.setPosition(x,y);
	}

	public void update(){
		setPosition(x,y-ySpeed);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getWidth() {
		return SIZE;
	}
}
