package animation.object;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class AbstractAnimationObject {

	protected Integer x;
	protected Integer y;
	protected Integer speedX;
	protected Integer speedY;
	
	protected Color color;
	
	public AbstractAnimationObject(Integer x, Integer y, Integer speedX, Integer speedY) {
		this.x = x;
		this.y = y;
		this.speedX = speedX;
		this.speedY = speedY;
		this.color = Color.red;
	}

	// Method for moving object coordinates
	public abstract void move(Integer x, Integer y);
	
	// Method for drawing object
	public abstract void draw(Graphics2D g);
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setSpeedX(Integer speedX) {
		this.speedX = speedX;
	}
	
	public void speedY(Integer speedY) {
		this.speedY = speedY;
	}

	
}