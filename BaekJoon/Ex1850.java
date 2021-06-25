package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1850 {
	// 8 : 09
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		long num = gcd(a, b);
		
		for(int i = 0; i < num; i++) {
			sb.append(1);
		}
		
		System.out.println(sb);
	}
	
	static long gcd(long a, long b) {
		if(b == 0) return a;
		return gcd(b, a%b);
	}

}