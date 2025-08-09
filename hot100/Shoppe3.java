package hot100;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Shoppe3 {

    public int number_of_gifts(int[] gifts, int money) {
        // write code here
        if (gifts == null || gifts.length == 0) {
            return money == 0 ? 0 : -1;
        }
        
        if (money == 0) {
            return 0;
        }
        
        Arrays.sort(gifts);
        
        // 如果最小的礼物价格都大于money，直接返回-1
        if (gifts[0] > money) {
            return -1;
        }
        
        // 使用数组来传递result，确保在递归中能正确更新
        int[] result = new int[1];
        result[0] = -1;
        
        dfs(gifts, money, 0, new ArrayList<>(), 0, result);
        return result[0];
    }

    public void dfs(int[] gifts, int money, int index, List<Integer> path, int sum, int[] result) {
        if (sum > money) {
            return;
        }

        if(sum == money){
            result[0] = Math.max(result[0], path.size());
            return;
        }

        for (int i = index; i < gifts.length; i++) {
            // 剪枝：如果当前sum加上当前礼物价格已经超过money，直接跳过
            if (sum + gifts[i] > money) {
                break;
            }
            
            path.add(gifts[i]);
            sum += gifts[i];
            dfs(gifts, money, i + 1, path, sum, result);
            sum -= gifts[i];
            path.remove(path.size() - 1);
        }
    }
}
