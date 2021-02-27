
// https://leetcode.com/problems/sort-colors/

class Solution {
    public int[] sortColors(int[] nums) {
        int n = nums.length;
        for (int gap = n; gap > 0; gap /= 2) { // gap identification
            for (int i = gap; i < n; i ++) { // iteration over the gap elements
                int key = nums[i];
                int j = i;
                while (j >= gap && nums[j - gap] > key) { // compare and replace
                    nums[j] = nums[j - gap];
                    j -= gap;
                }
                nums[j] = key;
            }
        } 
        return nums;
    }
}