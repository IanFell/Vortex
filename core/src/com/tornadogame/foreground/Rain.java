package com.tornadogame.foreground;

import com.badlogic.gdx.graphics.Texture;
import com.tornadogame.TornadoGame;
import com.tornadogame.gameobjects.GameObject;
import com.tornadogame.helpers.RandomNumberGenerator;

public class Rain extends GameObject {

	public Rain(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
		
		int color = RandomNumberGenerator.generateRandomInteger(100);
		if (color < 20) {
			this.texture = new Texture("artwork/ui/staticeffect/GraySquare.png");
		}
		if (color > 80) {
			this.texture = new Texture("WhiteSquare.png");
		}
	}

	public void update() {
		x -= dx;
		y -= dy;

		if (y < 0) {
			x = RandomNumberGenerator.generateRandomInteger((int) TornadoGame.screenWidth);
			y = TornadoGame.screenHeight;
		}
	}
}
