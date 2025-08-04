package hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) { // [1,-1] 1
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] num1, int[] num2) {
                return num2[1] - num1[1];
            }
        });
        for (int i = 0; i < k; i++) {
            priorityQueue.add(new int[] { i, nums[i] });
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = priorityQueue.peek()[1];
        for (int i = k; i < nums.length; i++) {
            priorityQueue.add(new int[] { i, nums[i] });
            while (priorityQueue.peek()[0] < i - k + 1) { // 左边界 是 i-k+1
                priorityQueue.poll();
            }
            res[i - k + 1] = priorityQueue.peek()[1];
        }
        return res;
    }
}
