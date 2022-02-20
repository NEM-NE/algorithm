package B11051;

import java.io.*;
import java.util.*;

public class Main {
    // 14:05
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new long[1001][1001];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i) dp[i][j] = 1;
                if(j == i-1 || j == 1) dp[i][j] = i;
            }
        }

        for(int i = 3; i <= n; i++){
            for(int j = 2; j <= i; j++){
                dp[i][j] = dp[i-1][j-1];
                if(i-1 >= j){
                    dp[i][j] += dp[i-1][j];
                }

                dp[i][j] %= 10007;
            }
        }

        sb.append(dp[n][k]);
        System.out.println(sb);
    }

}