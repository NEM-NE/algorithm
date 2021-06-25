package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2225 {
	// 10 : 44
	
	static long[][] dp = new long[201][201];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		dp[0][0] = 1;
		for(int i = 1; i < 201; i++) {
			dp[0][i] = 1;
			dp[i][1] = 1;
			dp[i][2] = i+1;
		}
		
		for(int i = 3; i <= k; i++) {
			for(int j = 1; j <= n; j++) {
				for(int a = 0; a <= j; a++) {
					dp[j][i] += dp[a][i-1];
					dp[j][i] %= 1000000000;
				}
			}
		}
		
		System.out.println(dp[n][k]%1000000000);

	}
}