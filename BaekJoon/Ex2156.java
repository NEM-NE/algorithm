package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2156 {
	// 10 : 04
	
	static long[] dp = new long[10001];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		int data[] = new int [tc+1];
		//input
		for(int i = 1; i < tc+1; i++) {
			data[i] = scanner.nextInt();
		}
		
		dp[1] = data[1];
		dp[2] = data[1] + data[2];
		dp[3] = Math.max(data[1] + data[2], data[3] + data[2]);
		for(int i = 4; i < tc+1; i++) {
			dp[i] = Math.max(dp[i-4] + data[i-2], dp[i-3] + data[i-1]) + data[i];
			dp[i] = Math.max(dp[i], dp[i-1]);
		}
		
		System.out.println(dp[tc]);
		
	}
	
}