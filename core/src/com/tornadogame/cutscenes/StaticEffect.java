package com.tornadogame.cutscenes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.gameobjects.GameObject;
import com.tornadogame.helpers.RandomNumberGenerator;

public class StaticEffect extends GameObject {

	private int flashTimerMax;
	private int flashTimer;
	private boolean canDraw;

	public StaticEffect(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
		flashTimer    = 0;
		flashTimerMax = RandomNumberGenerator.generateRandomInteger(50);
		canDraw       = true;
	}

	@Override
	public void draw(SpriteBatch batch) {
		if (canDraw) {
			batch.draw(texture, x, y, width, height);
		}
	}

	public void update() {
		flashTimer++;
		if (flashTimer > flashTimerMax) {
			flashTimer = 0;
		}
		canDraw = false;
		if (flashTimer < flashTimerMax / 2) {
			canDraw = true;
		}
	}
}
