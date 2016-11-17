package objects;

import java.awt.Color;
import java.awt.Graphics2D;

import animationcore.objects.AbstractMovingObject;
import animationcore.physics.CVector;
import helpers.Constants;

public class BallObject extends AbstractMovingObject {

	private Integer ballRadius;
	private Color color;
	
	public BallObject(CVector velocity, CVector acceleration) {
		position = new CVector(0f, 0f);
		this.velocity = velocity;
		this.acceleration = acceleration;
		this.ballRadius = Constants.BALL_RADIUS; 
		position.setX(new Float(Constants.PANEL_WIDTH / 2 - (ballRadius / 2)));
		position.setY(new Float(Constants.PANEL_HEIGHT / 2 - (ballRadius / 2)));
		this.color = Color.RED;
	}

	@Override
	public void move() {
		velocity.add(acceleration);
		position.add(velocity);
		checkLimit();
		String status = String.format(
				"    Ball status: "
				+ "POSITION (%1$.2f,%2$.2f)              "
				+ "VELOCITY(%3$.2f,%4$.2f)               "
				+ "ACCELERATION (%5$.4f,%6$.4f)          ",
				position.getX(),position.getY(),
				velocity.getX(), velocity.getY(),
				acceleration.getX(), acceleration.getY()
			);
		Constants.statusLabel.setBackground(Color.BLUE);;
		Constants.statusLabel.setText(status);
		
		
	}

	@Override
	public void draw(Graphics2D g) {
		g.setPaint(color);
		g.fillOval(Math.round(position.getX()), Math.round(position.getY()), ballRadius, ballRadius);
		g.setColor(Color.WHITE);
		g.fillOval(Math.round(position.getX()) + 7, Math.round(position.getY()) + 5,
				(int)Math.round(ballRadius - (ballRadius * 0.75)), 
				(int)Math.round(ballRadius - (ballRadius * 0.35)));
	}
	
	
	private void checkLimit() {
		if (position.getX() < 0.0 || position.getX() - ballRadius / 2 > Constants.PANEL_WIDTH) {
			this.acceleration.setX(acceleration.getX() * -1);
			this.velocity.setX(velocity.getX() * -1);
		}
		if (position.getY() < 0.0 || position.getY() + (ballRadius / 2) > Constants.PANEL_HEIGHT) {
			this.acceleration.setY(acceleration.getY() * -1);
			this.velocity.setY(velocity.getY() * -1);
		}
	}
	
	
}