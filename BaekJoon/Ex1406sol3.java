package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1406sol3 {
	// 12 : 21
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		
		String str = br.readLine();
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < str.length(); i++) {
			left.push(str.charAt(i));
		}
		
		for(int i = 0; i < tc; i++) {
			String req = br.readLine();
			
			if(req.charAt(0) == 'P') {
				char input = req.charAt(2);
				left.push(input);
				
			}else if(req.charAt(0) == 'L') {
				if(!left.isEmpty()) {
					char input = left.pop();
					right.push(input);
				}
			}else if(req.charAt(0) == 'D') {
				if(!right.isEmpty()) {
					char input = right.pop();
					left.push(input);
				}
			}else if(req.charAt(0) == 'B') {
				if(!left.isEmpty()) left.pop();
			}
		}
		int rightS = right.size();
		for(int i = 0; i < rightS; i++) {
			left.push(right.pop());
		}
		
		int leftS = left.size();
		for(int i = 0; i < leftS; i++) {
			sb.append(left.pop());
		}
		
		sb.reverse();
		
		System.out.println(sb);

	}
	
}