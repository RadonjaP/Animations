package panels;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import helpers.Constants;

public class ControlPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField sleepTime;

	public ControlPanel() {
		
		JPanel accPanel = setupAccelerationMenu();
		JPanel velPanel = setupVelocityMenu();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(accPanel);
		add(velPanel);
		
		JLabel sleepTimeLbl = new JLabel("Sleep time ");
		sleepTime = new JTextField();
		
		sleepTime.setText(String.valueOf(Constants.SIMULATION_SLEEP_TIME));
		sleepTime.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Constants.SIMULATION_SLEEP_TIME = Integer.parseInt(sleepTime.getText());
			}
		});
		
		add(sleepTimeLbl);
		add(sleepTime);
		
		setVisible(true);
		
		
	}
	
	public JPanel setupAccelerationMenu() {
		JPanel accPanel = new JPanel();
		accPanel.setLayout(new FlowLayout());
		JLabel accLabel = new JLabel("Acceleration ");
		JButton accUp = new JButton(" + ");
		JButton accDown = new JButton(" - ");
		accPanel.add(accLabel);
		accPanel.add(accUp);
		accPanel.add(accDown);
		
		accUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Constants.OBJECT_ACCELERATION++;
			}
		});
		
		accDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Constants.OBJECT_ACCELERATION--;
			}
		});
		accPanel.setVisible(true);
		
		return accPanel;
	}
	
	public JPanel setupVelocityMenu() {
		JPanel velPanel = new JPanel();
		velPanel.setLayout(new FlowLayout());
		JLabel velLabel = new JLabel("Velocity ");
		JButton velUp = new JButton(" + ");
		JButton velDown = new JButton(" - ");
		velPanel.add(velLabel);
		velPanel.add(velUp);
		velPanel.add(velDown);
		
		velUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Constants.OBJECT_VELOCITY++;
			}
		});
		
		velDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Constants.OBJECT_VELOCITY--;
			}
		});
		velPanel.setVisible(true);
		
		return velPanel;
	}
	
}
