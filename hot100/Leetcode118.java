package hot100;

import java.util.ArrayList;
import java.util.List;

public class Leetcode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        res.add(arrayList);
        for (int i = 1; i < numRows; i++) {
            List<Integer> lastList = res.get(i - 1);
            int lengthNow = lastList.size() + 1;
            List<Integer> arrayListNow = new ArrayList<>(lengthNow);
            arrayListNow.add(1);
            for (int j = 1; j < lengthNow - 1; j++) {
                arrayListNow.add(lastList.get(j) + lastList.get(j - 1));
            }
            arrayListNow.add(1);
            res.add(arrayListNow);
        }
        return res;
    }
}