package com.tornadogame.handlers;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.foreground.Debree;

public class DebreeHandler {

	private Debree[] debree = new Debree[100];

	public DebreeHandler() {
		for (int i = 0; i < debree.length; i++) {
			Random randomX    = new Random();
			Random randomY    = new Random();
			float debreeX     = randomX.nextInt((int) TornadoGame.screenWidth);
			float debreeY     = randomY.nextInt((int) TornadoGame.screenHeight);
			Random randomDx   = new Random();
			float debreeDx    = randomDx.nextInt(100);
			if (debreeDx < 10) {
				debreeDx = 10;
			}
			Random randomSize = new Random();
			float debreeSize  = randomSize.nextInt(10);
			debree[i]         = new Debree(debreeX, debreeY, debreeSize, debreeSize, new Texture("WhiteSquare.png"), -debreeDx, 0);
		}
	}

	public void update() {
		for (int i = 0; i < debree.length; i++) {
			debree[i].update();
		}
	}

	public void draw(SpriteBatch batch) {
		for (int i = 0; i < debree.length; i++) {
			debree[i].draw(batch);
		}
	}
}
