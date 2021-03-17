

//https://leetcode.com/problems/3sum/submissions/


 class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length < 3) return ans;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) return ans;
            int Left = i+1, Right = nums.length - 1;
            if(i != 0 && nums[i] == nums[i-1]) continue;
            while(Left < Right){
                int sum = nums[Left] + nums[Right] + nums[i];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[Left], nums[Right]));
                    Left++;
                    while(Left < Right && nums[Left]==nums[Left-1]) Left++;
                    Right--;
                    while(Left < Right && nums[Right] == nums[Right+1]) Right--;
                }else if(sum < 0){
                    Left++;
                }else{
                    Right--;
                }
            }
        }
        return ans;
    }
}