package com.tornadogame.foreground;

import com.badlogic.gdx.graphics.Texture;
import com.tornadogame.TornadoGame;
import com.tornadogame.gameobjects.GameObject;

public class Debree extends GameObject {

	public Debree(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
	}

	public void update() {
		x += dx;
		if (x < 0) {
			x = TornadoGame.screenWidth;
		}
	}
}
