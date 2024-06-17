package com.tornadogame.handlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.handlers.pointsanddamage.PointHandler;
import com.tornadogame.ui.meters.PlayerMeter;
import com.tornadogame.ui.meters.TornadoMeter;

public class MeterHandler {

	private final int METER_MAX  = PointHandler.MAX_POINTS;
	private final int HEIGHT     = 100;

	private TornadoMeter tornadoMeter;
	private PlayerMeter playerMeter;

	public MeterHandler() {
		int offset   = METER_MAX / 4;
		tornadoMeter = new TornadoMeter(offset, TornadoGame.screenHeight - HEIGHT - offset, METER_MAX, HEIGHT, null, 0, 0);
		playerMeter  = new PlayerMeter(TornadoGame.screenWidth - METER_MAX - offset, TornadoGame.screenHeight - HEIGHT - offset, METER_MAX, HEIGHT, null, 0, 0);
	}

	public void draw(SpriteBatch batch, Tornado tornado, Player player) {
		tornadoMeter.draw(batch, tornado);
		playerMeter.draw(batch, player);
	}

	public TornadoMeter getTornadoMeter() {
		return tornadoMeter;
	}

	public PlayerMeter getPlayerMeter() {
		return playerMeter;
	}
}
