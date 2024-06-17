package com.tornadogame.input.keyboard;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.tornadogame.TornadoGame;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.gameobjects.Tornado;
import com.tornadogame.gameobjects.weapons.ShrapnelDrop;
import com.tornadogame.handlers.ShrapnelDropHandler;
import com.tornadogame.handlers.audio.SoundHandler;
import com.tornadogame.input.InputParent;
import com.tornadogame.ui.menu.Menu;


public class KeyboardInput extends InputParent implements ApplicationListener {

	public void handleInput(TornadoGame tornadoGame, OrthographicCamera camera, Player player, Tornado tornado, ShrapnelDropHandler shrapnelDropHandler) {
		
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			System.exit(0);
		}
		
		if (!TornadoGame.shouldStartGameplay) {
			handleInputTornado(camera, tornado, shrapnelDropHandler, tornadoGame);
			handleInputPlayer(camera, player, tornadoGame);
		}

		if (!TornadoGame.isAi) {
			if (tornadoGame.getGameType() == TornadoGame.TWO_PLAYER) {
				handleInputTornado(camera, tornado, shrapnelDropHandler, tornadoGame);
				handleInputPlayer(camera, player, tornadoGame);
			}
			else if (tornadoGame.getGameType() == TornadoGame.TORNADO) {
				handleInputTornado(camera, tornado, shrapnelDropHandler, tornadoGame);
			}
			else if (tornadoGame.getGameType() == TornadoGame.PLAYER) {
				handleInputPlayer(camera, player, tornadoGame);
			}
		}

		// TODO Remove this for release.
		// Zoom camera out.  Use this for debugging.
		handleDebugZoom(camera);
	}

	private void handleDebugZoom(OrthographicCamera camera) {
		if (Gdx.input.isKeyPressed(Input.Keys.Z) && Gdx.input.isKeyPressed(Input.Keys.O)) {
			camera.zoom += .01;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.Z) && Gdx.input.isKeyPressed(Input.Keys.I)) {
			camera.zoom -= .01;
		}
	}

	private void handleInputTornado(OrthographicCamera camera, Tornado tornado, ShrapnelDropHandler shrapnelDropHandler, TornadoGame tornadoGame) {
		if(Gdx.input.isKeyPressed(Input.Keys.A)){
			if (tornado.getX() > 0) {
				tornado.moveLeft();
			}
		} 

		if(Gdx.input.isKeyPressed(Input.Keys.D)){
			if (tornado.getX() + tornado.getWidth() < camera.viewportWidth) {
				tornado.moveRight();
				keyHeld = true;
			}
		} else {
			keyHeld = false;
		}

		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			tornado.moveUp();
		} 

		if(Gdx.input.isKeyPressed(Input.Keys.S)){
			tornado.moveDown();

			if (shrapnelDropHandler.getShrapnelDrop().size() > 0) {
				ShrapnelDrop.isDropped = true;
			}
		} 

		// Game is in main menu.
		if (!TornadoGame.shouldStartGameplay) {
			handleMainMenuTornado(tornadoGame);
		}
	}

	private void handleMainMenuTornado(TornadoGame tornadoGame) {
		if(Gdx.input.isKeyPressed(Input.Keys.P)){
			if (TornadoGame.splashScreenHasEnded) {
				TornadoGame.shouldStartGameplay = true;
			}
		}

		if(Gdx.input.isKeyPressed(Input.Keys.NUM_1)){
			TornadoGame.isAi         = false;
			TornadoGame.tornadoHasAi = false;
			TornadoGame.playerHasAi  = true;
			tornadoHasJoined         = true;
			tornadoGame.setGameType(TornadoGame.TORNADO);
			Menu.playTornadoUiSwoosh = true;

			if (tornadoHasJoined && playerHasJoined) {
				tornadoGame.setGameType(TornadoGame.TWO_PLAYER);
				TornadoGame.playerHasAi  = false;
			}
		}

		handleCreditsScreen();
		handleControlsScreen();
	}
	
	private void handleControlsScreen() {
		if (Gdx.input.isKeyPressed(Input.Keys.NUM_6) && !Menu.renderControllsScreen) {
			Menu.renderControllsScreen    = true;
			SoundHandler.playControllsHit = true;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.NUM_5) && Menu.renderControllsScreen) {
			Menu.renderControllsScreen    = false;
			SoundHandler.playControllsHit = true;
		} 
	}
	
	private void handleCreditsScreen() {
		if (Gdx.input.isKeyPressed(Input.Keys.NUM_7) && !Menu.renderCreditScreen) {
			Menu.renderCreditScreen     = true;
			SoundHandler.playCreditsHit = true;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.NUM_5) && Menu.renderCreditScreen) {
			Menu.renderCreditScreen     = false;
			SoundHandler.playCreditsHit = true;
		} 
	}

	private void handleMainMenuPlayer(TornadoGame tornadoGame) {
		if(Gdx.input.isKeyPressed(Input.Keys.P)){
			if (TornadoGame.splashScreenHasEnded) {
				TornadoGame.shouldStartGameplay = true;
			}
		}

		if(Gdx.input.isKeyPressed(Input.Keys.NUM_2)){
			TornadoGame.isAi         = false;
			TornadoGame.tornadoHasAi = true;
			TornadoGame.playerHasAi  = false;
			playerHasJoined          = true;
			tornadoGame.setGameType(TornadoGame.PLAYER);
			Menu.playMaggieUiSwoosh  = true;

			if (tornadoHasJoined && playerHasJoined) {
				tornadoGame.setGameType(TornadoGame.TWO_PLAYER);
				TornadoGame.tornadoHasAi  = false;
			}
		}
	}

	private void handleInputPlayer(OrthographicCamera camera, Player player, TornadoGame tornadoGame) {
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			if (player.getX() > 0) {
				player.moveLeft();
			}
		} 
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			if (player.getX() + player.getWidth() < camera.viewportWidth) {
				player.moveRight();
			}
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
			if (player.isCanJump() && !player.isStunned() && !player.isJumping()) {
				player.setJumping(true);
			}
		}

		// Game is in main menu.
		if (!TornadoGame.shouldStartGameplay) {
			handleMainMenuPlayer(tornadoGame);
		}
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
}
