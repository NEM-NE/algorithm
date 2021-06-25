package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1406sol4 {
	// 1 0: 12
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int tc = Integer.parseInt(br.readLine());
		
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();

		for(int i = 0; i < str.length(); i++) {
			left.push(str.charAt(i));
		}
		
		for(int i = 0; i < tc; i++) {
			String dir = br.readLine();
			
			if(dir.charAt(0) == 'P') {
				char input = dir.charAt(2);
				left.add(input);
			}else if(dir.charAt(0) == 'L') {
				if(!left.isEmpty()) {
					char input = left.pop();
					right.add(input);
				}
			}else if(dir.charAt(0) == 'D') {
				if(!right.isEmpty()) {
					char input = right.pop();
					left.add(input);
				}
			}else if(dir.charAt(0) == 'B') {
				if(!left.isEmpty())left.pop();
			}
		}
		
		int size = left.size();
		for(int i = 0; i < size; i++) {
			char input = left.pop();
			right.add(input);
		}
		
		size = right.size();
		for(int i = 0; i < size; i++) {
			sb.append(right.pop());
		}
		
		System.out.println(sb);
		
	}
	

}