package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11727sol2 {
	// 11 : 24
	
	static int[] dp = new int[1000001];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		dp[1] = 1;
		dp[2] = 3;
		System.out.println(sol(tc));
		
	}
	
	private static int sol(int tc) {
		if(tc == 1 || tc == 2) return dp[tc];
		if(dp[tc] > 0) return dp[tc];
		
		dp[tc] = (sol(tc-1)%10007) + 2 * (sol(tc-2)%10007);
		dp[tc] %= 10007;
		
		return dp[tc];
		
	}
}