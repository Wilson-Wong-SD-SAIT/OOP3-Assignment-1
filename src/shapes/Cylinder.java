package shapes;

public class Cylinder extends Shape
{
	private double radius;
	
	public Cylinder(double height, double radius) 
	{
		super(height);
		this.setRadius(radius);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double calcBaseArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	@Override
	public double calcVolume() {
		return Math.PI * Math.pow(radius, 2) * height;
	}

}
