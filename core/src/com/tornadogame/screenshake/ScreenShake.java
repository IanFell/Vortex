package com.tornadogame.screenshake;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class ScreenShake {

	public static boolean screenIsShaking = false;

	private float durationOfScreenShakeInMilliseconds;

	private float elapsedScreenShakeTime;

	private int timer = 0;

	public static final int SHAKE_VALUE = 10;

	/**
	 * Start the screen shaking with a given power and duration.
	 *
	 * @param float radius 
	 * @param float duration 
	 */
	public void shake(float radius , float duration) {
		elapsedScreenShakeTime              = 0;
		durationOfScreenShakeInMilliseconds = duration / 1000f;
		screenIsShaking                     = true;
	}

	/**
	 * Updates the shake and the camera.
	 * This must be called prior to camera.update().
	 * 
	 * @param float              delta
	 * @param OrthographicCamera camera
	 * @param GameObject         player
	 */
	public void update(OrthographicCamera camera) {
		// Only shake when required.
		if((elapsedScreenShakeTime < durationOfScreenShakeInMilliseconds)) {
			float x = 50;
			timer++;
			if (timer % 2 == 0) {
				x = -x;
			}
			float y = 0;
			camera.translate(-x, y);

			// Increase the elapsed time by the delta provided.
			elapsedScreenShakeTime += 10;
		} 
	}
}
