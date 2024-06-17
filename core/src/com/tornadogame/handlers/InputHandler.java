package com.tornadogame.handlers;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.tornadogame.TornadoGame;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.input.controller.ControllerInput;
import com.tornadogame.input.keyboard.KeyboardInput;
import com.tornadogame.levels.Level;

public class InputHandler extends ApplicationAdapter implements ApplicationListener {

	private boolean hasController;

	private ControllerInput controllerInput;
	private KeyboardInput keyboardInput;

	public boolean isHasController() {
		return hasController;
	}

	public InputHandler() {
		hasController = false;
		if(Controllers.getControllers().size > 0) {
			hasController = true;
		}

		if (hasController) {
			controllerInput = new ControllerInput();
		} else {
			keyboardInput = new KeyboardInput();
		}

		// Hide mouse.
		Gdx.input.setCursorCatched(true);
	}

	public void init() {
		if (hasController) {
			controllerInput.init();
		}
	}

	public void handleInput(TornadoGame tornadoGame, OrthographicCamera camera, Player player, Tornado tornado, ShrapnelDropHandler shrapnelDropHandler, Level level) {
		if (hasController) {
			controllerInput.handleInput(tornadoGame, camera, player, tornado, shrapnelDropHandler, level);
		} else {
			keyboardInput.handleInput(tornadoGame, camera, player, tornado, shrapnelDropHandler);
		}
	}

	// We need this for TornadoGame class to draw menu.
	public KeyboardInput getKeyboardInput() {
		return keyboardInput;
	}

	// We need this for TornadoGame class to draw menu.
	public ControllerInput getControllerInput() {
		return controllerInput;
	}
}
