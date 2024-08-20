#include<bits/stdc++.h>
using namespace std;

void getAllPermutations(int index, vector<int> &array, vector<vector<int>> &ans) {
	//if index is length that means we got our permutation
	if(index == array.size()) {
		ans.push_back(array);
		return;
	} 

	for(int i = index; i < array.size(); i++) {
		//here swap plays really important role
		swap(array[index], array[i]);
		getAllPermutations(index+1, array, ans);
		swap(array[index], array[i]);
	}
}

void printArray(vector<int> array) {
	for(auto ele: array) {
		cout << ele<< " ";
	}
	cout << endl;
}

int main() {
	int n;
	cin >> n;
	vector<int> array;
	for(int i = 0; i < n; i++) {
		int d;
		cin >> d;
		array.push_back(d);
	}
	vector<vector<int>> ans;
	getAllPermutations(0, array, ans);
	for(auto permutation: ans) {
		printArray(permutation);
	}
}