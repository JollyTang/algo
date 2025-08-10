package hot100;

import java.util.Arrays;

// 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]

// 输出：6
// 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// dp[i] 表示到i结尾的字数组的最大和。
// dp[i] = Math.max(nums[i],dp[i-1]+nums[i])

public class Leetcode53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return ans;
    }
}
