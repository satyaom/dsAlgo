class CycleInList {
	public static boolean detectCycle(Node root) {
		Node slowPtr = root;
		Node fastPtr = root;

		while(slowPtr != null && fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if(slowPtr == fastPtr) return true;
		}

		return false;
	}

	public static void main(String args[]) {
		Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
      
        // head.next.next.next.next = head;

        if (detectCycle(head))
            System.out.println("true");
        else
            System.out.println("false");

	}
}

class Node {
	int data;
	Node next;

	Node(int x) {
		this.data = x;
		this.next = null;
	}
}