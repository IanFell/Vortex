package com.tornadogame.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.tornadogame.TornadoGame;
import com.tornadogame.ai.Ai;
import com.tornadogame.gameobjects.weapons.ShrapnelDrop;
import com.tornadogame.handlers.LevelHandler;
import com.tornadogame.handlers.PowerUpHandler;
import com.tornadogame.handlers.ShrapnelDropHandler;
import com.tornadogame.handlers.audio.SoundHandler;
import com.tornadogame.helpers.RandomNumberGenerator;
import com.tornadogame.input.InputParent;
import com.tornadogame.levels.Level;
import com.tornadogame.ui.Message;

public class Tornado extends GameObject {

	public static boolean hasWonFarmLevel  = false;
	public static boolean hasWonSpaceLevel = false;
	public static boolean hasWonBeachLevel = false;
	public static boolean hasWonArcticLevel = false;
	public static boolean hasWonHellLevel = false;
	public static boolean hasWonCityLevel = false;
	public static boolean hasWonDesertLevel = false;
	public static boolean hasWonForrestLevel = false;
	public static boolean hasWonTrackLevel = false;

	private boolean hasShrapnel;

	private final float MIN_WIDTH  = 200;
	private final float MIN_HEIGHT = 300;

	private final float MAX_WIDTH  = 500;
	private final float MAX_HEIGHT = 900;

	private boolean shouldSuck;

	private Rectangle shrapnelSuckBoundary;

	private boolean hasSuckBoost;

	private Ai ai;

	private int shrapnelTimer;

	/*
	private Texture[] suckAura = new Texture[4];
	private int suckAuraTimer;
	private Texture suckAuraTextureToLoad; */

	public Tornado(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
		shouldSuck           = false;
		shrapnelSuckBoundary = new Rectangle();
		hasSuckBoost         = false;

		loadTornadoTextures();

		textureToDraw = animationTexture[0];

		ai = new Ai(Ai.OBJECT_TORNADO);

		hasShrapnel = false;

		shrapnelTimer = 0;

		//loadSuckAuraTextures();
		//suckAuraTimer = 0;
	}

	/*
	private void loadSuckAuraTextures() {
		suckAura[0]           = new Texture("artwork/tornado/suckfx/TornadoSuckFX_01.png");
		suckAura[1]           = new Texture("artwork/tornado/suckfx/TornadoSuckFX_02.png");
		suckAura[2]           = new Texture("artwork/tornado/suckfx/TornadoSuckFX_03.png");
		suckAura[3]           = new Texture("artwork/tornado/suckfx/TornadoSuckFX_04.png");
		suckAuraTextureToLoad = suckAura[0];
	} */

	public void setHasShrapnel(boolean hasShrapnel) {
		this.hasShrapnel = hasShrapnel;
	}

	public boolean isHasShrapnel() {
		return hasShrapnel;
	}

	public void moveDown() {
		y -= dy;
	}

	@Override
	public void draw(SpriteBatch batch) {
		if (hasSuckBoost) {

			/*for (int i = 0; i < suckAura.length; i++) {
				batch.draw(suckAuraTextureToLoad, x, y - height / 2, width, height);
			}*/

			int randomColor = RandomNumberGenerator.generateRandomInteger(100);
			Color color = Color.RED;
			if (randomColor < 50) {
				color = Color.BLUE;
			}
			batch.setColor(color);
			batch.draw(textureToDraw, x, y, width, height);
			batch.setColor(Color.WHITE);
		} else {
			batch.draw(textureToDraw, x, y, width, height);
		}
		if (hasShrapnel && !hasSuckBoost) {
			shrapnelTimer++;
			//if (shrapnelTimer < 5) {
			Color color = getShrapnelColor();
			batch.setColor(color);
			batch.draw(textureToDraw, x, y, width, height);
			batch.setColor(Color.WHITE);
			//} 
			//if (shrapnelTimer > 10) {
			//	shrapnelTimer = 0;
			//}
		}
	}

	private Color getShrapnelColor() {
		Color color = Color.WHITE;
		switch (TornadoGame.levelToLoad) {
		case LevelHandler.LEVEL_FARM:
			color = Color.YELLOW;
			break;
		case LevelHandler.LEVEL_SPACE:
			color = Color.YELLOW;
			break;
		case LevelHandler.LEVEL_BEACH:
			color = Color.PINK;
			break;
		case LevelHandler.LEVEL_ARCTIC:
			color = Color.CYAN;
			break;
		case LevelHandler.LEVEL_HELL:
			color = Color.PINK;
			break;
		case LevelHandler.LEVEL_CITY:
			color = Color.RED;
			break;
		case LevelHandler.LEVEL_DESERT:
			color = Color.GREEN;
			break;
		case LevelHandler.LEVEL_FORREST:
			color = Color.RED;
			break;
		case LevelHandler.LEVEL_TRACK:
			color = Color.BLUE;
			break;
		case LevelHandler.LEVEL_END:
			color = Color.BLUE;
			break;
		}
		return color;
	}

	public void drawTornadoAsWinner(SpriteBatch batch, float x, float y, float width, float height) {
		batch.draw(textureToDraw, x, y, width, height);
	}

	public void update(Message message, Player player, PowerUpHandler powerUpHandler, Level level, OrthographicCamera camera, ShrapnelDropHandler shrapnelDropHandler) {
		if (!level.isLevelIsOver()) {
			grow();
			shrink();
			checkScreenTopBoundaryCollision();
			CheckScreenBottomBoundaryCollision();

			rectangle.x      = x;
			rectangle.y      = y;
			rectangle.width  = width;
			rectangle.height = height;

			handleShrapnelSuckBoundary();

			if (player.isHasSpeedBoost()) {
				if (x >= 0) {
					x -= 50;
				}
			}

			for (int i = 0; i < powerUpHandler.getSuckBoost().length; i++) {
				if (rectangle.overlaps(powerUpHandler.getSuckBoost()[i].getRectangle()) && !powerUpHandler.getSuckBoost()[i].isHasBeenCollected()) {
					hasSuckBoost = true;
					powerUpHandler.getSuckBoost()[i].setHasBeenCollected(true);
					SoundHandler.playSuckBoostAudioForPlayer = true;
				}
			}
			if (hasSuckBoost) {
				if (player.getX() > x && player.getX() + player.getWidth() < x + width) {
					shouldSuck = true;
				}
				//handleSuckAuraTimer();
			}
			checkPointBoost(message, powerUpHandler);

			if (TornadoGame.isAi || TornadoGame.tornadoHasAi) { 
				executeAi(camera, shrapnelDropHandler);
			}
		}
		handleAnimation();
	}

	/*
	private void handleSuckAuraTimer() {
		suckAuraTimer++;
		if (suckAuraTimer < 5) {
			suckAuraTextureToLoad = suckAura[0];
		}
		else if (suckAuraTimer >= 5 && suckAuraTimer < 10) {
			suckAuraTextureToLoad = suckAura[1];
		}
		else if (suckAuraTimer >= 10 && suckAuraTimer < 15) {
			suckAuraTextureToLoad = suckAura[2];
		}
		else if (suckAuraTimer >= 15 && suckAuraTimer < 20) {
			suckAuraTextureToLoad = suckAura[3];
		}
		else {
			suckAuraTimer = 0;
		}
	} */

	private void executeAi(OrthographicCamera camera, ShrapnelDropHandler shrapnelDropHandler) {
		if (ai.executeAi() == Ai.MOVE_RIGHT) {
			if (x + width < camera.viewportWidth) {
				moveRight();
				InputParent.keyHeld = true;
			}
		} else if (ai.executeAi() == Ai.MOVE_LEFT) {
			if (x > 0) {
				moveLeft();
				InputParent.keyHeld = false;
			}
		} else if (ai.executeAi() == Ai.MOVE_UP) {
			moveUp();
			InputParent.keyHeld = false;
		} else if (ai.executeAi() == Ai.MOVE_DOWN) {
			moveDown();
			InputParent.keyHeld = false;

			if (shrapnelDropHandler.getShrapnelDrop().size() > 0) {
				ShrapnelDrop.isDropped = true;
			}
		}
	}

	public boolean isHasSuckBoost() {
		return hasSuckBoost;
	}

	public void setHasSuckBoost(boolean hasSuckBoost) {
		this.hasSuckBoost = hasSuckBoost;
	}

	public Rectangle getShrapnelSuckBoundary() {
		return shrapnelSuckBoundary;
	}

	private void handleShrapnelSuckBoundary() {
		float mid                               = x  + width / 2;
		float shrapnelSuckBoundaryOffsetFromMid = width / 4;
		shrapnelSuckBoundary.x                  = mid - shrapnelSuckBoundaryOffsetFromMid;
		shrapnelSuckBoundary.y                  = y;
		shrapnelSuckBoundary.width              = shrapnelSuckBoundaryOffsetFromMid * 2;
		shrapnelSuckBoundary.height             = height;
	}

	private void CheckScreenBottomBoundaryCollision() {
		if (y < 0) {
			y = 1;
		}
	}

	public void grow() {
		if (InputParent.keyHeld) {
			if (width < MAX_WIDTH) {
				width += 20;
			}
			if (height < MAX_HEIGHT) {
				height += 30;
			}
		}
	}

	public void shrink() {
		if (!InputParent.keyHeld) {
			if (width > MIN_WIDTH) {
				width -= 20;
			}
			if (height > MIN_HEIGHT) {
				height -= 30;
			}
		}
	}

	public void setShouldSuck(boolean shouldSuck) {
		this.shouldSuck = shouldSuck;
	}

	public boolean isShouldSuck() {
		return shouldSuck;
	}

	public float getMAX_WIDTH() {
		return MAX_WIDTH;
	}

	public float getMAX_HEIGHT() {
		return MAX_HEIGHT;
	}

	public static void resetVariables() {
		hasWonFarmLevel    = false;
		hasWonSpaceLevel   = false;
		hasWonBeachLevel   = false;
		hasWonArcticLevel  = false;
		hasWonHellLevel    = false;
		hasWonCityLevel    = false;
		hasWonDesertLevel  = false;
		hasWonForrestLevel = false;
		hasWonTrackLevel   = false;
	}
}
