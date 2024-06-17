package com.tornadogame.handlers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.Tornado;

public class ShadowHandler {

	public void draw(SpriteBatch batch, Tornado tornado, Player player) {
		batch.setColor(Color.DARK_GRAY);
		batch.draw(tornado.getTextureToDraw(), tornado.getX() + tornado.getWidth() / 2, 0, tornado.getWidth() / 4, tornado.getHeight() / 4);
		batch.draw(player.getTextureToDraw(), player.getX() + player.getWidth() / 2, 0, player.getWidth() / 4, player.getHeight() / 4);
		batch.setColor(Color.WHITE);
	}
}
