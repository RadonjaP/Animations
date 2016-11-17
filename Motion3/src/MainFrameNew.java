import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import helpers.Constants;

public class MainFrameNew extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MainFrameNew() {
		this.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		this.setTitle("Animation panel");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.getContentPane().add(new AnimationPanel(), BorderLayout.CENTER);

		// Add status panel
		JPanel statusPanel = new JPanel();
		Constants.statusLabel.setSize(Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH);
		statusPanel.add(Constants.statusLabel);
		statusPanel.setBackground(Color.green);
		this.getContentPane().add(statusPanel,BorderLayout.NORTH);
		
		// Add control panel
		JPanel controlPanel = new JPanel(new GridLayout(0, 1));
		
		JPanel accelerationControlPanel = new JPanel();
		JButton buttonAccelerationUp = new JButton(" + ");
		JButton buttonAccelerationDown = new JButton(" - ");
		
		accelerationControlPanel.add(new JLabel("Acceleration"));
		accelerationControlPanel.add(buttonAccelerationDown);
		accelerationControlPanel.add(buttonAccelerationUp);
		
		JButton buttonVelocityUp = new JButton(" + ");
		JButton buttonVelocityDown = new JButton(" - ");
		
		JPanel velocityControlPanel = new JPanel();
		velocityControlPanel.add(new JLabel("Velocity"));
		velocityControlPanel.add(buttonVelocityUp);
		velocityControlPanel.add(buttonVelocityDown);
		
		controlPanel.add(accelerationControlPanel);
		controlPanel.add(velocityControlPanel);
		
		this.getContentPane().add(controlPanel,BorderLayout.EAST);
	}

	public static void main(String[] args) {

		new MainFrameNew();
		
	}

}