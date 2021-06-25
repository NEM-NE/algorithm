package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1373sol3 {
	// 11 : 27
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		int index = str.length();
		while(index != 0) {
			String input = "";
			
			if(index == 2) { // 2 letter
				input = str.substring(index - 2, index);
				index -= 2;
			}else if(index == 1) { // 1 letter
				input = str.substring(index - 1, index);
				index -= 1;
			}else {
				input = str.substring(index - 3, index);
				index -= 3;
			}

			int sum = 0;
			for(int i = 0; i < input.length(); i++) {
				int num = input.charAt(i) - '0';
				sum += num * Math.pow(2, input.length()-1-i);
			}
			sb.append(sum);
		}
		
		sb.reverse();
		System.out.println(sb);
		
		
	}
	
}