package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2448 {
	// 2 : 01
	
	static char[][] ary;
	static StringBuilder sb;
	
	static void drawPattern(int size, int xStart, int yStart) {
		ary[yStart][xStart] = '*';
		
		ary[yStart+1][xStart-1] = '*';
		ary[yStart+1][xStart] = ' ';
		ary[yStart+1][xStart+1] = '*';
		
		ary[yStart+2][xStart-2] = '*';
		ary[yStart+2][xStart-1] = '*';
		ary[yStart+2][xStart] = '*';
		ary[yStart+2][xStart+1] = '*';
		ary[yStart+2][xStart+2] = '*';
	}
	
	static void partition(int size, int xStart, int yStart) {
		if(size == 3) {
			drawPattern(size, xStart, yStart);
			return;
		}
		
		partition(size/2, xStart, yStart);
		partition(size/2, xStart - size/2, yStart + size/2);
		partition(size/2, xStart + size/2, yStart + size/2);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = null;
		
		int tc = Integer.parseInt(br.readLine());
		ary = new char[tc+1][2*tc + 1];
		
		for(int i = 0; i <= tc; i++) {
			for(int j = 0; j <= 2*tc; j++) {
				ary[i][j] = ' ';
			}
		}
		
		partition(tc, tc, 1);
		
		for(int i = 1; i <= tc; i++) {
			for(int j = 1; j <= 2*tc; j++) {
				sb.append(ary[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		
	}

}