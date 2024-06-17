package com.tornadogame.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.gameobjects.GameObject;
import com.tornadogame.handlers.LevelHandler;
import com.tornadogame.handlers.WinnerHandler;

public class Score extends GameObject {

	public static Texture playerTextureToDraw;

	//private Texture[] playerAnimationTexture = new Texture[5];

	protected float playerAnimationTimer;

	public static Texture[] numbers = new Texture[10];
	private float numberSize;

	private float maggieTimer;

	public static Texture[] farmHead = new Texture[3];
	public static Texture[] spaceHead = new Texture[1];
	public static Texture[] beachHead = new Texture[3];
	public static Texture[] arcticHead = new Texture[3];
	public static Texture[] hellHead = new Texture[3];
	public static Texture[] cityHead = new Texture[3];
	public static Texture[] desertHead = new Texture[3];
	public static Texture[] forrestHead = new Texture[3];
	public static Texture[] trackHead = new Texture[3];
	public static Texture[] endHead = new Texture[3];

	public Score(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
		loadTornadoTextures();
		textureToDraw = animationTexture[0];
		//playerAnimationTexture[0] = new Texture("artwork/levels/testlevel/Player_01.png");
		//playerAnimationTexture[1] = new Texture("artwork/levels/testlevel/Player_02.png");
		//playerAnimationTexture[2] = new Texture("artwork/levels/testlevel/Player_03.png");
		//playerAnimationTexture[3] = new Texture("artwork/levels/testlevel/Player_02.png");
		//playerAnimationTexture[4] = new Texture("artwork/levels/testlevel/Player_03.png");
		playerTextureToDraw       = new Texture("artwork/cutscenes/MH.png");
		playerAnimationTimer      = 0;

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
		numberSize = 100;

		maggieTimer = 0;

		farmHead[0] = new Texture("artwork/player/heads/farmer/FarmerHead_01.png");
		farmHead[1] = new Texture("artwork/player/heads/farmer/FarmerHead_02.png");
		farmHead[2] = new Texture("artwork/player/heads/farmer/FarmerHead_03.png");

		spaceHead[0] = new Texture("artwork/player/heads/AstronautHead.png");

		beachHead[0] = new Texture("artwork/player/heads/beach/BeachHead_01.png");
		beachHead[1] = new Texture("artwork/player/heads/beach/BeachHead_02.png");
		beachHead[2] = new Texture("artwork/player/heads/beach/BeachHead_03.png");

		arcticHead[0] = new Texture("artwork/player/heads/arctic/ArcticHead_01.png");
		arcticHead[1] = new Texture("artwork/player/heads/arctic/ArcticHead_02.png");
		arcticHead[2] = new Texture("artwork/player/heads/arctic/ArcticHead_03.png");

		hellHead[0] = new Texture("artwork/player/heads/hell/HellHead_01.png");
		hellHead[1] = new Texture("artwork/player/heads/hell/HellHead_02.png");
		hellHead[2] = new Texture("artwork/player/heads/hell/HellHead_03.png");

		cityHead[0] = new Texture("artwork/player/heads/beach/BeachHead_01.png");
		cityHead[1] = new Texture("artwork/player/heads/beach/BeachHead_02.png");
		cityHead[2] = new Texture("artwork/player/heads/beach/BeachHead_03.png");

		desertHead[0] = new Texture("artwork/player/heads/beach/BeachHead_01.png");
		desertHead[1] = new Texture("artwork/player/heads/beach/BeachHead_02.png");
		desertHead[2] = new Texture("artwork/player/heads/beach/BeachHead_03.png");

		forrestHead[0] = new Texture("artwork/player/heads/beach/BeachHead_01.png");
		forrestHead[1] = new Texture("artwork/player/heads/beach/BeachHead_02.png");
		forrestHead[2] = new Texture("artwork/player/heads/beach/BeachHead_03.png");

		trackHead[0] = new Texture("artwork/player/heads/beach/BeachHead_01.png");
		trackHead[1] = new Texture("artwork/player/heads/beach/BeachHead_02.png");
		trackHead[2] = new Texture("artwork/player/heads/beach/BeachHead_03.png");

		endHead[0] = new Texture("artwork/player/heads/beach/BeachHead_01.png");
		endHead[1] = new Texture("artwork/player/heads/beach/BeachHead_02.png");
		endHead[2] = new Texture("artwork/player/heads/beach/BeachHead_03.png");
	}

	public void draw(SpriteBatch batch, int level) {
		batch.draw(textureToDraw, x, y, height, height);
		drawMaggie(batch, level, x + width - height, y, height);
		//batch.draw(playerTextureToDraw, x + width - height, y, height, height);
		batch.draw(getScoreTexture(WinnerHandler.tornadoScore), x + height * 2, TornadoGame.screenHeight - numberSize, numberSize, numberSize);
		batch.draw(getScoreTexture(WinnerHandler.playerScore), x + width - height * 3, TornadoGame.screenHeight - numberSize, numberSize, numberSize);
	}

	private void drawMaggie(SpriteBatch batch, int level, float x, float y, float size) {
		maggieTimer++;
		if (maggieTimer > 30) {
			maggieTimer = 0;
		}

		switch (level) {
		case LevelHandler.LEVEL_FARM:
			if (maggieTimer < 10) {
				playerTextureToDraw = farmHead[0];
			}
			else if (maggieTimer >= 10 && maggieTimer < 20) {
				playerTextureToDraw = farmHead[1];
			}
			else {
				playerTextureToDraw = farmHead[2];
			}
			break;
		case LevelHandler.LEVEL_SPACE:
			playerTextureToDraw = spaceHead[0];
			break;
		case LevelHandler.LEVEL_BEACH:
			if (maggieTimer < 10) {
				playerTextureToDraw = beachHead[0];
			}
			else if (maggieTimer >= 10 && maggieTimer < 20) {
				playerTextureToDraw = beachHead[1];
			}
			else {
				playerTextureToDraw = beachHead[2];
			}
			break;
		case LevelHandler.LEVEL_ARCTIC:
			if (maggieTimer < 10) {
				playerTextureToDraw = arcticHead[0];
			}
			else if (maggieTimer >= 10 && maggieTimer < 20) {
				playerTextureToDraw = arcticHead[1];
			}
			else {
				playerTextureToDraw = arcticHead[2];
			}
			break;
		case LevelHandler.LEVEL_HELL:
			if (maggieTimer < 10) {
				playerTextureToDraw = hellHead[0];
			}
			else if (maggieTimer >= 10 && maggieTimer < 20) {
				playerTextureToDraw = hellHead[1];
			}
			else {
				playerTextureToDraw = hellHead[2];
			}
			break;
		case LevelHandler.LEVEL_CITY:
			if (maggieTimer < 10) {
				playerTextureToDraw = cityHead[0];
			}
			else if (maggieTimer >= 10 && maggieTimer < 20) {
				playerTextureToDraw = cityHead[1];
			}
			else {
				playerTextureToDraw = cityHead[2];
			}
			break;
		case LevelHandler.LEVEL_DESERT:
			if (maggieTimer < 10) {
				playerTextureToDraw = beachHead[0];
			}
			else if (maggieTimer >= 10 && maggieTimer < 20) {
				playerTextureToDraw = beachHead[1];
			}
			else {
				playerTextureToDraw = beachHead[2];
			}
			break;
		case LevelHandler.LEVEL_FORREST:
			if (maggieTimer < 10) {
				playerTextureToDraw = forrestHead[0];
			}
			else if (maggieTimer >= 10 && maggieTimer < 20) {
				playerTextureToDraw = forrestHead[1];
			}
			else {
				playerTextureToDraw = forrestHead[2];
			}
			break;
		case LevelHandler.LEVEL_TRACK:
			if (maggieTimer < 10) {
				playerTextureToDraw = trackHead[0];
			}
			else if (maggieTimer >= 10 && maggieTimer < 20) {
				playerTextureToDraw = trackHead[1];
			}
			else {
				playerTextureToDraw = trackHead[2];
			}
			break;
		case LevelHandler.LEVEL_END:
			if (maggieTimer < 10) {
				playerTextureToDraw = endHead[0];
			}
			else if (maggieTimer >= 10 && maggieTimer < 20) {
				playerTextureToDraw = endHead[1];
			}
			else {
				playerTextureToDraw = endHead[2];
			}
			break;
		}
		batch.draw(playerTextureToDraw, x - 25, y - 15, size, size);
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

	public void update() {
		handleAnimation();
		//handlePlayerAnimation();
	}

	/*
	private void handlePlayerAnimation() {
		playerAnimationTimer++;
		if (playerAnimationTimer < 15) {
			if (playerAnimationTimer < 5) {
				playerTextureToDraw = playerAnimationTexture[0];
			}
			else if (playerAnimationTimer >= 3 && playerAnimationTimer < 6) {
				playerTextureToDraw = playerAnimationTexture[1];
			}
			else if (playerAnimationTimer >= 6 && playerAnimationTimer < 9) {
				playerTextureToDraw = playerAnimationTexture[2];
			}
			else if (playerAnimationTimer >= 9 && playerAnimationTimer < 12) {
				playerTextureToDraw = playerAnimationTexture[3];
			}
			else if (playerAnimationTimer >= 12 && playerAnimationTimer < 15) {
				playerTextureToDraw = playerAnimationTexture[4];
			}
		}
		if (playerAnimationTimer >= 15) {
			playerAnimationTimer = 0;
		}
	}*/

	public static void dispose() {
		playerTextureToDraw.dispose();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i].dispose();
		}
		spaceHead[0].dispose();
		for (int i = 0; i < farmHead.length; i++) {
			farmHead[i].dispose();
			beachHead[i].dispose();
			arcticHead[i].dispose();
			hellHead[i].dispose();
			cityHead[i].dispose();
			desertHead[i].dispose();
			forrestHead[i].dispose();
			trackHead[i].dispose();
			endHead[i].dispose();
		}
	}
}
