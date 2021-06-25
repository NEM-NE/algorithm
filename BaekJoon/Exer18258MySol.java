package BaekJoon;

import java.io.*;
import java.util.*;

/*
 *  매우매우매우 야매로 푼 풀이 그냥 입출력을 개선하여 푼 경우 사실상 틀린 풀이
 */

public class Exer18258MySol {
	static Queue<Integer> que;
	static int lastVal = 0;
	
	static boolean isEmpty() {
		return que.isEmpty();
	}
	
	static void push(int n) {
		que.offer(n);
		lastVal = n;
	}
	
	static int pop() {
		return que.poll();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		que = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			if(str.contains("push")) {
				int num = Integer.parseInt(str.substring(5, str.length()));
				push(num);
			}else if(str.contains("front")) {
				if(isEmpty()) sb.append(-1 + "\n" );
				else sb.append(que.peek() + "\n" );
			}else if(str.contains("back")) {
				if(isEmpty()) sb.append(-1 + "\n" );
				else sb.append(lastVal + "\n" );
			}else if(str.contains("size")) {
				sb.append(que.size() + "\n" );
			}else if(str.contains("empty")) {
				if(!isEmpty()) sb.append(0 + "\n" );
				else sb.append(1 + "\n" );
			}else if(str.contains("pop")) {
				if(isEmpty()) sb.append(-1 + "\n" );
				else {
					int result = pop();
					sb.append(result + "\n" );	
				}
			}
		}
		
		System.out.println(sb);
		
	}
}