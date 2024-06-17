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

public class ArcticLevel extends Level {
	
	public static float iceburgX      = Layout.GRID_02;
	public static float iceburgWidth  = 500;
	public static float iceburgHeight = 500;
	public static float iceburgY      = TornadoGame.screenHeight - 1300;

	public ArcticLevel(OrthographicCamera camera, float endOfLevel, int level) {
		super(camera, LevelHandler.LEVEL_ARCTIC, endOfLevel);
		cutscene    = new Cutscene(0, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/cutscenes/Cutscene_Base.png"), 0, 0, level);
		headTexture[0] = new Texture("artwork/player/heads/arctic/ArcticHead_01.png");
		headTexture[1] = new Texture("artwork/player/heads/arctic/ArcticHead_02.png");
		headTexture[2] = new Texture("artwork/player/heads/arctic/ArcticHead_03.png");
	}

	public void update(LevelHandler levelHandler, OrthographicCamera camera, TornadoGame tornadoGame) {
		super.update(levelHandler, camera, tornadoGame);
		
		iceburgX += backgroundObjectDx / 2;

		if (iceburgX + iceburgWidth * 2 < 0) {
			iceburgX = camera.position.x + TornadoGame.screenWidth * 2;
		}

		if (cutscene.isCutsceneComplete()) {
			for (int i = 0; i < snow.length; i++) {
				snow[i].update();
			}
		}
	}

	public void draw(SpriteBatch batch, Tornado tornado, Player player, int level) {
		super.draw(batch, tornado, player, level);

		if (cutscene.isCutsceneComplete() && !loadingScreenShouldRender) {
			for (int i = 0; i < snow.length; i++) {
				snow[i].draw(batch);
			}
		}
	}
}
