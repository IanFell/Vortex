package com.tornadogame.foreground;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.tornadogame.TornadoGame;
import com.tornadogame.gameobjects.GameObject;

public class Flame extends GameObject {

	/**
	 * Animation variables.
	 */
	private final float ANIMATION_SPEED = 1/15f;
	protected static TextureAtlas textureAtlas;
	protected Animation <TextureRegion> animation;
	protected float elapsedTime = 0;

	public Flame(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);

		textureAtlas = new TextureAtlas(Gdx.files.internal("artwork/levels/helllevel/fire.atlas"));
		animation    = new Animation <TextureRegion> (ANIMATION_SPEED, textureAtlas.getRegions());
	}

	public void draw(SpriteBatch batch) {
		updateElapsedTime();
		renderAnimation(
				batch, 
				elapsedTime, 
				animation, 
				x, 
				y, 
				width, 
				height
				);
	}

	public void updateElapsedTime() {
		elapsedTime += Gdx.graphics.getDeltaTime();
	}

	public static void renderAnimation(
			SpriteBatch batch, 
			float elapsedTime, 
			Animation <TextureRegion> animation, 
			float x, 
			float y, 
			float width,
			float height
			) {
		batch.draw( 
				animation.getKeyFrame(elapsedTime, true),  
				x,  
				y, 
				width, 
				height
				);
	}

	public void update() {
		x += dx;
		if (x + width < 0) {
			x = TornadoGame.screenWidth;
		}
	}
	
	public static void dispose() {
		textureAtlas.dispose();
	}
}
