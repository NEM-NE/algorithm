package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex9461 {
	// 2 : 51
	
	static long[] dp = new long[100001];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		
		for(int i = 0; i < tc; i++) {
			int num = scanner.nextInt();
			dp[1] = 1;
			dp[2] = 1;
			for(int j = 3; j < num+1; j++) {
				dp[j] = dp[j-2] + dp[j-3];
			}
			System.out.println(dp[num]);
		}

	}
}