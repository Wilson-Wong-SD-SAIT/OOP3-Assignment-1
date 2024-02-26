package utilities;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort 
{

	/**
	 * Initiate Comparable method
	 * @param array   Array to be pivoted
	 */
	public static<T> void sort( Comparable<T>[] array) 
	{
		mergeSort(array, 0, array.length - 1);
	}
	
	/**
	 * Initiate Comparator method
	 * @param array   Array to be pivoted
	 * @param comp   Comparator
	 */
	public static<T> void sort( Comparable<T>[] array, Comparator<? super T> comp ) 
	{
		mergeSort(array, 0, array.length - 1, comp);
	}
	
	/**
	 * Comparable method: Divide and Conquer Array into pivot, left Integer Array and right Integer Array
	 * @param array   Array to be pivoted
	 * @param left   Left most index of the Integer Array
	 * @param right   Right most index of the Integer Array
	 */
	@SuppressWarnings("unchecked")
	public static<T> void mergeSort( Comparable<T>[] array, int start, int end ) 
	{
		if(start < end) 
		{
			int mid = (start + end) / 2;
			mergeSort(array, start, mid);
			mergeSort(array, mid+1, end);
			
			Comparable<T>[] left = Arrays.copyOfRange(array, start, mid +1);
			Comparable<T>[] right = Arrays.copyOfRange(array, mid+1, end +1);
			
			
			int i = 0;
			int j = 0;
			int k = start;
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
	 * Comparator method: Divide and Conquer Array into pivot, left Integer Array and right Integer Array
	 * @param array   Array to be pivoted
	 * @param left   Left most index of the Integer Array
	 * @param right   Right most index of the Integer Array
	 * @param comp   Comparator
	 */
	@SuppressWarnings("unchecked")
	public static<T> void mergeSort( Comparable<T>[] array, int start, int end, Comparator<? super T> comp ) 
	{
		if(start < end) 
		{
			int mid = (start + end) / 2;
			mergeSort(array, start, mid, comp);
			mergeSort(array, mid+1, end, comp);
			
			Comparable<T>[] left = Arrays.copyOfRange(array, start, mid +1);
			Comparable<T>[] right = Arrays.copyOfRange(array, mid+1, end +1);
			
			
			int i = 0;
			int j = 0;
			int k = start;
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
