package com.tornadogame.gameobjects.weapons;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.gameobjects.GameObject;
import com.tornadogame.gameobjects.Tornado;

public class ShrapnelDrop extends GameObject {

	public static boolean isDropped = false;

	public static boolean playDropAudio = false;

	private final float SCALE_VALUE = 5;

	public ShrapnelDrop(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
	}

	public void update(Tornado tornado) {
		rectangle.x      = x;
		rectangle.y      = y;
		rectangle.width  = width;
		rectangle.height = height;

		if (!isDropped) {
			tornado.setHasShrapnel(true);
			Random random = new Random();
			x = tornado.getX() + 50;
			int xDirection = random.nextInt(50);
			if (xDirection < 25) {
				x = tornado.getX() - 50;
			}
			y = tornado.getY();
			
			playDropAudio = true;
		} else {
			x += dx;
			y += dy;

			width += SCALE_VALUE;
			height += SCALE_VALUE;
			tornado.setHasShrapnel(false);
			
			/*
			if (!tornado.isHasShrapnel()) {
				
			}*/
		}
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		if (isDropped) {
			batch.draw(texture, x, y, width, height);
		}
	}
}
