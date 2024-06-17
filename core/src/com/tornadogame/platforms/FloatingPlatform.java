package com.tornadogame.platforms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.handlers.LevelHandler;
import com.tornadogame.levels.Level;

public class FloatingPlatform extends Platform {

	public FloatingPlatform(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
	}

	public void update() {
		x += dx;
	}
}
