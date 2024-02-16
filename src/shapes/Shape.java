package shapes;

public abstract class Shape implements Comparable<Shape>
{
	protected double height;
	
	/**
	 * Constructs a Shape object with specified height.
	 * @param height height of Shape
	 */
	public Shape(double height) {
		super();
		this.height = height;
	}

	/**
	 * Returns height.
	 * @return height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Sets height to provided height.
	 * @param height height of Shape
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * Returns the volume of Shape.
	 * @return volume
	 */
	public abstract double calcVolume();
	
	/**
	 * Returns the base area of Shape.
	 * @return base area
	 */
	public abstract double calcBaseArea();
	
	
	@Override
	public int compareTo(Shape other) 
	{
		if(this.height > other.height)
			return 1;
		else if(this.height < other.height)
			return -1;
		return 0;
	}

}
