#include<bits/stdc++.h>
using namespace std;

bool isSquare(int num) {
	int r = num/2;
	int l = 0;
	while(l <= r) {
		int m = (l + r) / 2;
		int sqr = m * m;
		if(sqr == num) return true;
		else if(sqr > num) r = m - 1;
		else l = m + 1;
	}
	return false;
}

int main() {
	int n;
	cin >> n;
	cout << isSquare(n);
}