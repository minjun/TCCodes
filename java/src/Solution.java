public class Solution {
	public boolean canPartition(int[] nums) {
		int sum = 0;

		for (int num : nums) {
			sum += num;
		}

		if ((sum & 1) == 1) {
			return false;
		}
		sum /= 2;

		int n = nums.length;
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;

		for (int i = 1; i < n; ++i) {
			for (int j = sum; j >= 0; --j) {
				if (j >= nums[i]) {
					System.out.println(String.format("%d-%b:%d-%b-%d",j,dp[j],j-nums[i],dp[j-nums[i]],nums[i]));
					dp[j] = dp[j] || dp[j - nums[i]];
				}
			}
		}

		return dp[sum];
	}
	public static void main(String[] args) {
		new Solution().canPartition(new int[]{1, 5, 11, 5});
	}
}