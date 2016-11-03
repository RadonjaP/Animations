import java.awt.Color;


public class ColoredRectangle  {

	private int pos_x;
	private int pos_y;
	private Color color;

	public ColoredRectangle(int x, int y, Color color) {
		this.pos_x = x;
		this.pos_y = y;
		this.color = color;
	}
	
	public void setPosition(int pos_x, int pos_y) {
		this.pos_x = pos_x;
		this.pos_y = pos_y;
	}
	
	public int getPosX() {
		return this.pos_x;
	}
	
	public int getPosY() {
		return this.pos_y;
	}
	
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
