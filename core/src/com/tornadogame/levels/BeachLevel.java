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
import com.tornadogame.layout.Layout;

public class BeachLevel extends Level {

	public static float boatX      = Layout.GRID_02;
	public static float boatWidth  = 250;
	public static float boatHeight = 150;
	public static float boatY      = TornadoGame.screenHeight - boatHeight * 7.85f;

	public static float lightHouseX      = TornadoGame.screenWidth * 2;
	public static float lightHouseY      = TornadoGame.screenHeight / 4;
	public static float lightHouseWidth  = 100;
	public static float lightHouseHeight = 300;

	public BeachLevel(OrthographicCamera camera, float endOfLevel, int level) {
		super(camera, LevelHandler.LEVEL_BEACH, endOfLevel);
		cutscene    = new Cutscene(0, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/cutscenes/Cutscene_Base.png"), 0, 0, level);
		headTexture[0] = new Texture("artwork/player/heads/beach/BeachHead_01.png");
		headTexture[1] = new Texture("artwork/player/heads/beach/BeachHead_02.png");
		headTexture[2] = new Texture("artwork/player/heads/beach/BeachHead_03.png");
	}

	public void update(LevelHandler levelHandler, OrthographicCamera camera, TornadoGame tornadoGame) {
		super.update(levelHandler, camera, tornadoGame);

		if (cutscene.isCutsceneComplete()) {
			for (int i = 0; i < rain.length; i++) {
				rain[i].update();
			}
			updateBoat(camera);
			updateLighthouse();
		}
	}

	private void updateLighthouse() {
		lightHouseX += Background.SCROLL_SPEED_MID_LAYER_01;
		if (lightHouseX + lightHouseWidth < 0) {
			lightHouseX = TornadoGame.screenWidth * 2;
		}
	}

	private void updateBoat(OrthographicCamera camera) {
		boatX += backgroundObjectDx / 2;
		if (boatX + boatWidth * 2 < 0) {
			boatX = camera.position.x + TornadoGame.screenWidth * 2;
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
