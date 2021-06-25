package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex9465 {
	// 09 : 55
	
	static int[][] dp = new int[100001][2];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();

		for(int i = 0; i < tc; i++) {
			int num = scanner.nextInt();
			int[][] array = new int[num+1][2];
			
			//input
			for(int k = 0; k < 2; k++) {
				for(int j = 1; j < num+1; j++) {
					array[j][k] = scanner.nextInt();
				}
			}
			
			dp[1][0] = array[1][0];
			dp[1][1] = array[1][1];
			
			for(int j = 2; j < num+1; j++) {
				dp[j][0] = Math.max(dp[j-1][1], dp[j-2][1]) + array[j][0];
				dp[j][1] = Math.max(dp[j-1][0], dp[j-2][0]) + array[j][1];
			}
			
			System.out.println(Math.max(dp[num][0], dp[num][1]));
			
		}
		
	}
	
}