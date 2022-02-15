package B11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 1:50
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
        if(tc == 1) return 1;
        else if(tc == 2) return 3;
        else if(dp[tc] != 0) return dp[tc];

        dp[tc] = (solve(tc-1) + 2 * solve(tc-2)) % 10007;
        return dp[tc];
    }

}
