package com.tornadogame.levels;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.backgrounds.Background;
import com.tornadogame.cutscenes.Cutscene;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.handlers.LevelHandler;

public class DesertLevel extends Level {

	public static float pyramidWidth  = 700;
	public static float pyramidHeight = 700;
	public static float pyramidX      = TornadoGame.screenWidth * 2;
	public static float pyramidY      = TornadoGame.screenHeight / 3.8f;

	public DesertLevel(OrthographicCamera camera, float endOfLevel, int level) {
		super(camera, LevelHandler.LEVEL_DESERT, endOfLevel);
		cutscene    = new Cutscene(0, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/cutscenes/Cutscene_Base.png"), 0, 0, level);
		headTexture[0] = new Texture("artwork/player/heads/beach/BeachHead_01.png");
		headTexture[1] = new Texture("artwork/player/heads/beach/BeachHead_02.png");
		headTexture[2] = new Texture("artwork/player/heads/beach/BeachHead_03.png");
	}

	public void update(LevelHandler levelHandler, OrthographicCamera camera, TornadoGame tornadoGame) {

		super.update(levelHandler, camera, tornadoGame);

		if (cutscene.isCutsceneComplete()) {
			for (int i = 0; i < fire.length; i++) {
				fire[i].update();
			}
			updatePyramid();
		}
	}

	private void updatePyramid() {
		pyramidX += Background.SCROLL_SPEED_MID_LAYER_01;
		if (pyramidX + pyramidWidth < 0) {
			pyramidX = TornadoGame.screenWidth * 2;
		}
	}

	public void draw(SpriteBatch batch, Tornado tornado, Player player, int level) {
		super.draw(batch, tornado, player, level);

		if (cutscene.isCutsceneComplete() && !loadingScreenShouldRender) {
			for (int i = 0; i < rain.length; i++) {
				fire[i].draw(batch);
			}
		}
	}
}
