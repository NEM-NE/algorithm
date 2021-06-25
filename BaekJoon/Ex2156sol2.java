package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2156sol2 {
	// 10 : 25
	
	static int[] dp = new int[10001];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		int[] array = new int[tc+1];
		
		for(int i = 1; i < tc+1; i++) {
			array[i] = scanner.nextInt();
		}
		
		dp[1] = array[1];
		if(tc > 1) dp[2] = array[1] + array[2];
		
		for(int i = 3; i < tc+1; i++) {
			dp[i] = Math.max(array[i-1] + dp[i-3], dp[i-2]);
			dp[i] += array[i];
			dp[i] = Math.max(dp[i-1], dp[i]);
		}
		
		int max = 0;
		for(int i = 1; i < tc+1; i++) {
			if(max < dp[i]) max = dp[i];
		}
		
		System.out.println(max);
	}
	
}