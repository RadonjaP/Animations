import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MotionWindow {
	
	public static final int ITERATION_NUMBER = 10000;
	public static final int THREAD_SLEEP_TIME = 1;
	public static final int RANDOM_NUMBER_RANGE = 400;
	
	public static final int SCREEN_HEIGHT = 550;
	public static final int SCREEN_WIDTH = 750;
	
	public static final int RECTANGLE_WIDTH = 25;
	public static final int RECTANGLE_HEIGHT = 10;
	
	private static Random r = new Random();

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		Drawboard drawboard = new Drawboard();
		JPanel northPanel = new JPanel();
		Label iterationLabel = new Label("Remaining iterations: ");
		
		Label redLabel = new Label("Red: ");
		Label greenLabel = new Label("Green: ");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.getContentPane().add(drawboard, BorderLayout.CENTER);
		frame.getContentPane().add(northPanel, BorderLayout.NORTH);
		frame.setVisible(true);
		
		frame.getContentPane().add(iterationLabel, BorderLayout.SOUTH);
		
		northPanel.add(redLabel, BorderLayout.WEST);
		northPanel.add(greenLabel, BorderLayout.EAST);
		
		
		int i = 0;
		
		int pos_x = SCREEN_WIDTH / 2;
		int pos_y = SCREEN_HEIGHT / 2;
		Color color = Color.black;
		
		int greenNum = 0;
		int redNum = 0;
		
		int redPerc = 0;
		int greenPerc = 0;
		
		while(i <= ITERATION_NUMBER) {

			drawboard.getRectangle().setPosition(pos_x, pos_y);
			drawboard.getRectangle().setColor(color);
			drawboard.drawRectangle();
			
			/* ALGORITHM PART START */
			int step = r.nextInt(4);
			System.out.println(step);
			switch (step) {
				case 0: 
//					/color = Color.red;
					pos_x += 1;
					break;
				case 1: 
//					color = Color.blue;
					pos_y -= 1;
					break;
				case 2: 
					//color = Color.green; 
					pos_y += 1;
					break;
				case 3: 
					//color = Color.yellow; 
					pos_x -= 1;
					break;
			}
			
			/* ALGORITHM PART END */
			
			try {
				Thread.sleep(THREAD_SLEEP_TIME);	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
//			redPerc = (redNum * 100) / (redNum + greenNum);
//			greenPerc = 100 - redPerc;
			
			iterationLabel.setText("Remaining iterations: " + (ITERATION_NUMBER - i) + " pos (x,y): ("+pos_x+" , "+pos_y+") ");
			redLabel.setText("Red: " + redNum + " percentage: " + redPerc + " %");
			greenLabel.setText("Green: " + greenNum + " percentage: " + greenPerc + " %");
			
			
			i++;
		}
		
	}

	@SuppressWarnings("unused")
	private void randomPositionAlgorithm(int pos_x, int pos_y, Color color, int greenNum, int redNum) {
		if (pos_x < RANDOM_NUMBER_RANGE / 2) {
			color = Color.green;
			greenNum++;
		} else {
			color = Color.red;
			redNum++;
		}

		pos_x = r.nextInt(RANDOM_NUMBER_RANGE);
		pos_y = r.nextInt(RANDOM_NUMBER_RANGE);	
	}
	
	@SuppressWarnings("unused")
	private void smoothMovingAlgorithm(int pos_x, int pos_y, Color color) {
		
		int step = r.nextInt(4);
		
		System.out.println(step);
		
		switch (step) {
			case 0: 
				color = Color.red;
				pos_x += 1;
				break;
			case 1: 
				color = Color.blue;
				pos_x -= 1;
				break;
			case 2: 
				color = Color.green; 
				pos_y += 1;
				break;
			default: 
				color = Color.yellow; 
				pos_y += 1;
				break;
		}
		
	}

}
