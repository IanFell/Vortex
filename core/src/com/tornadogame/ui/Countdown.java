package com.tornadogame.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.gameobjects.GameObject;

public class Countdown extends GameObject {

	public static boolean stopCountdownTimer = false;

	public static boolean playCountdownSiren = false;

	private final int INCREMENT = 20;

	public static Texture[] number = new Texture[5];

	private float timer;

	private int numberToDraw;

	private int flash;

	private final int AMOUNT_OF_BEEPS = 5;

	public Countdown(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);

		number[0] = new Texture("artwork/ui/numbers/NUM_05.png");
		number[1] = new Texture("artwork/ui/numbers/NUM_04.png");
		number[2] = new Texture("artwork/ui/numbers/NUM_03.png");
		number[3] = new Texture("artwork/ui/numbers/NUM_02.png");
		number[4] = new Texture("artwork/ui/numbers/NUM_01.png");

		numberToDraw = 0;

		stopCountdownTimer = false;
	}

	public void update() {

		if (timer == 0) {
			playCountdownSiren = true;
		}

		timer++;
		if (timer > INCREMENT) {
			timer = 0;
			numberToDraw++;
		}

		flash++;
		if (flash > INCREMENT / 2) {
			flash = 0;
		}

		if (numberToDraw == AMOUNT_OF_BEEPS) {
			stopCountdownTimer = true;
		}
	}

	public void draw(SpriteBatch batch) {
		if (flash < 5) {
			if (numberToDraw == 0) {
				batch.draw(number[0], x, y, width, height);
			}
			else if (numberToDraw == 1) {
				batch.draw(number[1], x, y, width, height);
			}
			else if (numberToDraw == 2) {
				batch.draw(number[2], x, y, width, height);
			}
			else if (numberToDraw == 3) {
				batch.draw(number[3], x, y, width, height);
			}
			else if (numberToDraw == 4) {
				batch.draw(number[4], x, y, width, height);
			}
		}
	}

	public static void dispose() {
		for (int i = 0; i < number.length; i++) {
			number[i].dispose();
		}
	}
}
