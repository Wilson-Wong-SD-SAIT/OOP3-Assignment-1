package utilities;

import java.util.Comparator;

public class HeapSort 
{
	/**
	 * Initiate Comparable method
	 * @param array   Array to be pivoted
	 */
	public static<T> void sort( Comparable<T>[] array) 
	{
		int n = array.length;
		
		// build min heap
		for(int i = n/2 -1 ; i >= 0; i--) 
		{
			heapify(array, n, i);
		}
		
		// reverse smallest item in min heaps continuously  
		for(int i = n - 1 ; i > 0; i--) 
		{
			swapElements(array, 0, i);
			heapify(array, i, 0);
		}
	}
	
	/**
	 * Initiate Comparator method
	 * @param array   Array to be pivoted
	 * @param comp   Comparator
	 */
	public static<T> void sort( Comparable<T>[] array, Comparator<? super T> comp ) 
	{
		int n = array.length;
		
		// build min heap
		for(int i = n/2 -1 ; i >= 0; i--) 
		{
			heapify(array, n, i, comp);
		}
		
		// reverse smallest item in min heaps continuously  
		for(int i = n - 1 ; i > 0; i--) 
		{
			swapElements(array, 0, i);
			heapify(array, i, 0, comp);
		}
		
	}
	

	
	/**
	 * Comparable method: Swap smaller items to left of Pivot, and larger items to right of Pivot
	 * @param array   Array to be pivoted
	 * @param left   Left most index of the Integer Array
	 * @param right   Right most index of the Integer Array
	 * @return        index of pivot 
	 */
	@SuppressWarnings("unchecked")
	private static<T> void heapify( Comparable<T>[] array, int n, int i ) 
	{
		// assume i as minimum first; find indexes of left-child and right-child 
		int min = i;
		int left = i *2 +1;
		int right = i *2 +2;
		
		// find minimum amongst i, left-child and right-child 
		if( left < n && array[min].compareTo( (T) array[left] ) > 0 ) 
		{
			min = left;
		}
		if( right < n &&  array[min].compareTo( (T) array[right] ) > 0 ) 
		{
			min = right;
		}
		
		// if i is no longer minimum, min heapify all child branches
		if( min != i ) 
		{
			swapElements(array, min, i);
			heapify(array, n, min);
		}	
		
		if( left < n && right < n && array[left].compareTo( (T) array[right] ) > 0 ) 
		{
			swapElements(array, left, right);
			heapify(array, n, right);
		}
		
	}
	

	
	/**
	 * Comparator method: Swap smaller items to left of Pivot, and larger items to right of Pivot
	 * @param array   Array to be pivoted
	 * @param left   Left most index of the Integer Array
	 * @param right   Right most index of the Integer Array
	 * @param comp   Comparator
	 * @return        index of pivot 
	 */
	@SuppressWarnings("unchecked")
	private static<T> void heapify( Comparable<T>[] array, int n, int i, Comparator<? super T> comp) 
	{
		
		// assume i as minimum first; find indexes of left-child and right-child 
		int min = i;
		int left = i *2 +1;
		int right = i *2 +2;
		
		// find minimum amongst i, left-child and right-child 
		if( left < n && comp.compare( (T) array[min], (T) array[left] ) > 0) 
		{
			min = left;
		}
		if( right < n &&  comp.compare( (T) array[min], (T) array[right] ) > 0 ) 
		{
			min = right;
		}
		
		// if i is no longer minimum, min heapify all child branches
		if( min != i ) 
		{
			swapElements(array, min, i);
			heapify(array, n, min, comp);
		}	
		
		if( left < n && right < n && comp.compare( (T) array[left], (T) array[right] ) > 0 ) 
		{
			swapElements(array, left, right);
			heapify(array, n, right, comp);
		}
	}
	
	/**
	 * Swap two items inside an array
	 * @param array   Array to be swapped items
	 * @param i   1st swapping item
	 * @param j   2nd swapping item
	 */
	private static <T> void swapElements( Comparable<T>[] array, int i, int j )
	{
		Comparable<T> temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
}
