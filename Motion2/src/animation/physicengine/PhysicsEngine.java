package animation.physicengine;

import java.awt.Point;

public class PhysicsEngine {

	
	
	public Point callAlgorithm(Integer direction, Integer x, Integer y, Integer speed) {
		return getNextPoint(direction, x, y, speed);
	}
	
	private Point getNextPoint(Integer direction, Integer x, Integer y, Integer speed) {
		
		switch(direction) {
			case 0: x -= speed; break;
			case 1: x += speed; break;
			case 2: y -= speed; break;
			case 3: y += speed; break;
			case 4: x -= speed; y -= speed; break;
			case 5: x += speed; y -= speed; break;
			case 6: x -= speed; y += speed; break;
			case 7: x += speed; y += speed; break;
			default: break;
		}
		
		return new Point(x,y);
		
	}
		
	
}