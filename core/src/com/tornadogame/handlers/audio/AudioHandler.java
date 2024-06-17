package com.tornadogame.handlers.audio;

import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.handlers.LevelHandler;
import com.tornadogame.levels.Level;

public class AudioHandler {
	
	private SoundHandler soundHandler;
	private MusicHandler musicHandler;
	
	public AudioHandler() {
		soundHandler = new SoundHandler();
		musicHandler = new MusicHandler();
	}
	
	public void handleAudio(LevelHandler levelHandler, Player player, Tornado tornado, int currentLevel) {
		Level level = levelHandler.getCurrentLevel();
		soundHandler.handleAudio(level, player, tornado);
		musicHandler.handleAudio(level, player, currentLevel);
	}
	
	public void dispose() {
		soundHandler.dispose();
		musicHandler.dispose();
	}
}
