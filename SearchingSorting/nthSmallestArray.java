// https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/

import java.util.Arrays;
import java.util.Collections;

class NthSmallestArray {
	
	public static int nthSmallest(Integer[] arr,
								int k)
	{
	
		Arrays.sort(arr);

		
		return arr[k - 1];
	}

	
	public static void main(String[] args)
	{
		Integer arr[] = new Integer[] { 12, 3, 5, 7, 19 };
		int i = 2;
		System.out.print("K'th smallest element is " + nthSmallest(arr, i));
	}
}


