package hot100;

// 输入：nums = [1,2,0] 1-N
// 输出：3
// 解释：范围 [1,2] 中的数字都在数组中。

public class Leetcode41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val > 0 && val <= nums.length && val - 1 != i) {
                swap(nums, val - 1, i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                return nums[i];
            }
        }
        return nums.length + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
