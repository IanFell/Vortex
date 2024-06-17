package com.tornadogame.obstacles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.gameobjects.powerups.PowerUp;
import com.tornadogame.handlers.LevelHandler;
import com.tornadogame.handlers.ShrapnelDropHandler;
import com.tornadogame.handlers.pointsanddamage.PointHandler;
import com.tornadogame.levels.Level;

public class Obstacle extends PowerUp {

	public static boolean playReactionAudio = false;

	public static boolean playShrapnelSuckAudio = false;

	private boolean hasCollidedWithPlayer;

	private boolean[] shrapnelHasBeenCaught = new boolean[8];

	private boolean playerHasCollectedPoint;

	public static Texture plus50;
	private boolean displayPassingPoints;
	private float passingPointsX;
	private float passingPointsY;
	private float passPointsSize;
	private final int PASSING_POINT_SPEED = 30;

	public Obstacle(float x, float y, float width, float height, Texture texture, float dx, float dy, int levelToLoad) {
		super(x, y, width, height, texture, dx, dy);
		hasCollidedWithPlayer = false;

		for (int i = 0; i < shrapnel.length; i++) {
			shrapnelHasBeenCaught[i] = false;
		}

		switch(levelToLoad) {
		case LevelHandler.LEVEL_TEST:
			shrapnelImage = new Texture("artwork/levels/testlevel/Bomb.png");
			break;
		case LevelHandler.LEVEL_FARM:
			shrapnelImage = new Texture("artwork/levels/farmlevel/Hay.png");
			break;
		case LevelHandler.LEVEL_SPACE:
			shrapnelImage = new Texture("artwork/levels/spacelevel/Hay.png");
			break;
		case LevelHandler.LEVEL_BEACH:
			shrapnelImage = new Texture("artwork/levels/beachlevel/Hay.png");
			break;
		case LevelHandler.LEVEL_ARCTIC:
			shrapnelImage = new Texture("artwork/levels/arcticlevel/Hay.png");
			break;
		case LevelHandler.LEVEL_HELL:
			shrapnelImage = new Texture("artwork/levels/helllevel/Hay.png");
			break;
		case LevelHandler.LEVEL_CITY:
			shrapnelImage = new Texture("artwork/levels/citylevel/Hay.png");
			break;
		case LevelHandler.LEVEL_DESERT:
			shrapnelImage = new Texture("artwork/levels/desertlevel/Hay.png");
			break;
		case LevelHandler.LEVEL_FORREST:
			shrapnelImage = new Texture("artwork/levels/forrestlevel/Hay.png");
			break;
		case LevelHandler.LEVEL_TRACK:
			shrapnelImage = new Texture("artwork/levels/tracklevel/Hay.png");
			break;
		case LevelHandler.LEVEL_END:
			shrapnelImage = new Texture("artwork/levels/tracklevel/Hay.png");
			break;
		case LevelHandler.LEVEL_DOUBLE:
			shrapnelImage = new Texture("artwork/levels/tracklevel/Hay.png");
			break;
		}
		playerHasCollectedPoint = false;

		plus50  = new Texture("artwork/ui/messages/Plus50.png");
		displayPassingPoints = false;
		passingPointsX = TornadoGame.screenWidth / 2 - 500;
		passingPointsY = TornadoGame.screenHeight / 4;
		passPointsSize = 400;
	}

	public boolean isHasCollidedWithPlayer() {
		return hasCollidedWithPlayer;
	}

	public void update(Tornado tornado, Player player, ShrapnelDropHandler shrapnelDropHandler, Level level) {
		if (!hasCollidedWithPlayer) {
			x += dx;
			rectangle.x = x;
			rectangle.y = y;

			for (int i = 0; i < shrapnel.length; i++) {
				shrapnel[i].x = x;
				shrapnel[i].y = y;
			}

			if (!level.isLevelIsOver()) {
				if (x + width < 0 && !playerHasCollectedPoint) {
					player.setPoints(player.getPoints() + PointHandler.POINT_VALUE_OBSTACLE_JUMP);
					playerHasCollectedPoint = true;
					playReactionAudio = true;
					displayPassingPoints = true;
				}
			}
		} else {
			for (int i = 0; i < shrapnel.length; i++) {
				if (!shrapnelHasBeenCaught[i]) {
					shrapnel[i].x += shrapnelDx[i];
					shrapnel[i].y += shrapnelDy[i];

					if (shrapnelDx[i] > 0) {
						shrapnelDx[i] -= 2;
					}

					shrapnelDy[i] -= 10;

					if (
							shrapnel[i].getX() > tornado.getShrapnelSuckBoundary().getX() && 
							shrapnel[i].getX() + shrapnel[i].getWidth() < tornado.getShrapnelSuckBoundary().getX() + tornado.getShrapnelSuckBoundary().getWidth() &&
							shrapnel[i].getY() > 0
							) {
						shrapnelHasBeenCaught[i] = true;
						tornado.setPoints(tornado.getPoints() + 5);
						if (shrapnelDropHandler.getShrapnelDrop().size() < 1) {
							shrapnelDropHandler.addShrapnelDropsToTornado(tornado);
						}

						playShrapnelSuckAudio = true;
					}
				} else {
					shrapnelDy[i] += 25;
					shrapnel[i].y += shrapnelDy[i];
				}
			}
		}
		if (displayPassingPoints) {
			passingPointsY += PASSING_POINT_SPEED;

			if (passingPointsY > TornadoGame.screenHeight - (TornadoGame.screenHeight / 2)) {
				passingPointsY = TornadoGame.screenHeight / 4;
				displayPassingPoints = false;
			}
		}
	}

	public void draw(SpriteBatch batch, Tornado tornado) {
		if (!hasCollidedWithPlayer) {
			batch.draw(texture, x, y, width, height);
			if (displayPassingPoints) {
				batch.draw(plus50, passingPointsX, passingPointsY, passPointsSize, passPointsSize);
			}
		} else {
			for (int i = 0; i < shrapnel.length; i++) {
				if (shrapnel[i].getY() < tornado.getY()) {
					batch.draw(shrapnelImage, shrapnel[i].x, shrapnel[i].y, shrapnel[i].width, shrapnel[i].height);
				}
			}
		}
	}

	public void setHasCollidedWithPlayer(boolean hasCollidedWithPlayer) {
		this.hasCollidedWithPlayer = hasCollidedWithPlayer;
	}

	public static void dispose() {
		plus50.dispose();
	}
}
