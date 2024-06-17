package com.tornadogame.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.gameobjects.GameObject;
import com.tornadogame.gameobjects.Player;

public class SuckUpScoreUi extends GameObject {

	public SuckUpScoreUi(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
	}

	public void draw(SpriteBatch batch, Player player) {
		switch(player.getLives()) {
		case 2:
			batch.draw(texture, x, y, width, height);
			break;
		case 1:
			batch.draw(texture, x, y, width, height);
			batch.draw(texture, x + width * 2, y, width, height);
			break;
		case 0:
			batch.draw(texture, x, y, width, height);
			batch.draw(texture, x + width * 2, y, width, height);
			batch.draw(texture, x + width * 3, y, width, height);
			break;
		}
	}
}
