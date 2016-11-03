import java.awt.Color;
import java.awt.Graphics;

public class AnimationObject {

	private Integer posX;
	private Integer posY;
	
	private Integer width;
	private Integer height;
	
	private Color color;

	public AnimationObject(Integer posX, Integer posY, Color color) {
		this.posX = posX;
		this.posY = posY;
		this.color = color;
		this.width = Settings.OBJECT_WIDTH;
		this.height = Settings.OBJECT_HEIGHT;
	} 
	
	public void draw(Graphics g) {
		g.setColor(color);
//		g.drawOval(posX, posY, width, height);
		g.fillOval(posX, posY, width, height);
	}
	
	public void move(Integer posX, Integer posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	
	public Integer getX() {
		return posX;
	}
	
	public Integer getY() {
		return posY;
	}
}
