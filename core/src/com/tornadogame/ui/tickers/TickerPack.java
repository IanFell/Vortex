package com.tornadogame.ui.tickers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.helpers.RandomNumberGenerator;

public class TickerPack {

	private float tickerY;

	/**
	 * Number of total tickers that COULD happen randomly.
	 * Each level will load a random ticker from this number.
	 */
	private final int NUMBER_OF_UNIQUE_TICKERS = 25;

	/**
	 * How many screens the tickers take up.
	 * I made all the tickers be three screens long.
	 */
	private static final int NUMBER_OF_TICKERS_PER_TICKER = 3;

	private final int TICKER_GOLDENAGE = 0;
	private final int TICKER_DODGER = 1;
	private final int TICKER_ARC = 2;
	private final int TICKER_PONE = 3;
	private final int TICKER_MAGGIE = 4;
	private final int TICKER_KEVIN = 5;
	private final int TICKER_HEELS = 6;
	private final int TICKER_CAKE = 7;
	private final int TICKER_BULLS = 8;
	private final int TICKER_BAND = 9;
	private final int TICKER_TAIN = 10;
	private final int TICKER_ABE = 11;
	private final int TICKER_SCOUTS = 12;
	private final int TICKER_MOUSE = 13;
	private final int TICKER_BULLET = 14;
	private final int TICKER_SPIT = 15;
	private final int TICKER_FINGER = 16;
	private final int TICKER_CARTERS = 17;
	private final int TICKER_JAKE = 18;
	private final int TICKER_EMMA = 19;
	private final int TICKER_CONE = 20;
	private final int TICKER_MOTHER = 21;
	private final int TICKER_MED = 22;
	private final int TICKER_SLAP = 23;
	private final int TICKER_MOVIE = 24;
	//private final int TICKER_BEER = 25;

	private int tickerToLoad;

	public static Texture[] tickerTexturesGoldenage = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesGoldenageX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesDodgerDog = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesDodgerDogX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesArc = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesArcX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesPone = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesPoneX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesMaggie = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesMaggieX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesKevin = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesKevinX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesHeels = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesHeelsX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesCake = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesCakeX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesBulls = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesBullsX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesBand = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesBandX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesTain = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesTainX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesAbe = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesAbeX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesScouts = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesScoutsX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesMouse = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesMouseX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesBullet = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesBulletX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesSpit = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesSpitX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesFinger = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesFingerX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesCarters = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesCartersX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesJake = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesJakeX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesEmma = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesEmmaX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesCone = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesConeX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesMother = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesMotherX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesMed = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesMedX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesSlap = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesSlapX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	public static Texture[] tickerTexturesMovie = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	private Float[] tickerTexturesMovieX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	//private Texture[] tickerTexturesBeer = new Texture[NUMBER_OF_TICKERS_PER_TICKER];
	//private Float[] tickerTexturesBeerX = new Float[NUMBER_OF_TICKERS_PER_TICKER];

	private float dx = -15;

	public TickerPack() {
		tickerToLoad = RandomNumberGenerator.generateRandomInteger(NUMBER_OF_UNIQUE_TICKERS);
		switch (tickerToLoad) {
		case TICKER_GOLDENAGE:
			loadGoldenageTicker();
			break;
		case TICKER_DODGER:
			loadDodgerDogTicker();
			break;
		case TICKER_ARC:
			loadArcTicker();
			break;
		case TICKER_PONE:
			loadPoneTicker();
			break;
		case TICKER_MAGGIE:
			loadMaggieTicker();
			break;
		case TICKER_KEVIN:
			loadKevinTicker();
			break;
		case TICKER_HEELS:
			loadHeelsTicker();
			break;
		case TICKER_CAKE:
			loadCakeTicker();
			break;
		case TICKER_BULLS:
			loadBullsTicker();
			break;
		case TICKER_BAND:
			loadBandTicker();
			break;
		case TICKER_TAIN:
			loadTainTicker();
			break;
		case TICKER_ABE:
			loadAbeTicker();
			break;
		case TICKER_SCOUTS:
			loadScoutsTicker();
			break;
		case TICKER_MOUSE:
			loadMouseTicker();
			break;
		case TICKER_BULLET:
			loadBulletTicker();
			break;
		case TICKER_SPIT:
			loadSpitTicker();
			break;
		case TICKER_FINGER:
			loadFingerTicker();
			break;
		case TICKER_CARTERS:
			loadCartersTicker();
			break;
		case TICKER_JAKE:
			loadJakeTicker();
			break;
		case TICKER_EMMA:
			loadEmmaTicker();
			break;
		case TICKER_CONE:
			loadConeTicker();
			break;
		case TICKER_MOTHER:
			loadMotherTicker();
			break;
		case TICKER_MED:
			loadMedTicker();
			break;
		case TICKER_SLAP:
			loadSlapTicker();
			break;
		case TICKER_MOVIE:
			loadMovieTicker();
			break;
			/* case TICKER_BEER:
			loadBeerTicker();
			break; */
		}

		tickerY = TornadoGame.screenHeight / 24;
	}

	public void draw(SpriteBatch batch) {
		switch (tickerToLoad) {
		case TICKER_GOLDENAGE:
			for (int i = 0; i < tickerTexturesGoldenage.length; i++) {
				batch.draw(tickerTexturesGoldenage[i], tickerTexturesGoldenageX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_DODGER:
			for (int i = 0; i < tickerTexturesDodgerDogX.length; i++) {
				batch.draw(tickerTexturesDodgerDog[i], tickerTexturesDodgerDogX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_ARC:
			for (int i = 0; i < tickerTexturesArcX.length; i++) {
				batch.draw(tickerTexturesArc[i], tickerTexturesArcX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_PONE:
			for (int i = 0; i < tickerTexturesPoneX.length; i++) {
				batch.draw(tickerTexturesPone[i], tickerTexturesPoneX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_MAGGIE:
			for (int i = 0; i < tickerTexturesMaggieX.length; i++) {
				batch.draw(tickerTexturesMaggie[i], tickerTexturesMaggieX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_KEVIN:
			for (int i = 0; i < tickerTexturesKevinX.length; i++) {
				batch.draw(tickerTexturesKevin[i], tickerTexturesKevinX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_HEELS:
			for (int i = 0; i < tickerTexturesHeelsX.length; i++) {
				batch.draw(tickerTexturesHeels[i], tickerTexturesHeelsX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_CAKE:
			for (int i = 0; i < tickerTexturesCakeX.length; i++) {
				batch.draw(tickerTexturesCake[i], tickerTexturesCakeX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_BULLS:
			for (int i = 0; i < tickerTexturesBullsX.length; i++) {
				batch.draw(tickerTexturesBulls[i], tickerTexturesBullsX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_BAND:
			for (int i = 0; i < tickerTexturesBandX.length; i++) {
				batch.draw(tickerTexturesBand[i], tickerTexturesBandX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_TAIN:
			for (int i = 0; i < tickerTexturesTainX.length; i++) {
				batch.draw(tickerTexturesTain[i], tickerTexturesTainX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_ABE:
			for (int i = 0; i < tickerTexturesAbeX.length; i++) {
				batch.draw(tickerTexturesAbe[i], tickerTexturesAbeX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_SCOUTS:
			for (int i = 0; i < tickerTexturesScoutsX.length; i++) {
				batch.draw(tickerTexturesScouts[i], tickerTexturesScoutsX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_MOUSE:
			for (int i = 0; i < tickerTexturesMouseX.length; i++) {
				batch.draw(tickerTexturesMouse[i], tickerTexturesMouseX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_BULLET:
			for (int i = 0; i < tickerTexturesBulletX.length; i++) {
				batch.draw(tickerTexturesBullet[i], tickerTexturesBulletX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_SPIT:
			for (int i = 0; i < tickerTexturesSpitX.length; i++) {
				batch.draw(tickerTexturesSpit[i], tickerTexturesSpitX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_FINGER:
			for (int i = 0; i < tickerTexturesFingerX.length; i++) {
				batch.draw(tickerTexturesFinger[i], tickerTexturesFingerX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_CARTERS:
			for (int i = 0; i < tickerTexturesCartersX.length; i++) {
				batch.draw(tickerTexturesCarters[i], tickerTexturesCartersX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_JAKE:
			for (int i = 0; i < tickerTexturesJakeX.length; i++) {
				batch.draw(tickerTexturesJake[i], tickerTexturesJakeX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_EMMA:
			for (int i = 0; i < tickerTexturesEmmaX.length; i++) {
				batch.draw(tickerTexturesEmma[i], tickerTexturesEmmaX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_CONE:
			for (int i = 0; i < tickerTexturesConeX.length; i++) {
				batch.draw(tickerTexturesCone[i], tickerTexturesConeX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_MOTHER:
			for (int i = 0; i < tickerTexturesMotherX.length; i++) {
				batch.draw(tickerTexturesMother[i], tickerTexturesMotherX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_MED:
			for (int i = 0; i < tickerTexturesMedX.length; i++) {
				batch.draw(tickerTexturesMed[i], tickerTexturesMedX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_SLAP:
			for (int i = 0; i < tickerTexturesSlapX.length; i++) {
				batch.draw(tickerTexturesSlap[i], tickerTexturesSlapX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
		case TICKER_MOVIE:
			for (int i = 0; i < tickerTexturesMovieX.length; i++) {
				batch.draw(tickerTexturesMovie[i], tickerTexturesMovieX[i], tickerY, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break;
			/*
		case TICKER_BEER:
			for (int i = 0; i < tickerTexturesBeerX.length; i++) {
				// This one is dumb and insulting, so just use something else.
				batch.draw(tickerTexturesMovie[i], tickerTexturesMovieX[i], 0, TornadoGame.screenWidth, TornadoGame.screenHeight);
			}
			break; */
		}
	}

	public void update() {
		switch (tickerToLoad) {
		case TICKER_GOLDENAGE:
			for (int i = 0; i < tickerTexturesGoldenageX.length; i++) {
				tickerTexturesGoldenageX[i] += dx;
				if (tickerTexturesGoldenageX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesGoldenageX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_DODGER:
			for (int i = 0; i < tickerTexturesDodgerDogX.length; i++) {
				tickerTexturesDodgerDogX[i] += dx;
				if (tickerTexturesDodgerDogX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesDodgerDogX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_ARC:
			for (int i = 0; i < tickerTexturesArcX.length; i++) {
				tickerTexturesArcX[i] += dx;
				if (tickerTexturesArcX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesArcX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_PONE:
			for (int i = 0; i < tickerTexturesPoneX.length; i++) {
				tickerTexturesPoneX[i] += dx;
				if (tickerTexturesPoneX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesPoneX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_MAGGIE:
			for (int i = 0; i < tickerTexturesMaggieX.length; i++) {
				tickerTexturesMaggieX[i] += dx;
				if (tickerTexturesMaggieX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesMaggieX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_KEVIN:
			for (int i = 0; i < tickerTexturesKevinX.length; i++) {
				tickerTexturesKevinX[i] += dx;
				if (tickerTexturesKevinX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesKevinX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_HEELS:
			for (int i = 0; i < tickerTexturesHeelsX.length; i++) {
				tickerTexturesHeelsX[i] += dx;
				if (tickerTexturesHeelsX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesHeelsX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_CAKE:
			for (int i = 0; i < tickerTexturesCakeX.length; i++) {
				tickerTexturesCakeX[i] += dx;
				if (tickerTexturesCakeX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesCakeX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_BULLS:
			for (int i = 0; i < tickerTexturesBullsX.length; i++) {
				tickerTexturesBullsX[i] += dx;
				if (tickerTexturesBullsX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesBullsX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_BAND:
			for (int i = 0; i < tickerTexturesBandX.length; i++) {
				tickerTexturesBandX[i] += dx;
				if (tickerTexturesBandX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesBandX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_TAIN:
			for (int i = 0; i < tickerTexturesTainX.length; i++) {
				tickerTexturesTainX[i] += dx;
				if (tickerTexturesTainX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesTainX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_ABE:
			for (int i = 0; i < tickerTexturesAbeX.length; i++) {
				tickerTexturesAbeX[i] += dx;
				if (tickerTexturesAbeX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesAbeX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_SCOUTS:
			for (int i = 0; i < tickerTexturesScoutsX.length; i++) {
				tickerTexturesScoutsX[i] += dx;
				if (tickerTexturesScoutsX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesScoutsX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_MOUSE:
			for (int i = 0; i < tickerTexturesMouseX.length; i++) {
				tickerTexturesMouseX[i] += dx;
				if (tickerTexturesMouseX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesMouseX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_BULLET:
			for (int i = 0; i < tickerTexturesBulletX.length; i++) {
				tickerTexturesBulletX[i] += dx;
				if (tickerTexturesBulletX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesBulletX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_SPIT:
			for (int i = 0; i < tickerTexturesSpitX.length; i++) {
				tickerTexturesSpitX[i] += dx;
				if (tickerTexturesSpitX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesSpitX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_FINGER:
			for (int i = 0; i < tickerTexturesFingerX.length; i++) {
				tickerTexturesFingerX[i] += dx;
				if (tickerTexturesFingerX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesFingerX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_CARTERS:
			for (int i = 0; i < tickerTexturesCartersX.length; i++) {
				tickerTexturesCartersX[i] += dx;
				if (tickerTexturesCartersX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesCartersX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_JAKE:
			for (int i = 0; i < tickerTexturesJakeX.length; i++) {
				tickerTexturesJakeX[i] += dx;
				if (tickerTexturesJakeX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesJakeX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_EMMA:
			for (int i = 0; i < tickerTexturesEmmaX.length; i++) {
				tickerTexturesEmmaX[i] += dx;
				if (tickerTexturesEmmaX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesEmmaX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_CONE:
			for (int i = 0; i < tickerTexturesConeX.length; i++) {
				tickerTexturesConeX[i] += dx;
				if (tickerTexturesConeX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesConeX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_MOTHER:
			for (int i = 0; i < tickerTexturesMotherX.length; i++) {
				tickerTexturesMotherX[i] += dx;
				if (tickerTexturesMotherX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesMotherX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_MED:
			for (int i = 0; i < tickerTexturesMedX.length; i++) {
				tickerTexturesMedX[i] += dx;
				if (tickerTexturesMedX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesMedX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_SLAP:
			for (int i = 0; i < tickerTexturesSlapX.length; i++) {
				tickerTexturesSlapX[i] += dx;
				if (tickerTexturesSlapX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesSlapX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
		case TICKER_MOVIE:
			for (int i = 0; i < tickerTexturesMovieX.length; i++) {
				tickerTexturesMovieX[i] += dx;
				if (tickerTexturesMovieX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesMovieX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break;
			/*case TICKER_BEER:
			for (int i = 0; i < tickerTexturesBeerX.length; i++) {
				tickerTexturesBeerX[i] += dx;
				if (tickerTexturesBeerX[i] + TornadoGame.screenWidth < 0) {
					tickerTexturesBeerX[i] = (float) TornadoGame.screenWidth * 2;
				}
			}
			break; */
		}
	}

	/*
	private void loadBeerTicker() {
		tickerTexturesBeer[0] = new Texture("artwork/ui/tickers/beer/Ticker_01.png");
		tickerTexturesBeer[1] = new Texture("artwork/ui/tickers/beer/Ticker_02.png");
		tickerTexturesBeer[2] = new Texture("artwork/ui/tickers/beer/Ticker_03.png");

		tickerTexturesBeerX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesBeerX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesBeerX[2] = (float) TornadoGame.screenWidth * 3;
	} */

	private void loadMovieTicker() {
		tickerTexturesMovie[0] = new Texture("artwork/ui/tickers/movie/Ticker_01.png");
		tickerTexturesMovie[1] = new Texture("artwork/ui/tickers/movie/Ticker_02.png");
		tickerTexturesMovie[2] = new Texture("artwork/ui/tickers/movie/Ticker_03.png");

		tickerTexturesMovieX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesMovieX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesMovieX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadSlapTicker() {
		tickerTexturesSlap[0] = new Texture("artwork/ui/tickers/slap/Ticker_01.png");
		tickerTexturesSlap[1] = new Texture("artwork/ui/tickers/slap/Ticker_02.png");
		tickerTexturesSlap[2] = new Texture("artwork/ui/tickers/slap/Ticker_03.png");

		tickerTexturesSlapX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesSlapX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesSlapX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadMedTicker() {
		tickerTexturesMed[0] = new Texture("artwork/ui/tickers/medical/Ticker_01.png");
		tickerTexturesMed[1] = new Texture("artwork/ui/tickers/medical/Ticker_02.png");
		tickerTexturesMed[2] = new Texture("artwork/ui/tickers/medical/Ticker_03.png");

		tickerTexturesMedX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesMedX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesMedX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadMotherTicker() {
		tickerTexturesMother[0] = new Texture("artwork/ui/tickers/mothersday/Ticker_01.png");
		tickerTexturesMother[1] = new Texture("artwork/ui/tickers/mothersday/Ticker_02.png");
		tickerTexturesMother[2] = new Texture("artwork/ui/tickers/mothersday/Ticker_03.png");

		tickerTexturesMotherX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesMotherX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesMotherX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadConeTicker() {
		tickerTexturesCone[0] = new Texture("artwork/ui/tickers/cone/Ticker_01.png");
		tickerTexturesCone[1] = new Texture("artwork/ui/tickers/cone/Ticker_02.png");
		tickerTexturesCone[2] = new Texture("artwork/ui/tickers/cone/Ticker_03.png");

		tickerTexturesConeX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesConeX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesConeX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadEmmaTicker() {
		tickerTexturesEmma[0] = new Texture("artwork/ui/tickers/emma/Ticker_01.png");
		tickerTexturesEmma[1] = new Texture("artwork/ui/tickers/emma/Ticker_02.png");
		tickerTexturesEmma[2] = new Texture("artwork/ui/tickers/emma/Ticker_03.png");

		tickerTexturesEmmaX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesEmmaX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesEmmaX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadJakeTicker() {
		tickerTexturesJake[0] = new Texture("artwork/ui/tickers/jake/Ticker_01.png");
		tickerTexturesJake[1] = new Texture("artwork/ui/tickers/jake/Ticker_02.png");
		tickerTexturesJake[2] = new Texture("artwork/ui/tickers/jake/Ticker_03.png");

		tickerTexturesJakeX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesJakeX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesJakeX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadCartersTicker() {
		tickerTexturesCarters[0] = new Texture("artwork/ui/tickers/carters/Ticker_01.png");
		tickerTexturesCarters[1] = new Texture("artwork/ui/tickers/carters/Ticker_02.png");
		tickerTexturesCarters[2] = new Texture("artwork/ui/tickers/carters/Ticker_03.png");

		tickerTexturesCartersX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesCartersX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesCartersX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadFingerTicker() {
		tickerTexturesFinger[0] = new Texture("artwork/ui/tickers/finger/Ticker_01.png");
		tickerTexturesFinger[1] = new Texture("artwork/ui/tickers/finger/Ticker_02.png");
		tickerTexturesFinger[2] = new Texture("artwork/ui/tickers/finger/Ticker_03.png");

		tickerTexturesFingerX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesFingerX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesFingerX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadSpitTicker() {
		tickerTexturesSpit[0] = new Texture("artwork/ui/tickers/spit/Ticker_01.png");
		tickerTexturesSpit[1] = new Texture("artwork/ui/tickers/spit/Ticker_02.png");
		tickerTexturesSpit[2] = new Texture("artwork/ui/tickers/spit/Ticker_03.png");

		tickerTexturesSpitX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesSpitX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesSpitX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadBulletTicker() {
		tickerTexturesBullet[0] = new Texture("artwork/ui/tickers/bullet/Ticker_01.png");
		tickerTexturesBullet[1] = new Texture("artwork/ui/tickers/bullet/Ticker_02.png");
		tickerTexturesBullet[2] = new Texture("artwork/ui/tickers/bullet/Ticker_03.png");

		tickerTexturesBulletX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesBulletX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesBulletX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadMouseTicker() {
		tickerTexturesMouse[0] = new Texture("artwork/ui/tickers/mouse/Ticker_01.png");
		tickerTexturesMouse[1] = new Texture("artwork/ui/tickers/mouse/Ticker_02.png");
		tickerTexturesMouse[2] = new Texture("artwork/ui/tickers/mouse/Ticker_03.png");

		tickerTexturesMouseX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesMouseX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesMouseX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadGoldenageTicker() {
		tickerTexturesGoldenage[0] = new Texture("artwork/ui/tickers/goldenage/Ticker_01.png");
		tickerTexturesGoldenage[1] = new Texture("artwork/ui/tickers/goldenage/Ticker_02.png");
		tickerTexturesGoldenage[2] = new Texture("artwork/ui/tickers/goldenage/Ticker_03.png");

		tickerTexturesGoldenageX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesGoldenageX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesGoldenageX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadDodgerDogTicker() {
		tickerTexturesDodgerDog[0] = new Texture("artwork/ui/tickers/dodgerdog/Ticker_01.png");
		tickerTexturesDodgerDog[1] = new Texture("artwork/ui/tickers/dodgerdog/Ticker_02.png");
		tickerTexturesDodgerDog[2] = new Texture("artwork/ui/tickers/dodgerdog/Ticker_03.png");

		tickerTexturesDodgerDogX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesDodgerDogX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesDodgerDogX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadArcTicker() {
		tickerTexturesArc[0] = new Texture("artwork/ui/tickers/arc/Ticker_01.png");
		tickerTexturesArc[1] = new Texture("artwork/ui/tickers/arc/Ticker_02.png");
		tickerTexturesArc[2] = new Texture("artwork/ui/tickers/arc/Ticker_03.png");

		tickerTexturesArcX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesArcX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesArcX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadPoneTicker() {
		tickerTexturesPone[0] = new Texture("artwork/ui/tickers/pone/Ticker_01.png");
		tickerTexturesPone[1] = new Texture("artwork/ui/tickers/pone/Ticker_02.png");
		tickerTexturesPone[2] = new Texture("artwork/ui/tickers/pone/Ticker_03.png");

		tickerTexturesPoneX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesPoneX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesPoneX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadMaggieTicker() {
		tickerTexturesMaggie[0] = new Texture("artwork/ui/tickers/maggie/Ticker_01.png");
		tickerTexturesMaggie[1] = new Texture("artwork/ui/tickers/maggie/Ticker_02.png");
		tickerTexturesMaggie[2] = new Texture("artwork/ui/tickers/maggie/Ticker_03.png");

		tickerTexturesMaggieX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesMaggieX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesMaggieX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadKevinTicker() {
		tickerTexturesKevin[0] = new Texture("artwork/ui/tickers/kevin/Ticker_01.png");
		tickerTexturesKevin[1] = new Texture("artwork/ui/tickers/kevin/Ticker_02.png");
		tickerTexturesKevin[2] = new Texture("artwork/ui/tickers/kevin/Ticker_03.png");

		tickerTexturesKevinX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesKevinX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesKevinX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadHeelsTicker() {
		tickerTexturesHeels[0] = new Texture("artwork/ui/tickers/heels/Ticker_01.png");
		tickerTexturesHeels[1] = new Texture("artwork/ui/tickers/heels/Ticker_02.png");
		tickerTexturesHeels[2] = new Texture("artwork/ui/tickers/heels/Ticker_03.png");

		tickerTexturesHeelsX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesHeelsX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesHeelsX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadCakeTicker() {
		tickerTexturesCake[0] = new Texture("artwork/ui/tickers/cake/Ticker_01.png");
		tickerTexturesCake[1] = new Texture("artwork/ui/tickers/cake/Ticker_02.png");
		tickerTexturesCake[2] = new Texture("artwork/ui/tickers/cake/Ticker_03.png");

		tickerTexturesCakeX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesCakeX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesCakeX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadBullsTicker() {
		tickerTexturesBulls[0] = new Texture("artwork/ui/tickers/bulls/Ticker_01.png");
		tickerTexturesBulls[1] = new Texture("artwork/ui/tickers/bulls/Ticker_02.png");
		tickerTexturesBulls[2] = new Texture("artwork/ui/tickers/bulls/Ticker_03.png");

		tickerTexturesBullsX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesBullsX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesBullsX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadBandTicker() {
		tickerTexturesBand[0] = new Texture("artwork/ui/tickers/band/Ticker_01.png");
		tickerTexturesBand[1] = new Texture("artwork/ui/tickers/band/Ticker_02.png");
		tickerTexturesBand[2] = new Texture("artwork/ui/tickers/band/Ticker_03.png");

		tickerTexturesBandX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesBandX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesBandX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadTainTicker() {
		tickerTexturesTain[0] = new Texture("artwork/ui/tickers/tain/Ticker_01.png");
		tickerTexturesTain[1] = new Texture("artwork/ui/tickers/tain/Ticker_02.png");
		tickerTexturesTain[2] = new Texture("artwork/ui/tickers/tain/Ticker_03.png");

		tickerTexturesTainX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesTainX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesTainX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadAbeTicker() {
		tickerTexturesAbe[0] = new Texture("artwork/ui/tickers/abe/Ticker_01.png");
		tickerTexturesAbe[1] = new Texture("artwork/ui/tickers/abe/Ticker_02.png");
		tickerTexturesAbe[2] = new Texture("artwork/ui/tickers/abe/Ticker_03.png");

		tickerTexturesAbeX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesAbeX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesAbeX[2] = (float) TornadoGame.screenWidth * 3;
	}

	private void loadScoutsTicker() {
		tickerTexturesScouts[0] = new Texture("artwork/ui/tickers/scouts/Ticker_01.png");
		tickerTexturesScouts[1] = new Texture("artwork/ui/tickers/scouts/Ticker_02.png");
		tickerTexturesScouts[2] = new Texture("artwork/ui/tickers/scouts/Ticker_03.png");

		tickerTexturesScoutsX[0] = (float) TornadoGame.screenWidth;
		tickerTexturesScoutsX[1] = (float) TornadoGame.screenWidth * 2;
		tickerTexturesScoutsX[2] = (float) TornadoGame.screenWidth * 3;
	}

	public static void dispose() {
		for (int i = 0; i < NUMBER_OF_TICKERS_PER_TICKER; i++) {
			if (tickerTexturesGoldenage[i] != null) {
				tickerTexturesGoldenage[i].dispose();
			}
			if (tickerTexturesDodgerDog[i] != null) {
				tickerTexturesDodgerDog[i].dispose();
			}
			if (tickerTexturesArc[i] != null) {
				tickerTexturesArc[i].dispose();
			}
			if (tickerTexturesPone[i] != null) {
				tickerTexturesPone[i].dispose();
			}
			if (tickerTexturesMaggie[i] != null) {
				tickerTexturesMaggie[i].dispose();
			}
			if (tickerTexturesKevin[i] != null) {
				tickerTexturesKevin[i].dispose();
			}
			if (tickerTexturesHeels[i] != null) {
				tickerTexturesHeels[i].dispose();
			}
			if (tickerTexturesCake[i] != null) {
				tickerTexturesCake[i].dispose();
			}
			if (tickerTexturesBulls[i] != null) {
				tickerTexturesBulls[i].dispose();
			}
			if (tickerTexturesBand[i] != null) {
				tickerTexturesBand[i].dispose();
			}
			if (tickerTexturesTain[i] != null) {
				tickerTexturesTain[i].dispose();
			}
			if (tickerTexturesAbe[i] != null) {
				tickerTexturesAbe[i].dispose();
			}
			if (tickerTexturesScouts[i] != null) {
				tickerTexturesScouts[i].dispose();
			}
			if (tickerTexturesMouse[i] != null) {
				tickerTexturesMouse[i].dispose();
			}
			if (tickerTexturesBullet[i] != null) {
				tickerTexturesBullet[i].dispose();
			}
			if (tickerTexturesSpit[i] != null) {
				tickerTexturesSpit[i].dispose();
			}
			if (tickerTexturesFinger[i] != null) {
				tickerTexturesFinger[i].dispose();
			}
			if (tickerTexturesCarters[i] != null) {
				tickerTexturesCarters[i].dispose();
			}
			if (tickerTexturesJake[i] != null) {
				tickerTexturesJake[i].dispose();
			}
			if (tickerTexturesEmma[i] != null) {
				tickerTexturesEmma[i].dispose();
			}
			if (tickerTexturesCone[i] != null) {
				tickerTexturesCone[i].dispose();
			}
			if (tickerTexturesMother[i] != null) {
				tickerTexturesMother[i].dispose();
			}
			if (tickerTexturesMed[i] != null) {
				tickerTexturesMed[i].dispose();
			}
			if (tickerTexturesSlap[i] != null) {
				tickerTexturesSlap[i].dispose();
			}
			if (tickerTexturesMovie[i] != null) {
				tickerTexturesMovie[i].dispose();
			}
		}
	}
}
