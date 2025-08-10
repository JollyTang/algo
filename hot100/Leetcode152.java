package hot100;

// 输入: nums = [2,3,-2,4]

// 输出: 6
// 解释: 子数组 [2,3] 有最大乘积 6。
// dp[i][0] 到i为止的最大乘积 dp[i][1] 到i为止的最乘积
// dp[i][0] = max(nums[i],dp[i-1][0]*nums[i],dp[i-1][1]*nums[i])

public class Leetcode152 {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int maxProduct = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(nums[i], Math.max(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]));
            dp[i][1] = Math.min(nums[i], Math.min(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]));
            maxProduct = Math.max(maxProduct, dp[i][0]);
        }
        return maxProduct;
    }
}
