package com.tornadogame.ui.menu.screenshots;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.gameobjects.GameObject;

public class ScreenShot extends GameObject {

	public static Texture[] textureScreenShot = new Texture[9];
	private int textureToDraw;
	private int textureToDrawTimer;

	private float transparancy;

	public ScreenShot(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
		textureScreenShot[0] = new Texture("artwork/menu/screenshots/Farm.png");
		textureScreenShot[1] = new Texture("artwork/menu/screenshots/Space.png");
		textureScreenShot[2] = new Texture("artwork/menu/screenshots/Beach.png");
		textureScreenShot[3] = new Texture("artwork/menu/screenshots/Arctic.png");
		textureScreenShot[4] = new Texture("artwork/menu/screenshots/Hell.png");
		textureScreenShot[5] = new Texture("artwork/menu/screenshots/City.png");
		textureScreenShot[6] = new Texture("artwork/menu/screenshots/Desert.png");
		textureScreenShot[7] = new Texture("artwork/menu/screenshots/Forrest.png");
		textureScreenShot[8] = new Texture("artwork/menu/screenshots/Track.png");

		textureToDraw = 0;
		textureToDrawTimer = 0;

		transparancy = 0;
	}

	public void draw(SpriteBatch batch) {
		batch.setColor(1, 1, 1, transparancy);
		batch.draw(textureScreenShot[textureToDraw], x, y, width, height);
		batch.setColor(Color.WHITE);
	}

	public void update() {
		textureToDrawTimer++;

		if (textureToDrawTimer % 100 == 0) {
			textureToDraw++;
			transparancy = 0;
		}

		if (textureToDraw > 8) {
			textureToDraw = 0;
		}

		transparancy += .02f;
	}

	public static void dispose() {
		for (int i = 0; i < textureScreenShot.length; i++) {
			textureScreenShot[i].dispose();
		}
	}
}
