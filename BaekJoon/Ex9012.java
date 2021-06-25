package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex9012 {
	// 2 : 31
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < tc; i++) {
			Stack<Boolean> stack = new Stack<>();
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == '(') {
					stack.push(true);
				}else if(str.charAt(j) == ')') {
					if(stack.isEmpty()){
						stack.push(false);
						break;
					}
					stack.pop();
				}
			}
			
			if(stack.isEmpty()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
		
	}
}