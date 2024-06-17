package com.tornadogame.ui.doubleornothing;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.gameobjects.GameObject;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.Tornado;

public class DoubleOrNothingUi extends GameObject {

	//private Texture doubleOrNothingBackground;

	public DoubleOrNothingUi(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
		//doubleOrNothingBackground = new Texture("artwork/cutscenes/SignalLost.png");
	}

	public void draw(SpriteBatch batch, Tornado tornado, Player player, int level) {
		//batch.draw(doubleOrNothingBackground, x, y, width, height);
	}

	public void update() {	
		//ControllerInput.maskControlls = true;
	}
}
