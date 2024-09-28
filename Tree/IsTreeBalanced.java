import java.util.*;

class IsTreeBalanced {
	public static int isTreeBalanced(Node root) {
		if(root == null) return 0;
		int left = isTreeBalanced(root.left);
		if(left == -1) return -1;
		int right = isTreeBalanced(root.right);
		if(right == -1) return -1;
		if(Math.abs(left - right) > 1) return -1;
		else return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(30);
        root.right.left = new Node(15);
        root.right.right = new Node(20);

		if(isTreeBalanced(root) < 0)
			System.out.println("not balanced");
		else
			System.out.println("balanced");
	}
}

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}