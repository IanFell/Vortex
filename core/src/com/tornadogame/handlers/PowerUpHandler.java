package com.tornadogame.handlers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.backgrounds.Background;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.gameobjects.powerups.PointBoost;
import com.tornadogame.gameobjects.powerups.SpeedBoost;
import com.tornadogame.gameobjects.powerups.SuckBoost;
import com.tornadogame.layout.Layout;

public class PowerUpHandler {

	private final int SIZE = 300;

	private SpeedBoost[] speedBoost = new SpeedBoost[2];

	private SuckBoost[] suckBoost = new SuckBoost[3];

	private PointBoost[] pointBoost = new PointBoost[4];

	protected static Texture suckBoostTexture;
	protected static Texture speedBoostTexture;

	public PowerUpHandler(PlatformHandler platformHandler, int levelToLoad) {
		suckBoostTexture  = new Texture("YellowSquare.png");
		speedBoostTexture = new Texture("artwork/levels/farmlevel/SpeedBoost.png");

		switch (levelToLoad) {
		case LevelHandler.LEVEL_TEST:
			loadTestLevel(platformHandler);
			break;
		case LevelHandler.LEVEL_FARM:
			loadFarmLevel(platformHandler);
			break;
		case LevelHandler.LEVEL_SPACE:
			loadSpaceLevel(platformHandler);
			break;
		case LevelHandler.LEVEL_BEACH:
			loadBeachLevel(platformHandler);
			break;
		case LevelHandler.LEVEL_ARCTIC:
			loadArcticLevel(platformHandler);
			break;
		case LevelHandler.LEVEL_HELL:
			loadHellLevel(platformHandler);
			break;
		case LevelHandler.LEVEL_CITY:
			loadCityLevel(platformHandler);
			break;
		case LevelHandler.LEVEL_DESERT:
			loadDesertLevel(platformHandler);
			break;
		case LevelHandler.LEVEL_FORREST:
			loadForrestLevel(platformHandler);
			break;
		case LevelHandler.LEVEL_TRACK:
			loadTrackLevel(platformHandler);
			break;
		case LevelHandler.LEVEL_END:
			loadTrackLevel(platformHandler);
			break;
		case LevelHandler.LEVEL_DOUBLE:
			loadTrackLevel(platformHandler);
			break;
		}
	}
	
	private void loadTrackLevel(PlatformHandler platformHandler) {
		suckBoost[0] = new SuckBoost(Layout.GRID_10 + TornadoGame.screenWidth / 2 - SIZE / 2, TornadoGame.screenHeight / 2, SIZE, SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		suckBoost[1] = new SuckBoost(Layout.GRID_30, TornadoGame.screenHeight - SIZE, SIZE , SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		suckBoost[2] = new SuckBoost(Layout.GRID_50, platformHandler.getGround().getY(), SIZE, SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		speedBoost[0]   = new SpeedBoost(
				Layout.GRID_20 + SIZE * 2, 
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE * 3, 
				SIZE * 2, 
				speedBoostTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0
				);
		speedBoost[1]   = new SpeedBoost(
				Layout.GRID_40 + TornadoGame.screenWidth - SIZE, 
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE * 3, 
				SIZE * 2, 
				speedBoostTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0
				);

		pointBoost[0] = new PointBoost(Layout.GRID_10 + TornadoGame.screenWidth - SIZE, TornadoGame.screenHeight / 2, SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[1] = new PointBoost(Layout.GRID_20, platformHandler.getPlatforms()[26].getY(), SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[2] = new PointBoost(Layout.GRID_30 + TornadoGame.screenWidth / 2 - SIZE / 2, TornadoGame.screenHeight / 2 - SIZE / 2, SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[3] = new PointBoost(Layout.GRID_40, platformHandler.getGround().getY(), SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
	}
	
	private void loadForrestLevel(PlatformHandler platformHandler) {
		suckBoost[0] = new SuckBoost(Layout.GRID_10 + TornadoGame.screenWidth / 2 - SIZE / 2, TornadoGame.screenHeight / 2, SIZE, SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		suckBoost[1] = new SuckBoost(Layout.GRID_30, TornadoGame.screenHeight - SIZE, SIZE , SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		suckBoost[2] = new SuckBoost(Layout.GRID_50, platformHandler.getGround().getY(), SIZE, SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		speedBoost[0]   = new SpeedBoost(
				Layout.GRID_20 + SIZE * 2, 
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE * 3, 
				SIZE * 2, 
				speedBoostTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0
				);
		speedBoost[1]   = new SpeedBoost(
				Layout.GRID_40 + TornadoGame.screenWidth - SIZE, 
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE * 3, 
				SIZE * 2, 
				speedBoostTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0
				);

		pointBoost[0] = new PointBoost(Layout.GRID_10 + TornadoGame.screenWidth - SIZE, TornadoGame.screenHeight / 2, SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[1] = new PointBoost(Layout.GRID_20, platformHandler.getPlatforms()[26].getY(), SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[2] = new PointBoost(Layout.GRID_30 + TornadoGame.screenWidth / 2 - SIZE / 2, TornadoGame.screenHeight / 2 - SIZE / 2, SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[3] = new PointBoost(Layout.GRID_40, platformHandler.getGround().getY(), SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
	}
	
	private void loadDesertLevel(PlatformHandler platformHandler) {
		suckBoost[0] = new SuckBoost(Layout.GRID_10 + TornadoGame.screenWidth / 2 - SIZE / 2, TornadoGame.screenHeight / 2, SIZE, SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		suckBoost[1] = new SuckBoost(Layout.GRID_30, TornadoGame.screenHeight - SIZE, SIZE , SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		suckBoost[2] = new SuckBoost(Layout.GRID_50, platformHandler.getGround().getY(), SIZE, SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		speedBoost[0]   = new SpeedBoost(
				Layout.GRID_20 + SIZE * 2, 
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE * 3, 
				SIZE * 2, 
				speedBoostTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0
				);
		speedBoost[1]   = new SpeedBoost(
				Layout.GRID_40 + TornadoGame.screenWidth - SIZE, 
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE * 3, 
				SIZE * 2, 
				speedBoostTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0
				);

		pointBoost[0] = new PointBoost(Layout.GRID_10 + TornadoGame.screenWidth - SIZE, TornadoGame.screenHeight / 2, SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[1] = new PointBoost(Layout.GRID_20, platformHandler.getPlatforms()[26].getY(), SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[2] = new PointBoost(Layout.GRID_30 + TornadoGame.screenWidth / 2 - SIZE / 2, TornadoGame.screenHeight / 2 - SIZE / 2, SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[3] = new PointBoost(Layout.GRID_40, platformHandler.getGround().getY(), SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
	}
	
	private void loadCityLevel(PlatformHandler platformHandler) {
		suckBoost[0] = new SuckBoost(Layout.GRID_10 + TornadoGame.screenWidth / 2 - SIZE / 2, TornadoGame.screenHeight / 2, SIZE, SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		suckBoost[1] = new SuckBoost(Layout.GRID_30, TornadoGame.screenHeight - SIZE, SIZE , SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		suckBoost[2] = new SuckBoost(Layout.GRID_50, platformHandler.getGround().getY(), SIZE, SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		speedBoost[0]   = new SpeedBoost(
				Layout.GRID_20 + SIZE * 2, 
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE * 3, 
				SIZE * 2, 
				speedBoostTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0
				);
		speedBoost[1]   = new SpeedBoost(
				Layout.GRID_40 + TornadoGame.screenWidth - SIZE, 
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE * 3, 
				SIZE * 2, 
				speedBoostTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0
				);

		pointBoost[0] = new PointBoost(Layout.GRID_10 + TornadoGame.screenWidth - SIZE, TornadoGame.screenHeight / 2, SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[1] = new PointBoost(Layout.GRID_20, platformHandler.getPlatforms()[26].getY(), SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[2] = new PointBoost(Layout.GRID_30 + TornadoGame.screenWidth / 2 - SIZE / 2, TornadoGame.screenHeight / 2 - SIZE / 2, SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[3] = new PointBoost(Layout.GRID_40, platformHandler.getGround().getY(), SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
	}
	
	private void loadHellLevel(PlatformHandler platformHandler) {
		suckBoost[0] = new SuckBoost(Layout.GRID_10 + TornadoGame.screenWidth / 2 - SIZE / 2, TornadoGame.screenHeight / 2, SIZE, SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		suckBoost[1] = new SuckBoost(Layout.GRID_30, TornadoGame.screenHeight - SIZE, SIZE , SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		suckBoost[2] = new SuckBoost(Layout.GRID_50, platformHandler.getGround().getY(), SIZE, SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		speedBoost[0]   = new SpeedBoost(
				Layout.GRID_20 + SIZE * 2, 
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE * 3, 
				SIZE * 2, 
				speedBoostTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0
				);
		speedBoost[1]   = new SpeedBoost(
				Layout.GRID_40 + TornadoGame.screenWidth - SIZE, 
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE * 3, 
				SIZE * 2, 
				speedBoostTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0
				);

		pointBoost[0] = new PointBoost(Layout.GRID_10 + TornadoGame.screenWidth - SIZE, TornadoGame.screenHeight / 2, SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[1] = new PointBoost(Layout.GRID_20, platformHandler.getPlatforms()[26].getY(), SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[2] = new PointBoost(Layout.GRID_30 + TornadoGame.screenWidth / 2 - SIZE / 2, TornadoGame.screenHeight / 2 - SIZE / 2, SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[3] = new PointBoost(Layout.GRID_40, platformHandler.getGround().getY(), SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
	}
	
	private void loadArcticLevel(PlatformHandler platformHandler) {
		suckBoost[0] = new SuckBoost(Layout.GRID_12 + TornadoGame.screenWidth / 2 - SIZE / 2, TornadoGame.screenHeight / 2, SIZE, SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		suckBoost[1] = new SuckBoost(Layout.GRID_25, TornadoGame.screenHeight - SIZE, SIZE , SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		suckBoost[2] = new SuckBoost(Layout.GRID_33, platformHandler.getGround().getY(), SIZE, SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		speedBoost[0]   = new SpeedBoost(
				Layout.GRID_17, 
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE * 3, 
				SIZE * 2, 
				speedBoostTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0
				);
		speedBoost[1]   = new SpeedBoost(
				Layout.GRID_33 + TornadoGame.screenWidth - SIZE, 
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE * 3, 
				SIZE * 2, 
				speedBoostTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0
				);

		pointBoost[0] = new PointBoost(Layout.GRID_09 + TornadoGame.screenWidth - SIZE, TornadoGame.screenHeight / 2, SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[1] = new PointBoost(platformHandler.getPlatforms()[26].getX() + platformHandler.getPlatforms()[26].getWidth() / 2 - SIZE / 2, platformHandler.getPlatforms()[26].getY(), SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[2] = new PointBoost(Layout.GRID_31 + TornadoGame.screenWidth / 2 - SIZE / 2, TornadoGame.screenHeight / 2 - SIZE / 2, SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[3] = new PointBoost(Layout.GRID_39, platformHandler.getGround().getY(), SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
	}

	private void loadBeachLevel(PlatformHandler platformHandler) {
		suckBoost[0] = new SuckBoost(Layout.GRID_12 + TornadoGame.screenWidth / 2 - SIZE / 2, TornadoGame.screenHeight / 2, SIZE, SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		suckBoost[1] = new SuckBoost(Layout.GRID_25, TornadoGame.screenHeight - SIZE, SIZE , SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		suckBoost[2] = new SuckBoost(Layout.GRID_33, platformHandler.getGround().getY(), SIZE, SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		speedBoost[0]   = new SpeedBoost(
				Layout.GRID_17, 
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE * 3, 
				SIZE * 2, 
				speedBoostTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0
				);
		speedBoost[1]   = new SpeedBoost(
				Layout.GRID_33 + TornadoGame.screenWidth - SIZE, 
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE * 3, 
				SIZE * 2, 
				speedBoostTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0
				);

		pointBoost[0] = new PointBoost(Layout.GRID_09 + TornadoGame.screenWidth - SIZE, TornadoGame.screenHeight / 2, SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[1] = new PointBoost(platformHandler.getPlatforms()[26].getX() + platformHandler.getPlatforms()[26].getWidth() / 2 - SIZE / 2, platformHandler.getPlatforms()[26].getY(), SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[2] = new PointBoost(Layout.GRID_31 + TornadoGame.screenWidth / 2 - SIZE / 2, TornadoGame.screenHeight / 2 - SIZE / 2, SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[3] = new PointBoost(Layout.GRID_39, platformHandler.getGround().getY(), SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
	}

	private void loadSpaceLevel(PlatformHandler platformHandler) {
		suckBoost[0] = new SuckBoost(Layout.GRID_12 + TornadoGame.screenWidth - SIZE, platformHandler.getGround().getY(), SIZE, SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		suckBoost[1] = new SuckBoost(Layout.GRID_25, TornadoGame.screenHeight - SIZE, SIZE , SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		suckBoost[2] = new SuckBoost(Layout.GRID_33, platformHandler.getGround().getY(), SIZE, SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		speedBoost[0]   = new SpeedBoost(
				Layout.GRID_17 + TornadoGame.screenWidth - SIZE, 
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE * 3, 
				SIZE * 2, 
				speedBoostTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0
				);
		speedBoost[1]   = new SpeedBoost(
				Layout.GRID_33 + TornadoGame.screenWidth - SIZE, 
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE * 3, 
				SIZE * 2, 
				speedBoostTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0
				);

		pointBoost[0] = new PointBoost(Layout.GRID_09 + TornadoGame.screenWidth / 2 - SIZE / 2, platformHandler.getGround().getY(), SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[1] = new PointBoost(platformHandler.getPlatforms()[21].getX() + platformHandler.getPlatforms()[21].getWidth() / 2 - SIZE / 2, platformHandler.getPlatforms()[21].getY(), SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[2] = new PointBoost(Layout.GRID_31 + TornadoGame.screenWidth / 2 - SIZE / 2, TornadoGame.screenHeight / 2 - SIZE / 2, SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[3] = new PointBoost(platformHandler.getPlatforms()[54].getX() + platformHandler.getPlatforms()[54].getWidth() / 2 - SIZE / 2, platformHandler.getPlatforms()[54].getY() + SIZE, SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
	}

	private void loadFarmLevel(PlatformHandler platformHandler) {
		suckBoost[0] = new SuckBoost(Layout.GRID_13, TornadoGame.screenHeight - SIZE, SIZE, SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		suckBoost[1] = new SuckBoost(Layout.GRID_25, TornadoGame.screenHeight - SIZE, SIZE , SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		suckBoost[2] = new SuckBoost(Layout.GRID_33, TornadoGame.screenHeight - SIZE , SIZE, SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		speedBoost[0]   = new SpeedBoost(
				Layout.GRID_17 + TornadoGame.screenWidth / 2 - SIZE / 2, 
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE * 3, 
				SIZE * 2, 
				speedBoostTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0
				);
		speedBoost[1]   = new SpeedBoost(
				Layout.GRID_33, 
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE * 3, 
				SIZE * 2, 
				speedBoostTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0
				);

		pointBoost[0] = new PointBoost(Layout.GRID_09 + TornadoGame.screenWidth / 2 - SIZE / 2, TornadoGame.screenHeight / 2 - SIZE / 2, SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[1] = new PointBoost(Layout.GRID_24 + TornadoGame.screenWidth / 2 - SIZE / 2, TornadoGame.screenHeight / 2 - SIZE / 2, SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[2] = new PointBoost(Layout.GRID_31 + TornadoGame.screenWidth / 2 - SIZE / 2, platformHandler.getPlatforms()[23].getY() + platformHandler.getPlatforms()[23].getHeight(), SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[3] = new PointBoost(Layout.GRID_39 + TornadoGame.screenWidth / 2 - SIZE / 2, platformHandler.getPlatforms()[23].getY() + platformHandler.getPlatforms()[23].getHeight(), SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
	}

	private void loadTestLevel(PlatformHandler platformHandler) {
		suckBoost[0] = new SuckBoost(Layout.GRID_03 + TornadoGame.screenWidth - SIZE, TornadoGame.screenHeight - SIZE, SIZE, SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		suckBoost[1] = new SuckBoost(Layout.GRID_10, TornadoGame.screenHeight - SIZE, SIZE , SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		suckBoost[2] = new SuckBoost(Layout.GRID_17, TornadoGame.screenHeight - SIZE , SIZE, SIZE, suckBoostTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		speedBoost[0]   = new SpeedBoost(
				Layout.GRID_10 + TornadoGame.screenWidth - SIZE, 
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE, 
				SIZE, 
				speedBoostTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0
				);
		speedBoost[1]   = new SpeedBoost(
				Layout.GRID_10 + TornadoGame.screenWidth - SIZE, 
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE, 
				SIZE, 
				speedBoostTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0
				);

		pointBoost[0] = new PointBoost(Layout.GRID_07 + TornadoGame.screenWidth / 2 - SIZE / 2, TornadoGame.screenHeight / 2 - SIZE / 2, SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[1] = new PointBoost(Layout.GRID_14 + TornadoGame.screenWidth / 2 - SIZE / 2, TornadoGame.screenHeight / 2 - SIZE / 2, SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[2] = new PointBoost(platformHandler.getPlatforms()[23].getX() + platformHandler.getPlatforms()[23].getWidth() - SIZE * 2, platformHandler.getPlatforms()[23].getY() + platformHandler.getPlatforms()[23].getHeight(), SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		pointBoost[3] = new PointBoost(platformHandler.getPlatforms()[23].getX() + platformHandler.getPlatforms()[23].getWidth() - SIZE * 2, platformHandler.getPlatforms()[23].getY() + platformHandler.getPlatforms()[23].getHeight(), SIZE * 2, SIZE * 2, null, Background.SCROLL_SPEED_FRONT_LAYER, 0);
	}

	public void draw(SpriteBatch batch) {
		for (int i = 0; i < speedBoost.length; i++) {
			speedBoost[i].draw(batch);
		}
		for (int i = 0; i < suckBoost.length; i++) {
			suckBoost[i].draw(batch);
		}
		for (int i = 0; i < pointBoost.length; i++) {
			pointBoost[i].draw(batch);
		}
	}

	public void update(Tornado tornado, Player player) {
		for (int i = 0; i < speedBoost.length; i++) {
			speedBoost[i].update(player);
		}
		for (int i = 0; i < suckBoost.length; i++) {
			suckBoost[i].update(tornado);
		}
		for (int i = 0; i < pointBoost.length; i++) {
			pointBoost[i].update();
		}
	}

	public SpeedBoost[] getSpeedBoost() {
		return speedBoost;
	}

	public SuckBoost[] getSuckBoost() {
		return suckBoost;
	}

	public PointBoost[] getPointBoost() {
		return pointBoost;
	}
	
	public static void dispose() {
		suckBoostTexture.dispose();
		speedBoostTexture.dispose();
	}
}
