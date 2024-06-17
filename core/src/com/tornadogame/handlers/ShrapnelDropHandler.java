package com.tornadogame.handlers;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.gameobjects.weapons.ShrapnelDrop;
import com.tornadogame.levels.Level;

public class ShrapnelDropHandler {

	public static boolean playAudio = false;

	private ArrayList <ShrapnelDrop> shrapnelDrop = new ArrayList<ShrapnelDrop>();

	public static Texture shrapnelDropTexture;

	private float fallingDy = -50;

	public ShrapnelDropHandler(Tornado tornado, int levelToLoad) {
		switch(levelToLoad) {
		case LevelHandler.LEVEL_TEST:
			shrapnelDropTexture = new Texture("artwork/levels/testlevel/Bomb.png");
			break;
		case LevelHandler.LEVEL_FARM:
			shrapnelDropTexture = new Texture("artwork/levels/farmlevel/Hay.png");
			break;
		case LevelHandler.LEVEL_SPACE:
			shrapnelDropTexture = new Texture("artwork/levels/spacelevel/Hay.png");
			break;
		case LevelHandler.LEVEL_BEACH:
			shrapnelDropTexture = new Texture("artwork/levels/beachlevel/Hay.png");
			break;
		case LevelHandler.LEVEL_ARCTIC:
			shrapnelDropTexture = new Texture("artwork/levels/arcticlevel/Hay.png");
			break;
		case LevelHandler.LEVEL_HELL:
			shrapnelDropTexture = new Texture("artwork/levels/helllevel/Hay.png");
			break;
		case LevelHandler.LEVEL_CITY:
			shrapnelDropTexture = new Texture("artwork/levels/citylevel/Hay.png");
			break;
		case LevelHandler.LEVEL_DESERT:
			shrapnelDropTexture = new Texture("artwork/levels/desertlevel/Hay.png");
			break;
		case LevelHandler.LEVEL_FORREST:
			shrapnelDropTexture = new Texture("artwork/levels/forrestlevel/Hay.png");
			break;
		case LevelHandler.LEVEL_TRACK:
			shrapnelDropTexture = new Texture("artwork/levels/tracklevel/Hay.png");
			break;
		case LevelHandler.LEVEL_END:
			shrapnelDropTexture = new Texture("artwork/levels/tracklevel/Hay.png");
			break;
		case LevelHandler.LEVEL_DOUBLE:
			shrapnelDropTexture = new Texture("artwork/levels/tracklevel/Hay.png");
			break;
		}
		//loadTestLevel();
	}

	private void loadTestLevel() {}

	public void update(Tornado tornado) {
		for (int i = 0; i < shrapnelDrop.size(); i++) {
			shrapnelDrop.get(i).update(tornado);
			if (ShrapnelDrop.isDropped) {
				shrapnelDrop.get(i).setDy(shrapnelDrop.get(i).getDy() - 2);
				if (shrapnelDrop.get(i).getY() < 0) {
					shrapnelDrop.clear();
					ShrapnelDrop.isDropped = false;
				}
			}
		}
	}

	public void draw(SpriteBatch batch, Level level) {
		for (int i = 0; i < shrapnelDrop.size(); i++) {
			if (!level.isLevelIsOver()) {
				shrapnelDrop.get(i).draw(batch);
			}
		}
	}

	public ArrayList<ShrapnelDrop> getShrapnelDrop() {
		return shrapnelDrop;
	}

	public void addShrapnelDropsToTornado(Tornado tornado) {
		shrapnelDrop.add(new ShrapnelDrop(tornado.getX(), tornado.getY() + tornado.getHeight(), 100, 100, shrapnelDropTexture, 0, fallingDy));
		shrapnelDrop.add(new ShrapnelDrop(tornado.getX(), tornado.getY() + tornado.getHeight(), 100, 100, shrapnelDropTexture, 0, fallingDy));
		shrapnelDrop.add(new ShrapnelDrop(tornado.getX(), tornado.getY() + tornado.getHeight(), 100, 100, shrapnelDropTexture, 0, fallingDy));

		// Reset DX value so it's random.
		for (int i = 0; i < shrapnelDrop.size(); i++) {
			Random random  = new Random();
			float randomDx = random.nextInt(100);
			shrapnelDrop.get(i).setDx(randomDx);
		}
	}
	
	public static void dispose() {
		shrapnelDropTexture.dispose();
	}
}
