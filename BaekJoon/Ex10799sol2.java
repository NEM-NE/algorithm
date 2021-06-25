package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10799sol2 {
	// 10 : 10
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String que =br.readLine();
		Stack<Character> stack = new Stack<>();
		
		char cur;
		char pre = '1';
		int cnt = 0;
		for(int i = 0; i < que.length(); i++) {
			cur = que.charAt(i);
			if(i > 0 ) pre = que.charAt(i-1);
			
			if(pre == '(' && cur == ')') {
				if(stack.size() > 0) stack.pop();
				cnt--;
				cnt += stack.size();
			}else if(cur == '(') {
				stack.push('(');
				cnt++;
	
			}else if(cur == ')') {
				stack.pop();
			}
		}

		sb.append(cnt);
		
		System.out.println(sb);
	}
}