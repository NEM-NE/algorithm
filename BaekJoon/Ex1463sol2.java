package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1463sol2 {
	// 10 : 48
	
	static int[] dp = new int[1000001];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		
		dp[1] = 0;
		
		for(int i = 2; i < tc+1; i++) {
			// case : -1
			dp[i] = dp[i-1] + 1;
			
			if(i % 3 == 0) {	//case : /3
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			}
			if(i % 2 == 0) {	//case : /2
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			}
		}
		
		System.out.println(dp[tc]);
		
	}
	
}