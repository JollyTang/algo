package hot100;

import java.util.Arrays;

public class Shoppe2 {
    public int horseRace(int[] tj, int[] qw) {
        // write code here
        Arrays.sort(tj);
        Arrays.sort(qw);
        int res = 0;
        for(int i = 0;i<tj.length;i++){
            if(tj[i] > qw[i]){
                res += 200;
            }
        }
        return res;
    }
}
