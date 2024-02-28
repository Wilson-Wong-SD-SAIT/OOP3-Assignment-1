package utilities;

import java.util.Comparator;

public final class QuickSort
{
	/**
	 * Initiate Comparable method
	 * @param array   Array to be sorted
	 */
	public static<T> void sort( Comparable<T>[] array) 
	{
		quickSort(array, 0, array.length - 1);
	}
	
	/**
	 * Initiate Comparator method
	 * @param array   Array to be sorted
	 * @param comp   Comparator
	 */
	public static<T> void sort( Comparable<T>[] array, Comparator<? super T> comp ) 
	{
		quickSort(array, 0, array.length - 1, comp);
	}
	
	/**
	 * Comparable method: Divide and Conquer Array into pivot, left Integer Array and right Integer Array
	 * @param array   Array to be pivoted
	 * @param left   Left most index of the Integer Array
	 * @param right   Right most index of the Integer Array
	 */
	public static<T> void quickSort( Comparable<T>[] array, int left, int right ) 
	{
		if(left < right) 
		{
			int pivot = partition( array, left, right);
			quickSort(array, left, pivot - 1);
			quickSort(array, pivot + 1, right);
		}
	}
	
	/**
	 * Comparator method: Divide and Conquer Array into pivot, left Integer Array and right Integer Array
	 * @param array   Array to be pivoted
	 * @param left   Left most index of the Integer Array
	 * @param right   Right most index of the Integer Array
	 * @param comp   Comparator
	 */
	public static<T> void quickSort( Comparable<T>[] array, int left, int right, Comparator<? super T> comp ) 
	{

		if(left < right) 
		{
			int pivot = partition( array, left, right, comp);
			quickSort(array, left, pivot - 1, comp);
			quickSort(array, pivot + 1, right, comp);
		}
	}
	
	/**
	 * Comparable method: Swap smaller items to left of Pivot, and larger items to right of Pivot
	 * @param array   Array to be pivoted
	 * @param left   Left most index of the Array
	 * @param right   Right most index of the Array
	 * @return        index of pivot 
	 */
	@SuppressWarnings("unchecked")
	private static<T> int partition( Comparable<T>[] array, int left, int right ) 
	{

		// assume no item larger than pivot
		int pivotLeft = left -1;

		for(int i = left; i < right; i ++) 
		{
			// swap item larger than pivot 
			// no need swap if all items larger than pivot (items position not change)
			if( ( (Comparable<T>) array[i] ).compareTo( (T) array[right] ) > 0 && i != pivotLeft) 
			{
				pivotLeft++;
				swapElements(array, i, pivotLeft);
			}
		}
		
		// swap pivot with pointer
		swapElements(array, pivotLeft+1, right);

		return pivotLeft + 1;
	}
	
	/**
	 * Comparator method: Swap smaller items to left of Pivot, and larger items to right of Pivot
	 * @param array   Array to be pivoted
	 * @param left   Left most index of the Array
	 * @param right   Right most index of the Array
	 * @param comp   Comparator
	 * @return        index of pivot 
	 */
	@SuppressWarnings("unchecked")
	private static<T> int partition( Comparable<T>[] array, int left, int right, Comparator<? super T> comp) 
	{

		// assume no item larger than pivot
		int pivotLeft = left -1;
		
		for(int i = left; i < right; i ++) 
		{
			// swap item larger than pivot 
			// no need swap if all items larger than pivot (items position not change)
			if( comp.compare( (T) array[i], (T) array[right] ) > 0 && i != pivotLeft) 
			{
				pivotLeft++;
				swapElements(array, i, pivotLeft);
			}
		}
		
		// swap pivot with pointer
		swapElements(array, pivotLeft+1, right);


		return pivotLeft + 1;
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
