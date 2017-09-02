public class Solution {
	public int arrayNesting(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int res = 0;
		for (int i = 0; i < nums.length; ++i) {
			int count = 1;
			int j = i;
			while (nums[j] != i) {
				count++;
				j = nums[j];
			}
			res = Math.max(res, count);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().arrayNesting(new int[]{5,4,0,3,1,6,2}));
	}
}