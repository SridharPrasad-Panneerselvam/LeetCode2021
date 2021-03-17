// https://leetcode.com/problems/subtree-of-another-tree/

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }else if (s == null || t== null) {
            return false;
        }
        if(checkSameTree(s , t)) {
            return true;
        }
        return isSubtree(s.left , t) || isSubtree(s.right , t);
    }
    private boolean checkSameTree(TreeNode s , TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null){ 
            return false;
        }
        if(s.val != t.val) {
            return false;
        }
        return checkSameTree(s.left , t.left) && checkSameTree(s.right , t.right);
    }
}