package animation.main;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainFrame() {
		this.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		this.setTitle("Motion main frame");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.getContentPane().add(new AnimationPanel(), BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		
		new MainFrame();
		
	}
	
}
