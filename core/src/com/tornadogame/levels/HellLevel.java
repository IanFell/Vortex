package com.tornadogame.levels;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.cutscenes.Cutscene;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.handlers.LevelHandler;
import com.tornadogame.layout.Layout;

public class HellLevel extends Level {

	public static float gargoyleX      = Layout.GRID_02;
	public static float gargoyleWidth  = 500;
	public static float gargoyleHeight = 500;
	public static float gargoyleY      = TornadoGame.screenHeight - 750;

	public HellLevel(OrthographicCamera camera, float endOfLevel, int level) {
		super(camera, LevelHandler.LEVEL_HELL, endOfLevel);
		cutscene    = new Cutscene(0, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/cutscenes/Cutscene_Base.png"), 0, 0, level);
		headTexture[0] = new Texture("artwork/player/heads/hell/HellHead_01.png");
		headTexture[1] = new Texture("artwork/player/heads/hell/HellHead_02.png");
		headTexture[2] = new Texture("artwork/player/heads/hell/HellHead_03.png");
	}

	public void update(LevelHandler levelHandler, OrthographicCamera camera, TornadoGame tornadoGame) {

		super.update(levelHandler, camera, tornadoGame);

		gargoyleX += backgroundObjectDx / 2;
		if (gargoyleX + gargoyleWidth * 2 < 0) {
			gargoyleX = camera.position.x + TornadoGame.screenWidth * 2;
		}

		if (cutscene.isCutsceneComplete()) {
			for (int i = 0; i < fire.length; i++) {
				fire[i].update();
			}
		}
	}

	public void draw(SpriteBatch batch, Tornado tornado, Player player, int level) {
		super.draw(batch, tornado, player, level);

		if (cutscene.isCutsceneComplete() && !loadingScreenShouldRender) {
			for (int i = 0; i < fire.length; i++) {
				fire[i].draw(batch);
			}
		}
	}
}
