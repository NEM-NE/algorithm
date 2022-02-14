package B1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 2:25
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int tc = Integer.parseInt(br.readLine());
        dp = new int[tc+1];

        int result = solve(tc);
        sb.append(result);
        System.out.println(sb);
    }

    public static int solve(int tc){
        if(tc <= 1) return 0;
        if(dp[tc] != 0) return dp[tc];

        int value = Integer.MAX_VALUE;

        if(tc%3 == 0) {
            value = Math.min(value, solve(tc/3) + 1);
        }

        if(tc%2 == 0){
            value = Math.min(value, solve(tc/2) + 1);
        }

        value = Math.min(value, solve(tc-1) + 1);

        dp[tc] = value;

        return value;
    }
}
