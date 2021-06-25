package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1780sol2 {
	// 13 : 32
	
	static int[][] ary;
	static int[] cnt;
	
	static boolean isSame(int size, int xStart, int yStart) {
		for(int i = yStart; i < yStart + size; i++) {
			for(int j = xStart; j < xStart + size; j++) {
				if(ary[yStart][xStart] != ary[i][j]) return false;
			}
		}
		return true;
	}
	
	static void partition(int size, int xStart, int yStart) {
		boolean same = isSame(size, xStart, yStart);
		
		if(!same) {
			int newSize = size/3;
			partition(newSize, xStart, yStart);
			partition(newSize, xStart + newSize, yStart);
			partition(newSize, xStart + 2 * newSize, yStart);
			
			partition(newSize, xStart, yStart + newSize);
			partition(newSize, xStart + newSize, yStart + newSize);
			partition(newSize, xStart + 2 * newSize, yStart + newSize);
			
			partition(newSize, xStart, yStart + 2 * newSize);
			partition(newSize, xStart + newSize, yStart + 2 * newSize);
			partition(newSize, xStart + 2 * newSize, yStart + 2 * newSize);
		}else {
			if(ary[yStart][xStart] == -1) cnt[0]++;
			if(ary[yStart][xStart] == 0) cnt[1]++;
			if(ary[yStart][xStart] == 1) cnt[2]++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int tc = Integer.parseInt(br.readLine());
		
		ary = new int[tc+1][tc+1];
		cnt = new int[3];
		
		// input
		for(int i = 1; i <= tc; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= tc; j++) {
				ary[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// cal
		partition(tc, 1, 1);
		
		sb.append(cnt[0]).append('\n');
		sb.append(cnt[1]).append('\n');
		sb.append(cnt[2]).append('\n');
		
		System.out.println(sb);
	}

}