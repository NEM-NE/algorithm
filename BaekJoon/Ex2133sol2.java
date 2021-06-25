package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2133sol2 {
	// 09 : 55
		static int[] dp = new int[31];
		
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		dp[0] = 1;
		dp[2] = 3;
		for(int i = 4; i < tc+1; i+=2) {
			dp[i] = dp[i-2] * 3;
			for(int j = 0; j <= i-4; j+=2) {
				dp[i] += dp[j] * 2;
			}
		}
		
		System.out.println(dp[tc]);
	}
}