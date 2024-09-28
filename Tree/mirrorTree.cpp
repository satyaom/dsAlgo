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

void mirror(Node *root) {
	if(root == nullptr) return;

	//Go to the end of the left most node and start swaping left and right till root end the end you will get mirror
	//Here we using preorder traversal in tree
	mirror(root->left);
	mirror(root->right);

	Node *temp = root->left;
	root->left = root->right;
	root->right = temp;
}