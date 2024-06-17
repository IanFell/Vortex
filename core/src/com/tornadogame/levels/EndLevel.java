package com.tornadogame.levels;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.cutscenes.Cutscene;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.handlers.LevelHandler;

public class EndLevel extends Level {
	
	//private boolean drawSlamScreen;

	//private SlamScreen slamScreen;

	public EndLevel(OrthographicCamera camera, float endOfLevel, int level) {
		super(camera, LevelHandler.LEVEL_END, endOfLevel);
		cutscene    = new Cutscene(0, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, new Texture("artwork/cutscenes/Cutscene_Base.png"), 0, 0, level);
		headTexture[0] = new Texture("artwork/player/heads/beach/BeachHead_01.png");
		headTexture[1] = new Texture("artwork/player/heads/beach/BeachHead_02.png");
		headTexture[2] = new Texture("artwork/player/heads/beach/BeachHead_03.png");
		
		//slamScreen = new SlamScreen(0, 0, TornadoGame.screenWidth, TornadoGame.screenHeight, null, 0, 0);
		//drawSlamScreen = false;
		
		this.goTexture = new Texture("artwork/levels/endlevel/DoubleOrNothingUi.png");
	}

	public void update(LevelHandler levelHandler, OrthographicCamera camera, TornadoGame tornadoGame) {
		
		//if (!isLevelIsOver()) {
		super.update(levelHandler, camera, tornadoGame);
		
		if (cutscene.isCutsceneComplete()) {
			for (int i = 0; i < rain.length; i++) {
				rain[i].update();
			}
		}
		//}
		//else {
		
		//if (isLevelIsOver()) {
		//	drawSlamScreen = true;
		//}
	//	}
		
	}

	public void draw(SpriteBatch batch, Tornado tornado, Player player, int level) {
		//if (!drawSlamScreen) {
			super.draw(batch, tornado, player, level);
			
			if (cutscene.isCutsceneComplete() && !loadingScreenShouldRender) {
				for (int i = 0; i < rain.length; i++) {
					rain[i].draw(batch);
				}
			}
			
			
		//} else {
			//if (drawSlamScreen) {
			//slamScreen.draw(batch, tornado, player, level);
		//	}
		//}
	}
}
