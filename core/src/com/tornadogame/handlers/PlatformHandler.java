package com.tornadogame.handlers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.backgrounds.Background;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.layout.Layout;
import com.tornadogame.levels.Level;
import com.tornadogame.platforms.FloatingPlatform;
import com.tornadogame.platforms.Ground;
import com.tornadogame.platforms.Platform;

public class PlatformHandler {

	private final float HEIGHT = 300;

	private Ground ground;

	private FloatingPlatform[] platforms = new FloatingPlatform[67];

	public static Texture floatingPlatformTexture;

	public PlatformHandler(OrthographicCamera camera, int levelToLoad) {
		ground = new Ground(Layout.GRID_01, 0, camera.viewportWidth, 100, new Texture("artwork/ui/staticeffect/GraySquare.png"), 0, 0);
		floatingPlatformTexture = new Texture("artwork/levels/testlevel/Platform.png");

		switch (levelToLoad) {
		case LevelHandler.LEVEL_TEST:
			floatingPlatformTexture = new Texture("artwork/levels/testlevel/Platform.png");
			loadTestLevel();
			break;
		case LevelHandler.LEVEL_FARM:
			floatingPlatformTexture = new Texture("artwork/levels/farmlevel/Platform.png");
			loadFarmLevel();
			break;
		case LevelHandler.LEVEL_SPACE:
			floatingPlatformTexture = new Texture("artwork/levels/spacelevel/Platform.png");
			loadSpaceLevel();
			break;
		case LevelHandler.LEVEL_BEACH:
			floatingPlatformTexture = new Texture("artwork/levels/beachlevel/AlternatePlatform.png");
			loadBeachLevel();
			break;
		case LevelHandler.LEVEL_ARCTIC:
			floatingPlatformTexture = new Texture("artwork/levels/arcticlevel/Platform.png");
			loadArcticLevel();
			break;
		case LevelHandler.LEVEL_HELL:
			floatingPlatformTexture = new Texture("artwork/levels/beachlevel/Platform.png");
			loadHellLevel();
			break;
		case LevelHandler.LEVEL_CITY:
			floatingPlatformTexture = new Texture("artwork/levels/citylevel/Platform.png");
			loadCityLevel();
			break;
		case LevelHandler.LEVEL_DESERT:
			floatingPlatformTexture = new Texture("artwork/levels/desertlevel/Platform.png");
			loadDesertLevel();
			break;
		case LevelHandler.LEVEL_FORREST:
			floatingPlatformTexture = new Texture("artwork/levels/forrestlevel/Platform.png");
			loadForrestLevel();
			break;
		case LevelHandler.LEVEL_TRACK:
			floatingPlatformTexture = new Texture("artwork/levels/tracklevel/Platform.png");
			loadTrackLevel();
			break;
		case LevelHandler.LEVEL_END:
			floatingPlatformTexture = new Texture("artwork/levels/tracklevel/Platform.png");
			loadTrackLevel();
			break;
		case LevelHandler.LEVEL_DOUBLE:
			floatingPlatformTexture = new Texture("artwork/levels/tracklevel/Platform.png");
			loadTrackLevel();
			break;
		}
	}
	
	private void loadTrackLevel() {
		platforms[0]  = new FloatingPlatform(Layout.GRID_03, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[1]  = new FloatingPlatform(Layout.GRID_04, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[2]  = new FloatingPlatform(Layout.GRID_04 + TornadoGame.screenWidth - Layout.MEDIUM_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[3]  = new FloatingPlatform(Layout.GRID_05, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[4]  = new FloatingPlatform(Layout.GRID_06, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[5]  = new FloatingPlatform(Layout.GRID_01 - TornadoGame.screenWidth - Layout.LARGE_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[6]  = new FloatingPlatform(Layout.GRID_07, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[7]  = new FloatingPlatform(Layout.GRID_09, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[8]  = new FloatingPlatform(Layout.GRID_09 + TornadoGame.screenWidth / 2, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[9]  = new FloatingPlatform(Layout.GRID_10, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[10] = new FloatingPlatform(Layout.GRID_11, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[11] = new FloatingPlatform(Layout.GRID_11, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[12] = new FloatingPlatform(Layout.GRID_12, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[13] = new FloatingPlatform(Layout.GRID_12, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[14] = new FloatingPlatform(Layout.GRID_14, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[15] = new FloatingPlatform(Layout.GRID_16, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[16] = new FloatingPlatform(Layout.GRID_16 + TornadoGame.screenWidth / 2 - Layout.MEDIUM_WIDTH / 2, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[17] = new FloatingPlatform(Layout.GRID_16 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[18] = new FloatingPlatform(Layout.GRID_17, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[19] = new FloatingPlatform(Layout.GRID_18, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[20] = new FloatingPlatform(Layout.GRID_19, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[21] = new FloatingPlatform(Layout.GRID_20, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[22] = new FloatingPlatform(Layout.GRID_22, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[23] = new FloatingPlatform(Layout.GRID_22 + TornadoGame.screenWidth / 2 - Layout.MEDIUM_WIDTH / 2, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[24] = new FloatingPlatform(Layout.GRID_22 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[25] = new FloatingPlatform(Layout.GRID_24, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[26] = new FloatingPlatform(Layout.GRID_25, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[27] = new FloatingPlatform(Layout.GRID_26, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[28] = new FloatingPlatform(Layout.GRID_27, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[29] = new FloatingPlatform(Layout.GRID_28, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[30] = new FloatingPlatform(Layout.GRID_30, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[31] = new FloatingPlatform(Layout.GRID_31, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[32] = new FloatingPlatform(Layout.GRID_31 + TornadoGame.screenWidth / 2 - Layout.MEDIUM_WIDTH / 2, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[33] = new FloatingPlatform(Layout.GRID_31 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[34] = new FloatingPlatform(Layout.GRID_32, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[35] = new FloatingPlatform(Layout.GRID_33, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[36] = new FloatingPlatform(Layout.GRID_33, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[37] = new FloatingPlatform(Layout.GRID_34, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[38] = new FloatingPlatform(Layout.GRID_34, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[39] = new FloatingPlatform(Layout.GRID_35, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[40] = new FloatingPlatform(Layout.GRID_35, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[41] = new FloatingPlatform(Layout.GRID_38, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[42] = new FloatingPlatform(Layout.GRID_39 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[43] = new FloatingPlatform(Layout.GRID_39 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[44] = new FloatingPlatform(Layout.GRID_39, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[45] = new FloatingPlatform(Layout.GRID_40, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[46] = new FloatingPlatform(Layout.GRID_40 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[47] = new FloatingPlatform(Layout.GRID_40 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[48] = new FloatingPlatform(Layout.GRID_41, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[49] = new FloatingPlatform(Layout.GRID_44, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[50] = new FloatingPlatform(Layout.GRID_45, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[51] = new FloatingPlatform(Layout.GRID_46, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[52] = new FloatingPlatform(Layout.GRID_46  + TornadoGame.screenWidth - Layout.MEDIUM_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[53] = new FloatingPlatform(Layout.GRID_47, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[54] = new FloatingPlatform(Layout.GRID_49, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[55] = new FloatingPlatform(Layout.GRID_49 + TornadoGame.screenWidth - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[56] = new FloatingPlatform(Layout.GRID_49, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[57] = new FloatingPlatform(Layout.GRID_50, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[58] = new FloatingPlatform(Layout.GRID_52, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[59] = new FloatingPlatform(Layout.GRID_53, Layout.Y_POSITION_HIGH, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[60] = new FloatingPlatform(Layout.GRID_54, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[61] = new FloatingPlatform(Layout.GRID_56, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[62] = new FloatingPlatform(Layout.GRID_56 + TornadoGame.screenWidth - Layout.MEDIUM_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[63] = new FloatingPlatform(Layout.GRID_57, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[64] = new FloatingPlatform(Layout.GRID_59, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[65] = new FloatingPlatform(Layout.GRID_59, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[66] = new FloatingPlatform(Layout.GRID_59, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
	}
	
	private void loadForrestLevel() {
		platforms[0]  = new FloatingPlatform(Layout.GRID_03, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[1]  = new FloatingPlatform(Layout.GRID_04, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[2]  = new FloatingPlatform(Layout.GRID_04 + TornadoGame.screenWidth - Layout.MEDIUM_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[3]  = new FloatingPlatform(Layout.GRID_05, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[4]  = new FloatingPlatform(Layout.GRID_06, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[5]  = new FloatingPlatform(Layout.GRID_06 - TornadoGame.screenWidth - Layout.LARGE_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[6]  = new FloatingPlatform(Layout.GRID_07, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[7]  = new FloatingPlatform(Layout.GRID_09, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[8]  = new FloatingPlatform(Layout.GRID_09 + TornadoGame.screenWidth / 2, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[9]  = new FloatingPlatform(Layout.GRID_10, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[10] = new FloatingPlatform(Layout.GRID_11, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[11] = new FloatingPlatform(Layout.GRID_11, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[12] = new FloatingPlatform(Layout.GRID_12, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[13] = new FloatingPlatform(Layout.GRID_12, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[14] = new FloatingPlatform(Layout.GRID_14, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[15] = new FloatingPlatform(Layout.GRID_16, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[16] = new FloatingPlatform(Layout.GRID_16 + TornadoGame.screenWidth / 2 - Layout.MEDIUM_WIDTH / 2, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[17] = new FloatingPlatform(Layout.GRID_16 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[18] = new FloatingPlatform(Layout.GRID_17, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[19] = new FloatingPlatform(Layout.GRID_18, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[20] = new FloatingPlatform(Layout.GRID_19, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[21] = new FloatingPlatform(Layout.GRID_20, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[22] = new FloatingPlatform(Layout.GRID_22, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[23] = new FloatingPlatform(Layout.GRID_22 + TornadoGame.screenWidth / 2 - Layout.MEDIUM_WIDTH / 2, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[24] = new FloatingPlatform(Layout.GRID_22 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[25] = new FloatingPlatform(Layout.GRID_24, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[26] = new FloatingPlatform(Layout.GRID_25, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[27] = new FloatingPlatform(Layout.GRID_26, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[28] = new FloatingPlatform(Layout.GRID_27, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[29] = new FloatingPlatform(Layout.GRID_28, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[30] = new FloatingPlatform(Layout.GRID_30, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[31] = new FloatingPlatform(Layout.GRID_31, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[32] = new FloatingPlatform(Layout.GRID_31 + TornadoGame.screenWidth / 2 - Layout.MEDIUM_WIDTH / 2, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[33] = new FloatingPlatform(Layout.GRID_31 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[34] = new FloatingPlatform(Layout.GRID_32, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[35] = new FloatingPlatform(Layout.GRID_33, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[36] = new FloatingPlatform(Layout.GRID_33, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[37] = new FloatingPlatform(Layout.GRID_34, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[38] = new FloatingPlatform(Layout.GRID_34, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[39] = new FloatingPlatform(Layout.GRID_35, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[40] = new FloatingPlatform(Layout.GRID_35, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[41] = new FloatingPlatform(Layout.GRID_38, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[42] = new FloatingPlatform(Layout.GRID_39 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[43] = new FloatingPlatform(Layout.GRID_39 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[44] = new FloatingPlatform(Layout.GRID_39, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[45] = new FloatingPlatform(Layout.GRID_40, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[46] = new FloatingPlatform(Layout.GRID_40 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[47] = new FloatingPlatform(Layout.GRID_40 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[48] = new FloatingPlatform(Layout.GRID_41, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[49] = new FloatingPlatform(Layout.GRID_44, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[50] = new FloatingPlatform(Layout.GRID_45, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[51] = new FloatingPlatform(Layout.GRID_46, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[52] = new FloatingPlatform(Layout.GRID_46  + TornadoGame.screenWidth - Layout.MEDIUM_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[53] = new FloatingPlatform(Layout.GRID_47, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[54] = new FloatingPlatform(Layout.GRID_49, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[55] = new FloatingPlatform(Layout.GRID_49 + TornadoGame.screenWidth - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[56] = new FloatingPlatform(Layout.GRID_49, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[57] = new FloatingPlatform(Layout.GRID_50, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[58] = new FloatingPlatform(Layout.GRID_52, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[59] = new FloatingPlatform(Layout.GRID_53, Layout.Y_POSITION_HIGH, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[60] = new FloatingPlatform(Layout.GRID_54, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[61] = new FloatingPlatform(Layout.GRID_56, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[62] = new FloatingPlatform(Layout.GRID_56 + TornadoGame.screenWidth - Layout.MEDIUM_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[63] = new FloatingPlatform(Layout.GRID_57, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[64] = new FloatingPlatform(Layout.GRID_59, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[65] = new FloatingPlatform(Layout.GRID_59, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[66] = new FloatingPlatform(Layout.GRID_59, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
	}
	
	private void loadDesertLevel() {
		platforms[0]  = new FloatingPlatform(Layout.GRID_03, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[1]  = new FloatingPlatform(Layout.GRID_04, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[2]  = new FloatingPlatform(Layout.GRID_04 + TornadoGame.screenWidth - Layout.MEDIUM_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[3]  = new FloatingPlatform(Layout.GRID_05, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[4]  = new FloatingPlatform(Layout.GRID_06, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[5]  = new FloatingPlatform(Layout.GRID_06 - TornadoGame.screenWidth - Layout.LARGE_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[6]  = new FloatingPlatform(Layout.GRID_07, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[7]  = new FloatingPlatform(Layout.GRID_09, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[8]  = new FloatingPlatform(Layout.GRID_09 + TornadoGame.screenWidth / 2, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[9]  = new FloatingPlatform(Layout.GRID_10, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[10] = new FloatingPlatform(Layout.GRID_11, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[11] = new FloatingPlatform(Layout.GRID_11, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[12] = new FloatingPlatform(Layout.GRID_12, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[13] = new FloatingPlatform(Layout.GRID_12, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[14] = new FloatingPlatform(Layout.GRID_14, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[15] = new FloatingPlatform(Layout.GRID_16, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[16] = new FloatingPlatform(Layout.GRID_16 + TornadoGame.screenWidth / 2 - Layout.MEDIUM_WIDTH / 2, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[17] = new FloatingPlatform(Layout.GRID_16 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[18] = new FloatingPlatform(Layout.GRID_17, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[19] = new FloatingPlatform(Layout.GRID_18, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[20] = new FloatingPlatform(Layout.GRID_19, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[21] = new FloatingPlatform(Layout.GRID_20, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[22] = new FloatingPlatform(Layout.GRID_22, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[23] = new FloatingPlatform(Layout.GRID_22 + TornadoGame.screenWidth / 2 - Layout.MEDIUM_WIDTH / 2, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[24] = new FloatingPlatform(Layout.GRID_22 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[25] = new FloatingPlatform(Layout.GRID_24, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[26] = new FloatingPlatform(Layout.GRID_25, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[27] = new FloatingPlatform(Layout.GRID_26, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[28] = new FloatingPlatform(Layout.GRID_27, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[29] = new FloatingPlatform(Layout.GRID_28, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[30] = new FloatingPlatform(Layout.GRID_30, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[31] = new FloatingPlatform(Layout.GRID_31, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[32] = new FloatingPlatform(Layout.GRID_31 + TornadoGame.screenWidth / 2 - Layout.MEDIUM_WIDTH / 2, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[33] = new FloatingPlatform(Layout.GRID_31 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[34] = new FloatingPlatform(Layout.GRID_32, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[35] = new FloatingPlatform(Layout.GRID_33, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[36] = new FloatingPlatform(Layout.GRID_33, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[37] = new FloatingPlatform(Layout.GRID_34, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[38] = new FloatingPlatform(Layout.GRID_34, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[39] = new FloatingPlatform(Layout.GRID_35, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[40] = new FloatingPlatform(Layout.GRID_35, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[41] = new FloatingPlatform(Layout.GRID_38, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[42] = new FloatingPlatform(Layout.GRID_39 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[43] = new FloatingPlatform(Layout.GRID_39 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[44] = new FloatingPlatform(Layout.GRID_39, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[45] = new FloatingPlatform(Layout.GRID_40, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[46] = new FloatingPlatform(Layout.GRID_40 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[47] = new FloatingPlatform(Layout.GRID_40 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[48] = new FloatingPlatform(Layout.GRID_41, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[49] = new FloatingPlatform(Layout.GRID_44, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[50] = new FloatingPlatform(Layout.GRID_45, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[51] = new FloatingPlatform(Layout.GRID_46, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[52] = new FloatingPlatform(Layout.GRID_46  + TornadoGame.screenWidth - Layout.MEDIUM_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[53] = new FloatingPlatform(Layout.GRID_47, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[54] = new FloatingPlatform(Layout.GRID_49, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[55] = new FloatingPlatform(Layout.GRID_49 + TornadoGame.screenWidth - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[56] = new FloatingPlatform(Layout.GRID_49, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[57] = new FloatingPlatform(Layout.GRID_50, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[58] = new FloatingPlatform(Layout.GRID_52, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[59] = new FloatingPlatform(Layout.GRID_53, Layout.Y_POSITION_HIGH, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[60] = new FloatingPlatform(Layout.GRID_54, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[61] = new FloatingPlatform(Layout.GRID_56, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[62] = new FloatingPlatform(Layout.GRID_56 + TornadoGame.screenWidth - Layout.MEDIUM_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[63] = new FloatingPlatform(Layout.GRID_57, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[64] = new FloatingPlatform(Layout.GRID_59, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[65] = new FloatingPlatform(Layout.GRID_59, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[66] = new FloatingPlatform(Layout.GRID_59, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
	}
	
	private void loadCityLevel() {
		platforms[0]  = new FloatingPlatform(Layout.GRID_03, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[1]  = new FloatingPlatform(Layout.GRID_04, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[2]  = new FloatingPlatform(Layout.GRID_04 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[3]  = new FloatingPlatform(Layout.GRID_05, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[4]  = new FloatingPlatform(Layout.GRID_06, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[5]  = new FloatingPlatform(Layout.GRID_06 - TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[6]  = new FloatingPlatform(Layout.GRID_07, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[7]  = new FloatingPlatform(Layout.GRID_09, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[8]  = new FloatingPlatform(Layout.GRID_09 + TornadoGame.screenWidth / 2, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[9]  = new FloatingPlatform(Layout.GRID_10, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[10] = new FloatingPlatform(Layout.GRID_11, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[11] = new FloatingPlatform(Layout.GRID_11, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[12] = new FloatingPlatform(Layout.GRID_12, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[13] = new FloatingPlatform(Layout.GRID_12, Layout.Y_POSITION_HIGH, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[14] = new FloatingPlatform(Layout.GRID_14, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[15] = new FloatingPlatform(Layout.GRID_16, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[16] = new FloatingPlatform(Layout.GRID_16 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[17] = new FloatingPlatform(Layout.GRID_16 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[18] = new FloatingPlatform(Layout.GRID_17, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[19] = new FloatingPlatform(Layout.GRID_18, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[20] = new FloatingPlatform(Layout.GRID_19, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[21] = new FloatingPlatform(Layout.GRID_20, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[22] = new FloatingPlatform(Layout.GRID_22, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[23] = new FloatingPlatform(Layout.GRID_22 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[24] = new FloatingPlatform(Layout.GRID_22 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[25] = new FloatingPlatform(Layout.GRID_24, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[26] = new FloatingPlatform(Layout.GRID_25, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[27] = new FloatingPlatform(Layout.GRID_26, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[28] = new FloatingPlatform(Layout.GRID_27, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[29] = new FloatingPlatform(Layout.GRID_28, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[30] = new FloatingPlatform(Layout.GRID_30, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[31] = new FloatingPlatform(Layout.GRID_31, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[32] = new FloatingPlatform(Layout.GRID_31 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[33] = new FloatingPlatform(Layout.GRID_31 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[34] = new FloatingPlatform(Layout.GRID_32, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[35] = new FloatingPlatform(Layout.GRID_33, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[36] = new FloatingPlatform(Layout.GRID_33, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[37] = new FloatingPlatform(Layout.GRID_34, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[38] = new FloatingPlatform(Layout.GRID_34, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[39] = new FloatingPlatform(Layout.GRID_35, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[40] = new FloatingPlatform(Layout.GRID_35, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[41] = new FloatingPlatform(Layout.GRID_38, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[42] = new FloatingPlatform(Layout.GRID_39 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[43] = new FloatingPlatform(Layout.GRID_39 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[44] = new FloatingPlatform(Layout.GRID_39, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[45] = new FloatingPlatform(Layout.GRID_40, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[46] = new FloatingPlatform(Layout.GRID_40 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[47] = new FloatingPlatform(Layout.GRID_40 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[48] = new FloatingPlatform(Layout.GRID_41, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[49] = new FloatingPlatform(Layout.GRID_44, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[50] = new FloatingPlatform(Layout.GRID_45, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[51] = new FloatingPlatform(Layout.GRID_46, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[52] = new FloatingPlatform(Layout.GRID_46  + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[53] = new FloatingPlatform(Layout.GRID_47, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[54] = new FloatingPlatform(Layout.GRID_49, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[55] = new FloatingPlatform(Layout.GRID_49 + TornadoGame.screenWidth - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[56] = new FloatingPlatform(Layout.GRID_49, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[57] = new FloatingPlatform(Layout.GRID_50, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[58] = new FloatingPlatform(Layout.GRID_52, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[59] = new FloatingPlatform(Layout.GRID_53, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[60] = new FloatingPlatform(Layout.GRID_54, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[61] = new FloatingPlatform(Layout.GRID_56, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[62] = new FloatingPlatform(Layout.GRID_56 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[63] = new FloatingPlatform(Layout.GRID_57, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[64] = new FloatingPlatform(Layout.GRID_59, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[65] = new FloatingPlatform(Layout.GRID_59, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[66] = new FloatingPlatform(Layout.GRID_59, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
	}
	
	private void loadHellLevel() {
		platforms[0]  = new FloatingPlatform(Layout.GRID_03, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[1]  = new FloatingPlatform(Layout.GRID_04, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[2]  = new FloatingPlatform(Layout.GRID_04 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[3]  = new FloatingPlatform(Layout.GRID_05, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[4]  = new FloatingPlatform(Layout.GRID_06, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[5]  = new FloatingPlatform(Layout.GRID_06 - TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[6]  = new FloatingPlatform(Layout.GRID_07, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[7]  = new FloatingPlatform(Layout.GRID_09, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[8]  = new FloatingPlatform(Layout.GRID_09 + TornadoGame.screenWidth / 2, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[9]  = new FloatingPlatform(Layout.GRID_10, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[10] = new FloatingPlatform(Layout.GRID_11, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[11] = new FloatingPlatform(Layout.GRID_11, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[12] = new FloatingPlatform(Layout.GRID_12, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[13] = new FloatingPlatform(Layout.GRID_12, Layout.Y_POSITION_HIGH, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[14] = new FloatingPlatform(Layout.GRID_14, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[15] = new FloatingPlatform(Layout.GRID_16, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[16] = new FloatingPlatform(Layout.GRID_16 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[17] = new FloatingPlatform(Layout.GRID_16 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[18] = new FloatingPlatform(Layout.GRID_17, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[19] = new FloatingPlatform(Layout.GRID_18, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[20] = new FloatingPlatform(Layout.GRID_19, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[21] = new FloatingPlatform(Layout.GRID_20, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[22] = new FloatingPlatform(Layout.GRID_22, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[23] = new FloatingPlatform(Layout.GRID_22 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[24] = new FloatingPlatform(Layout.GRID_22 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[25] = new FloatingPlatform(Layout.GRID_24, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[26] = new FloatingPlatform(Layout.GRID_25, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[27] = new FloatingPlatform(Layout.GRID_26, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[28] = new FloatingPlatform(Layout.GRID_27, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[29] = new FloatingPlatform(Layout.GRID_28, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[30] = new FloatingPlatform(Layout.GRID_30, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[31] = new FloatingPlatform(Layout.GRID_31, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[32] = new FloatingPlatform(Layout.GRID_31 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[33] = new FloatingPlatform(Layout.GRID_31 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[34] = new FloatingPlatform(Layout.GRID_32, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[35] = new FloatingPlatform(Layout.GRID_33, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[36] = new FloatingPlatform(Layout.GRID_33, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[37] = new FloatingPlatform(Layout.GRID_34, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[38] = new FloatingPlatform(Layout.GRID_34, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[39] = new FloatingPlatform(Layout.GRID_35, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[40] = new FloatingPlatform(Layout.GRID_35, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[41] = new FloatingPlatform(Layout.GRID_38, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[42] = new FloatingPlatform(Layout.GRID_39 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[43] = new FloatingPlatform(Layout.GRID_39 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[44] = new FloatingPlatform(Layout.GRID_39, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[45] = new FloatingPlatform(Layout.GRID_40, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[46] = new FloatingPlatform(Layout.GRID_40 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[47] = new FloatingPlatform(Layout.GRID_40 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[48] = new FloatingPlatform(Layout.GRID_41, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[49] = new FloatingPlatform(Layout.GRID_44, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[50] = new FloatingPlatform(Layout.GRID_45, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[51] = new FloatingPlatform(Layout.GRID_46, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[52] = new FloatingPlatform(Layout.GRID_46  + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[53] = new FloatingPlatform(Layout.GRID_47, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[54] = new FloatingPlatform(Layout.GRID_49, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[55] = new FloatingPlatform(Layout.GRID_49 + TornadoGame.screenWidth - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[56] = new FloatingPlatform(Layout.GRID_49, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[57] = new FloatingPlatform(Layout.GRID_50, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[58] = new FloatingPlatform(Layout.GRID_52, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[59] = new FloatingPlatform(Layout.GRID_53, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[60] = new FloatingPlatform(Layout.GRID_54, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[61] = new FloatingPlatform(Layout.GRID_56, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[62] = new FloatingPlatform(Layout.GRID_56 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[63] = new FloatingPlatform(Layout.GRID_57, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[64] = new FloatingPlatform(Layout.GRID_59, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[65] = new FloatingPlatform(Layout.GRID_59, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[66] = new FloatingPlatform(Layout.GRID_59, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
	}
	
	private void loadArcticLevel() {
		platforms[0]  = new FloatingPlatform(Layout.GRID_03, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[1]  = new FloatingPlatform(Layout.GRID_04, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[2]  = new FloatingPlatform(Layout.GRID_05, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[3]  = new FloatingPlatform(Layout.GRID_06, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[4]  = new FloatingPlatform(Layout.GRID_07, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[5]  = new FloatingPlatform(Layout.GRID_08, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[6]  = new FloatingPlatform(Layout.GRID_09, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[7]  = new FloatingPlatform(Layout.GRID_10, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[8]  = new FloatingPlatform(Layout.GRID_11, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[9]  = new FloatingPlatform(Layout.GRID_14, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[10] = new FloatingPlatform(Layout.GRID_14, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[11] = new FloatingPlatform(Layout.GRID_15, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[12] = new FloatingPlatform(Layout.GRID_15, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[13] = new FloatingPlatform(Layout.GRID_16, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[14] = new FloatingPlatform(Layout.GRID_16, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[15] = new FloatingPlatform(Layout.GRID_18, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[16] = new FloatingPlatform(Layout.GRID_18, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[17] = new FloatingPlatform(Layout.GRID_20, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[18] = new FloatingPlatform(Layout.GRID_21, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[19] = new FloatingPlatform(Layout.GRID_22, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[20] = new FloatingPlatform(Layout.GRID_22, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[21] = new FloatingPlatform(Layout.GRID_23, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[22] = new FloatingPlatform(Layout.GRID_23, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[23] = new FloatingPlatform(Layout.GRID_24, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[24] = new FloatingPlatform(Layout.GRID_24, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[25] = new FloatingPlatform(Layout.GRID_25, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[26] = new FloatingPlatform(Layout.GRID_26, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[27] = new FloatingPlatform(Layout.GRID_27, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[28] = new FloatingPlatform(Layout.GRID_28, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[29] = new FloatingPlatform(Layout.GRID_28, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[30] = new FloatingPlatform(Layout.GRID_31, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[31] = new FloatingPlatform(Layout.GRID_32, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[32] = new FloatingPlatform(Layout.GRID_33, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[33] = new FloatingPlatform(Layout.GRID_34, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[34] = new FloatingPlatform(Layout.GRID_34, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[35] = new FloatingPlatform(Layout.GRID_34, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[36] = new FloatingPlatform(Layout.GRID_35, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[37] = new FloatingPlatform(Layout.GRID_35, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[38] = new FloatingPlatform(Layout.GRID_35, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[39] = new FloatingPlatform(Layout.GRID_36, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[40] = new FloatingPlatform(Layout.GRID_36, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[41] = new FloatingPlatform(Layout.GRID_36, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[42] = new FloatingPlatform(Layout.GRID_38, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[43] = new FloatingPlatform(Layout.GRID_38, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[44] = new FloatingPlatform(Layout.GRID_38, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[45] = new FloatingPlatform(Layout.GRID_39, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[46] = new FloatingPlatform(Layout.GRID_39, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[47] = new FloatingPlatform(Layout.GRID_39, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[48] = new FloatingPlatform(Layout.GRID_40, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[49] = new FloatingPlatform(Layout.GRID_40, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[50] = new FloatingPlatform(Layout.GRID_40, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[51] = new FloatingPlatform(Layout.GRID_41, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		for (int i = 51; i < platforms.length; i++) {
			platforms[i] = new FloatingPlatform(Layout.GRID_41, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		}
	}

	private void loadBeachLevel() {
		platforms[0]  = new FloatingPlatform(Layout.GRID_02 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[1]  = new FloatingPlatform(Layout.GRID_02 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[2]  = new FloatingPlatform(Layout.GRID_02 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[3]  = new FloatingPlatform(Layout.GRID_04, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[4]  = new FloatingPlatform(Layout.GRID_04, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[5]  = new FloatingPlatform(Layout.GRID_04, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[6]  = new FloatingPlatform(Layout.GRID_06, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[7]  = new FloatingPlatform(Layout.GRID_08, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[8]  = new FloatingPlatform(Layout.GRID_08, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[9]  = new FloatingPlatform(Layout.GRID_08, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[10] = new FloatingPlatform(Layout.GRID_09, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[11] = new FloatingPlatform(Layout.GRID_09, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[12] = new FloatingPlatform(Layout.GRID_09, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[13] = new FloatingPlatform(Layout.GRID_10, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[14] = new FloatingPlatform(Layout.GRID_11, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[15] = new FloatingPlatform(Layout.GRID_11 + TornadoGame.screenWidth - Layout.MEDIUM_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[16] = new FloatingPlatform(Layout.GRID_11 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[17] = new FloatingPlatform(Layout.GRID_13, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[18] = new FloatingPlatform(Layout.GRID_13, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[19] = new FloatingPlatform(Layout.GRID_13, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[20] = new FloatingPlatform(Layout.GRID_15, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[21] = new FloatingPlatform(Layout.GRID_16, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[22] = new FloatingPlatform(Layout.GRID_16 + TornadoGame.screenWidth - Layout.MEDIUM_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[23] = new FloatingPlatform(Layout.GRID_18, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[24] = new FloatingPlatform(Layout.GRID_18, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[25] = new FloatingPlatform(Layout.GRID_18, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[26] = new FloatingPlatform(Layout.GRID_19, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[27] = new FloatingPlatform(Layout.GRID_21, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[28] = new FloatingPlatform(Layout.GRID_21, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[29] = new FloatingPlatform(Layout.GRID_21, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[30] = new FloatingPlatform(Layout.GRID_22 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[31] = new FloatingPlatform(Layout.GRID_23, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[32] = new FloatingPlatform(Layout.GRID_23, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[33] = new FloatingPlatform(Layout.GRID_23, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[34] = new FloatingPlatform(Layout.GRID_24, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[35] = new FloatingPlatform(Layout.GRID_26, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[36] = new FloatingPlatform(Layout.GRID_28, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[37] = new FloatingPlatform(Layout.GRID_28, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[38] = new FloatingPlatform(Layout.GRID_28, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[39] = new FloatingPlatform(Layout.GRID_30, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[40] = new FloatingPlatform(Layout.GRID_31, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[41] = new FloatingPlatform(Layout.GRID_32, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[42] = new FloatingPlatform(Layout.GRID_34, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[43] = new FloatingPlatform(Layout.GRID_34, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[44] = new FloatingPlatform(Layout.GRID_34, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[45] = new FloatingPlatform(Layout.GRID_35, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[46] = new FloatingPlatform(Layout.GRID_35, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[47] = new FloatingPlatform(Layout.GRID_35, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[48] = new FloatingPlatform(Layout.GRID_37, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[49] = new FloatingPlatform(Layout.GRID_38, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[50] = new FloatingPlatform(Layout.GRID_38, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[51] = new FloatingPlatform(Layout.GRID_38, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[52] = new FloatingPlatform(Layout.GRID_40, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[53] = new FloatingPlatform(Layout.GRID_40, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[54] = new FloatingPlatform(Layout.GRID_40, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[55] = new FloatingPlatform(Layout.GRID_41, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[56] = new FloatingPlatform(Layout.GRID_41, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[57] = new FloatingPlatform(Layout.GRID_41, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		for (int i = 57; i < platforms.length; i++) {
			platforms[i] = new FloatingPlatform(-10000, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		}
	}

	private void loadSpaceLevel() {
		platforms[0]  = new FloatingPlatform(Layout.GRID_02, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[1]  = new FloatingPlatform(Layout.GRID_03, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[2]  = new FloatingPlatform(Layout.GRID_03 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[3]  = new FloatingPlatform(Layout.GRID_04, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[4]  = new FloatingPlatform(Layout.GRID_04 + TornadoGame.screenWidth - Layout.MEDIUM_WIDTH, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[5]  = new FloatingPlatform(Layout.GRID_05 + Layout.MEDIUM_WIDTH - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[6]  = new FloatingPlatform(Layout.GRID_06, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[7]  = new FloatingPlatform(Layout.GRID_07, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[8]  = new FloatingPlatform(Layout.GRID_10, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[9]  = new FloatingPlatform(Layout.GRID_10 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[10] = new FloatingPlatform(Layout.GRID_10 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[11] = new FloatingPlatform(Layout.GRID_11, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[12] = new FloatingPlatform(Layout.GRID_12, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[13] = new FloatingPlatform(Layout.GRID_13, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[14] = new FloatingPlatform(Layout.GRID_13 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[15] = new FloatingPlatform(Layout.GRID_13 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[16] = new FloatingPlatform(Layout.GRID_14 + TornadoGame.screenWidth / 2, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[17] = new FloatingPlatform(Layout.GRID_16, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[18] = new FloatingPlatform(Layout.GRID_17, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[19] = new FloatingPlatform(Layout.GRID_17 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[20] = new FloatingPlatform(Layout.GRID_17, Layout.Y_POSITION_HIGH, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[21] = new FloatingPlatform(Layout.GRID_19, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[22] = new FloatingPlatform(Layout.GRID_19, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[23] = new FloatingPlatform(Layout.GRID_19 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[24] = new FloatingPlatform(Layout.GRID_20, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[25] = new FloatingPlatform(Layout.GRID_20 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[26] = new FloatingPlatform(Layout.GRID_21, Layout.Y_POSITION_HIGH, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[27] = new FloatingPlatform(Layout.GRID_21, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[28] = new FloatingPlatform(Layout.GRID_21 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[29] = new FloatingPlatform(Layout.GRID_22, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[30] = new FloatingPlatform(Layout.GRID_22 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[31] = new FloatingPlatform(Layout.GRID_22 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[32] = new FloatingPlatform(Layout.GRID_24, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[33] = new FloatingPlatform(Layout.GRID_24, Layout.Y_POSITION_HIGH, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[34] = new FloatingPlatform(Layout.GRID_26, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[35] = new FloatingPlatform(Layout.GRID_27, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[36] = new FloatingPlatform(Layout.GRID_28, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[37] = new FloatingPlatform(Layout.GRID_28 + TornadoGame.screenWidth - Layout.MEDIUM_WIDTH, Layout.Y_POSITION_HIGH, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[38] = new FloatingPlatform(Layout.GRID_29, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[39] = new FloatingPlatform(Layout.GRID_29 + TornadoGame.screenWidth - Layout.MEDIUM_WIDTH, Layout.Y_POSITION_HIGH, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[40] = new FloatingPlatform(Layout.GRID_30, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[41] = new FloatingPlatform(Layout.GRID_32, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[42] = new FloatingPlatform(Layout.GRID_32, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[43] = new FloatingPlatform(Layout.GRID_32 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[44] = new FloatingPlatform(Layout.GRID_33, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[45] = new FloatingPlatform(Layout.GRID_34, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[46] = new FloatingPlatform(Layout.GRID_34 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[47] = new FloatingPlatform(Layout.GRID_35 + TornadoGame.screenWidth - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[48] = new FloatingPlatform(Layout.GRID_36, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[49] = new FloatingPlatform(Layout.GRID_36 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[50] = new FloatingPlatform(Layout.GRID_37, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[51] = new FloatingPlatform(Layout.GRID_37, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[52] = new FloatingPlatform(Layout.GRID_38, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[53] = new FloatingPlatform(Layout.GRID_38 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[54] = new FloatingPlatform(Layout.GRID_39, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[55] = new FloatingPlatform(Layout.GRID_39 + TornadoGame.screenWidth / 2, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[56] = new FloatingPlatform(Layout.GRID_40, Layout.Y_POSITION_HIGH, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[57] = new FloatingPlatform(Layout.GRID_40 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		for (int i = 57; i < platforms.length; i++) {
			platforms[i] = new FloatingPlatform(-10000, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		}
	}

	private void loadFarmLevel() {
		platforms[0]  = new FloatingPlatform(Layout.GRID_02 + Layout.MEDIUM_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[1]  = new FloatingPlatform(Layout.GRID_04, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[2]  = new FloatingPlatform(platforms[1].getX() + platforms[1].getWidth() - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[3]  = new FloatingPlatform(Layout.GRID_06, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[4]  = new FloatingPlatform(Layout.GRID_06 + Layout.MEDIUM_WIDTH - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[5]  = new FloatingPlatform(Layout.GRID_06 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[6]  = new FloatingPlatform(Layout.GRID_08, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[7]  = new FloatingPlatform(Layout.GRID_08 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[8]  = new FloatingPlatform(Layout.GRID_10, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[9]  = new FloatingPlatform(Layout.GRID_10, Layout.Y_POSITION_HIGH, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[10] = new FloatingPlatform(Layout.GRID_11, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[11] = new FloatingPlatform(Layout.GRID_11 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[12] = new FloatingPlatform(Layout.GRID_11 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[13] = new FloatingPlatform(Layout.GRID_12, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[14] = new FloatingPlatform(Layout.GRID_12, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[15] = new FloatingPlatform(Layout.GRID_12 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[16] = new FloatingPlatform(Layout.GRID_14, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[17] = new FloatingPlatform(Layout.GRID_15, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[18] = new FloatingPlatform(Layout.GRID_16, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[19] = new FloatingPlatform(Layout.GRID_16, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[20] = new FloatingPlatform(Layout.GRID_16 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[21] = new FloatingPlatform(Layout.GRID_18, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[22] = new FloatingPlatform(Layout.GRID_18 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[23] = new FloatingPlatform(Layout.GRID_18 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[24] = new FloatingPlatform(Layout.GRID_19, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[25] = new FloatingPlatform(Layout.GRID_20, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[26] = new FloatingPlatform(Layout.GRID_20 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[27] = new FloatingPlatform(Layout.GRID_20 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[28] = new FloatingPlatform(Layout.GRID_21, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[29] = new FloatingPlatform(Layout.GRID_21 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[30] = new FloatingPlatform(Layout.GRID_23, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[31] = new FloatingPlatform(Layout.GRID_24, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[32] = new FloatingPlatform(Layout.GRID_24 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[33] = new FloatingPlatform(Layout.GRID_25 + TornadoGame.screenWidth / 2, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[34] = new FloatingPlatform(Layout.GRID_26, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[35] = new FloatingPlatform(Layout.GRID_26 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[36] = new FloatingPlatform(Layout.GRID_27, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[37] = new FloatingPlatform(Layout.GRID_28, Layout.Y_POSITION_MEDIUM, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[38] = new FloatingPlatform(Layout.GRID_30, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[39] = new FloatingPlatform(Layout.GRID_30 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[40] = new FloatingPlatform(Layout.GRID_30 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[41] = new FloatingPlatform(Layout.GRID_30 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[42] = new FloatingPlatform(Layout.GRID_31 + TornadoGame.screenWidth / 2, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[43] = new FloatingPlatform(Layout.GRID_32 + TornadoGame.screenWidth / 2, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[44] = new FloatingPlatform(Layout.GRID_33 + TornadoGame.screenWidth / 2, Layout.Y_POSITION_HIGH, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[45] = new FloatingPlatform(Layout.GRID_34 + TornadoGame.screenWidth / 2, Layout.Y_POSITION_HIGH, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[46] = new FloatingPlatform(Layout.GRID_35, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[47] = new FloatingPlatform(Layout.GRID_35 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[48] = new FloatingPlatform(Layout.GRID_37, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[49] = new FloatingPlatform(Layout.GRID_37 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[50] = new FloatingPlatform(Layout.GRID_38, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[51] = new FloatingPlatform(Layout.GRID_38 + TornadoGame.screenWidth / 2, Layout.Y_POSITION_HIGH, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[52] = new FloatingPlatform(Layout.GRID_39, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[53] = new FloatingPlatform(Layout.GRID_39, Layout.Y_POSITION_HIGH, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[54] = new FloatingPlatform(Layout.GRID_39 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[55] = new FloatingPlatform(Layout.GRID_40, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[56] = new FloatingPlatform(Layout.GRID_40 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[57] = new FloatingPlatform(Layout.GRID_40 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		for (int i = 57; i < platforms.length; i++) {
			platforms[i] = new FloatingPlatform(-10000, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		}
	}

	private void loadTestLevel() {
		platforms[0]  = new FloatingPlatform(Layout.GRID_03, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[1]  = new FloatingPlatform(Layout.GRID_04, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[2]  = new FloatingPlatform(platforms[1].getX() + Layout.LARGE_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[3]  = new FloatingPlatform(platforms[1].getX() + Layout.LARGE_WIDTH + Layout.MEDIUM_WIDTH, Layout.Y_POSITION_HIGH, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[4]  = new FloatingPlatform(Layout.GRID_06, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[5]  = new FloatingPlatform(Layout.GRID_06 + TornadoGame.screenWidth - Layout.MEDIUM_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[6]  = new FloatingPlatform(Layout.GRID_08, Layout.Y_POSITION_LOW, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[7]  = new FloatingPlatform(Layout.GRID_08 + Layout.MEDIUM_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[8]  = new FloatingPlatform(Layout.GRID_08 + Layout.MEDIUM_WIDTH * 2, Layout.Y_POSITION_HIGH, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[9]  = new FloatingPlatform(Layout.GRID_09, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[10] = new FloatingPlatform(Layout.GRID_11, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[11] = new FloatingPlatform(Layout.GRID_11 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[12] = new FloatingPlatform(Layout.GRID_11 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[13] = new FloatingPlatform(Layout.GRID_12 + TornadoGame.screenWidth - Layout.LARGE_WIDTH, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[14] = new FloatingPlatform(Layout.GRID_13, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[15] = new FloatingPlatform(Layout.GRID_13 + Layout.SMALL_WIDTH, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[16] = new FloatingPlatform(Layout.GRID_15, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[17] = new FloatingPlatform(Layout.GRID_16, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[18] = new FloatingPlatform(Layout.GRID_16 + TornadoGame.screenWidth / 2 - Layout.SMALL_WIDTH / 2, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[19] = new FloatingPlatform(Layout.GRID_16 + TornadoGame.screenWidth - Layout.SMALL_WIDTH, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[20] = new FloatingPlatform(Layout.GRID_17 + TornadoGame.screenWidth / 2, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[21] = new FloatingPlatform(Layout.GRID_17 + TornadoGame.screenWidth / 2 + Layout.SMALL_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[22] = new FloatingPlatform(Layout.GRID_17 + TornadoGame.screenWidth / 2 + Layout.SMALL_WIDTH * 2, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0);
		platforms[23] = new FloatingPlatform(Layout.GRID_19, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[24] = new FloatingPlatform(Layout.GRID_19 + TornadoGame.screenWidth - Layout.MEDIUM_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.MEDIUM_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[25] = new FloatingPlatform(Layout.GRID_20, Layout.Y_POSITION_LOW, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[26] = new FloatingPlatform(Layout.GRID_20 + Layout.SMALL_WIDTH, Layout.Y_POSITION_MEDIUM, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[27] = new FloatingPlatform(Layout.GRID_20 + Layout.SMALL_WIDTH * 2, Layout.Y_POSITION_HIGH, Layout.SMALL_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		platforms[28] = new FloatingPlatform(Layout.GRID_21, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		for (int i = 28; i < platforms.length; i++) {
			platforms[i] = new FloatingPlatform(Layout.GRID_21, Layout.Y_POSITION_LOW, Layout.LARGE_WIDTH, HEIGHT, floatingPlatformTexture, Background.SCROLL_SPEED_FRONT_LAYER, 0); 
		}
	}

	public Ground getGround() {
		return ground;
	}

	public void update(Player player, Level level) {
		// Platforms act as gravity barriers.
		if (!level.isLevelIsOver()) {
			if (player.getY() <= ground.getY() + ground.getHeight()) {
				player.setY(ground.getY() + ground.getHeight() + 1);
				player.setCanJump(true);
			}
			for (int i = 0; i < platforms.length; i++) {
				platforms[i].update();
				checkPlayerCollisionWithPlatform(player, platforms[i]);
			}
		}
	}

	private void checkPlayerCollisionWithPlatform(Player player, Platform platform) {
		if (
				player.getY() <= platform.getY() + platform.getHeight() && 
				player.getY() + player.getHeight() / 4 > platform.getY() && 
				player.getX() + player.getWidth() > platform.getX() && 
				player.getX() < platform.getX() + platform.getWidth()) {
			player.setY(platform.getY() + platform.getHeight());
			player.setCanJump(true);
		}
	}

	public void draw(SpriteBatch batch) {
		// Don't draw the ground platform.  It only acts as a barrier so the player doesn't fall through the floor.
		for (int i = 0; i < platforms.length; i++) {
			
			float platformY = platforms[i].getY();
			
			//drawPlatformShadow(batch, i);
			
			platforms[i].setY(platformY);
			platforms[i].draw(batch);
		}
	}
	
	private void drawPlatformShadow(SpriteBatch batch, int increment) {
		batch.setColor(Color.DARK_GRAY);
		platforms[increment].setY(-200);
		platforms[increment].draw(batch);
		batch.setColor(Color.WHITE);
	}

	public FloatingPlatform[] getPlatforms() {
		return platforms;
	}
	
	public static void dispose() {
		floatingPlatformTexture.dispose();
	}
}
