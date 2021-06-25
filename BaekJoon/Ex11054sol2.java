package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11054sol2 {
	// 10 : 20
	
	static int[][] dp = new int[1001][2];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		int[] ary = new int[tc+1];
		
		for(int i = 1; i < tc+1; i++) {
			ary[i] = scanner.nextInt();
		}
		//up
		for(int i = 1; i < tc+1; i++) {
			dp[i][0] = 1;
			for(int j = 1; j < i; j++) {
				if(ary[i] > ary[j]) {
					dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
				}
			}
		}
		
		//down
		for(int i = tc; i > 0; i--) {
			dp[i][1] = 1;
			for(int j = tc; j > i; j--) {
				if(ary[i] > ary[j]) {
					dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
				}
			}			
		}
		
		int max = 0;
		for(int i = 1; i < tc+1; i++) {
			max = Math.max(dp[i][0] + dp[i][1], max);
		}
		
		System.out.println(max-1);
	}
	
}