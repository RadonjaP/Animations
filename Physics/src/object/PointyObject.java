package object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import helpers.Constants;

public class PointyObject extends AbstractMovingObject {

	public static final Integer BALL_WIDTH = 10;
	public static final Integer BALL_HEIGHT = 10;
	private Color color;

	public PointyObject(Color color) {
		this.color = color;
	}

	@Override
	public void moveObject() {
		moveObjectWithAngle();
		checkCollision();
	}

	@Override
	public void drawObject(Graphics g) {
		g.setColor(color);
		g.fillOval(this.position.getX().intValue(), this.position.getY().intValue(), BALL_WIDTH, BALL_HEIGHT);
//		g.setColor(Color.BLUE);
//		g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
//		String textInfoTop = String.format("(%.0f,%.0f)", 
//				position.getX(), position.getY());
//		g.drawString(textInfoTop, position.getX().intValue(), position.getY().intValue() - 4);
//		String textInfoBottom = String.format("s:%.2f a:%.0f", 
//				velocity.getX(), Math.toDegrees(angle));
//		g.drawString(textInfoBottom, position.getX().intValue(), position.getY().intValue() + BALL_HEIGHT + 10);
//		g.setColor(color);
//		int lineX = position.getX().intValue() + (BALL_WIDTH / 2);
//		int lineY = position.getY().intValue() + (BALL_HEIGHT / 2);
//		
//		Double x = Math.cos(angle) * BALL_WIDTH;
//		Double y = Math.sin(angle) * BALL_HEIGHT;
//		
//		g.drawLine(lineX, lineY, lineX + x.intValue(), lineY + y.intValue());

	}

	@Override
	public boolean checkCollision() {
		int outOfBoundsValue = outOfBounds();
		if (outOfBoundsValue != 0) {
			double oldAngle = Math.toDegrees(angle);
			double alpha = outOfBoundsValue - oldAngle;
			if (alpha >= 360) {
				alpha -= 360;
			}
			this.angle = Math.toRadians(alpha);
			return true;
		} 
		return false;
	}
	
	public int outOfBounds() {
		if (outOfBoundsX()) {
			return 180;
		} else if (outOfBoundsY()) {
			return 360;
		}
		return 0;
	}
	
	public boolean outOfBoundsX() {
		return this.position.getX() < 0 ||
			this.position.getX() + BALL_WIDTH > Constants.PANEL_ANIMATION_WIDTH;
	}
	public boolean outOfBoundsY() {
		return this.position.getY() < 0 ||
			this.position.getY() + BALL_HEIGHT > Constants.PANEL_ANIMATION_HEIGHT;
	}

	private void moveObjectWithAngle() {
		double newAngle =  Math.toDegrees(angle);
		if (newAngle >= 360) {
			newAngle -= 360;
		}
		this.angle = Math.toRadians(newAngle);
		
		double x = Math.cos(angle) * velocity.getX();
		double y = Math.sin(angle) * velocity.getY();
		position.setX(position.getX() + x);
		position.setY(position.getY() + y);
	}

	public Color getColor() {
		return this.color;
	}

}
