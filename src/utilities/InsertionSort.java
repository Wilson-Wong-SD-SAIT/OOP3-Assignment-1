package utilities;

import java.util.Comparator;

public class InsertionSort 
{
	/**
	 * Initiate Comparable method
	 * @param array   Array to be pivoted
	 */
	@SuppressWarnings("unchecked")
	public static<T> void sort( Comparable<T>[] array) 
	{
		Comparable<T> temp;
		
		for(int i = 1, j = 0; i < array.length; i++, j = i -1) 
		{
			temp = array[i];
			
			while( j >= 0 && temp.compareTo((T)array[j]) > 0 ) 
			{			
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = temp;
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
		
		for(int i = 1, j = 0; i < array.length; i++, j = i -1) 
		{
			temp = array[i];
			
			while( j >= 0 && comp.compare((T) temp, (T)array[j]) > 0 ) 
			{			
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = temp;
		}
	}

}
