package com.tornadogame.foreground;

import com.badlogic.gdx.graphics.Texture;
import com.tornadogame.TornadoGame;
import com.tornadogame.gameobjects.GameObject;
import com.tornadogame.helpers.RandomNumberGenerator;

public class Wind extends GameObject {

	public Wind(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);

		int color = RandomNumberGenerator.generateRandomInteger(100);
		if (color < 50) {
			this.texture = new Texture("artwork/ui/staticeffect/GraySquare.png");
		} else {
			this.texture = new Texture("WhiteSquare.png");
		}
	}

	public void update() {
		x -= dx;
		y -= dy;

		if (x  + width < 0) {
			x = TornadoGame.screenWidth;
			y = RandomNumberGenerator.generateRandomInteger((int) TornadoGame.screenHeight);
		}
	}
}
