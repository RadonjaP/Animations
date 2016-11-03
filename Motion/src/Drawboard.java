import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Drawboard extends JPanel {

	private static final long serialVersionUID = 1L;
	private ColoredRectangle rectangle = new ColoredRectangle(0, 0, Color.green);
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int posX = rectangle.getPosX();
		int posY = rectangle.getPosY();
		g.setColor(rectangle.getColor());
		g.drawRect(posX, posY, MotionWindow.RECTANGLE_WIDTH, MotionWindow.RECTANGLE_HEIGHT);
		g.fillRect(posX, posY, MotionWindow.RECTANGLE_WIDTH, MotionWindow.RECTANGLE_HEIGHT);
	}

	public void drawRectangle() {
		repaint();
	}

	public void setRectangle(ColoredRectangle rectangle) {
		this.rectangle = rectangle;
	}
	
	public ColoredRectangle getRectangle() {
		return rectangle;
	}
	
}
