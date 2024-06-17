package com.tornadogame.ui.splashscreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.gameobjects.GameObject;

public class SplashScreen extends GameObject {

	private int splashScreenTimer;

	private float maxWidth;
	private float minWidth;
	private boolean backgroundIsGrowingSplash;

	private final int SPLASH_SCREEN_DURATION      = 300;
	private final int RESOLUTION_WARNING_DURATION = 150;

	private Texture resolutionWarning;

	public SplashScreen(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
		splashScreenTimer         = 0;
		backgroundIsGrowingSplash = true;
		maxWidth                  = width + 250;
		minWidth                  = width;
		resolutionWarning         = new Texture("artwork/splashscreen/ResolutionWarning.png");
	}

	public void update() {
		splashScreenTimer++;
		if (splashScreenTimer > SPLASH_SCREEN_DURATION) {
			TornadoGame.splashScreenHasEnded = true;
		}
		handleStarsShining();
	}

	public void draw(SpriteBatch batch) {
		if (splashScreenTimer < RESOLUTION_WARNING_DURATION) {
			batch.draw(resolutionWarning, x, y, width, height);
		} else {
			batch.draw(texture, x, y, width, height);
		}
	}

	/**
	 * This method makes the background starts grow and shrink by slightly resizing
	 * the background image.
	 */
	@Override
	protected void handleStarsShining() {
		if (backgroundIsGrowingSplash) {
			if (width < maxWidth) {
				width += shineIncrement;
				height += shineIncrement;
			} 
			if (width >= maxWidth) {
				backgroundIsGrowingSplash = false;
			}
		}

		if (!backgroundIsGrowingSplash) {
			if (width > minWidth) {
				width -= shineIncrement;
				height -= shineIncrement;
			}
			if (width <= minWidth) {
				backgroundIsGrowingSplash = true;
			}
		}
	}
}
