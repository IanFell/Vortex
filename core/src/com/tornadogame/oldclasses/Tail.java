package com.tornadogame.oldclasses;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Tail {

	private float x;
	private float y;
	private float width;
	private float height;

	private Rectangle rectangle;

	private Texture img;

	public Tail(float x, float y, float size) {
		this.x      = x;
		this.y      = y;
		this.width  = size;
		this.height = size;
		rectangle   = new Rectangle(x, y, width, height);
		img         = new Texture("WhiteSquare.png");
	}

	public void draw(SpriteBatch batch) {
		batch.draw(img, x, y, width, height);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void dispose() {
		img.dispose();
	}
}
