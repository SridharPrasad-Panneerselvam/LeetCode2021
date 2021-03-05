// https://www.geeksforgeeks.org/count-1s-sorted-binary-array/

class CountOnes 
{
    int countNoOfOnes(int arr[], int low, int high)
    {
        if (high >= low) 
        {
            int mid = low + (high - low) / 2;

            if (( arr[mid + 1] == 0 || mid == high)
                && (arr[mid] == 1))
                return mid + 1;
            if (arr[mid] == 1)
                return countNoOfOnes(arr, (mid + 1), high);
 
            return countNoOfOnes(arr, low, (mid - 1));
        }
        return 0;
    }
 
    public static void main(String args[])
    {
        CountNoOfOnes ob = new countNoOfOnes();
        int arr[] = { 1, 1, 1, 1, 0, 0, 0 };
        int n = arr.length;
        System.out.println("Count of 1's in given array is "
                           + ob.countNoOfOnes(arr, 0, n - 1));
    }
}
