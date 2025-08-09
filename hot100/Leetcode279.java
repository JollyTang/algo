package hot100;

import java.util.*;

// 1 4 9 
// 输入：n = 12
// 输出：3 
// 解释：12 = 4 + 4 + 4
// dp[x][y] 用前x个完全平方数 满足和为 y的 最小个数 min
// 不选当前的x dp[x][y] = dp[x-1][y]
// 选当前的x   dp[x][y] = Math.min(dp[x][y],dp[x-1][y-num]+1)

public class Leetcode279 {
    public int numSquares(int n) {
        int m = (int) Math.sqrt(n) + 1;
        int[][] dp = new int[m + 1][n + 1];

        // 初始化：和为 0 需要 0 个数
        for (int i = 0; i <= m; i++)
            dp[i][0] = 0;
        for (int j = 1; j <= n; j++)
            dp[0][j] = Integer.MAX_VALUE; // 0 个数无法凑出正和
        for (int i = 1; i <= m; i++) {
            int num = i * i;
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j]; // 一个都不选
                if (j >= num) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - num] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
