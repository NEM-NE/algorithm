package B2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 2:45
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long[] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int tc = Integer.parseInt(br.readLine());
        dp = new long[tc+1];
        long result = solve(tc);

        sb.append(result);
        System.out.println(sb);
    }

    public static long solve(int tc){
        if(tc <= 2) {
            dp[tc] = 1;
        }
        if(dp[tc] != 0) return dp[tc];

        dp[tc] = solve(tc-1) + solve(tc-2);

        return dp[tc];
    }
}
