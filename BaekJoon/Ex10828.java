package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10828 {
	// 2 : 16
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < tc; i++) {
			String str = br.readLine();
			
			if(str.contains("push")) {
				int num = Integer.parseInt(str.substring(5, str.length()));
				stack.push(num);
			}else if(str.contains("pop")) {
				if(stack.size() == 0) {
					System.out.println(-1);
				}else {
					System.out.println(stack.pop());
				}
				
			}else if(str.contains("size")) {
				System.out.println(stack.size());
			}else if(str.contains("empty")) {
				if(stack.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}else if(str.contains("top")) {
				if(stack.size() == 0) {
					System.out.println(-1);
				}else {
					System.out.println(stack.peek());
				}
			}
		}

		
	}
}