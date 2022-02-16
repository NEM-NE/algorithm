package B2294;

import java.util.*;
import java.io.*;

public class Main2 {
    // 11:26
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] dp;
    static int[] coinAry;

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[10001];
        for(int i = 1; i < 10001; i++){
            dp[i] = Integer.MAX_VALUE - 1;
        }

        coinAry = new int[n];
        for(int i = 0; i < n; i++){
            coinAry[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        for(int i = 0; i < n; i++){
            for(int j = coinAry[i]; j <= k; j++){
                dp[j] = Math.min(dp[j], dp[j - coinAry[i]] + 1);
            }
        }

        sb.append(dp[k] == Integer.MAX_VALUE - 1 ? -1 : dp[k]);
        System.out.println(sb);

    }

}
