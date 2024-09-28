#include<stdio.h>
using namespace std;

int maxSubArraySum(int ar[], int n) {
  int maxTillNow = 0, maxNow = 0;
  for(int i = 0; i < n; i++) {
    maxNow = maxNow+ar[i];
    if(maxTillNow < maxNow) maxTillNow = maxNow;

    //to intiate again max to 0 for subarray
    if(maxNow < 0) maxNow = 0;
  }
  return maxTillNow;
}

int main() {
  int arr[] = {3, 2, -3, 2, 3};
  printf("%d", maxSubArraySum(arr, 5));
  return 0;
}