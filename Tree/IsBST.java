import java.util.*;

class Node {
	int val;
	Node left;
	Node right;

	Node(int data) {
		this.val = data;
		this.left = null;
		this.right = null;
	}
}

class IsBST {
	public static Boolean isBST(Node root, int min, int max) {
		if(root == null) return true;
		if(root.val < min || root.val > max) return false;
		return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
	}

	public static void main(String[] args) {
		Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.left.right = new Node(6);
        if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
	}
}