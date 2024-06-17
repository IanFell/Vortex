package com.tornadogame.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.ai.Ai;
import com.tornadogame.gameobjects.powerups.SpeedBoost;
import com.tornadogame.gameobjects.weapons.ShrapnelDrop;
import com.tornadogame.handlers.LevelHandler;
import com.tornadogame.handlers.PowerUpHandler;
import com.tornadogame.handlers.ShrapnelDropHandler;
import com.tornadogame.handlers.audio.SoundHandler;
import com.tornadogame.handlers.pointsanddamage.PointHandler;
import com.tornadogame.helpers.RandomNumberGenerator;
import com.tornadogame.levels.Level;
import com.tornadogame.ui.Message;

public class Player extends GameObject {

	public static boolean hasWonFarmLevel  = false;
	public static boolean hasWonSpaceLevel = false;
	public static boolean hasWonBeachLevel = false;
	public static boolean hasWonArcticLevel = false;
	public static boolean hasWonHellLevel = false;
	public static boolean hasWonCityLevel = false;
	public static boolean hasWonDesertLevel = false;
	public static boolean hasWonForrestLevel = false;
	public static boolean hasWonTrackLevel = false;

	private boolean isJumping;
	private boolean canJump;

	private boolean isDead;

	private int deathTimer;

	private int lives;

	private boolean hasBeenHitByObstacle;

	private int stunTimer;

	private boolean isStunned;

	private boolean hasSpeedBoost; 
	// Use this to control scrolling of background objects that can't take a player object in their update method.
	public static boolean isBoosting = false;

	private final int WINNER_MAX_SIZE = 1000;

	private final int DEATH_TIME = 50;

	private final int STUN_DURATION = 50;

	private Ai ai;

	private boolean playJumpAudio;

	private int speedBoostFlashTimer;
	private final int SPEED_BOOST_FLASH_INCREMENT = 10;

	private boolean isGettingSuckedUp;

	/*
	private Texture[] fireTrail = new Texture[4];
	private int fireTrailTimer;
	private int fireTrailIncrement;
	private float fireTrailWidth; */

	public Player(float x, float y, float width, float height, Texture texture, float dx, float dy, int level) {
		super(x, y, width, height, texture, dx, dy);
		isJumping            = false;
		canJump              = true;
		isDead               = false;
		deathTimer           = 0;
		lives                = 3;
		hasBeenHitByObstacle = false;
		stunTimer            = 0;
		isStunned            = false;
		hasSpeedBoost        = false;
		ai                   = new Ai(Ai.OBJECT_PLAYER);

		loadPlayerTextures(level);
		textureToDraw = animationTexture[0];

		playJumpAudio = false;

		speedBoostFlashTimer = 0;

		isGettingSuckedUp = false;

		/*
		loadFireTrailTextures();
		fireTrailTimer     = 0;
		fireTrailIncrement = 0;
		fireTrailWidth     = 0; */
	}

	/*
	private void loadFireTrailTextures() {
		fireTrail[0] = new Texture("artwork/player/firetrail/01.png");
		fireTrail[1] = new Texture("artwork/player/firetrail/02.png");
		fireTrail[2] = new Texture("artwork/player/firetrail/03.png");
		fireTrail[3] = new Texture("artwork/player/firetrail/04.png");
	} */

	public boolean isPlayJumpAudio() {
		return playJumpAudio;
	}

	public void setPlayJumpAudio(boolean playJumpAudio) {
		this.playJumpAudio = playJumpAudio;
	}

	private void loadPlayerTextures(int level) {
		animationTexture[0] = new Texture("artwork/player/body/01.png");
		animationTexture[1] = new Texture("artwork/player/body/02.png");
		animationTexture[2] = new Texture("artwork/player/body/03.png");
		animationTexture[3] = new Texture("artwork/player/body/02.png");
		animationTexture[4] = new Texture("artwork/player/body/03.png");
		animationTexture[5] = new Texture("artwork/player/body/02.png");

		switch (level) {
		case LevelHandler.LEVEL_FARM:
			animationTexture[0] = new Texture("artwork/player/body/farmer/01_Farmer.png");
			animationTexture[1] = new Texture("artwork/player/body/farmer/02_Farmer.png");
			animationTexture[2] = new Texture("artwork/player/body/farmer/03_Farmer.png");
			animationTexture[3] = new Texture("artwork/player/body/farmer/02_Farmer.png");
			animationTexture[4] = new Texture("artwork/player/body/farmer/03_Farmer.png");
			animationTexture[5] = new Texture("artwork/player/body/farmer/02_Farmer.png");
			break;
		case LevelHandler.LEVEL_SPACE:
			animationTexture[0] = new Texture("artwork/player/body/astronaut/01_Astronaut.png");
			animationTexture[1] = new Texture("artwork/player/body/astronaut/02_Astronaut.png");
			animationTexture[2] = new Texture("artwork/player/body/astronaut/03_Astronaut.png");
			animationTexture[3] = new Texture("artwork/player/body/astronaut/02_Astronaut.png");
			animationTexture[4] = new Texture("artwork/player/body/astronaut/03_Astronaut.png");
			animationTexture[5] = new Texture("artwork/player/body/astronaut/02_Astronaut.png");
			break;
		case LevelHandler.LEVEL_BEACH:
			animationTexture[0] = new Texture("artwork/player/body/beach/01_Beach.png");
			animationTexture[1] = new Texture("artwork/player/body/beach/02_Beach.png");
			animationTexture[2] = new Texture("artwork/player/body/beach/03_Beach.png");
			animationTexture[3] = new Texture("artwork/player/body/beach/02_Beach.png");
			animationTexture[4] = new Texture("artwork/player/body/beach/03_Beach.png");
			animationTexture[5] = new Texture("artwork/player/body/beach/02_Beach.png");
			break;
		case LevelHandler.LEVEL_ARCTIC:
			animationTexture[0] = new Texture("artwork/player/body/arctic/01.png");
			animationTexture[1] = new Texture("artwork/player/body/arctic/02.png");
			animationTexture[2] = new Texture("artwork/player/body/arctic/03.png");
			animationTexture[3] = new Texture("artwork/player/body/arctic/02.png");
			animationTexture[4] = new Texture("artwork/player/body/arctic/03.png");
			animationTexture[5] = new Texture("artwork/player/body/arctic/02.png");
			break;
		case LevelHandler.LEVEL_HELL:
			animationTexture[0] = new Texture("artwork/player/body/Hell/01.png");
			animationTexture[1] = new Texture("artwork/player/body/Hell/02.png");
			animationTexture[2] = new Texture("artwork/player/body/Hell/03.png");
			animationTexture[3] = new Texture("artwork/player/body/Hell/02.png");
			animationTexture[4] = new Texture("artwork/player/body/Hell/03.png");
			animationTexture[5] = new Texture("artwork/player/body/Hell/02.png");
			break;
		case LevelHandler.LEVEL_CITY:
			animationTexture[0] = new Texture("artwork/player/body/city/01.png");
			animationTexture[1] = new Texture("artwork/player/body/city/02.png");
			animationTexture[2] = new Texture("artwork/player/body/city/03.png");
			animationTexture[3] = new Texture("artwork/player/body/city/02.png");
			animationTexture[4] = new Texture("artwork/player/body/city/03.png");
			animationTexture[5] = new Texture("artwork/player/body/city/02.png");
			break;
		case LevelHandler.LEVEL_DESERT:
			animationTexture[0] = new Texture("artwork/player/body/beach/01_Beach.png");
			animationTexture[1] = new Texture("artwork/player/body/beach/02_Beach.png");
			animationTexture[2] = new Texture("artwork/player/body/beach/03_Beach.png");
			animationTexture[3] = new Texture("artwork/player/body/beach/02_Beach.png");
			animationTexture[4] = new Texture("artwork/player/body/beach/03_Beach.png");
			animationTexture[5] = new Texture("artwork/player/body/beach/02_Beach.png");
			break;
		case LevelHandler.LEVEL_FORREST:
			animationTexture[0] = new Texture("artwork/player/body/forrest/01.png");
			animationTexture[1] = new Texture("artwork/player/body/forrest/02.png");
			animationTexture[2] = new Texture("artwork/player/body/forrest/03.png");
			animationTexture[3] = new Texture("artwork/player/body/forrest/02.png");
			animationTexture[4] = new Texture("artwork/player/body/forrest/03.png");
			animationTexture[5] = new Texture("artwork/player/body/forrest/02.png");
			break;
		case LevelHandler.LEVEL_TRACK:
			animationTexture[0] = new Texture("artwork/player/body/beach/01_Beach.png");
			animationTexture[1] = new Texture("artwork/player/body/beach/02_Beach.png");
			animationTexture[2] = new Texture("artwork/player/body/beach/03_Beach.png");
			animationTexture[3] = new Texture("artwork/player/body/beach/02_Beach.png");
			animationTexture[4] = new Texture("artwork/player/body/beach/03_Beach.png");
			animationTexture[5] = new Texture("artwork/player/body/beach/02_Beach.png");
			break;
		}
	}

	public void update(Message message, TornadoGame tornadoGame, Tornado tornado, PowerUpHandler powerUpHandler, ShrapnelDropHandler shrapnelDropHandler, OrthographicCamera camera, Level level) {
		if (!level.isLevelIsOver()) {
			y += dy;
			checkScreenTopBoundaryCollision();
			if (!tornado.isShouldSuck()) {
				handleJumping();
				if (hasBeenHitByObstacle) {
					stun();
				} else {
					dx = 50;
				}
			} else {
				if (y < tornado.getY()) {
					getSuckedUp(tornado);
				}
			}

			rectangle.x = x;
			rectangle.y = y;

			resetPlayerIfDead(tornado);

			for (int i = 0; i < shrapnelDropHandler.getShrapnelDrop().size(); i++) {
				if (!isStunned && shrapnelDropHandler.getShrapnelDrop().get(i).getY() < tornado.getY()) {
					if (rectangle.overlaps(shrapnelDropHandler.getShrapnelDrop().get(i).getRectangle())) {
						tornado.setPoints(tornado.getPoints() + PointHandler.POINT_VALUE_SHRAPNEL_DROP);
						ShrapnelDrop.isDropped = false;
						tornadoGame.setScreenShouldShake(true);
						message.setShouldDisplayMessage(true, Message.MESSAGE_OUCH, x, y);
						ShrapnelDropHandler.playAudio = true;
					}
				}
			}

			for (int i = 0; i < powerUpHandler.getSpeedBoost().length; i++) {
				if (rectangle.overlaps(powerUpHandler.getSpeedBoost()[i].getRectangle()) && !isStunned) {
					hasSpeedBoost = true;
					powerUpHandler.getSpeedBoost()[i].setHasBeenCollected(true);
					message.setShouldDisplayMessage(true, Message.MESSAGE_SPEED, x, y);
					SpeedBoost.playAudio = true;
				}
			}

			if (!isStunned) {
				checkPointBoost(message, powerUpHandler);
			}

			if (tornado.isShouldSuck()) {
				if (rectangle.overlaps(tornado.getRectangle())) {
					isDead = true;
					tornado.setPoints(tornado.getPoints() + PointHandler.POINT_VALUE_SUCK);
					message.setShouldDisplayMessage(true, Message.MESSAGE_SUCK, tornado.getX() - tornado.getWidth() / 2, tornado.getY() + tornado.getHeight());
				}
			}

			if (TornadoGame.isAi || TornadoGame.playerHasAi) { 
				executeAi(camera);
			}

			if (hasSpeedBoost) {
				isBoosting = true;
				handleSpeedBoostFlashTimer();
			} else {
				isBoosting = false;
			}

			//handleFireTrail();
		}
		handleAnimation();

		if (tornado.isHasSuckBoost()) {
			isGettingSuckedUp = true;
		} else {
			isGettingSuckedUp = false;
		}
	}

	/*
	private void handleFireTrail() {
		fireTrailTimer++;
		if (fireTrailTimer % 5 == 0) {
			fireTrailIncrement++;
		}
		if (fireTrailIncrement > 3) {
			fireTrailIncrement = 0;
		}

		fireTrailWidth += 5;
		if (fireTrailWidth > 500) {
			fireTrailWidth = 0;
		}
	} */

	private void executeAi(OrthographicCamera camera) {
		if (ai.executeAi() == Ai.JUMP) {
			if (canJump && !isStunned()) {
				setJumping(true);
			}
		} else if (ai.executeAi() == Ai.MOVE_RIGHT) {
			if (x + width < camera.viewportWidth) {
				moveRight();
			}
		} else if (ai.executeAi() == Ai.MOVE_LEFT) {
			if (x > 0) {
				moveLeft();
			}
		}
	}

	public int getWINNER_MAX_SIZE() {
		return WINNER_MAX_SIZE;
	}

	private void stun() {
		isStunned = true;
		dx        = 0;
		dy        = 0;
		stunTimer++;
		if (stunTimer > STUN_DURATION) {
			stunTimer = 0;
			hasBeenHitByObstacle = false;
			isStunned = false;
		}
	}

	@Override
	public void moveLeft() {
		x -= dx * 2.5f;
	}

	public void draw(SpriteBatch batch, int level, Level loadedLevel) {
		if (!isDead) {
			//batch.draw(fireTrail[fireTrailIncrement], -x, y, fireTrailWidth, 200);
			if (isStunned) {
				batch.setColor(Color.BLACK);
				batch.draw(textureToDraw, x, y, width, height);
				batch.setColor(Color.WHITE);
			} 
			else if (isGettingSuckedUp) {
				int randomColor = RandomNumberGenerator.generateRandomInteger(100);
				Color color = Color.RED;
				if (randomColor < 50) {
					color = Color.BLUE;
				}
				batch.setColor(color);
				batch.draw(textureToDraw, x, y, width, height);
				batch.setColor(Color.WHITE);
			}
			else {
				if (hasSpeedBoost) {
					//batch.draw(fireTrail[fireTrailIncrement], x - 350, y, fireTrailWidth, 200);
					if (speedBoostFlashTimer < SPEED_BOOST_FLASH_INCREMENT / 2) {
						batch.setColor(Color.YELLOW);
						batch.draw(textureToDraw, x, y, width, height);
						batch.setColor(Color.WHITE);
					} 
					else if (speedBoostFlashTimer >= SPEED_BOOST_FLASH_INCREMENT / 2 && speedBoostFlashTimer < SPEED_BOOST_FLASH_INCREMENT - SPEED_BOOST_FLASH_INCREMENT / 4) {
						batch.setColor(Color.ORANGE);
						batch.draw(textureToDraw, x, y, width, height);
						batch.setColor(Color.WHITE);
					}
					else {
						batch.setColor(Color.WHITE);
						batch.draw(textureToDraw, x, y, width, height);
					}
				} else {
					batch.setColor(Color.WHITE);
					batch.draw(textureToDraw, x, y, width, height);
				}
				drawHead(batch, loadedLevel);
			}
		}
	}

	private void handleSpeedBoostFlashTimer() {
		if (hasSpeedBoost) {
			speedBoostFlashTimer++;
			if (speedBoostFlashTimer > SPEED_BOOST_FLASH_INCREMENT) {
				speedBoostFlashTimer = 0;
			}
		}
	}

	private void drawHead(SpriteBatch batch, Level loadedLevel) {
		Texture headTexture = loadedLevel.getHeadTexture()[1];
		if (animationTimer < ANIMATION_TIMER_MAX) {
			if (animationTimer < 5) {
				headTexture = loadedLevel.getHeadTexture()[0];
			}
			else if (animationTimer >= 5 && animationTimer < 10) {
				headTexture = loadedLevel.getHeadTexture()[1];
			}
			else if (animationTimer >= 10 && animationTimer < 15) {
				headTexture = loadedLevel.getHeadTexture()[2];
			}
			else if (animationTimer >= 15 && animationTimer < 20) {
				headTexture = loadedLevel.getHeadTexture()[1];
			}
			else if (animationTimer >= 20 && animationTimer < 25) {
				headTexture = loadedLevel.getHeadTexture()[0];
			}
			else if (animationTimer >= 25 && animationTimer < 30) {
				headTexture = loadedLevel.getHeadTexture()[1];
			}
		}
		if (hasSpeedBoost) {
			if (speedBoostFlashTimer < SPEED_BOOST_FLASH_INCREMENT / 2) {
				batch.setColor(Color.GRAY);
				batch.draw(headTexture, x, y, width, height);
				batch.setColor(Color.WHITE);
			} else {
				batch.setColor(Color.WHITE);
				batch.draw(headTexture, x, y, width, height);
			}
		} 
		else if (isGettingSuckedUp) {
			int randomColor = RandomNumberGenerator.generateRandomInteger(100);
			Color color = Color.RED;
			if (randomColor < 50) {
				color = Color.BLUE;
			}
			batch.setColor(color);
			batch.draw(headTexture, x, y, width, height);
			batch.setColor(Color.WHITE);
		}
		else {
			batch.setColor(Color.WHITE);
			batch.draw(headTexture, x, y, width, height);
		}
	}

	public boolean isHasSpeedBoost() {
		return hasSpeedBoost;
	}

	public void setHasSpeedBoost(boolean hasSpeedBoost) {
		this.hasSpeedBoost = hasSpeedBoost;
	}

	private void resetPlayerIfDead(Tornado tornado) {
		if (isDead) {
			deathTimer++;
			if (deathTimer > DEATH_TIME) {
				isDead = false;
				x = 0;
				y = TornadoGame.screenHeight;
				deathTimer = 0;
				tornado.setShouldSuck(false);
				lives--;

				if (tornado.getX() > TornadoGame.screenWidth / 2) {
					x = 0;
				} else {
					x = TornadoGame.screenWidth - width;
				}
				SoundHandler.playMaggieFallingDownAudioAfterGettingReleasedFromSuckUp = true;
			}
		}
	}

	private void getSuckedUp(Tornado tornado) {
		if (y < tornado.getY()) {
			dy = 100;
		}
	}

	private void handleJumping() {
		if (isJumping) {
			playJumpAudio = true;
			canJump = false;
			dy += 50;

			if (dy > 100) {
				isJumping = false;
			}
		} else {
			if (dy > -100) {
				dy -= 20;
			}
		}
	}

	public void setJumping(boolean isJumping) {
		this.isJumping = isJumping;
	}

	public boolean isJumping() {
		return isJumping;
	}

	public boolean isCanJump() {
		return canJump;
	}

	public void setCanJump(boolean canJump) {
		this.canJump = canJump;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public int getLives() {
		return lives;
	}

	public void setHasBeenHitByObstacle(boolean hasBeenHitByObstacle) {
		this.hasBeenHitByObstacle = hasBeenHitByObstacle;
	}

	public void setStunned(boolean isStunned) {
		this.isStunned = isStunned;
	}

	public boolean isStunned() {
		return isStunned;
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
		isBoosting         = false;
	}
}
