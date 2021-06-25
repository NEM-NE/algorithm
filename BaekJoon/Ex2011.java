package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2011 {
	// 10 : 43
		static int[] dp = new int[5001];
		
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int[] ary = new int[str.length()+1];
		
		for(int i = 1; i < ary.length; i++) {
			ary[i] = str.charAt(i-1) - '0';
		}
		
		if(ary[1] == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		dp[0] = dp[1] = 1;
		
		for(int i = 2; i < ary.length; i++) {
			int pre = ary[i-1];
			int cur = ary[i];
			int num = 10*pre + cur;
			
			if(cur == 0) {
				if(num == 10 || num == 20) {
					dp[i] = dp[i-2];
				}
			}else {
				if(num > 10 && num < 27) {
					dp[i] = dp[i-1] + dp[i-2];
				}else {
					dp[i] = dp[i-1];
				}
			}
			
			dp[i] %= 1000000;
		}
		sb.append(dp[ary.length-1]);
		System.out.println(sb);



		
	}
}