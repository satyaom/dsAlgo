class Node {
	int val;
	Node left;
	Node right;

	private Node() {}

	public static Node newNode(int val) {
		Node node = new Node();
		node.val = val;
		node.left = null;
		node.right = null;
		return node;
	}
}


/*

	This traversal mechanism not using any space like stack or recurrsion which use call stack.
	The methodogy used here is based on threading the rightmost element of left element to root.
*/

class MorrisTraversal {
	public static void morrisTraversal(Node root) {
		while(root != null) {
			if(root.left == null) {
				System.out.println(root.val);
				root = root.right;
			} else {
				Node prev = root.left;
				
				while(prev.right != null && prev.right != root) {
					// Going right most of left node from root
					prev = prev.right;
				} 

				if(prev.right == null) {
					/*
						- Before going to left we must make thread to root
						- It is important to point at root because from right node most 
						  we going traverse to root
					*/

					// making thread to root from right most
					prev.right = root;

					// then move to left
					root = root.left;
				} else {
					/*
						- This means the thread already there and we need to remove it
						  and print root.
						- This also means that we completed our left sub tree
						  and we can move to right.
					*/

					// removing thread
					prev.right = null;
					// print itselft
					System.out.println(root.val);

					// move to right as left sub tree already traversed
					root = root.right;
				}

			}
		}
	}

	public static void main(String[] args) {
		Node root = Node.newNode(4); 
	    root.left = Node.newNode(2); 
	    root.right = Node.newNode(7); 
	    root.left.left = Node.newNode(1); 
	    root.left.right = Node.newNode(3); 
	    root.right.left = Node.newNode(6); 
	    root.right.right = Node.newNode(10); 
	    morrisTraversal(root);
	}
}







