package com.tornadogame.oldclasses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.gameobjects.Player;

public class Tile {
	
	//public static boolean needsSpeedBoost = false;
	
	float bx;
	float bx2;
	float bx3;
	
	private Texture t1;
	private Texture t2;
	private Texture t3;
	
	private Texture background;
	
	public Tile() {
		t1 = new Texture("ScallopCove.png");
		t2 = new Texture("RawBar3d.png");
		t3 = new Texture("TradingPost3d.png");
		
		background = new Texture("BackGround.png");
		
		bx = 0;
		bx2 = Gdx.graphics.getWidth();
		bx3 = Gdx.graphics.getWidth() * 2;
	}
	
	public void update(Player player) {
		/*
		if (player.isHasSpeedBoost()) {
			bx += TornadoGame.SCROLL_SPEED;
			bx2 += TornadoGame.SCROLL_SPEED;
			bx3 += TornadoGame.SCROLL_SPEED;
		} else {
			bx += TornadoGame.SCROLL_SPEED;
			bx2 += TornadoGame.SCROLL_SPEED;
			bx3 += TornadoGame.SCROLL_SPEED;
		}

		if (bx < - Gdx.graphics.getWidth()) {
			bx = Gdx.graphics.getWidth() * 2;
		}

		if (bx2 < - Gdx.graphics.getWidth()) {
			bx2 = Gdx.graphics.getWidth() * 2;
		}

		if (bx3 < - Gdx.graphics.getWidth()) {
			bx3 = Gdx.graphics.getWidth() * 2;
		}*/
	}

	public void draw(SpriteBatch batch) {
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(t1, bx, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(t2, bx2, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(t3, bx3, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

}
