package com.tornadogame.ui.menu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.gameobjects.GameObject;
import com.tornadogame.handlers.InputHandler;
import com.tornadogame.input.InputParent;
import com.tornadogame.input.controller.ControllerInput;
import com.tornadogame.ui.menu.screenshots.ScreenShot;

public class Menu extends GameObject {

	private InputHandler inputHandler;

	public static Texture keyNumFive;

	public static Texture genericBackground;

	public static Texture creditsOnePlayer;
	public static Texture creditsTwoPlayer;
	public static boolean renderCreditScreen = false;

	public static Texture creditsLabel;
	public static Texture controllsLabel;
	public static Texture backLabel;

	public static boolean playTornadoUiSwoosh   = false;
	public static boolean playMaggieUiSwoosh    = false;
	public static boolean playStartGameUiSwoosh = false;

	public static boolean hasPlayedTornadoUiSwoosh   = false;
	public static boolean hasPlayedMaggieUiSwoosh    = false;
	public static boolean hasPlayedStartGameUiSwoosh = false;

	// If game doesn't start before this value, go ahead an start it.
	private final int GAME_START_TIMER = 3232;

	private int beginGameTimer;

	public static Texture[] maggieHeads = new Texture[3];
	public static Texture playerTexture;

	private int joinedInIconSize;

	private int animationTimer;
	private final int ANIMATION_TIMER_MAX = 30;

	// Textures for text on the menu.
	public static Texture playerOne;
	public static Texture playerTwo;
	public static Texture startGame;
	public static Texture joinGame;

	// Used to make player names flash.
	private int flashTimer;
	private final int FLASH_MAX_VALUE   = 15;
	private final int FLASH_CYCLE_VALUE = 30;

	// Button overlays.
	public static Texture buttonOnePlayer;
	public static Texture buttonTwoPlayer;
	public static Texture buttonKeyboard;

	public static Texture controllsScreen;
	public static Texture controllsScreenTwoPlayer;
	public static Texture controllsScreenKeyboard;
	public static boolean renderControllsScreen = false;

	private ScreenShot screenShot;

	public Menu(float x, float y, float width, float height, Texture texture, float dx, float dy, InputHandler inputHandler) {
		super(x, y, width, height, texture, dx, dy);

		backgroundWidth     = width;
		backgroundHeight    = height;

		loadTextTextures();

		loadMaggieTextures();
		playerTexture  = maggieHeads[0];

		joinedInIconSize = 400;

		loadTornadoTextures();

		textureToDraw = animationTexture[0];

		beginGameTimer = 0;
		animationTimer = 0;
		flashTimer     = 0;

		loadButtonLayoutTextures();

		setUiStaticVariablesForAudio();

		keyNumFive = new Texture("artwork/menu/KeyNum_05.png");

		creditsOnePlayer = new Texture("artwork/menu/Credits.png");
		creditsTwoPlayer = new Texture("artwork/menu/Credits_TwoPlayer.png");
		renderCreditScreen = false;

		controllsScreen = new Texture("artwork/menu/ControllsUi.png");
		controllsScreenTwoPlayer = new Texture("artwork/menu/ControllsUiTwoPlayer.png");
		controllsScreenKeyboard = new Texture("artwork/menu/ControllsUiKeyboard.png");
		renderControllsScreen = false;

		genericBackground = new Texture("artwork/menu/GenericBackground.png");

		float screenShotWidth = 1100;
		float screenShotHeight = 700;
		screenShot = new ScreenShot(
				x + width / 2 - screenShotWidth / 2, 
				y + height / 2 - screenShotHeight / 2, 
				screenShotWidth, 
				screenShotHeight, 
				null, 
				0, 
				0
				);

		this.inputHandler = inputHandler;
	}

	private void setUiStaticVariablesForAudio() {
		playTornadoUiSwoosh   = false;
		playMaggieUiSwoosh    = false;

		hasPlayedTornadoUiSwoosh   = false;
		hasPlayedMaggieUiSwoosh    = false;
	}

	private void loadButtonLayoutTextures() {
		buttonOnePlayer = new Texture("artwork/menu/ButtonOnePlayer_Alt_StartButton.png");
		buttonTwoPlayer = new Texture("artwork/menu/ButtonTwoPlayer.png");
		buttonKeyboard  = new Texture("artwork/menu/ButtonKeyboard.png");
	}

	private void loadTextTextures() {
		playerOne      = new Texture("artwork/menu/PlayerOne.png");
		playerTwo      = new Texture("artwork/menu/PlayerTwo.png");
		startGame      = new Texture("artwork/menu/StartGame.png");
		joinGame       = new Texture("artwork/menu/JoinGame.png");
		creditsLabel   = new Texture("artwork/menu/CreditsLabel.png");
		controllsLabel = new Texture("artwork/menu/ControllsLabel.png");
		backLabel      = new Texture("artwork/menu/BackLabel.png");
	}

	private void loadMaggieTextures() {
		maggieHeads[0] = new Texture("artwork/player/heads/beach/BeachHead_01.png");
		maggieHeads[1] = new Texture("artwork/player/heads/beach/BeachHead_02.png");
		maggieHeads[2] = new Texture("artwork/player/heads/beach/BeachHead_03.png");
	}

	public void draw(SpriteBatch batch, InputParent input, InputHandler inputHandler) {
		int offset = 150;
		if (renderCreditScreen) {
			batch.draw(genericBackground, x, y, backgroundWidth, backgroundHeight);
			if (ControllerInput.isTwoPlayer) {
				batch.draw(creditsTwoPlayer, x + offset, y, width - offset * 2, height);
			}
			else {
				batch.draw(creditsOnePlayer, x + offset, y, width - offset * 2, height);
			}
			batch.draw(backLabel, x + width - (width / 5), y - height / 4, width / 3, height / 3);

			if (!inputHandler.isHasController()) {
				batch.draw(keyNumFive, x + width - (width / 8), y - height / 70, width / 14, height / 7);
			}
		} 
		else if (renderControllsScreen) {
			batch.draw(genericBackground, x, y, backgroundWidth, backgroundHeight);
			if (inputHandler.isHasController()) {
				if (ControllerInput.isTwoPlayer) {
					batch.draw(controllsScreenTwoPlayer, x + offset, y, width - offset * 2, height);
				} 
				else {
					batch.draw(controllsScreen, x + offset, y, width - offset * 2, height);
				}
			} else {
				batch.draw(controllsScreenKeyboard, x + offset, y, width - offset * 2, height);
			}
			batch.draw(backLabel, x + width - (width / 5), y - height / 4, width / 3, height / 3);
		
			if (!inputHandler.isHasController()) {
				batch.draw(keyNumFive, x + width - (width / 8), y - height / 70, width / 14, height / 7);
			}
		}
		else {

			expandScreen();

			// Draw background.
			batch.draw(texture, x, y, backgroundWidth, backgroundHeight);

			// Draw player names.
			if (flashTimer < FLASH_MAX_VALUE) {

				// Tornado side.
				batch.draw(playerOne, x + TornadoGame.screenWidth / 20, y, width / 2, height / 2);

				if (!input.isTornadoHasJoined()) {
					batch.draw(joinGame, x + width / 12, y + height / 6, width / 4, height / 4);
				}

				// Maggie side.
				batch.draw(playerTwo, (x + width) - (width / 3.5f), y, width / 2, height / 2);

				if (!input.isPlayerHasJoined()) {
					batch.draw(joinGame, (x + width) - (width / 5), y + height / 6, width / 4, height / 4);
				}
			}

			batch.draw(startGame, x + width / 2 - (width / 8), y - height / 4, width / 2, height / 2);
			batch.draw(creditsLabel, x + width - (width / 4), y - height / 4, width / 3, height / 3);
			batch.draw(controllsLabel, x + (width / 8), y - height / 4, width / 3, height / 3);

			drawButtonLayouts(batch, input, inputHandler);

			screenShot.draw(batch);
		}
		handleStarsShining();
	}

	private void expandScreen() {
		if (x > 0) {
			x -= 160;
		}
		if (x + width < TornadoGame.screenWidth) {
			width += 320;
			backgroundWidth  = width;
			backgroundHeight = height;
		}
	}

	private void drawButtonLayouts(SpriteBatch batch, InputParent input, InputHandler inputHandler) {
		// Draw button layouts, for either controllers or keyboard.
		if (inputHandler.isHasController()) {
			if (ControllerInput.isTwoPlayer) {
				batch.draw(buttonTwoPlayer, x, y, width, height); 
			} else {
				batch.draw(buttonOnePlayer, x, y, width, height); 
			}
		} else {
			batch.draw(buttonKeyboard, x, y, width, height); 
		}

		// Draw players when they join in.
		if (input.isTornadoHasJoined()) {
			batch.draw(textureToDraw, x + width / 12, y + (height / 2), joinedInIconSize, joinedInIconSize);
		}

		if (input.isPlayerHasJoined()) {
			batch.draw(playerTexture, (x + width) - (width / 5), y + (height / 2), joinedInIconSize, joinedInIconSize);
		}
	}

	public void update() {
		handleAnimation();

		// If game doesn't start before this, go ahead and start it.
		beginGameTimer++;
		if (beginGameTimer > GAME_START_TIMER) {
			TornadoGame.shouldStartGameplay = true;
		}

		animateMaggie();

		// Handle player names flashing.
		flashTimer++;
		if (flashTimer > FLASH_CYCLE_VALUE) {
			flashTimer = 0;
		}

		screenShot.update();
	}

	private void animateMaggie() {
		animationTimer++;
		if (animationTimer > ANIMATION_TIMER_MAX) {
			animationTimer = 0;
		}

		if (animationTimer < 10) {
			playerTexture = maggieHeads[0];
		} else if (animationTimer >= 10 && animationTimer < 20) {
			playerTexture = maggieHeads[1];
		} else {
			playerTexture = maggieHeads[2];
		}
	}

	public static void dispose() {
		keyNumFive.dispose();
		genericBackground.dispose();
		creditsOnePlayer.dispose();
		creditsTwoPlayer.dispose();
		creditsLabel.dispose();
		controllsLabel.dispose();
		backLabel.dispose();
		for (int i = 0; i < maggieHeads.length; i++) {
			maggieHeads[i].dispose();
		}
		playerTexture.dispose();
		playerOne.dispose();
		playerTwo.dispose();
		startGame.dispose();
		joinGame.dispose();
		buttonOnePlayer.dispose();
		buttonTwoPlayer.dispose();
		buttonKeyboard.dispose();
		controllsScreen.dispose();
		controllsScreenTwoPlayer.dispose();
	}
}
