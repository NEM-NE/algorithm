import java.io.*;
import java.util.*;

public class Ex2225sol4 {
	// 16 : 21
	
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        dp = new int[n+1][k+1];

        for(int j = 0; j <= n; j++){    // n
            dp[j][1] = 1;
            if(k > 1) dp[j][2] = j+1;
        }

        for(int i = 1; i < k+1; i++){
            dp[0][i] = 1;
        }

        if(k > 2) {
            for(int a = 3; a < k+1; a++) {  //k
                for(int i = 1; i < n+1; i++) {  // n
                    for(int j = i; j >= 0; j--) {
                        dp[i][a] += dp[i-j][a-1];
                        dp[i][a] %= 1000000000;
                    }
                }
            }
        }

        System.out.println(dp[n][k]);
		
	}
	
}