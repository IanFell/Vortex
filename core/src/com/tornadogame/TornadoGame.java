package com.tornadogame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.cutscenes.Cutscene;
import com.tornadogame.foreground.Flame;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.gameobjects.powerups.PointBoost;
import com.tornadogame.gameobjects.powerups.PowerUp;
import com.tornadogame.handlers.BackgroundHandler;
import com.tornadogame.handlers.InputHandler;
import com.tornadogame.handlers.LevelHandler;
import com.tornadogame.handlers.ObstacleHandler;
import com.tornadogame.handlers.PlatformHandler;
import com.tornadogame.handlers.PowerUpHandler;
import com.tornadogame.handlers.ShrapnelDropHandler;
import com.tornadogame.handlers.WinnerHandler;
import com.tornadogame.handlers.audio.AudioHandler;
import com.tornadogame.levels.Level;
import com.tornadogame.obstacles.Obstacle;
import com.tornadogame.screenshake.ScreenShake;
import com.tornadogame.ui.Countdown;
import com.tornadogame.ui.Message;
import com.tornadogame.ui.Score;
import com.tornadogame.ui.menu.Menu;
import com.tornadogame.ui.menu.screenshots.ScreenShot;
import com.tornadogame.ui.meters.Meter;
import com.tornadogame.ui.slamscreen.SlamScreen;
import com.tornadogame.ui.splashscreen.SplashScreen;
import com.tornadogame.ui.subtitles.SubtitlePack;
import com.tornadogame.ui.tickers.TickerPack;
import com.tornadogame.ui.winningscreen.WinningScreen;

public class TornadoGame extends ApplicationAdapter {

	public static boolean gameHasBeenPlayedOnce = false;

	public static final float SCALE_VALUE_GAMEPLAY = 0.465f;
	public static final float SCALE_VALUE_CUTSCENE = 0.435f;

	public static boolean pause = false;

	public static boolean tornadoWinsFinalGame = false;
	public static boolean playerWinsFinalGame = false;

	public static float screenWidth;
	public static float screenHeight;

	private OrthographicCamera camera;

	private SpriteBatch batch;

	private InputHandler input;

	private LevelHandler levelHandler;

	private SplashScreen splashScreen;
	public static boolean splashScreenHasEnded;
	private Menu menu;
	private WinningScreen winningScreen;
	public static boolean displayWinningScreen = false;
	private SlamScreen slamScreen;

	public static boolean isAi;
	public static boolean playerHasAi;
	public static boolean tornadoHasAi;

	public static final int TORNADO    = 0;
	public static final int PLAYER     = 1;
	public static final int TWO_PLAYER = 2;

	private int gameType;

	// After every match, this increases by one increment to load the next level.  Game starts on LEVEL_FARM.
	public static int levelToLoad = LevelHandler.LEVEL_FARM;

	private boolean screenShouldShake;
	public ScreenShake screenShake;
	private int screenShakeTimer;

	private WinnerHandler winnerHandler;

	public static boolean shouldStartGameplay = false;

	public static boolean shouldReloadGame = false;

	private AudioHandler audioHandler;

	public int getGameType() {
		return gameType;
	}

	public void setGameType(int gameType) {
		this.gameType = gameType;
	}

	private void generateGameType(OrthographicCamera camera) {

		// This resets the game after completion.
		if (levelToLoad <= LevelHandler.LEVEL_FARM) {
			WinnerHandler.resetScores();
			resetGameType();
		}

		if (!shouldStartGameplay) {
			isAi     = true;
			if (gameType == TORNADO) {
				tornadoHasAi = false;
				playerHasAi  = true;
			} 
			else if (gameType == PLAYER) {
				tornadoHasAi = true;
				playerHasAi  = false;
			}
		}

		switch (levelToLoad) {
		case LevelHandler.LEVEL_TEST:
			levelHandler = new LevelHandler(camera, LevelHandler.LEVEL_TEST);
			break;
		case LevelHandler.LEVEL_FARM:
			levelHandler = new LevelHandler(camera, LevelHandler.LEVEL_FARM);
			break;
		case LevelHandler.LEVEL_SPACE:
			levelHandler = new LevelHandler(camera, LevelHandler.LEVEL_SPACE);
			break;
		case LevelHandler.LEVEL_BEACH:
			levelHandler = new LevelHandler(camera, LevelHandler.LEVEL_BEACH);
			break;
		case LevelHandler.LEVEL_ARCTIC:
			levelHandler = new LevelHandler(camera, LevelHandler.LEVEL_ARCTIC);
			break;
		case LevelHandler.LEVEL_HELL:
			levelHandler = new LevelHandler(camera, LevelHandler.LEVEL_HELL);
			break;
		case LevelHandler.LEVEL_CITY:
			levelHandler = new LevelHandler(camera, LevelHandler.LEVEL_CITY);
			break;
		case LevelHandler.LEVEL_DESERT:
			levelHandler = new LevelHandler(camera, LevelHandler.LEVEL_DESERT);
			break;
		case LevelHandler.LEVEL_FORREST:
			levelHandler = new LevelHandler(camera, LevelHandler.LEVEL_FORREST);
			break;
		case LevelHandler.LEVEL_TRACK:
			levelHandler = new LevelHandler(camera, LevelHandler.LEVEL_TRACK);
			break;
		case LevelHandler.LEVEL_END:
			levelHandler = new LevelHandler(camera, LevelHandler.LEVEL_END);
			break;
		}
	}

	private void resetGameType() {
		tornadoHasAi = false;
		playerHasAi  = false;
	}

	@Override
	public void create () {

		if (gameHasBeenPlayedOnce) {
			dispose();
			System.out.println("DISPOSING");
			//System.exit(0);
		}

		screenWidth  = Gdx.graphics.getWidth() / SCALE_VALUE_GAMEPLAY;
		screenHeight = Gdx.graphics.getHeight() / SCALE_VALUE_GAMEPLAY;

		batch = new SpriteBatch();

		camera = new OrthographicCamera(screenWidth, screenHeight);
		camera.position.set(screenWidth / 2, screenHeight / 2, 0);

		generateGameType(camera);

		input = new InputHandler();
		input.init();

		screenShake      = new ScreenShake();
		screenShakeTimer = 0;

		winnerHandler = new WinnerHandler();

		menu = new Menu(screenWidth / 2, 0, 0, screenHeight, new Texture("artwork/menu/MenuBackground.png"), 0, 0, input);
		winningScreen = new WinningScreen(0, 0, screenWidth, screenHeight, new Texture("artwork/menu/MenuBackground.png"), 0, 0);

		audioHandler = new AudioHandler();

		splashScreen = new SplashScreen(0, 0, screenWidth, screenHeight, new Texture("artwork/splashscreen/SplashScreen.png"), 0, 0);
		splashScreenHasEnded = false;

		slamScreen = new SlamScreen(0, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, null, 0, 0);

		tornadoWinsFinalGame = false;
		playerWinsFinalGame  = false;
	}

	public void setScreenShouldShake(boolean screenShouldShake) {
		this.screenShouldShake = screenShouldShake;
	}

	private void updateLevels() {
		if (shouldStartGameplay) {
			levelHandler.update(camera, this);
		}
		//System.out.println(levelToLoad);
	}

	/**
	 * Use this method to determine who is the final game winner when the last cutscene starts.
	 * This will help to display the correct winner on screen.
	 */
	/*
	private void handleFinalWinner() {
		if (
				TornadoGame.levelToLoad == LevelHandler.LEVEL_END && 
				!levelHandler.getCurrentLevel().getCutscene().isCutsceneComplete()
				) {
			boolean tornadoHasWon = WinnerHandler.tornadoScore > WinnerHandler.playerScore;
			if (tornadoHasWon) {
				System.out.println("getting tornado");
				tornadoWinsFinalGame = true;
			} else {
				System.out.println("getting maggie");
				playerWinsFinalGame = true;
			}
		}
	}*/

	public WinnerHandler getWinnerHandler() {
		return winnerHandler;
	}

	@Override
	public void render () {
		if (!pause) {
			//System.out.println("level to load: " + levelToLoad);
			Tornado tornado = levelHandler.getCurrentLevel().getGameObjectHandler().getTornado();
			Player player = levelHandler.getCurrentLevel().getGameObjectHandler().getPlayer();
			input.handleInput(
					this,
					camera, 
					player, 
					tornado,
					levelHandler.getCurrentLevel().getShrapnelDropHandler(),
					levelHandler.getCurrentLevel()
					);
			if (shouldStartGameplay) {
				if (levelToLoad <= LevelHandler.LEVEL_END) { 
					updateLevels();
				} else {
					slamScreen.update();
				}
			} else if (splashScreenHasEnded) {
				menu.update();
			} else {
				splashScreen.update();
			}

			draw();
			handleScreenShake();
			audioHandler.handleAudio(levelHandler, player, tornado, levelToLoad);

			if (shouldReloadGame) {
				reloadGame();
			}
		}
	}

	private void handleScreenShake() {
		if (screenShouldShake) {
			screenShake.update(camera);
			screenShake.shake(ScreenShake.SHAKE_VALUE, 3);
			camera.update();

			screenShakeTimer++;
			if (screenShakeTimer > ScreenShake.SHAKE_VALUE) {
				screenShouldShake = false;
				screenShakeTimer  = 0;
			}
		}
	}

	public void draw() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.setProjectionMatrix(camera.combined);
		camera.update();
		if (shouldStartGameplay) {
			if (levelToLoad <= LevelHandler.LEVEL_END) { 
				levelHandler.draw(batch);
			} else {
				slamScreen.draw(batch);
			}

		} else if (splashScreenHasEnded) {
			if (input.isHasController()) {
				menu.draw(batch, input.getControllerInput(), input);
			} else {
				menu.draw(batch, input.getKeyboardInput(), input);
			}
		} else {
			splashScreen.draw(batch);
		}
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		audioHandler.dispose();
		Cutscene.dispose();
		disposeHandlers();
		//GameObject.dispose();
		disposePowerUps();
		Level.dispose();
		Obstacle.dispose();
		System.out.println("getting here");
		System.out.println("batch: " + batch);
		System.out.println("audioHandler: " + audioHandler);
		disposeUi();
		Flame.dispose();
	}

	private void disposeUi() {
		Countdown.dispose();
		Message.dispose();
		Score.dispose();
		Menu.dispose();
		ScreenShot.dispose();
		Meter.dispose();
		SlamScreen.dispose();
		SubtitlePack.dispose();
		TickerPack.dispose();
		WinningScreen.dispose();
	}

	private void disposePowerUps() {
		PointBoost.dispose();
		PowerUp.dispose();
	}

	private void disposeHandlers() {
		BackgroundHandler.dispose();
		ObstacleHandler.dispose();
		PlatformHandler.dispose();
		PowerUpHandler.dispose();
		ShrapnelDropHandler.dispose();
	}

	public WinningScreen getWinningScreen() {
		return winningScreen;
	}

	private void resetAi() {
		isAi         = false;
		playerHasAi  = false;
		tornadoHasAi = false;
	}

	public void reloadGame() {
		resetAi();
		shouldStartGameplay  = false;
		splashScreenHasEnded = false;
		Player.resetVariables();
		Tornado.resetVariables();
		levelToLoad = LevelHandler.LEVEL_FARM;
		Message.isRenderingUltimateWinner = true;
		create();
		shouldReloadGame = false;
	}
}

