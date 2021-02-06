// https://leetcode.com/problems/sum-of-left-leaves/

class Solution {
    int ans;
    public int sumOfLeftLeaves(TreeNode root) {
        ans = 0;
        return sum(root, false);
    }
    
    public int sum(TreeNode root, boolean left) {
        if(root == null) return 0;
        if(left && root.left == null && root.right == null) {
            ans += root.val;
        }
        sum(root.left, true);
        sum(root.right, false);
        return ans;
    }
}