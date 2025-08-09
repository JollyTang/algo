package hot100;

// 输入：coins = [1, 2, 5], amount = 11 最少的硬币个数

// 输出：3 
// 解释：11 = 5 + 5 + 1
// 可以重复拿 -> 完全背包问题
// dp[x][y] 仅有前x个硬币 组成 y 的最小硬币个数
// 不拿当前的x dp[x][y] = dp[x-1][y]
// 拿当前的x. dp[x][y] = Math.min(dp[x][y],dp[x-1][y-nums]+1)
// 初始化 对已知信息初始化。
public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int j = 0; j < amount + 1; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            int coin = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coin) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - coin] + 1);
                }
            }
        }
        return dp[n][amount] == Integer.MAX_VALUE ? -1 : dp[n][amount];
    }
}
