package com.tornadogame.gameobjects.powerups;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.helpers.RandomNumberGenerator;

public class SuckBoost extends PowerUp {

	private final int BOOST_DURATION_SUCK = 300;

	private static int boosterTimer;

	public SuckBoost(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
		loadTornadoTextures();
		textureToDraw = animationTexture[0];
		shrapnelImage = new Texture("artwork/levels/testlevel/tornado/Tornado_01.png");
		boosterTimer  = 0;
	}

	public void update(Tornado tornado) {

		x += dx;
		rectangle.x = x;
		rectangle.y = y;

		if (tornado.isHasSuckBoost()) {
			boosterTimer++;
			if (boosterTimer > BOOST_DURATION_SUCK) { 
				boosterTimer = 0;
				tornado.setHasSuckBoost(false);
			}
		}

		if (!hasBeenCollected) {
			for (int i = 0; i < shrapnel.length; i++) {
				shrapnel[i].x = x;
				shrapnel[i].y = y;
			}
		} else {
			for (int i = 0; i < shrapnel.length; i++) {
				shrapnel[i].x += shrapnelDx[i];
				shrapnel[i].y += shrapnelDy[i];

				if (shrapnelDx[i] > 0) {
					shrapnelDx[i] -= 2;
				}
				shrapnelDy[i] -= 10;
				shrapnel[i].y += shrapnelDy[i];
			}
		}	
		handleAnimation();
	}

	public void draw(SpriteBatch batch) {
		int randomColor = RandomNumberGenerator.generateRandomInteger(100);
		Color color = Color.RED;
		if (randomColor < 50) {
			color = Color.BLUE;
		}
		batch.setColor(color);
		if (!hasBeenCollected) {
			batch.draw(textureToDraw, x, y, width, height);
		} else {
			for (int i = 0; i < shrapnel.length; i++) {
				batch.draw(shrapnelImage, shrapnel[i].x, shrapnel[i].y, shrapnel[i].width, shrapnel[i].height);
			}
		}
		batch.setColor(Color.WHITE);
	}
}
