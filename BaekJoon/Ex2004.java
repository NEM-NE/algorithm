package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2004 {
	// 10 : 55	
	
	static int getFiveNum(int x) {
		int num = x;
		int cnt = 0;
		while(num > 0) {
			cnt += num/5;
			num /= 5;
		}
		
		return cnt;
	}
	
	static int getTwoNum(int x) {
		int num = x;
		int cnt = 0;
		while(num > 0) {
			cnt += num/2;
			num /= 2;
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int five = getFiveNum(n) - getFiveNum(m) - getFiveNum(n-m);
		int two = getTwoNum(n) - getTwoNum(m) - getTwoNum(n-m); 
		int ans = Math.min(five, two);
		
		sb.append(ans);
		System.out.println(sb);
	}
	
}