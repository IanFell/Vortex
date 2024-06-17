package com.tornadogame.backgrounds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.levels.Level;

public class MidLayer extends Background {

	private float x1 = 0;
	private float x2 = Gdx.graphics.getWidth();
	private float x3 = Gdx.graphics.getWidth() * 2;

	private float speedUpDx;

	private float slowDownDx1;
	private float slowDownDx2;
	private float slowDownDx3;

	public MidLayer(float x, float y, float width, float height, Texture texture, float dx, float dy, float scrollSpeed) {
		super(x, y, width, height, texture, dx, dy, scrollSpeed);
		speedUpDx        = 0;
		this.slowDownDx1 = scrollSpeed;
		this.slowDownDx2 = scrollSpeed;
		this.slowDownDx3 = scrollSpeed;
	}

	public void update(Player player, Level level) {
		if (!level.isLevelIsOver()) {
			if (player.isHasSpeedBoost()) {
				x1 += dx * 2;
				x2 += dx * 2;
				x3 += dx * 2;
			} else {
				x1 += dx;
				x2 += dx;
				x3 += dx;
			}

			if (x1 <= - Gdx.graphics.getWidth() + 100) {
				x1 = Gdx.graphics.getWidth() * 2;
			}
			if (x2 <= - Gdx.graphics.getWidth() + 100) {
				x2 = Gdx.graphics.getWidth() * 2;
			}
			if (x3 <= - Gdx.graphics.getWidth() + 100) {
				x3 = Gdx.graphics.getWidth() * 2;
			}

			speedUpScrollingAtStartOfLevel();
		} else {
			slowDownScrollingAtEndOfLevel();
		}
	}

	private void slowDownScrollingAtEndOfLevel() {
		if (dx <= 0) {
			x1 += slowDownDx1;
			x2 += slowDownDx2;
			x3 += slowDownDx3;

			float slowDownSpeed = 2;
			if (slowDownDx1 <= 0) {
				slowDownDx1 += slowDownSpeed;
			}
			if (slowDownDx2 <= 0) {
				slowDownDx2 += slowDownSpeed;
			} 
			if (slowDownDx3 <= 0) {
				slowDownDx3 += slowDownSpeed;
			} 
		}
	}

	private void speedUpScrollingAtStartOfLevel() {
		if (dx > scrollSpeed) {
			dx += speedUpDx;
			speedUpDx -= 0.1f;
		}
	}

	@Override
	public void draw(SpriteBatch batch) {
		// Stretch the texture a little bit so it doesn't render with gaps.
		batch.draw(texture, x1 - 100, 0, Gdx.graphics.getWidth() + 200, Gdx.graphics.getHeight());
		batch.draw(texture, x2 - 100, 0, Gdx.graphics.getWidth() + 200, Gdx.graphics.getHeight());
		batch.draw(texture, x3 - 100, 0, Gdx.graphics.getWidth() + 200, Gdx.graphics.getHeight());
	}
}
