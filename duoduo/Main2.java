package duoduo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//76
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        long m = in.nextLong();
        long[] scores = new long[n];
        int[] difficults = new int[n];
        for(int i = 0;i<n;i++){
            scores[i] = in.nextLong();
            difficults[i] = in.nextInt();
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            long sum = 0;
            int maxdifficult = -1;
            for(int j = i;j<n;j++){
                sum += scores[j];
                maxdifficult = Math.max(maxdifficult,difficults[j]);
                if(sum >= m){
                    res = Math.min(res,maxdifficult);
                    break;
                }
            }
        }
        System.out.println(res);


        // int left = 0;
        // int right = 0;
        // int sum = 0;
        // int maxdifficult = Integer.MIN_VALUE;
        // int resMaxDifficult = Integer.MAX_VALUE;
        // while(right < n){
        //     sum+=scores[right];
        //     maxdifficult = Math.max(maxdifficult,difficults[right]);
        //     right++;
        //     if(sum >= m){
        //         resMaxDifficult = Math.min(resMaxDifficult,maxdifficult);
        //         while(sum >= m){
        //             sum-=scores[left];
        //             left++;
        //         }
        //     }
        // }
        // System.out.println(resMaxDifficult);
        // in.close();

    }
}
