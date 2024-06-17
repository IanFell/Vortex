package com.tornadogame.foreground;

import com.badlogic.gdx.graphics.Texture;
import com.tornadogame.helpers.RandomNumberGenerator;

public class Fire extends Snow {

	public Fire(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);

		int color = RandomNumberGenerator.generateRandomInteger(100);
		if (color < 20) {
			this.texture = new Texture("PinkSquare.png");
		}
		if (color > 80) {
			this.texture = new Texture("OrangeSquare.png");
		}
	}
}
