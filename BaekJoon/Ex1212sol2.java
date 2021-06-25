package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1212sol2 {
	// 11 : 39
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] ary = {"000", "001", "010", "011", "100", "101", "110", "111"};
		String[] ary2 = {"1", "10", "11"};
		String input = br.readLine();
		
		if(input.equals("0")) {
			System.out.println("0");
			return;
		}
		
		for(int i = 0; i < input.length(); i++) {
			int num = input.charAt(i) - '0';
			
			if(i == 0 && num < 4) {
				sb.append(ary2[num-1]);
			}else {
				sb.append(ary[num]);
			}
		}
		
		System.out.println(sb);
		
	}
	
}