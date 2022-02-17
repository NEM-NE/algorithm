package B10844;

import java.io.*;
import java.util.*;

public class Ex10844sol3 {
    // 12:50
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        int[][] dp = new int[tc + 1][10];
        
        for(int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        if(tc > 1){
            for(int i = 2; i <= tc; i++) {
                for(int j = 0; j < 10; j++) {
                    if(j == 0){
                        dp[i][0] = dp[i-1][1];
                        dp[i][0] %= 1000000000;
                    }else if(j == 9) {
                        dp[i][9] = dp[i-1][8];
                        dp[i][9] %= 1000000000;
                    }else {
                        dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
                        dp[i][j] %= 1000000000;
                    }
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < 10; i++){
            sum += dp[tc][i];
            sum %= 1000000000;
        }

        sb.append(sum);
        System.out.println(sb);
    }
}
