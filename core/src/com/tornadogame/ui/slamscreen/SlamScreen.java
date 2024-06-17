package com.tornadogame.ui.slamscreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.gameobjects.GameObject;

public class SlamScreen extends GameObject {

	private float maxWidth;
	private float minWidth;
	private boolean backgroundIsGrowingSplash;

	protected static Texture vortexSlam;

	private int slamScreenTimer;

	private final int SLAM_SCREEN_DURATION = 150;

	private float slamScreenWidth;
	private float slamScreenHeight;

	private float slamScreenX;
	private float slamScreenY;

	public SlamScreen(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);

		vortexSlam = new Texture("artwork/levels/endlevel/SplashScreenEnd.png");

		slamScreenTimer = 0;
		slamScreenX = TornadoGame.screenWidth / 2;
		slamScreenY = 0;
		slamScreenWidth = 0;
		slamScreenHeight = TornadoGame.screenHeight;

		backgroundIsGrowingSplash = true;
		maxWidth                  = width + 250;
		minWidth                  = width;
	}

	public void update() {
		slamScreenTimer++;
		if (slamScreenTimer > SLAM_SCREEN_DURATION) {
			handleStarsShining();
			// END GAME.   
			// TODO ::::: HERE IS WHERE THE GAME ENDS.   WHEN THIS HAPPENS, SWITCH THIS TO RESET TO NEW GAME.
			System.exit(0);
			//TornadoGame.gameHasBeenPlayedOnce = true;
			//TornadoGame.shouldReloadGame = true;
		}
		if (slamScreenX > 0) {
			slamScreenX -= 160;
		}
		if (slamScreenWidth < TornadoGame.screenWidth) {
			slamScreenWidth += 320;
		}
	}

	public void draw(SpriteBatch batch) {
		batch.draw(vortexSlam, slamScreenX, slamScreenY, slamScreenWidth, slamScreenHeight);
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

	public static void dispose() {
		vortexSlam.dispose();
	}
}
