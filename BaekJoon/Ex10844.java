package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10844 {
	// 11 : 41
	
	static long[][] dp = new long[101][10];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		
		// 1
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i < tc + 1; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][j+1]%1000000000;
				}else if(j == 9) {
					dp[i][j] = dp[i-1][j-1]%1000000000;
				}else {
					dp[i][j] = dp[i-1][j+1]%1000000000 + dp[i-1][j-1]%1000000000;
				}
		
			}
		}
		
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			sum += dp[tc][i]%1000000000;
			sum %= 1000000000;
		}
		
		System.out.println(sum);
		
	}
	
}