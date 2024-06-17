package com.tornadogame.handlers.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.tornadogame.TornadoGame;
import com.tornadogame.audio.Mixer;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.powerups.SpeedBoost;
import com.tornadogame.handlers.LevelHandler;
import com.tornadogame.levels.Level;

public class MusicHandler {

	// Menu audio.
	private Music theme;

	// Cutscene audio.
	private Music staticOne;
	//private Music staticTwo;

	// Level audio.
	private Music maggieBanter;
	private Music speedBoost;
	private Music recordScratch;

	// Level music.
	private Music levelMusic;
	private Music bizzarri;
	private Music letItBurn;
	private Music pipein;
	private Music snorkel;
	private Music tardy;
	private Music cantStopUsNow;
	private Music twoNightsToCall;
	private Music reggaeFusion;
	private Music trackSong;
	private Music citySong;
	private Music desertSong;
	private Music forrestSong;
	private Music progressBackwards;
	private Music panicAtTheGroceryStore;
	private Music polka;
	
	// End game stinger.
	private Music endGameStinger;
	private boolean hasPlayedEndGameStinger;

	public MusicHandler() {
		
		/*
		 * Create audio files.
		 */
		// Menu audio.
		theme = Gdx.audio.newMusic(Gdx.files.internal("audio/music/menu/EarlyMillenials.ogg"));

		// Cutscene audio.
		staticOne = Gdx.audio.newMusic(Gdx.files.internal("audio/music/cutscene/tv_static.ogg"));
		//staticTwo = Gdx.audio.newMusic(Gdx.files.internal("audio/music/cutscene/Static2.ogg"));

		// Level audio.
		maggieBanter = Gdx.audio.newMusic(Gdx.files.internal("audio/music/level/PassObstacle.ogg"));
		speedBoost = Gdx.audio.newMusic(Gdx.files.internal("audio/music/level/Vaccum.ogg"));
		recordScratch = Gdx.audio.newMusic(Gdx.files.internal("audio/sound/level/RecordScratch.wav"));

		// Level music.
		bizzarri = Gdx.audio.newMusic(Gdx.files.internal("audio/music/level/songs/Bizzarri.ogg"));
		letItBurn = Gdx.audio.newMusic(Gdx.files.internal("audio/music/level/songs/LetItBurn.ogg"));
		pipein = Gdx.audio.newMusic(Gdx.files.internal("audio/music/level/songs/Pipein.ogg"));
		snorkel = Gdx.audio.newMusic(Gdx.files.internal("audio/music/level/songs/SnorkelingForClowns.ogg"));
		tardy = Gdx.audio.newMusic(Gdx.files.internal("audio/music/level/songs/WhereIsTheTardy.ogg"));
		cantStopUsNow = Gdx.audio.newMusic(Gdx.files.internal("audio/music/level/songs/CantStopUsNow.mp3"));
		twoNightsToCall = Gdx.audio.newMusic(Gdx.files.internal("audio/music/level/songs/TwoNightsToCall.mp3"));
		reggaeFusion = Gdx.audio.newMusic(Gdx.files.internal("audio/music/level/songs/ReggaeFusion.ogg"));
		//trackSong = Gdx.audio.newMusic(Gdx.files.internal("audio/music/level/songs/10_13_02.ogg"));
		citySong = Gdx.audio.newMusic(Gdx.files.internal("audio/music/level/songs/citysong.ogg"));
		desertSong = Gdx.audio.newMusic(Gdx.files.internal("audio/music/level/songs/desertsong.ogg"));
		forrestSong = Gdx.audio.newMusic(Gdx.files.internal("audio/music/level/songs/forrestsong.ogg"));
		trackSong = Gdx.audio.newMusic(Gdx.files.internal("audio/music/level/songs/tracksong.ogg"));
		progressBackwards = Gdx.audio.newMusic(Gdx.files.internal("audio/music/level/songs/progressbackwards.ogg"));
		panicAtTheGroceryStore = Gdx.audio.newMusic(Gdx.files.internal("audio/music/level/songs/PanicAtTheGroceryStore.ogg"));
		polka = Gdx.audio.newMusic(Gdx.files.internal("audio/music/level/songs/PolkaBrothersDiscoSmash.ogg"));
		levelMusic = bizzarri;
		
		// End game stinger.
		endGameStinger = Gdx.audio.newMusic(Gdx.files.internal("audio/music/endgamestinger/Bomb.wav"));
		hasPlayedEndGameStinger = false;
		
		/**
		 * Set volume levels.
		 */
		// Menu music.
		theme.setVolume(Mixer.THEME_VOLUME);
		
		// Level music.
		pipein.setVolume(Mixer.LEVEL_VOLUME_PIPEIN);
		letItBurn.setVolume(Mixer.LEVEL_VOLUME_LETITBURN);
		snorkel.setVolume(Mixer.LEVEL_VOLUME_SNORKELING);
		bizzarri.setVolume(Mixer.LEVEL_VOLUME_BIZZARRI);
		tardy.setVolume(Mixer.LEVEL_VOLUME_TARDY);
		cantStopUsNow.setVolume(Mixer.LEVEL_VOLUME_CITY);
		citySong.setVolume(Mixer.LEVEL_VOLUME_CITY);
		twoNightsToCall.setVolume(Mixer.LEVEL_VOLUME_DESERT);
		desertSong.setVolume(Mixer.LEVEL_VOLUME_DESERT);
		reggaeFusion.setVolume(Mixer.LEVEL_VOLUME_FORREST);
		forrestSong.setVolume(Mixer.LEVEL_VOLUME_FORREST);
		polka.setVolume(Mixer.LEVEL_VOLUME_FORREST);
		trackSong.setVolume(Mixer.LEVEL_VOLUME_TRACK);
		progressBackwards.setVolume(Mixer.LEVEL_VOLUME_PROGRESS_BACKWARDS);
		panicAtTheGroceryStore.setVolume(Mixer.LEVEL_VOLUME_PROGRESS_BACKWARDS);
		
		// Level SFX.
		maggieBanter.setVolume(Mixer.LEVEL_VOLUME_MAGGIE_BANTER);
		speedBoost.setVolume(Mixer.LEVEL_VOLUME_SPEED_BOOST);
		recordScratch.setVolume(Mixer.LEVEL_VOLUME_RECORD_SCRATCH);
		
		// Cutscene SFX.
		staticOne.setVolume(Mixer.CUTSCENE_VOLUME_STATIC_ONE);
		//staticTwo.setVolume(Mixer.CUTSCENE_VOLUME_STATIC_TWO);
		
		// End game stinger.
		endGameStinger.setVolume(Mixer.LEVEL_VOLUME_END_GAME_STINGER);
	}

	public void dispose() {
		// Menu audio.
		theme.dispose();

		// Cutscene audio.
		staticOne.dispose();
		//staticTwo.dispose();

		// Level audio.
		maggieBanter.dispose();
		speedBoost.dispose();
		recordScratch.dispose();

		// Level music.
		bizzarri.dispose();
		letItBurn.dispose();
		pipein.dispose();
		snorkel.dispose();
		tardy.dispose();
		cantStopUsNow.dispose();
		twoNightsToCall.dispose();
		reggaeFusion.dispose();
		trackSong.dispose();
		citySong.dispose();
		desertSong.dispose();
		forrestSong.dispose();
		progressBackwards.dispose();
		panicAtTheGroceryStore.dispose();
		polka.dispose();
		
		// End game stinger.
		endGameStinger.dispose();
	}

	public void handleAudio(Level level, Player player, int currentLevel) {
		if (!TornadoGame.shouldStartGameplay && TornadoGame.splashScreenHasEnded) {
			theme.play();
		} else {
			theme.stop();
		}

		if (!level.getCutscene().isCutsceneComplete()) {
			handleCutsceneMusic(level);
		} else {	
			if (TornadoGame.levelToLoad <= LevelHandler.LEVEL_END) { 
				handleLevelMusic(level, player, currentLevel);
			} else {
				handleSlamAudio();
			}
		}
	}
	
	private void handleSlamAudio() {
		if (!hasPlayedEndGameStinger) {
			endGameStinger.play();
			hasPlayedEndGameStinger = true;
		}
	}

	private void handleCutsceneMusic(Level level) {
		if (level.getCutscene().shouldDrawStatic() && !level.getCutscene().isShouldDrawDeadScreen()) {
			staticOne.play();
			//staticTwo.play();
			// Don't play pass obstacle audio during cutscene.
		} else {
			staticOne.stop();
			//staticTwo.stop();
		}
	}

	private void handleLevelMusic(Level level, Player player, int currentLevel) {

		switch (currentLevel) {
		case LevelHandler.LEVEL_FARM:
			levelMusic = panicAtTheGroceryStore;
			break;
		case LevelHandler.LEVEL_SPACE:
			levelMusic = bizzarri;
			break;
		case LevelHandler.LEVEL_BEACH:
			levelMusic = snorkel;
			break;
		case LevelHandler.LEVEL_ARCTIC:
			levelMusic = letItBurn;
			break;
		case LevelHandler.LEVEL_HELL:
			levelMusic = tardy;
			break;
		case LevelHandler.LEVEL_CITY:
			levelMusic = pipein;
			break;
		case LevelHandler.LEVEL_DESERT:
			levelMusic = progressBackwards;
			break;
		case LevelHandler.LEVEL_FORREST:
			levelMusic = polka;
			break;
		case LevelHandler.LEVEL_TRACK:
			levelMusic = trackSong;
			break;
		case LevelHandler.LEVEL_END:
			levelMusic = trackSong;
			break;
		}

		maggieBanter.play();
		levelMusic.play();

		if (level.isLevelIsOver()) {
			// Stop level music.
			if (levelMusic.isPlaying()) {
				levelMusic.stop();
			}

			// Stop Maggie talking.
			maggieBanter.stop();
		}

		if (player.isHasSpeedBoost()) {
			if (SpeedBoost.playAudio) {
				speedBoost.setVolume(1);
				speedBoost.play();
				recordScratch.play();
				SpeedBoost.playAudio = false;
			}
		} else {
			speedBoost.stop();
		}
	}
}
