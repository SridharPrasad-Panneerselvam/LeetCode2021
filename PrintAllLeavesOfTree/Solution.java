// https://leetcode.com/problems/find-leaves-of-binary-tree/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
public List<List<Integer>> findLeaves(TreeNode root) {
    while (root != null) {
        List<Integer> leaves = new ArrayList<>();
        root = helper(root, leaves);
        res.add(leaves);
    }
    return res;
}

private TreeNode helper(TreeNode root, List<Integer> leaves) {         
    if (root == null) {
        return null;
    }
    if (isLeaveNode(root)) {
        leaves.add(root.val);
        root = null;
        return root;
    } else {
        if (isLeaveNode(root.left)) {
            leaves.add(root.left.val);
            root.left = null;
        } else {
            helper(root.left, leaves);
        }
        if (isLeaveNode(root.right)) {
            leaves.add(root.right.val);
            root.right = null;
        } else {
            helper(root.right, leaves);
        }
    }
    return root;
}


private boolean isLeaveNode(TreeNode root) {
    if (root != null && root.left == null && root.right == null) {
        return true;
    }
    return false;
}
}