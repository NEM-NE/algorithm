package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex9095sol3 {
	// 11 : 10
	
	static int[] dp = new int[11];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 0; i < tc; i++) {
			int num = scanner.nextInt();
			for(int j = 4; j < num+1; j++) {
				if(dp[j] == 0) {
					dp[j] = dp[j-1] + dp[j-2] + dp[j-3];	
				}
			}
			System.out.println(dp[num]);
		}
		
	}
	
}