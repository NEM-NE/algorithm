package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2225sol3 {
	// 10 : 26
		static int[][] dp = new int[201][201];
		
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		
		for(int i = 1; i < 201; i++) {
			dp[0][i] = 1;
			dp[i][1] = 1;
			dp[i][2] = i+1;
		}
		
		for(int i = 3; i < k+1; i++) {
			for(int j = 1; j < n+1; j++) {
				dp[j][i] = dp[j-1][i] + dp[j][i-1];
				dp[j][i] %= 1000000000;
			}
		}
		
		System.out.println(dp[n][k]);
	}
}