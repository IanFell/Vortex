package com.tornadogame.platforms;

import com.badlogic.gdx.graphics.Texture;
import com.tornadogame.gameobjects.GameObject;

public class Platform extends GameObject {

	public Platform(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
	}
}
