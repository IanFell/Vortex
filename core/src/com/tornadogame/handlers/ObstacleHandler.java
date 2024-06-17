package com.tornadogame.handlers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.backgrounds.Background;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.handlers.pointsanddamage.DamageHandler;
import com.tornadogame.layout.Layout;
import com.tornadogame.levels.Level;
import com.tornadogame.obstacles.Obstacle;
import com.tornadogame.ui.Message;

public class ObstacleHandler {

	public static boolean playImpactAudio = false;

	private final int SIZE = 200;

	private Obstacle[] obstacle = new Obstacle[43];

	public static Texture obstacleTexture;

	public ObstacleHandler(PlatformHandler platformHandler, int levelToLoad) {
		switch (levelToLoad) {
		case LevelHandler.LEVEL_TEST:
			obstacleTexture = new Texture("artwork/levels/testlevel/Bomb.png");
			loadTestLevel(platformHandler, levelToLoad);
			break;
		case LevelHandler.LEVEL_FARM:
			obstacleTexture = new Texture("artwork/levels/farmlevel/Hay.png");
			loadFarmLevel(platformHandler, levelToLoad);
			break;
		case LevelHandler.LEVEL_SPACE:
			obstacleTexture = new Texture("artwork/levels/spacelevel/Hay.png");
			loadSpaceLevel(platformHandler, levelToLoad);
			break;
		case LevelHandler.LEVEL_BEACH:
			obstacleTexture = new Texture("artwork/levels/beachlevel/Hay.png");
			loadBeachLevel(platformHandler, levelToLoad);
			break;
		case LevelHandler.LEVEL_ARCTIC:
			obstacleTexture = new Texture("artwork/levels/arcticlevel/Hay.png");
			loadArcticLevel(platformHandler, levelToLoad);
			break;
		case LevelHandler.LEVEL_HELL:
			obstacleTexture = new Texture("artwork/levels/helllevel/Hay.png");
			loadHellLevel(platformHandler, levelToLoad);
			break;
		case LevelHandler.LEVEL_CITY:
			obstacleTexture = new Texture("artwork/levels/citylevel/Hay.png");
			loadCityLevel(platformHandler, levelToLoad);
			break;
		case LevelHandler.LEVEL_DESERT:
			obstacleTexture = new Texture("artwork/levels/desertlevel/Hay.png");
			loadDesertLevel(platformHandler, levelToLoad);
			break;
		case LevelHandler.LEVEL_FORREST:
			obstacleTexture = new Texture("artwork/levels/forrestlevel/Hay.png");
			loadForrestLevel(platformHandler, levelToLoad);
			break;
		case LevelHandler.LEVEL_TRACK:
			obstacleTexture = new Texture("artwork/levels/tracklevel/Hay.png");
			loadTrackLevel(platformHandler, levelToLoad);
			break;
		case LevelHandler.LEVEL_END:
			obstacleTexture = new Texture("artwork/levels/tracklevel/Hay.png");
			loadTrackLevel(platformHandler, levelToLoad);
			break;
		case LevelHandler.LEVEL_DOUBLE:
			obstacleTexture = new Texture("artwork/levels/tracklevel/Hay.png");
			loadTrackLevel(platformHandler, levelToLoad);
			break;
		}
		playImpactAudio = false;
	}
	
	private void loadTrackLevel(PlatformHandler platformHandler, int levelToLoad) {
		float hayWidth = SIZE * 1.5f;
		float ground   = platformHandler.getGround().getY() + platformHandler.getGround().getHeight();
		obstacle[0] = new Obstacle(
				Layout.GRID_03,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[1] = new Obstacle(
				platformHandler.getPlatforms()[0].getX(),
				platformHandler.getPlatforms()[0].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[2] = new Obstacle(
				platformHandler.getPlatforms()[3].getX(),
				platformHandler.getPlatforms()[3].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[3] = new Obstacle(
				Layout.GRID_07,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[4] = new Obstacle(
				platformHandler.getPlatforms()[6].getX(),
				platformHandler.getPlatforms()[6].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[5] = new Obstacle(
				Layout.GRID_08,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[6] = new Obstacle(
				Layout.GRID_10,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[7] = new Obstacle(
				Layout.GRID_10,
				ground + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[8] = new Obstacle(
				Layout.GRID_10,
				ground + SIZE * 2,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[9] = new Obstacle(
				platformHandler.getPlatforms()[10].getX(),
				platformHandler.getPlatforms()[10].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[10] = new Obstacle(
				platformHandler.getPlatforms()[11].getX(),
				platformHandler.getPlatforms()[11].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[11] = new Obstacle(
				Layout.GRID_13,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[12] = new Obstacle(
				Layout.GRID_16,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[13] = new Obstacle(
				Layout.GRID_16 + TornadoGame.screenWidth / 2 - SIZE / 2,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[14] = new Obstacle(
				Layout.GRID_16 + TornadoGame.screenWidth - SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[15] = new Obstacle(
				platformHandler.getPlatforms()[21].getX(),
				platformHandler.getPlatforms()[21].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[16] = new Obstacle(
				Layout.GRID_21,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[17] = new Obstacle(
				Layout.GRID_23,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[18] = new Obstacle(
				Layout.GRID_24,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[19] = new Obstacle(
				platformHandler.getPlatforms()[25].getX(),
				platformHandler.getPlatforms()[25].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[20] = new Obstacle(
				platformHandler.getPlatforms()[28].getX(),
				platformHandler.getPlatforms()[28].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[21] = new Obstacle(
				Layout.GRID_28,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[22] = new Obstacle(
				Layout.GRID_29,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[23] = new Obstacle(
				Layout.GRID_30,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[24] = new Obstacle(
				platformHandler.getPlatforms()[34].getX(),
				platformHandler.getPlatforms()[34].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[25] = new Obstacle(
				Layout.GRID_36,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[26] = new Obstacle(
				Layout.GRID_36,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[27] = new Obstacle(
				Layout.GRID_46,
				ground + SIZE * 2,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[28] = new Obstacle(
				platformHandler.getPlatforms()[41].getX(),
				platformHandler.getPlatforms()[41].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[29] = new Obstacle(
				Layout.GRID_39,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[30] = new Obstacle(
				platformHandler.getPlatforms()[45].getX(),
				platformHandler.getPlatforms()[45].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[31] = new Obstacle(
				Layout.GRID_42,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[32] = new Obstacle(
				Layout.GRID_44,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[33] = new Obstacle(
				platformHandler.getPlatforms()[49].getX(),
				platformHandler.getPlatforms()[49].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[34] = new Obstacle(
				platformHandler.getPlatforms()[52].getX(),
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[35] = new Obstacle(
				Layout.GRID_48,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[36] = new Obstacle(
				Layout.GRID_50,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[37] = new Obstacle(
				platformHandler.getPlatforms()[57].getX(),
				platformHandler.getPlatforms()[57].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[38] = new Obstacle(
				Layout.GRID_52,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[39] = new Obstacle(
				Layout.GRID_54,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[40] = new Obstacle(
				platformHandler.getPlatforms()[61].getX(),
				platformHandler.getPlatforms()[61].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[41] = new Obstacle(
				platformHandler.getPlatforms()[62].getX(),
				platformHandler.getPlatforms()[62].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[42] = new Obstacle(
				Layout.GRID_58,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
	}
	
	private void loadDesertLevel(PlatformHandler platformHandler, int levelToLoad) {
		float hayWidth = SIZE * 1.5f;
		float ground   = platformHandler.getGround().getY() + platformHandler.getGround().getHeight();
		obstacle[0] = new Obstacle(
				Layout.GRID_03,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[1] = new Obstacle(
				platformHandler.getPlatforms()[0].getX(),
				platformHandler.getPlatforms()[0].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[2] = new Obstacle(
				platformHandler.getPlatforms()[3].getX(),
				platformHandler.getPlatforms()[3].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[3] = new Obstacle(
				Layout.GRID_07,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[4] = new Obstacle(
				platformHandler.getPlatforms()[6].getX(),
				platformHandler.getPlatforms()[6].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[5] = new Obstacle(
				Layout.GRID_08,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[6] = new Obstacle(
				Layout.GRID_10,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[7] = new Obstacle(
				Layout.GRID_10,
				ground + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[8] = new Obstacle(
				Layout.GRID_10,
				ground + SIZE * 2,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[9] = new Obstacle(
				platformHandler.getPlatforms()[10].getX(),
				platformHandler.getPlatforms()[10].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[10] = new Obstacle(
				platformHandler.getPlatforms()[11].getX(),
				platformHandler.getPlatforms()[11].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[11] = new Obstacle(
				Layout.GRID_13,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[12] = new Obstacle(
				Layout.GRID_16,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[13] = new Obstacle(
				Layout.GRID_16 + TornadoGame.screenWidth / 2 - SIZE / 2,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[14] = new Obstacle(
				Layout.GRID_16 + TornadoGame.screenWidth - SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[15] = new Obstacle(
				platformHandler.getPlatforms()[21].getX(),
				platformHandler.getPlatforms()[21].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[16] = new Obstacle(
				Layout.GRID_21,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[17] = new Obstacle(
				Layout.GRID_23,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[18] = new Obstacle(
				Layout.GRID_24,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[19] = new Obstacle(
				platformHandler.getPlatforms()[25].getX(),
				platformHandler.getPlatforms()[25].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[20] = new Obstacle(
				platformHandler.getPlatforms()[28].getX(),
				platformHandler.getPlatforms()[28].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[21] = new Obstacle(
				Layout.GRID_28,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[22] = new Obstacle(
				Layout.GRID_29,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[23] = new Obstacle(
				Layout.GRID_30,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[24] = new Obstacle(
				platformHandler.getPlatforms()[34].getX(),
				platformHandler.getPlatforms()[34].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[25] = new Obstacle(
				Layout.GRID_36,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[26] = new Obstacle(
				Layout.GRID_36,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[27] = new Obstacle(
				Layout.GRID_46,
				ground + SIZE * 2,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[28] = new Obstacle(
				platformHandler.getPlatforms()[41].getX(),
				platformHandler.getPlatforms()[41].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[29] = new Obstacle(
				Layout.GRID_39,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[30] = new Obstacle(
				platformHandler.getPlatforms()[45].getX(),
				platformHandler.getPlatforms()[45].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[31] = new Obstacle(
				Layout.GRID_42,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[32] = new Obstacle(
				Layout.GRID_44,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[33] = new Obstacle(
				platformHandler.getPlatforms()[49].getX(),
				platformHandler.getPlatforms()[49].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[34] = new Obstacle(
				platformHandler.getPlatforms()[52].getX(),
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[35] = new Obstacle(
				Layout.GRID_48,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[36] = new Obstacle(
				Layout.GRID_50,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[37] = new Obstacle(
				platformHandler.getPlatforms()[57].getX(),
				platformHandler.getPlatforms()[57].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[38] = new Obstacle(
				Layout.GRID_52,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[39] = new Obstacle(
				Layout.GRID_54,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[40] = new Obstacle(
				platformHandler.getPlatforms()[61].getX(),
				platformHandler.getPlatforms()[61].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[41] = new Obstacle(
				platformHandler.getPlatforms()[62].getX(),
				platformHandler.getPlatforms()[62].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[42] = new Obstacle(
				Layout.GRID_58,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
	}

	private void loadForrestLevel(PlatformHandler platformHandler, int levelToLoad) {
		float hayWidth = SIZE * 1.5f;
		float ground   = platformHandler.getGround().getY() + platformHandler.getGround().getHeight();
		obstacle[0] = new Obstacle(
				Layout.GRID_03,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[1] = new Obstacle(
				platformHandler.getPlatforms()[0].getX(),
				platformHandler.getPlatforms()[0].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[2] = new Obstacle(
				platformHandler.getPlatforms()[3].getX(),
				platformHandler.getPlatforms()[3].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[3] = new Obstacle(
				Layout.GRID_07,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[4] = new Obstacle(
				platformHandler.getPlatforms()[6].getX(),
				platformHandler.getPlatforms()[6].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[5] = new Obstacle(
				Layout.GRID_08,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[6] = new Obstacle(
				Layout.GRID_10,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[7] = new Obstacle(
				Layout.GRID_10,
				ground + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[8] = new Obstacle(
				Layout.GRID_10,
				ground + SIZE * 2,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[9] = new Obstacle(
				platformHandler.getPlatforms()[10].getX(),
				platformHandler.getPlatforms()[10].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[10] = new Obstacle(
				platformHandler.getPlatforms()[11].getX(),
				platformHandler.getPlatforms()[11].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[11] = new Obstacle(
				Layout.GRID_13,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[12] = new Obstacle(
				Layout.GRID_16,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[13] = new Obstacle(
				Layout.GRID_16 + TornadoGame.screenWidth / 2 - SIZE / 2,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[14] = new Obstacle(
				Layout.GRID_16 + TornadoGame.screenWidth - SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[15] = new Obstacle(
				platformHandler.getPlatforms()[21].getX(),
				platformHandler.getPlatforms()[21].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[16] = new Obstacle(
				Layout.GRID_21,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[17] = new Obstacle(
				Layout.GRID_23,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[18] = new Obstacle(
				Layout.GRID_24,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[19] = new Obstacle(
				platformHandler.getPlatforms()[25].getX(),
				platformHandler.getPlatforms()[25].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[20] = new Obstacle(
				platformHandler.getPlatforms()[28].getX(),
				platformHandler.getPlatforms()[28].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[21] = new Obstacle(
				Layout.GRID_28,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[22] = new Obstacle(
				Layout.GRID_29,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[23] = new Obstacle(
				Layout.GRID_30,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[24] = new Obstacle(
				platformHandler.getPlatforms()[34].getX(),
				platformHandler.getPlatforms()[34].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[25] = new Obstacle(
				Layout.GRID_36,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[26] = new Obstacle(
				Layout.GRID_36,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[27] = new Obstacle(
				Layout.GRID_46,
				ground + SIZE * 2,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[28] = new Obstacle(
				platformHandler.getPlatforms()[41].getX(),
				platformHandler.getPlatforms()[41].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[29] = new Obstacle(
				Layout.GRID_39,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[30] = new Obstacle(
				platformHandler.getPlatforms()[45].getX(),
				platformHandler.getPlatforms()[45].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[31] = new Obstacle(
				Layout.GRID_42,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[32] = new Obstacle(
				Layout.GRID_44,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[33] = new Obstacle(
				platformHandler.getPlatforms()[49].getX(),
				platformHandler.getPlatforms()[49].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[34] = new Obstacle(
				platformHandler.getPlatforms()[52].getX(),
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[35] = new Obstacle(
				Layout.GRID_48,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[36] = new Obstacle(
				Layout.GRID_50,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[37] = new Obstacle(
				platformHandler.getPlatforms()[57].getX(),
				platformHandler.getPlatforms()[57].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[38] = new Obstacle(
				Layout.GRID_52,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[39] = new Obstacle(
				Layout.GRID_54,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[40] = new Obstacle(
				platformHandler.getPlatforms()[61].getX(),
				platformHandler.getPlatforms()[61].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[41] = new Obstacle(
				platformHandler.getPlatforms()[62].getX(),
				platformHandler.getPlatforms()[62].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[42] = new Obstacle(
				Layout.GRID_58,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
	}

	private void loadCityLevel(PlatformHandler platformHandler, int levelToLoad) {
		float hayWidth = SIZE * 1.5f;
		float ground   = platformHandler.getGround().getY() + platformHandler.getGround().getHeight();
		obstacle[0] = new Obstacle(
				Layout.GRID_03,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[1] = new Obstacle(
				platformHandler.getPlatforms()[0].getX(),
				platformHandler.getPlatforms()[0].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[2] = new Obstacle(
				platformHandler.getPlatforms()[3].getX(),
				platformHandler.getPlatforms()[3].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[3] = new Obstacle(
				Layout.GRID_07,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[4] = new Obstacle(
				platformHandler.getPlatforms()[6].getX(),
				platformHandler.getPlatforms()[6].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[5] = new Obstacle(
				Layout.GRID_08,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[6] = new Obstacle(
				Layout.GRID_10,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[7] = new Obstacle(
				Layout.GRID_10,
				ground + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[8] = new Obstacle(
				Layout.GRID_10,
				ground + SIZE * 2,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[9] = new Obstacle(
				platformHandler.getPlatforms()[10].getX(),
				platformHandler.getPlatforms()[10].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[10] = new Obstacle(
				platformHandler.getPlatforms()[11].getX(),
				platformHandler.getPlatforms()[11].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[11] = new Obstacle(
				Layout.GRID_13,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[12] = new Obstacle(
				Layout.GRID_16,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[13] = new Obstacle(
				Layout.GRID_16 + TornadoGame.screenWidth / 2 - SIZE / 2,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[14] = new Obstacle(
				Layout.GRID_16 + TornadoGame.screenWidth - SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[15] = new Obstacle(
				platformHandler.getPlatforms()[21].getX(),
				platformHandler.getPlatforms()[21].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[16] = new Obstacle(
				Layout.GRID_21,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[17] = new Obstacle(
				Layout.GRID_23,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[18] = new Obstacle(
				Layout.GRID_24,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[19] = new Obstacle(
				platformHandler.getPlatforms()[25].getX(),
				platformHandler.getPlatforms()[25].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[20] = new Obstacle(
				platformHandler.getPlatforms()[28].getX(),
				platformHandler.getPlatforms()[28].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[21] = new Obstacle(
				Layout.GRID_28,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[22] = new Obstacle(
				Layout.GRID_29,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[23] = new Obstacle(
				Layout.GRID_30,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[24] = new Obstacle(
				platformHandler.getPlatforms()[34].getX(),
				platformHandler.getPlatforms()[34].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[25] = new Obstacle(
				Layout.GRID_36,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[26] = new Obstacle(
				Layout.GRID_36,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[27] = new Obstacle(
				Layout.GRID_46,
				ground + SIZE * 2,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[28] = new Obstacle(
				platformHandler.getPlatforms()[41].getX(),
				platformHandler.getPlatforms()[41].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[29] = new Obstacle(
				Layout.GRID_39,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[30] = new Obstacle(
				platformHandler.getPlatforms()[45].getX(),
				platformHandler.getPlatforms()[45].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[31] = new Obstacle(
				Layout.GRID_42,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[32] = new Obstacle(
				Layout.GRID_44,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[33] = new Obstacle(
				platformHandler.getPlatforms()[49].getX(),
				platformHandler.getPlatforms()[49].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[34] = new Obstacle(
				platformHandler.getPlatforms()[52].getX(),
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[35] = new Obstacle(
				Layout.GRID_48,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[36] = new Obstacle(
				Layout.GRID_50,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[37] = new Obstacle(
				platformHandler.getPlatforms()[57].getX(),
				platformHandler.getPlatforms()[57].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[38] = new Obstacle(
				Layout.GRID_52,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[39] = new Obstacle(
				Layout.GRID_54,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[40] = new Obstacle(
				platformHandler.getPlatforms()[61].getX(),
				platformHandler.getPlatforms()[61].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[41] = new Obstacle(
				platformHandler.getPlatforms()[62].getX(),
				platformHandler.getPlatforms()[62].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[42] = new Obstacle(
				Layout.GRID_58,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
	}

	private void loadHellLevel(PlatformHandler platformHandler, int levelToLoad) {
		float hayWidth = SIZE * 1.5f;
		float ground   = platformHandler.getGround().getY() + platformHandler.getGround().getHeight();
		obstacle[0] = new Obstacle(
				Layout.GRID_03,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[1] = new Obstacle(
				platformHandler.getPlatforms()[0].getX(),
				platformHandler.getPlatforms()[0].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[2] = new Obstacle(
				platformHandler.getPlatforms()[3].getX(),
				platformHandler.getPlatforms()[3].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[3] = new Obstacle(
				Layout.GRID_07,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[4] = new Obstacle(
				platformHandler.getPlatforms()[6].getX(),
				platformHandler.getPlatforms()[6].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[5] = new Obstacle(
				Layout.GRID_08,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[6] = new Obstacle(
				Layout.GRID_10,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[7] = new Obstacle(
				Layout.GRID_10,
				ground + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[8] = new Obstacle(
				Layout.GRID_10,
				ground + SIZE * 2,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[9] = new Obstacle(
				platformHandler.getPlatforms()[10].getX(),
				platformHandler.getPlatforms()[10].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[10] = new Obstacle(
				platformHandler.getPlatforms()[11].getX(),
				platformHandler.getPlatforms()[11].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[11] = new Obstacle(
				Layout.GRID_13,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[12] = new Obstacle(
				Layout.GRID_16,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[13] = new Obstacle(
				Layout.GRID_16 + TornadoGame.screenWidth / 2 - SIZE / 2,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[14] = new Obstacle(
				Layout.GRID_16 + TornadoGame.screenWidth - SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[15] = new Obstacle(
				platformHandler.getPlatforms()[21].getX(),
				platformHandler.getPlatforms()[21].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[16] = new Obstacle(
				Layout.GRID_21,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[17] = new Obstacle(
				Layout.GRID_23,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[18] = new Obstacle(
				Layout.GRID_24,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[19] = new Obstacle(
				platformHandler.getPlatforms()[25].getX(),
				platformHandler.getPlatforms()[25].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[20] = new Obstacle(
				platformHandler.getPlatforms()[28].getX(),
				platformHandler.getPlatforms()[28].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[21] = new Obstacle(
				Layout.GRID_28,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[22] = new Obstacle(
				Layout.GRID_29,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[23] = new Obstacle(
				Layout.GRID_30,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[24] = new Obstacle(
				platformHandler.getPlatforms()[34].getX(),
				platformHandler.getPlatforms()[34].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[25] = new Obstacle(
				Layout.GRID_36,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[26] = new Obstacle(
				Layout.GRID_36,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[27] = new Obstacle(
				Layout.GRID_46,
				ground + SIZE * 2,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[28] = new Obstacle(
				platformHandler.getPlatforms()[41].getX(),
				platformHandler.getPlatforms()[41].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[29] = new Obstacle(
				Layout.GRID_39,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[30] = new Obstacle(
				platformHandler.getPlatforms()[45].getX(),
				platformHandler.getPlatforms()[45].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[31] = new Obstacle(
				Layout.GRID_42,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[32] = new Obstacle(
				Layout.GRID_44,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[33] = new Obstacle(
				platformHandler.getPlatforms()[49].getX(),
				platformHandler.getPlatforms()[49].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[34] = new Obstacle(
				platformHandler.getPlatforms()[52].getX(),
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[35] = new Obstacle(
				Layout.GRID_48,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[36] = new Obstacle(
				Layout.GRID_50,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[37] = new Obstacle(
				platformHandler.getPlatforms()[57].getX(),
				platformHandler.getPlatforms()[57].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[38] = new Obstacle(
				Layout.GRID_52,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[39] = new Obstacle(
				Layout.GRID_54,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[40] = new Obstacle(
				platformHandler.getPlatforms()[61].getX(),
				platformHandler.getPlatforms()[61].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[41] = new Obstacle(
				platformHandler.getPlatforms()[62].getX(),
				platformHandler.getPlatforms()[62].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[42] = new Obstacle(
				Layout.GRID_58,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
	}

	private void loadArcticLevel(PlatformHandler platformHandler, int levelToLoad) {
		float hayWidth = SIZE * 1.5f;
		float ground   = platformHandler.getGround().getY() + platformHandler.getGround().getHeight();
		obstacle[0] = new Obstacle(
				platformHandler.getPlatforms()[2].getX(),
				platformHandler.getPlatforms()[2].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[1] = new Obstacle(
				platformHandler.getPlatforms()[3].getX(),
				platformHandler.getPlatforms()[3].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[2] = new Obstacle(
				platformHandler.getPlatforms()[4].getX(),
				platformHandler.getPlatforms()[4].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[3] = new Obstacle(
				platformHandler.getPlatforms()[6].getX(),
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[4] = new Obstacle(
				Layout.GRID_12,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[5] = new Obstacle(
				Layout.GRID_12 + SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[6] = new Obstacle(
				Layout.GRID_12 + SIZE * 2,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[7] = new Obstacle(
				platformHandler.getPlatforms()[9].getX(),
				platformHandler.getPlatforms()[9].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[8] = new Obstacle(
				platformHandler.getPlatforms()[10].getX(),
				platformHandler.getPlatforms()[10].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[9] = new Obstacle(
				platformHandler.getPlatforms()[11].getX(),
				platformHandler.getPlatforms()[11].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[10] = new Obstacle(
				platformHandler.getPlatforms()[12].getX(),
				platformHandler.getPlatforms()[12].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[11] = new Obstacle(
				Layout.GRID_17,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[12] = new Obstacle(
				Layout.GRID_19,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[13] = new Obstacle(
				platformHandler.getPlatforms()[17].getX(),
				platformHandler.getPlatforms()[17].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[14] = new Obstacle(
				platformHandler.getPlatforms()[18].getX(),
				platformHandler.getPlatforms()[18].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[15] = new Obstacle(
				platformHandler.getPlatforms()[23].getX(),
				platformHandler.getPlatforms()[23].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[16] = new Obstacle(
				platformHandler.getPlatforms()[24].getX(),
				platformHandler.getPlatforms()[24].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[17] = new Obstacle(
				Layout.GRID_25,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[18] = new Obstacle(
				platformHandler.getPlatforms()[25].getX(),
				platformHandler.getPlatforms()[25].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[19] = new Obstacle(
				platformHandler.getPlatforms()[26].getX() + platformHandler.getPlatforms()[39].getWidth() - SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[20] = new Obstacle(
				platformHandler.getPlatforms()[27].getX(),
				platformHandler.getPlatforms()[27].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[21] = new Obstacle(
				platformHandler.getPlatforms()[30].getX(),
				platformHandler.getPlatforms()[30].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[22] = new Obstacle(
				platformHandler.getPlatforms()[32].getX(),
				platformHandler.getPlatforms()[32].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[23] = new Obstacle(
				platformHandler.getPlatforms()[33].getX(),
				platformHandler.getPlatforms()[33].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[24] = new Obstacle(
				platformHandler.getPlatforms()[34].getX(),
				platformHandler.getPlatforms()[34].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[25] = new Obstacle(
				platformHandler.getPlatforms()[35].getX(),
				platformHandler.getPlatforms()[35].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[26] = new Obstacle(
				platformHandler.getPlatforms()[48].getX(),
				platformHandler.getPlatforms()[48].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[27] = new Obstacle(
				platformHandler.getPlatforms()[49].getX(),
				platformHandler.getPlatforms()[49].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[28] = new Obstacle(
				platformHandler.getPlatforms()[50].getX(),
				platformHandler.getPlatforms()[50].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[29] = new Obstacle(
				platformHandler.getPlatforms()[51].getX(),
				platformHandler.getPlatforms()[51].getY() - SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		for (int i = 29; i < obstacle.length; i++) {
			obstacle[i] = new Obstacle(
					Layout.GRID_61 * 3,
					platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
					SIZE, 
					SIZE, 
					obstacleTexture, 
					Background.SCROLL_SPEED_FRONT_LAYER, 
					0,
					levelToLoad
					);
		}
	}

	private void loadBeachLevel(PlatformHandler platformHandler, int levelToLoad) {
		float hayWidth = SIZE * 1.5f;
		float ground   = platformHandler.getGround().getY() + platformHandler.getGround().getHeight();
		obstacle[0] = new Obstacle(
				Layout.GRID_03,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[1] = new Obstacle(
				Layout.GRID_03,
				ground + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[2] = new Obstacle(
				Layout.GRID_03,
				ground + SIZE * 2,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[3] = new Obstacle(
				Layout.GRID_05,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[4] = new Obstacle(
				Layout.GRID_05,
				ground + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[5] = new Obstacle(
				Layout.GRID_05,
				ground + SIZE * 2,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[6] = new Obstacle(
				Layout.GRID_10 + TornadoGame.screenWidth - SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[7] = new Obstacle(
				Layout.GRID_10 + TornadoGame.screenWidth - SIZE,
				ground + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[8] = new Obstacle(
				Layout.GRID_10 + TornadoGame.screenWidth - SIZE,
				ground + SIZE * 2,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[9] = new Obstacle(
				Layout.GRID_14,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[10] = new Obstacle(
				Layout.GRID_16 + TornadoGame.screenWidth - SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[11] = new Obstacle(
				Layout.GRID_18 + TornadoGame.screenWidth - SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[12] = new Obstacle(
				Layout.GRID_18 + TornadoGame.screenWidth - SIZE,
				ground + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[13] = new Obstacle(
				Layout.GRID_18 + TornadoGame.screenWidth - SIZE,
				ground + SIZE * 2,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[14] = new Obstacle(
				Layout.GRID_20,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[15] = new Obstacle(
				Layout.GRID_24,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[16] = new Obstacle(
				Layout.GRID_24 + TornadoGame.screenWidth / 2,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[17] = new Obstacle(
				Layout.GRID_24 + TornadoGame.screenWidth - SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[18] = new Obstacle(
				Layout.GRID_27,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[19] = new Obstacle(
				platformHandler.getPlatforms()[39].getX() + platformHandler.getPlatforms()[39].getWidth() - SIZE,
				platformHandler.getPlatforms()[39].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[20] = new Obstacle(
				platformHandler.getPlatforms()[41].getX(),
				platformHandler.getPlatforms()[41].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[21] = new Obstacle(
				Layout.GRID_35,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[22] = new Obstacle(
				Layout.GRID_35,
				ground + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[23] = new Obstacle(
				Layout.GRID_35,
				ground + SIZE * 2,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[24] = new Obstacle(
				Layout.GRID_36 + TornadoGame.screenWidth / 2 - SIZE / 2,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[25] = new Obstacle(
				Layout.GRID_36 + TornadoGame.screenWidth / 2 - SIZE / 2,
				ground + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[26] = new Obstacle(
				Layout.GRID_36 + TornadoGame.screenWidth / 2 - SIZE / 2,
				ground + SIZE * 2,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[27] = new Obstacle(
				Layout.GRID_41 + TornadoGame.screenWidth / 2 - SIZE / 2,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[28] = new Obstacle(
				Layout.GRID_41 + TornadoGame.screenWidth / 2 - SIZE / 2,
				ground + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[29] = new Obstacle(
				Layout.GRID_41 + TornadoGame.screenWidth / 2 - SIZE / 2,
				ground + SIZE * 2,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		for (int i = 29; i < obstacle.length; i++) {
			obstacle[i] = new Obstacle(
					Layout.GRID_61 * 3,
					platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
					SIZE, 
					SIZE, 
					obstacleTexture, 
					Background.SCROLL_SPEED_FRONT_LAYER, 
					0,
					levelToLoad
					);
		}
	}

	private void loadSpaceLevel(PlatformHandler platformHandler, int levelToLoad) {
		float hayWidth = SIZE * 1.5f;
		float ground   = platformHandler.getGround().getY() + platformHandler.getGround().getHeight();
		obstacle[0] = new Obstacle(
				platformHandler.getPlatforms()[0].getX() + platformHandler.getPlatforms()[0].getWidth() - SIZE,
				platformHandler.getPlatforms()[0].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[1] = new Obstacle(
				platformHandler.getPlatforms()[4].getX(),
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[2] = new Obstacle(
				platformHandler.getPlatforms()[6].getX(),
				platformHandler.getPlatforms()[6].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[3] = new Obstacle(
				platformHandler.getPlatforms()[7].getX() + platformHandler.getPlatforms()[7].getWidth() - SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[4] = new Obstacle(
				Layout.GRID_09,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[5] = new Obstacle(
				platformHandler.getPlatforms()[11].getX(),
				platformHandler.getPlatforms()[11].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[6] = new Obstacle(
				platformHandler.getPlatforms()[12].getX(),
				platformHandler.getPlatforms()[12].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[7] = new Obstacle(
				platformHandler.getPlatforms()[16].getX(),
				platformHandler.getPlatforms()[16].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[8] = new Obstacle(
				Layout.GRID_15 + TornadoGame.screenWidth - SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[9] = new Obstacle(
				Layout.GRID_18 + TornadoGame.screenWidth - SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[10] = new Obstacle(
				platformHandler.getPlatforms()[21].getX() + platformHandler.getPlatforms()[21].getWidth() - SIZE,
				platformHandler.getPlatforms()[21].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[11] = new Obstacle(
				platformHandler.getPlatforms()[22].getX(),
				platformHandler.getPlatforms()[22].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[12] = new Obstacle(
				platformHandler.getPlatforms()[28].getX(),
				platformHandler.getPlatforms()[28].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[13] = new Obstacle(
				Layout.GRID_23,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[14] = new Obstacle(
				Layout.GRID_25,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[15] = new Obstacle(
				platformHandler.getPlatforms()[35].getX() + platformHandler.getPlatforms()[35].getWidth() - SIZE,
				platformHandler.getPlatforms()[35].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[16] = new Obstacle(
				platformHandler.getPlatforms()[37].getX(),
				platformHandler.getPlatforms()[37].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[17] = new Obstacle(
				Layout.GRID_30 + TornadoGame.screenWidth - SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[18] = new Obstacle(
				platformHandler.getPlatforms()[41].getX() + TornadoGame.screenWidth / 2 - SIZE / 2,
				platformHandler.getPlatforms()[41].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[19] = new Obstacle(
				platformHandler.getPlatforms()[45].getX(),
				platformHandler.getPlatforms()[45].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[20] = new Obstacle(
				platformHandler.getPlatforms()[46].getX(),
				platformHandler.getPlatforms()[46].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[21] = new Obstacle(
				platformHandler.getPlatforms()[50].getX(),
				platformHandler.getPlatforms()[50].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[22] = new Obstacle(
				platformHandler.getPlatforms()[51].getX(),
				platformHandler.getPlatforms()[51].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[23] = new Obstacle(
				platformHandler.getPlatforms()[55].getX(),
				platformHandler.getPlatforms()[55].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[24] = new Obstacle(
				Layout.GRID_41,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		for (int i = 24; i < obstacle.length; i++) {
			obstacle[i] = new Obstacle(
					Layout.GRID_61 * 3,
					platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
					SIZE, 
					SIZE, 
					obstacleTexture, 
					Background.SCROLL_SPEED_FRONT_LAYER, 
					0,
					levelToLoad
					);
		}
	}

	private void loadFarmLevel(PlatformHandler platformHandler, int levelToLoad) {
		float hayWidth = SIZE * 1.5f;
		float ground   = platformHandler.getGround().getY() + platformHandler.getGround().getHeight();
		obstacle[0] = new Obstacle(
				Layout.GRID_03 + TornadoGame.screenWidth - SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[1] = new Obstacle(
				Layout.GRID_03 + TornadoGame.screenWidth - SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[2] = new Obstacle(
				platformHandler.getPlatforms()[4].getX(),
				platformHandler.getPlatforms()[4].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[3] = new Obstacle(
				Layout.GRID_07,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[4] = new Obstacle(
				Layout.GRID_09,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[5] = new Obstacle(
				platformHandler.getPlatforms()[8].getX() + platformHandler.getPlatforms()[8].getWidth() - SIZE,
				platformHandler.getPlatforms()[8].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[6] = new Obstacle(
				platformHandler.getPlatforms()[13].getX() + platformHandler.getPlatforms()[13].getWidth() - SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[7] = new Obstacle(
				platformHandler.getPlatforms()[16].getX(),
				platformHandler.getPlatforms()[16].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[8] = new Obstacle(
				Layout.GRID_16 + TornadoGame.screenWidth / 2 - SIZE / 2,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[9] = new Obstacle(
				platformHandler.getPlatforms()[21].getX(),
				platformHandler.getPlatforms()[21].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[10] = new Obstacle(
				platformHandler.getPlatforms()[22].getX(),
				platformHandler.getPlatforms()[22].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[11] = new Obstacle(
				platformHandler.getPlatforms()[23].getX(),
				platformHandler.getPlatforms()[23].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[12] = new Obstacle(
				platformHandler.getPlatforms()[29].getX(),
				platformHandler.getPlatforms()[29].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[13] = new Obstacle(
				Layout.GRID_22 + TornadoGame.screenWidth - SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[14] = new Obstacle(
				Layout.GRID_23 + TornadoGame.screenWidth - SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[15] = new Obstacle(
				platformHandler.getPlatforms()[33].getX(),
				platformHandler.getPlatforms()[33].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[16] = new Obstacle(
				platformHandler.getPlatforms()[37].getX(),
				platformHandler.getPlatforms()[37].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[17] = new Obstacle(
				platformHandler.getPlatforms()[40].getX(),
				platformHandler.getPlatforms()[40].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[18] = new Obstacle(
				platformHandler.getPlatforms()[41].getX(),
				platformHandler.getPlatforms()[41].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[19] = new Obstacle(
				Layout.GRID_32 + TornadoGame.screenWidth - SIZE,
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[20] = new Obstacle(
				platformHandler.getPlatforms()[46].getX(),
				platformHandler.getPlatforms()[46].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[21] = new Obstacle(
				platformHandler.getPlatforms()[48].getX(),
				platformHandler.getPlatforms()[48].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[22] = new Obstacle(
				platformHandler.getPlatforms()[51].getX(),
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[23] = new Obstacle(
				platformHandler.getPlatforms()[53].getX() + platformHandler.getPlatforms()[53].getWidth() - SIZE,
				platformHandler.getPlatforms()[53].getY() + SIZE,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[24] = new Obstacle(
				platformHandler.getPlatforms()[55].getX() + platformHandler.getPlatforms()[55].getWidth(),
				ground,
				hayWidth, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		for (int i = 25; i < obstacle.length; i++) {
			obstacle[i] = new Obstacle(
					Layout.GRID_61 * 3,
					platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
					SIZE, 
					SIZE, 
					obstacleTexture, 
					Background.SCROLL_SPEED_FRONT_LAYER, 
					0,
					levelToLoad
					);
		}
	}

	private void loadTestLevel(PlatformHandler platformHandler, int levelToLoad) {
		obstacle[0] = new Obstacle(
				Layout.GRID_03 + Layout.LARGE_WIDTH / 2 - SIZE / 2,
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[1] = new Obstacle(
				platformHandler.getPlatforms()[2].getX(),
				platformHandler.getPlatforms()[2].getY() + platformHandler.getPlatforms()[2].getHeight(),
				SIZE, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[2] = new Obstacle(
				platformHandler.getPlatforms()[3].getX(),
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[3] = new Obstacle(
				Layout.GRID_05 + TornadoGame.screenWidth / 2,
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[4] = new Obstacle(
				platformHandler.getPlatforms()[5].getX(),
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[5] = new Obstacle(
				platformHandler.getPlatforms()[7].getX(),
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[6] = new Obstacle(
				platformHandler.getPlatforms()[9].getX() + platformHandler.getPlatforms()[9].getWidth(),
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[7] = new Obstacle(
				platformHandler.getPlatforms()[11].getX(),
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[8] = new Obstacle(
				platformHandler.getPlatforms()[12].getX(),
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[9] = new Obstacle(
				platformHandler.getPlatforms()[13].getX() + platformHandler.getPlatforms()[13].getWidth() - SIZE,
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[10] = new Obstacle(
				platformHandler.getPlatforms()[15].getX() + platformHandler.getPlatforms()[15].getWidth() + SIZE,
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[11] = new Obstacle(
				platformHandler.getPlatforms()[16].getX() + platformHandler.getPlatforms()[16].getWidth() + SIZE,
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[12] = new Obstacle(
				platformHandler.getPlatforms()[18].getX(),
				platformHandler.getPlatforms()[18].getY() + platformHandler.getPlatforms()[18].getHeight(),
				SIZE, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[13] = new Obstacle(
				platformHandler.getPlatforms()[20].getX(),
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[14] = new Obstacle(
				Layout.GRID_18 + TornadoGame.screenWidth - SIZE,
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[15] = new Obstacle(
				platformHandler.getPlatforms()[27].getX() + platformHandler.getPlatforms()[27].getWidth() - SIZE,
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		obstacle[16] = new Obstacle(
				platformHandler.getPlatforms()[28].getX() + platformHandler.getPlatforms()[28].getWidth(),
				platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
				SIZE, 
				SIZE, 
				obstacleTexture, 
				Background.SCROLL_SPEED_FRONT_LAYER, 
				0,
				levelToLoad
				);
		for (int i = 16; i < obstacle.length; i++) {
			obstacle[i] = new Obstacle(
					platformHandler.getPlatforms()[28].getX() + platformHandler.getPlatforms()[28].getWidth(),
					platformHandler.getGround().getY() + platformHandler.getGround().getHeight(),
					SIZE, 
					SIZE, 
					obstacleTexture, 
					Background.SCROLL_SPEED_FRONT_LAYER, 
					0,
					levelToLoad
					);
		}
	}

	public void update(Message message, OrthographicCamera camera, Tornado tornado, Player player, ShrapnelDropHandler shrapnelDropHandler, TornadoGame tornadoGame, Level level) {
		for (int i = 0; i < obstacle.length; i++) {
			obstacle[i].update(tornado, player, shrapnelDropHandler, level);

			if (player.getRectangle().overlaps(obstacle[i].getRectangle()) && !obstacle[i].isHasCollidedWithPlayer() &&!level.isLevelIsOver()) {
				obstacle[i].setHasCollidedWithPlayer(true);
				player.setHasBeenHitByObstacle(true);
				player.setStunned(true);

				if (player.getPoints() >= DamageHandler.DAMAGE_VALUE_OBSTACLE) {
					player.setPoints(player.getPoints() - DamageHandler.DAMAGE_VALUE_OBSTACLE);
				} else {
					player.setPoints(0);
				}

				tornadoGame.setScreenShouldShake(true);
				message.setShouldDisplayMessage(true, Message.MESSAGE_BOOM, player.getX(), player.getY());
				playImpactAudio = true;
			}
		}
	}

	public void draw(SpriteBatch batch, Tornado tornado) {
		for (int i = 0; i < obstacle.length; i++) {
			obstacle[i].draw(batch, tornado);
		}
	}
	
	public static void dispose() {
		obstacleTexture.dispose();
	}
}
