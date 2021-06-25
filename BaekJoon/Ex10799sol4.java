package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10799sol4 {
	// 11 : 08 15
	
	
	
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		Stack<Character> stack = new Stack<>();		
				
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);

			if(cur == '(') {
				stack.push('(');
				cnt++;
			}else if(cur == ')') {
				if(str.charAt(i-1) == '(') {	//laser
					cnt--;
					stack.pop();
					cnt += stack.size();
				}else {
					stack.pop();
				}
			}
			
		}
		
		sb.append(cnt);
		System.out.println(sb);
		

	}
	
}