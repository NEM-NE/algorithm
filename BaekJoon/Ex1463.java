package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1463 {
	// 10 : 44
	
	static int[] dp;
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		
		dp = new int[tc+1];
		dp[1] = 0;
		
		for(int i = 2; i < tc+1; i++) {
			// case : +1
			dp[i] = dp[i-1] + 1;
			// case : %3
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i/3] + 1, dp[i]);
			}
			// case : %2
			if(i % 2 == 0) {	
				dp[i] = Math.min(dp[i/2] + 1, dp[i]);
			}
		}
		
		System.out.println(dp[tc]);
		
	}
}
