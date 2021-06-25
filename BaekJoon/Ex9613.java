package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex9613 {
	// 8 : 14
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> list = new ArrayList<Integer>();
			int a = Integer.parseInt(st.nextToken());
			for(int j = 0; j < a; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			long sum = 0;
			for(int j = 0; j < a; j++) {
				for(int k = 0; k < j; k++) {
					sum += gcd(list.get(j), list.get(k));
				}
			}
			
			sb.append(sum).append('\n');
		}
		
		System.out.println(sb);
		
		

	}
	
	static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a%b);
	}

}