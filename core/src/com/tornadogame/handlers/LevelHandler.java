package com.tornadogame.handlers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.layout.Layout;
import com.tornadogame.levels.ArcticLevel;
import com.tornadogame.levels.BeachLevel;
import com.tornadogame.levels.CityLevel;
import com.tornadogame.levels.DesertLevel;
import com.tornadogame.levels.DoubleLevel;
import com.tornadogame.levels.EndLevel;
import com.tornadogame.levels.FarmLevel;
import com.tornadogame.levels.ForrestLevel;
import com.tornadogame.levels.HellLevel;
import com.tornadogame.levels.Level;
import com.tornadogame.levels.SpaceLevel;
import com.tornadogame.levels.TestLevel;
import com.tornadogame.levels.TrackLevel;

public class LevelHandler {

	public static final int LEVEL_TEST    = 0;
	public static final int LEVEL_FARM    = 1;
	public static final int LEVEL_SPACE   = 2;
	public static final int LEVEL_BEACH   = 3;
	public static final int LEVEL_ARCTIC  = 4;
	public static final int LEVEL_HELL    = 5;
	public static final int LEVEL_CITY    = 6;
	public static final int LEVEL_DESERT  = 7;
	public static final int LEVEL_FORREST = 8;
	public static final int LEVEL_TRACK   = 9;
	public static final int LEVEL_END     = 10;
	public static final int LEVEL_DOUBLE  = 11;

	private int currentLevel;

	private TestLevel testLevel;
	private FarmLevel farmLevel;
	private SpaceLevel spaceLevel;
	private BeachLevel beachLevel;
	private ArcticLevel arcticLevel;
	private HellLevel hellLevel;
	private CityLevel cityLevel;
	private DesertLevel desertLevel;
	private ForrestLevel forrestLevel;
	private TrackLevel trackLevel;
	private EndLevel endLevel;
	private DoubleLevel doubleLevel;

	public LevelHandler(OrthographicCamera camera, int levelToLoad) {
		currentLevel = levelToLoad;
		switch (currentLevel) {
		case LEVEL_TEST:
			testLevel = new TestLevel(camera, Layout.GRID_21);
			break;
		case LEVEL_FARM:
			farmLevel = new FarmLevel(camera, Layout.GRID_42, levelToLoad);
			break;
		case LEVEL_SPACE:
			spaceLevel = new SpaceLevel(camera, Layout.GRID_42, levelToLoad);
			break;
		case LEVEL_BEACH:
			beachLevel = new BeachLevel(camera, Layout.GRID_42, levelToLoad);
			break;
		case LEVEL_ARCTIC:
			arcticLevel = new ArcticLevel(camera, Layout.GRID_42, levelToLoad);
			break;
		case LEVEL_HELL:
			hellLevel = new HellLevel(camera, Layout.GRID_67, levelToLoad);
			break;
		case LEVEL_CITY:
			cityLevel = new CityLevel(camera, Layout.GRID_61, levelToLoad);
			break;
		case LEVEL_DESERT:
			desertLevel = new DesertLevel(camera, Layout.GRID_61, levelToLoad);
			break;
		case LEVEL_FORREST:
			forrestLevel = new ForrestLevel(camera, Layout.GRID_61, levelToLoad);
			break;
		case LEVEL_TRACK:
			trackLevel = new TrackLevel(camera, Layout.GRID_61, levelToLoad);
			break;
		case LEVEL_END:
			endLevel = new EndLevel(camera, Layout.GRID_61, levelToLoad);
			break;
		case LEVEL_DOUBLE:
			doubleLevel = new DoubleLevel(camera, Layout.GRID_61, levelToLoad);
			break;
		}
	}

	public void update(OrthographicCamera camera, TornadoGame tornadoGame) {
		switch (currentLevel) {
		case LEVEL_TEST:
			testLevel.update(this, camera, tornadoGame);
			break;
		case LEVEL_FARM:
			farmLevel.update(this, camera, tornadoGame); 
			break;
		case LEVEL_SPACE:
			spaceLevel.update(this, camera, tornadoGame);
			break;
		case LEVEL_BEACH:
			beachLevel.update(this, camera, tornadoGame);
			break;
		case LEVEL_ARCTIC:
			arcticLevel.update(this, camera, tornadoGame);
			break;
		case LEVEL_HELL:
			hellLevel.update(this, camera, tornadoGame);
			break;
		case LEVEL_CITY:
			cityLevel.update(this, camera, tornadoGame);
			break;
		case LEVEL_DESERT:
			desertLevel.update(this, camera, tornadoGame);
			break;
		case LEVEL_FORREST:
			forrestLevel.update(this, camera, tornadoGame);
			break;
		case LEVEL_TRACK:
			trackLevel.update(this, camera, tornadoGame);
			break;
		case LEVEL_END:
			endLevel.update(this, camera, tornadoGame);
			break;
		case LEVEL_DOUBLE:
			doubleLevel.update(this, camera, tornadoGame);
			break;
		}
	}

	public void draw(SpriteBatch batch) {
		switch (currentLevel) {
		case LEVEL_TEST:
			testLevel.draw(
					batch, 
					testLevel.getGameObjectHandler().getTornado(),
					testLevel.getGameObjectHandler().getPlayer(),
					currentLevel
					);
			break;
		case LEVEL_FARM:
			farmLevel.draw(
					batch, 
					farmLevel.getGameObjectHandler().getTornado(),
					farmLevel.getGameObjectHandler().getPlayer(),
					currentLevel
					);
			break;
		case LEVEL_SPACE:
			spaceLevel.draw(
					batch, 
					spaceLevel.getGameObjectHandler().getTornado(),
					spaceLevel.getGameObjectHandler().getPlayer(),
					currentLevel
					);
			break;
		case LEVEL_BEACH:
			beachLevel.draw(
					batch, 
					beachLevel.getGameObjectHandler().getTornado(),
					beachLevel.getGameObjectHandler().getPlayer(),
					currentLevel
					);
			break;
		case LEVEL_ARCTIC:
			arcticLevel.draw(
					batch, 
					arcticLevel.getGameObjectHandler().getTornado(),
					arcticLevel.getGameObjectHandler().getPlayer(),
					currentLevel
					);
			break;
		case LEVEL_HELL:
			hellLevel.draw(
					batch, 
					hellLevel.getGameObjectHandler().getTornado(),
					hellLevel.getGameObjectHandler().getPlayer(),
					currentLevel
					);
			break;
		case LEVEL_CITY:
			cityLevel.draw(
					batch, 
					cityLevel.getGameObjectHandler().getTornado(),
					cityLevel.getGameObjectHandler().getPlayer(),
					currentLevel
					);
			break;
		case LEVEL_DESERT:
			desertLevel.draw(
					batch, 
					desertLevel.getGameObjectHandler().getTornado(),
					desertLevel.getGameObjectHandler().getPlayer(),
					currentLevel
					);
			break;
		case LEVEL_FORREST:
			forrestLevel.draw(
					batch, 
					forrestLevel.getGameObjectHandler().getTornado(),
					forrestLevel.getGameObjectHandler().getPlayer(),
					currentLevel
					);
			break;
		case LEVEL_TRACK:
			trackLevel.draw(
					batch, 
					trackLevel.getGameObjectHandler().getTornado(),
					trackLevel.getGameObjectHandler().getPlayer(),
					currentLevel
					);
			break;
		case LEVEL_END:
			endLevel.draw(
					batch, 
					endLevel.getGameObjectHandler().getTornado(),
					endLevel.getGameObjectHandler().getPlayer(),
					currentLevel
					);
			break;
		case LEVEL_DOUBLE:
			endLevel.draw(
					batch, 
					doubleLevel.getGameObjectHandler().getTornado(),
					doubleLevel.getGameObjectHandler().getPlayer(),
					currentLevel
					);
			break;
		}
	}

	public Level getCurrentLevel() {
		Level level = null;
		switch (currentLevel) {
		case LEVEL_TEST:
			level = testLevel;
			break;
		case LEVEL_FARM:
			level = farmLevel;
			break;
		case LEVEL_SPACE:
			level = spaceLevel;
			break;
		case LEVEL_BEACH:
			level = beachLevel;
			break;
		case LEVEL_ARCTIC:
			level = arcticLevel;
			break;
		case LEVEL_HELL:
			level = hellLevel;
			break;
		case LEVEL_CITY:
			level = cityLevel;
			break;
		case LEVEL_DESERT:
			level = desertLevel;
			break;
		case LEVEL_FORREST:
			level = forrestLevel;
			break;
		case LEVEL_TRACK:
			level = trackLevel;
			break;
		case LEVEL_END:
			level = endLevel;
			break;
		case LEVEL_DOUBLE:
			level = doubleLevel;
			break;
		}
		return level;
	}
}
