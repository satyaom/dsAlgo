import java.util.*;

class Node {
	Integer val;
	Node left;
	Node right;
	protected Node() {};

	static Node newNode(Integer val) {
		Node n = new Node();
		n.val = val;
		n.left = null;
		n.right = null;
		return n;
	}

	static void printTreeDesc(Node root) {
		if(root == null) return;

		printTreeDesc(root.left);
		System.out.println(root.val);
		printTreeDesc(root.right);
	}
}

class IdenticalTree {
	public static boolean identicalTree(Node root1, Node root2) {
		if(root1 == null && root2 == null) return true;

		if(root1 == null || root2 == null) return false;

		return root1.val == root2.val &&
			identicalTree(root1.left, root2.left) &&
			identicalTree(root1.right, root2.right);
	}

	public static void main(String[] args) {
	    Node r1 = Node.newNode(1);
	    r1.left = Node.newNode(2);
	    r1.right = Node.newNode(3);
	    r1.left.left = Node.newNode(4);

	    
	    Node r2 = Node.newNode(1);
	    r2.left = Node.newNode(2);
	    r2.right = Node.newNode(3);
	    r2.left.left = Node.newNode(4);

	    if (identicalTree(r1, r2))
	        System.out.println("Yes");
	    else
	        System.out.println("No");
	}
}
