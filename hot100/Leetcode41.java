package hot100;

// 输入：nums = [1,2,0] 1-N
// 输出：3
// 解释：范围 [1,2] 中的数字都在数组中。
// 1 -> index = 0
// i -> index = i-1
// nums[i] 当前下标为i的合法数据
// nums[i]-1 他要去的下标位置
// nums[nums[i]-1] 下标位置当前的数据 
public class Leetcode41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                // int temp = nums[i];
                // nums[i] = nums[nums[i] - 1];
                // nums[nums[i] - 1] = temp;
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
