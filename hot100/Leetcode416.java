package hot100;

// 输入：nums = [1,5,11,5]
// 输出：true
// 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
// 是否存在一个子集 使target = sum(nums)/2
// dp[x][y] 用前x的num能凑的sum和
// dp[x][y] = dp[x-1][y] || dp[x-1][y-nums[i]]
// 
public class Leetcode416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j]; // 不选择第i个数
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]]; // 选择第i个数
                }
            }
        }
        return dp[nums.length][target];
    }
}
