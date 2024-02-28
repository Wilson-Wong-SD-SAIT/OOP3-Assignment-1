package manager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;

import shapes.BaseAreaComparator;
import shapes.VolumeComparator;

public class SortManager 
{
	private String sortClass, compareMethod, compareParameter;
	private long start, stop;
	
	public SortManager(CommandManager cm) 
	{
		if( cm.getSortType() == 'b' ) 
		{	
			this.sortClass = "BubbleSort";
		}
		else if( cm.getSortType() == 's' ) 
		{	
			this.sortClass = "SelectionSort";
		}
		else if( cm.getSortType() == 'i' ) 
		{	
			this.sortClass = "InsertionSort";
		}
		else if( cm.getSortType() == 'm' ) 
		{	
			this.sortClass = "MergeSort";
		}
		else if( cm.getSortType() == 'q' ) 
		{	
			this.sortClass = "QuickSort";
		}
		else if( cm.getSortType() == 'z' ) 
		{	
			// implement customized sorting
			this.sortClass = "HeapSort";
		}
		// invalid argument
		else 
		{
			this.sortClass = null;
			System.out.println( "Invalid argument for sortType" );
			System.exit(0);
		}
		
		
		try {
			Class<?> cls = Class.forName( "utilities." + this.sortClass );
			
			if( cm.getCompareType() == 'h' ) 
			{	
				this.compareMethod = "Comparable";
				this.compareParameter = "getHeight";
				Method m = cls.getMethod("sort", new Class[]{Comparable[].class});
				this.start = System.nanoTime();
				
				m.invoke(cls, (Object) cm.getShapes());
			}
			else if( cm.getCompareType() == 'b' ) 
			{
				this.compareMethod = "BaseAreaComparator";
				this.compareParameter = "calcBaseArea";
				Method m = cls.getMethod("sort", new Class[]{Comparable[].class, Comparator.class});
				BaseAreaComparator bac = new BaseAreaComparator();
				this.start = System.nanoTime();
				
				m.invoke(cls, (Object) cm.getShapes(), bac);
			}
			else if( cm.getCompareType() == 'v' ) 
			{
				this.compareMethod = "VolumeComparator";
				this.compareParameter = "calcVolume";
				Method m = cls.getMethod("sort", new Class[]{Comparable[].class, Comparator.class});
				VolumeComparator vc = new VolumeComparator();
				this.start = System.nanoTime();
				
				m.invoke(cls, (Object) cm.getShapes(), vc);
			}
			// invalid argument
			else 
			{
				this.compareMethod = null;
				this.compareParameter = null;
				this.start = 0;
				System.out.println( "Invalid argument for compareType" );
				System.exit(0);
			}

			this.stop = System.nanoTime();
			output();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public Object[] output() 
	{
		Object argList[] = new Object[5];
		argList[0] = this.sortClass;
		argList[1] = this.compareMethod;
		argList[2] = this.compareParameter;
		argList[3] = this.start;
		argList[4] = this.stop;
		return argList;
	}
}
