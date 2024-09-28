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

bool isSymmetricTree(Node *left, Node *right) {
	if(left == nullptr && right == nullptr) return true;

	return left && right && left->data == right->data 
				&&isSymmetricTree(left->left, right->right)
				&& isSymmetricTree(left->right, right->left);
}

int main()
{
    // Let us construct the Tree shown in the above figure
    Node* root = new Node(1);
    root->left = new Node(2);
    root->right = new Node(2);
    root->left->left = new Node(3);
    root->left->right = new Node(4);
    root->right->left = new Node(4);
    root->right->right = new Node(3);

    if (isSymmetricTree(root, root))
        cout << "Symmetric";
    else
        cout << "Not symmetric";
    return 0;
}
