package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import helpers.Constants;
import helpers.MVector;
import object.BallObject;

public class AnimationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private BallObject ball = new BallObject();
	
	public AnimationPanel() {
		
		this.setSize(Constants.PANEL_ANIMATION_WIDTH, Constants.PANEL_ANIMATION_HEIGHT);
		this.setMaximumSize(new Dimension(Constants.PANEL_ANIMATION_WIDTH, Constants.PANEL_ANIMATION_HEIGHT));
		this.setMinimumSize(new Dimension(BallObject.BALL_WIDTH, BallObject.BALL_HEIGHT));
		this.setOpaque(true);
		this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
		this.setVisible(true);
		this.setObjectProperties();
		
		Thread animation = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					
					nextStep();
					
					try {
						Thread.sleep(Constants.SIMULATION_SLEEP_TIME);
					} catch (InterruptedException e) {
						
					}
    			}
			}
		});
		animation.start();
		
	}
	
	private void setObjectProperties() {
		this.ball.setPosition(new MVector(Constants.PANEL_ANIMATION_WIDTH / 2.0 - BallObject.BALL_WIDTH / 2,
				Constants.PANEL_ANIMATION_HEIGHT / 2.0 - BallObject.BALL_HEIGHT / 2));
		this.ball.setAcceleration(new MVector(Constants.OBJECT_ACCELERATION, Constants.OBJECT_ACCELERATION));
		this.ball.setVelocity(new MVector(Constants.OBJECT_VELOCITY, Constants.OBJECT_VELOCITY));
	}

	private void nextStep() {
		ball.moveObject();
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ball.drawObject(g);
	}
	
	// TODO This won't work properly
	public void changeAcc(Double acc) {
		ball.setAcceleration(new MVector(acc, acc));
	}
	
	public void changeVel(Double vel) {
		ball.setVelocity(new MVector(vel, vel));
	}
	
}
