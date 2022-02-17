package B11057;

import java.util.*;
import java.io.*;

public class Main {
    // 14:45
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int tc = Integer.parseInt(br.readLine());
        dp = new long[10][tc+1];

        for(int i = 0; i < 10; i++){
            dp[i][1] = 1;
        }

        for(int i = 2; i <= tc; i++){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k <= j; k++){
                    dp[j][i] += dp[k][i-1];
                    dp[j][i] %= 10007;
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < 10; i++){
            sum += dp[i][tc];
            sum %= 10007;
        }

        sb.append(sum);
        System.out.println(sb);

    }

}
