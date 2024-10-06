import java.util.*;

class Node {
	int val;
	Node left;
	Node right;
	Node(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

class ChildrenSum {
	public static Boolean isChildrenSum(Node root) {
		if(root == null || (root.left == null && root.right == null))` 
			return true;

		int sum = 0;

		if(root.left != null) sum += root.left.val;
		if(root.right != null) sum += root.right.val;

		return sum == root.val && isChildrenSum(root.left)
			&& isChildrenSum(root.right);
	}

	public static void main(String[] args) {
		Node root = new Node(35);
        root.left = new Node(20);
        root.right = new Node(15);
        root.left.left = new Node(15);
        root.left.right = new Node(5);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        System.out.println(isChildrenSum(root));
	}
}