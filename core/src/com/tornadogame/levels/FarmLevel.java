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

public class FarmLevel extends Level {

	public static float watertowerX      = Layout.GRID_03;
	public static float watertowerY      = 300;
	public static float watertowerWidth  = 300;
	public static float watertowerHeight = 600;

	public static float scarecrowX      = Layout.GRID_06;
	public static float scarecrowY      = 800;
	public static float scarecrowWidth  = 300;
	public static float scarecrowHeight = 300;

	public FarmLevel(OrthographicCamera camera, float endOfLevel, int level) {
		super(camera, LevelHandler.LEVEL_FARM, endOfLevel);
		cutscene = new Cutscene(0, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/cutscenes/Cutscene_Base.png"), 0, 0, level);
		headTexture[0] = new Texture("artwork/player/heads/farmer/FarmerHead_01.png");
		headTexture[1] = new Texture("artwork/player/heads/farmer/FarmerHead_02.png");
		headTexture[2] = new Texture("artwork/player/heads/farmer/FarmerHead_03.png");
	}

	public void update(LevelHandler levelHandler, OrthographicCamera camera, TornadoGame tornadoGame) {
		super.update(levelHandler, camera, tornadoGame);

		if (Player.isBoosting) {
			watertowerX += backgroundObjectDx * 2;
			//scarecrowX += backgroundObjectDx * 2;
		} else {
			watertowerX += backgroundObjectDx;
			//scarecrowX += backgroundObjectDx;
		}

		if (watertowerX + watertowerWidth * 2 < 0) {
			watertowerX = camera.position.x + TornadoGame.screenWidth * 4;
		}
		//if (scarecrowX + scarecrowWidth * 2 < 0) {
		//	scarecrowX = camera.position.x + TornadoGame.screenWidth * 4;
		//}

		if (cutscene.isCutsceneComplete()) {
			for (int i = 0; i < rain.length; i++) {
				rain[i].update();
			}
		}
	} 

	public void draw(SpriteBatch batch, Tornado tornado, Player player, int level) {
		super.draw(batch, tornado, player, level);

		if (cutscene.isCutsceneComplete() && !loadingScreenShouldRender) {
			for (int i = 0; i < rain.length; i++) {
				rain[i].draw(batch);
			}
		}
	}
}
