package com.tornadogame.gameobjects.powerups;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.tornadogame.gameobjects.GameObject;

public class PowerUp extends GameObject {

	protected final int BOOST_DURATION = 200;

	protected int boostTimer;

	protected boolean hasBeenCollected;

	protected Rectangle[] shrapnel = new Rectangle[8];
	protected float[] shrapnelDx   = new float[8];
	protected float[] shrapnelDy   = new float[8];

	public static Texture shrapnelImage;

	public PowerUp(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
		boostTimer       = 0;
		hasBeenCollected = false;

		for (int i = 0; i < shrapnel.length; i++) {
			shrapnel[i] = new Rectangle(x, y, 100, 100);

			Random random = new Random();
			float randomShrapnelDx = random.nextInt(100);
			if (randomShrapnelDx < 10) {
				shrapnelDx[i] = 15;
			} else if (randomShrapnelDx >= 10 && randomShrapnelDx < 25) {
				shrapnelDx[i] = -23;
			} else if (randomShrapnelDx >= 25 && randomShrapnelDx < 40) {
				shrapnelDx[i] = 37;
			} else if (randomShrapnelDx >= 40 && randomShrapnelDx < 50) {
				shrapnelDx[i] = -40;
			} else if (randomShrapnelDx >= 50 && randomShrapnelDx < 65) {
				shrapnelDx[i] = 50;
			} else if (randomShrapnelDx >= 65 && randomShrapnelDx < 75) {
				shrapnelDx[i] = -35;
			} else if (randomShrapnelDx >= 75 && randomShrapnelDx < 85) {
				shrapnelDx[i] = 40;
			} else {
				shrapnelDx[i] = -50;
			}
			shrapnelDy[i] = 100;
		}
	}

	public void setHasBeenCollected(boolean hasBeenCollected) {
		this.hasBeenCollected = hasBeenCollected;
	}

	public boolean isHasBeenCollected() {
		return hasBeenCollected;
	}

	public static void dispose() {
		shrapnelImage.dispose();
	}
}
