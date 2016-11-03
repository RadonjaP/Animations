import java.awt.Color;
import java.util.Random;


public class Settings {
	
	private static Random r = new Random(200);
	
	// Canvas constants
	public static final int PANEL_WIDTH = 600;
	public static final int PANEL_HEIGHT = 450;
	public static final int FRAME_WIDTH = PANEL_WIDTH + 50;
	public static final int FRAME_HEIGHT = PANEL_HEIGHT + 50;
	
	// Object constants
	public static final int OBJECT_WIDTH = 60;
	public static final int OBJECT_HEIGHT = 60;
	public static final Color OBJECT_COLOR = Color.red;
	
	// Animation constants
	public static final int TIMER_DELAY = 5;
	
	public static final int RANDOM_NUM_RANGE_X = PANEL_WIDTH - 20;
	public static final int RANDOM_NUM_RANGE_Y = PANEL_HEIGHT - 20;
	
	public static int FLUENT_NUM_STEP_X = -1;
	public static int FLUENT_NUM_STEP_Y = 1;
	
	public static int MOVEMENT_LENGTH = r.nextInt(100);
	
}
