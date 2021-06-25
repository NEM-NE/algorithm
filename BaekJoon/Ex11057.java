package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11057 {
	// 10 : 12
	
	static long[][] dp = new long[1001][11];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		
		for(int i = 0; i < 10; i++ ) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i < tc + 1; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 0) {
					dp[i][0] = 1; 
				}else if(j == 9) {
					for(int k = 0; k < 10; k++) {
						dp[i][9] += dp[i-1][k];
						dp[i][9] %= 10007;
					}
				}else {
					for(int k = 0; k < j + 1; k++) {
						dp[i][j] += dp[i-1][k]; 
						dp[i][j] %= 10007;
					}
				}
			}
		}
		
		
		long sum = 0;
		
		for(int i = 0; i < 10; i++) {
			sum += dp[tc][i];
			sum %= 10007;
		}
		
		System.out.println(sum);
		
	}
	
}