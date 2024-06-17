package com.tornadogame.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.tornadogame.TornadoGame;
import com.tornadogame.handlers.PowerUpHandler;
import com.tornadogame.handlers.pointsanddamage.PointHandler;
import com.tornadogame.ui.Message;

public class GameObject {

	protected float x;
	protected float y;
	protected float width;
	protected float height;

	protected Texture texture;

	protected float dx;
	protected float dy;

	protected Rectangle rectangle;

	protected float points;

	private final float LEVEL_OVER_SCALE_VALUE = 20;

	protected Texture textureToDraw;

	protected float animationTimer;
	protected int ANIMATION_TIMER_MAX = 30;

	protected Texture[] animationTexture = new Texture[6];

	protected float backgroundWidth;
	protected float backgroundHeight;
	protected boolean backgroundIsGrowing;
	protected float shineIncrement;
	protected final int BACKGROUND_MIN = 3200;
	protected final int BACKGROUND_MAX = 3250;

	public GameObject(float x, float y, float width, float height, Texture texture, float dx, float dy) {
		this.x                = x;
		this.y                = y;
		this.width            = width;
		this.height           = height;
		this.texture          = texture;
		this.dx               = dx;
		this.dy               = dy;
		rectangle             = new Rectangle(x, y, width, height);
		points                = 0;
		animationTimer        = 0;
		backgroundIsGrowing   = true;
		shineIncrement        = 0.2f;
	}

	public Texture getTextureToDraw() {
		return textureToDraw;
	}

	protected void loadTornadoTextures() {
		animationTexture[0] = new Texture("artwork/tornado/T_01.png");
		animationTexture[1] = new Texture("artwork/tornado/T_02.png");
		animationTexture[2] = new Texture("artwork/tornado/T_03.png");
		animationTexture[3] = new Texture("artwork/tornado/T_04.png");
		animationTexture[4] = new Texture("artwork/tornado/T_05.png");
		animationTexture[5] = new Texture("artwork/tornado/T_06.png");
	}

	public void draw(SpriteBatch batch) {
		batch.draw(texture, x, y, width, height);
	}

	protected void checkScreenTopBoundaryCollision() {
		if (y + height > TornadoGame.screenHeight) {
			y = TornadoGame.screenHeight - height - 1;
		}
	}

	public float getPoints() {
		return points;
	}

	public void setPoints(float points) {
		this.points = points;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void moveUp() {
		y += dy;
	}

	public float getWidth() {
		return width;
	}

	public void moveLeft() {
		x -= dx;
	}

	public void moveRight() {
		x += dx;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getY() {
		return y;
	}

	public float getHeight() {
		return height;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public float getDy() {
		return dy;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public void updateWinner(float maxWidth, float maxHeight) {
		if (width < maxWidth) {
			width += LEVEL_OVER_SCALE_VALUE;
		} else {
			width = maxWidth + 1;
		}
		if (height < maxHeight) {
			height += LEVEL_OVER_SCALE_VALUE;
		} else {
			height = maxHeight + 1;
		}
		if (x <= TornadoGame.screenWidth / 2 - width / 2) {
			x += LEVEL_OVER_SCALE_VALUE;
		} else {
			x -= LEVEL_OVER_SCALE_VALUE;
		} 
		if (y <= TornadoGame.screenHeight / 2 - height / 2) {
			y += LEVEL_OVER_SCALE_VALUE;
		} else {
			y -= LEVEL_OVER_SCALE_VALUE;
		}
	}

	protected void handleAnimation() {
		animationTimer++;
		if (animationTimer < ANIMATION_TIMER_MAX) {
			if (animationTimer < 5) {
				textureToDraw = animationTexture[0];
			}
			else if (animationTimer >= 5 && animationTimer < 10) {
				textureToDraw = animationTexture[1];
			}
			else if (animationTimer >= 10 && animationTimer < 15) {
				textureToDraw = animationTexture[2];
			}
			else if (animationTimer >= 15 && animationTimer < 20) {
				textureToDraw = animationTexture[3];
			}
			else if (animationTimer >= 20 && animationTimer < 25) {
				textureToDraw = animationTexture[4];
			}
			else if (animationTimer >= 25 && animationTimer < 30) {
				textureToDraw = animationTexture[5];
			}
		}
		if (animationTimer >= ANIMATION_TIMER_MAX) {
			animationTimer = 0;
		}
	}

	public void updateLoser() {
		width -= LEVEL_OVER_SCALE_VALUE;
		height -= LEVEL_OVER_SCALE_VALUE;
	}

	protected void checkPointBoost(Message message, PowerUpHandler powerUpHandler) {
		for (int i = 0; i < powerUpHandler.getPointBoost().length; i++) {
			if (rectangle.overlaps(powerUpHandler.getPointBoost()[i].getRectangle()) && !powerUpHandler.getPointBoost()[i].isHasBeenCollected()) {
				points += PointHandler.POINT_VALUE_POINTS_BOOST;
				powerUpHandler.getPointBoost()[i].setHasBeenCollected(true);
				message.setShouldDisplayMessage(true, Message.MESSAGE_BONUS, x, y);
				powerUpHandler.getPointBoost()[i].setPlayPointsBoostAudio(true);
			}
		}
	}

	public void setDx(float dx) {
		this.dx = dx;
	}

	public void setDy(float dy) {
		this.dy = dy;
	}

	/**
	 * This method makes the background starts grow and shrink by slightly resizing
	 * the background image.
	 */
	protected void handleStarsShining() {
		if (backgroundIsGrowing) {
			if (backgroundWidth < BACKGROUND_MAX) {
				backgroundWidth += shineIncrement;
				backgroundHeight += shineIncrement;
			} 
			if (backgroundWidth >= BACKGROUND_MAX) {
				backgroundIsGrowing = false;
			}
		}

		if (!backgroundIsGrowing) {
			if (backgroundWidth > BACKGROUND_MIN) {
				backgroundWidth -= shineIncrement;
				backgroundHeight -= shineIncrement;
			}
			if (backgroundWidth <= BACKGROUND_MIN) {
				backgroundIsGrowing = true;
			}
		}
	}

	public float getDx() {
		return dx;
	}
	
	/*
	public static void dispose() {
		//texture.dispose();
		textureToDraw.dispose();
		for (int i = 0; i < animationTexture.length; i++) {
			animationTexture[i].dispose();
		}
	} */
	
	public Texture getTexture() {
		return texture;
	}
}
