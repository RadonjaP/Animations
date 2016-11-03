import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class AnimationContainer extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private AnimationObject object = new AnimationObject(Settings.PANEL_WIDTH / 2, Settings.PANEL_HEIGHT / 2, Settings.OBJECT_COLOR);
	
	public AnimationContainer() {
		this.setSize(Settings.PANEL_WIDTH, Settings.PANEL_HEIGHT);
		this.setVisible(true);
	}
	
	public void moveObject(Integer x, Integer y) {
		System.out.printf("Object append move from (%d,%d) to (%d,%d) \n", object.getX(), object.getY(), x, y);
		
		moveObjectRegular(x, y);
		
		System.out.printf("Object moved to (%d,%d), appended to (%d,%d). \n", object.getX(), object.getY(), x, y);
	}
	
	private void moveObjectRegular(Integer x, Integer y) {
		object.move(x, y);
		repaint();	
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		object.draw(g);
		
		System.out.println("painted: " + object.getX() + " , " + object.getY());
	}
	
	public void setObjectColor(Color c) {
		object.setColor(c);
	}

 
}
