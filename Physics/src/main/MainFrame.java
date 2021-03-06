package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import helpers.Constants;
import panels.AnimationPanel;
import panels.ControlPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		frame.setMinimumSize(new Dimension(Constants.PANEL_ANIMATION_WIDTH, Constants.PANEL_ANIMATION_HEIGHT));
		frame.setTitle(" Physics and Animations ");
		String projectPath = System.getProperty("user.dir");
		ImageIcon frameIcon = new ImageIcon(projectPath + "/resources/application_icon.png-c200");
		frame.setIconImage(frameIcon.getImage());
		
		AnimationPanel animationPanel = new AnimationPanel();
		frame.getContentPane().add(animationPanel, BorderLayout.CENTER);
		
		ControlPanel cp = new ControlPanel();
		frame.getContentPane().add(cp, BorderLayout.EAST);
		
		frame.setVisible(true);
		
		
	}

}
