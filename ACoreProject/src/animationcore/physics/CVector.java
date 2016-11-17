package animationcore.physics;

public class CVector {

	private Float x , y;
	
	public CVector(Float x, Float y) {
		this.setX(x);
		this.setY(y);
	}
	
	//TODO this is not magnitude, x and y should be longitude not coordinates
	public Float getMagnitude() {
		return (float) Math.sqrt(x*x + y*y);
	}
	
	public void add(CVector addition) {
		this.x += addition.getX();
		this.y += addition.getY();
	}
	
	public void subtract(CVector subtraction) {
		this.x -= subtraction.getX();
		this.y -= subtraction.getY();
	}
	
	public void multiply(CVector multiplication) {
		this.x *= multiplication.getX();
		this.y *= multiplication.getY();
	}
	
	public void multiply(Integer n) {
		this.x *= n;
		this.y *= n;
	}
	
	public void divide(CVector division) {
		this.x /= division.getX();
		this.y /= division.getY();
	}

	public Float getX() {
		return x;
	}

	public void setX(Float x) {
		this.x = x;
	}

	public Float getY() {
		return y;
	}

	public void setY(Float y) {
		this.y = y;
	}
	
	
	
}
