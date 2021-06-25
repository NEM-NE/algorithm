package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1912sol1 {
	// 10 : 12
	
	static int[] dp = new int[100001];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		int[] ary = new int[tc+1];
		
		for(int i = 1; i < tc+1; i++) {
			ary[i] = scanner.nextInt();
		}
		
		dp[1] = ary[1];
		
		for(int i = 2; i < tc+1; i++) {
			dp[i] = Math.max(dp[i-1] + ary[i], ary[i]);
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < tc+1; i++) {
			if(max < dp[i]) max = dp[i];
		}
		
		System.out.println(max);
		
	}
}