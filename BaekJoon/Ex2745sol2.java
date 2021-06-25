package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2745sol2 {
	// 1 0: 37
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str = st.nextToken();
		int b = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		for(int i = 0; i < str.length(); i++) {
			char input = str.charAt(i);
			if(input >= 'A' && input <= 'Z') {
				sum += (int) ((input - 'A' + 10) * Math.pow(b, str.length()-1-i));
			}else if(input >= '0' && input <= '9') {
				sum += (int) ((input - '0') * Math.pow(b, str.length()-1-i));
			}
		}
		
		sb.append(sum);
		System.out.println(sb);
	}
	

}