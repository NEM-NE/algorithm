package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2133 {
	// 1 : 10
	
	static int[] dp = new int[31];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		dp[2] = 3;
		
		for(int i = 4; i < tc+1; i+=2) {
			dp[i] = dp[i-2] * 3;
			for(int j = 4; j <= i; j+=2) {
				if(j == i) {
					dp[i] += 2;
				}else {
					dp[i] += dp[i-j] * 2;
				}
				
			}
			
		}
		
		System.out.println(dp[tc]);

	}
}