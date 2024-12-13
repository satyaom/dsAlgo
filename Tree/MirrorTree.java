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

class MirrorTree {
	public static void mirrorTree(Node root) {
		if(root == null) return;

		mirrorTree(root.left);
		mirrorTree(root.right);

		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	public static void main(String[] args) {
		Node root = Node.newNode(1);
        root.left = Node.newNode(2);
        root.right = Node.newNode(3);
        root.left.left = Node.newNode(4);
        root.left.right = Node.newNode(5);
	    mirrorTree(root);
	    Node.printTreeDesc(root);
	}
}