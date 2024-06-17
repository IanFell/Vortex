package com.tornadogame.oldclasses;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class TornadoOriginal {
	
	private Rectangle rectangle;
	
	// Starting position of each tornado.
	private float originX;
	private float originY;
	
	private float x;
	private float y;
	private float radius;
	private float size;
	
	// Make tornado's y position descend with each spin.
	private float yPositionDecentValue;
	
	private float angle;
	
	// Determine if we should remove and add a tail to the array list.
	private int killTimer;
	
	private ArrayList <Rectangle> tail = new ArrayList <Rectangle>();
	
	private Texture texture;
	
	public TornadoOriginal(float x, float y, float radius) {
		this.x      = x;
		this.y      = y;
		this.radius = radius;
		size        = 45.0f;
		
		yPositionDecentValue = 0.5f;
		angle                = 0;
		killTimer            = 0;
		
		texture = getTailTexture();
		
		originX = Gdx.graphics.getWidth() / 4;
		originY = Gdx.graphics.getHeight() / 2;
		
		rectangle = new Rectangle(x, y, 100, 100);
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}

	private Texture getTailTexture() {
		Texture texture;
		Random random = new Random();
		int num = random.nextInt(100);
		texture = new Texture("WhiteSquare.png");
		if (num < 25) {
			texture = new Texture("Rain.png");
		} else if (num > 25 && num < 70) {
			texture = new Texture("RedSquare.png");
		}
		return texture;
	}
	
	public void draw(SpriteBatch batch) {
		batch.draw(new Texture("WhiteSquare.png"), rectangle.x, rectangle.y, 100, 100);
		tail.add(new Rectangle(x, y, size, size));

		for (int i = 0; i < tail.size(); i++) {
			if (tail.get(i) != null) {
				batch.draw(texture, tail.get(i).getX(), tail.get(i).getY(), size, size);
			}
		}
	}
	
	public void update() {
		x = ((float) (originX - Math.cos(angle) * radius));
		y = ((float) (originY + Math.sin(angle) * radius / 2) + yPositionDecentValue);
		yPositionDecentValue -= 0.7f;

		// This controls how fast the tornado spins.
		angle += 0.13f;
		if (radius > 0) {
			radius = radius - 0.20f;
		}
		
		killTimer += 1;
		if (killTimer % 2 == 0) {
			tail.remove(0);
			tail.add(new Rectangle(x, y, size, size));
		}
		
		rectangle.x = x;
		rectangle.y = y;
	}
	
	public void dispose() {
		texture.dispose();
	}

	public ArrayList<Rectangle> getTail() {
		return tail;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
}
