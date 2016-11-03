import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;


public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Timer timer;
	private ActionListener moveAction;
	private AnimationContainer container;
	private AlgorithmContainer alghCont;
	
	public MainFrame() {
		container = new AnimationContainer();
		alghCont = new AlgorithmContainer();
		
		this.setSize(Settings.FRAME_WIDTH, Settings.FRAME_HEIGHT);
		this.setTitle("Animation");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.getContentPane().add(container);

		this.moveAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Point nextPos = alghCont.getPosition();
				container.moveObject(nextPos.x, nextPos.y);
			}
		};
		
		this.timer = new Timer(Settings.TIMER_DELAY, moveAction);
		this.timer.start();
	}
	
	public static void main(String[] args) {

		new MainFrame();
		
	}
	
}
