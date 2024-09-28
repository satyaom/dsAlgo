#include <bits/stdc++.h>
using namespace std;

void printArray(vector<int> arr) {
	for(auto i: arr) {
		cout<<i<<" ";
	}
	cout<<endl;
}

void findMissingNumber(vector<int> numbers) {
	int n = numbers.size();
	int sum = n*(n+1)/2;
	int missing;
	int repeating;
	for(int i = 0; i < n; i++) {
		if(numbers[abs(numbers[i]) - 1] > 0) {
			numbers[abs(numbers[i]) - 1] = -1 * numbers[abs(numbers[i]) - 1];
			sum = sum - numbers[i];
		} else {
			repeating = abs(numbers[i]);
		}
	}
	cout<<"Missing: "<<missing<<endl<<"Repeating: "<<repeating;
}

int main()
{
    vector<int> arr = { 7, 3, 4, 5, 5, 6, 2 };
    findMissingNumber(arr);
}
