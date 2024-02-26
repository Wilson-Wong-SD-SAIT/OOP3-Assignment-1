package utilities;

import java.util.Comparator;

public class BubbleSort 
{
	/**
	 * Initiate Comparable method
	 * @param array   Array to be pivoted
	 */
	@SuppressWarnings("unchecked")
	public static<T> void sort( Comparable<T>[] array) 
	{
		Comparable<T> temp;
		
		for(int i = array.length - 1; i > 0; i--) 
		{
			for(int j = 0; j < i; j++) 
			{
				if( array[j+1].compareTo((T)array[j]) > 0 ) 
				{			
					temp = array[j]; 
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * Initiate Comparator method
	 * @param array   Array to be pivoted
	 * @param comp   Comparator
	 */
	@SuppressWarnings("unchecked")
	public static<T> void sort( Comparable<T>[] array, Comparator<? super T> comp ) 
	{
		Comparable<T> temp;
		
		for(int i = array.length - 1; i > 0; i--) 
		{
			for(int j = 0; j < i; j++) 
			{
				if( comp.compare((T) array[j+1], (T)array[j]) > 0 ) 
				{			
					temp = array[j]; 
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
}
