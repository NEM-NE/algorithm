package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10844sol2 {
	// 11 : 35
	
	static int[][] dp = new int[101][10];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i < tc+1; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][j+1]; 
					dp[i][j] %= 1000000000;
				}else if(j == 9) {
					dp[i][j] = dp[i-1][j-1]; 
					dp[i][j] %= 1000000000;
				}else {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]; 
					dp[i][j] %= 1000000000;
				}
			}
		}
		
		long sum = 0;
		for(int i = 0; i < 10; i++) {
			sum += dp[tc][i];
			sum %= 1000000000;
		}
		
		System.out.println(sum);
		
	}
	
}