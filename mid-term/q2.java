// Q-2 : Print perimeter of a tree in clock-wise order.
// Example : Expected output for the following tree should be : [1,3,7,14,13,11,10,9,8,4,2]

// Time Complexity - O(N) => N is the number of nodes in binary tree
// Space Complexity - O(n)

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { 
		this.val = val; 
	}
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
	
class Solution{
	void printLeaves(TreeNode node)
	{
		if (node == null)
			return;

		printLeaves(node.right);
		if (node.left == null && node.right == null)
			System.out.print(node.val + " ");
		printLeaves(node.left);
	}

	void printBoundaryLeft(TreeNode node)
	{
		if (node == null)
			return;

		if (node.left != null) {
			printBoundaryLeft(node.left);
            System.out.print(node.val + " ");

		}
		else if (node.right != null) {
			printBoundaryLeft(node.right);
            System.out.print(node.val + " ");

		}

	}

	void printBoundaryRight(TreeNode node){
		if (node == null)
			return;

		if (node.right != null) {
            System.out.print(node.val + " ");
			printBoundaryRight(node.right);
		}
		else if (node.left != null) {
            System.out.print(node.val + " ");
			printBoundaryRight(node.left);
		}
	}

	void printPerimeter(TreeNode node){
		if (node == null)
			return;

		System.out.print(node.val + " ");

		printBoundaryRight(node.right);
      	printLeaves(node.right);
		printLeaves(node.left);
      	printBoundaryLeft(node.left);
	}


	public static void main(String args[]){     
        Solution result = new Solution();
		TreeNode tree = new TreeNode(1);

		tree.left = new TreeNode(2);
		tree.left.left = new TreeNode(4);
        tree.left.left.left = new TreeNode(8);
		tree.left.left.right = new TreeNode(9);
		tree.left.right = new TreeNode(5);
		tree.left.right.left = new TreeNode(10);
        tree.left.right.right = new TreeNode(11);

		tree.right = new TreeNode(3);
		tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        tree.right.left.right = new TreeNode(13);
        tree.right.right.right = new TreeNode(14);

		result.printPerimeter(tree);
	}
	
}