// https://leetcode.com/problems/minimum-depth-of-binary-tree/

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
    public int minDepth(TreeNode root) {
       // use two stacks, one for storing the nodes to be examined
        // one for recording the corrisponding depth

        if (root == null) return 0;

        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> depth = new Stack<>();

        nodes.push(root);
        depth.push(1);

        int min = Integer.MAX_VALUE;
        while (!nodes.isEmpty()) {
            TreeNode curNode = nodes.pop();
            int curDepth = depth.pop();
            // found a leaf
            if (curNode.left == null && curNode.right == null) {
                min = Math.min(min, curDepth);
            }
            if (curNode.right != null) {
                nodes.push(curNode.right);
                depth.push(curDepth + 1);
            }
            if (curNode.left != null) {
                nodes.push(curNode.left);
                depth.push(curDepth + 1);
            }
        }

        return min; 
    }
}