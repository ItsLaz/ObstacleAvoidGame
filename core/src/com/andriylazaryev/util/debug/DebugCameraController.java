package com.andriylazaryev.util.debug;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Logger;

public class DebugCameraController {

	// === constants
	private static final Logger log = new Logger(DebugCameraController.class.getName(), Logger.DEBUG);

	private static final int DEFAULT_LEFT_KEY = Input.Keys.DPAD_LEFT;
	private static final int DEFAULT_RIGHT_KEY = Input.Keys.DPAD_RIGHT;
	private static final int DEFAULT_UP_KEY = Input.Keys.DPAD_UP;
	private static final int DEFAULT_DOWN_KEY = Input.Keys.DPAD_DOWN;

	private static final int DEFAULT_ZOOM_IN_KEY = Input.Keys.COMMA;
	private static final int DEFAULT_ZOOM_OUT_KEY = Input.Keys.PERIOD;
	private static final int DEFAULT_RESET_KEY = Input.Keys.SLASH;
	private static final int DEFAULT_LOG_KEY = Input.Keys.ENTER;

	private static final float DEFAULT_MOVE_SPEED = 20.0f;
	private static final float DEFAULT_ZOOM_SPEED = 2.0f;
	private static final float DEFAULT_ZOOM_VALUE = 1.0f;
	private static final float DEFAULT_MAX_ZOOM_IN = .20f;
	private static final float DEFAULT_MAX_ZOOM_OUT = 30f;



	// === attributes
	private Vector2 position = new Vector2();
	private Vector2 startPosition = new Vector2();
	private float zoom = DEFAULT_ZOOM_VALUE;


	// === constructor
	public DebugCameraController(){}


	// === public methods
	public void setStartPosition(float x, float y){
		startPosition.set(x,y);
		position.set(x, y);
	}

	public void applyTo(OrthographicCamera camera){
		camera.position.set(position,0);
		camera.zoom = zoom;
		camera.update();
	}

	public void handleDebugInput(float delta){
		// check if player is on desktop
		if(Gdx.app.getType() != Application.ApplicationType.Desktop)return;

		float moveSpeed = DEFAULT_MOVE_SPEED * delta;
		float zoomSpeed = DEFAULT_ZOOM_SPEED * delta;

		// move controls
		if(Gdx.input.isKeyPressed(DEFAULT_LEFT_KEY))moveLeft(moveSpeed);
		if(Gdx.input.isKeyPressed(DEFAULT_RIGHT_KEY))moveRight(moveSpeed);
		if(Gdx.input.isKeyPressed(DEFAULT_DOWN_KEY))moveDown(moveSpeed);
		if(Gdx.input.isKeyPressed(DEFAULT_UP_KEY))moveUp(moveSpeed);

		// zoom controls
		if(Gdx.input.isKeyPressed(DEFAULT_ZOOM_IN_KEY))zoomIn(zoomSpeed);
		if(Gdx.input.isKeyPressed(DEFAULT_ZOOM_OUT_KEY))zoomOut(zoomSpeed);

		// reset controls
		if(Gdx.input.isKeyPressed(DEFAULT_RESET_KEY))reset();

		// log controls
		if(Gdx.input.isKeyPressed(DEFAULT_LOG_KEY))logDebug();

	}


	// === private methods
	private void setPosition(float x, float y){
		position.set(x, y);
	}

	private void moveCamera(float xSpeed, float ySpeed){
		setPosition(position.x + xSpeed, position.y + ySpeed);
	}

	private void moveLeft(float speed){
		moveCamera(-speed,0);
	}
	private void moveRight(float speed){
		moveCamera(speed,0);
	}
	private void moveDown(float speed){
		moveCamera(0,-speed);
	}
	private void moveUp(float speed){
		moveCamera(0,speed);
	}

	private void setZoom(float value){
		// check if value is less than min or greater than max
		zoom = MathUtils.clamp(value,DEFAULT_MAX_ZOOM_IN, DEFAULT_MAX_ZOOM_OUT);
	}

	private void zoomIn(float zoomSpeed){
		setZoom(zoom + zoomSpeed);
	}

	private void zoomOut(float zoomSpeed){
		setZoom(zoom - zoomSpeed);
	}

	private void reset(){
		position.set(startPosition);
		setZoom(DEFAULT_ZOOM_VALUE);
	}

	private void logDebug(){
		log.debug("position=" + position + ", zoom=" + zoom);
	}
}
