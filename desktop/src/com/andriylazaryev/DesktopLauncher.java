package com.andriylazaryev;

import com.andriylazaryev.config.GameConfig;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.andriylazaryev.ObstacleAvoidGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

		config.setWindowSizeLimits((int)GameConfig.WIDTH, (int)GameConfig.HEIGHT,(int)GameConfig.WIDTH, (int)GameConfig.HEIGHT);

		new Lwjgl3Application(new ObstacleAvoidGame(), config);
	}
}
