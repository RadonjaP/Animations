import java.awt.Point;
import java.util.Random;


public class AlgorithmContainer {

	private Random r = new Random();
	
	private int posX = Settings.PANEL_WIDTH / 2;
	private int posY = Settings.PANEL_HEIGHT / 2;
	
	public Point getPosition() {
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
		this.posX += Settings.FLUENT_NUM_STEP_X;
		this.posY += Settings.FLUENT_NUM_STEP_Y;
		
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
	
	
	@SuppressWarnings("unused")
	private Point moveToLocation(Integer locationX, Integer locationY) {
		if (this.posX != locationX) {
			if (this.posX < locationX) {
				this.posX++;
			} else {
				this.posX--;
			}
		}
		if (this.posY != locationY) {
			if (this.posY < locationY) {
				this.posY++;
			} else {
				this.posY--;
			}
		}
		
		return new Point(this.posX, this.posY);
	}
}
