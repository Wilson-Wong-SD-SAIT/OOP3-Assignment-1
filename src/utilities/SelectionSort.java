package utilities;

import java.util.Comparator;

public class SelectionSort 
{
	/**
	 * Initiate Comparable method
	 * @param array   Array to be sorted
	 */
	@SuppressWarnings("unchecked")
	public static<T> void sort( Comparable<T>[] array) 
	{
		Comparable<T> temp;
		
		// assume current item as maximum first in each iteration
		for(int i = 0, maxInd = 0; i < array.length - 1; i++, maxInd = i) 
		{
			
			// find the maximum item
			for(int j = i + 1; j < array.length; j++) 
			{
				if( array[j].compareTo((T)array[maxInd]) > 0 ) 
				{			
					maxInd = j;
				}
			}

			// swap maximum item with current item
			temp = array[maxInd]; 
			array[maxInd] = array[i];
			array[i] = temp;
		}
	}
	
	/**
	 * Initiate Comparator method
	 * @param array   Array to be sorted
	 * @param comp   Comparator
	 */
	@SuppressWarnings("unchecked")
	public static<T> void sort( Comparable<T>[] array, Comparator<? super T> comp ) 
	{
		Comparable<T> temp;
		
		// assume current item as maximum first in each iteration
		for(int i = 0, maxInd = 0; i < array.length - 1; i++, maxInd = i) 
		{
			// find the maximum item 
			for(int j = i + 1; j < array.length; j++) 
			{
				if( comp.compare((T) array[j], (T)array[maxInd]) > 0 ) 
				{			
					maxInd = j;
				}
			}

			// swap maximum item with current item
			temp = array[maxInd]; 
			array[maxInd] = array[i];
			array[i] = temp;
		}
	}
}
