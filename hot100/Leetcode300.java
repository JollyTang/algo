package hot100;

// 输入：nums = [10,9,2,5,3,7,101,18]
// 输出：4
// 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

// 0 1 背包问题
// dp[x][y] 表示 到x之前的 子序列最大值为y的最大的长度。
// dp[x][y] = dp[x-1][y]
// dp[x][y] = Math.max(dp[x-1][y],dp[x-1][y-nums[x]]+1)

public class Leetcode300 {
    // public int lengthOfLIS(int[] nums) {
    // int max = -1000001;
    // for (int i = 0; i < nums.length; i++) {
    // max = Math.max(max, nums[i]);
    // }
    // int[][] dp = new int[nums.length + 1][max + 1];
    // // 到i之前的 子序列最大值为0 的 最大的长度
    // for (int i = 0; i <= nums.length; i++) {
    // dp[i][0] = -1000001;
    // }
    // // 到0之前的 子序列最大值为 max的最大长度 0
    // for (int j = 0; j <= max; j++) {
    // dp[0][j] = 0;
    // }

    // for (int i = 1; i <= nums.length; i++) {
    // int n = nums[i - 1];
    // for (int j = 0; j <= max; j++) {
    // dp[i][j] = dp[i - 1][j];
    // if (j >= n) {
    // dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - n] + 1);
    // }
    // }
    // }

    // return dp[nums.length][max];
    // }

    // dp[i] 表示到i为止的递增子序列最大值
    // dp[i] = max(dp[i],dp[i-j]+1)

    // public int lengthOfLIS(int[] nums) {
    // int n = nums.length;
    // int[] dp = new int[n];
    // for (int i = 0; i < n; i++) {
    // dp[i] = 1;
    // }
    // int ans = 1;
    // for (int i = 1; i < n; i++) {
    // int num = nums[i];
    // for (int j = i - 1; j >= 0; j--) {
    // if (num > nums[j]) {
    // dp[i] = Math.max(dp[i], dp[j] + 1);
    // }
    // }
    // ans = Math.max(ans, dp[i]);
    // }
    // return ans;
    // }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length + 1;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
        }
        int ans = 1;
        for (int i = 2; i < n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                if (nums[i - 1] > nums[j - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
