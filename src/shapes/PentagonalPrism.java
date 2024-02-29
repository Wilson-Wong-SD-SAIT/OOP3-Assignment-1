package shapes;

public class PentagonalPrism extends Prism
{
	public PentagonalPrism(double height, double side) 
	{
		super(height, side);
	}
	
	@Override
	public double calcBaseArea() {
		return  5 * Math.pow(side, 2) * Math.tan(54) / 4;
	}
	
	@Override
	public double calcVolume() {
		return this.calcBaseArea() * height;
	}
}
