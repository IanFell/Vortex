package com.tornadogame.handlers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.backgrounds.BackLayer;
import com.tornadogame.backgrounds.Background;
import com.tornadogame.backgrounds.MidLayer;
import com.tornadogame.foreground.Flame;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.layout.Layout;
import com.tornadogame.levels.ArcticLevel;
import com.tornadogame.levels.BeachLevel;
import com.tornadogame.levels.DesertLevel;
import com.tornadogame.levels.FarmLevel;
import com.tornadogame.levels.HellLevel;
import com.tornadogame.levels.Level;
import com.tornadogame.levels.SpaceLevel;

public class BackgroundHandler {

	private BackLayer backLayer;
	private MidLayer midLayerOne;
	private MidLayer midLayerTwo;
	private MidLayer midLayerThree;
	private MidLayer midLayerFour;
	private MidLayer frontLayer;

	public static Texture watertowerTexture;
	public static Texture lightHouseTexture;
	public static Texture pyramidTexture;
	//public static Texture scarecrowTexture;
	public static Texture rocketTexture;
	public static Texture boatTexture;
	public static Texture iceburgTexture;
	public static Texture gargoyleTexture;

	// This is the actual flame in hell level.  The "fire" is the debree.
	private Flame flame;
	private float flameWidth;
	private float flameHeight;

	public BackgroundHandler(int levelToLoad) {
		switch (levelToLoad) {
		case LevelHandler.LEVEL_TEST:
			loadTestLevel();
			break;
		case LevelHandler.LEVEL_FARM:
			loadFarmLevel();
			break;
		case LevelHandler.LEVEL_SPACE:
			loadSpaceLevel();
			break;
		case LevelHandler.LEVEL_BEACH:
			loadBeachLevel();
			break;
		case LevelHandler.LEVEL_ARCTIC:
			loadArcticLevel();
			break;
		case LevelHandler.LEVEL_HELL:
			loadHellLevel();
			break;
		case LevelHandler.LEVEL_CITY:
			loadCityLevel();
			break;
		case LevelHandler.LEVEL_DESERT:
			loadDesertLevel();
			break;
		case LevelHandler.LEVEL_FORREST:
			loadForrestLevel();
			break;
		case LevelHandler.LEVEL_TRACK:
			loadTrackLevel();
			break;
		case LevelHandler.LEVEL_END:
			loadEndLevel();
			break;
		case LevelHandler.LEVEL_DOUBLE:
			loadEndLevel();
			break;
		}

		watertowerTexture = new Texture("artwork/levels/farmlevel/Watertower.png");
		lightHouseTexture = new Texture("artwork/levels/beachlevel/LightHouse.png");
		pyramidTexture = new Texture("artwork/levels/desertlevel/pyramid.png");
		//scarecrowTexture = new Texture("artwork/levels/farmlevel/Scarecrow.png");
		rocketTexture = new Texture("artwork/levels/spacelevel/Rocket.png");
		boatTexture = new Texture("artwork/levels/beachlevel/Boat.png");
		iceburgTexture = new Texture("artwork/levels/arcticlevel/Iceburg.png");
		gargoyleTexture = new Texture("artwork/levels/helllevel/GG.png");

		flameWidth  = 250;
		flameHeight = 600;

		flame = new Flame(
				TornadoGame.screenWidth * 3f,
				TornadoGame.screenHeight - flameHeight * 1.53f,
				flameWidth,
				flameHeight,
				new Texture("artwork/levels/helllevel/fire.png"),
				Background.SCROLL_SPEED_MID_LAYER_03,
				0
				);
	}

	public void update(Player player, Level level) {
		midLayerOne.update(player, level);
		midLayerTwo.update(player, level);
		if (midLayerThree != null) {
			midLayerThree.update(player, level);
		}
		if (midLayerFour != null) {
			midLayerFour.update(player, level);
		}
		frontLayer.update(player, level);
	}

	public void draw(SpriteBatch batch, int level) {
		backLayer.draw(batch);
		if (level == LevelHandler.LEVEL_HELL) {
			// TODO Updating flame shouldn't be here, it should be in the update method.
			flame.update();
			flame.draw(batch);
		}
		if (level == LevelHandler.LEVEL_BEACH) {
			batch.draw(
					lightHouseTexture, 
					BeachLevel.lightHouseX, 
					BeachLevel.lightHouseY, 
					BeachLevel.lightHouseWidth, 
					BeachLevel.lightHouseHeight
					);
		}
		if (level == LevelHandler.LEVEL_DESERT) {
			// Big pyramid.
			batch.draw(
					pyramidTexture, 
					DesertLevel.pyramidX, 
					DesertLevel.pyramidY, 
					DesertLevel.pyramidWidth, 
					DesertLevel.pyramidHeight
					);
			// Small pyramid
			// Don't draw this.  Since they're both using the same pyramid x position it disappears
			// and gets shot over to the other side and looks weird.
			/*
			batch.draw(
					pyramidTexture, 
					DesertLevel.pyramidX / 3, 
					DesertLevel.pyramidY - 50, 
					DesertLevel.pyramidWidth / 1.5f, 
					DesertLevel.pyramidHeight / 1.5f
					); */
		}
		midLayerOne.draw(batch);
		if (level == LevelHandler.LEVEL_FARM) {
			batch.draw(watertowerTexture, FarmLevel.watertowerX, FarmLevel.watertowerY, FarmLevel.watertowerWidth, FarmLevel.watertowerHeight);
			//batch.draw(scarecrowTexture, FarmLevel.scarecrowX, FarmLevel.scarecrowY, FarmLevel.scarecrowWidth, FarmLevel.scarecrowHeight);
		}
		if (level == LevelHandler.LEVEL_SPACE) {
			batch.draw(rocketTexture, SpaceLevel.rocketX, SpaceLevel.rocketY, SpaceLevel.rocketWidth, SpaceLevel.rocketHeight);
		}
		if (level == LevelHandler.LEVEL_BEACH) {
			batch.draw(boatTexture, BeachLevel.boatX, BeachLevel.boatY, BeachLevel.boatWidth, BeachLevel.boatHeight);
		}
		if (level == LevelHandler.LEVEL_ARCTIC) {
			batch.draw(iceburgTexture, ArcticLevel.iceburgX, ArcticLevel.iceburgY, ArcticLevel.iceburgWidth, ArcticLevel.iceburgHeight);
		}
		if (level == LevelHandler.LEVEL_HELL) { 
			batch.draw(gargoyleTexture, HellLevel.gargoyleX, HellLevel.gargoyleY, HellLevel.gargoyleWidth, HellLevel.gargoyleHeight);
		}
		// Arctic looks better without this layer.  Lets remove it.
		if (level != LevelHandler.LEVEL_ARCTIC) { 
			midLayerTwo.draw(batch);
		}
		if (midLayerThree != null) {
			midLayerThree.draw(batch);
		}

		// Draw midLayerFour here normally.  See below for farm level rendering.
		if (TornadoGame.levelToLoad == LevelHandler.LEVEL_SPACE || TornadoGame.levelToLoad == LevelHandler.LEVEL_BEACH) {
			if (midLayerFour != null) {
				midLayerFour.draw(batch);
			}
		}

		frontLayer.draw(batch);

		// Draw midLayerFour here in farm level because the fence looks better.
		if (TornadoGame.levelToLoad == LevelHandler.LEVEL_FARM) {
			if (midLayerFour != null) {
				midLayerFour.draw(batch);
			}
		}
	}

	private void loadEndLevel() {
		backLayer   = new BackLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/farmlevel/Background.png"), 0, 0, 0);
		midLayerOne = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/tracklevel/RollingHillsBack_Alt3_4Square_Alt2.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_01);
		midLayerTwo = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/tracklevel/RollingHillsFront.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_02);
		midLayerThree = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/tracklevel/Fence.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_03);
		midLayerFour = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/beachlevel/Fence.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_04);
		frontLayer  = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/tracklevel/Runway.png"), 0, 0, Background.SCROLL_SPEED_FRONT_LAYER);
	}

	private void loadTrackLevel() {
		backLayer   = new BackLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/farmlevel/Background.png"), 0, 0, 0);
		midLayerOne = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/tracklevel/RollingHillsBack_Alt3_4Square_Alt2.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_01);
		midLayerTwo = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/tracklevel/RollingHillsFront.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_02);
		midLayerThree = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/tracklevel/Fence.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_03);
		midLayerFour = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/beachlevel/Fence.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_04);
		frontLayer  = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/tracklevel/Runway.png"), 0, 0, Background.SCROLL_SPEED_FRONT_LAYER);
	}

	private void loadForrestLevel() {
		backLayer   = new BackLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/farmlevel/Background.png"), 0, 0, 0);
		midLayerOne = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/forrestlevel/RollingHillsBack.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_01);
		midLayerTwo = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/forrestlevel/RollingHillsFront.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_02);
		midLayerThree = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/forrestlevel/Fence.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_03);
		midLayerFour = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/beachlevel/Fence.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_04);
		frontLayer  = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/forrestlevel/Runway.png"), 0, 0, Background.SCROLL_SPEED_FRONT_LAYER);
	}

	private void loadDesertLevel() {
		backLayer   = new BackLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/desertlevel/Background.png"), 0, 0, 0);
		midLayerOne = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/desertlevel/RollingHillsBack.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_01);
		midLayerTwo = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/desertlevel/RollingHillsFront.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_02);
		midLayerThree = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/desertlevel/Fence.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_03);
		midLayerFour = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/beachlevel/Fence.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_04);
		frontLayer  = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/desertlevel/Runway.png"), 0, 0, Background.SCROLL_SPEED_FRONT_LAYER);
	}

	private void loadCityLevel() {
		backLayer   = new BackLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/farmlevel/Background.png"), 0, 0, 0);
		midLayerOne = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/citylevel/RollingHillsBack.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_01);
		midLayerTwo = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/citylevel/RollingHillsFront.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_02);
		midLayerThree = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/citylevel/Fence.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_03);
		midLayerFour = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/beachlevel/Fence.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_04);
		frontLayer  = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/citylevel/Runway.png"), 0, 0, Background.SCROLL_SPEED_FRONT_LAYER);
	}

	private void loadHellLevel() {
		backLayer   = new BackLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/helllevel/Background.png"), 0, 0, 0);
		midLayerOne = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/helllevel/RollingHillsBack.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_01);
		midLayerTwo = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/helllevel/RollingHillsFront.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_02);
		midLayerThree = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/helllevel/Fence.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_03);
		midLayerFour = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/beachlevel/Fence.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_04);
		frontLayer  = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/helllevel/Runway.png"), 0, 0, Background.SCROLL_SPEED_FRONT_LAYER);
	}

	private void loadArcticLevel() {
		backLayer   = new BackLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/arcticlevel/Background.png"), 0, 0, 0);
		midLayerOne = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/arcticlevel/RollingHillsBack.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_01);
		midLayerTwo = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/arcticlevel/RollingHillsFront.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_02);
		midLayerThree = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/arcticlevel/Corn.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_03);
		midLayerFour = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/beachlevel/Fence.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_04);
		frontLayer  = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/arcticlevel/Runway.png"), 0, 0, Background.SCROLL_SPEED_FRONT_LAYER);
	}

	private void loadBeachLevel() {
		backLayer   = new BackLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/beachlevel/Background.png"), 0, 0, 0);
		midLayerOne = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/beachlevel/RollingHillsBack.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_01);
		midLayerTwo = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/beachlevel/RollingHillsFront.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_02);
		midLayerThree = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/beachlevel/Corn.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_03);
		midLayerFour = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/beachlevel/Fence.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_04);
		frontLayer  = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/beachlevel/Runway.png"), 0, 0, Background.SCROLL_SPEED_FRONT_LAYER);
	}

	private void loadSpaceLevel() {
		backLayer   = new BackLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/spacelevel/Background.png"), 0, 0, 0);
		midLayerOne = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/spacelevel/RollingHillsBack.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_01);
		midLayerTwo = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/spacelevel/RollingHillsFront.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_02);
		midLayerThree = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/spacelevel/Corn.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_03);
		midLayerFour = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/spacelevel/Fence.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_04);
		frontLayer  = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/spacelevel/Runway.png"), 0, 0, Background.SCROLL_SPEED_FRONT_LAYER);
	}

	private void loadFarmLevel() {
		int increment = 0;
		backLayer   = new BackLayer(Layout.GRID_01, 0, TornadoGame.screenWidth + increment, TornadoGame.screenHeight, new Texture("artwork/levels/farmlevel/Background.png"), 0, 0, 0);
		midLayerOne = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth + increment, TornadoGame.screenHeight, new Texture("artwork/levels/farmlevel/RollingHillsBack.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_01);
		midLayerTwo = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth + increment, TornadoGame.screenHeight, new Texture("artwork/levels/farmlevel/RollingHillsFront.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_02);
		midLayerThree = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth + increment, TornadoGame.screenHeight, new Texture("artwork/levels/farmlevel/Corn.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_03);
		midLayerFour = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth + increment, TornadoGame.screenHeight, new Texture("artwork/levels/farmlevel/Fence.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_04);
		frontLayer  = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth + increment, TornadoGame.screenHeight, new Texture("artwork/levels/farmlevel/Runway.png"), 0, 0, Background.SCROLL_SPEED_FRONT_LAYER);
	}

	private void loadTestLevel() {
		backLayer   = new BackLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/testlevel/BackGround.png"), 0, 0, 0);
		midLayerOne = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/testlevel/Farm.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_01);
		midLayerTwo = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/testlevel/Fence.png"), 0, 0, Background.SCROLL_SPEED_MID_LAYER_03);
		frontLayer  = new MidLayer(Layout.GRID_01, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/levels/testlevel/Sidewalk.png"), 0, 0, Background.SCROLL_SPEED_FRONT_LAYER);
	}

	public static void dispose() {
		watertowerTexture.dispose();
		lightHouseTexture.dispose();
		pyramidTexture.dispose();
		rocketTexture.dispose();
		boatTexture.dispose();
		iceburgTexture.dispose();
		gargoyleTexture.dispose();
	}
}
