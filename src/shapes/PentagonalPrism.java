package shapes;

public class PentagonalPrism extends Prism
{
	public PentagonalPrism(double height, double side) 
	{
		super(height, side);
	}
	
	@Override
	public double calcBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * Math.pow(side, 2);
	}
	
	@Override
	public double calcVolume() {
		return this.calcBaseArea() * height;
	}
}
