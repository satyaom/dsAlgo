#include<bits/stdc++.h>
using namespace std;

bool isPathValid(vector<string> queenPath, int row, int col) {
	for(int i = row; i >= 0; i--) {
		if(queenPath[i][col] == 'Q') {
			return false;
		}
	}

	for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
		if(queenPath[i][j] == 'Q') {
			return false;
		}
	}

	for(int i = row - 1, j = col + 1; i < queenPath.size() && j < queenPath.size(); i--, j++) {
		if(queenPath[i][j] == 'Q') {
			return false;
		}
	}

	return true;
}

void nQueen(vector<string> &queenPath, int row, vector<vector<string>> &ans) {
	if(row == queenPath.size()) {
		ans.push_back(queenPath);
		return;
	}
	for(int col = 0; col < queenPath.size(); col++) {
		if(isPathValid(queenPath, row, col)) {
			queenPath[row][col] = 'Q';
			nQueen(queenPath, row + 1, ans);
			queenPath[row][col] = '_';
		}
	}
}

void printArray(vector<string> array) {
	for(auto ele: array) {
		cout << ele << endl;
	}
	cout << endl;
}

int main() {
	int n;
	cin >> n;
	vector<string> array;
	for(int i = 0; i < n; i++) {
		array.push_back("____");
	}
	vector<vector<string>> ans;
	nQueen(array, 0, ans);
	for(auto queenPath: ans) {
		printArray(queenPath);
	}
}