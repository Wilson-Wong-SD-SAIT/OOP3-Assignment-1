package manager;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import shapes.Shape;


public class OutputManager 
{
	public OutputManager (CommandManager cm, String sortClass, String compareMethod, String compareParameter, long start, long stop) 
	{
		// display benchmark
		System.out.println( "Benchmark: " + (stop - start) + " nanoseconds");
		
		System.out.println( compareMethod +  " by " + sortClass +  ":" );
		try {
			// [reserved for testing]
			//for(Shape shape: cm.getShapes()) 
			//{
			//	Method m = shape.getClass().getMethod(compareParameter);
			//	System.out.println( "\t" + shape.getClass().getSimpleName() + " " + m.invoke(shape) );
			//}

			
			// display first sorted value
			Method m = cm.getShapes()[0].getClass().getMethod(compareParameter);
			System.out.println( "First value: " + m.invoke(cm.getShapes()[0]));
			
			// display every thousandth value in between
			if(cm.getShapes().length > 1000) 
			{
				for(int i = 999; i < cm.getShapes().length - 1; i += 1000) 
				{
					m = cm.getShapes()[i].getClass().getMethod(compareParameter);
					System.out.println( i +1 + "th sorted value: " +  m.invoke(cm.getShapes()[i]));
				}
			}
			// display last sorted value
			m = cm.getShapes()[cm.getShapes().length - 1].getClass().getMethod(compareParameter);
			System.out.println( "Last value: " + m.invoke(cm.getShapes()[cm.getShapes().length - 1]));
			
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} 

	}
}
