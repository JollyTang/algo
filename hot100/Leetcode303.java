package hot100;

public class Leetcode303 {
    // prefixSum[i] 的含义是 第i位之前的和。
    // prefixSum[i] = num[0] + nums[1] + ... + nums[i-1]
    int[] prefixSum;

    public Leetcode303(int[] nums) {
        prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
    }

    // 子数组的和 sumRange(left,right) = prefixSum[right+1] - prefix[left]
    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}
