import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import animationcore.physics.CVector;
import helpers.Constants;
import objects.BallObject;

public class AnimationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private BallObject object = new BallObject(new CVector(Constants.BALL_VELOCITY
			, Constants.BALL_VELOCITY),
			new CVector(Constants.BALL_ACCELLERATION,
					Constants.BALL_ACCELLERATION));

	public AnimationPanel() {
		
		this.setSize(Constants.PANEL_WIDTH, Constants.PANEL_HEIGHT);
		this.setVisible(true);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				while (true) {
					
					moveObject();
					
					try {
						Thread.sleep(Constants.SLEEP_TIME);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		object.draw(g2D);
	}
	
	public void moveObject() {
		object.move();
		repaint();
	}

}