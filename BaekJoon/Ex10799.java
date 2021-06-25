package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10799 {
	// 2 : 46
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int tc = str.length();
		
		Stack<Character> stack = new Stack<>();
		char cur = str.charAt(0);
		if(cur == ')') {
			System.out.println(0);
			System.exit(0);
		}
		
		char pre;
		int cnt = 1;
		stack.add(cur);
		
		for(int i = 1; i < tc; i++) {
			cur = str.charAt(i);
			pre = str.charAt(i-1);
			
			stack.add(cur);
			
			if(cur == ')' && pre == '(') {	//laser
				stack.pop();
				stack.pop();
				cnt += stack.size();
				cnt--;
			}else if(cur == '('){
				cnt++;
			}else if(cur == ')') {
				stack.pop();
				stack.pop();
			}
		}
		
		sb.append(cnt);
		System.out.println(sb);

		
	}
}