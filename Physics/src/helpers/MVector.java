package helpers;

/**
 * 
 * @author Radonja Prelevic
 * @version 1.1
 * @since 1.1
 * 
 * <p>
 * Class represents vector in space
 * </p>
 *
 */

public class MVector {

	/**
	 * Value x of vector
	 */
	private Double x;
	/**
	 * Value y of vector
	 */
	private Double y;
	
	/**
	 * Longitude of vector on X axis. Counted when 
	 * we add goal point. Initial value is 0.0
	 */
	private Double dx = 0.0;
	/**
	 * Longitude of vector on Y axis. Counted when 
	 * we add goal point. Initial value is 0.0
	 */
	private Double dy = 0.0;
	
	
	public MVector() {
		this.x = 0.0;
		this.y = 0.0;
	}
	
	/**
	 * Constructor of vector with specific position
	 * 
	 * @param x - position of vector on X axis
	 * @param y - position of vector on Y axis
	 */
	public MVector(Double x, Double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Adds one vector to this one
	 * 
	 * @param addition - vector to add
	 */
	public void add(MVector addition) {
		this.x += addition.getX();
		this.y += addition.getY();
	}
	
	/**
	 * Subtracts vectors
	 * 
	 * @param subtraction - vector for subtraction
	 */
	public void subtract(MVector subtraction) {
		this.x -= subtraction.getX();
		this.y -= subtraction.getY();
	}
	
	/**
	 * Divides two vectors
	 * 
	 * @param div - vector for division
	 */
	public void divide(MVector div) {
		this.x /= div.getX();
		this.y /= div.getY();
	}
	
	/**
	 * Scales vector to smaller value
	 * 
	 * @param div - amount that decides how much vector should be scaled down
	 * 
	 */
	public void divide(Double div) {
		this.x /= div;
		this.y /= div;
	}
	
	/**
	 * Scales vector
	 *  
	 * @param n - scales vector to specific size
	 */
	public void scale(Double n) {
		this.x *= n;
		this.y *= n;
	}
	
	/**
	 * Multiplies two vectors
	 * 
	 * @param mult - factor
	 */
	public void multiply(MVector mult) {
		this.x *= mult.getX();
		this.y *= mult.getY();
	}
	
	/**
	 * Sets distance between this vector point to another
	 * 
	 * @param goalPoint - point where we are going
	 */
	public void setDistanceToGoalPoint(MVector goalPoint) {
		this.dx = this.x - goalPoint.getX();
		this.dy = this.y - goalPoint.getY();
	}
	
	/**
	 * Counts magnitude of the vector
	 * 
	 * @return Double value of magnitude
	 */
	public Double getMagnitude() {
		return Math.sqrt(dx * dx + dy * dy);
	}
	
	/**
	 * Normalizes this vector 
	 */
	public void normalize() {
		Double mag = getMagnitude();
		if (mag != 0.0)
			divide(mag);
	}
	
	/**
	 * Returns normalized value of this vector
	 * 
	 * @return MVector object that represents normalized value of this vector
	 */
	public MVector getNormalized() {
		MVector normalizedVector = new MVector(this.x, this.y);
		normalizedVector.normalize();
		return normalizedVector;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}
	
}
