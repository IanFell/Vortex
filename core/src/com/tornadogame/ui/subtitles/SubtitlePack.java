package com.tornadogame.ui.subtitles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.cutscenes.Cutscene;
import com.tornadogame.handlers.LevelHandler;

public class SubtitlePack {

	// Use this because the subtitles pictures are centered on the screen and we need them to be lower.
	private float y;

	public static final int MAX_SUBTITLES = 6;

	public static final int SUBTITLE_DISPLAY_LENGTH = 150;

	public static Texture[] subtitles = new Texture[MAX_SUBTITLES];

	private Cutscene cutscene;

	private int timer;

	public SubtitlePack(int level, Cutscene cutscene, float y) {
		switch (level) {
		case LevelHandler.LEVEL_FARM:
			subtitles[0] = new Texture("artwork/ui/subtitles/farm/01.png");
			subtitles[1] = new Texture("artwork/ui/subtitles/farm/02.png");
			subtitles[2] = new Texture("artwork/ui/subtitles/farm/03.png");
			subtitles[3] = new Texture("artwork/ui/subtitles/farm/04.png");
			break;
		case LevelHandler.LEVEL_SPACE:
			subtitles[0] = new Texture("artwork/ui/subtitles/space/01.png");
			subtitles[1] = new Texture("artwork/ui/subtitles/space/02.png");
			subtitles[2] = new Texture("artwork/ui/subtitles/space/03.png");
			subtitles[3] = new Texture("artwork/ui/subtitles/space/04.png");
			break;
		case LevelHandler.LEVEL_BEACH:
			subtitles[0] = new Texture("artwork/ui/subtitles/beach/01.png");
			subtitles[1] = new Texture("artwork/ui/subtitles/beach/02.png");
			subtitles[2] = new Texture("artwork/ui/subtitles/beach/03.png");
			subtitles[3] = new Texture("artwork/ui/subtitles/beach/04.png");
			break;
		case LevelHandler.LEVEL_ARCTIC:
			subtitles[0] = new Texture("artwork/ui/subtitles/arctic/01.png");
			subtitles[1] = new Texture("artwork/ui/subtitles/arctic/02.png");
			subtitles[2] = new Texture("artwork/ui/subtitles/arctic/03.png");
			subtitles[3] = new Texture("artwork/ui/subtitles/arctic/04.png");
			break;
		case LevelHandler.LEVEL_HELL:
			subtitles[0] = new Texture("artwork/ui/subtitles/hell/01.png");
			subtitles[1] = new Texture("artwork/ui/subtitles/hell/02.png");
			subtitles[2] = new Texture("artwork/ui/subtitles/hell/03.png");
			subtitles[3] = new Texture("artwork/ui/subtitles/hell/04.png");
			break;
		case LevelHandler.LEVEL_CITY:
			subtitles[0] = new Texture("artwork/ui/subtitles/city/01.png");
			subtitles[1] = new Texture("artwork/ui/subtitles/city/02.png");
			subtitles[3] = new Texture("artwork/ui/subtitles/city/03.png");
			subtitles[2] = new Texture("artwork/ui/subtitles/city/04.png");
			break;
		case LevelHandler.LEVEL_DESERT:
			subtitles[0] = new Texture("artwork/ui/subtitles/desert/01.png");
			subtitles[1] = new Texture("artwork/ui/subtitles/desert/02.png");
			subtitles[2] = new Texture("artwork/ui/subtitles/desert/03.png");
			subtitles[3] = new Texture("artwork/ui/subtitles/desert/04.png");
			break;
		case LevelHandler.LEVEL_FORREST:
			subtitles[0] = new Texture("artwork/ui/subtitles/forrest/01.png");
			subtitles[1] = new Texture("artwork/ui/subtitles/forrest/02.png");
			subtitles[2] = new Texture("artwork/ui/subtitles/forrest/03.png");
			subtitles[3] = new Texture("artwork/ui/subtitles/forrest/04.png");
			break;
		case LevelHandler.LEVEL_TRACK:
			subtitles[0] = new Texture("artwork/ui/subtitles/track/01.png");
			subtitles[1] = new Texture("artwork/ui/subtitles/track/02.png");
			subtitles[2] = new Texture("artwork/ui/subtitles/track/03.png");
			subtitles[3] = new Texture("artwork/ui/subtitles/track/04.png");
			break;
		case LevelHandler.LEVEL_END:
			subtitles[0] = new Texture("artwork/ui/subtitles/end/01.png");
			subtitles[1] = new Texture("artwork/ui/subtitles/end/02.png");
			subtitles[2] = new Texture("artwork/ui/subtitles/end/03.png");
			subtitles[3] = new Texture("artwork/ui/subtitles/end/04.png");
			break;
		case LevelHandler.LEVEL_DOUBLE:
			subtitles[0] = new Texture("artwork/ui/subtitles/end/01.png");
			subtitles[1] = new Texture("artwork/ui/subtitles/end/02.png");
			subtitles[2] = new Texture("artwork/ui/subtitles/end/03.png");
			subtitles[3] = new Texture("artwork/ui/subtitles/end/04.png");
			break;
		}
		subtitles[4] = new Texture("artwork/ui/subtitles/05.png");
		subtitles[5] = new Texture("artwork/ui/subtitles/06.png");
		this.cutscene = cutscene;
		this.y = y;
	}

	public int getTimer() {
		return timer;
	}

	public void draw(SpriteBatch batch) { 
		if (timer < SUBTITLE_DISPLAY_LENGTH) {
			batch.draw(subtitles[0], 0, y, TornadoGame.screenWidth, TornadoGame.screenHeight);
		} 
		else if (timer >= SUBTITLE_DISPLAY_LENGTH && timer < SUBTITLE_DISPLAY_LENGTH * 2) {
			batch.draw(subtitles[1], 0, y, TornadoGame.screenWidth, TornadoGame.screenHeight);
		}
		else if (timer >= SUBTITLE_DISPLAY_LENGTH * 2 && timer < SUBTITLE_DISPLAY_LENGTH * 3) {
			batch.draw(subtitles[2], 0, y, TornadoGame.screenWidth, TornadoGame.screenHeight);
		}
		else if (timer >= SUBTITLE_DISPLAY_LENGTH * 3 && timer < SUBTITLE_DISPLAY_LENGTH * 4) {
			batch.draw(subtitles[3], 0, y, TornadoGame.screenWidth, TornadoGame.screenHeight);
		}
		else if (timer >= SUBTITLE_DISPLAY_LENGTH * 4 && timer < SUBTITLE_DISPLAY_LENGTH * 5) {
			batch.draw(subtitles[4], 0, y, TornadoGame.screenWidth, TornadoGame.screenHeight);
		}
		else if (timer >= SUBTITLE_DISPLAY_LENGTH * 5 && timer < SUBTITLE_DISPLAY_LENGTH * 6) {
			batch.draw(subtitles[5], 0, y, TornadoGame.screenWidth, TornadoGame.screenHeight);
		}
		else {
			cutscene.setCutsceneComplete(true);
		}
	}

	public void update() {
		timer++;
	}

	public Texture[] getSubtitles() {
		return subtitles;
	}

	public static void dispose() {
		for (int i = 0; i < subtitles.length; i++) {
			subtitles[i].dispose();
		}
	}
}
