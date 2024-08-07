#include<bits/stdc++.h>
using namespace std;

vector<vector<int>> getTripletTwoPointer(vector<int> &array) {
	vector<vector<int>> triplets;
	int n = array.size();
	sort(array.begin(), array.end());
	for (int i = 0; i < n; i++) {
		if(i != 0 && array[i] == array[i-1]) continue;
		int ip = i+1;
		int ep = n-1;
		while(ip < ep) {
			int sum = array[ip] + array[ep] + array[i];
			if(sum < 0) ip++;
			else if(sum > 0) ep--;
			else {
				vector<int> triplet = {array[i], array[ip], array[ep]};
				triplets.push_back(triplet);
				ip++;
				ep--;
				while (ip < ep && array[ip] == array[ip - 1]) ip++;
                while (ip < ep && array[ep] == array[ep + 1]) ep--;
			}
		}
	}
	return triplets;
}

vector<vector<int>> getTripletHashMap(vector<int> &array) {
	set<vector<int>> uniqueTriplets;
	unordered_set<int> set;
	int n = array.size();
	for(int i = 0; i < n; i++) {
		for(int j = i+1; i < n; i++) {
			int third = -(array[i] + array[j]);
			if(set.find(third) != set.end()) {
				vector<int> triplet = {array[i], array[j], third};
				sort(triplet.begin(), triplet.end());
				uniqueTriplets.insert(triplet);
			}
			set.insert(array[j]);
		}
	}
	vector<vector<int>> triplets(uniqueTriplets.begin(), uniqueTriplets.end());
	return triplets;
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
	vector<vector<int>> triplets = getTripletHashMap(array);
	for(auto triplet: triplets) {
		printArray(triplet);
	}
}