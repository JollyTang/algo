package hot100;

import java.util.*;

public class Leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<int[]> p = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] temp = new int[2];
            temp[0] = entry.getKey();
            temp[1] = entry.getValue();
            p.add(temp);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = p.poll()[0];
        }
        return ans;
    }
}
