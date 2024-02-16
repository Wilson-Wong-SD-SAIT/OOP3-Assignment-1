package shapes;

import java.util.Comparator;

public class BaseAreaComparator implements Comparator<Shape>
{
	@Override
	public int compare(Shape o1, Shape o2) 
	{
		if(o1.calcBaseArea() > o2.calcBaseArea())
			return 1;
		else if(o1.calcBaseArea() < o2.calcBaseArea())
			return -1;
		return 0;
	}
}
