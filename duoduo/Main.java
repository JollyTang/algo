package duoduo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        
        // 统计每个余数出现的次数
        long[] count = new long[m];
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            count[((num % m) + m) % m]++; // 处理负数情况
        }
        
        long res = 0;
        final long MOD = 998244353;
        
        // 处理余数为0的情况
        if (count[0] >= 2) {
            res = (res + (count[0] * (count[0] - 1) / 2)) % MOD;
        }
        
        // 处理其他余数的情况
        for (int i = 1; i <= m / 2; i++) {
            if (i == m - i) {
                // m 是偶数且 i = m/2
                if (count[i] >= 2) {
                    res = (res + (count[i] * (count[i] - 1) / 2)) % MOD;
                }
            } else {
                // 余数 i 和余数 (m-i) 配对
                res = (res + (count[i] * count[m - i])) % MOD;
            }
        }
        
        System.out.println(res);
        in.close();
    }
}