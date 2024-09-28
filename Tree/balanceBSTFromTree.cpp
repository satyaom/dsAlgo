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

Node *sortedArrayToBST(vector<int> ar, int left, int right) {
	int mid = (left+right)/2;

	if(left > right) return nullptr;

	Node *root = new Node(ar[mid]);

	root->left = sortedArrayToBST(ar, left, mid-1);
	root->right = sortedArrayToBST(ar, mid+1, right);

	return root;
}

void preOrder(Node *root) {
	if(root == nullptr) return;
	preOrder(root->left);
	cout<<root->data<<" ";
	preOrder(root->right);
}

int main()
{
    vector<int> ar({ 1, 2, 3, 4, 5, 6, 7 });
 	cout<<ar[0];
    /* Convert List to BST */
    Node* root = sortedArrayToBST(ar, 0, ar.size() - 1);
    cout << "PreOrder Traversal of constructed BST \n";
    preOrder(root);
 
    return 0;
}