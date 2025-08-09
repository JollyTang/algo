package hot100;

import java.util.*;

// 输入: s = "leetcode", wordDict = ["leet", "code"]
// 输出: true
// 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// dp[i] 表示 s到i之前能否用wordDict中的单词表示
// dp[i] = dp[i-word.length] && wrod.equals(i-word.length)
// i = 4 j = 0 substring = leet
public class Leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        System.out.println(set);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                String substr = s.substring(j, i);
                if (set.contains(substr) && dp[j]) {
                    dp[i] = true;
                }
            }

        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }
}
