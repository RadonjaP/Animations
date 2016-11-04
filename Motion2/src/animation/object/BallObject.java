package animation.object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import animation.main.Constants;

public class BallObject extends AbstractAnimationObject {

	private Integer radius;
	
	public BallObject(Integer x, Integer y, Integer speedX, Integer speedY) {
		super(x, y, speedX, speedY);
		this.radius = Constants.OBJECT_BALL_RADIUS;
	}

	@Override
	public void move(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setPaint(color);
		g.fillOval(x, y, radius, radius);
		g.setColor(Color.WHITE);
		g.fillOval(x + 5, y + 3,
				(int)Math.round(radius - (radius * 0.75)), 
				(int)Math.round(radius - (radius * 0.35)));
	}
	
	public Point getCoordinates() {
		Point p = new Point(this.x, this.y);
		return p;
	}

}