package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1992 {
	// 7 : 41
	
	static int[][] ary;
	static StringBuilder sb;
	
	static void partition(int xStart, int yStart, int size) {
		boolean same = true;
		for(int i = yStart; i < yStart + size; i++) {
			for(int j = xStart; j < xStart + size; j++) {
				if(ary[i][j] != ary[yStart][xStart]) same = false;
			}
		}
		
		if(!same) {
			int newSize = size/2;
			
			sb.append("(");
			partition(xStart, yStart, newSize);
			partition(xStart + newSize, yStart, newSize);
				
			partition(xStart, yStart + newSize, newSize);
			partition(xStart + newSize, yStart + newSize, newSize);
			sb.append(")");
		}else {
			if(ary[yStart][xStart] == 1) {
				sb.append(1);
			}else {
				sb.append(0);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = null;
		
		int tc = Integer.parseInt(br.readLine());
		ary = new int[tc+1][tc+1];
		
		for(int i = 1; i <= tc; i++) {
			String str = br.readLine();
			for(int j = 1; j <= tc; j++) {
				ary[i][j] = str.charAt(j-1) - '0';
			}
		}
		
		partition(1, 1, tc);
		
		System.out.println(sb);
	}
}