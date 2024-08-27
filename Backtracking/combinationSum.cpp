#include<bits/stdc++.h>
using namespace std;

void printArray(vector<int> array) {
	for(auto ele: array) {
		cout << ele <<" ";
	}
	cout << endl;
}

void combinationSum(int index, vector<vector<int>> &ans, vector<int> &targetArray, vector<int> &cmbArray, int sum, int target) {
	if(sum > target) return;

	if(index == cmbArray.size()) {
		if(sum == target) {
			ans.push_back(targetArray);
		}
		return;
	}
	targetArray.push_back(cmbArray[index]);
	combinationSum(index, ans, targetArray, cmbArray, sum + cmbArray[index], target);
	targetArray.pop_back();
	combinationSum(index+1, ans, targetArray, cmbArray, sum, target);
}

int main() {
	int n;
	cin >> n;
	vector<int> cmbArray;
	for(int i = 0; i < n; i++) {
		int input;
		cin >> input;
		cmbArray.push_back(input);
	}
	int target;
	cin >> target;
	vector<vector<int>> ans;
	vector<int> targetArray;
	combinationSum(0, ans, targetArray, cmbArray, 0, target);
	for(auto queenPath: ans) {
		printArray(queenPath);
	}
}