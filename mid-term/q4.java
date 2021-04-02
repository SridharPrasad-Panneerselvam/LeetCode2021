// Q-4 : Given a sorted array ‘nums’ , return the first occurrence of an integer ‘x’.
// Example : For the given array [2,4,4,4,6,7,7,7,8,9,9,9,] & x = 7 , the result should be 5.Please note that you should not use a linear search to solve thisproblem.

// Time Complexity - O(log(n))
// Space Complexity - O(1)

class Solution
{
	public static int getIndex(int[] nums, int x)
	{
		int left = 0;
		int right = nums.length - 1;
		int result = -1;

		while (left <= right)
		{
			int mid = (left + right) / 2;
			if (x == nums[mid])
			{
				result = mid;
				right = mid - 1;
			}

			else if (x < nums[mid]) {
				right = mid - 1;
			}

			else {
				left = mid + 1;
			}
		}

		return result;
	}

	public static void main(String[] args)
	{
		int[] nums = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
		int key = 6;

		int index = getIndex(nums, key);

		if (index != -1)
		{
			System.out.println("First Occurance of element " + key +
							" is located at index " + index);
		}
		else {
			System.out.println("Element not found in array");
		}
	}
}