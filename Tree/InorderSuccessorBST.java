import java.util.*;


class Node {
	int val;
	Node left;
	Node right;

	private Node(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

	public static Node insert(Node root, int val) {
		if(root == null) return new Node(val);

		if(val > root.val) {
			root.right = insert(root.right, val);
		} else {
			root.left =  insert(root.left, val);
		}
		return root;
	}
}

class InorderSuccessorBST {
	public static Node inorderSuccessorBSTImp(Node root, Node target) {
		Node succ = null;

		while(root != null) {
			if(target.val < root.val) {
				succ = root;
				root = root.left;
			} else if(target.val >= root.val) {
				root = root.right;
			}
		}

		return succ;
	}


	public static void main(String[] args) {
		Node root = null, temp, succ;
		root = Node.insert(root, 20);
	    root = Node.insert(root, 8);
	    root = Node.insert(root, 22);
	    root = Node.insert(root, 4);
	    root = Node.insert(root, 12);
	    root = Node.insert(root, 10);
	    root = Node.insert(root, 14);
	    System.out.println(temp.val + ": "+ inorderSuccessorBSTImp(root, temp).val);

	}

}