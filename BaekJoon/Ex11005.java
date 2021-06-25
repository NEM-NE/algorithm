package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11005 {
	// 1 0: 22
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		while(n > 0) {
			int num = n%b;
			if(num >= 10) {
				sb.append((char)('7' + num));
			}else {
				sb.append((char)('0' + num));
			}
			n /= b;
		}
		
		sb.reverse();
		
		System.out.println(sb);
		
	}
	

}