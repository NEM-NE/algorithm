package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10845 {
	// 5 : 19
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new LinkedList<>();
		for(int i = 0; i < tc; i++) {
			String str = br.readLine();
			
			if(str.contains("push")) {
				int num = Integer.parseInt(str.substring(5, str.length()));
				queue.add(num);
			}else if(str.contains("pop")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(queue.poll());
				}
			}else if(str.contains("size")) {
				System.out.println(queue.size());
			}else if(str.contains("empty")) {
				if(queue.isEmpty())
					System.out.println(1);
				else System.out.println(0);
			}else if(str.contains("front")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(queue.peek());
				}
			}else if(str.contains("back")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(queue.peekLast());
				}
			}
			
		}

		
	}
}