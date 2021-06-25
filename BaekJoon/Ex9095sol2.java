package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex9095sol2 {
	// 11 : 34
	
	static int[] dp = new int[1000001];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 0; i < tc; i++) {
			int num = scanner.nextInt();
			System.out.println(sol(num));
		}
		
	}
	
	private static int sol(int tc) {
		if(tc == 1 || tc == 2 || tc == 3) return dp[tc];
		if(dp[tc] > 0) return dp[tc];
		
		dp[tc] = sol(tc-1) + sol(tc-2) + sol(tc-3);
		
		return dp[tc];
		
	}
}