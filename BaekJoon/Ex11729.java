package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11729 {
	// 7 : 06
	
	static StringBuilder sb;
	static int cnt;
	
	static void hanoi(int size, int start, int mid, int end) {
		cnt++;
		
		if(size == 1) {
			sb.append(start + " " + end).append('\n');
			return;
		}
			
		hanoi(size-1, start, end, mid);
		sb.append(start + " " + end).append('\n');
		hanoi(size-1, mid, start, end);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		cnt = 0;
		hanoi(tc, 1, 2, 3);
		
		System.out.println(cnt);
		System.out.println(sb);
	}

}