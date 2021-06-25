package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10799sol3 {
	// 6 : 53 
	
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		int cnt = 1;
		stack.add('(');
		
		for(int i = 1; i < str.length(); i++) {
			char cur = str.charAt(i);
			char pre = str.charAt(i-1);
			
			if(cur == '(') {
				stack.add(cur);
				cnt++;
			}else if(cur == ')') {
				if(pre == '(') {	//laser
					stack.pop();
					cnt--;
					cnt += stack.size();
				}else {
					// close
					stack.pop();
				}
			}
		}
		
		sb.append(cnt);
		
		System.out.println(sb);
		
		
	}
}