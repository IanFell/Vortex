package com.tornadogame.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tornadogame.TornadoGame;
import com.tornadogame.gameobjects.GameObject;
import com.tornadogame.gameobjects.Player;
import com.tornadogame.handlers.LevelHandler;
import com.tornadogame.levels.Level;

public class Message extends GameObject {

	private final int GROWTH_VALUE = 45;

	private final int MESSAGE_DISPLAY_VALUE = 30;

	private boolean shouldDisplayMessage;

	private int timer;

	public static final int MESSAGE_BOOM            = 0;
	public static final int MESSAGE_SUCK            = 1;
	public static final int MESSAGE_BONUS           = 2;
	public static final int MESSAGE_SPEED           = 3;
	public static final int MESSAGE_OUCH            = 4;
	public static final int MESSAGE_WINNER          = 5;
	public static final int MESSAGE_ULTIMATE_WINNER = 6;

	private int messageType;

	protected static Texture boomTexture;
	protected static Texture suckTexture;
	protected static Texture bonusTexture;
	protected static Texture speedTexture;
	protected static Texture ouchTexture;
	protected static Texture winnerTexture;
	protected static Texture ultimateWinnerTexture;

	protected static Texture plus50;
	protected static Texture minus50;

	private float dropScoreY;

	public static boolean isRenderingUltimateWinner;

	private int speedBoostColorTimer;
	private int speedBoostColorIncrement;
	private final int MAX_SPEED_BOOST_COLORS = 9;
	private Color[] speedBoostColor = new Color[MAX_SPEED_BOOST_COLORS];

	public Message(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		super(x, y, width, height, texture, dx, dy);
		shouldDisplayMessage  = false;
		timer                 = 0;
		messageType           = MESSAGE_BOOM;
		boomTexture           = new Texture("artwork/ui/messages/Boom.png");
		suckTexture           = new Texture("artwork/ui/messages/Suck.png");
		bonusTexture          = new Texture("artwork/ui/messages/Bonus.png");
		speedTexture          = new Texture("artwork/ui/messages/Speed.png");
		ouchTexture           = new Texture("artwork/ui/messages/Ouch.png");
		winnerTexture         = new Texture("artwork/ui/messages/Winner.png");
		ultimateWinnerTexture = new Texture("artwork/ui/messages/UltimateWinner.png");

		plus50  = new Texture("artwork/ui/messages/Plus50.png");
		minus50 = new Texture("artwork/ui/messages/Minus50.png");

		dropScoreY = 0;

		isRenderingUltimateWinner = true;

		speedBoostColorTimer     = 0;
		speedBoostColorIncrement = 4;
		speedBoostColor[0]       = new Color(Color.WHITE);
		speedBoostColor[1]       = new Color(Color.BLUE);
		speedBoostColor[2]       = new Color(Color.GREEN);
		speedBoostColor[3]       = new Color(Color.YELLOW);
		speedBoostColor[4]       = new Color(Color.PINK);
		speedBoostColor[5]       = new Color(Color.ORANGE);
		speedBoostColor[6]       = new Color(Color.CYAN);
		speedBoostColor[7]       = new Color(Color.PURPLE);
		speedBoostColor[8]       = new Color(Color.RED);
	}

	public void setShouldDisplayMessage(boolean shouldDisplayMessage, int messageType, float xPos, float yPos) {
		this.shouldDisplayMessage = shouldDisplayMessage;
		this.messageType          = messageType;
		this.x                    = xPos;
		this.y                    = yPos;
	}

	public void draw(SpriteBatch batch) {
		if (shouldDisplayMessage) {
			Texture texture = boomTexture;
			//batch.setColor(Color.RED);
			Texture dropScoreTexture = minus50;
			if (messageType == MESSAGE_SUCK) {
				texture = suckTexture;
			} else if (messageType == MESSAGE_BONUS) {
				texture = bonusTexture;
				batch.setColor(Color.YELLOW);
				dropScoreTexture = plus50;
				batch.draw(dropScoreTexture, x, y + dropScoreY, width / 2, height * 2 / 2);
			} else if (messageType == MESSAGE_SPEED) {
				texture = speedTexture;
				// TODO Make it flash rainbow colors.
				handleSpeedBoostColor(batch);

			} else if (messageType == MESSAGE_OUCH) {
				texture = ouchTexture;
				batch.setColor(Color.RED);
				dropScoreTexture = minus50;
				batch.draw(dropScoreTexture, x, y + dropScoreY, width / 2, height * 2 / 2);
			} else if (messageType == MESSAGE_WINNER) {
				texture = winnerTexture;
			} else if (messageType == MESSAGE_ULTIMATE_WINNER) {
				texture = ultimateWinnerTexture;
			} else if (messageType == MESSAGE_BOOM) {
				batch.setColor(Color.RED);
				dropScoreTexture = minus50;
				batch.draw(dropScoreTexture, x, y + dropScoreY, width / 2, height * 2 / 2);
			}

			//batch.draw(dropScoreTexture, x, y + dropScoreY, width / 2, height * 2 / 2);
			if (messageType != MESSAGE_SPEED) {
				batch.setColor(Color.WHITE);
			}

			batch.draw(texture, x, y, width, height);
		}
	}

	private void handleSpeedBoostColor(SpriteBatch batch) {

		speedBoostColorTimer++;
		if (speedBoostColorTimer > MAX_SPEED_BOOST_COLORS) {
			speedBoostColorTimer = 0;
		}

		if (speedBoostColorTimer < speedBoostColorIncrement) {
			batch.setColor(speedBoostColor[0]);
		}
		else if (speedBoostColorTimer >= speedBoostColorIncrement && speedBoostColorTimer < speedBoostColorIncrement * 2) {
			batch.setColor(speedBoostColor[1]);
		}
		else if (speedBoostColorTimer >= speedBoostColorIncrement * 2 && speedBoostColorTimer < speedBoostColorIncrement * 3) {
			batch.setColor(speedBoostColor[2]);
		}
		else if (speedBoostColorTimer >= speedBoostColorIncrement * 3 && speedBoostColorTimer < speedBoostColorIncrement * 4) {
			batch.setColor(speedBoostColor[3]);
		}
		else if (speedBoostColorTimer >= speedBoostColorIncrement * 4 && speedBoostColorTimer < speedBoostColorIncrement * 5) {
			batch.setColor(speedBoostColor[4]);
		}
		else if (speedBoostColorTimer >= speedBoostColorIncrement * 5 && speedBoostColorTimer < speedBoostColorIncrement * 6) {
			batch.setColor(speedBoostColor[5]);
		}
		else if (speedBoostColorTimer >= speedBoostColorIncrement * 6 && speedBoostColorTimer < speedBoostColorIncrement * 7) {
			batch.setColor(speedBoostColor[6]);
		}
		else if (speedBoostColorTimer >= speedBoostColorIncrement * 7 && speedBoostColorTimer < speedBoostColorIncrement * 8) {
			batch.setColor(speedBoostColor[7]);
		}
		else if (speedBoostColorTimer >= speedBoostColorIncrement * 8 && speedBoostColorTimer < speedBoostColorIncrement * 9) {
			batch.setColor(speedBoostColor[8]);
		}
	}

	public void update(Player player, Level level) {
		if (shouldDisplayMessage) {
			timer++;
			if (timer > MESSAGE_DISPLAY_VALUE) {
				shouldDisplayMessage = false;
				timer                = 0;
			}
			dropScoreY += 10;
		} else {
			dropScoreY = 0;
		}

		/**
		 * This makes the "Ultimate Winner" UI grow and expand offscreen.  
		 * When commented out, it will retain the width and height of the regular level "Winner" UI dimensions. 
		 */
		/*if (TornadoGame.levelToLoad == LevelHandler.LEVEL_END && level.isLevelIsOver()) {
			width += GROWTH_VALUE;
			height += GROWTH_VALUE;
		} */

		// This enlarges "Ultimate Winner" UI.
		if (TornadoGame.levelToLoad == LevelHandler.LEVEL_END && level.isLevelIsOver() && isRenderingUltimateWinner) {
			width *= 3;
			height *= 3;
			isRenderingUltimateWinner = false;
		}
	}

	public static void dispose() {
		boomTexture.dispose();
		suckTexture.dispose();
		bonusTexture.dispose();
		speedTexture.dispose();
		ouchTexture.dispose();
		winnerTexture.dispose();
		ultimateWinnerTexture.dispose();
		plus50.dispose();
		minus50.dispose();
	}
}
