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

class ZigZagTraversal {
	public static void zigZagTraversalImp(Node root) {
		Boolean zigFlag = true;
		Deque<Node> st = new LinkedList<>();
		st.add(root);
		while(!st.isEmpty()) {
			int size = st.size();
			for(int i = 0; i < size; i++) {
				Node temp;
				if(zigFlag) {
					temp = st.pollFirst();
					if(temp.left != null) st.addLast(temp.left);
					if(temp.right != null) st.addLast(temp.right);
				} else {
					temp = st.pollLast();
					if(temp.right != null) st.addFirst(temp.right);
					if(temp.left != null) st.addFirst(temp.left);
				}      
				System.out.println(temp.val);
			}
			zigFlag = !zigFlag;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.right.right = new Node(11);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        zigZagTraversalImp(root);
	}
}

// flag = t
// st -> 22, 
// out -> 20,
