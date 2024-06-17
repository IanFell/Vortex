package com.tornadogame.levels;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.cutscenes.Cutscene;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.handlers.LevelHandler;

public class DoubleLevel extends Level {

	public DoubleLevel(OrthographicCamera camera, float endOfLevel, int level) {
		super(camera, LevelHandler.LEVEL_END, endOfLevel);
		cutscene    = new Cutscene(0, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/cutscenes/Cutscene_Base.png"), 0, 0, level);
		headTexture[0] = new Texture("artwork/player/heads/arctic/ArcticHead_01.png");
		headTexture[1] = new Texture("artwork/player/heads/arctic/ArcticHead_02.png");
		headTexture[2] = new Texture("artwork/player/heads/arctic/ArcticHead_03.png");
	}
	
	public void update(LevelHandler levelHandler, OrthographicCamera camera, TornadoGame tornadoGame) {
		super.update(levelHandler, camera, tornadoGame);
		//System.exit(0);
		//TornadoGame.shouldReloadGame = true;
	}
	
	public void draw(SpriteBatch batch, Tornado tornado, Player player, int level) {
		//if (!cutscene.isCutsceneComplete()) {
			super.draw(batch, tornado, player, level);
		//} //else {
			//slamScreen.draw(batch, tornado, player, level);
			//doubleOrNothingUi.draw(batch, tornado, player, level);
		//}
	}

}
