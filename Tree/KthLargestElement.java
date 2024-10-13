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

		printTreeDesc(root.right);
		System.out.println(root.val);
		printTreeDesc(root.left);
	}
}

class KthLargestElement {
	private static Integer k;

	public static void kthLargest(Node root, Node myVal) {
		if(root == null) return;

		kthLargest(root.right, myVal);
		
		k--;
		if(k == 0 && myVal.val == null) myVal.val = root.val;
		
		kthLargest(root.left, myVal);
	}

	// Used Morris traversal in reverse :)
	public static int kthLargestIterative(Node root, int v) {
		while(root != null) {
			if(root.right == null) {
				if(--v == 0) return root.val;
				root = root.left;
			} else {
				Node prev = root.right;
				while(prev.left != null && prev.left != root) {
					prev = prev.left;
				}

				if(prev.left == null) {
					prev.left = root;
					root = root.right;
				} else {
					prev.left = null;
					if(--v == 0) return root.val;
					root = root.left;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Node root = Node.newNode(4); 
	    root.left = Node.newNode(2); 
	    root.right = Node.newNode(7); 
	    root.left.left = Node.newNode(1); 
	    root.left.right = Node.newNode(3); 
	    root.right.left = Node.newNode(6); 
	    root.right.right = Node.newNode(10); 
	    Node.printTreeDesc(root);
	    System.out.println();

	   	k = 6;  

	   	// Node temp = Node.newNode(null);
	    // kthLargest(root, temp);
	    // if(temp.val != null) System.out.println(temp.val);
	    // else System.out.println("Not found " + k);
	    System.out.println(kthLargestIterative(root, 4));
	}
}