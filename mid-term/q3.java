// Q-3 : Given a binary array, find the maximum number of consecutive 1s in this array.
// Example : For the given array [0,1,0,1,1,0,1,1,1,0,0,0] the result should be 3.

// Time Complexity - O(n)
// Space Complexity - O(1)

class Solution{
    public static int getMaxConsecutiveOnes(int[] nums){
        int max = 0;
            int curr = 0;
            for (int i : nums) {
                if (i == 1) {
                    curr++;
                } else {
                    if (curr > max) {
                        max = curr;
                    }
                    if (max >= nums.length / 2) {
                        return max;
                    }
                    curr = 0;
                }
            }
            return Math.max(max, curr);
    }
    public static void main(String[] args){
        int arr[] = {0,1,0,1,1,0,1,1,1,0,0,0};
                
        int n = arr.length;
    
        System.out.println(getMaxConsecutiveOnes(arr));
    }
    
    }