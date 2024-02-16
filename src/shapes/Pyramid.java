package shapes;

public class Pyramid extends Shape
{
	private double side;
	
	public Pyramid(double height, double side) 
	{
		super(height);
		this.setSide(side);
	}

	
	public double getSide() {
		return side;
	}


	public void setSide(double side) {
		this.side = side;
	}


	@Override
	public double calcBaseArea() {
		return Math.PI * Math.pow(side, 2);
	}
	
	@Override
	public double calcVolume() {
		return Math.pow(side, 2) * height / 3;
	}

}
