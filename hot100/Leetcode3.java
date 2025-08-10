package hot100;

import java.util.*;

// 输入: s = "abcabcbb"
// 输出: 3 
// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            Character charAt = s.charAt(right);
            map.put(charAt, map.getOrDefault(charAt, 0) + 1);
            right++;
            while (map.get(charAt) > 1) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, right - left);

        }
        return res;
    }
}
