package com.tornadogame.ui.meters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.handlers.pointsanddamage.PointHandler;

public class PlayerMeter extends Meter {

	//private Texture negativePointsTexture;

	public PlayerMeter(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
		//negativePointsTexture = new Texture("YellowSquare.png");
		pointsTexture         = new Texture("YellowSquare.png");
	}

	public void draw(SpriteBatch batch, Player player) {
		//batch.draw(texture, x, y, width, height);
		if (player.getPoints() <= PointHandler.MAX_POINTS) {
			batch.draw(pointsTexture, x, y, player.getPoints(), height);
		} else {
			player.setPoints(PointHandler.MAX_POINTS);
		}
		batch.draw(meterOverlay, x - meterOverlayOffset, y - meterOverlayOffset, width + meterOverlayOffset * 2, height + meterOverlayOffset * 2);
		/*
		if (player.getPoints() < 0) {
			batch.draw(negativePointsTexture, x, y, player.getPoints(), height);
		} */
	}
}
