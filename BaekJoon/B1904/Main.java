package B1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 3:00
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long[] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int tc = Integer.parseInt(br.readLine());
        dp = new long[tc+1];

        dp[1] = 1;
        if(tc >= 2) dp[2] = 2;
        for(int i = 3; i <= tc; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }

        sb.append(dp[tc]);
        System.out.println(sb);
    }

}
