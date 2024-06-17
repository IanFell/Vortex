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

public class SpaceLevel extends Level {

	public static float rocketX      = Layout.GRID_02;
	public static float rocketWidth  = 500;
	public static float rocketHeight = 500;
	public static float rocketY      = TornadoGame.screenHeight - rocketHeight * 1.25f;

	public SpaceLevel(OrthographicCamera camera, float endOfLevel, int level) {
		super(camera, LevelHandler.LEVEL_SPACE, endOfLevel);
		cutscene    = new Cutscene(0, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/cutscenes/Cutscene_Base.png"), 0, 0, level);
		headTexture[0] = new Texture("artwork/player/heads/AstronautHead.png");
		headTexture[1] = new Texture("artwork/player/heads/AstronautHead.png");
		headTexture[2] = new Texture("artwork/player/heads/AstronautHead.png");
	}

	public void update(LevelHandler levelHandler, OrthographicCamera camera, TornadoGame tornadoGame) {
		super.update(levelHandler, camera, tornadoGame);

		rocketX += backgroundObjectDx / 2;

		if (rocketX + rocketWidth * 2 < 0) {
			rocketX = camera.position.x + TornadoGame.screenWidth * 2;
		}

		if (cutscene.isCutsceneComplete()) {
			for (int i = 0; i < wind.length; i++) {
				wind[i].update();
			} 
		}
	}

	public void draw(SpriteBatch batch, Tornado tornado, Player player, int level) {
		super.draw(batch, tornado, player, level);

		if (cutscene.isCutsceneComplete() && !loadingScreenShouldRender) {
			for (int i = 0; i < wind.length; i++) {
				wind[i].draw(batch);
			} 
		}
	}
}
