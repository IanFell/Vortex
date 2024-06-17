package com.tornadogame.input;

public class InputParent {

	public static boolean keyHeld = false;

	protected boolean tornadoHasJoined;
	protected boolean playerHasJoined;

	public InputParent() {
		tornadoHasJoined = false;
		playerHasJoined  = false;
	}

	public boolean isTornadoHasJoined() {
		return tornadoHasJoined;
	}

	public boolean isPlayerHasJoined() {
		return playerHasJoined;
	}
}
