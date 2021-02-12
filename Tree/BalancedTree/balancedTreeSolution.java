// https://leetcode.com/problems/balanced-binary-tree/

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        
        if (Math.abs(leftDepth - rightDepth) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}