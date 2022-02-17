package B10844;

import java.util.*;
import java.io.*;

public class Main {
    // 14:25
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int tc = Integer.parseInt(br.readLine());
        dp = new long[10][tc+1];

        for(int i = 1; i < 10; i++){
            dp[i][1] = 1;
        }

        for(int i = 2; i <= tc; i++){
            for(int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[j][i] = dp[j + 1][i - 1];
                } else if (j == 9) {
                    dp[j][i] = dp[j - 1][i - 1];
                } else {
                    dp[j][i] = dp[j - 1][i - 1] + dp[j + 1][i - 1];
                }

                dp[j][i] %= 1000000000;
            }
        }

        int sum = 0;
        for(int i = 0; i < 10; i++){
            sum += dp[i][tc];
            sum %= 1000000000;
        }

        sb.append(sum);
        System.out.println(sb);
    }

}
