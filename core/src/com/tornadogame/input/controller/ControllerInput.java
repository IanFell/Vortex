package com.tornadogame.input.controller;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.tornadogame.TornadoGame;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.gameobjects.weapons.ShrapnelDrop;
import com.tornadogame.handlers.ShrapnelDropHandler;
import com.tornadogame.handlers.audio.SoundHandler;
import com.tornadogame.input.InputParent;
import com.tornadogame.levels.Level;
import com.tornadogame.ui.menu.Menu;

public class ControllerInput extends InputParent {

	private Controller controllerOne;
	private Controller controllerTwo;

	private final int CONTROLLER_TORNADO = 0;
	private final int CONTROLLER_PLAYER  = 1;

	private boolean hasOneController = true;
	// Use this in the menu class to determine which button layout image to display.
	public static boolean isTwoPlayer = false;

	private final int ONE_CONTROLLER = 1;
	private final int TWO_CONTROLLER = 2;

	private boolean canHitCreditsButtonForOnePlayer;
	private int creditsButtonTimer;
	private final int CREDITS_BUTTON_BREAK_VALUE = 25;

	private boolean canHitControllsButtonForOnePlayer;
	private int controllsButtonTimer;
	private final int CONTROLLS_BUTTON_BREAK_VALUE = 25;

	/**
	 * Represents the dead zone for joysticks.  
	 * In the deadzone will register as 0 (non movement).
	 * This is used because controller is very sensitive and we
	 * dont want an accidental movement to trigger.
	 */
	private float deadZone = 0.2f;

	private int BUTTON_Y;
	private int BUTTON_A;
	private int BUTTON_X;
	private int BUTTON_B;

	private int BUTTON_Y_C2;
	private int BUTTON_A_C2;
	private int BUTTON_X_C2;
	private int BUTTON_B_C2;

	private int BUTTON_A_CONTROLLER_TWO;

	private int BUTTON_START;
	private int BUTTON_SELECT;

	private int BUTTON_START_C2;
	private int BUTTON_SELECT_C2;

	private String f310        = "F310";
	private String xBox        = "XBox";
	private String playStation = "Wireless Controller";

	/**
	 * Controller sticks.
	 */
	private int AXIS_LEFT_X;  // -1 is left | +1 is right
	private int AXIS_LEFT_Y;  // -1 is up | +1 is down

	private int AXIS_LEFT_X_CONTROLLER_TWO;  // -1 is left | +1 is right

	private int AXIS_LEFT_X_C2;  // -1 is left | +1 is right
	private int AXIS_LEFT_Y_C2;  // -1 is up | +1 is down

	public ControllerInput() {
		canHitCreditsButtonForOnePlayer = true;
		creditsButtonTimer = 0;

		playerHasJoined = false;
		tornadoHasJoined = false;
	}

	private Controller getControllerOne() {
		return Controllers.getControllers().get(CONTROLLER_TORNADO);
	}

	private Controller getControllerTwo() {
		return Controllers.getControllers().get(CONTROLLER_PLAYER);
	}

	public void init() {
		if(Controllers.getControllers().size == ONE_CONTROLLER) {
			initFirstController(); 
		}
		else if(Controllers.getControllers().size == TWO_CONTROLLER) {
			initBothControllers(); 
		} 

		if (hasOneController) {
			isTwoPlayer = false;
		} else {
			isTwoPlayer = true;
		}
	}

	private void initFirstController() {
		controllerOne = getControllerOne();
		System.out.println(controllerOne.getName());

		if (controllerOne.getName().contains("F310")) {
			mapButtonsForF310GamePadC1();
		}
		if (controllerOne.getName().contains("Wireless Controller")) {
			mapButtonsForPlayStationControllerC1();
		}
		if (controllerOne.getName().contains("Xbox")) {
			mapButtonsForXBoxControllerC1();
		}

		hasOneController = true;
	}

	private void initBothControllers() {
		controllerOne = getControllerOne();
		//System.out.println(controllerOne.getName());

		controllerTwo = getControllerTwo();
		//System.out.println(controllerTwo.getName());

		// Controller One.
		if (controllerOne.getName().contains(f310)) {
			mapButtonsForF310GamePadC1();
		}
		if (controllerOne.getName().contains(playStation)) {
			mapButtonsForPlayStationControllerC1();
		}
		if (controllerOne.getName().contains(xBox)) {
			mapButtonsForXBoxControllerC1();
		}

		// Controller Two.
		if (controllerTwo.getName().contains(f310)) {
			mapButtonsForF310GamePadC2();
		}
		if (controllerTwo.getName().contains(playStation)) {
			mapButtonsForPlayStationControllerC2();
		}
		if (controllerTwo.getName().contains(xBox)) {
			mapButtonsForXBoxControllerC2();
		}
		hasOneController = false;
	}

	private void mapButtonsForXBoxControllerC1() {
		this.AXIS_LEFT_X                = 1; // -1 is left | +1 is right
		this.AXIS_LEFT_Y                = 0; // -1 is up | +1 is down
		this.AXIS_LEFT_X_CONTROLLER_TWO = 1;
		this.BUTTON_Y                   = 3;
		this.BUTTON_A                   = 0;
		this.BUTTON_X                   = 2;
		this.BUTTON_B                   = 1;
		this.BUTTON_START               = 7;
		this.BUTTON_SELECT              = 6;
	}

	private void mapButtonsForXBoxControllerC2() {
		this.AXIS_LEFT_X_C2             = 1; // -1 is left | +1 is right
		this.AXIS_LEFT_Y_C2             = 0; // -1 is up | +1 is down
		this.AXIS_LEFT_X_CONTROLLER_TWO = 1;
		this.BUTTON_Y_C2                = 3;
		this.BUTTON_A_C2                = 0;
		this.BUTTON_X_C2                = 2;
		this.BUTTON_B_C2                = 1;
		this.BUTTON_START_C2            = 7;
		this.BUTTON_SELECT_C2           = 6;
	}

	private void mapButtonsForPlayStationControllerC1() {
		this.AXIS_LEFT_X                = 3; // -1 is left | +1 is right
		this.AXIS_LEFT_Y                = 2; // -1 is up | +1 is down
		this.AXIS_LEFT_X_CONTROLLER_TWO = 1;
		this.BUTTON_Y                   = 3;
		this.BUTTON_A                   = 1;
		this.BUTTON_X                   = 0;
		this.BUTTON_B                   = 2;
		this.BUTTON_START               = 9;
		this.BUTTON_SELECT              = 8;
	}

	private void mapButtonsForPlayStationControllerC2() {
		this.AXIS_LEFT_X_CONTROLLER_TWO = 3;
		this.BUTTON_Y_C2                = 3;
		this.BUTTON_A_C2                = 1;
		this.BUTTON_X_C2      			= 0;
		this.BUTTON_B_C2      			= 2;
		this.BUTTON_START_C2  			= 9;
		this.BUTTON_SELECT_C2 			= 8;
	}

	private void mapButtonsForF310GamePadC1() {
		this.AXIS_LEFT_X  				= 1; // -1 is left | +1 is right
		this.AXIS_LEFT_Y  				= 0; // -1 is up | +1 is down
		this.AXIS_LEFT_X_CONTROLLER_TWO = 1;
		this.BUTTON_Y     				= 3;
		this.BUTTON_A     				= 0;
		this.BUTTON_X     				= 2;
		this.BUTTON_B     				= 1;
		this.BUTTON_A_CONTROLLER_TWO 	= 0;
		this.BUTTON_START  				= 7;
		this.BUTTON_SELECT 				= 6;
	}

	private void mapButtonsForF310GamePadC2() {
		this.AXIS_LEFT_X_C2  			= 1; // -1 is left | +1 is right
		this.AXIS_LEFT_Y_C2  			= 0; // -1 is up | +1 is down
		this.AXIS_LEFT_X_CONTROLLER_TWO = 1;
		this.BUTTON_Y_C2     			= 3;
		this.BUTTON_A_C2     			= 0;
		this.BUTTON_X_C2    			= 2;
		this.BUTTON_B_C2    			= 1;
		this.BUTTON_A_CONTROLLER_TWO 	= 0;
		this.BUTTON_START_C2  			= 7;
		this.BUTTON_SELECT_C2 			= 6;
	}

	public void handleInput(TornadoGame tornadoGame, OrthographicCamera camera, Player player, Tornado tornado, ShrapnelDropHandler shrapnelDropHandler, Level level) {

		// Quit game.  Only first controller can do this.
		if (controllerOne.getButton(BUTTON_SELECT)) {
			System.exit(0);
		}

		if (!hasOneController) {
			if (!TornadoGame.shouldStartGameplay) {
				pollMenuButtonsTornado(tornadoGame);
				pollMenuButtonsPlayer(tornadoGame);
			} else {
				pollSticksTornado(tornado, shrapnelDropHandler, camera);
				pollSticksPlayer(player, shrapnelDropHandler, camera);
				if (level.getCutscene().isCutsceneComplete()) {
					pollJumpButtonPlayer(player);
				}
				pollEnterButtonsDuringGameplay();
			}
		}
		else {
			// LOGIC FOR ONLY ONE CONTROLLER HERE WHETHER IT'S TORNADO OR MAGGIE.
			if (!TornadoGame.shouldStartGameplay) {
				determineIfPlayerIsTornadoOrMaggieAndStartGame(tornadoGame);
			} else {
				// If we want to pause the game, uncomment this out.
				/*
				if(controllerOne.getButton(BUTTON_B)) {
					TornadoGame.pause = true;
				} */
				if (tornadoGame.getGameType() == TornadoGame.TORNADO) {
					pollSticksTornado(tornado, shrapnelDropHandler, camera);
				} else {
					pollSticksPlayerForControllerOne(player, shrapnelDropHandler, camera);
					if (level.getCutscene().isCutsceneComplete() && !player.isStunned()) {
						pollJumpButtonPlayerControllerOne(player);
					}
				}
			}
		}
	}

	/**
	 * This method checks to see if player wants to start a new game during demo mode.
	 */
	private void pollEnterButtonsDuringGameplay() {

		if (TornadoGame.isAi) {
			if(controllerOne.getButton(BUTTON_Y) || controllerTwo.getButton(BUTTON_Y_C2)) {		
				TornadoGame.shouldReloadGame = true;
			}
		}
	}

	private void determineIfPlayerIsTornadoOrMaggieAndStartGame(TornadoGame tornadoGame) {
		if(controllerOne.getButton(BUTTON_X) && !Menu.renderCreditScreen && !Menu.renderControllsScreen) {
			TornadoGame.isAi         = false;
			TornadoGame.tornadoHasAi = false;
			TornadoGame.playerHasAi  = true;
			tornadoHasJoined         = true;
			tornadoGame.setGameType(TornadoGame.TORNADO);

			TornadoGame.tornadoHasAi = false;
			TornadoGame.playerHasAi  = true;
			playerHasJoined          = false;

			Menu.playTornadoUiSwoosh     = true;
			Menu.playMaggieUiSwoosh      = false;
			Menu.hasPlayedMaggieUiSwoosh = false;
		}
		if(controllerOne.getButton(BUTTON_B) && !Menu.renderCreditScreen && !Menu.renderControllsScreen) {
			TornadoGame.isAi         = false;
			TornadoGame.tornadoHasAi = true;
			TornadoGame.playerHasAi  = false;
			playerHasJoined          = true;
			tornadoGame.setGameType(TornadoGame.PLAYER);

			TornadoGame.tornadoHasAi = true;
			TornadoGame.playerHasAi  = false;
			tornadoHasJoined         = false;

			Menu.playMaggieUiSwoosh       = true;
			Menu.playTornadoUiSwoosh      = false;
			Menu.hasPlayedTornadoUiSwoosh = false;
		}

		// Start the game.
		if(controllerOne.getButton(BUTTON_START) && !Menu.renderCreditScreen && !Menu.renderControllsScreen) {
			if (TornadoGame.splashScreenHasEnded) {
				TornadoGame.shouldStartGameplay = true;
			}
		}

		// Handle Credits screen.
		// If game is one controller.
		if (!isTwoPlayer) {
			if(controllerOne.getButton(BUTTON_Y) && canHitCreditsButtonForOnePlayer && !Menu.renderControllsScreen) {
				Menu.renderCreditScreen = !Menu.renderCreditScreen;
				canHitCreditsButtonForOnePlayer = false;
				SoundHandler.playCreditsHit = true;
			}
			handleCreditsButtonTimerForOnePlayer();
		}

		// Handle controls screen.
		if (!isTwoPlayer) {
			if(controllerOne.getButton(BUTTON_A) && canHitControllsButtonForOnePlayer && !Menu.renderCreditScreen) { 
				Menu.renderControllsScreen = !Menu.renderControllsScreen;
				canHitControllsButtonForOnePlayer = false;
				SoundHandler.playControllsHit = true;
			}
			handleControllsButtonTimerForOnePlayer();
		}
	}

	private void handleControllsButtonTimerForOnePlayer() {
		if (!canHitControllsButtonForOnePlayer) {
			controllsButtonTimer++;
			if (controllsButtonTimer > CONTROLLS_BUTTON_BREAK_VALUE) {
				controllsButtonTimer = 0;
				canHitControllsButtonForOnePlayer = true;
			}
		}
	}

	private void handleCreditsButtonTimerForOnePlayer() {
		if (!canHitCreditsButtonForOnePlayer) {
			creditsButtonTimer++;
			if (creditsButtonTimer > CREDITS_BUTTON_BREAK_VALUE) {
				creditsButtonTimer = 0;
				canHitCreditsButtonForOnePlayer = true;
			}
		}
	}

	private void pollJumpButtonPlayerControllerOne(Player player) {
		if(controllerOne.getButton(BUTTON_A)) {
			if (player.isCanJump() && !player.isStunned() && !player.isJumping()) {
				player.setJumping(true);
			}
		}
	}

	private void pollJumpButtonPlayer(Player player) {
		if(controllerTwo.getButton(BUTTON_A_C2)) {
			if (player.isCanJump() && !player.isStunned() && !player.isJumping()) {
				player.setJumping(true);
			}
		}
	}

	public void pollMenuButtonsPlayer(TornadoGame tornadoGame) {
		if(controllerTwo.getButton(BUTTON_Y_C2)) {
			TornadoGame.isAi         = false;
			TornadoGame.tornadoHasAi = true;
			TornadoGame.playerHasAi  = false;
			playerHasJoined          = true;
			tornadoGame.setGameType(TornadoGame.PLAYER);

			if (tornadoHasJoined && playerHasJoined) {
				tornadoGame.setGameType(TornadoGame.TWO_PLAYER);
				TornadoGame.tornadoHasAi  = false;
			}

			Menu.playTornadoUiSwoosh = true;
		}

		// TODO Remove this for final build.  Only first controller should be able to select.
		// TODO Ecspecially on the arcade version since the button to start will be on tornado's controls.
		if(controllerTwo.getButton(BUTTON_A_C2)) {
			if (TornadoGame.splashScreenHasEnded) {
				TornadoGame.shouldStartGameplay = true;
			}
		}

		if(controllerTwo.getButton(BUTTON_B_C2) && canHitCreditsButtonForOnePlayer) {
			Menu.renderCreditScreen = !Menu.renderCreditScreen;
			canHitCreditsButtonForOnePlayer = false;
			SoundHandler.playCreditsHit = true;
		}
		handleCreditsButtonTimerForOnePlayer();

		if (controllerTwo.getButton(BUTTON_X_C2) && canHitControllsButtonForOnePlayer && !Menu.renderCreditScreen) {
			Menu.renderControllsScreen = !Menu.renderControllsScreen;
			canHitControllsButtonForOnePlayer = false;
			SoundHandler.playControllsHit = true;
		}
		handleControllsButtonTimerForOnePlayer();
	}

	public void pollMenuButtonsTornado(TornadoGame tornadoGame) {
		if(controllerOne.getButton(BUTTON_Y)) {
			TornadoGame.isAi         = false;
			TornadoGame.tornadoHasAi = false;
			TornadoGame.playerHasAi  = true;
			tornadoHasJoined         = true;
			tornadoGame.setGameType(TornadoGame.TORNADO);

			if (tornadoHasJoined && playerHasJoined) {
				tornadoGame.setGameType(TornadoGame.TWO_PLAYER);
				TornadoGame.playerHasAi  = false;
			}

			Menu.playMaggieUiSwoosh  = true;
		}

		if(controllerOne.getButton(BUTTON_A)) {		
			if (TornadoGame.splashScreenHasEnded) {
				TornadoGame.shouldStartGameplay = true;
			}
		}

		if(controllerOne.getButton(BUTTON_B) && canHitCreditsButtonForOnePlayer && !Menu.renderControllsScreen) {
			Menu.renderCreditScreen = !Menu.renderCreditScreen;
			canHitCreditsButtonForOnePlayer = false;
			SoundHandler.playCreditsHit = true;
		}
		handleCreditsButtonTimerForOnePlayer();

		if (controllerOne.getButton(BUTTON_X) && canHitControllsButtonForOnePlayer && !Menu.renderCreditScreen) {
			Menu.renderControllsScreen = !Menu.renderControllsScreen;
			canHitControllsButtonForOnePlayer = false;
			SoundHandler.playControllsHit = true;
		}
		handleControllsButtonTimerForOnePlayer();
	}

	public void pollSticksPlayerForControllerOne(Player player, ShrapnelDropHandler shrapnelDropHandler, OrthographicCamera camera) {
		if (stickIsMovedPlayerControllerOne(AXIS_LEFT_X)) {
			if (controllerOne.getAxis(AXIS_LEFT_X) < 0) {
				if (player.getX() > 0) {
					player.moveLeft();
				}
			} 
			if (controllerOne.getAxis(AXIS_LEFT_X) > 0) {
				if (player.getX() + player.getWidth() < camera.viewportWidth) {
					player.moveRight();
				}
			} 
		}
	}

	public void pollSticksPlayer(Player player, ShrapnelDropHandler shrapnelDropHandler, OrthographicCamera camera) {
		if (stickIsMovedPlayer(AXIS_LEFT_X_CONTROLLER_TWO)) {
			if (controllerTwo.getAxis(AXIS_LEFT_X_CONTROLLER_TWO) < 0) {
				if (player.getX() > 0) {
					player.moveLeft();
				}
			} 
			if (controllerTwo.getAxis(AXIS_LEFT_X_CONTROLLER_TWO) > 0) {
				if (player.getX() + player.getWidth() < camera.viewportWidth) {
					player.moveRight();
				}
			} 
		}
	}

	public void pollSticksTornado(Tornado tornado, ShrapnelDropHandler shrapnelDropHandler, OrthographicCamera camera) {
		if (stickIsMovedTornado(AXIS_LEFT_X)) {
			if (controllerOne.getAxis(AXIS_LEFT_X) < 0) {
				if (tornado.getX() > 0) {
					tornado.moveLeft();
				}
			} 
			if (controllerOne.getAxis(AXIS_LEFT_X) > 0) {
				if (tornado.getX() + tornado.getWidth() < camera.viewportWidth) {
					tornado.moveRight();
					InputParent.keyHeld = true;
				}
			} else {
				InputParent.keyHeld = false;
			}
		}
		if (stickIsMovedTornado(AXIS_LEFT_Y)) {
			if (controllerOne.getAxis(AXIS_LEFT_Y) < 0) {
				tornado.moveUp();
			} 
			if (controllerOne.getAxis(AXIS_LEFT_Y) > 0) {
				tornado.moveDown();

				if (shrapnelDropHandler.getShrapnelDrop().size() > 0) {
					ShrapnelDrop.isDropped = true;
				}
			} 
		} 
	}

	/**
	 * Determines if either joystick has been moved.
	 * 
	 * @param int axis
	 * @return boolean
	 */
	private boolean stickIsMovedPlayerControllerOne(int axis) {
		if (controllerOne.getAxis(axis) > deadZone  || controllerOne.getAxis(axis) < -deadZone) {
			return true;
		}
		return false;
	}

	/**
	 * Determines if either joystick has been moved.
	 * 
	 * @param int axis
	 * @return boolean
	 */
	private boolean stickIsMovedPlayer(int axis) {
		if (controllerTwo.getAxis(axis) > deadZone  || controllerTwo.getAxis(axis) < -deadZone) {
			return true;
		}
		return false;
	}

	/**
	 * Determines if either joystick has been moved.
	 * 
	 * @param int axis
	 * @return boolean
	 */
	private boolean stickIsMovedTornado(int axis) {
		if (controllerOne.getAxis(axis) > deadZone  || controllerOne.getAxis(axis) < -deadZone) {
			return true;
		}
		return false;
	}
}
