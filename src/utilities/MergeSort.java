package utilities;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort 
{

	/**
	 * Initiate Comparable method
	 * @param array   Array to be sorted
	 */
	public static<T> void sort( Comparable<T>[] array) 
	{
		mergeSort(array, 0, array.length - 1);
	}
	
	/**
	 * Initiate Comparator method
	 * @param array   Array to be sorted
	 * @param comp   Comparator
	 */
	public static<T> void sort( Comparable<T>[] array, Comparator<? super T> comp ) 
	{
		mergeSort(array, 0, array.length - 1, comp);
	}
	
	/**
	 * Comparable method: Divide and Conquer Array into left sorted Array and right sorted Array, then merge
	 * @param array   Array to be sorted
	 * @param start   Starting index of the Array
	 * @param end     Ending index of the Array
	 */
	@SuppressWarnings("unchecked")
	public static<T> void mergeSort( Comparable<T>[] array, int start, int end ) 
	{
		if(start < end) 
		{
			// Divide into left sorted Array and right sorted Array
			int mid = (start + end) / 2;
			mergeSort(array, start, mid);
			mergeSort(array, mid+1, end);
			
			// Initialize variables for merging
			Comparable<T>[] left = Arrays.copyOfRange(array, start, mid +1);
			Comparable<T>[] right = Arrays.copyOfRange(array, mid+1, end +1);
			int i = 0;
			int j = 0;
			int k = start;
			
			// Merge left sorted Array and right sorted Array
			while(true) 
			{
				while( i < left.length && left[i].compareTo((T)right[j]) >= 0 ) 
				{
					array[k++] = left[i++];
				}
				if(i == left.length) 
				{
					while(j < right.length) 
					{
						array[k++] = right[j++];
					}
					break;
				}
				
				while( j < right.length && right[j].compareTo((T)left[i]) >= 0) 
				{
					array[k++] = right[j++];
				}
				if(j == right.length) 
				{
					while(i < left.length) 
					{
						array[k++] = left[i++];
					}
					break;
				}
			}
		}
	}
	
	/**
	 * Comparator method: Divide and Conquer Array into left sorted Array and right sorted Array, then merge
	 * @param array   Array to be sorted
	 * @param start   Starting index of the Array
	 * @param end     Ending index of the Array
	 * @param comp   Comparator
	 */
	@SuppressWarnings("unchecked")
	public static<T> void mergeSort( Comparable<T>[] array, int start, int end, Comparator<? super T> comp ) 
	{
		if(start < end) 
		{
			// Divide into left sorted Array and right sorted Array
			int mid = (start + end) / 2;
			mergeSort(array, start, mid, comp);
			mergeSort(array, mid+1, end, comp);
			
			// Initialize variables for merging
			Comparable<T>[] left = Arrays.copyOfRange(array, start, mid +1);
			Comparable<T>[] right = Arrays.copyOfRange(array, mid+1, end +1);
			int i = 0;
			int j = 0;
			int k = start;
			
			// Merge left sorted Array and right sorted Array
			while(true) 
			{
				while( i < left.length && comp.compare((T) left[i], (T)right[j]) >= 0 ) 
				{
					array[k++] = left[i++];
				}
				if(i == left.length) 
				{
					while(j < right.length) 
					{
						array[k++] = right[j++];
					}
					break;
				}
				
				while( j < right.length && comp.compare((T) right[j], (T)left[i]) >= 0) 
				{
					array[k++] = right[j++];
				}
				if(j == right.length) 
				{
					while(i < left.length) 
					{
						array[k++] = left[i++];
					}
					break;
				}
			}
		}

	}

}
