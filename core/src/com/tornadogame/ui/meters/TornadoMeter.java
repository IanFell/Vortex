package com.tornadogame.ui.meters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.handlers.pointsanddamage.PointHandler;

public class TornadoMeter extends Meter {

	public TornadoMeter(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
		pointsTexture = new Texture("YellowSquare.png"); 
	}

	public void draw(SpriteBatch batch, Tornado tornado) {
		//batch.draw(texture, x, y, width, height);
		if (tornado.getPoints() <= PointHandler.MAX_POINTS) {
			batch.draw(pointsTexture, x, y, tornado.getPoints(), height);
		} else {
			tornado.setPoints(PointHandler.MAX_POINTS);
		}
		batch.draw(meterOverlay, x - meterOverlayOffset, y - meterOverlayOffset, width + meterOverlayOffset * 2, height + meterOverlayOffset * 2);
	}
}
