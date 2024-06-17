package com.tornadogame.ui;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.handlers.MeterHandler;
import com.tornadogame.levels.Level;

public class UserInterface {

	private MeterHandler meterHandler;
	private SuckUpScoreUi suckUpScoreUi;
	private Message message;
	private Score score;

	public UserInterface(OrthographicCamera camera) {
		meterHandler      = new MeterHandler();
		suckUpScoreUi     = new SuckUpScoreUi(
				meterHandler.getTornadoMeter().getWidth() + meterHandler.getTornadoMeter().getHeight() * 2,
				meterHandler.getTornadoMeter().getY(),
				meterHandler.getTornadoMeter().getHeight(),
				meterHandler.getTornadoMeter().getHeight(),
				new Texture("artwork/ui/meters/Rain.png"),
				0,
				0
				);
		message          = new Message(camera.viewportWidth / 2 - 500, camera.viewportHeight / 2 - 150, 1000, 300, null, 0, 0);

		float scoreX      = meterHandler.getTornadoMeter().getX() + meterHandler.getTornadoMeter().getWidth(); 
		float scoreWidth  = meterHandler.getPlayerMeter().getX() - scoreX;
		float scoreHeight = meterHandler.getTornadoMeter().getHeight();
		score             = new Score(scoreX, camera.viewportHeight - scoreHeight, scoreWidth, scoreHeight, null, 0, 0);
	}

	public MeterHandler getMeterHandler() {
		return meterHandler;
	}

	public Message getMessage() {
		return message;
	}

	public void draw(SpriteBatch batch, Tornado tornado, Player player, int level) {
		meterHandler.draw(batch, tornado, player);
		//suckUpScoreUi.draw(batch, player);
		message.draw(batch);
		score.draw(batch, level);
	}

	public void update(Player player, Level level) {
		message.update(player, level);
		score.update();
	}
}
