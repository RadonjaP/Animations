package object;

import java.awt.Color;
import java.awt.Graphics;

import helpers.Constants;

public class BallObject extends AbstractMovingObject {

	public static final Integer BALL_WIDTH = 70;
	public static final Integer BALL_HEIGHT = 70;
	
	@Override
	public void moveObject() {
		velocity.add(acceleration);
		position.add(velocity);
		checkCollision();
		System.out.printf("Ball data:  \n"
				+ "position: (%.2f , %.2f) \n"
				+ "velocity: (%.2f , %.2f) \n"
				+ "accelera: (%.2f , %.2f) \n"
				+ "------------------- \n",
				position.getX(), position.getY(),
				velocity.getX(), velocity.getY(),
				acceleration.getX(), acceleration.getY());
	}

	@Override
	public void drawObject(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(this.position.getX().intValue(), this.position.getY().intValue(),
				BALL_WIDTH, BALL_HEIGHT);
		g.setColor(Color.WHITE);
		g.fillOval(this.position.getX().intValue() + 7, this.position.getY().intValue() + 7, 
				BALL_WIDTH / 3, BALL_HEIGHT / 3);
		g.setColor(Color.BLUE);
		g.drawLine(Constants.PANEL_ANIMATION_WIDTH, Constants.PANEL_ANIMATION_HEIGHT,
				position.getX().intValue() + BALL_WIDTH / 2, position.getY().intValue() + BALL_HEIGHT / 2);
	}

	@Override
	public boolean checkCollision() {		
		if (this.position.getX() < 0 || this.position.getX() + BALL_WIDTH > Constants.PANEL_ANIMATION_WIDTH) {
			acceleration.setX(-acceleration.getX());
			velocity.setX(-velocity.getX());
			Double posX = this.position.getX() < 0 ? 0 : Constants.PANEL_ANIMATION_WIDTH.doubleValue() - BALL_WIDTH;
			position.setX(posX);
			if (Math.abs(velocity.getX()) >= Constants.VELOCITY_LIMITATION) {
				acceleration.setX(-acceleration.getX());
			}    
			return false;
		}
		if (this.position.getY() < 0 || this.position.getY() + BALL_HEIGHT > Constants.PANEL_ANIMATION_HEIGHT) {
			acceleration.setY(-acceleration.getY());
			Double posY = this.position.getY() < 0 ? 0 : Constants.PANEL_ANIMATION_HEIGHT.doubleValue() - BALL_HEIGHT;
			velocity.setY(-velocity.getY());
			position.setY(posY);
			if (Math.abs(velocity.getY()) >= Constants.VELOCITY_LIMITATION) {
				acceleration.setY(-acceleration.getY()); 
			}
			return false;
		}
		return true;
	}

}