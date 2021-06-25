package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1373 {
	// 10 : 57
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		int end = (str.length()%3 == 0) ? 3 : str.length()%3;
		int start = 0;
		for(int i = 0; i < str.length(); i+=3) {
			String sub = str.substring(start, end);
			
			int input = 0;
			for(int j = 0; j < sub.length(); j++) {
				int num = sub.charAt(j) - '0';
				input += (int) (num * Math.pow(2, sub.length()-1-j));
			}
			
			sb.append(input);
			
			start = end;
			end += 3;
			
		}
		
		System.out.println(sb);
		
	}
	

}