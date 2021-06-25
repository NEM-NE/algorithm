package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2745 {
	// 11 : 20
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		String str = st.nextToken();
		int b = Integer.parseInt(st.nextToken());

		int sum = 0;
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch >= 'A' && ch <= 'Z') {
				int num = (ch - 'A' + 10);
				sum += num * Math.pow(b, str.length()-1-i);
			}else if(ch >= '0' && ch <= '9') {
				int num = (ch - '0');
				sum += num * Math.pow(b, str.length()-1-i);
			}
		}
		
		sb.append(sum);
		System.out.println(sb);
		
		
	}
	

}