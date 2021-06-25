package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1934 {
	// 7 : 47
	
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int gcd = GCD(a, b);
			int ans = (a*b) / gcd;
			
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}

	static int GCD(int a, int b) {
		if(b == 0) return a;
		return GCD(b, a%b);
	}
}