package com.andriylazaryev.entity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;

public abstract class GameObjectBase {

	private float x;
	private float y;

	private final Circle bounds;


	protected GameObjectBase(float boundsRadius) {
		bounds = new Circle(x,y,boundsRadius);
	}

	public void drawDebug(ShapeRenderer renderer){
		renderer.circle(bounds.x, bounds.y, bounds.radius, 30);
	}

	public void setPosition(float x, float y){
		this.x = x;
		this.y = y;
		updateBounds();
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setX(float x) {
		this.x = x;
		updateBounds();
	}

	public void setY(float y) {
		this.y = y;
		updateBounds();
	}

	protected void updateBounds(){
		bounds.setPosition(x,y);
	}

	protected Circle getBounds() {
		return bounds;
	}
}
