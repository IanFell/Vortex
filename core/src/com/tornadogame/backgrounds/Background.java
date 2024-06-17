package com.tornadogame.backgrounds;

import com.badlogic.gdx.graphics.Texture;
import com.tornadogame.gameobjects.GameObject;

public class Background extends GameObject {

	public static final float SCROLL_SPEED_MID_LAYER_01 = -50f;
	public static final float SCROLL_SPEED_MID_LAYER_02 = -75f;
	public static final float SCROLL_SPEED_MID_LAYER_03 = -100f;
	public static final float SCROLL_SPEED_MID_LAYER_04 = -125f;
	public static final float SCROLL_SPEED_FRONT_LAYER  = -150;

	protected float scrollSpeed;

	public Background(float x, float y, float width, float height, Texture texture, float dx, float dy, float scrollSpeed) {
		super(x, y, width, height, texture, dx, dy);
		this.scrollSpeed = scrollSpeed;
	}
}
