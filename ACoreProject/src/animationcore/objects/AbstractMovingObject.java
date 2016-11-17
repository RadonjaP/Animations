package animationcore.objects;

import java.awt.Graphics2D;

import animationcore.physics.CVector;

public abstract class AbstractMovingObject {

	protected CVector position;
	protected CVector velocity;
	protected CVector acceleration;
	
	public AbstractMovingObject() {
		super();
	}

	// Move object and set parameters
	public abstract void move() throws Exception;

	// Draw object on canvas
	public abstract void draw(Graphics2D g);
	
	public void setAcceleration(CVector accelerationNew) {
		this.acceleration = accelerationNew;
	}
	
	public void setVelocity(CVector velocityNew) {
		this.velocity = velocityNew;
	}
	
	public void setPosition(CVector positionNew) {
		this.position = positionNew;
	}
	
}
