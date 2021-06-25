package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11057sol2 {
	// 10 : 16
	
	static int[][] dp = new int[1001][10];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		//init
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 1; i < tc + 1; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 0) { 
					dp[i][j] = 1;
				}else {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
					dp[i][j] %= 10007;
				}
			}
		}
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			sum += dp[tc][i];
			sum %= 10007;
		}
		
		System.out.println(sum);
		
	}
	
}