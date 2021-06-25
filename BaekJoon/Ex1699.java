package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1699 {
	// 11 : 09
	
	static int[] dp = new int[100001];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		for(int i = 1; i < tc+1; i++) {
			dp[i] = i;
		}

		for(int i = 1; i < tc+1; i++) {
			if(i % 2 == 0) {
				for(int j = 1; j <= i/2; j++) {
					dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);	
				}	
			}else {
				for(int j = 1; j < i/2; j++) {
					dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);	
				}	
			}
			double num = Math.sqrt(i);
			if(num - (int) num == 0 ) {
				dp[i] = 1;
			}
			
		}
		
		System.out.println(dp[tc]);
	}
}