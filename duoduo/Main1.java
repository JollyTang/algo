package duoduo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
// 51
public class Main1 {
    //3 8
    //2 2 2
    // dp[i][j] 表示 第i天背包容量为j的时候能容纳的动物的数量
    // dp[i][j] = dp[i-1][j]
    // dp[i][j] = dp[i-1][j-value] + 1
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = in.nextInt();
        }
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i<=n;i++){
            for(int j = 0;j<=m;j++){
                dp[i][j] = dp[i-1][j];
                int need = arr[i-1]*(n-i+1);
                if(j>=need){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-need]+1);
                }
            }
        }
        System.out.println(dp[n][m]);
        in.close();

    }
}
