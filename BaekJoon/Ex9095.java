package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex9095 {
	// 11 : 50
	
	static long[] dp = new long[11];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for(int i = 4; i < dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		for(int i = 0; i < tc; i++) {
			int num = scanner.nextInt();
			System.out.println(dp[num]);
			
		}
		
	}
}