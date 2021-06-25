package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1158sol2 {
	// 7 : 34
	
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> que = new LinkedList<>();

		for(int i = 1; i <= n; i++) {
			que.add(i);
		}
		
		int index = 0;
		sb.append('<');
		for(int i = 0; i < n-1; i++) {
			index += k-1;
			if(index >= que.size()) index %= que.size();

			sb.append(que.remove(index)).append(", ");
			
		}
		
		sb.append(que.remove(que.size()-1)).append(">");
		
		System.out.println(sb);
		
	}
}