// Array is sorted and rotated, we need to find minimum 

import java.util.*;

class MinElementRotatedArray {
	public static int findMin(int[] nums) {
		int i = 0, j = nums.length-1;
		while(nums[i] > nums[j]) {
			int mid = i + (j - i)/2;
			if(nums[mid] > nums[mid + 1]) return nums[mid+1];
			else if(nums[mid] < nums[mid - 1]) return nums[mid];
			else if(nums[mid] < nums[i]) i = mid+1;
			else if(nums[mid] > nums[j]) j = mid-1;
		}
		return nums[0];
	}

	public static void main(String[] args) {
		int[] ar = {3,4,5,0,1,2};
		System.out.println(findMin(ar));
	}
}