package hot100;

// 输入：nums = [1,1,1,1,1], target = 3
// 输出：5
// p 1 s 总 s-p 0
// p - (s - p) = target p = (s + target) / 2
// dp[x][y] = Math.max(dp[x-1][y] , dp[x-1][y-c]+1)

public class Leetcode494 {
    public int findTargetSumWays(int[] nums, int target) {
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
        }
        target += s;
        if (target < 0 || target % 2 == 1) {
            return 0;
        }
        target = target / 2;
        int[][] dp = new int[nums.length + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            int tempnum = nums[i - 1];
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= tempnum) {
                    dp[i][j] += dp[i - 1][j - tempnum];
                }
            }
        }
        return dp[nums.length][target];
    }

}
