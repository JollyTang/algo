package hot100;

import java.util.Arrays;
import java.util.HashSet;

public class Leetcode76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] map_s = new int[128];
        int[] map_t = new int[128];

    }

    // 新增：判断当前窗口是否已满足 t 的要求
    private boolean isCover(int[] need, int[] window) {
        for (int i = 0; i < 128; i++) {
            if (window[i] < need[i])
                return false;
        }
        return true;
    }
}
