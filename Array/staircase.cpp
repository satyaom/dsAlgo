#include<bits/stdc++.h>
using namespace std;

/**
 * 1 = 1
 * 2 = 1+1, 2
 * 3 = 1+1+1, 2+1, 1+2
 * 4 = 1+1+1+1, 2+2, 2+1+1, 1+2+1, 2+1+1, 2+2+1
 * */

int staircase(int n) {
	vector<int> visited(n+1, 0);
	visited[1] = 1;
	visited[2] = 2;
	//used fabonacii pattern to find the number
	for(int i = 3; i < n+1; i++) {
		visited[i] = visited[i-1] + visited[i-2];
	}
	return visited[n];
}

int main() {
	int stairsCount;
	cin>>stairsCount;
	cout<<staircase(stairsCount);
}