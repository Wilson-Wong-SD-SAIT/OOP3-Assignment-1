package shapes;

public class TriangularPrism extends Prism
{
	public TriangularPrism(double height, double side) 
	{
		super(height, side);
	}
	
	@Override
	public double calcBaseArea() {
		return Math.PI * Math.pow(side, 2);
	}
	
	@Override
	public double calcVolume() {
		return Math.PI * Math.pow(side, 2) * height / 3;
	}

}
