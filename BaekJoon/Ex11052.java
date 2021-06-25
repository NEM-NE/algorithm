package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11052 {
	// 4 : 04
	
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
			dp[i] = ary[i];
			for(int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[j] + dp[i-j], dp[i]);
			}
		}
		
		
		System.out.println(dp[tc]);
		
	}
}