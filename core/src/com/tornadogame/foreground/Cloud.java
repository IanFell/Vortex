package com.tornadogame.foreground;

import com.badlogic.gdx.graphics.Texture;
import com.tornadogame.TornadoGame;
import com.tornadogame.gameobjects.GameObject;

public class Cloud extends GameObject {

	public Cloud(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
		this.texture = new Texture("artwork/levels/Cloud.png");
	}

	public void update() {
		x -= dx;
		y -= dy;

		if (x < -TornadoGame.screenWidth) {
			x = TornadoGame.screenWidth;
		}
	}
}
