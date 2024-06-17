package com.tornadogame.backgrounds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BackLayer extends Background {

	public BackLayer(float x, float y, float width, float height, Texture texture, float dx, float dy, float scrollSpeed) {
		super(x, y, width, height, texture, dx, dy, scrollSpeed);
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		// Stretch image so it doesn't go offscreen during screen shake.
		batch.draw(texture, x - 100, y, width + 200, height);
	}
}
