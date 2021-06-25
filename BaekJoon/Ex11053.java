package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11053 {
	// 10 : 47
	
	static int[] dp = new int[1001];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		int[] array = new int[tc+1];
		
		for(int i = 1; i < tc+1; i++) {
			array[i] = scanner.nextInt();
		}
		
		for(int i = 1; i < tc+1; i++) {
			dp[i] = 1;
			for(int j = 1; j < i; j++) {
				if(array[j] < array[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		int max = 0;
		for(int i = 1; i < tc+1; i++) {
			if(max < dp[i]) max = dp[i];
		}
		
		System.out.println(max);
		
	}
	
}