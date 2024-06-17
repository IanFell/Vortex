package com.tornadogame.cutscenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.gameobjects.GameObject;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.handlers.LevelHandler;
import com.tornadogame.helpers.RandomNumberGenerator;
import com.tornadogame.ui.menu.Menu;
import com.tornadogame.ui.subtitles.SubtitlePack;
import com.tornadogame.ui.tickers.TickerPack;

public class Cutscene extends GameObject {

	protected static Texture[] timeanddate = new Texture[10];

	private float transparancy;

	protected static Texture breakingNews;
	private int breakingNewsTimer;
	private final int BREAKING_NEWS_MAX_VALUE = 20;

	private int nextLevelBlink;
	private final int NEXT_LEVEL_BLINK_VALUE = 30;

	private TickerPack tickers;

	private SubtitlePack subtitles;

	protected static Texture deadScreenTexture;
	private float deadScreenTimer;
	private boolean shouldDrawDeadScreen;

	private float tvScreenDimension;

	private final int CUTSCENE_TIMER_MAX = SubtitlePack.MAX_SUBTITLES * SubtitlePack.SUBTITLE_DISPLAY_LENGTH;
	private boolean cutsceneComplete;

	private static StaticEffect[] staticEffect = new StaticEffect[1500];
	private float staticScreenX;
	private float screenY;

	protected static Texture kevinTexture;
	private float kevinScreenX;

	protected static Texture maggieTexture;

	protected static Texture borderTexture;

	protected static Texture reporterBackgroundTexture;

	protected static Texture map;
	protected static Texture mapFarm;
	protected static Texture mapSpace;
	protected static Texture mapBeach;
	protected static Texture mapCity;
	protected static Texture mapHell;
	protected static Texture mapDesert;
	protected static Texture mapArctic;
	protected static Texture mapWoods;
	protected static Texture mapTrack;

	protected static Texture mapFarmBlink;
	protected static Texture mapSpaceBlink;
	protected static Texture mapBeachBlink;
	protected static Texture mapArcticBlink;
	protected static Texture mapHellBlink;
	protected static Texture mapCityBlink;
	protected static Texture mapDesertBlink;
	protected static Texture mapForrestBlink;
	protected static Texture mapTrackBlink;

	protected static Texture cutsceneBackground;

	private float mapX;
	private float mapY;
	private float mapWidth;
	private float mapHeight;

	private final int WINNER_TORNADO = 0;
	private final int WINNER_PLAYER  = 1;

	private float winnerIconSize = 100;

	protected static Texture mapBorder;

	private boolean hasBegunGarbledSpeechAudio;
	private boolean hasPlayedBeepAudio;

	private boolean playBreakingNewsAudio;

	private float maggieTimer;

	protected static Texture[] farmHead = new Texture[3];
	protected static Texture[] spaceHead = new Texture[1];
	protected static Texture[] beachHead = new Texture[3];
	protected static Texture[] arcticHead = new Texture[3];
	protected static Texture[] hellHead = new Texture[3];
	protected static Texture[] cityHead = new Texture[3];
	protected static Texture[] desertHead = new Texture[3];
	protected static Texture[] forrestHead = new Texture[3];
	protected static Texture[] trackHead = new Texture[3];
	protected static Texture[] endHead = new Texture[3];

	protected static Texture kevinBackground;

	protected static Texture maggieWinnerTexture;

	protected static Texture[] kevinHead = new Texture[4];

	protected static Texture maggieBackgroundTexture;
	protected static Texture[] maggieBackgrounds = new Texture[10];

	private final int MAGGIE_BACKGROUND_FARM = 0;
	private final int MAGGIE_BACKGROUND_SPACE = 1;
	private final int MAGGIE_BACKGROUND_BEACH = 2;
	private final int MAGGIE_BACKGROUND_ARCTIC = 3;
	private final int MAGGIE_BACKGROUND_HELL = 4;
	private final int MAGGIE_BACKGROUND_CITY = 5;
	private final int MAGGIE_BACKGROUND_DESERT = 6;
	private final int MAGGIE_BACKGROUND_FORREST = 7;
	private final int MAGGIE_BACKGROUND_TRACK = 8;
	private final int MAGGIE_BACKGROUND_END = 9;

	protected static Texture maggieAvoid;
	private int maggieAvoidFlashTimer;

	protected static Texture avoidInstructions[] = new Texture[10];
	protected static Texture avoidInstructionTexture;

	public Cutscene(float x, float y, float width, float height, Texture texture, float dx, float dy, int level) {
		super(x, y, width, height, texture, dx, dy);
		cutsceneComplete = false;
		tvScreenDimension = 500;
		float offset = TornadoGame.screenWidth / 8;
		staticScreenX = TornadoGame.screenWidth / 2 + offset;
		kevinScreenX = TornadoGame.screenWidth / 2 - (offset * 1.5f);
		screenY = 685;

		disposeStaticEffectTextures();

		for (int i = 0; i < staticEffect.length; i++) {
			float staticPixelSize = 15;
			Texture staticPixelTexture = new Texture("artwork/ui/staticeffect/GraySquare.png");
			int randomStaticPixelColor = RandomNumberGenerator.generateRandomInteger(3);
			switch(randomStaticPixelColor) {
			case 0:
				staticPixelTexture = new Texture("artwork/ui/staticeffect/BlackSquare.png");
				break;
			case 1:
				staticPixelTexture = new Texture("artwork/ui/staticeffect/GraySquare2.png");
				break;
			case 2:
				staticPixelTexture = new Texture("WhiteSquare.png");
				break;
			}
			float staticOffset = 20;
			staticEffect[i] = new StaticEffect(
					(float) RandomNumberGenerator.generateRandomDouble(staticScreenX - tvScreenDimension / 2 + staticOffset, staticScreenX  + tvScreenDimension / 2 - staticPixelSize - staticOffset), 
					(float) RandomNumberGenerator.generateRandomDouble(screenY + staticOffset, screenY  + tvScreenDimension - staticPixelSize - staticOffset), 
					staticPixelSize, 
					staticPixelSize, 
					staticPixelTexture, 
					0, 
					0
					);
		}

		deadScreenTexture = new Texture("artwork/cutscenes/SignalLost.png");
		deadScreenTimer = 0;
		shouldDrawDeadScreen = false;

		kevinTexture = new Texture("artwork/cutscenes/KL.png");
		maggieTexture = new Texture("artwork/cutscenes/MH.png");

		maggieTimer = 0;

		//map = new Texture("artwork/cutscenes/maps/MenuMapAlternate_02.png");
		map = new Texture("artwork/cutscenes/maps/MenuMapWhite.png");
		mapFarm = new Texture("artwork/cutscenes/maps/MenuMapFarm.png");
		mapSpace = new Texture("artwork/cutscenes/maps/MenuMapMoon.png");
		mapBeach = new Texture("artwork/cutscenes/maps/MenuMapBeach.png");
		mapCity = new Texture("artwork/cutscenes/maps/MenuMapCity.png");
		mapHell = new Texture("artwork/cutscenes/maps/MenuMapHell.png");
		mapDesert = new Texture("artwork/cutscenes/maps/MenuMapDesert.png");
		mapArctic = new Texture("artwork/cutscenes/maps/MenuMapArctic.png");
		mapWoods = new Texture("artwork/cutscenes/maps/MenuMapWoods.png");
		mapTrack = new Texture("artwork/cutscenes/maps/MenuMapLastLevel.png");

		mapFarmBlink = new Texture("artwork/cutscenes/maps/MenuMapFarm.png");
		mapSpaceBlink = new Texture("artwork/cutscenes/maps/MenuMapMoon.png");
		mapBeachBlink = new Texture("artwork/cutscenes/maps/MenuMapBeach.png");
		mapArcticBlink = new Texture("artwork/cutscenes/maps/MenuMapArctic.png");
		mapHellBlink = new Texture("artwork/cutscenes/maps/MenuMapHell.png");
		mapCityBlink = new Texture("artwork/cutscenes/maps/MenuMapCity.png");
		mapDesertBlink = new Texture("artwork/cutscenes/maps/MenuMapDesert.png");
		mapForrestBlink = new Texture("artwork/cutscenes/maps/MenuMapWoods.png");
		mapTrackBlink = new Texture("artwork/cutscenes/maps/MenuMapLastLevel.png");

		cutsceneBackground = new Texture("artwork/ui/UI_Black_Background.png");

		subtitles = new SubtitlePack(level, this, -200);

		borderTexture = new Texture("artwork/cutscenes/Cutscene_Border.png");

		tickers = new TickerPack();

		reporterBackgroundTexture = new Texture("artwork/ui/staticeffect/GraySquare2.png");

		mapBorder = new Texture("WhiteSquare.png");

		mapX = TornadoGame.screenWidth - tvScreenDimension * 1.5f;
		mapY = tvScreenDimension * 2.2f;
		mapWidth = tvScreenDimension * 1.15f;
		mapHeight = tvScreenDimension * 0.825f;

		animationTexture[0] = new Texture("artwork/tornado/T_01.png");
		animationTexture[1] = new Texture("artwork/tornado/T_02.png");
		animationTexture[2] = new Texture("artwork/tornado/T_03.png");
		animationTexture[3] = new Texture("artwork/tornado/T_04.png");
		animationTexture[4] = new Texture("artwork/tornado/T_05.png");
		animationTexture[5] = new Texture("artwork/tornado/T_06.png");

		textureToDraw = animationTexture[0];

		hasBegunGarbledSpeechAudio = false;
		hasPlayedBeepAudio = false;

		playBreakingNewsAudio = true;

		farmHead[0] = new Texture("artwork/player/heads/farmer/FarmerHead_01.png");
		farmHead[1] = new Texture("artwork/player/heads/farmer/FarmerHead_02.png");
		farmHead[2] = new Texture("artwork/player/heads/farmer/FarmerHead_03.png");

		spaceHead[0] = new Texture("artwork/player/heads/AstronautHead.png");

		beachHead[0] = new Texture("artwork/player/heads/beach/BeachHead_01.png");
		beachHead[1] = new Texture("artwork/player/heads/beach/BeachHead_02.png");
		beachHead[2] = new Texture("artwork/player/heads/beach/BeachHead_03.png");

		arcticHead[0] = new Texture("artwork/player/heads/arctic/ArcticHead_01.png");
		arcticHead[1] = new Texture("artwork/player/heads/arctic/ArcticHead_02.png");
		arcticHead[2] = new Texture("artwork/player/heads/arctic/ArcticHead_03.png");

		hellHead[0] = new Texture("artwork/player/heads/hell/HellHead_01.png");
		hellHead[1] = new Texture("artwork/player/heads/hell/HellHead_02.png");
		hellHead[2] = new Texture("artwork/player/heads/hell/HellHead_03.png");

		cityHead[0] = new Texture("artwork/player/heads/beach/BeachHead_01.png");
		cityHead[1] = new Texture("artwork/player/heads/beach/BeachHead_02.png");
		cityHead[2] = new Texture("artwork/player/heads/beach/BeachHead_03.png");

		desertHead[0] = new Texture("artwork/player/heads/beach/BeachHead_01.png");
		desertHead[1] = new Texture("artwork/player/heads/beach/BeachHead_02.png");
		desertHead[2] = new Texture("artwork/player/heads/beach/BeachHead_03.png");

		forrestHead[0] = new Texture("artwork/player/heads/beach/BeachHead_01.png");
		forrestHead[1] = new Texture("artwork/player/heads/beach/BeachHead_02.png");
		forrestHead[2] = new Texture("artwork/player/heads/beach/BeachHead_03.png");

		trackHead[0] = new Texture("artwork/player/heads/beach/BeachHead_01.png");
		trackHead[1] = new Texture("artwork/player/heads/beach/BeachHead_02.png");
		trackHead[2] = new Texture("artwork/player/heads/beach/BeachHead_03.png");

		endHead[0] = new Texture("artwork/player/heads/beach/BeachHead_01.png");
		endHead[1] = new Texture("artwork/player/heads/beach/BeachHead_02.png");
		endHead[2] = new Texture("artwork/player/heads/beach/BeachHead_03.png");

		kevinBackground = new Texture("artwork/cutscenes/KL_Background_Alt.png");

		maggieWinnerTexture = farmHead[0] = new Texture("artwork/player/heads/farmer/FarmerHead_01.png");

		kevinHead[0] = new Texture("artwork/cutscenes/kevinhead/01.png");
		kevinHead[1] = new Texture("artwork/cutscenes/kevinhead/02.png");
		kevinHead[2] = new Texture("artwork/cutscenes/kevinhead/03.png");
		kevinHead[3] = new Texture("artwork/cutscenes/kevinhead/04.png");

		maggieBackgrounds[MAGGIE_BACKGROUND_FARM] = new Texture("artwork/cutscenes/maggiebackgrounds/MH_Background_Farm.png");
		maggieBackgrounds[MAGGIE_BACKGROUND_SPACE] = new Texture("artwork/cutscenes/maggiebackgrounds/MH_Background_Space.png");
		maggieBackgrounds[MAGGIE_BACKGROUND_BEACH] = new Texture("artwork/cutscenes/maggiebackgrounds/MH_Background_Beach.png");
		maggieBackgrounds[MAGGIE_BACKGROUND_ARCTIC] = new Texture("artwork/cutscenes/maggiebackgrounds/MH_Background_Arctic.png");
		maggieBackgrounds[MAGGIE_BACKGROUND_HELL] = new Texture("artwork/cutscenes/maggiebackgrounds/MH_Background_Hell.png");
		maggieBackgrounds[MAGGIE_BACKGROUND_CITY] = new Texture("artwork/cutscenes/maggiebackgrounds/MH_Background_City.png");
		maggieBackgrounds[MAGGIE_BACKGROUND_DESERT] = new Texture("artwork/cutscenes/maggiebackgrounds/MH_Background_Desert.png");
		maggieBackgrounds[MAGGIE_BACKGROUND_FORREST] = new Texture("artwork/cutscenes/maggiebackgrounds/MH_Background_Forrest.png");
		maggieBackgrounds[MAGGIE_BACKGROUND_TRACK] = new Texture("artwork/cutscenes/maggiebackgrounds/MH_Background_Track.png");
		maggieBackgrounds[MAGGIE_BACKGROUND_END] = new Texture("artwork/cutscenes/maggiebackgrounds/MH_Background_Track.png");
		maggieBackgroundTexture = maggieBackgrounds[MAGGIE_BACKGROUND_FARM];

		maggieAvoid = new Texture("artwork/cutscenes/maggieavoid/MaggieAvoid.png");

		avoidInstructions[MAGGIE_BACKGROUND_FARM] = new Texture("artwork/cutscenes/maggieavoid/AvoidFarm.png");
		avoidInstructions[MAGGIE_BACKGROUND_SPACE] = new Texture("artwork/cutscenes/maggieavoid/AvoidSpace.png");
		avoidInstructions[MAGGIE_BACKGROUND_BEACH] = new Texture("artwork/cutscenes/maggieavoid/AvoidBeach.png");
		avoidInstructions[MAGGIE_BACKGROUND_ARCTIC] = new Texture("artwork/cutscenes/maggieavoid/AvoidArctic.png");
		avoidInstructions[MAGGIE_BACKGROUND_HELL] = new Texture("artwork/cutscenes/maggieavoid/AvoidHell.png");
		avoidInstructions[MAGGIE_BACKGROUND_CITY] = new Texture("artwork/cutscenes/maggieavoid/AvoidCity.png");
		avoidInstructions[MAGGIE_BACKGROUND_DESERT] = new Texture("artwork/cutscenes/maggieavoid/AvoidDesert.png");
		avoidInstructions[MAGGIE_BACKGROUND_FORREST] = new Texture("artwork/cutscenes/maggieavoid/AvoidForrest.png");
		avoidInstructions[MAGGIE_BACKGROUND_TRACK] = new Texture("artwork/cutscenes/maggieavoid/AvoidTrack.png");
		avoidInstructions[MAGGIE_BACKGROUND_END] = new Texture("artwork/cutscenes/maggieavoid/MaggieAvoidEnd.png");
		avoidInstructionTexture = avoidInstructions[MAGGIE_BACKGROUND_FARM];

		// Use this for the swoosh audio to play at the beginning of every cutscene.
		Menu.playStartGameUiSwoosh      = true;
		Menu.hasPlayedStartGameUiSwoosh = false;

		nextLevelBlink = 0;

		breakingNews = new Texture("artwork/cutscenes/BreakingNews_Alt.png");
		breakingNewsTimer = 0;

		transparancy = 0;

		timeanddate[0] = new Texture("artwork/cutscenes/timeanddate/TAndD_Farm.png");
		timeanddate[1] = new Texture("artwork/cutscenes/timeanddate/TAndD_Moon.png");
		timeanddate[2] = new Texture("artwork/cutscenes/timeanddate/TAndD_Beach.png");
		timeanddate[3] = new Texture("artwork/cutscenes/timeanddate/TAndD_Arctic.png");
		timeanddate[4] = new Texture("artwork/cutscenes/timeanddate/TAndD_Hell.png");
		timeanddate[5] = new Texture("artwork/cutscenes/timeanddate/TAndD_City.png");
		timeanddate[6] = new Texture("artwork/cutscenes/timeanddate/TAndD_Desert.png");
		timeanddate[7] = new Texture("artwork/cutscenes/timeanddate/TAndD_Forrest.png");
		timeanddate[8] = new Texture("artwork/cutscenes/timeanddate/TAndD_Track.png");
		timeanddate[9] = new Texture("artwork/cutscenes/timeanddate/TAndD_End.png");

		backgroundWidth     = width;
		backgroundHeight    = height;

		maggieAvoidFlashTimer = 0;
	}

	public boolean isPlayBreakingNewsAudio() {
		return playBreakingNewsAudio;
	}

	public void setPlayBreakingNewsAudio(boolean playBreakingNewsAudio) {
		this.playBreakingNewsAudio = playBreakingNewsAudio;
	}

	public boolean isHasPlayedBeepAudio() {
		return hasPlayedBeepAudio;
	}

	public void setHasPlayedBeepAudio(boolean hasPlayedBeepAudio) {
		this.hasPlayedBeepAudio = hasPlayedBeepAudio;
	}

	public boolean isHasBegunGarbledSpeechAudio() {
		return hasBegunGarbledSpeechAudio;
	}

	public void setHasBegunGarbledSpeechAudio(boolean hasBegunGarbledSpeechAudio) {
		this.hasBegunGarbledSpeechAudio = hasBegunGarbledSpeechAudio;
	}

	public int getCUTSCENE_TIMER_MAX() {
		return CUTSCENE_TIMER_MAX;
	}

	public boolean isShouldDrawDeadScreen() {
		return shouldDrawDeadScreen;
	}

	public void draw(SpriteBatch batch, Player player, Tornado tornado, int level) {
		batch.setColor(1, 1, 1, transparancy);
		if (!cutsceneComplete) {
			batch.draw(cutsceneBackground, x, y, backgroundWidth, backgroundHeight);

			// Gray squares on top and bottom border.
			batch.draw(borderTexture, x, y, width, height);

			// WFFG News Logo
			batch.draw(texture, x, y, width, height);

			// Gray rectangle behind Kevin and Maggie.
			batch.draw(
					reporterBackgroundTexture, 
					kevinScreenX - tvScreenDimension, 
					TornadoGame.screenHeight / 2 - tvScreenDimension / 3, 
					TornadoGame.screenWidth / 1.5f, 
					TornadoGame.screenHeight / 4
					);

			// Set background color for square behind Kevin and Maggie to correspond with level color.
			setBackgroundColorForSqureBehindKevinAndMaggie(batch, level);

			float offset = 50;
			batch.draw(
					reporterBackgroundTexture, 
					kevinScreenX - tvScreenDimension + offset, 
					TornadoGame.screenHeight / 2 - tvScreenDimension / 3 + offset, 
					TornadoGame.screenWidth / 1.5f - offset * 2, 
					TornadoGame.screenHeight / 4 - offset * 2
					);
			batch.setColor(Color.WHITE);

			drawMap(batch, level);

			drawKevinHead(batch);
			drawMaggieHead(batch, level); 

			if (shouldDrawDeadScreen) {
				batch.draw(deadScreenTexture, staticScreenX - tvScreenDimension / 2, screenY, tvScreenDimension, tvScreenDimension);
			} else {
				if (shouldDrawStatic()) {
					for (int i = 0; i < staticEffect.length; i++) {
						staticEffect[i].draw(batch);
					}
				}
			}
			subtitles.draw(batch);
			tickers.draw(batch);

			if (TornadoGame.levelToLoad < LevelHandler.LEVEL_END) {
				drawMaggieAvoid(batch, level);
			}

			// Breaking news flashing red banner.
			if (level == LevelHandler.LEVEL_END) { 
				if (breakingNewsTimer < BREAKING_NEWS_MAX_VALUE / 2) {
					batch.draw(breakingNews, x, y, width, height); 
				}
			}

			drawTimeAndDate(batch, level);
		}
		batch.setColor(Color.WHITE);

		handleStarsShining();
	}

	private void drawMaggieAvoid(SpriteBatch batch, int level) {
		maggieAvoidFlashTimer++;
		if (maggieAvoidFlashTimer > 20) {
			maggieAvoidFlashTimer = 0;
		}
		switch (level) {
		case LevelHandler.LEVEL_FARM:
			avoidInstructionTexture = avoidInstructions[MAGGIE_BACKGROUND_FARM];
			break;
		case LevelHandler.LEVEL_SPACE:
			avoidInstructionTexture = avoidInstructions[MAGGIE_BACKGROUND_SPACE];
			break;
		case LevelHandler.LEVEL_BEACH:
			avoidInstructionTexture = avoidInstructions[MAGGIE_BACKGROUND_BEACH];
			break;
		case LevelHandler.LEVEL_ARCTIC:
			avoidInstructionTexture = avoidInstructions[MAGGIE_BACKGROUND_ARCTIC];
			break;
		case LevelHandler.LEVEL_HELL:
			avoidInstructionTexture = avoidInstructions[MAGGIE_BACKGROUND_HELL];
			break;
		case LevelHandler.LEVEL_CITY:
			avoidInstructionTexture = avoidInstructions[MAGGIE_BACKGROUND_CITY];
			break;
		case LevelHandler.LEVEL_DESERT:
			avoidInstructionTexture = avoidInstructions[MAGGIE_BACKGROUND_DESERT];
			break;
		case LevelHandler.LEVEL_FORREST:
			avoidInstructionTexture = avoidInstructions[MAGGIE_BACKGROUND_FORREST];
			break;
		case LevelHandler.LEVEL_TRACK:
			avoidInstructionTexture = avoidInstructions[MAGGIE_BACKGROUND_TRACK];
			break;
		case LevelHandler.LEVEL_END:
			avoidInstructionTexture = avoidInstructions[MAGGIE_BACKGROUND_END];
			break;
		}
		// Make it flash.
		if (maggieAvoidFlashTimer < 10) {
			batch.draw(maggieAvoid, x, y, width, height);
			batch.draw(avoidInstructionTexture, x, y, width, height);
		}
	}

	private void setBackgroundColorForSqureBehindKevinAndMaggie(SpriteBatch batch, int level) {
		switch (level) {
		case LevelHandler.LEVEL_FARM:
			batch.setColor(Color.GREEN);
			break;
		case LevelHandler.LEVEL_SPACE:
			batch.setColor(Color.GRAY);
			break;
		case LevelHandler.LEVEL_BEACH:
			batch.setColor(Color.YELLOW);
			break;
		case LevelHandler.LEVEL_ARCTIC:
			batch.setColor(Color.WHITE);
			break;
		case LevelHandler.LEVEL_HELL:
			batch.setColor(Color.RED);
			break;
		case LevelHandler.LEVEL_CITY:
			batch.setColor(Color.DARK_GRAY);
			break;
		case LevelHandler.LEVEL_DESERT:
			batch.setColor(Color.YELLOW);
			break;
		case LevelHandler.LEVEL_FORREST:
			batch.setColor(Color.GREEN);
			break;
		case LevelHandler.LEVEL_TRACK:
			batch.setColor(Color.DARK_GRAY);
			break;
		case LevelHandler.LEVEL_END:
			batch.setColor(Color.DARK_GRAY);
			break;
		}
	}

	private void drawTimeAndDate(SpriteBatch batch, int level) {
		switch (level) {
		case LevelHandler.LEVEL_FARM:
			batch.draw(timeanddate[0], x, y, width, height);
			break;
		case LevelHandler.LEVEL_SPACE:
			batch.draw(timeanddate[1], x, y, width, height);
			break;
		case LevelHandler.LEVEL_BEACH:
			batch.draw(timeanddate[2], x, y, width, height);
			break;
		case LevelHandler.LEVEL_ARCTIC:
			batch.draw(timeanddate[3], x, y, width, height);
			break;
		case LevelHandler.LEVEL_HELL:
			batch.draw(timeanddate[4], x, y, width, height);
			break;
		case LevelHandler.LEVEL_CITY:
			batch.draw(timeanddate[5], x, y, width, height);
			break;
		case LevelHandler.LEVEL_DESERT:
			batch.draw(timeanddate[6], x, y, width, height);
			break;
		case LevelHandler.LEVEL_FORREST:
			batch.draw(timeanddate[7], x, y, width, height);
			break;
		case LevelHandler.LEVEL_TRACK:
			batch.draw(timeanddate[8], x, y, width, height);
			break;
		case LevelHandler.LEVEL_END:
			batch.draw(timeanddate[9], x, y, width, height);
			break;
		}
	}

	private void handleBreakingNewsBlinkTimer() {
		breakingNewsTimer++;
		if (breakingNewsTimer > BREAKING_NEWS_MAX_VALUE) {
			breakingNewsTimer = 0;
		}
	}

	private void drawKevinHead(SpriteBatch batch) {
		if (!shouldDrawDeadScreen) {
			if (maggieTimer < 10) {
				kevinTexture = kevinHead[0];
			}
			else if (maggieTimer >= 10 && maggieTimer < 20) {
				kevinTexture = kevinHead[1];
			}
			else {
				kevinTexture = kevinHead[2];
			}
		} else {
			kevinTexture = kevinHead[3];
		}
		batch.draw(kevinBackground, kevinScreenX - tvScreenDimension / 2, screenY, tvScreenDimension, tvScreenDimension);
		batch.draw(kevinTexture, kevinScreenX - tvScreenDimension / 2, screenY, tvScreenDimension, tvScreenDimension);
	}

	private void drawMaggieHead(SpriteBatch batch, int level) {

		maggieTimer++;
		if (maggieTimer > 30) {
			maggieTimer = 0;
		}

		switch (level) {
		case LevelHandler.LEVEL_FARM:
			maggieBackgroundTexture = maggieBackgrounds[MAGGIE_BACKGROUND_FARM];
			if (maggieTimer < 10) {
				maggieTexture = farmHead[0];
			}
			else if (maggieTimer >= 10 && maggieTimer < 20) {
				maggieTexture = farmHead[1];
			}
			else {
				maggieTexture = farmHead[2];
			}
			break;
		case LevelHandler.LEVEL_SPACE:
			maggieBackgroundTexture = maggieBackgrounds[MAGGIE_BACKGROUND_SPACE];
			maggieTexture = spaceHead[0];
			break;
		case LevelHandler.LEVEL_BEACH:
			maggieBackgroundTexture = maggieBackgrounds[MAGGIE_BACKGROUND_BEACH];
			if (maggieTimer < 10) {
				maggieTexture = beachHead[0];
			}
			else if (maggieTimer >= 10 && maggieTimer < 20) {
				maggieTexture = beachHead[1];
			}
			else {
				maggieTexture = beachHead[2];
			}
			break;
		case LevelHandler.LEVEL_ARCTIC:
			maggieBackgroundTexture = maggieBackgrounds[MAGGIE_BACKGROUND_ARCTIC];
			if (maggieTimer < 10) {
				maggieTexture = arcticHead[0];
			}
			else if (maggieTimer >= 10 && maggieTimer < 20) {
				maggieTexture = arcticHead[1];
			}
			else {
				maggieTexture = arcticHead[2];
			}
			break;
		case LevelHandler.LEVEL_HELL:
			maggieBackgroundTexture = maggieBackgrounds[MAGGIE_BACKGROUND_HELL];
			if (maggieTimer < 10) {
				maggieTexture = hellHead[0];
			}
			else if (maggieTimer >= 10 && maggieTimer < 20) {
				maggieTexture = hellHead[1];
			}
			else {
				maggieTexture = hellHead[2];
			}
			break;
		case LevelHandler.LEVEL_CITY:
			maggieBackgroundTexture = maggieBackgrounds[MAGGIE_BACKGROUND_CITY];
			if (maggieTimer < 10) {
				maggieTexture = cityHead[0];
			}
			else if (maggieTimer >= 10 && maggieTimer < 20) {
				maggieTexture = cityHead[1];
			}
			else {
				maggieTexture = cityHead[2];
			}
			break;
		case LevelHandler.LEVEL_DESERT:
			maggieBackgroundTexture = maggieBackgrounds[MAGGIE_BACKGROUND_DESERT];
			if (maggieTimer < 10) {
				maggieTexture = desertHead[0];
			}
			else if (maggieTimer >= 10 && maggieTimer < 20) {
				maggieTexture = desertHead[1];
			}
			else {
				maggieTexture = desertHead[2];
			}
			break;
		case LevelHandler.LEVEL_FORREST:
			maggieBackgroundTexture = maggieBackgrounds[MAGGIE_BACKGROUND_FORREST];
			if (maggieTimer < 10) {
				maggieTexture = forrestHead[0];
			}
			else if (maggieTimer >= 10 && maggieTimer < 20) {
				maggieTexture = forrestHead[1];
			}
			else {
				maggieTexture = forrestHead[2];
			}
			break;
		case LevelHandler.LEVEL_TRACK:
			maggieBackgroundTexture = maggieBackgrounds[MAGGIE_BACKGROUND_TRACK];
			if (maggieTimer < 10) {
				maggieTexture = trackHead[0];
			}
			else if (maggieTimer >= 10 && maggieTimer < 20) {
				maggieTexture = trackHead[1];
			}
			else {
				maggieTexture = trackHead[2];
			}
			break;
		case LevelHandler.LEVEL_END:
			maggieBackgroundTexture = maggieBackgrounds[MAGGIE_BACKGROUND_END];
			if (maggieTimer < 10) {
				maggieTexture = endHead[0];
			}
			else if (maggieTimer >= 10 && maggieTimer < 20) {
				maggieTexture = endHead[1];
			}
			else {
				maggieTexture = endHead[2];
			}
			break;
		}

		float x = staticScreenX - tvScreenDimension / 2;
		float y = screenY;
		float width = tvScreenDimension;
		float height = tvScreenDimension;
		batch.draw(maggieBackgroundTexture, x, y, width, height);
		batch.draw(maggieTexture, x + 25, y - 25, width - 50, height - 25);
	}

	public boolean shouldDrawStatic() {
		return subtitles.getTimer() > SubtitlePack.SUBTITLE_DISPLAY_LENGTH * 3;
	}

	private void drawMap(SpriteBatch batch, int level) {
		float offset = 20;
		batch.draw(mapBorder, mapX - offset, mapY - offset, mapWidth + offset * 2, mapHeight + offset * 2);
		batch.draw(map, mapX, mapY, mapWidth, mapHeight);

		drawNextLevelBlinking(batch, level);
		drawWinners(batch);
	}

	private void drawNextLevelBlinking(SpriteBatch batch, int level) {
		if (nextLevelBlink < NEXT_LEVEL_BLINK_VALUE / 2) {
			switch (level) {
			case LevelHandler.LEVEL_FARM:
				batch.draw(mapFarmBlink, mapX, mapY, mapWidth, mapHeight);
				break;
			case LevelHandler.LEVEL_SPACE:
				batch.draw(mapSpaceBlink, mapX, mapY, mapWidth, mapHeight);
				break;
			case LevelHandler.LEVEL_BEACH:
				batch.draw(mapBeachBlink, mapX, mapY, mapWidth, mapHeight);
				break;
			case LevelHandler.LEVEL_ARCTIC:
				batch.draw(mapArcticBlink, mapX, mapY, mapWidth, mapHeight);
				break;
			case LevelHandler.LEVEL_HELL:
				batch.draw(mapHellBlink, mapX, mapY, mapWidth, mapHeight);
				break;
			case LevelHandler.LEVEL_CITY:
				batch.draw(mapCityBlink, mapX, mapY, mapWidth, mapHeight);
				break;
			case LevelHandler.LEVEL_DESERT:
				batch.draw(mapDesertBlink, mapX, mapY, mapWidth, mapHeight);
				break;
			case LevelHandler.LEVEL_FORREST:
				batch.draw(mapForrestBlink, mapX, mapY, mapWidth, mapHeight);
				break;
			case LevelHandler.LEVEL_TRACK:
				batch.draw(mapTrackBlink, mapX, mapY, mapWidth, mapHeight);
				break;
			case LevelHandler.LEVEL_END:
				batch.draw(mapTrackBlink, mapX, mapY, mapWidth, mapHeight);
				break;
			}
		}
	}

	private void drawWinners(SpriteBatch batch) {
		drawFarmWinner(batch, Tornado.hasWonFarmLevel, Player.hasWonFarmLevel);
		drawSpaceWinner(batch, Tornado.hasWonSpaceLevel, Player.hasWonSpaceLevel);
		drawBeachWinner(batch, Tornado.hasWonBeachLevel, Player.hasWonBeachLevel);
		drawArcticWinner(batch, Tornado.hasWonArcticLevel, Player.hasWonArcticLevel);
		drawHellWinner(batch, Tornado.hasWonHellLevel, Player.hasWonHellLevel);
		drawCityWinner(batch, Tornado.hasWonCityLevel, Player.hasWonCityLevel);
		drawDesertWinner(batch, Tornado.hasWonDesertLevel, Player.hasWonDesertLevel);
		drawForrestWinner(batch, Tornado.hasWonForrestLevel, Player.hasWonForrestLevel);
		drawTrackWinner(batch, Tornado.hasWonTrackLevel, Player.hasWonTrackLevel);
	}

	private void drawTrackWinner(SpriteBatch batch, boolean winnerTornado, boolean winnerPlayer) {
		if (winnerTornado) {
			batch.draw(mapTrack, mapX, mapY, mapWidth, mapHeight);
			batch.draw(textureToDraw, mapX + mapWidth - winnerIconSize - 150f, mapY + mapHeight - winnerIconSize - 250f, winnerIconSize, winnerIconSize);
		}
		if (winnerPlayer) {
			batch.draw(mapTrack, mapX, mapY, mapWidth, mapHeight);
			drawMaggieWinnerHeadIcon(batch, LevelHandler.LEVEL_DESERT, mapX + mapWidth - winnerIconSize - 150f, mapY + mapHeight - winnerIconSize - 250f);
		}
	}

	private void drawForrestWinner(SpriteBatch batch, boolean winnerTornado, boolean winnerPlayer) {
		if (winnerTornado) {
			batch.draw(mapWoods, mapX, mapY, mapWidth, mapHeight);
			batch.draw(textureToDraw, mapX + mapWidth - winnerIconSize - 160f, mapY + mapHeight - winnerIconSize - 100f, winnerIconSize, winnerIconSize);
		}
		if (winnerPlayer) {
			batch.draw(mapWoods, mapX, mapY, mapWidth, mapHeight);
			drawMaggieWinnerHeadIcon(batch, LevelHandler.LEVEL_DESERT, mapX + mapWidth - winnerIconSize - 160f, mapY + mapHeight - winnerIconSize - 100f);
		}
	}

	private void drawDesertWinner(SpriteBatch batch, boolean winnerTornado, boolean winnerPlayer) {
		if (winnerTornado) {
			batch.draw(mapDesert, mapX, mapY, mapWidth, mapHeight);
			batch.draw(textureToDraw, mapX + mapWidth - winnerIconSize + 25f, mapY + mapHeight - winnerIconSize - 255f, winnerIconSize, winnerIconSize);
		}
		if (winnerPlayer) {
			batch.draw(mapDesert, mapX, mapY, mapWidth, mapHeight);
			drawMaggieWinnerHeadIcon(batch, LevelHandler.LEVEL_DESERT, mapX + mapWidth - winnerIconSize + 25f, mapY + mapHeight - winnerIconSize - 255f);
		}
	}

	private void drawCityWinner(SpriteBatch batch, boolean winnerTornado, boolean winnerPlayer) {
		if (winnerTornado) {
			batch.draw(mapCity, mapX, mapY, mapWidth, mapHeight);
			batch.draw(textureToDraw, mapX + mapWidth - winnerIconSize - 235f, mapY + mapHeight - winnerIconSize - 125f, winnerIconSize, winnerIconSize);
		}
		if (winnerPlayer) {
			batch.draw(mapCity, mapX, mapY, mapWidth, mapHeight);
			drawMaggieWinnerHeadIcon(batch, LevelHandler.LEVEL_CITY, mapX + mapWidth - winnerIconSize - 235f, mapY + mapHeight - winnerIconSize - 125f);
		}
	}

	private void drawHellWinner(SpriteBatch batch, boolean winnerTornado, boolean winnerPlayer) {
		if (winnerTornado) {
			batch.draw(mapHell, mapX, mapY, mapWidth, mapHeight);
			batch.draw(textureToDraw, mapX + mapWidth - winnerIconSize + 20f, mapY + mapHeight - winnerIconSize - 375f, winnerIconSize, winnerIconSize);
		}
		if (winnerPlayer) {
			batch.draw(mapHell, mapX, mapY, mapWidth, mapHeight);
			drawMaggieWinnerHeadIcon(batch, LevelHandler.LEVEL_HELL, mapX + mapWidth - winnerIconSize + 20f, mapY + mapHeight - winnerIconSize - 375f);
		}
	}

	private void drawArcticWinner(SpriteBatch batch, boolean winnerTornado, boolean winnerPlayer) {
		if (winnerTornado) {
			batch.draw(mapArctic, mapX, mapY, mapWidth, mapHeight);
			batch.draw(textureToDraw, mapX + mapWidth - winnerIconSize - 0f, mapY + mapHeight - winnerIconSize - 150f, winnerIconSize, winnerIconSize);
		}
		if (winnerPlayer) {
			batch.draw(mapArctic, mapX, mapY, mapWidth, mapHeight);
			drawMaggieWinnerHeadIcon(batch, LevelHandler.LEVEL_ARCTIC, mapX + mapWidth - winnerIconSize, mapY + mapHeight - winnerIconSize - 150f);
		}
	}

	private void drawBeachWinner(SpriteBatch batch, boolean winnerTornado, boolean winnerPlayer) {
		if (winnerTornado) {
			batch.draw(mapBeach, mapX, mapY, mapWidth, mapHeight);
			batch.draw(textureToDraw, mapX + mapWidth - winnerIconSize - 300f, mapY + mapHeight - winnerIconSize - 225f, winnerIconSize, winnerIconSize);
		}
		if (winnerPlayer) {
			batch.draw(mapBeach, mapX, mapY, mapWidth, mapHeight);
			drawMaggieWinnerHeadIcon(batch, LevelHandler.LEVEL_BEACH, mapX + mapWidth - winnerIconSize - 300f, mapY + mapHeight - winnerIconSize - 225f);
		}
	}

	private void drawSpaceWinner(SpriteBatch batch, boolean winnerTornado, boolean winnerPlayer) {
		if (winnerTornado) {
			batch.draw(mapSpace, mapX, mapY, mapWidth, mapHeight);
			batch.draw(textureToDraw, mapX + mapWidth - winnerIconSize - 40f, mapY + mapHeight - winnerIconSize - 30f, winnerIconSize, winnerIconSize);
		}
		if (winnerPlayer) {
			batch.draw(mapSpace, mapX, mapY, mapWidth, mapHeight);
			drawMaggieWinnerHeadIcon(batch, LevelHandler.LEVEL_SPACE, mapX + mapWidth - winnerIconSize - 40f, mapY + mapHeight - winnerIconSize - 30f); 
		}
	}

	private void drawFarmWinner(SpriteBatch batch, boolean winnerTornado, boolean winnerPlayer) {
		if (winnerTornado) {
			batch.draw(mapFarm, mapX, mapY, mapWidth, mapHeight);
			batch.draw(textureToDraw, mapX + mapWidth - winnerIconSize * 2f, mapY + winnerIconSize / 2 - 60, winnerIconSize, winnerIconSize);
		}
		if (winnerPlayer) {
			batch.draw(mapFarm, mapX, mapY, mapWidth, mapHeight);
			drawMaggieWinnerHeadIcon(batch, LevelHandler.LEVEL_FARM, mapX + mapWidth - winnerIconSize * 2f, mapY + winnerIconSize / 2 - 60);
		}
	}

	private void drawMaggieWinnerHeadIcon(SpriteBatch batch, int level, float x, float y) {
		if (maggieTimer < 10) {
			if (level == LevelHandler.LEVEL_FARM) {
				maggieWinnerTexture = farmHead[0];
			}
			else if (level == LevelHandler.LEVEL_SPACE) {
				maggieWinnerTexture = spaceHead[0];
			}
			else if (level == LevelHandler.LEVEL_BEACH) {
				maggieWinnerTexture = beachHead[0];
			}
			else if (level == LevelHandler.LEVEL_ARCTIC) {
				maggieWinnerTexture = arcticHead[0];
			}
			else if (level == LevelHandler.LEVEL_HELL) {
				maggieWinnerTexture = hellHead[0];
			}
			else if (level == LevelHandler.LEVEL_CITY) {
				maggieWinnerTexture = cityHead[0];
			}
			else if (level == LevelHandler.LEVEL_DESERT) {
				maggieWinnerTexture = desertHead[0];
			}
			else if (level == LevelHandler.LEVEL_FORREST) {
				maggieWinnerTexture = forrestHead[0];
			}
			else if (level == LevelHandler.LEVEL_TRACK) {
				maggieWinnerTexture = trackHead[0];
			}
		}
		else if (maggieTimer >= 10 && maggieTimer < 20) {
			if (level == LevelHandler.LEVEL_FARM) {
				maggieWinnerTexture = farmHead[1];
			}
			else if (level == LevelHandler.LEVEL_SPACE) {
				maggieWinnerTexture = spaceHead[0];
			}
			else if (level == LevelHandler.LEVEL_BEACH) {
				maggieWinnerTexture = beachHead[1];
			}
			else if (level == LevelHandler.LEVEL_ARCTIC) {
				maggieWinnerTexture = arcticHead[1];
			}
			else if (level == LevelHandler.LEVEL_HELL) {
				maggieWinnerTexture = hellHead[1];
			}
			else if (level == LevelHandler.LEVEL_CITY) {
				maggieWinnerTexture = cityHead[1];
			}
			else if (level == LevelHandler.LEVEL_DESERT) {
				maggieWinnerTexture = desertHead[1];
			}
			else if (level == LevelHandler.LEVEL_FORREST) {
				maggieWinnerTexture = forrestHead[1];
			}
			else if (level == LevelHandler.LEVEL_TRACK) {
				maggieWinnerTexture = trackHead[1];
			}
		}
		else {
			if (level == LevelHandler.LEVEL_FARM) {
				maggieWinnerTexture = farmHead[2];
			}
			else if (level == LevelHandler.LEVEL_SPACE) {
				maggieWinnerTexture = spaceHead[0];
			}
			else if (level == LevelHandler.LEVEL_BEACH) {
				maggieWinnerTexture = beachHead[2];
			}
			else if (level == LevelHandler.LEVEL_ARCTIC) {
				maggieWinnerTexture = arcticHead[2];
			}
			else if (level == LevelHandler.LEVEL_HELL) {
				maggieWinnerTexture = hellHead[2];
			}
			else if (level == LevelHandler.LEVEL_CITY) {
				maggieWinnerTexture = cityHead[2];
			}
			else if (level == LevelHandler.LEVEL_DESERT) {
				maggieWinnerTexture = desertHead[2];
			}
			else if (level == LevelHandler.LEVEL_FORREST) {
				maggieWinnerTexture = forrestHead[2];
			}
			else if (level == LevelHandler.LEVEL_TRACK) {
				maggieWinnerTexture = trackHead[2];
			}
		}
		batch.draw(maggieWinnerTexture, x, y, winnerIconSize, winnerIconSize);
	}

	public void setCutsceneComplete(boolean cutsceneComplete) {
		this.cutsceneComplete = cutsceneComplete;
	}

	public void update() {
		if (!cutsceneComplete) {
			for (int i = 0; i < staticEffect.length; i++) {
				staticEffect[i].update();
			}
			handleDeadScreenTimer(); 
			subtitles.update();
			tickers.update();
			handleAnimation();
			handleNextLevelBlinkTimer();
			handleBreakingNewsBlinkTimer();

			transparancy += .02f;
		} 
	}

	private void handleNextLevelBlinkTimer() {
		nextLevelBlink++;
		if (nextLevelBlink > NEXT_LEVEL_BLINK_VALUE) {
			nextLevelBlink = 0;
		}
	}

	private void handleDeadScreenTimer() {
		deadScreenTimer++;
		if (deadScreenTimer > SubtitlePack.SUBTITLE_DISPLAY_LENGTH * 5) {
			shouldDrawDeadScreen = true;
		}
	}

	public boolean isCutsceneComplete() {
		return cutsceneComplete;
	}

	public static void dispose() {
		for (int i = 0; i < timeanddate.length; i++) {
			timeanddate[i].dispose();
		}
		breakingNews.dispose();
		deadScreenTexture.dispose();
		kevinTexture.dispose();
		maggieTexture.dispose();
		borderTexture.dispose();
		reporterBackgroundTexture.dispose();
		map.dispose();
		mapFarm.dispose();
		mapSpace.dispose();
		mapBeach.dispose();
		mapCity.dispose();
		mapHell.dispose();
		mapDesert.dispose();
		mapArctic.dispose();
		mapWoods.dispose();
		mapTrack.dispose();
		mapFarmBlink.dispose();
		mapSpaceBlink.dispose();
		mapBeachBlink.dispose();
		mapArcticBlink.dispose();
		mapHellBlink.dispose();
		mapCityBlink.dispose();
		mapDesertBlink.dispose();
		mapForrestBlink.dispose();
		mapTrackBlink.dispose();
		cutsceneBackground.dispose();
		mapBorder.dispose();
		spaceHead[0].dispose();
		for (int i = 0; i < farmHead.length; i++) {
			farmHead[i].dispose();
			beachHead[i].dispose();
			arcticHead[i].dispose();
			hellHead[i].dispose();
			cityHead[i].dispose();
			desertHead[i].dispose();
			forrestHead[i].dispose();
			trackHead[i].dispose();
			endHead[i].dispose();
		}
		kevinBackground.dispose();
		maggieWinnerTexture.dispose();
		for (int i = 0; i < kevinHead.length; i++) {
			kevinHead[i].dispose();
		}
		maggieBackgroundTexture.dispose();

		for (int i = 0; i < maggieBackgrounds.length; i++) {
			maggieBackgrounds[i].dispose();
		}
		maggieAvoid.dispose();
		for (int i = 0; i < avoidInstructions.length; i++) {
			avoidInstructions[i].dispose();
		}
		avoidInstructionTexture.dispose();
		disposeStaticEffectTextures();
	}

	private static void disposeStaticEffectTextures() {
		for (int i = 0; i < staticEffect.length; i++) {
			if (staticEffect[i] != null) {
				staticEffect[i].getTexture().dispose();
			}
		}
	}
}
