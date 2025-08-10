package hot100;

// 输入：s = "(()"
// 输出：2
// 解释：最长有效括号子串是 "()"
// dp[i] 表示 到i为止的合法子串长度
// dp[i] = 2 + dp[i-1] + dp[i-dp[i-1]-2]
public class Leetcode32 {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == ')') {
                char lastchar = s.charAt(i - 1);
                if (lastchar == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else {
                    int j = i - dp[i - 1] - 1;
                    if (j >= 0 && s.charAt(j) == '(') {
                        dp[i] = dp[i - 1] + (j >= 1 ? dp[j - 1] : 0) + 2;
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
