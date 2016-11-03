import java.awt.Point;
import java.util.Random;


public class AlgorithmContainer {

	private Random r = new Random();
	
	private int posX = Settings.PANEL_WIDTH / 2;
	private int posY = Settings.PANEL_HEIGHT / 2;
	
	public Point getAlgorithm() {
		return getNextPositionFluent();
	}
	
	/* ALGORITHM METHODS */
	
	/* Random generated location */
	@SuppressWarnings("unused")
	private Point getNextPositionRandom() {	
		int x = r.nextInt(Settings.RANDOM_NUM_RANGE_X);
		int y = r.nextInt(Settings.RANDOM_NUM_RANGE_Y);
		
		return new Point(x, y);
	}
	
	/* Fluent movement of object */
	private Point getNextPositionFluent() {
		this.posY += Settings.FLUENT_NUM_STEP_Y;
		this.posX += Settings.FLUENT_NUM_STEP_X;
		
		if (this.posY <= 0 || this.posY > Settings.PANEL_HEIGHT - Settings.OBJECT_HEIGHT) {
			Settings.FLUENT_NUM_STEP_Y = -Settings.FLUENT_NUM_STEP_Y;
			this.posY += Settings.FLUENT_NUM_STEP_Y;
		}
		if (this.posX <= 0 || this.posX >  Settings.PANEL_WIDTH - Settings.OBJECT_WIDTH) {
			Settings.FLUENT_NUM_STEP_X = -Settings.FLUENT_NUM_STEP_X;
			this.posX += Settings.FLUENT_NUM_STEP_X;
		}
		return new Point(this.posX, this.posY);
	}
	
	/* Fluent movement of object on both coordinates */
	@SuppressWarnings("unused")
	private Point getNextPositionXYFluent() {
		boolean coordinatesAllowed = false;
		int x = this.posX;
		int y = this.posY;
		while (!coordinatesAllowed) {		
			int side = r.nextInt(4);	
			
			switch (side) {
			case 0: y = y + Settings.MOVEMENT_LENGTH; break;
			case 1: y = y - Settings.MOVEMENT_LENGTH; break;
			case 2: x = x - Settings.MOVEMENT_LENGTH; break;
			case 3: x = x + Settings.MOVEMENT_LENGTH; break;
			default:
				break;
			}
			coordinatesAllowed = validateCoordinates(x,y);
			if (!coordinatesAllowed) {
				x = this.posX;
				y = this.posY;
			}
		}
		return new Point(this.posX, this.posY);
	}
	
	
	/* Check if new coordinates go out of panel borders */
	private boolean validateCoordinates(int x, int y) {
		if (x < 0 || x >= Settings.PANEL_WIDTH - Settings.OBJECT_WIDTH) {
			return false;
		} 
		if (y <= 0 || y > Settings.PANEL_HEIGHT - Settings.OBJECT_HEIGHT) {
			return false;
		}
		this.posX = x;
		this.posY = y;
		
		return true;
	}
	
}
