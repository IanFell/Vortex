package com.tornadogame.gameobjects.powerups;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.gameobjects.Player;

public class SpeedBoost extends PowerUp {
	
	public static boolean playAudio = false;

	private int flashTimer;
	private final int FLASH_TIMER_MAX = 8;

	public SpeedBoost(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
		shrapnelImage    = new Texture("artwork/levels/farmlevel/SpeedBoost.png");
		flashTimer       = 0;
		rectangle.width  = width * 3;
		rectangle.height = height * 2;
	}

	@Override
	public void draw(SpriteBatch batch) {
		if (!hasBeenCollected) {
			if (flashTimer < FLASH_TIMER_MAX / 2) {
				batch.draw(texture, x, y, width, height);
			}
		} else {
			for (int i = 0; i < shrapnel.length; i++) {
				batch.draw(shrapnelImage, shrapnel[i].x, shrapnel[i].y, shrapnel[i].width, shrapnel[i].height);
			}
		}
	}

	private void handleFlashTimer() {
		flashTimer++;
		if (flashTimer > FLASH_TIMER_MAX) {
			flashTimer = 0;
		}
	}

	public void update(Player player) {
		x += dx;
		rectangle.x      = x;
		rectangle.y      = y;
		if (!hasBeenCollected) {

			for (int i = 0; i < shrapnel.length; i++) {
				shrapnel[i].x = x;
				shrapnel[i].y = y;
			}
			handleFlashTimer();
		} else {
			for (int i = 0; i < shrapnel.length; i++) {
				shrapnel[i].x += shrapnelDx[i];
				shrapnel[i].y += shrapnelDy[i];

				shrapnelDy[i] -= 10;
				shrapnel[i].y += shrapnelDy[i];
			}
			
			if (player.isHasSpeedBoost()) {
				boostTimer++;
				if (boostTimer > BOOST_DURATION / 2) {
					boostTimer = 0;
					player.setHasSpeedBoost(false);
				}
			}
		}		
	}
}
