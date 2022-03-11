package 등굣길;

public class Solution {
    static long[][] dp;

    public int solution(int m, int n, int[][] puddles) {
        dp = new long[n+1][m+1];
        // visited= new boolean[n+1][m+1];

        for(int i = 0; i < puddles.length; i++){
            int x = puddles[i][0];
            int y = puddles[i][1];

            dp[y][x] = -1;
        }

        dp[1][1] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(i == 1 && j == 1) continue;
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][j] %= 1000000007;
            }
        }

        return (int)dp[n][m];
    }

}
