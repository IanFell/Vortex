package com.tornadogame.ui.meters;

import com.badlogic.gdx.graphics.Texture;
import com.tornadogame.gameobjects.GameObject;

public class Meter extends GameObject {

	public static Texture pointsTexture;
	public static Texture meterOverlay;

	protected int meterOverlayOffset = 50;

	public Meter(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
		meterOverlay  = new Texture("artwork/ui/meters/MeterOutline.png");
	}

	public static void dispose() {
		pointsTexture.dispose();
		meterOverlay.dispose();
	}
}
