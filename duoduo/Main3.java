package duoduo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//10
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int m = in.nextInt();
        int[] beautify = new int[n];
        for(int i = 0 ;i<n;i++){
            beautify[i] = in.nextInt();
        }
        int res = 0;
        for(int i = 0;i<n;i++){
            int sum = 0;
            for(int j = i;j<n;j++){
                sum += beautify[j];
                if(sum == m){
                    res++;
                }
            }
        }
        System.out.println(res);

    }
}
