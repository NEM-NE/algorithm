package 정수삼각형;

public class Solution {
    static int[][] dp = new int[501][501];
    public int solution(int[][] triangle) {
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < triangle.length; i++){
            int length = triangle[i].length;

            for(int j = 0; j < i; j++){
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + triangle[i][j]);
                dp[i][j+1] = Math.max(dp[i][j+1], dp[i-1][j] + triangle[i][j+1]);
            }
        }

        int max = 0;
        for(int i = 0; i < triangle[triangle.length-1].length; i++){
            max = Math.max(max, dp[triangle.length-1][i]);
        }

        return max;
    }
}
