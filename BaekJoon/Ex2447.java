package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2447 {
	// 10 : 38
	
	static String[] answer;
	
	static String pat1 = "***";
	static String pat2 = "* *";
	static String pat3 = "***";
	
	static void drawBlank(int size, int start) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				answer[start + i] += " ";
			}
		}
	}
	
	static void drawPattern(int size, int start) {
		if(size == 3) {
			answer[start] += pat1;
			answer[start + 1] += pat2;
			answer[start + 2] += pat3;
		}else {
			drawPattern(size/3, start);
			drawPattern(size/3, start);
			drawPattern(size/3, start);
			
			drawPattern(size/3, start + size/3);
			drawBlank(size/3, start + size/3);
			drawPattern(size/3, start + size/3);
			
			drawPattern(size/3, start + 2 * size/3);
			drawPattern(size/3, start + 2 * size/3);
			drawPattern(size/3, start + 2 * size/3);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int tc = Integer.parseInt(br.readLine());
		answer = new String[tc];
		
		for(int i = 0; i < tc; i++) {
			answer[i] = "";
		}
		
		if(tc > 3) {
			drawPattern(tc, 0);
			
		}else {
			sb.append(pat1).append('\n');
			sb.append(pat2).append('\n');
			sb.append(pat3).append('\n');
		}
		
		for(int i = 0; i < answer.length; i++) {
			sb.append(answer[i]).append('\n');
		}
		
		System.out.println(sb);
	}

}