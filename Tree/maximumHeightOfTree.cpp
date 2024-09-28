#include<bits/stdc++.h>
using namespace std;

struct Node {
	int data;
	Node *left;
	Node *right;
	Node(int val) {
		data = val;
		left = nullptr;
		right = nullptr;
	}
};

//Using level order traveral but optimized
int getHeight(Node *root) {
	if(!root) return 0;

	queue<Node *> queue;
	queue.push(root);
	int depth = 0;

	while(!queue.empty()) {
		int size = queue.size();
		for(int i = 0; i < size; i++) {
			Node *temp = queue.front();
			if(temp->left) {
				queue.push(temp->left);
			}
			if(temp->right) {
				queue.push(temp->right);
			}
			queue.pop();
		}
		depth++;
	}
	return depth;
}

// Using level order traversal
int getTreeHeight(Node *root) {
	if(!root) return 0;

	queue<Node *> queue;
	int depth = 0;
	queue.push(root);
	queue.push(nullptr);

	while(!queue.empty()) {
		Node *temp = queue.front();
		queue.pop();
		if(temp == nullptr) {
			depth++;
			if(!queue.empty()) {
				queue.push(nullptr);
			}
		} else {
			if(temp->left) {
				queue.push(temp->left);
			}
			if(temp->right) {
				queue.push(temp->right);
			}
		}
	}

	return depth;
}

//Using recursion
int getMaxHeightTree(Node *root) {
	if(root == nullptr) return 0;
	
	return max(getMaxHeightTree(root->left), getMaxHeightTree(root->right)) + 1;
}

int main() {
    Node *root = new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);
    root->left->left = new Node(4);
    root->left->right = new Node(5);
    root->right->right = new Node(6);
    root->right->right->right = new Node(7);
    cout << getHeight(root);
    return 0;
}

