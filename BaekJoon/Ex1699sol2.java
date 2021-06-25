package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1699sol2 {
	// 10: 14
	
	static int[] dp = new int[100001];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		for(int i = 4; i < tc+1; i++) {
			dp[i] = i;
			for(int j = 1; j*j <= i; j++) {
				if(j*j == i) {
					dp[i] = 1;
				}else {
					dp[i] = Math.min(dp[i], dp[j*j] + dp[i-j*j]);
				}
			}
		}
		
		System.out.println(dp[tc]);
		
	}
}