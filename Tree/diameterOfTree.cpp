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

int maxDiameter(Node *root, int &ans) {
	if(root == nullptr) return 0;

	int l = maxDiameter(root->left, ans);
	int r = maxDiameter(root->right, ans);

	ans = max(ans, l + r +1);
	return max(l, r) + 1;
}

int main()
{
    Node* root = new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);
    root->left->left = new Node(4);
    root->left->right = new Node(5);

    int ans = INT_MIN;
    maxDiameter(root, ans);
    cout<<ans;

    return 0;
}