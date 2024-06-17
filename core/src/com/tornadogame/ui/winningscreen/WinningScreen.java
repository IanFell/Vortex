package com.tornadogame.ui.winningscreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.gameobjects.GameObject;
import com.tornadogame.handlers.WinnerHandler;

public class WinningScreen extends GameObject {

	//private int flashTimer;

	public static Texture winningScreenBackground;
	public static Texture winningScreenForeground;

	public static Texture[] numbers = new Texture[10];
	private float numberSize;

	public static Texture[] maggieHeads = new Texture[3];
	public static Texture playerTexture;

	private int animationTimer;
	private final int ANIMATION_TIMER_MAX = 30;

	public WinningScreen(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);

		winningScreenBackground = new Texture("artwork/winningscreen/WinningScreenBackground.png");
		winningScreenForeground = new Texture("artwork/winningscreen/WinningScreenForeground.png");

		numbers[0] = new Texture("artwork/ui/numbers/NUM_00.png");
		numbers[1] = new Texture("artwork/ui/numbers/NUM_01.png");
		numbers[2] = new Texture("artwork/ui/numbers/NUM_02.png");
		numbers[3] = new Texture("artwork/ui/numbers/NUM_03.png");
		numbers[4] = new Texture("artwork/ui/numbers/NUM_04.png");
		numbers[5] = new Texture("artwork/ui/numbers/NUM_05.png");
		numbers[6] = new Texture("artwork/ui/numbers/NUM_06.png");
		numbers[7] = new Texture("artwork/ui/numbers/NUM_07.png");
		numbers[8] = new Texture("artwork/ui/numbers/NUM_08.png");
		numbers[9] = new Texture("artwork/ui/numbers/NUM_09.png");
		numberSize = 400;

		loadMaggieTextures();
		playerTexture  = maggieHeads[0];

		loadTornadoTextures();
		textureToDraw = animationTexture[0];

		animationTimer = 0;

		//flashTimer = 0;
	}

	private void loadMaggieTextures() {
		maggieHeads[0] = new Texture("artwork/player/heads/beach/BeachHead_01.png");
		maggieHeads[1] = new Texture("artwork/player/heads/beach/BeachHead_02.png");
		maggieHeads[2] = new Texture("artwork/player/heads/beach/BeachHead_03.png");
	}

	public void draw(SpriteBatch batch, float tornadoScore, float maggieScore) {
		batch.draw(winningScreenBackground, x - width / 2, y - height / 2, width, height);
		batch.draw(winningScreenForeground, x - width / 2, y - height / 2, width, height);
		drawScore(batch, tornadoScore, maggieScore);

		//if (flashTimer > 0) {
		batch.draw(textureToDraw, x - width / 2 + numberSize, y - height / 2 + numberSize / 4, numberSize - 50, numberSize - 50);
		batch.draw(playerTexture, x + width / 2 - numberSize * 2, y - height / 2 + numberSize / 4, numberSize, numberSize);
		//}
		//updateFlashTimer();

	}

	/*
	private void updateFlashTimer() {
		flashTimer++;
		if (flashTimer > 10) {
			flashTimer = 0;
		}
		System.out.println(flashTimer);
	} */

	public void update(int placeHolder) {
		handleAnimation();
		animateMaggie();
	}

	private void animateMaggie() {
		animationTimer++;
		if (animationTimer > ANIMATION_TIMER_MAX) {
			animationTimer = 0;
		}

		if (animationTimer < 10) {
			playerTexture = maggieHeads[0];
		} else if (animationTimer >= 10 && animationTimer < 20) {
			playerTexture = maggieHeads[1];
		} else {
			playerTexture = maggieHeads[2];
		}
	}

	private void drawScore(SpriteBatch batch, float tornadoScore, float maggieScore) {
		batch.draw(getScoreTexture(WinnerHandler.tornadoScore), x - width / 2 + numberSize, y - height + (height / 2) + numberSize, numberSize, numberSize);
		batch.draw(getScoreTexture(WinnerHandler.playerScore), x + width / 2 - numberSize * 2, y - height / 2 + numberSize, numberSize, numberSize);
	}

	private Texture getScoreTexture(int score) {
		Texture texture = numbers[0];
		switch (score) {
		case 0:
			texture = numbers[0];
			break;
		case 1:
			texture = numbers[1];
			break;
		case 2:
			texture = numbers[2];
			break;
		case 3:
			texture = numbers[3];
			break;
		case 4:
			texture = numbers[4];
			break;
		case 5:
			texture = numbers[5];
			break;
		case 6:
			texture = numbers[6];
			break;
		case 7:
			texture = numbers[7];
			break;
		case 8:
			texture = numbers[8];
			break;
		case 9:
			texture = numbers[9];
			break;
		}
		return texture;
	}

	public static void dispose() {
		winningScreenBackground.dispose();
		winningScreenForeground.dispose();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i].dispose();
		}
		for (int i = 0; i < maggieHeads.length; i++) {
			maggieHeads[i].dispose();
		}
		playerTexture.dispose();
	}
}
