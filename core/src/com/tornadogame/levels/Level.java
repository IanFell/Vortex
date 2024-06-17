package com.tornadogame.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.backgrounds.Background;
import com.tornadogame.cutscenes.Cutscene;
import com.tornadogame.foreground.Cloud;
import com.tornadogame.foreground.Fire;
import com.tornadogame.foreground.Rain;
import com.tornadogame.foreground.Snow;
import com.tornadogame.foreground.Wind;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.handlers.BackgroundHandler;
import com.tornadogame.handlers.DebreeHandler;
import com.tornadogame.handlers.GameObjectHandler;
import com.tornadogame.handlers.LevelHandler;
import com.tornadogame.handlers.ObstacleHandler;
import com.tornadogame.handlers.PlatformHandler;
import com.tornadogame.handlers.PowerUpHandler;
import com.tornadogame.handlers.ShrapnelDropHandler;
import com.tornadogame.handlers.WinnerHandler;
import com.tornadogame.handlers.audio.SoundHandler;
import com.tornadogame.handlers.pointsanddamage.PointHandler;
import com.tornadogame.helpers.RandomNumberGenerator;
import com.tornadogame.ui.Countdown;
import com.tornadogame.ui.Message;
import com.tornadogame.ui.UserInterface;

public class Level {

	private Countdown countdown;

	private final int COUNTDOWN_TIMER_BEGIN_VALUE = 15000;

	private boolean showCountdown;

	protected boolean playEndLevelAudio;

	protected static Texture loadingScreen;

	public static final int WINNER_TORNADO  = 0;
	public static final int WINNER_PLAYER   = 1;
	private final int WINNER_NOT_DETERMINED = 3;

	private final int WINNING_SCREEN_DURATION = 200;

	protected int winner;

	private int winningScreenTimer;
	private boolean winningScreenHasConcluded;

	protected boolean levelIsOver;
	private float endOfLevel;

	protected UserInterface userInterface;

	protected GameObjectHandler gameObjectHandler;
	protected BackgroundHandler backgroundHandler;
	protected DebreeHandler debreeHandler;
	protected ShrapnelDropHandler shrapnelDropHandler;
	protected PowerUpHandler powerUpHandler;
	protected PlatformHandler platformHandler;
	private ObstacleHandler obstacleHandler;

	private float transparencyAlpha;
	private float transparencyAlphaIncrement;

	protected static Texture goTexture;
	private int goTextureSize;
	private int goTextureTimer;
	private final int GO_TEXTURE_MAX = 50;

	protected Cutscene cutscene;

	protected float backgroundObjectDx;

	protected static Texture[] headTexture = new Texture[3];

	protected static Rain[] rain   = new Rain[500];
	protected static Wind[] wind   = new Wind[25];
	protected static Snow[] snow   = new Snow[500];
	protected static Fire[] fire   = new Fire[500];
	protected static Cloud[] cloud = new Cloud[4];

	// Audio variables for level.
	private boolean hasPlayedSiren;

	protected boolean loadingScreenShouldRender;

	public Level(OrthographicCamera camera, int levelToLoad, float endOfLevel) {

		int countdownSize = 400;
		countdown = new Countdown(
				TornadoGame.screenWidth / 2 - countdownSize / 2, 
				TornadoGame.screenHeight - countdownSize, 
				countdownSize, 
				countdownSize,
				new Texture("artwork/ui/numbers/NUM_05.png"),
				0,
				0
				);

		userInterface  = new UserInterface(camera);

		showCountdown = false;

		gameObjectHandler   = new GameObjectHandler(levelToLoad);
		backgroundHandler   = new BackgroundHandler(levelToLoad);
		platformHandler     = new PlatformHandler(camera, levelToLoad);
		debreeHandler       = new DebreeHandler();
		shrapnelDropHandler = new ShrapnelDropHandler(gameObjectHandler.getTornado(), levelToLoad);
		powerUpHandler      = new PowerUpHandler(platformHandler, levelToLoad);
		obstacleHandler     = new ObstacleHandler(platformHandler, levelToLoad);

		winner                    = WINNER_NOT_DETERMINED;
		levelIsOver               = false;
		winningScreenTimer        = 0;
		winningScreenHasConcluded = false;
		this.endOfLevel           = endOfLevel;

		transparencyAlpha          = 0;
		transparencyAlphaIncrement = 0.01f;

		goTexture      = new Texture("artwork/ui/messages/Go.png");
		goTextureSize  = 1000;
		goTextureTimer = 0;

		backgroundObjectDx = Background.SCROLL_SPEED_MID_LAYER_01;

		for (int i = 0; i < cloud.length; i++) {
			cloud[i] = new Cloud(
					0,
					(float) RandomNumberGenerator.generateRandomDouble(TornadoGame.screenHeight / 2, TornadoGame.screenHeight - (int)TornadoGame.screenHeight / 5),
					(float) RandomNumberGenerator.generateRandomDouble(TornadoGame.screenWidth / 10, TornadoGame.screenWidth / 3),
					(float) RandomNumberGenerator.generateRandomDouble(TornadoGame.screenHeight / 10, TornadoGame.screenHeight / 5),
					new Texture("artwork/levels/Cloud.png"),
					(float) RandomNumberGenerator.generateRandomDouble(50, 100),
					0
					);
		}

		for (int i = 0; i < rain.length; i++) {
			rain[i] = new Rain(
					RandomNumberGenerator.generateRandomInteger((int) TornadoGame.screenWidth),
					(float) RandomNumberGenerator.generateRandomDouble(TornadoGame.screenWidth, TornadoGame.screenWidth + TornadoGame.screenWidth * 2),
					RandomNumberGenerator.generateRandomInteger(7),
					RandomNumberGenerator.generateRandomInteger(100),
					new Texture("artwork/ui/meters/Rain.png"),
					(float) RandomNumberGenerator.generateRandomDouble(10, 50),
					(float) RandomNumberGenerator.generateRandomDouble(50, 100)
					);
		}

		for (int i = 0; i < wind.length; i++) {
			wind[i] = new Wind(
					RandomNumberGenerator.generateRandomInteger((int) TornadoGame.screenWidth),
					(float) RandomNumberGenerator.generateRandomDouble(TornadoGame.screenWidth, TornadoGame.screenWidth + TornadoGame.screenWidth * 2),
					500,
					10,
					new Texture("artwork/ui/meters/Rain.png"),
					(float) RandomNumberGenerator.generateRandomDouble(30, 100),
					0
					);
		}

		for (int i = 0; i < snow.length; i++) {
			snow[i] = new Snow(
					RandomNumberGenerator.generateRandomInteger((int) TornadoGame.screenWidth),
					(float) RandomNumberGenerator.generateRandomDouble(TornadoGame.screenWidth, TornadoGame.screenWidth + TornadoGame.screenWidth * 2),
					RandomNumberGenerator.generateRandomInteger(20),
					RandomNumberGenerator.generateRandomInteger(20),
					new Texture("WhiteSquare.png"),
					(float) RandomNumberGenerator.generateRandomDouble(10, 100),
					(float) RandomNumberGenerator.generateRandomDouble(50, 100)
					);
		}

		for (int i = 0; i < fire.length; i++) {
			fire[i] = new Fire(
					RandomNumberGenerator.generateRandomInteger((int) TornadoGame.screenWidth),
					(float) RandomNumberGenerator.generateRandomDouble(TornadoGame.screenWidth, TornadoGame.screenWidth + TornadoGame.screenWidth * 2),
					RandomNumberGenerator.generateRandomInteger(20),
					RandomNumberGenerator.generateRandomInteger(20),
					new Texture("YellowSquare.png"),
					(float) RandomNumberGenerator.generateRandomDouble(10, 100),
					(float) RandomNumberGenerator.generateRandomDouble(50, 100)
					);
		}

		hasPlayedSiren = false;

		loadingScreen = new Texture(Gdx.files.internal("artwork/cutscenes/LoadingScreen.png"));
		loadingScreenShouldRender = false;

		playEndLevelAudio = false;

		SoundHandler.gettingSuckedAudioToPlay = 0;
	}

	public boolean isPlayEndLevelAudio() {
		return playEndLevelAudio;
	}

	public void setPlayEndLevelAudio(boolean playEndLevelAudio) {
		this.playEndLevelAudio = playEndLevelAudio;
	}

	public PowerUpHandler getPowerUpHandler() {
		return powerUpHandler;
	}

	public boolean isHasPlayedSiren() {
		return hasPlayedSiren;
	}

	public void setHasPlayedSiren(boolean hasPlayedSiren) {
		this.hasPlayedSiren = hasPlayedSiren;
	}

	private void checkCountdown() {
		if (endOfLevel < COUNTDOWN_TIMER_BEGIN_VALUE) {
			showCountdown = true;
		}
	}

	/**
	 * At end of level, scrolling will slow to a halt.
	 */
	protected void checkEndOfLevel() {
		endOfLevel += Background.SCROLL_SPEED_FRONT_LAYER;
		if (endOfLevel < 0) {
			levelIsOver = true;
		}
	}

	public Texture[] getHeadTexture() {
		return headTexture;
	}

	public float getEndOfLevel() {
		return endOfLevel;
	}

	public Cutscene getCutscene() {
		return cutscene;
	}

	public void update(LevelHandler levelHandler, OrthographicCamera camera, TornadoGame tornadoGame) {
		camera.update();

		if (cutscene.isCutsceneComplete()) {
			if (transparencyAlpha >= 1) {
				Player player = gameObjectHandler.getPlayer();
				Tornado tornado = gameObjectHandler.getTornado();
				gameObjectHandler.update(userInterface.getMessage(), tornadoGame, powerUpHandler, this, shrapnelDropHandler, camera);
				backgroundHandler.update(player, this);
				platformHandler.update(player, this);
				debreeHandler.update();
				shrapnelDropHandler.update(tornado);
				powerUpHandler.update(tornado, player);
				obstacleHandler.update(userInterface.getMessage(), camera, tornado, player, shrapnelDropHandler, tornadoGame, this);

				for (int i = 0; i < cloud.length; i++) {
					cloud[i].update();
				}

				checkEndOfLevel();
				checkCountdown();
				if (showCountdown) {
					countdown.update();
				}
				determineWinner(tornadoGame, camera, userInterface.getMessage(), player, tornado, TornadoGame.levelToLoad);

				// If tornado sucks up player 3 times, tornado wins.
				if (!levelIsOver) {
					checkTornadoSuckUpScore();
				}

				if (isWinningScreenHasConcluded()) {
					TornadoGame.levelToLoad++;
					tornadoGame.create();
				}

				userInterface.update(player, this);

				handleGoTextureTimer();
			}

			handleFadeIn();
		} else {
			cutscene.update();
		}
	}

	private void handleGoTextureTimer() {
		if (transparencyAlpha >= 1) {
			if (goTextureTimer < GO_TEXTURE_MAX) {
				goTextureTimer++;
			}
		}
	}

	private void handleFadeIn() {
		if (transparencyAlpha < 1) {
			transparencyAlpha += transparencyAlphaIncrement;
			transparencyAlphaIncrement += 0.005f;
		}
	}

	public void draw(SpriteBatch batch, Tornado tornado, Player player, int level) {
		if (cutscene.isCutsceneComplete()) {
			batch.setColor(1, 1, 1, transparencyAlpha);
			backgroundHandler.draw(batch, level);

			if (level != LevelHandler.LEVEL_HELL && level != LevelHandler.LEVEL_SPACE) {
				for (int i = 0; i < cloud.length; i++) {
					cloud[i].draw(batch);
				}
			}
			//shadowHandler.draw(batch, tornado, player);
			platformHandler.draw(batch);
			powerUpHandler.draw(batch);
			obstacleHandler.draw(batch, gameObjectHandler.getTornado());
			shrapnelDropHandler.draw(batch, this);
			gameObjectHandler.draw(batch, this, level);
			userInterface.draw(batch, gameObjectHandler.getTornado(), gameObjectHandler.getPlayer(), level);
			debreeHandler.draw(batch);

			if (transparencyAlpha >= 1 && goTextureTimer < GO_TEXTURE_MAX) {
				batch.draw(
						goTexture, 
						TornadoGame.screenWidth / 2 - goTextureSize * 1.5f, 
						TornadoGame.screenHeight / 2 - goTextureSize / 2, 
						goTextureSize * 3, 
						goTextureSize
						);
			}

			if (loadingScreenShouldRender) {
				int loadingScreenOffset = 50;
				batch.draw(loadingScreen, 0 - loadingScreenOffset, 0, TornadoGame.screenWidth + loadingScreenOffset * 2, TornadoGame.screenHeight);
			}

			if (showCountdown && !levelIsOver) {
				countdown.draw(batch);
			}
		} else {
			cutscene.draw(batch, player, tornado, level);
		}
	}

	private void checkTornadoSuckUpScore() {
		if (gameObjectHandler.getPlayer().getLives() == 0) {
			levelIsOver = true;
			winner      = WINNER_TORNADO;
		}
	}

	public boolean isWinningScreenHasConcluded() {
		return winningScreenHasConcluded;
	}

	private void handleWinningScreen(Message message, OrthographicCamera camera, TornadoGame tornadoGame) {
		int messageToDisplay = Message.MESSAGE_WINNER;
		if (TornadoGame.levelToLoad == LevelHandler.LEVEL_END) {
			messageToDisplay = Message.MESSAGE_ULTIMATE_WINNER;
		}
		message.setShouldDisplayMessage(true, messageToDisplay, camera.viewportWidth / 2 - message.getWidth() / 2, camera.viewportHeight / 2 - message.getHeight() / 2);
		winningScreenTimer++;
		if (winningScreenTimer > WINNING_SCREEN_DURATION) {
			winningScreenHasConcluded = true;
			// Make sure score doesn't keep going up after last level.
			if (TornadoGame.levelToLoad <= LevelHandler.LEVEL_TRACK) {
				if (winner == WINNER_PLAYER) {
					WinnerHandler.playerScore++;
				} else {
					WinnerHandler.tornadoScore++;
				}
			}
		}
		if (winningScreenTimer > WINNING_SCREEN_DURATION - 1) {
			loadingScreenShouldRender = true;
		}
	}

	private void determineWinner(TornadoGame tornadoGame, OrthographicCamera camera, Message message, Player player, Tornado tornado, int level) {
		if (levelIsOver) {
			if (player.getPoints() > tornado.getPoints()) {
				winner = WINNER_PLAYER;
				switch (level) {
				case LevelHandler.LEVEL_FARM:
					Player.hasWonFarmLevel = true;
					break;
				case LevelHandler.LEVEL_SPACE:
					Player.hasWonSpaceLevel = true;
					break;
				case LevelHandler.LEVEL_BEACH:
					Player.hasWonBeachLevel = true;
					break;
				case LevelHandler.LEVEL_ARCTIC:
					Player.hasWonArcticLevel = true;
					break;
				case LevelHandler.LEVEL_HELL:
					Player.hasWonHellLevel = true;
					break;
				case LevelHandler.LEVEL_CITY:
					Player.hasWonCityLevel = true;
					break;
				case LevelHandler.LEVEL_DESERT:
					Player.hasWonDesertLevel = true;
					break;
				case LevelHandler.LEVEL_FORREST:
					Player.hasWonForrestLevel = true;
					break;
				case LevelHandler.LEVEL_TRACK:
					Player.hasWonTrackLevel = true;
					break;
				}
			} else {
				winner = WINNER_TORNADO;
				switch (level) {
				case LevelHandler.LEVEL_FARM:
					Tornado.hasWonFarmLevel = true;
					break;
				case LevelHandler.LEVEL_SPACE:
					Tornado.hasWonSpaceLevel = true;
					break;
				case LevelHandler.LEVEL_BEACH:
					Tornado.hasWonBeachLevel = true;
					break;
				case LevelHandler.LEVEL_ARCTIC:
					Tornado.hasWonArcticLevel = true;
					break;
				case LevelHandler.LEVEL_HELL:
					Tornado.hasWonHellLevel = true;
					break;
				case LevelHandler.LEVEL_CITY:
					Tornado.hasWonCityLevel = true;
					break;
				case LevelHandler.LEVEL_DESERT:
					Tornado.hasWonDesertLevel = true;
					break;
				case LevelHandler.LEVEL_FORREST:
					Tornado.hasWonForrestLevel = true;
					break;
				case LevelHandler.LEVEL_TRACK:
					Tornado.hasWonTrackLevel = true;
					break;
				}
			}
			if (winner == WINNER_TORNADO) {
				tornado.updateWinner(tornado.getMAX_WIDTH(), tornado.getMAX_HEIGHT());
				player.updateLoser();
			} else {
				player.updateWinner(player.getWINNER_MAX_SIZE(), player.getWINNER_MAX_SIZE());
				tornado.updateLoser();
			}
			handleWinningScreen(message, camera, tornadoGame);
		} else {
			// If someone wins before the level is over, end the level.
			if (tornado.getPoints() > PointHandler.MAX_POINTS || player.getPoints() > PointHandler.MAX_POINTS) {
				if (player.getPoints() > PointHandler.MAX_POINTS) {
					winner = WINNER_PLAYER;
					switch (level) {
					case LevelHandler.LEVEL_FARM:
						Player.hasWonFarmLevel = true;
						break;
					case LevelHandler.LEVEL_SPACE:
						Player.hasWonSpaceLevel = true;
						break;
					case LevelHandler.LEVEL_BEACH:
						Player.hasWonBeachLevel = true;
						break;
					case LevelHandler.LEVEL_ARCTIC:
						Player.hasWonArcticLevel = true;
						break;
					case LevelHandler.LEVEL_HELL:
						Player.hasWonHellLevel = true;
						break;
					case LevelHandler.LEVEL_CITY:
						Player.hasWonCityLevel = true;
						break;
					case LevelHandler.LEVEL_DESERT:
						Player.hasWonDesertLevel = true;
						break;
					case LevelHandler.LEVEL_FORREST:
						Player.hasWonForrestLevel = true;
						break;
					case LevelHandler.LEVEL_TRACK:
						Player.hasWonTrackLevel = true;
						break;
					}
				} else {
					winner = WINNER_TORNADO;
					switch (level) {
					case LevelHandler.LEVEL_FARM:
						Tornado.hasWonFarmLevel = true;
						break;
					case LevelHandler.LEVEL_SPACE:
						Tornado.hasWonSpaceLevel = true;
						break;
					case LevelHandler.LEVEL_BEACH:
						Tornado.hasWonBeachLevel = true;
						break;
					case LevelHandler.LEVEL_ARCTIC:
						Tornado.hasWonArcticLevel = true;
						break;
					case LevelHandler.LEVEL_HELL:
						Tornado.hasWonHellLevel = true;
						break;
					case LevelHandler.LEVEL_CITY:
						Tornado.hasWonCityLevel = true;
						break;
					case LevelHandler.LEVEL_DESERT:
						Tornado.hasWonDesertLevel = true;
						break;
					case LevelHandler.LEVEL_FORREST:
						Tornado.hasWonForrestLevel = true;
						break;
					case LevelHandler.LEVEL_TRACK:
						Tornado.hasWonTrackLevel = true;
						break;
					}
				}
				levelIsOver = true;
				checkEndOfLevel();
				handleWinningScreen(message, camera, tornadoGame);
			}
		}
	}

	public boolean isLevelIsOver() {
		return levelIsOver;
	}

	public GameObjectHandler getGameObjectHandler() {
		return gameObjectHandler;
	}

	public int getWinner() {
		return winner;
	}

	public ShrapnelDropHandler getShrapnelDropHandler() {
		return shrapnelDropHandler;
	}

	public static void dispose() {
		loadingScreen.dispose();
		goTexture.dispose();
		for (int i = 0; i < headTexture.length; i++) {
			headTexture[i].dispose();
		}
		for (int i = 0; i < rain.length; i++) {
			rain[i].getTexture().dispose();
		}
		for (int i = 0; i < wind.length; i++) {
			wind[i].getTexture().dispose();
		}
		for (int i = 0; i < snow.length; i++) {
			snow[i].getTexture().dispose();
		}
		for (int i = 0; i < fire.length; i++) {
			fire[i].getTexture().dispose();
		}
		for (int i = 0; i < cloud.length; i++) {
			cloud[i].getTexture().dispose();
		}
	}
}
