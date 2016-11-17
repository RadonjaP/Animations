package objects;

import helpers.Constants;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import animationcore.objects.AbstractMovingObject;
import animationcore.physics.CVector;

public class ObjectWithGoal extends AbstractMovingObject {

	private Random r = new Random();
	
	private Integer ballRadius;
	private Color color;
	
	private Double goalX;
	private Double goalY;
	
	private Double longX;
	private Double longY;
	
	private Double normalizedX;
	private Double normalizedY;
	
	private Double magnitude;
	
	public ObjectWithGoal(CVector velocity, CVector acceleration) {
		position = new CVector(0f, 0f);
		this.ballRadius = Constants.BALL_RADIUS;
		position.setX(new Float(Constants.PANEL_WIDTH / 2 - (ballRadius / 2)));
		position.setY(new Float(Constants.PANEL_HEIGHT / 2 - (ballRadius / 2)));
		longX = r.nextInt(150) + 0.0;
		longY = r.nextInt(150) + 0.0;
		goalX = position.getX() + longX;
		goalY = position.getY() + longY;		
		this.velocity = velocity;
		this.acceleration = acceleration;
		magnitude = Math.sqrt(longX*longX + longY*longY);
		this.color = Color.RED;
		
		System.out.printf("OBJECT PROPERTIES: \n"
				+ "POSITION: (%.2f , %.2f) \n"
				+ "GOAL: (%.2f , %.2f) \n"
				+ "LONG x: %.2f  LONG y: %.2f \n"
				+ "MAGNITUDE: %.2f \n \n",
				position.getX(), position.getY(), goalX, goalY, longX, longY, magnitude);
	}
	
	
	@Override
	public void move() throws Exception {
		
		velocity.add(acceleration);
		
		normalizedX = (longX / magnitude) * velocity.getMagnitude();
		normalizedY = (longY / magnitude) * velocity.getMagnitude();
		
		position.setX((float) (position.getX() + normalizedX));
		position.setY((float) (position.getY() + normalizedY));
		
		System.out.printf("(%f , %f) \n"
				+ "VELOCITY: %f \n"
				+ "ACCELERATION: %f \n \n", 
				position.getX(), position.getY(), velocity.getMagnitude(), acceleration.getMagnitude());
		
		if (!checkLimit()) 
			throw new Exception();
		
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
	
	private boolean checkLimit() {
		return position.getX() <= goalX && position.getY() <= goalY;
	}

}