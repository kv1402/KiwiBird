package com.kv1402.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.kv1402.game.FlappyDemo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width= FlappyDemo.WIDTH;
		config.height= FlappyDemo.HEIGHT;
		config.title= FlappyDemo.TITTLE;
		new LwjglApplication(new FlappyDemo(), config);
	}
}
