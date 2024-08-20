#include<bits/stdc++.h>
using namespace std;


vector<int> nextPermutation(vector<int> arr) {
	int n = arr.size();
	int breakPoint = -1;

	//to break point
	for(int i = n-1; i > 0; i--) {
		if(arr[i] < arr[i+1]) {
			breakPoint = i;
			break;
		}
	}
	// return reverse as next permutation if it already sorted in desc order
	if(breakPoint == -1) {
		reverse(arr.begin(), arr.end());
		return arr;
	}

	//swap to have lowest possible arragnment after break point
	for(int i = n-1; i > breakPoint; i--) {
		if(arr[breakPoint] < arr[i]) {
			swap(arr[breakPoint], arr[i]);
		}
		break;
	}

	//reverse the entire to get lowest possible arrangement
	reverse(arr.begin() + breakPoint + 1, arr.end());
	return arr;
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
	printArray(nextPermutation(array));
}