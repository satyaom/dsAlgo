#include<stdio.h>
#include<vector>
#include<string>
using namespace std;

enum AlgoType {BruteForce, Optimized, TwoPointer};

// Time -> O(N^2), Space -> O(1)
int bruteForce(vector<int> &ar) {
  int maxCapacity = 0;
  for(int i = 1; i < ar.size()-1; i++) {
    int maxLeft = ar[i], maxRight = ar[i];
    for(int j = 0; j < i; j++) {
      if(maxLeft < ar[j]) maxLeft = ar[j];
    }
    for(int j = i+1; j < ar.size(); j++) {
      if(maxRight < ar[j]) maxRight = ar[j];
    }
    maxCapacity += min(maxLeft, maxRight) - ar[i];
  }
  return maxCapacity;
}

//Time -> O(N), Space -> O(1)
int twoPointer(vector<int> ar) {
  int maxCapacity = 0;
  int right = ar.size()-1, left = 0, leftMax = 0, rightMax = 0;
  while(left <= right) {
    if(leftMax <= rightMax) {
      maxCapacity += max(0, leftMax - ar[left]);
      leftMax = max(leftMax, ar[left]);
      left++;
    } else {
      maxCapacity += max(0, rightMax - ar[right]);
      rightMax = max(rightMax, ar[right]);
      right--;
    }
  }
  return maxCapacity;
}

//Time -> O(N), Space -> O(N)
int optimized(vector<int> ar) {
  int maxCapacity = 0;
  vector<int> leftMax(ar.size());
  vector<int> rightMax(ar.size());
  int maxLeft = 0, maxRight = 0;
  for(int i = 0; i < ar.size(); i++) { 
    maxLeft = max(maxLeft, ar[i]);
    leftMax[i] = max(maxLeft, ar[i]);
  }
  for(int i = ar.size()-1; i > 0; i--) {
    maxRight = max(maxRight, ar[i]);
    rightMax[i] = maxRight;
  }
  for(int i = 1; i < ar.size()-1; i++) {
    maxCapacity += min(leftMax[i], rightMax[i]) - ar[i];
  }
  return maxCapacity;
}

int getRainWaterCapacity(vector<int> &vr, AlgoType type) {
  switch(type) {
    case BruteForce:
      return bruteForce(vr);
      break;
    case Optimized:
      return optimized(vr);
      break;
    case TwoPointer:
      return twoPointer(vr);
      break;
  }
}

int main() {
  vector<int> vr{3, 0, 2, 0, 4};
  printf("%d", getRainWaterCapacity(vr, TwoPointer));
  return 0;
}
