package hot100;

import java.util.HashSet;
import java.util.Set;

// "shopeegarena",["shopee","garena","seamoney"]
// true

public class Shoppe1 {
    public boolean wordConcate(String word, String[] word_dict) {
        // write code here
        if (word == null || word.length() == 0) {
            return true;
        }
        
        if (word_dict == null || word_dict.length == 0) {
            return false;
        }
        
        // 将word_dict转换为Set，提高查找效率
        Set<String> dict = new HashSet<>();
        for (String w : word_dict) {
            dict.add(w);
        }
        
        int n = word.length();
        // dp[i][j] 表示word的子串[i,j]是否可以由字典中的单词拼接而成
        boolean[][] dp = new boolean[n][n];
        
        // 初始化：单个字符的情况
        for (int i = 0; i < n; i++) {
            String singleChar = word.substring(i, i + 1);
            dp[i][i] = dict.contains(singleChar);
        }
        
        // 填充dp表
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                
                // 检查整个子串是否在字典中
                String substr = word.substring(i, j + 1);
                if (dict.contains(substr)) {
                    dp[i][j] = true;
                    continue;
                }
                
                // 尝试所有可能的分割点
                for (int k = i; k < j; k++) {
                    if (dp[i][k] && dp[k + 1][j]) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }
        
        return dp[0][n - 1];
    }
}
