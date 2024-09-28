#include<bits/stdc++.h>
using namespace std;

struct Node {
	int val;
	Node *left;
	Node *right;
};

Node *newNode(int data) {	
	Node *node = new Node();
	node->val = data;
	node->left = nullptr;
	node->right = nullptr;
	return node;
}

bool identicalTrees(Node *a, Node *b) {
	if(a == nullptr && b == nullptr) return true;

	if(a-> val && b->val && a->val == b->val) {
		return identicalTrees(a->left, b->left) 
		&& identicalTrees(a->right, b->right) && true;
	}
	return false;
}

int main()
{
    Node* root1 = newNode(1);
    Node* root2 = newNode(1);
    root1->left = newNode(1);
    root1->right = newNode(3);
    root1->left->left = newNode(4);
    root1->left->right = newNode(5);

    root2->left = newNode(2);
    root2->right = newNode(3);
    root2->left->left = newNode(4);
    root2->left->right = newNode(5);

      // Function call
    if (identicalTrees(root1, root2))
        cout << "Both trees are identical.";
    else
        cout << "Trees are not identical.";

    return 0;
}
