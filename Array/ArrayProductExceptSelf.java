import java.util.*;
class ArrayProductExceptSelf {
	public static int[] productExceptSelf(int[] nums) {
       int[] prefix = new int[nums.length];
       int[] suffix = new int[nums.length];
       int[] result = new int[nums.length];
       int prefixProduct = 1, suffixProduct = 1;
       for(int index = 0; index < nums.length; index++) {
            prefixProduct *= nums[index];
            prefix[index] = prefixProduct;

            suffixProduct *= nums[nums.length - 1 - index];
            suffix[nums.length - 1 - index] = suffixProduct;
       }
       result[0] = suffix[1];
       result[nums.length - 1] = prefix[nums.length - 2];

       for(int index = 1; index < nums.length - 1; index++) {
            result[index] = prefix[index - 1] * suffix[index + 1];
       }

       return result;
    }

    public static void main(String[] args) {
		int[] ar = {1,2,3,4};
		System.out.println(
			Arrays.stream(productExceptSelf(ar)).boxed().toList()
		);
	}
}