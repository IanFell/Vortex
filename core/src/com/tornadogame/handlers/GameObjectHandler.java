package com.tornadogame.handlers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.input.InputParent;
import com.tornadogame.layout.Layout;
import com.tornadogame.levels.Level;
import com.tornadogame.levels.TestLevel;
import com.tornadogame.ui.Message;

public class GameObjectHandler {

	private Player player;
	private Tornado tornado;

	public GameObjectHandler(int level) {
		player  = new Player(Layout.GRID_01, 100, 300, 300, null, 50, -100, level);
		tornado = new Tornado(Layout.GRID_01, TornadoGame.screenHeight - 500, 500, 500, null, 50, 25);
	}

	public void update(Message message, TornadoGame tornadoGame, PowerUpHandler powerUpHandler, Level level, ShrapnelDropHandler shrapnelDropHandler, OrthographicCamera camera) {
		tornado.update(message, player, powerUpHandler, level, camera, shrapnelDropHandler);
		player.update(message, tornadoGame, tornado, powerUpHandler, shrapnelDropHandler, camera, level);
	}

	public void draw(SpriteBatch batch, Level level, int levelLoaded) {
		if (!level.isLevelIsOver()) {
			/**
			 * This determines where to render the tornado and Maggie.
			 * If the tornado is moving forwards, it's rendered in front of Maggie.
			 * If the tornado is NOT moving forwards, it's rendered behind Maggie.
			 */
			if (InputParent.keyHeld) {
				tornado.draw(batch);
				player.draw(batch, levelLoaded, level);
			} else {
				player.draw(batch, levelLoaded, level);
				tornado.draw(batch);
			}
		} else {
			if (level.getWinner() == TestLevel.WINNER_PLAYER) {
				player.draw(batch, levelLoaded, level);
			} else if (level.getWinner() == TestLevel.WINNER_TORNADO)  {
				tornado.draw(batch);
			}
		}
	}

	public Player getPlayer() {
		return player;
	}

	public Tornado getTornado() {
		return tornado;
	}
}
