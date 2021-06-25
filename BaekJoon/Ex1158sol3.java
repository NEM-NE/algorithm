package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1158sol3 {
	// 12 : 44
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> que = new LinkedList<Integer>();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		for(int i = 1; i <= n; i++) {
			que.add(i);
		}
		
		int index = 0;
		sb.append('<');
		for(int i = 0; i < n-1; i++) {
			if(index >= que.size()) {
				index %= que.size();
			}
			for(int j = 0; j < k-1; j++) {
				int num = que.pollFirst();
				que.add(num);
			}
			
			sb.append(que.pollFirst()).append(", ");
			
			index++;
		}
		
		sb.append(que.pollLast()).append('>');
		
		System.out.println(sb);
	}
	
}