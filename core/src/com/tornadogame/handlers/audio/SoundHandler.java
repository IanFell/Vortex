package com.tornadogame.handlers.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.tornadogame.TornadoGame;
import com.tornadogame.audio.Mixer;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.gameobjects.weapons.ShrapnelDrop;
import com.tornadogame.handlers.LevelHandler;
import com.tornadogame.handlers.ObstacleHandler;
import com.tornadogame.handlers.ShrapnelDropHandler;
import com.tornadogame.helpers.RandomNumberGenerator;
import com.tornadogame.levels.Level;
import com.tornadogame.obstacles.Obstacle;
import com.tornadogame.ui.Countdown;
import com.tornadogame.ui.menu.Menu;

public class SoundHandler {

	private final int SUCK_01 = 0;
	private final int SUCK_02 = 1;
	private final int SUCK_03 = 2;

	private final int WOW = 0;
	private final int AH  = 1;
	private final int OH  = 2;

	// UI audio.
	private Sound uiSwoosh;
	private Sound enterGame;
	private Sound startGame;

	// Debug audio.
	private Sound test;

	// Cutscene audio.
	private Sound garbledSpeech;
	private Sound beep;
	private Sound breakingNews;

	// Level audio.
	private Sound policeSiren;
	private Sound siren;
	private Sound pointsBoost;
	private Sound jump;
	private Sound impact;
	private Sound endLevel;
	private Sound throwShrapnel;
	private Sound suckShrapnelOne;
	private Sound suckShrapnelTwo;
	private Sound suckShrapnelThree;
	private Sound wow;
	private Sound oh;
	private Sound ah;
	private Sound shrapnelHit;
	private Sound countdown;
	private Sound winnerSound;
	private Sound[] gettingSucked = new Sound[3];
	private Sound gunshot;
	private Sound register;
	private Sound maggieRespawnAfterFall;

	private Sound suckItOrGetSucked;
	private boolean suckItOrGetSuckedHasPlayed;

	private boolean gunshotHasPlayedForTrackLevel;
	private boolean gunshotHasPlayedForDoubleOrNothingLevel;

	private boolean jumpAudioCanPlay;
	private int jumpAudioTimer;
	private final int JUMP_AUDIO_DURATION_TIMER_MAX = 37;

	private boolean playGettingSuckedSound;
	private int gettingSuckedTimer;
	public static int gettingSuckedAudioToPlay;
	private final int GETTING_SUCKED_BREAK_VALUE = 200;

	private boolean playSuckUpShrapnelSound;
	private int suckUpShrapnelTimer;
	private final int SUCK_UP_SHRAPNEL_BREAK_VALUE = 25;

	public static boolean playSuckBoostAudioForPlayer = false;

	public static boolean playCreditsHit = false;
	public static boolean playControllsHit = false;

	public static boolean playMaggieFallingDownAudioAfterGettingReleasedFromSuckUp = false;

	private boolean hasPlayedEndGameStinger;

	public SoundHandler() {
		/**
		 * Create audio.
		 */
		// Debug audio.
		test = Gdx.audio.newSound(Gdx.files.internal("audio/sound/GiantGrunt.wav"));

		// UI audio.
		uiSwoosh = Gdx.audio.newSound(Gdx.files.internal("audio/sound/ui/UISwoosh.wav"));
		enterGame = Gdx.audio.newSound(Gdx.files.internal("audio/sound/ui/enter_game_horn.ogg"));
		startGame = Gdx.audio.newSound(Gdx.files.internal("audio/sound/ui/start_game_horn.ogg"));

		// Cutscene audio.
		garbledSpeech = Gdx.audio.newSound(Gdx.files.internal("audio/sound/cutscene/GarbledSpeech.wav"));
		//beep = Gdx.audio.newSound(Gdx.files.internal("audio/sound/cutscene/Beep.wav"));
		beep = Gdx.audio.newSound(Gdx.files.internal("audio/sound/cutscene/flat_line_lower.ogg"));
		breakingNews = Gdx.audio.newSound(Gdx.files.internal("audio/sound/cutscene/BreakingNews.wav"));

		// Level audio.
		policeSiren = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/PoliceSiren.ogg"));
		siren = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/Siren.wav"));
		pointsBoost = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/PointsBoost.wav"));
		jump = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/Jump.wav"));
		impact = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/Impact.wav"));
		endLevel = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/GreatCornholio.wav"));
		throwShrapnel = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/ThrowShrapnel.wav"));
		//suckShrapnel = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/SuckUp.wav"));
		suckShrapnelOne = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/tornado_suck.wav"));
		suckShrapnelTwo = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/tornado_suck_up_3.wav"));
		suckShrapnelThree = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/tornado_suck_up_6.wav"));
		shrapnelHit = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/PlayerHit.wav"));
		countdown = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/Countdown.wav"));
		winnerSound = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/winnersound.wav"));
		gunshot = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/Pistol.wav"));
		register = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/register.wav"));
		maggieRespawnAfterFall = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/Heart.wav"));

		suckItOrGetSucked = Gdx.audio.newSound(Gdx.files.internal("audio/sound/splashscreen/suckitorgetsucked.wav"));

		gettingSucked[0] = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/maggieVo/sucked_VO_one.wav"));
		gettingSucked[1] = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/maggieVo/sucked_VO_two.wav"));
		gettingSucked[2] = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/maggieVo/sucked_VO_three.wav"));

		wow = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/crowd/Wow.wav"));
		ah = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/crowd/Ah.wav"));
		oh = Gdx.audio.newSound(Gdx.files.internal("audio/sound/level/crowd/Oh.wav"));

		suckItOrGetSuckedHasPlayed = false;

		jumpAudioCanPlay = true;
		jumpAudioTimer = 0;

		playGettingSuckedSound = true;
		gettingSuckedTimer = 0;
		gettingSuckedAudioToPlay = SUCK_01;

		playSuckUpShrapnelSound = true;;
		suckUpShrapnelTimer = 0;

		playSuckBoostAudioForPlayer = false;

		playCreditsHit = false;
		playControllsHit = false;

		gunshotHasPlayedForTrackLevel           = false;
		gunshotHasPlayedForDoubleOrNothingLevel = false;

		hasPlayedEndGameStinger = false;
	}

	public void dispose() {
		test.dispose();

		// UI audio.
		uiSwoosh.dispose();

		// Ctuscene audio.
		garbledSpeech.dispose();
		beep.dispose();
		breakingNews.dispose();

		// Level audio.
		policeSiren.dispose();
		siren.dispose();
		pointsBoost.dispose();
		jump.dispose();
		impact.dispose();
		endLevel.dispose();
		throwShrapnel.dispose();
		suckShrapnelOne.dispose();
		suckShrapnelTwo.dispose();
		suckShrapnelThree.dispose();
		shrapnelHit.dispose();
		countdown.dispose();
		winnerSound.dispose();
		gunshot.dispose();
		register.dispose();
		maggieRespawnAfterFall.dispose();

		suckItOrGetSucked.dispose();

		wow.dispose();
		ah.dispose();
		oh.dispose();

		for (int i = 0; i < gettingSucked.length; i++) {
			gettingSucked[i].dispose();
		}
	}

	public void handleAudio(Level level, Player player, Tornado tornado) {
		if (TornadoGame.shouldStartGameplay) {
			if (TornadoGame.levelToLoad <= LevelHandler.LEVEL_END) { 
				handleCutsceneAudio(level);
				handleLevelAudio(level, player, tornado);
			} else {
				handleSlamAudio();
			} 
		} else {
			handleMainMenuAudio();
		}
	}

	private void handleSlamAudio() {
		if (!hasPlayedEndGameStinger) {
			suckItOrGetSucked.play(Mixer.SLAM_SCREEN_VOLUME_SUCK_IT_OR_GET_SUCKED);
			hasPlayedEndGameStinger = true;
		}
	}

	private void handleMainMenuAudio() {
		if (!suckItOrGetSuckedHasPlayed) {
			suckItOrGetSucked.play(Mixer.INTRO_VOLUME_SUCK_IT_OR_GET_SUCKED);
			suckItOrGetSuckedHasPlayed = true;
		}
		handlePlayerEnterAudio();
		handleCreditsScreenAudio();
		handleControllsScreenAudio();
	}

	private void handlePlayerEnterAudio() {
		// This is when players join in the main menu.
		if (Menu.playTornadoUiSwoosh && !Menu.hasPlayedTornadoUiSwoosh) {
			enterGame.play(Mixer.UI_ENTER_GAME_SWOOSH);
			Menu.playTornadoUiSwoosh      = false;
			Menu.hasPlayedTornadoUiSwoosh = true;
		}
		if (Menu.playMaggieUiSwoosh && !Menu.hasPlayedMaggieUiSwoosh) {
			enterGame.play(Mixer.UI_ENTER_GAME_SWOOSH);
			Menu.playMaggieUiSwoosh      = false;
			Menu.hasPlayedMaggieUiSwoosh = true;
		}
	}

	private void handleControllsScreenAudio() {
		if (playControllsHit) {
			enterGame.play(Mixer.UI_ENTER_GAME_SWOOSH);
			playControllsHit = false;
		}
	}

	private void handleCreditsScreenAudio() {
		if (playCreditsHit) {
			enterGame.play(Mixer.UI_ENTER_GAME_SWOOSH);
			playCreditsHit = false;
		}
	}

	private void handleCutsceneAudio(Level level) {
		if (!level.getCutscene().isCutsceneComplete()) {
			if (
					Menu.playStartGameUiSwoosh && 
					!Menu.hasPlayedStartGameUiSwoosh && 
					TornadoGame.levelToLoad <= LevelHandler.LEVEL_FARM
					) {
				startGame.play(Mixer.UI_PLAY_GAME_SWOOSH);
				Menu.playStartGameUiSwoosh      = false;
				Menu.hasPlayedStartGameUiSwoosh = true;
			}

			// This is here so there's not an extra countdown beep when the cutscene starts.
			countdown.stop();

			if (level.getCutscene().isPlayBreakingNewsAudio()) {
				breakingNews.play(Mixer.CUTSCENE_VOLUME_BREAKING_NEWS);
				level.getCutscene().setPlayBreakingNewsAudio(false);
			}
			// Play Kevin's garbled speech.
			if (!level.getCutscene().isHasBegunGarbledSpeechAudio()) {
				garbledSpeech.loop(Mixer.CUTSCENE_VOLUME_KEVIN_DIALOGUE);
				level.getCutscene().setHasBegunGarbledSpeechAudio(true);
			}
			// Play the beep when Maggie loses signal.
			if (level.getCutscene().isShouldDrawDeadScreen()) {
				if (!level.getCutscene().isHasPlayedBeepAudio()) {
					beep.loop(Mixer.CUTSCENE_VOLUME_BEEP);
					level.getCutscene().setHasPlayedBeepAudio(true);
				}
			}
		} else {
			garbledSpeech.stop();
			beep.stop();
		}
	}

	private void handleLevelAudio(Level level, Player player, Tornado tornado) {
		if (
				!level.isHasPlayedSiren() && 
				level.getCutscene().isCutsceneComplete() && 
				TornadoGame.levelToLoad <= LevelHandler.LEVEL_END
				) {
			siren.play(Mixer.LEVEL_VOLUME_SIREN);
			level.setHasPlayedSiren(true);
		}

		for (int i = 0; i < level.getPowerUpHandler().getPointBoost().length; i++) {
			if (level.getPowerUpHandler().getPointBoost()[i].isPlayPointsBoostAudio()) {
				pointsBoost.play(Mixer.LEVEL_VOLUME_POINTS_BOOST);
				level.getPowerUpHandler().getPointBoost()[i].setPlayPointsBoostAudio(false);
			}
		}

		handleJumpingAudio(player);

		handleCrowdReaction();

		if (ObstacleHandler.playImpactAudio) {
			impact.play(Mixer.LEVEL_VOLUME_IMPACT);
			ObstacleHandler.playImpactAudio = false;
		}

		// Tornado sucks up shrapnel.
		if (Obstacle.playShrapnelSuckAudio && playSuckUpShrapnelSound) {
			suckShrapnelTwo.play(Mixer.LEVEL_VOLUME_SUCK_UP_SHRAPNEL);
			Obstacle.playShrapnelSuckAudio = false;
			playSuckUpShrapnelSound = false;
		}

		handleSuckUpShrapnelTimer();

		// Tornado sucks up player.
		// TODO FIND DIFFERENT SFX FOR THIS SO IT'S DIFFERENT THAN SUCKING UP SHRAPNEL.
		if (tornado.isShouldSuck() && playGettingSuckedSound) {
			suckShrapnelThree.play(Mixer.LEVEL_VOLUME_SUCK_UP_SHRAPNEL);
			switch(gettingSuckedAudioToPlay) {
			case SUCK_01:
				gettingSucked[SUCK_01].play(Mixer.LEVEL_VOLUME_GETTING_SUCKED);
				break;
			case SUCK_02:
				gettingSucked[SUCK_02].play(Mixer.LEVEL_VOLUME_GETTING_SUCKED);
				break;
			case SUCK_03:
				gettingSucked[SUCK_03].play(Mixer.LEVEL_VOLUME_GETTING_SUCKED);
				break;
			}
			playGettingSuckedSound = false;
		}

		handleGettingSuckedTimer();
		handleMaggieGettingReleasedFromSuckUp();

		// Handle police siren when tornado gets suck boost.
		if (!tornado.isHasSuckBoost()) {
			policeSiren.stop();
		}
		else if (playSuckBoostAudioForPlayer) {
			policeSiren.play(Mixer.TORNADO_SUCK_UP_PLAYER_SFX_VOLUME_SIREN);
			playSuckBoostAudioForPlayer = false;
		} 

		// Tornado drops shrapnel.
		if (ShrapnelDrop.isDropped && ShrapnelDrop.playDropAudio) {
			throwShrapnel.play(Mixer.LEVEL_VOLUME_THROW_SHRAPNEL);
			ShrapnelDrop.playDropAudio = false;
		}

		// Player gets hit by shrapnel.
		if (ShrapnelDropHandler.playAudio) {
			shrapnelHit.play(Mixer.LEVEL_VOLUME_SHRAPNEL_HIT);
			ShrapnelDropHandler.playAudio = false;
		}

		// End level/winner audio.
		if (level.isLevelIsOver() && !level.isPlayEndLevelAudio()) {
			endLevel.play(Mixer.LEVEL_VOLUME_CORNHOLIO);
			level.setPlayEndLevelAudio(true);

			winnerSound.play(Mixer.LEVEL_WINNER_VOLUME);
		}

		if (Countdown.playCountdownSiren && !Countdown.stopCountdownTimer) {
			countdown.play(Mixer.LEVEL_VOLUME_COUNTDOWN);
			Countdown.playCountdownSiren = false;
		}

		if (level.isLevelIsOver()) {
			countdown.stop();
			gettingSucked[SUCK_01].stop();
			gettingSucked[SUCK_02].stop();
			gettingSucked[SUCK_03].stop();
			suckShrapnelOne.stop();
			suckShrapnelTwo.stop();
			suckShrapnelThree.stop();
			policeSiren.stop();
		}

		handleGunshotAtStartOfTrackLevels(level);
	}

	private void handleMaggieGettingReleasedFromSuckUp() {
		if (playMaggieFallingDownAudioAfterGettingReleasedFromSuckUp) {
			maggieRespawnAfterFall.play(Mixer.LEVEL_VOLUME_RESPAWN_AFTER_FALL);
			playMaggieFallingDownAudioAfterGettingReleasedFromSuckUp = false;
		}
	}

	private void handleGunshotAtStartOfTrackLevels(Level level) {

		if (
				TornadoGame.levelToLoad == LevelHandler.LEVEL_TRACK && 
				!gunshotHasPlayedForTrackLevel && 
				level.getCutscene().isCutsceneComplete()
				) {
			gunshot.play(Mixer.GUNSHOT_VOLUME);
			gunshotHasPlayedForTrackLevel = true;
		}

		if (
				TornadoGame.levelToLoad == LevelHandler.LEVEL_END && 
				!gunshotHasPlayedForDoubleOrNothingLevel && 
				level.getCutscene().isCutsceneComplete()
				) {
			gunshot.play(Mixer.GUNSHOT_VOLUME);
			gunshotHasPlayedForDoubleOrNothingLevel = true;
		}
	}

	private void handleSuckUpShrapnelTimer() {
		if (!playSuckUpShrapnelSound) {
			suckUpShrapnelTimer++;
			if (suckUpShrapnelTimer > SUCK_UP_SHRAPNEL_BREAK_VALUE) {
				playSuckUpShrapnelSound = true;
			}
		}
	}

	private void handleGettingSuckedTimer() {
		if (!playGettingSuckedSound) {
			gettingSuckedTimer++;
			if (gettingSuckedTimer > GETTING_SUCKED_BREAK_VALUE) {
				playGettingSuckedSound = true;
				gettingSuckedAudioToPlay++;
				playSuckBoostAudioForPlayer = true;
			}
		}
	}

	private void handleCrowdReaction() {
		if (Obstacle.playReactionAudio) {
			int reaction = RandomNumberGenerator.generateRandomInteger(3);
			switch (reaction) {
			case WOW:
				wow.play(Mixer.LEVEL_VOLUME_CROWD);
				break;
			case AH:
				ah.play(Mixer.LEVEL_VOLUME_CROWD);
				break;
			case OH:
				oh.play(Mixer.LEVEL_VOLUME_CROWD);
				break;
			}
			register.play(Mixer.LEVEL_VOLUME_REGISTER);
			Obstacle.playReactionAudio = false;
		}
	}

	private void handleJumpingAudio(Player player) {
		if (player.isPlayJumpAudio() && jumpAudioCanPlay) {
			jump.play(Mixer.LEVEL_VOLUME_JUMP);
			player.setPlayJumpAudio(false);
			jumpAudioCanPlay = false;
		}

		if (!jumpAudioCanPlay) {
			jumpAudioTimer++;
			if (jumpAudioTimer > JUMP_AUDIO_DURATION_TIMER_MAX) {
				jumpAudioTimer = 0;
				jumpAudioCanPlay = true;
			}
		}
	}
}
