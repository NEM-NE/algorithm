package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex9465sol3 {
	// 3 : 08
	
	static long[][] dp = new long[100001][10];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		
		for(int i = 0; i < tc; i++) {
			int num = scanner.nextInt();
			int [][] ary = new int[num+1][2];
			
			for(int j = 1; j < num+1; j++) {
				ary[j][0] = scanner.nextInt();
			}
			for(int j = 1; j < num+1; j++) {
				ary[j][1] = scanner.nextInt();
			}
			
			dp[1][0] = ary[1][0];
			dp[1][1] = ary[1][1];
			
			for(int j = 2; j < num+1; j++) {
				dp[j][0] = Math.max(dp[j-1][1], dp[j-2][1]) + ary[j][0];
				dp[j][1] = Math.max(dp[j-1][0], dp[j-2][0]) + ary[j][1];
			}
			
			System.out.println(Math.max(dp[num][0], dp[num][1]));
		}
		
	}
}