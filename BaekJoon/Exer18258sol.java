package BaekJoon;

import java.io.*;
import java.util.*;

public class Exer18258sol {
	static int[] queue;
	
	static int front = 0;
	static int back = 0;
	static int size = 0;
	
	static boolean isEmpty() {
		return (front == back);
	}
	
	static void push(int n) {
		//init process
		front = front % queue.length;
		back = back % queue.length;
		
		queue[back+1] = n;

		back++;
		size++;
	}
	
	static int pop() {
		//init process
		front = front % queue.length;
		back = back % queue.length;
		
		int ans = queue[front+1];
		
		front++;
		size--;
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		queue = new int[N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			if(str.contains("push")) {
				int num = Integer.parseInt(str.substring(5, str.length()));
				push(num);
			}else if(str.contains("front")) {
				if(isEmpty()) sb.append(-1 + "\n" );
				else if(front == queue.length-1) {
					sb.append(queue[0] + "\n");
				}else {
					sb.append(queue[front+1] + "\n");
				}
			}else if(str.contains("back")) {
				if(isEmpty()) sb.append(-1 + "\n" );
				else {
					sb.append(queue[back] + "\n");
				}
				
			}else if(str.contains("size")) {
				sb.append(size + "\n" );
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