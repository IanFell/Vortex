package com.tornadogame.gameobjects.powerups;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PointBoost extends PowerUp {

	private boolean playPointsBoostAudio;

	public static Texture[] starTexture = new Texture[5];

	private int animationTimer;
	private final int ANIMATION_TIMER_MAX = 25;

	public PointBoost(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
		shrapnelImage = new Texture("artwork/star/Star_01.png");

		starTexture[0] = new Texture("artwork/star/Star_01.png");
		starTexture[1] = new Texture("artwork/star/Star_02.png");
		starTexture[2] = new Texture("artwork/star/Star_03.png");
		starTexture[3] = new Texture("artwork/star/Star_04.png");
		starTexture[4] = new Texture("artwork/star/Star_05.png");

		animationTimer = 0;

		playPointsBoostAudio = false;
	}

	public boolean isPlayPointsBoostAudio() {
		return playPointsBoostAudio;
	}

	public void setPlayPointsBoostAudio(boolean playPointsBoostAudio) {
		this.playPointsBoostAudio = playPointsBoostAudio;
	}

	public void update() {
		if (!hasBeenCollected) {
			x += dx;
			rectangle.x = x;
			rectangle.y = y;

			for (int i = 0; i < shrapnel.length; i++) {
				shrapnel[i].x = x;
				shrapnel[i].y = y;
			}
			handleAnimationTimer();
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
	}

	private void handleAnimationTimer() {
		animationTimer++;
		if (animationTimer > ANIMATION_TIMER_MAX) {
			animationTimer = 0;
		}
	}

	public void draw(SpriteBatch batch) {
		if (!hasBeenCollected) {
			//batch.draw(texture, x, y, width, height);
			drawAnimatedStar(batch);
		} else {
			for (int i = 0; i < shrapnel.length; i++) {
				batch.draw(shrapnelImage, shrapnel[i].x, shrapnel[i].y, shrapnel[i].width, shrapnel[i].height);
			}
		}
	}

	private void drawAnimatedStar(SpriteBatch batch) {
		if (animationTimer < 5) {
			batch.draw(starTexture[0], x, y, width, height);
		}
		else if (animationTimer >= 5 && animationTimer < 10) {
			batch.draw(starTexture[1], x, y, width, height);
		}
		else if (animationTimer >= 10 && animationTimer < 15) {
			batch.draw(starTexture[2], x, y, width, height);
		}
		else if (animationTimer >= 15 && animationTimer < 20) {
			batch.draw(starTexture[3], x, y, width, height);
		}
		else if (animationTimer >= 20 && animationTimer < 25) {
			batch.draw(starTexture[4], x, y, width, height);
		}
	}

	public static void dispose() {
		for (int i = 0; i < starTexture.length; i++) {
			starTexture[i].dispose();
		}
	}
}
