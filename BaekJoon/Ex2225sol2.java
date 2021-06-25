package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2225sol2 {
	// 1 : 45
	
	static long[][] dp = new long[201][201];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int k  = scanner.nextInt();
		
		dp[0][0] = 1;
		for(int i = 0; i < 201; i++) {
			dp[0][i] = 1;
			dp[i][1] = 1;
			dp[i][2] = i+1;
		}
		
		for(int i = 1; i < n+1; i++) {
			for(int j = 3; j < k+1; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
				dp[i][j] %= 1000000000;
			}
		}
		
		System.out.println(dp[n][k]);


	}
}